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
// 创建时间： 12/31/25
package com.che2n3jigw.android.libs.opensubsonicapi.response.retrieval

import kotlinx.serialization.Serializable

/**
 * Structured lyrics
 */
@Serializable
data class StructuredLyric(
    val lang: String? = null,
    /**
     * True if the lyrics are synced, false otherwise
     */
    val synced: Boolean? = null,
    /**
     * The actual lyrics. Ordered by start time (synced) or appearance order (unsynced)
     */
    val line: List<Line?>? = null,
    /**
     * The artist name to display. This could be the localized name, or any other value
     */
    val displayArtist: String? = null,
    /**
     * The title to display. This could be the song title (localized), or any other value
     */
    val displayTitle: String? = null,
    /**
     * 	number
     * The offset to apply to all lyrics, in milliseconds.
     * Positive means lyrics appear sooner, negative means later. If not included, the offset must be assumed to be 0
     */
    val offset: Int? = null
)