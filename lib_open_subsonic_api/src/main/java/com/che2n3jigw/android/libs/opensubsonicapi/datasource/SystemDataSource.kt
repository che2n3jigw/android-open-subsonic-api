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

package com.che2n3jigw.android.libs.opensubsonicapi.datasource

import com.che2n3jigw.android.libs.net.bean.RequestResult
import com.che2n3jigw.android.libs.net.utils.RequestUtils
import com.che2n3jigw.android.libs.opensubsonicapi.UnverifiedApi
import com.che2n3jigw.android.libs.opensubsonicapi.bean.AutoInfo
import com.che2n3jigw.android.libs.opensubsonicapi.response.system.License
import com.che2n3jigw.android.libs.opensubsonicapi.response.system.OpenSubsonicExtensions
import com.che2n3jigw.android.libs.opensubsonicapi.response.system.TokenInfo
import com.che2n3jigw.android.libs.opensubsonicapi.service.SystemService

/**
 * Subsonic System API 远程库
 */
class SystemDataSource(
    baseUrl: String,
    authInfo: AutoInfo,
    enableLogging: Boolean = true
) : BaseDataSource(baseUrl, authInfo, enableLogging) {

    private val service: SystemService = service()

    /**
     * 获取软件许可详情
     */
    suspend fun getLicense(): License? {
        val result = RequestUtils.safeApiCall { service.getLicense() }
        return when (result) {
            is RequestResult.Success -> result.data.response?.license
            is RequestResult.Error -> null
        }
    }

    /**
     * 列出此服务器支持的 OpenSubsonic 扩展
     */
    suspend fun getOpenSubsonicExtensions(): List<OpenSubsonicExtensions> {
        val result = RequestUtils.safeApiCall { service.getOpenSubsonicExtensions() }
        return when (result) {
            is RequestResult.Success -> {
                result.data.response?.openSubsonicExtensions?.filterNotNull() ?: emptyList()
            }

            is RequestResult.Error -> emptyList()
        }
    }

    /**
     * 用于测试与服务器的连接性
     */
    suspend fun ping(): Boolean {
        val result = RequestUtils.safeApiCall { service.ping() }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            else -> false
        }
    }

    /**
     * OpenSubsonic extension name apiKeyAuthentication (As returned by getOpenSubsonicExtensions).
     * Returns data about an API key.
     */
    @UnverifiedApi
    suspend fun tokenInfo(): TokenInfo? {
        val result = RequestUtils.safeApiCall {
            service.tokenInfo()
        }
        return when (result) {
            is RequestResult.Success -> result.data.response?.tokenInfo
            is RequestResult.Error -> null
        }
    }
}