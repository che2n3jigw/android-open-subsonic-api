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
// 创建时间： 1/3/26
package com.che2n3jigw.android.libs.opensubsonicapi.repository

import com.che2n3jigw.android.libs.net.bean.RequestResult
import com.che2n3jigw.android.libs.net.utils.RequestUtils
import com.che2n3jigw.android.libs.opensubsonicapi.UnverifiedApi
import com.che2n3jigw.android.libs.opensubsonicapi.bean.AutoInfo
import com.che2n3jigw.android.libs.opensubsonicapi.response.sharing.Shares
import com.che2n3jigw.android.libs.opensubsonicapi.service.SharingService

class SharingRepository(
    baseUrl: String,
    authInfo: AutoInfo,
    enableLogging: Boolean = true
) : BaseRepository(baseUrl, authInfo, enableLogging) {

    private val service: SharingService = service()

    /**
     * create a public URL that can be used by anyone to stream music or vide from the server
     * @param id            ID if a song / album or video to share
     * @param description   A user-defined description
     * @param expires       the share expires
     */
    @UnverifiedApi
    suspend fun createShare(
        id: List<String>,
        description: String? = null,
        expires: Long? = null
    ): Shares? {
        val result = RequestUtils.safeApiCall { service.createShare(id, description, expires) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.shares
            // 请求失败
            else -> null
        }
    }

    /**
     * deletes an existing share
     * @param id            ID if a song / album or video to share
     */
    @UnverifiedApi
    suspend fun deleteShare(id: String): Boolean {
        val result = RequestUtils.safeApiCall { service.deleteShare(id) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            // 请求失败
            else -> false
        }
    }

    /**
     * return information about shared media this user is allowed to manage
     */
    @UnverifiedApi
    suspend fun getShares(): Shares? {
        val result = RequestUtils.safeApiCall { service.getShares() }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.shares
            // 请求失败
            else -> null
        }
    }


    /**
     * Updates the description and/or expiration date for an existing share
     * @param id            ID if a song / album or video to share
     * @param description   A user-defined description
     * @param expires       the share expires
     */
    @UnverifiedApi
    suspend fun updateShare(
        id: String,
        description: String? = null,
        expires: Long? = null
    ): Boolean {
        val result = RequestUtils.safeApiCall { service.updateShare(id, description, expires) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            // 请求失败
            else -> false
        }
    }

}