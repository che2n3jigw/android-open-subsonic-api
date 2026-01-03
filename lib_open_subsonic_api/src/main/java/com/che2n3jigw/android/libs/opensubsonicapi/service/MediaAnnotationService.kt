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
// 创建时间： 1/1/26
package com.che2n3jigw.android.libs.opensubsonicapi.service

import com.che2n3jigw.android.libs.opensubsonicapi.response.BaseResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.BaseSubsonicResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 */
interface MediaAnnotationService {

    /**
     * Registers the local playback of one or more media files. Typically used when playing media that is cached on the client. This operation includes the following:
     *
     * “Scrobbles” the media files on last.fm if the user has configured his/her last.fm credentials on the server.
     * Updates the play count and last played timestamp for the media files. (Since 1.11.0)
     * Makes the media files appear in the “Now playing” page in the web app, and appear in the list of songs returned by getNowPlaying (Since 1.11.0)
     * Since 1.8.0 you may specify multiple id (and optionally time) parameters to scrobble multiple files.
     */
    @GET("/rest/scrobble")
    suspend fun scrobble(
        @Query("id") id: String,
        @Query("time") time: Long? = null,
        @Query("submission") submission: Boolean? = null
    ): BaseResponse<BaseSubsonicResponse>

    /**
     * Sets the rating for a music file.
     */
    @GET("/rest/setRating")
    suspend fun setRating(
        @Query("id") id: String,
        @Query("rating") rating: Int
    ): BaseResponse<BaseSubsonicResponse>

    /**
     * Attaches a star to a song, album or artist.
     */
    @GET("/rest/star")
    suspend fun star(
        @Query("id") id: List<String>? = null,
        @Query("albumId") albumId: List<String>? = null,
        @Query("artistId") artistId: List<String>? = null
    ): BaseResponse<BaseSubsonicResponse>

    /**
     * Removes a star to a song, album or artist.
     */
    @GET("/rest/unstar")
    suspend fun unstar(
        @Query("id") id: List<String>? = null,
        @Query("albumId") albumId: List<String>? = null,
        @Query("artistId") artistId: List<String>? = null
    ): BaseResponse<BaseSubsonicResponse>
}