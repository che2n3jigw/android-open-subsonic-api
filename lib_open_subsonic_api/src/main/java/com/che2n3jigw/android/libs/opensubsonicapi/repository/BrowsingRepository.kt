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
// 创建时间： 12/20/25
package com.che2n3jigw.android.libs.opensubsonicapi.repository

import com.che2n3jigw.android.libs.net.RequestClient
import com.che2n3jigw.android.libs.net.bean.RequestResult
import com.che2n3jigw.android.libs.net.utils.RequestUtils
import com.che2n3jigw.android.libs.opensubsonicapi.UnverifiedApi
import com.che2n3jigw.android.libs.opensubsonicapi.bean.AutoInfo
import com.che2n3jigw.android.libs.opensubsonicapi.response.common.AlbumID3WithSongs
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.AlbumInfo
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.ArtistInfo
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.ArtistInfo2
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.ArtistWithAlbumsID3
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.ArtistsID3
import com.che2n3jigw.android.libs.opensubsonicapi.response.common.Child
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.Directory
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.Genre
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.Indexes
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.MusicFolder

/**
 * Subsonic Browsing API 远程库
 */
class BrowsingRepository(
    private val baseUrl: String,
    authInfo: AutoInfo,
    private val enableLogging: Boolean = true
) : BaseRepository(authInfo) {

    private val service = RequestClient.createService<BrowsingService>(
        baseUrl = baseUrl,
        enableLogging = enableLogging,
        interceptors = listOf(authInterceptor)
    )

    /**
     * 获取专辑的详细信息，包括歌曲列表。此方法根据 ID3 标签对音乐进行分类。
     * @param id 专辑的ID
     */
    suspend fun getAlbum(id: String): AlbumID3WithSongs? {
        val result = RequestUtils.safeApiCall { service.getAlbum(id) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.album
            }
            // 请求失败
            else -> null
        }
    }

    /**
     * 获取专辑信息
     * @param id 专辑的ID/歌曲ID
     */
    suspend fun getAlbumInfo(id: String): AlbumInfo? {
        val result = RequestUtils.safeApiCall { service.getAlbumInfo(id) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.albumInfo
            // 请求失败
            else -> null
        }
    }

    /**
     * 与 getAlbumInfo 类似，但它是根据 ID3 标签对音乐进行分类。
     * @param id 专辑的ID
     */
    suspend fun getAlbumInfo2(id: String): AlbumInfo? {
        val result = RequestUtils.safeApiCall { service.getAlbumInfo2(id) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.albumInfo
            // 请求失败
            else -> null
        }
    }

    /**
     * 获取艺术家详情,ID3 tags 分类
     * @param id 艺术家的ID
     */
    suspend fun getArtist(id: String): ArtistWithAlbumsID3? {
        val result = RequestUtils.safeApiCall { service.getArtist(id) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.artist
            // 请求失败
            else -> null
        }
    }

    /**
     * 获取艺术家信息
     * @param id                艺术家的ID
     * @param count             相似艺术家数量上限
     * @param includeNotPresent 是否归还媒体库中不存在的艺术家
     */
    suspend fun getArtistInfo(
        id: String,
        count: Int = 20,
        includeNotPresent: Boolean = false
    ): ArtistInfo? {
        val result =
            RequestUtils.safeApiCall { service.getArtistInfo(id, count, includeNotPresent) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.artistInfo
            // 请求失败
            else -> null
        }
    }

    /**
     * 获取艺术家信息，与getArtistInfo相似，但它是根据 ID3 标签对音乐进行分类。
     * @param id                艺术家的ID
     * @param count             相似艺术家数量上限
     * @param includeNotPresent 是否归还媒体库中不存在的艺术家
     */
    suspend fun getArtistInfo2(
        id: String,
        count: Int = 20,
        includeNotPresent: Boolean = false
    ): ArtistInfo2? {
        val result =
            RequestUtils.safeApiCall { service.getArtistInfo2(id, count, includeNotPresent) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.artistInfo2
            // 请求失败
            else -> null
        }
    }

    /**
     * 获取所有艺术家
     * 与 getIndexes 类似，但它是根据 ID3 标签对音乐进行组织。
     * @param musicFolderId 如果指定，则仅返回音乐文件夹中具有给定 ID 的艺术家。
     */
    suspend fun getArtists(musicFolderId: String? = null): ArtistsID3? {
        val result = RequestUtils.safeApiCall { service.getArtists(musicFolderId) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.artists
            // 请求失败
            else -> null
        }
    }

    /**
     * 获取所有流派
     */
    suspend fun getGenres(): List<Genre> {
        val result = RequestUtils.safeApiCall { service.getGenres() }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.genres?.genre?.filterNotNull() ?: emptyList()
            }
            // 请求失败
            else -> emptyList()
        }
    }

    /**
     * 获取所有艺术家的索引结构。
     * @param musicFolderId     如果指定，则仅返回音乐文件夹中具有给定 ID 的艺术家。请参阅 getMusicFolders。
     * @param ifModifiedSince   如果指定，则仅当艺术家集合自给定时间（自 1970 年 1 月 1 日以来的毫秒数）以来发生变化时才返回结果。
     * @return 所有艺术家的索引结构
     */
    suspend fun getIndexes(musicFolderId: String? = null, ifModifiedSince: Long? = null): Indexes? {
        val result = RequestUtils.safeApiCall { service.getIndexes(musicFolderId, ifModifiedSince) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.indexes
            // 请求失败
            else -> null
        }
    }

    /**
     * 用于获取某个艺术家的专辑列表，或某个专辑的歌曲列表。
     * @param id 音乐目录的ID(艺术家id/专辑id),通过getIndexes/getMusicDirectory获取
     * @return 音乐目录中所有文件的列表
     */
    suspend fun getMusicDirectory(id: String): Directory? {
        val result = RequestUtils.safeApiCall {
            service.getMusicDirectory(id)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.directory
            // 请求失败
            else -> null
        }
    }

    /**
     * 返回所有已配置的顶级音乐文件夹
     */
    suspend fun getMusicFolders(): List<MusicFolder> {
        val result = RequestUtils.safeApiCall { service.getMusicFolders() }
        return when (result) {
            // 请求成功
            is RequestResult.Success ->
                result.data.response?.musicFolders?.musicFolder?.filterNotNull() ?: emptyList()
            // 请求失败
            else -> emptyList()
        }
    }

    /**
     * 返回给定艺术家及其相似艺术家的随机歌曲集合。
     * @param id                歌曲的ID
     * @param count             相似歌曲数量上限
     */
    suspend fun getSimilarSongs(id: String, count: Int = 50): List<Child> {
        val result = RequestUtils.safeApiCall { service.getSimilarSongs(id, count) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.similarSongs?.song?.filterNotNull() ?: emptyList()
            }
            // 请求失败
            else -> emptyList()
        }
    }

    /**
     * 返回给定艺术家和类似艺术家的随机歌曲集合（v2）。
     * @param id                歌曲的ID
     * @param count             相似歌曲数量上限
     */
    suspend fun getSimilarSongs2(id: String, count: Int = 50): List<Child> {
        val result = RequestUtils.safeApiCall { service.getSimilarSongs2(id, count) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.similarSongs2?.song?.filterNotNull() ?: emptyList()
            }
            // 请求失败
            else -> emptyList()
        }
    }


    /**
     * 获取歌曲详情
     * @param id 歌曲的ID
     */
    suspend fun getSong(id: String): Child? {
        val result = RequestUtils.safeApiCall { service.getSong(id) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.song
            // 请求失败
            else -> null
        }
    }

    /**
     * 返回指定歌手的热门歌曲。
     * @param artist            歌手
     * @param count             热门歌曲数量上限
     * @return 给定歌手的热门歌曲，数据来自 last.fm。
     */
    suspend fun getTopSongs(artist: String, count: Int = 50): List<Child> {
        val result = RequestUtils.safeApiCall { service.getTopSongs(artist, count) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.topSongs?.song?.filterNotNull() ?: emptyList()
            }
            // 请求失败
            else -> emptyList()
        }
    }

    /**
     * 获取视频详情
     * @param id 视频的ID
     */
    @UnverifiedApi
    suspend fun getVideoInfo(id: String) {
        RequestUtils.safeApiCall { service.getVideoInfo(id) }
    }

    /**
     * 获取所有视频
     */
    @UnverifiedApi
    suspend fun getVideos() {
        RequestUtils.safeApiCall { service.getVideos() }
    }
}