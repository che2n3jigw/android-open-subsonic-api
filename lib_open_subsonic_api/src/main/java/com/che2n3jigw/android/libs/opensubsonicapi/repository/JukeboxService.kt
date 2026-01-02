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
import com.che2n3jigw.android.libs.opensubsonicapi.response.jukebox.JukeboxControlSuccessResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface JukeboxService {

    /**
     * Controls the jukebox, i.e., playback directly on the server’s audio hardware. Note: The user must be authorized to control the jukebox (see Settings > Users > User is allowed to play files in jukebox mode).
     */
    @GET("/rest/jukeboxControl")
    suspend fun jukeboxControl(
        @Query("action") action: String,
        @Query("index") index: Int? = null,
        @Query("offset") offset: Int? = null,
        @Query("id") id: List<String>? = null,
        @Query("gain") gain: Float? = null
    ): BaseResponse<JukeboxControlSuccessResponse>

}