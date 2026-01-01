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

import com.che2n3jigw.android.libs.opensubsonicapi.response.BaseResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.common.SubsonicResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.playlists.CreatePlaylistResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.playlists.GetPlaylistResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.playlists.GetPlaylistsResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * open subsonic playlists api
 */
interface PlaylistsService {
    /**
     * Creates (or updates) a playlist.
     */
    @GET("/rest/createPlaylist")
    suspend fun createPlaylist(
        @Query("playlistId") playlistId: String? = null,
        @Query("name") name: String? = null,
        @Query("songId") songId: List<String>? = null
    ): BaseResponse<CreatePlaylistResponse>

    /**
     * Deletes a saved playlist.
     */
    @GET("/rest/deletePlaylist")
    suspend fun deletePlaylist(
        @Query("id") id: String
    ): BaseResponse<SubsonicResponse>

    /**
     * Returns a listing of files in a saved playlist.
     */
    @GET("/rest/getPlaylist")
    suspend fun getPlaylist(
        @Query("id") id: String
    ): BaseResponse<GetPlaylistResponse>

    /**
     * Returns all playlists a user is allowed to play.
     */
    @GET("/rest/getPlaylists")
    suspend fun getPlaylists(
        @Query("username") username: String? = null
    ): BaseResponse<GetPlaylistsResponse>

    /**
     * Updates a playlist. Only the owner of a playlist is allowed to update it.
     */
    @GET("/rest/updatePlaylist")
    suspend fun updatePlaylist(
        @Query("playlistId") playlistId: String,
        @Query("name") name: String? = null,
        @Query("comment") comment: String? = null,
        @Query("public") public: Boolean? = null,
        @Query("songIdToAdd") songIdToAdd: List<String>? = null,
        @Query("songIndexToRemove") songIndexToRemove: List<Int>? = null
    ): BaseResponse<SubsonicResponse>
}