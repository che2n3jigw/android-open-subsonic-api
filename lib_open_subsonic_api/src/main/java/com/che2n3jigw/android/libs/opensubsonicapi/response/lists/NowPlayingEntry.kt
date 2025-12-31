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
package com.che2n3jigw.android.libs.opensubsonicapi.response.lists

import com.che2n3jigw.android.libs.opensubsonicapi.response.common.ArtistID3
import com.che2n3jigw.android.libs.opensubsonicapi.response.common.Contributor
import com.che2n3jigw.android.libs.opensubsonicapi.response.common.ItemGenre
import com.che2n3jigw.android.libs.opensubsonicapi.response.common.ReplayGain
import kotlinx.serialization.Serializable

@Serializable
data class NowPlayingEntry(
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
    val size: Long? = null,
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
     * The duration of the media in seconds.
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
     * The sampling rate of the media.
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
     * The average rating of the media [1.0-5.0]
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
     * The generic type of media [music/podcast/audiobook/video]
     * [com.che2n3jigw.android.libs.opensubsonicapi.bean.GenericMediaType]
     */
    val type: String? = null,
    /**
     * Note: If you support musicBrainzId you must support this field to ensure clients knows what the ID refers to.
     * [com.che2n3jigw.android.libs.opensubsonicapi.bean.MediaType]
     */
    val mediaType: String? = null,
    /**
     * The bookmark position in seconds
     */
    val bookmarkPosition: Long? = null,
    /**
     * The video original Width
     */
    val originalWidth: Long? = null,
    /**
     * The video original Height
     */
    val originalHeight: Long? = null,
    /**
     * Date the album was last played.
     */
    val played: String? = null,
    /**
     * The BPM of the song.
     */
    val bpm: Long? = null,
    /**
     * The comment tag of the song.
     */
    val comment: String? = null,
    /**
     * The song sort name.
     */
    val sortName: String? = null,
    /**
     * The track MusicBrainzID.
     */
    val musicBrainzId: String? = null,
    /**
     * The track ISRC(s).
     */
    val isrc: List<String?>? = null,
    /**
     * The list of all genres of the song.
     */
    val genres: List<ItemGenre?>? = null,
    /**
     * The list of all song artists of the song.
     * (Note: Only the required ArtistID3 fields should be returned by default)
     */
    val artists: List<ArtistID3?>? = null,
    /**
     * The single value display artist.
     */
    val displayArtist: String? = null,
    /**
     * The list of all album artists of the song.
     * (Note: Only the required ArtistID3 fields should be returned by default)
     */
    val albumArtists: List<ArtistID3?>? = null,
    /**
     * The single value display album artist.
     */
    val displayAlbumArtist: String? = null,
    /**
     * The list of all contributor artists of the song.
     */
    val contributors: List<Contributor?>? = null,
    /**
     * The single value display composer.
     */
    val displayComposer: String? = null,
    /**
     * The list of all moods of the song.
     */
    val moods: List<String?>? = null,
    /**
     * The replay gain data of the song.
     */
    val replayGain: ReplayGain? = null,
    /**
     * [com.che2n3jigw.android.libs.opensubsonicapi.bean.ExplicitStatus]
     */
    val explicitStatus: String? = null,
    /**
     * The username
     */
    val username: String? = null,
    /**
     * Last update
     */
    val minutesAgo: Long? = null,
    /**
     * Player Id
     */
    val playerId: Long? = null,
    /**
     * Player name
     */
    val playerName: String? = null
)