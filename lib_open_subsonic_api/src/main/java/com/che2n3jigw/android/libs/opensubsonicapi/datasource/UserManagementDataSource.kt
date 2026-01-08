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
package com.che2n3jigw.android.libs.opensubsonicapi.datasource

import com.che2n3jigw.android.libs.net.bean.RequestResult
import com.che2n3jigw.android.libs.net.utils.RequestUtils
import com.che2n3jigw.android.libs.opensubsonicapi.UnverifiedApi
import com.che2n3jigw.android.libs.opensubsonicapi.bean.AutoInfo
import com.che2n3jigw.android.libs.opensubsonicapi.response.user.User
import com.che2n3jigw.android.libs.opensubsonicapi.service.UserManagementService

/**
 * User management repository.
 */
class UserManagementDataSource(
    baseUrl: String,
    authInfo: AutoInfo,
    enableLogging: Boolean = true
) : BaseDataSource(baseUrl, authInfo, enableLogging) {

    private val service: UserManagementService = service()

    /**
     * 修改密码
     * @param username 用户名
     * @param password 新密码
     */
    @UnverifiedApi
    suspend fun changePassword(username: String, password: String): Boolean {
        val result = RequestUtils.safeApiCall { service.changePassword(username, password) }
        return when (result) {
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            is RequestResult.Error -> false
        }
    }

    /**
     * 创建用户
     * @param username  用户名
     * @param password  密码
     * @param email     邮箱
     */
    @UnverifiedApi
    suspend fun createUser(
        username: String,
        password: String,
        email: String,
        ldapAuthenticated: Boolean? = null,
        adminRole: Boolean? = null,
        settingsRole: Boolean? = null,
        streamRole: Boolean? = null,
        jukeboxRole: Boolean? = null,
        downloadRole: Boolean? = null,
        uploadRole: Boolean? = null,
        playlistRole: Boolean? = null,
        coverArtRole: Boolean? = null,
        commentRole: Boolean? = null,
        podcastRole: Boolean? = null,
        shareRole: Boolean? = null,
        videoConversionRole: Boolean? = null,
        musicFolderId: List<String>? = null
    ): Boolean {
        val result = RequestUtils.safeApiCall {
            service.createUser(
                username, password, email, ldapAuthenticated, adminRole, settingsRole, streamRole,
                jukeboxRole, downloadRole, uploadRole, playlistRole, coverArtRole, commentRole,
                podcastRole, shareRole, videoConversionRole, musicFolderId
            )
        }
        return when (result) {
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            is RequestResult.Error -> false
        }
    }

    /**
     * 删除用户
     * @param username  用户名
     */
    @UnverifiedApi
    suspend fun deleteUser(username: String): Boolean {
        val result = RequestUtils.safeApiCall { service.deleteUser(username) }
        return when (result) {
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            is RequestResult.Error -> false
        }
    }


    /**
     * 获取用户信息
     * @param username  用户名
     */
    suspend fun getUser(username: String): User? {
        val result = RequestUtils.safeApiCall { service.getUser(username) }
        return when (result) {
            is RequestResult.Success -> result.data.response?.user
            is RequestResult.Error -> null
        }
    }

    /**
     * 获取所有用户信息
     */
    suspend fun getUsers(): List<User> {
        val result = RequestUtils.safeApiCall { service.getUsers() }
        return when (result) {
            is RequestResult.Success -> {
                result.data.response?.users?.user?.filterNotNull() ?: emptyList()
            }

            is RequestResult.Error -> emptyList()
        }
    }

    /**
     * 更新用户信息
     */
    @UnverifiedApi
    suspend fun updateUser(
        username: String,
        password: String,
        email: String? = null,
        ldapAuthenticated: Boolean? = null,
        adminRole: Boolean? = null,
        settingsRole: Boolean? = null,
        streamRole: Boolean? = null,
        jukeboxRole: Boolean? = null,
        downloadRole: Boolean? = null,
        uploadRole: Boolean? = null,
        playlistRole: Boolean? = null,
        coverArtRole: Boolean? = null,
        commentRole: Boolean? = null,
        podcastRole: Boolean? = null,
        shareRole: Boolean? = null,
        videoConversionRole: Boolean? = null,
        musicFolderId: List<String>? = null
    ): Boolean {
        val result = RequestUtils.safeApiCall {
            service.updateUser(
                username, password, email, ldapAuthenticated, adminRole, settingsRole, streamRole,
                jukeboxRole, downloadRole, uploadRole, playlistRole, coverArtRole, commentRole,
                podcastRole, shareRole, videoConversionRole, musicFolderId
            )
        }
        return when (result) {
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            is RequestResult.Error -> false
        }
    }


}