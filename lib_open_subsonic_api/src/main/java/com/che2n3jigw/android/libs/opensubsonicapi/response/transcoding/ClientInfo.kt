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
package com.che2n3jigw.android.libs.opensubsonicapi.response.transcoding

import kotlinx.serialization.Serializable

@Serializable
data class ClientInfo(
    val name: String? = null,
    val platform: String? = null,
    val maxAudioBitrate: Int? = null,
    val maxTranscodingAudioBitrate: Int? = null,
    val directPlayProfiles: List<DirectPlayProfile?>? = null,
    val transcodingProfiles: List<TranscodingProfile?>? = null,
    val codecProfiles: List<CodecProfile?>? = null
)

@Serializable
data class DirectPlayProfile(
    val containers: List<String?>? = null,
    val audioCodecs: List<String?>? = null,
    val protocols: List<String?>? = null,
    val maxAudioChannels: Int? = null
)

@Serializable
data class TranscodingProfile(
    val container: String? = null,
    val audioCodec: String? = null,
    val protocol: String? = null,
    val maxAudioChannels: Int? = null
)

@Serializable
data class CodecProfile(
    val type: String? = null,
    val name: String? = null,
    val limitations: List<Limitation?>? = null
)

@Serializable
data class Limitation(
    val name: String? = null,
    val comparison: String? = null,
    val values: List<String?>? = null,
    val required: Boolean? = null
)