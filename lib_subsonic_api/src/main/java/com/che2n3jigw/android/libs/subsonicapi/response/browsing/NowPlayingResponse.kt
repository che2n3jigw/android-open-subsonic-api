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
// 创建时间： 12/27/25
package com.che2n3jigw.android.libs.subsonicapi.response.browsing

import com.che2n3jigw.android.libs.subsonicapi.response.ISubsonicResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NowPlayingResponse(
    override val status: String?,
    override val version: String?,
    val nowPlaying: NowPlaying? = null
) : ISubsonicResponse {

    @Serializable
    data class NowPlaying(
        val entry: List<Entry?>? = null
    )

    @Serializable
    data class Entry(
        val username: String? = null,
        val minutesAgo: Int? = null,
        val playerId: Int? = null,
        val playerName: String? = null,
        val id: String? = null,
        val parent: String? = null,
        val title: String? = null,
        val isDir: Boolean? = null,
        val album: String? = null,
        val artist: String? = null,
        val track: Int? = null,
        val year: String? = null,
        val genre: String? = null,
        val coverArt: String? = null,
        val size: Long? = null,
        val contentType: String? = null,
        val suffix: String? = null,
        @SerialName("transcodedContentType")
        val transCodedContentType: String? = null,
        @SerialName("transcodedSuffix")
        val transCodedSuffix: String? = null,
        val path: String? = null,
    )
}