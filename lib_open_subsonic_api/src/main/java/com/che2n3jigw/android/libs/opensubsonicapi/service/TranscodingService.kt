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
package com.che2n3jigw.android.libs.opensubsonicapi.service

import com.che2n3jigw.android.libs.opensubsonicapi.response.transcoding.ClientInfo
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Open Subsonic Transcoding API
 */
interface TranscodingService {
    /**
     * Returns a transcode decision for a given media file.
     */
    @POST("/rest/getTranscodeDecision")
    suspend fun getTranscodeDecision(
        @Query("mediaId") mediaId: String,
        @Query("mediaType") mediaType: String
    ): ClientInfo


    /**
     * Returns a transcoded media stream. Clients should not try to reconstruct the transcodeParams.
     * Instead, they must use the transcodeParams provided in the response of the getTranscodeDecision endpoint.
     */
    @GET("/rest/getTranscodeStream")
    suspend fun getTranscodeStream(
        @Query("mediaId") mediaId: String,
        @Query("mediaType") mediaType: String,
        @Query("offset") offset: Long? = null,
        @Query("transcodeParams ") transcodeParams: String? = null
    ): String
}