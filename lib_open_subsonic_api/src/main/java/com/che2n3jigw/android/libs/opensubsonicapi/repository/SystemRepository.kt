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

package com.che2n3jigw.android.libs.opensubsonicapi.repository

import com.che2n3jigw.android.libs.net.RequestClient
import com.che2n3jigw.android.libs.net.bean.RequestResult
import com.che2n3jigw.android.libs.net.utils.RequestUtils
import com.che2n3jigw.android.libs.opensubsonicapi.bean.AutoInfo
import com.che2n3jigw.android.libs.opensubsonicapi.response.BaseResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.system.LicenseResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.system.PingResponse
import retrofit2.http.GET

/**
 * Subsonic System API 远程库
 */
class SystemRepository(
    private val baseUrl: String,
    authInfo: AutoInfo,
    private val enableLogging: Boolean = true
) : BaseRepository(authInfo) {

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