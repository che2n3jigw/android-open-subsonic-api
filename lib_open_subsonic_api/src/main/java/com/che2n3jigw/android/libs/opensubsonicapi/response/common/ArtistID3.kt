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

package com.che2n3jigw.android.libs.opensubsonicapi.response.common

import kotlinx.serialization.Serializable

/**
 * An artist from ID3 tags.
 */
@Serializable
data class ArtistID3(
    /**
     * The id of the artist
     */
    val id: String? = null,

    /**
     * The artist name.
     */
    val name: String? = null,

    /**
     * A covertArt id.
     */
    val coverArt: String? = null,

    /**
     * An url to an external image source.
     */
    val artistImageUrl: String? = null,

    /**
     * Artist album count.
     */
    val albumCount: Int? = null,

    /**
     * Date the artist was starred.
     */
    val starred: String? = null,

    /**
     * The artist MusicBrainzID.
     */
    val musicBrainzId: String? = null,

    /**
     * The artist sort name.
     */
    val sortName: String? = null,

    /**
     * The list of all roles this artist has in the library.
     */
    val roles: List<String?>? = null
)