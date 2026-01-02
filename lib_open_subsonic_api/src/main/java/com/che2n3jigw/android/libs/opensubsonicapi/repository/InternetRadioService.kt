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
package com.che2n3jigw.android.libs.opensubsonicapi.repository

import com.che2n3jigw.android.libs.opensubsonicapi.response.BaseResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.common.SubsonicResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.radio.GetInternetRadioStationsResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Open Subsonic Internet Radio API
 */
interface InternetRadioService {

    /**
     * Adds a new internet radio station. Only users with admin privileges are allowed to call this method.
     */
    @GET("/rest/createInternetRadioStation")
    suspend fun createInternetRadioStation(
        @Query("streamUrl") streamUrl: String,
        @Query("name") name: String,
        @Query("homepageUrl") homepageUrl: String? = null
    ): BaseResponse<SubsonicResponse>

    /**
     * Deletes an existing internet radio station. Only users with admin privileges are allowed to call this method.
     */
    @GET("/rest/deleteInternetRadioStation")
    suspend fun deleteInternetRadioStation(@Query("id") id: String): BaseResponse<SubsonicResponse>

    /**
     * Returns all internet radio stations. Takes no extra parameters.
     */
    @GET("/rest/getInternetRadioStations")
    suspend fun getInternetRadioStations(): BaseResponse<GetInternetRadioStationsResponse>

    /**
     * Updates an existing internet radio station. Only users with admin privileges are allowed to call this method.
     */
    @GET("/rest/updateInternetRadioStation")
    suspend fun updateInternetRadioStation(
        @Query("id") id: String,
        @Query("streamUrl") streamUrl: String,
        @Query("name") name: String,
        @Query("homepageUrl") homepageUrl: String? = null
    ): BaseResponse<SubsonicResponse>
}