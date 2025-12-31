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

import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.DiscTitle
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.ItemDate
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.RecordLabel
import kotlinx.serialization.Serializable

@Serializable
data class AlbumID3WithSongs(
    /**
     * The id of the album
     */
    val id: String? = null,

    /**
     * The name of the album
     */
    val name: String? = null,

    /**
     * he album version name
     */
    val version: String? = null,

    /**
     * Artist name.
     */
    val artist: String? = null,

    /**
     * The id of the artist
     */
    val artistId: String? = null,

    /**
     * A covertArt id.
     */
    val coverArt: String? = null,

    /**
     * Number of songs
     */
    val songCount: Int? = null,

    /**
     * Total duration of the album in seconds
     */
    val duration: Int? = null,

    /**
     * Number of play of the album
     */
    val playCount: Int? = null,

    /**
     * Date the album was added.
     */
    val created: String? = null,

    /**
     * Date the album was added.
     */
    val starred: String? = null,

    /**
     * The album year
     */
    val year: Int? = null,

    /**
     * The album genre
     */
    val genre: String? = null,

    /**
     * Date the album was last played.
     */
    val played: String? = null,

    /**
     * The user rating of the album. [1-5]
     */
    val userRating: Int? = null,

    /**
     * 负责发行这张专辑的唱片公司。
     */
    val recordLabels: List<RecordLabel>? = null,

    /**
     * The album MusicBrainzID.
     */
    val musicBrainzId: String? = null,

    /**
     * The list of all genres of the album.
     */
    val genres: List<ItemGenre>? = null,

    /**
     * The list of all album artists of the album.
     */
    val artists: List<ArtistID3>? = null,

    /**
     * The single value display artist.
     */
    val displayArtist: String? = null,

    /**
     * The types of this album release.
     */
    val releaseTypes: List<String>? = null,

    /**
     * The list of all moods of the album.
     */
    val moods: List<String>? = null,

    /**
     * The album sort name.
     */
    val sortName: String? = null,

    /**
     * Date the album was originally released.
     */
    val originalReleaseDate: ItemDate? = null,

    /**
     * Date the specific edition of the album was released. Note: for files using ID3 tags,
     * releaseDate should generally be read from the TDRL tag. Servers that use a different source for this field should document the behavior.
     */
    val releaseDate: ItemDate? = null,

    /**
     * True if the album is a compilation.
     */
    val isCompilation: Boolean? = null,

    /**
     * Returns “explicit”, “clean” or “”.
     */
    val explicitStatus: String? = null,

    /**
     * The list of all disc titles of the album.
     */
    val discTitles: List<DiscTitle>? = null,

    /**
     * The list of songs
     */
    val song: List<Child>? = null
)