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
// 创建时间： 12/26/25
package com.che2n3jigw.android.libs.subsonicapi.response.browsing

import com.che2n3jigw.android.libs.subsonicapi.response.ISubsonicResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideosResponse(
    override val status: String?,
    override val version: String?,
    val videos: Videos? = null
) : ISubsonicResponse {

    @Serializable
    data class Videos(
        val video: List<Video?>? = null
    )

    @Serializable
    data class Video(
        val id: String? = null,
        val parent: String? = null,
        val title: String? = null,
        val album: String? = null,
        val isDir: Boolean? = null,
        val coverArt: String? = null,
        val created: String? = null,
        val duration: Int? = null,
        val bitRate: Int? = null,
        val size: Int? = null,
        val suffix: String? = null,
        val contentType: String? = null,
        val isVideo: Boolean? = null,
        val path: String? = null,
        @SerialName("transcodedSuffix")
        val transCodedSuffix: String? = null,
        @SerialName("transcodedContentType")
        val transCodedContentType: String? = null
    )
}