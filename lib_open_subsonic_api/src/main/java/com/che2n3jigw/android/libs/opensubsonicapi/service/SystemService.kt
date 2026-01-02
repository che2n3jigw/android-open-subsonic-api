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
// 创建时间： 12/30/25
package com.che2n3jigw.android.libs.opensubsonicapi.service

import com.che2n3jigw.android.libs.opensubsonicapi.response.BaseResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.BaseSubsonicResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.system.GetLicenseResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.system.GetOpenSubsonicExtensionsResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.system.TokenInfoResponse
import retrofit2.http.GET

/**
 * Open Subsonic System API
 */
interface SystemService {

    /**
     * Get details about the software license.
     */
    @GET("/rest/getLicense")
    suspend fun getLicense(): BaseResponse<GetLicenseResponse>

    /**
     * List the OpenSubsonic extensions supported by this server.
     */
    @GET("/rest/getOpenSubsonicExtensions")
    suspend fun getOpenSubsonicExtensions(): BaseResponse<GetOpenSubsonicExtensionsResponse>

    /**
     * Test connectivity with the server.
     */
    @GET("/rest/ping")
    suspend fun ping(): BaseResponse<BaseSubsonicResponse>?

    /**
     * OpenSubsonic extension name apiKeyAuthentication (As returned by getOpenSubsonicExtensions).
     * Returns data about an API key.
     */
    @GET("/rest/tokenInfo")
    suspend fun tokenInfo(): BaseResponse<TokenInfoResponse>
}