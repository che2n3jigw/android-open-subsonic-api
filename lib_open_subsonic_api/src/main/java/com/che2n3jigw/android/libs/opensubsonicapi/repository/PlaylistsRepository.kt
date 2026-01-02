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
// 创建时间： 1/2/26
package com.che2n3jigw.android.libs.opensubsonicapi.repository

import com.che2n3jigw.android.libs.net.bean.RequestResult
import com.che2n3jigw.android.libs.net.utils.RequestUtils
import com.che2n3jigw.android.libs.opensubsonicapi.bean.AutoInfo
import com.che2n3jigw.android.libs.opensubsonicapi.response.playlists.Playlist
import com.che2n3jigw.android.libs.opensubsonicapi.response.playlists.PlaylistWithSongs
import com.che2n3jigw.android.libs.opensubsonicapi.service.PlaylistsService

class PlaylistsRepository(
    baseUrl: String,
    authInfo: AutoInfo,
    enableLogging: Boolean = true
) : BaseRepository(baseUrl, authInfo, enableLogging) {

    private val service: PlaylistsService = service()

    /**
     * 创建播放列表
     */
    suspend fun createPlaylist(
        playlistId: String? = null,
        name: String? = null,
        songId: List<String>? = null
    ): PlaylistWithSongs? {
        val result = RequestUtils.safeApiCall { service.createPlaylist(playlistId, name, songId) }
        return when (result) {
            is RequestResult.Success -> result.data.response?.playlist
            is RequestResult.Error -> null
        }
    }

    /**
     * 删除播放列表
     */
    suspend fun deletePlaylist(playlistId: String): Boolean {
        val result = RequestUtils.safeApiCall { service.deletePlaylist(playlistId) }
        return when (result) {
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            is RequestResult.Error -> false
        }
    }

    /**
     * 获取播放列表
     */
    suspend fun getPlaylist(playlistId: String): PlaylistWithSongs? {
        val result = RequestUtils.safeApiCall { service.getPlaylist(playlistId) }
        return when (result) {
            is RequestResult.Success -> result.data.response?.playlist
            is RequestResult.Error -> null
        }
    }

    /**
     * 获取所有播放列表
     */
    suspend fun getPlaylists(): List<Playlist> {
        val result = RequestUtils.safeApiCall { service.getPlaylists() }
        return when (result) {
            is RequestResult.Success -> {
                result.data.response?.playlists?.playlist?.filterNotNull() ?: emptyList()
            }

            is RequestResult.Error -> emptyList()
        }
    }

    /**
     * 更新播放列表
     */
    suspend fun updatePlaylist(
        playlistId: String,
        name: String? = null,
        comment: String? = null,
        public: Boolean? = null,
        songIdToAdd: List<String>? = null,
        songIndexToRemove: List<Int>? = null
    ): Boolean {
        val result = RequestUtils.safeApiCall {
            service.updatePlaylist(
                playlistId, name, comment, public, songIdToAdd, songIndexToRemove
            )
        }
        return when (result) {
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            is RequestResult.Error -> false
        }
    }
}