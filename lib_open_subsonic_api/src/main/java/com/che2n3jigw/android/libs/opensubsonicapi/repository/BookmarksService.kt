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
package com.che2n3jigw.android.libs.opensubsonicapi.repository

import com.che2n3jigw.android.libs.opensubsonicapi.response.BaseResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.bookmarks.GetBookmarksResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.bookmarks.GetPlayQueueByIndexSuccessResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.bookmarks.GetPlayQueueResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.common.SubsonicResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * open subsonic bookmarks api
 */
interface BookmarksService {
    /**
     * Creates or updates a bookmark (a position within a media file). Bookmarks are personal and not visible to other users.
     */
    @GET("/rest/createBookmark")
    suspend fun createBookmark(
        @Query("id") id: String,
        @Query("position") position: Long,
        @Query("comment") comment: String? = null
    ): BaseResponse<SubsonicResponse>

    /**
     * Deletes a bookmark (a position within a media file). Bookmarks are personal and not visible to other users.
     */
    @GET("/rest/deleteBookmark")
    suspend fun deleteBookmark(@Query("id") id: String): BaseResponse<SubsonicResponse>

    /**
     * Returns all bookmarks for this user. A bookmark is a position within a certain media file.
     */
    @GET("/rest/getBookmarks")
    suspend fun getBookmarks(): BaseResponse<GetBookmarksResponse>

    /**
     * Returns the state of the play queue for this user (as set by savePlayQueue).
     * This includes the tracks in the play queue, the currently playing track, and the position within this track.
     * Typically used to allow a user to move between different clients/apps while retaining the same play queue (for instance when listening to an audio book).
     */
    @GET("/rest/getPlayQueue")
    suspend fun getPlayQueue(): BaseResponse<GetPlayQueueResponse>

    /**
     * Returns the state of the play queue for this user (as set by savePlayQueue).
     * This includes the tracks in the play queue, the currently playing track, and the position within this track.
     * Typically used to allow a user to move between different clients/apps while retaining the same play queue (for instance when listening to an audio book).
     */
    @GET("/rest/getPlayQueueByIndex")
    suspend fun getPlayQueueByIndex(): BaseResponse<GetPlayQueueByIndexSuccessResponse>

    /**
     * Saves the state of the play queue for this user.
     * This includes the tracks in the play queue, the currently playing track, and the position within this track.
     * Typically used to allow a user to move between different clients/apps while retaining the same play queue (for instance when listening to an audio book). id is optional. Send a call without any parameters to clear the currently saved queue.
     */
    @GET("/rest/savePlayQueue")
    suspend fun savePlayQueue(
        @Query("id") id: String? = null,
        @Query("current") current: String? = null,
        @Query("position") position: Long? = null
    ): BaseResponse<SubsonicResponse>

    /**
     * Saves the state of the play queue for this user.
     * This includes the tracks in the play queue, the currently playing track, and the position within this track.
     * Typically used to allow a user to move between different clients/apps while retaining the same play queue (for instance when listening to an audio book). id is optional. Send a call without any parameters to clear the currently saved queue.
     */
    @GET("/rest/savePlayQueueByIndex")
    suspend fun savePlayQueueByIndex(
        @Query("id") id: String? = null,
        @Query("currentIndex") currentIndex: Long? = null,
        @Query("position") position: Long? = null
    ): BaseResponse<SubsonicResponse>

}