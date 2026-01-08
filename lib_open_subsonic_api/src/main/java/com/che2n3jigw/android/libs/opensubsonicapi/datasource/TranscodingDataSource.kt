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
// 创建时间： 1/5/26
package com.che2n3jigw.android.libs.opensubsonicapi.datasource

import com.che2n3jigw.android.libs.net.bean.RequestResult
import com.che2n3jigw.android.libs.net.utils.RequestUtils
import com.che2n3jigw.android.libs.opensubsonicapi.UnverifiedApi
import com.che2n3jigw.android.libs.opensubsonicapi.bean.AutoInfo
import com.che2n3jigw.android.libs.opensubsonicapi.response.transcoding.ClientInfo
import com.che2n3jigw.android.libs.opensubsonicapi.service.TranscodingService
import okhttp3.ResponseBody
import retrofit2.Response

class TranscodingDataSource(
    baseUrl: String,
    authInfo: AutoInfo,
    enableLogging: Boolean = true
) : BaseDataSource(baseUrl, authInfo, enableLogging) {

    private val service: TranscodingService = service()

    /**
     * get Transcode Decision
     * @param mediaId   The ID of the media
     * @param mediaType The type of the media [song,podcast]
     */
    @UnverifiedApi
    suspend fun getTranscodeDecision(
        mediaId: String,
        mediaType: String
    ): ClientInfo? {
        val result = RequestUtils.safeApiCall { service.getTranscodeDecision(mediaId, mediaType) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data
            // 请求失败
            else -> null
        }
    }

    /**
     * get Transcode Decision
     * @param mediaId           The ID of the media
     * @param mediaType         The type of the media [song,podcast]
     * @param offset            The time offset in seconds from which to start transcoding,default 0
     * @param transcodeParams   Server-specific transcoding parameters.This should be obtained from the getTranscodeDecision endpoint.
     */
    @UnverifiedApi
    suspend fun getTranscodeStream(
        mediaId: String,
        mediaType: String,
        offset: Long = 0L,
        transcodeParams: String = "transcodeParams"
    ): Response<ResponseBody>? {
        return try {
            service.getTranscodeStream(
                mediaId,
                mediaType,
                offset,
                transcodeParams
            )
        } catch (e: Exception) {
            null
        }
    }
}