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
import com.che2n3jigw.android.libs.opensubsonicapi.response.common.SubsonicResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.sharing.CreateSharesResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.sharing.GetSharesResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * open subsonic sharing api
 */
interface SharingService {
    /**
     * Creates a public URL that can be used by anyone to stream music or video from the server.
     * The URL is short and suitable for posting on Facebook, Twitter etc.
     * Note: The user must be authorized to share (see Settings > Users > User is allowed to share files with anyone). Since 1.6.0.
     */
    @GET("/rest/createShare")
    suspend fun createShare(
        @Query("id") id: List<String>,
        @Query("description") description: String? = null,
        @Query("expires") expires: Long? = null
    ): BaseResponse<CreateSharesResponse>

    /**
     * Deletes an existing share
     */
    @GET("/rest/deleteShare")
    suspend fun deleteShare(@Query("id") id: String): BaseResponse<SubsonicResponse>

    /**
     * Returns information about shared media this user is allowed to manage. Takes no extra parameters.
     */
    @GET("/rest/getShares")
    suspend fun getShares(): BaseResponse<GetSharesResponse>

    /**
     * Updates the description and/or expiration date for an existing share.
     */
    @GET("/rest/updateShare")
    suspend fun updateShare(
        @Query("id") id: String,
        @Query("description") description: String? = null,
        @Query("expires") expires: Int? = null
    ): BaseResponse<SubsonicResponse>

}