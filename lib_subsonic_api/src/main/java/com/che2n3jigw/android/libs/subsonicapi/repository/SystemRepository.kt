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

package com.che2n3jigw.android.libs.subsonicapi.repository

import com.che2n3jigw.android.libs.net.RequestClient
import com.che2n3jigw.android.libs.net.bean.RequestResult
import com.che2n3jigw.android.libs.net.utils.RequestUtils
import com.che2n3jigw.android.libs.subsonicapi.AuthenticationInterceptor
import com.che2n3jigw.android.libs.subsonicapi.bean.response.BaseResponse
import com.che2n3jigw.android.libs.subsonicapi.bean.response.LicenseResponse
import com.che2n3jigw.android.libs.subsonicapi.bean.response.PingResponse
import retrofit2.http.GET

/**
 * Subsonic System API 远程库
 * @param baseUrl           域名
 * @param enableLogging     是否启用日志
 * @param username          用户名
 * @param password          密码
 */
class SystemRepository(
    private val baseUrl: String,
    private val username: String,
    private val password: String,
    private val enableLogging: Boolean = true
) {

    companion object {
        private const val STATUS_OK = "ok"
    }

    private val authInterceptor = AuthenticationInterceptor(username, password)

    private val service = RequestClient.createService<Service>(
        baseUrl = baseUrl,
        enableLogging = enableLogging,
        interceptors = listOf(authInterceptor)
    )

    suspend fun ping(): Boolean {
        val result = RequestUtils.safeApiCall {
            service.ping()
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            else -> false
        }
    }

    suspend fun getLicense(): Boolean {
        val result = RequestUtils.safeApiCall {
            service.getLicense()
        }
        return when (result) {
            is RequestResult.Success -> result.data.response?.license?.valid == true
            is RequestResult.Error -> false
        }
    }

    interface Service {

        @GET("/rest/ping")
        suspend fun ping(): BaseResponse<PingResponse>?

        @GET("/rest/getLicense")
        suspend fun getLicense(): BaseResponse<LicenseResponse>
    }
}