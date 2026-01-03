/*
 * Copyright (c) 2025 che2n3jigw.
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
package com.che2n3jigw.android.libs.opensubsonicapi.repository

import android.util.Log
import com.che2n3jigw.android.libs.net.bean.RequestResult
import com.che2n3jigw.android.libs.net.utils.RequestUtils
import com.che2n3jigw.android.libs.opensubsonicapi.UnverifiedApi
import com.che2n3jigw.android.libs.opensubsonicapi.bean.AutoInfo
import com.che2n3jigw.android.libs.opensubsonicapi.download.DownloadClient
import com.che2n3jigw.android.libs.opensubsonicapi.response.retrieval.Lyrics
import com.che2n3jigw.android.libs.opensubsonicapi.response.retrieval.StructuredLyric
import com.che2n3jigw.android.libs.opensubsonicapi.service.MediaRetrievalService
import okhttp3.ResponseBody
import retrofit2.Response

class MediaRetrievalRepository(
    baseUrl: String,
    authInfo: AutoInfo,
    enableLogging: Boolean = true
) : BaseRepository(baseUrl, authInfo, enableLogging) {

    companion object {
        private const val TAG = "MediaRetrievalRepository"
    }

    private val service: MediaRetrievalService = service()
    private val downloadService =
        DownloadClient(baseUrl, authInfo).createService<MediaRetrievalService>()

    /**
     * 下载指定的媒体文件。类似于流式传输，
     * 但此方法返回的是原始媒体数据，不进行转码或降采样。
     * @param id 媒体文件的ID,通过getMusicDirectory获取
     */
    suspend fun download(id: String): Response<ResponseBody>? {
        return safeApiCall("download") {
            downloadService.download(id)
        }
    }

    /**
     * 获取头像
     */
    suspend fun getAvatar(username: String): Response<ResponseBody>? {
        return safeApiCall("getAvatar") {
            downloadService.getAvatar(username)
        }
    }

    /**
     * 返回视频字幕
     * @param id  视频id
     */
    @UnverifiedApi
    suspend fun getCaptions(id: String, format: String? = null): Response<ResponseBody>? {
        return safeApiCall("getCaptions") {
            downloadService.getCaptions(id, format)
        }
    }

    /**
     * 获取封面
     * @param id The coverArt ID. Returned by most entities likes Child or AlbumID3
     */
    suspend fun getCoverArt(id: String, size: Long? = null): Response<ResponseBody>? {
        return safeApiCall("getCoverArt") {
            downloadService.getCoverArt(id, size)
        }
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
    suspend fun hls(
        id: String,
        bitRate: Long? = null,
        audioTrack: String? = null
    ): Response<ResponseBody>? {
        return safeApiCall("hls") {
            downloadService.hls(id, bitRate, audioTrack)
        }
    }

    /**
     * Downloads a given media file
     * @param id A string which uniquely identifies the file to stream. Obtained by calls to getMusicDirectory.
     */
    suspend fun stream(
        id: String,
        maxBitRate: Long? = null,
        format: String? = null,
        timeOffset: Long? = null,
        size: String? = null,
        estimateContentLength: Boolean? = null,
        converted: Boolean? = null
    ): Response<ResponseBody>? {
        return safeApiCall("stream") {
            downloadService.stream(
                id,
                maxBitRate,
                format,
                timeOffset,
                size,
                estimateContentLength,
                converted
            )
        }
    }

    private suspend fun <T> safeApiCall(
        tag: String,
        call: suspend () -> Response<T>
    ): Response<T>? {
        return try {
            call()
        } catch (e: Exception) {
            Log.e(TAG, "$tag: ", e)
            null
        }
    }

}

