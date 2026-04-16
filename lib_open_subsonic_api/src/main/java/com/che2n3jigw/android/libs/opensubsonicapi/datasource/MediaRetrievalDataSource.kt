/*
 * Copyright (c) 2026 che2n3jigw.
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/MIT
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */

// 作者: che2n3jigw
// 邮箱: che2n3jigw@163.com
// 博客: che2n3jigw.github.io
// 创建时间： 12/31/25
package com.che2n3jigw.android.libs.opensubsonicapi.datasource

import com.che2n3jigw.android.libs.net.bean.RequestResult
import com.che2n3jigw.android.libs.net.utils.RequestUtils
import com.che2n3jigw.android.libs.opensubsonicapi.bean.AuthInfo
import com.che2n3jigw.android.libs.opensubsonicapi.response.retrieval.Lyrics
import com.che2n3jigw.android.libs.opensubsonicapi.response.retrieval.StructuredLyric
import com.che2n3jigw.android.libs.opensubsonicapi.service.MediaRetrievalService
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull

class MediaRetrievalDataSource(
    baseUrl: String,
    authInfo: AuthInfo,
    enableLogging: Boolean = true
) : BaseDataSource(baseUrl, authInfo, enableLogging) {

    private val service: MediaRetrievalService = service()

    /**
     * 获取下载地址
     * @param id 媒体文件的ID,通过getMusicDirectory获取
     */
    fun getDownloadUrl(id: String): String {
        val urlBuilder = "$baseUrl/rest/download".toHttpUrlOrNull()?.newBuilder() ?: return ""
        return urlBuilder.apply {
            addBaseQueryParameters(this)
            addQueryParameter("id", id)
        }.build().toString()
    }

    /**
     * 获取头像地址
     */
    fun getAvatarUrl(username: String): String {
        val urlBuilder = "$baseUrl/rest/getAvatar".toHttpUrlOrNull()?.newBuilder() ?: return ""
        return urlBuilder.apply {
            addBaseQueryParameters(this)
            addQueryParameter("username", username)
        }.build().toString()
    }

    /**
     * 获取封面 URL (不发起网络请求)
     * 直接返回带认证参数的字符串，可直接交给 Coil/Glide 使用
     *
     * @param id 封面 ID
     * @param size 图片尺寸 (可选)
     */
    fun getCoverArtUrl(id: String, size: Long? = null): String {
        val urlBuilder = "$baseUrl/rest/getCoverArt".toHttpUrlOrNull()?.newBuilder() ?: return ""
        return urlBuilder.apply {
            addBaseQueryParameters(this)
            addQueryParameter("id", id)
            size?.let { addQueryParameter("size", it.toString()) }
        }.build().toString()
    }

    /**
     * 获取歌词
     */
    suspend fun getLyrics(artist: String? = null, title: String? = null): Lyrics? {
        val result = RequestUtils.safeApiCall { service.getLyrics(artist, title) }
        return when (result) {
            is RequestResult.Success -> result.data.response?.lyrics
            is RequestResult.Error -> null
        }
    }

    /**
     * 获取歌词通过歌曲di
     */
    suspend fun getLyricsBySongId(id: String): List<StructuredLyric> {
        val result = RequestUtils.safeApiCall { service.getLyricsBySongId(id) }
        return when (result) {
            is RequestResult.Success -> {
                result.data.response?.lyricsList?.structuredLyrics?.filterNotNull() ?: emptyList()
            }

            is RequestResult.Error -> emptyList()
        }
    }

    /**
     * Downloads a given media file(HLS)
     * @param id A string which uniquely identifies the media file to stream.
     */
    fun hlsUrl(id: String, bitRate: Long? = null, audioTrack: String? = null): String {
        val urlBuilder = "$baseUrl/rest/hls.m3u8".toHttpUrlOrNull()?.newBuilder() ?: return ""
        return urlBuilder.apply {
            addBaseQueryParameters(this)
            addQueryParameter("id", id)
            bitRate?.let { addQueryParameter("bitRate", it.toString()) }
            audioTrack?.let { addQueryParameter("audioTrack", it) }
        }.build().toString()
    }

    /**
     * 获取媒体文件流地址
     */
    fun getStreamUrl(
        id: String,
        maxBitRate: Long? = null,
        format: String? = null,
        timeOffset: Long? = null,
        size: String? = null,
        estimateContentLength: Boolean? = null,
        converted: Boolean? = null
    ): String {
        val urlBuilder = "$baseUrl/rest/stream".toHttpUrlOrNull()?.newBuilder() ?: return ""
        urlBuilder.apply {
            addBaseQueryParameters(this)
            addQueryParameter("id", id)
            maxBitRate?.let { addQueryParameter("maxBitRate", it.toString()) }
            format?.let { addQueryParameter("format", it) }
            timeOffset?.let { addQueryParameter("timeOffset", it.toString()) }
            size?.let { addQueryParameter("size", it) }
            estimateContentLength?.let { addQueryParameter("estimateContentLength", it.toString()) }
            converted?.let { addQueryParameter("converted", it.toString()) }
        }
        return urlBuilder.build().toString()
    }

    private fun addBaseQueryParameters(urlBuilder: HttpUrl.Builder) {
        urlBuilder
            .addQueryParameter("u", authInfo.username)
            .addQueryParameter("p", authInfo.password)
            .addQueryParameter("v", authInfo.version)
            .addQueryParameter("c", authInfo.client)
            .addQueryParameter("f", authInfo.format)
    }
}