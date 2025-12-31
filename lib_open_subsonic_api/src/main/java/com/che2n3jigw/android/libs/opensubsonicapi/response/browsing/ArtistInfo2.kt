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
package com.che2n3jigw.android.libs.opensubsonicapi.response.browsing

import com.che2n3jigw.android.libs.opensubsonicapi.response.common.ArtistID3
import kotlinx.serialization.Serializable

/**
 * Artist info.
 */
@Serializable
data class ArtistInfo2(
    /**
     * Artist biography
     */
    val biography: String? = null,
    /**
     * Artist musicBrainzId
     */
    val musicBrainzId: String? = null,
    /**
     * Artist lastFmUrl
     */
    val lastFmUrl: String? = null,
    /**
     * Artist smallImageUrl
     */
    val smallImageUrl: String? = null,
    /**
     * Artist mediumImageUrl
     */
    val mediumImageUrl: String? = null,
    /**
     * Artist largeImageUrl
     */
    val largeImageUrl: String? = null,
    /**
     * Similar artists
     */
    val similarArtist: List<ArtistID3>? = null
)