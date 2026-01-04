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
import com.che2n3jigw.android.libs.opensubsonicapi.bean.AutoInfo
import com.che2n3jigw.android.libs.opensubsonicapi.response.radio.InternetRadioStation
import com.che2n3jigw.android.libs.opensubsonicapi.service.InternetRadioService

class InternetRadioRepository(
    baseUrl: String,
    authInfo: AutoInfo,
    enableLogging: Boolean = true
) : BaseRepository(baseUrl, authInfo, enableLogging) {

    private val service: InternetRadioService = service()

    /**
     * Adds a new internet radio station.
     * @param streamUrl     The stream URL for the station
     * @param name          The station name
     * @param homepageUrl   The home page URL for the station
     */
    suspend fun createInternetRadioStation(
        streamUrl: String,
        name: String,
        homepageUrl: String? = null
    ): Boolean {
        val result = RequestUtils.safeApiCall {
            service.createInternetRadioStation(streamUrl, name, homepageUrl)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            // 请求失败
            else -> false
        }
    }


    /**
     * deletes an existing internet raido station
     * @param id The ID for the station
     */
    suspend fun deleteInternetRadioStation(id: String): Boolean {
        val result = RequestUtils.safeApiCall { service.deleteInternetRadioStation(id) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            // 请求失败
            else -> false
        }
    }


    /**
     * return all internet radio stations
     */
    suspend fun getInternetRadioStations(): List<InternetRadioStation> {
        val result = RequestUtils.safeApiCall { service.getInternetRadioStations() }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                val internetRadioStation =
                    result.data.response?.internetRadioStations?.internetRadioStation
                internetRadioStation?.filterNotNull() ?: emptyList()
            }
            // 请求失败
            else -> emptyList()
        }
    }

    /**
     * return all internet radio stations
     * @param id            The ID of the station
     * @param streamUrl     The stream URL for the station
     * @param name          The user-defined name for the station
     * @param homepageUrl   The home page URL for the station
     */
    suspend fun updateInternetRadioStation(
        id: String,
        streamUrl: String,
        name: String,
        homepageUrl: String? = null
    ): Boolean {
        val result = RequestUtils.safeApiCall {
            service.updateInternetRadioStation(id, streamUrl, name, homepageUrl)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            // 请求失败
            else -> false
        }
    }

}