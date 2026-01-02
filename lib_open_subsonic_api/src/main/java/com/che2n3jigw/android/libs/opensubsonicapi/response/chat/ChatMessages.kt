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
package com.che2n3jigw.android.libs.opensubsonicapi.response.chat

import com.che2n3jigw.android.libs.opensubsonicapi.response.Error
import com.che2n3jigw.android.libs.opensubsonicapi.response.ISubsonicResponse
import kotlinx.serialization.Serializable

@Serializable
data class GetChatMessagesResponse(
    override val status: String?,
    override val version: String?,
    override val type: String?,
    override val serverVersion: String?,
    override val openSubsonic: Boolean?,
    override val error: Error?,
    val chatMessages: ChatMessages? = null
) : ISubsonicResponse

@Serializable
data class ChatMessages(
    val chatMessage: List<ChatMessage?>? = null
)

@Serializable
data class ChatMessage(
    val username: String? = null,
    val time: Int? = null,
    val message: String? = null
)