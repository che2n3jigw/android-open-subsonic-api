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
import com.che2n3jigw.android.libs.opensubsonicapi.response.user.GetUserResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.user.GetUsersResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * open subsonic user management api
 */
interface UserManagementService {
    /**
     * Changes the password of an existing user on the server, using the following parameters.
     * You can only change your own password unless you have admin privileges.
     */
    @GET("/rest/changePassword")
    suspend fun changePassword(
        @Query("username") username: String,
        @Query("password") password: String
    ): BaseResponse<SubsonicResponse>

    /**
     * Creates a new user on the server.
     */
    @GET("/rest/createUser")
    suspend fun createUser(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("email") email: String,
        @Query("ldapAuthenticated") ldapAuthenticated: Boolean,
        @Query("adminRole") adminRole: Boolean,
        @Query("settingsRole") settingsRole: Boolean,
        @Query("streamRole") streamRole: Boolean,
        @Query("jukeboxRole") jukeboxRole: Boolean,
        @Query("downloadRole") downloadRole: Boolean,
        @Query("uploadRole") uploadRole: Boolean,
        @Query("playlistRole") playlistRole: Boolean,
        @Query("coverArtRole") coverArtRole: Boolean,
        @Query("commentRole") commentRole: Boolean,
        @Query("podcastRole") podcastRole: Boolean,
        @Query("shareRole") shareRole: Boolean,
        @Query("videoConversionRole") videoConversionRole: Boolean,
        @Query("musicFolderId") musicFolderId: List<String>
    ): BaseResponse<SubsonicResponse>

    /**
     * Deletes an existing user on the server.
     */
    @GET("/rest/deleteUser")
    suspend fun deleteUser(
        @Query("username") username: String
    ): BaseResponse<SubsonicResponse>

    /**
     * Get details about a given user, including which authorization roles and folder access it has.
     * Can be used to enable/disable certain features in the client, such as jukebox control.
     */
    @GET("/rest/getUser")
    suspend fun getUser(
        @Query("username") username: String
    ): BaseResponse<GetUserResponse>

    /**
     * Get details about all users, including which authorization roles and folder access they have.
     * Only users with admin privileges are allowed to call this method.
     */
    @GET("/rest/getUsers")
    suspend fun getUsers(): BaseResponse<GetUsersResponse>

    /**
     * Modifies an existing user on the server.
     */
    @GET("/rest/updateUser")
    suspend fun updateUser(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("email") email: String,
        @Query("ldapAuthenticated") ldapAuthenticated: Boolean,
        @Query("adminRole") adminRole: Boolean,
        @Query("settingsRole") settingsRole: Boolean,
        @Query("streamRole") streamRole: Boolean,
        @Query("jukeboxRole") jukeboxRole: Boolean,
        @Query("downloadRole") downloadRole: Boolean,
        @Query("uploadRole") uploadRole: Boolean,
        @Query("playlistRole") playlistRole: Boolean,
        @Query("coverArtRole") coverArtRole: Boolean,
        @Query("commentRole") commentRole: Boolean,
        @Query("podcastRole") podcastRole: Boolean,
        @Query("shareRole") shareRole: Boolean,
        @Query("videoConversionRole") videoConversionRole: Boolean,
        @Query("musicFolderId") musicFolderId: List<String>,
        @Query("maxBitRate") maxBitRate: Long,
    ): BaseResponse<SubsonicResponse>
}