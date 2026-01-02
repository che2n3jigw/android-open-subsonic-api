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
package com.che2n3jigw.android.libs.opensubsonicapi.service

import com.che2n3jigw.android.libs.opensubsonicapi.response.BaseResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.BaseSubsonicResponse
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
    ): BaseResponse<BaseSubsonicResponse>

    /**
     * Creates a new user on the server.
     */
    @GET("/rest/createUser")
    suspend fun createUser(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("email") email: String,
        @Query("ldapAuthenticated") ldapAuthenticated: Boolean? = null,
        @Query("adminRole") adminRole: Boolean? = null,
        @Query("settingsRole") settingsRole: Boolean? = null,
        @Query("streamRole") streamRole: Boolean? = null,
        @Query("jukeboxRole") jukeboxRole: Boolean? = null,
        @Query("downloadRole") downloadRole: Boolean? = null,
        @Query("uploadRole") uploadRole: Boolean? = null,
        @Query("playlistRole") playlistRole: Boolean? = null,
        @Query("coverArtRole") coverArtRole: Boolean? = null,
        @Query("commentRole") commentRole: Boolean? = null,
        @Query("podcastRole") podcastRole: Boolean? = null,
        @Query("shareRole") shareRole: Boolean? = null,
        @Query("videoConversionRole") videoConversionRole: Boolean? = null,
        @Query("musicFolderId") musicFolderId: List<String>? = null
    ): BaseResponse<BaseSubsonicResponse>

    /**
     * Deletes an existing user on the server.
     */
    @GET("/rest/deleteUser")
    suspend fun deleteUser(
        @Query("username") username: String
    ): BaseResponse<BaseSubsonicResponse>

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
        @Query("email") email: String? = null,
        @Query("ldapAuthenticated") ldapAuthenticated: Boolean? = null,
        @Query("adminRole") adminRole: Boolean? = null,
        @Query("settingsRole") settingsRole: Boolean? = null,
        @Query("streamRole") streamRole: Boolean? = null,
        @Query("jukeboxRole") jukeboxRole: Boolean? = null,
        @Query("downloadRole") downloadRole: Boolean? = null,
        @Query("uploadRole") uploadRole: Boolean? = null,
        @Query("playlistRole") playlistRole: Boolean? = null,
        @Query("coverArtRole") coverArtRole: Boolean? = null,
        @Query("commentRole") commentRole: Boolean? = null,
        @Query("podcastRole") podcastRole: Boolean? = null,
        @Query("shareRole") shareRole: Boolean? = null,
        @Query("videoConversionRole") videoConversionRole: Boolean? = null,
        @Query("musicFolderId") musicFolderId: List<String>? = null,
        @Query("maxBitRate") maxBitRate: Long? = null
    ): BaseResponse<BaseSubsonicResponse>
}