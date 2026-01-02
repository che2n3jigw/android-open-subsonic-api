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

package com.che2n3jigw.android.libs.opensubsonicapi.response.podcast

import com.che2n3jigw.android.libs.opensubsonicapi.response.common.ArtistID3
import com.che2n3jigw.android.libs.opensubsonicapi.response.common.Contributor
import com.che2n3jigw.android.libs.opensubsonicapi.response.common.ItemGenre
import com.che2n3jigw.android.libs.opensubsonicapi.response.common.ReplayGain
import kotlinx.serialization.Serializable

@Serializable
data class PodcastEpisode(
    /**
     * The id of the media.
     */
    val id: String? = null,
    /**
     * The id of the parent (folder/album)
     */
    val parent: String? = null,
    /**
     * The media is a directory
     */
    val isDir: Boolean? = null,
    /**
     * The media name.
     */
    val title: String? = null,
    /**
     * The album name.
     */
    val album: String? = null,
    /**
     * The artist name.
     */
    val artist: String? = null,
    /**
     * The track number.
     */
    val track: Int? = null,
    /**
     * The media year.
     */
    val year: Int? = null,
    /**
     * The media genre
     */
    val genre: String? = null,
    /**
     * The coverArt id.
     */
    val coverArt: String? = null,
    /**
     * A file size of the media.
     */
    val size: Int? = null,
    /**
     * The mimeType of the media.
     */
    val contentType: String? = null,
    /**
     * The file suffix of the media.
     */
    val suffix: String? = null,
    /**
     * The transcoded mediaType if transcoding should happen.
     */
    val transcodedContentType: String? = null,
    /**
     * The file suffix of the transcoded media.
     */
    val transcodedSuffix: String? = null,
    /**
     * The duration of the media in seconds
     */
    val duration: Int? = null,
    /**
     * The bitrate of the media.
     */
    val bitRate: Int? = null,
    /**
     * The bit depth of the media.
     */
    val bitDepth: Int? = null,
    /**
     * The sample rate of the media.
     */
    val samplingRate: Int? = null,
    /**
     * The number of channels of the media.
     */
    val channelCount: Int? = null,
    /**
     * The full path of the media.
     */
    val path: String? = null,
    /**
     * Media is a video
     */
    val isVideo: Boolean? = null,
    /**
     * The user rating of the media [1-5]
     */
    val userRating: Int? = null,
    /**
     * The average rating of the media [1.null-5.null]
     */
    val averageRating: Int? = null,
    /**
     * The play count.
     */
    val playCount: Int? = null,
    /**
     * The disc number.
     */
    val discNumber: Int? = null,
    /**
     * Date the media was created.
     */
    val created: String? = null,
    /**
     * Date the media was starred.
     */
    val starred: String? = null,
    /**
     * The corresponding album id
     */
    val albumId: String? = null,
    /**
     * The corresponding artist id
     */
    val artistId: String? = null,
    /**
     * [com.che2n3jigw.android.libs.opensubsonicapi.bean.GenericMediaType]
     */
    val type: String? = null,
    /**
     * [com.che2n3jigw.android.libs.opensubsonicapi.bean.MediaType]
     */
    val mediaType: String? = null,
    /**
     * The bookmark position in seconds
     */
    val bookmarkPosition: Int? = null,
    /**
     * The video original Width
     */
    val originalWidth: Int? = null,
    /**
     * The video original Height
     */
    val originalHeight: Int? = null,
    /**
     * Date the album was last played. [ISO 8601]
     */
    val played: String? = null,
    /**
     * The BPM of the song.
     */
    val bpm: Int? = null,
    /**
     * The comment tag of the song.
     */
    val comment: String? = null,
    /**
     * The song sort name.
     */
    val sortName: String? = null,
    val musicBrainzId: String? = null,
    val isrc: List<String>? = null,
    val genres: List<ItemGenre>? = null,
    val artists: List<ArtistID3>? = null,
    val displayArtist: String? = null,
    val albumArtists: List<ArtistID3>? = null,
    val displayAlbumArtist: String? = null,
    val contributors: List<Contributor>? = null,
    val displayComposer: String? = null,
    val moods: List<String>? = null,
    val replayGain: ReplayGain? = null,
    val explicitStatus: String? = null,
    val streamId: String? = null,
    val channelId: String? = null,
    val description: String? = null,
    val status: String? = null,
    val publishDate: String? = null
)