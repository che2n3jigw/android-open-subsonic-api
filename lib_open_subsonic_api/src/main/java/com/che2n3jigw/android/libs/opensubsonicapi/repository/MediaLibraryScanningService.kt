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
import com.che2n3jigw.android.libs.opensubsonicapi.response.scanning.GetScanStatusResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.scanning.StartScanStatusResponse
import retrofit2.http.GET

/**
 * open subsonic media library scanning api
 */
interface MediaLibraryScanningService {
    /**
     * Returns the current status for media library scanning. Takes no extra parameters.
     */
    @GET("/rest/getScanStatus")
    suspend fun getScanStatus(): BaseResponse<GetScanStatusResponse>

    /**
     * Initiates a rescan of the media libraries. Takes no extra parameters.
     */
    @GET("/rest/startScan")
    suspend fun startScan(): BaseResponse<StartScanStatusResponse>
}