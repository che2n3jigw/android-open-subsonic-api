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
package com.che2n3jigw.android.libs.opensubsonicapi.datasource

import com.che2n3jigw.android.libs.net.bean.RequestResult
import com.che2n3jigw.android.libs.net.utils.RequestUtils
import com.che2n3jigw.android.libs.opensubsonicapi.UnverifiedApi
import com.che2n3jigw.android.libs.opensubsonicapi.bean.AutoInfo
import com.che2n3jigw.android.libs.opensubsonicapi.response.chat.ChatMessages
import com.che2n3jigw.android.libs.opensubsonicapi.service.ChatService

class ChatDataSource(
    baseUrl: String,
    authInfo: AutoInfo,
    enableLogging: Boolean = true
) : BaseDataSource(baseUrl, authInfo, enableLogging) {

    private val service: ChatService = service()

    /**
     * adds a message to the chat log
     * @param message   The chat message
     */
    @UnverifiedApi
    suspend fun createInternetRadioStation(message: String): Boolean {
        val result = RequestUtils.safeApiCall { service.addChatMessage(message) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            // 请求失败
            else -> false
        }
    }

    /**
     * Return the current visible chat messages
     */
    @UnverifiedApi
    suspend fun getChatMessages(): ChatMessages? {
        val result = RequestUtils.safeApiCall { service.getChatMessages() }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.chatMessages
            // 请求失败
            else -> null
        }
    }
}