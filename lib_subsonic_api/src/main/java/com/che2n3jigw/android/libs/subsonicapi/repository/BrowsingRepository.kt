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
package com.che2n3jigw.android.libs.subsonicapi.repository

import com.che2n3jigw.android.libs.net.RequestClient
import com.che2n3jigw.android.libs.net.bean.RequestResult
import com.che2n3jigw.android.libs.net.utils.RequestUtils
import com.che2n3jigw.android.libs.subsonicapi.bean.AutoInfo
import com.che2n3jigw.android.libs.subsonicapi.response.BaseResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.ArtistsResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.GenresResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.IndexesResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.IndexesResponse.Indexes
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.MusicDirectoryResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.MusicFoldersResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Subsonic Browsing API 远程库
 */
class BrowsingRepository(
    private val baseUrl: String,
    authInfo: AutoInfo,
    private val enableLogging: Boolean = true
) : BaseRepository(authInfo) {

    private val service = RequestClient.createService<Service>(
        baseUrl = baseUrl,
        enableLogging = enableLogging,
        interceptors = listOf(authInterceptor)
    )

    /**
     * 获取音乐文件夹
     */
    suspend fun getMusicFolders(): List<MusicFoldersResponse.MusicFolder> {
        val result = RequestUtils.safeApiCall {
            service.getMusicFolders()
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success ->
                result.data.response?.musicFolders?.musicFolder?.filterNotNull() ?: emptyList()
            // 请求失败
            else -> emptyList()
        }
    }

    /**
     * 获取索引结构
     * @return 所有艺术家的索引结构
     */
    suspend fun getIndexes(musicFolderId: Int? = null, ifModifiedSince: Long? = null): Indexes? {
        val result = RequestUtils.safeApiCall {
            service.getIndexes(musicFolderId, ifModifiedSince)
        }
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
    suspend fun getMusicDirectory(id: String): MusicDirectoryResponse.Directory? {
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
     * 获取流派
     */
    suspend fun getGenres(): List<GenresResponse.Genre> {
        val result = RequestUtils.safeApiCall {
            service.getGenres()
        }
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
     * 获取艺术家
     * 与 getIndexes 类似，但它是根据 ID3 标签对音乐进行组织。
     * @param musicFolderId 如果指定，则仅返回音乐文件夹中具有给定 ID 的艺术家。
     */
    suspend fun getArtists(musicFolderId: Long? = null): ArtistsResponse.Artists? {
        val result = RequestUtils.safeApiCall {
            service.getArtists(musicFolderId)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.artists
            }
            // 请求失败
            else -> null
        }
    }
}

interface Service {

    @GET("/rest/getMusicFolders")
    suspend fun getMusicFolders(): BaseResponse<MusicFoldersResponse>

    @GET("/rest/getIndexes")
    suspend fun getIndexes(
        @Query("musicFolderId") musicFolderId: Int? = null,
        @Query("ifModifiedSince") ifModifiedSince: Long? = null
    ): BaseResponse<IndexesResponse>

    @GET("/rest/getMusicDirectory")
    suspend fun getMusicDirectory(@Query("id") id: String): BaseResponse<MusicDirectoryResponse>

    @GET("/rest/getGenres")
    suspend fun getGenres(): BaseResponse<GenresResponse>

    @GET("/rest/getArtists")
    suspend fun getArtists(@Query("musicFolderId") musicFolderId: Long? = null): BaseResponse<ArtistsResponse>
}