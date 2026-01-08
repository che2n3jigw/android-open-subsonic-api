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
// 创建时间： 1/2/26
package com.che2n3jigw.android.libs.opensubsonicapi.datasource

import com.che2n3jigw.android.libs.net.bean.RequestResult
import com.che2n3jigw.android.libs.net.utils.RequestUtils
import com.che2n3jigw.android.libs.opensubsonicapi.bean.AutoInfo
import com.che2n3jigw.android.libs.opensubsonicapi.response.scanning.ScanStatus
import com.che2n3jigw.android.libs.opensubsonicapi.service.MediaLibraryScanningService

class MediaLibraryScanningDataSource(
    baseUrl: String,
    authInfo: AutoInfo,
    enableLogging: Boolean = true
) : BaseDataSource(baseUrl, authInfo, enableLogging) {

    private val service: MediaLibraryScanningService = service()

    /**
     * 获取媒体库扫描状态
     */
    suspend fun getScanStatus(): ScanStatus? {
        val result = RequestUtils.safeApiCall { service.getScanStatus() }
        return when (result) {
            is RequestResult.Success -> result.data.response?.scanStatus
            is RequestResult.Error -> null
        }
    }

    /**
     * 启动媒体库扫描
     */
    suspend fun startScan(): ScanStatus? {
        val result = RequestUtils.safeApiCall { service.startScan() }
        return when (result) {
            is RequestResult.Success -> result.data.response?.scanStatus
            is RequestResult.Error -> null
        }
    }
}