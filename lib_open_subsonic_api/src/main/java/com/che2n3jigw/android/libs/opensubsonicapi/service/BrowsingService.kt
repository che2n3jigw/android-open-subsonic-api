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
// 创建时间： 12/28/25
package com.che2n3jigw.android.libs.opensubsonicapi.service

import com.che2n3jigw.android.libs.opensubsonicapi.response.BaseResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.GetAlbumInfoResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.GetAlbumResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.GetArtistInfo2Response
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.GetArtistInfoResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.GetArtistResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.GetArtistsResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.GetGenresResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.GetIndexesResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.GetMusicDirectoryResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.GetMusicFoldersResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.GetSimilarSongs2Response
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.GetSimilarSongsResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.GetSongResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.GetTopSongsResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.GetVideoInfoResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.GetVideosResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Open Subsonic Browsing API
 */
interface BrowsingService {
    /**
     * Returns details for an album, including a list of songs. This method organizes music according to ID3 tags.
     */
    @GET("/rest/getAlbum")
    suspend fun getAlbum(@Query("id") id: String): BaseResponse<GetAlbumResponse>

    /**
     * Returns album notes, image URLs etc, using data from last.fm.
     */
    @GET("/rest/getAlbumInfo")
    suspend fun getAlbumInfo(@Query("id") id: String): BaseResponse<GetAlbumInfoResponse>

    /**
     * Similar to getAlbumInfo, but organizes music according to ID3 tags.
     */
    @GET("/rest/getAlbumInfo2")
    suspend fun getAlbumInfo2(@Query("id") id: String): BaseResponse<GetAlbumInfoResponse>

    /**
     * Returns details for an artist, including a list of albums. This method organizes music according to ID3 tags.
     */
    @GET("/rest/getArtist")
    suspend fun getArtist(@Query("id") id: String): BaseResponse<GetArtistResponse>

    /**
     * Returns album notes, image URLs etc, using data from last.fm.
     */
    @GET("/rest/getArtistInfo")
    suspend fun getArtistInfo(
        @Query("id") id: String,
        @Query("count") count: Int? = null,
        @Query("includeNotPresent") includeNotPresent: Boolean? = null
    ): BaseResponse<GetArtistInfoResponse>

    /**
     * Similar to getAlbumInfo, but organizes music according to ID3 tags.
     */
    @GET("/rest/getArtistInfo2")
    suspend fun getArtistInfo2(
        @Query("id") id: String,
        @Query("count") count: Int? = null,
        @Query("includeNotPresent") includeNotPresent: Boolean? = null
    ): BaseResponse<GetArtistInfo2Response>

    /**
     * Returns details for an artist, including a list of albums. This method organizes music according to ID3 tags.
     */
    @GET("/rest/getArtists")
    suspend fun getArtists(@Query("musicFolderId") musicFolderId: String? = null): BaseResponse<GetArtistsResponse>

    /**
     * Returns all genres.
     */
    @GET("/rest/getGenres")
    suspend fun getGenres(): BaseResponse<GetGenresResponse>

    /**
     * Returns an indexed structure of all artists.
     */
    @GET("/rest/getIndexes")
    suspend fun getIndexes(
        @Query("musicFolderId") musicFolderId: String? = null,
        @Query("ifModifiedSince") ifModifiedSince: Long? = null
    ): BaseResponse<GetIndexesResponse>

    /**
     * Returns a listing of all files in a music directory.
     * Typically used to get list of albums for an artist, or list of songs for an album.
     */
    @GET("/rest/getMusicDirectory")
    suspend fun getMusicDirectory(@Query("id") id: String): BaseResponse<GetMusicDirectoryResponse>

    /**
     * Returns all configured top-level music folders. Takes no extra parameters.
     */
    @GET("/rest/getMusicFolders")
    suspend fun getMusicFolders(): BaseResponse<GetMusicFoldersResponse>

    /**
     * Returns a random collection of songs from the given artist and similar artists, using data from last.fm.
     * Typically used for artist radio features.
     */
    @GET("/rest/getSimilarSongs")
    suspend fun getSimilarSongs(
        @Query("id") id: String,
        @Query("count") count: Int? = null
    ): BaseResponse<GetSimilarSongsResponse>

    /**
     * Similar to getSimilarSongs, but organizes music according to ID3 tags.
     */
    @GET("/rest/getSimilarSongs2")
    suspend fun getSimilarSongs2(
        @Query("id") id: String,
        @Query("count") count: Int? = null
    ): BaseResponse<GetSimilarSongs2Response>

    /**
     * Returns details for a song.
     */
    @GET("/rest/getSong")
    suspend fun getSong(@Query("id") id: String): BaseResponse<GetSongResponse>

    /**
     * Returns top songs for the given artist, using data from last.fm.
     */
    @GET("/rest/getTopSongs")
    suspend fun getTopSongs(
        @Query("artist") artist: String,
        @Query("count") count: Int? = null
    ): BaseResponse<GetTopSongsResponse>

    /**
     * Returns details for a video, including information about available audio tracks, subtitles (captions) and conversions.
     */
    @GET("/rest/getVideoInfo")
    suspend fun getVideoInfo(@Query("id") id: String): BaseResponse<GetVideoInfoResponse>

    /**
     * Returns all video files.
     */
    @GET("/rest/getVideos")
    suspend fun getVideos(): BaseResponse<GetVideosResponse>
}