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
// 创建时间： 12/28/25
package com.che2n3jigw.android.libs.subsonicapi.repository

import com.che2n3jigw.android.libs.subsonicapi.response.BaseResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.AlbumInfoResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.AlbumList2Response
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.AlbumListResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.AlbumResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.ArtistInfo2Response
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.ArtistInfoResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.ArtistsResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.GenresResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.IndexesResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.MusicDirectoryResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.MusicFoldersResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.NowPlayingResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.RandomSongsResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.SimilarSongs2Response
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.SimilarSongsResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.SongResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.SongsByGenreResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.Starred2Response
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.StarredResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.TopSongsResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.VideoInfoResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.VideosResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Subsonic Browsing API
 */
interface BrowsingService {
    @GET("/rest/getMusicFolders")
    suspend fun getMusicFolders(): BaseResponse<MusicFoldersResponse>

    @GET("/rest/getIndexes")
    suspend fun getIndexes(
        @Query("musicFolderId") musicFolderId: Int? = null,
        @Query("ifModifiedSince") ifModifiedSince: Long? = null
    ): BaseResponse<IndexesResponse>

    @GET("/rest/getMusicDirectory")
    suspend fun getMusicDirectory(@Query("id") id: String): BaseResponse<MusicDirectoryResponse>

    @GET("/rest/getGenres")
    suspend fun getGenres(): BaseResponse<GenresResponse>

    @GET("/rest/getArtists")
    suspend fun getArtists(@Query("musicFolderId") musicFolderId: Long? = null): BaseResponse<ArtistsResponse>

    @GET("/rest/getAlbum")
    suspend fun getAlbum(@Query("id") id: String): BaseResponse<AlbumResponse>

    @GET("/rest/getSong")
    suspend fun getSong(@Query("id") id: String): BaseResponse<SongResponse>

    @GET("/rest/getVideos")
    suspend fun getVideos(): BaseResponse<VideosResponse>

    @GET("/rest/getVideoInfo")
    suspend fun getVideoInfo(@Query("id") id: String): BaseResponse<VideoInfoResponse>

    @GET("/rest/getArtistInfo")
    suspend fun getArtistInfo(
        @Query("id") id: String,
        @Query("count") count: Int,
        @Query("includeNotPresent") includeNotPresent: Boolean
    ): BaseResponse<ArtistInfoResponse>

    @GET("/rest/getArtistInfo2")
    suspend fun getArtistInfo2(
        @Query("id") id: String,
        @Query("count") count: Int,
        @Query("includeNotPresent") includeNotPresent: Boolean
    ): BaseResponse<ArtistInfo2Response>

    @GET("/rest/getAlbumInfo")
    suspend fun getAlbumInfo(@Query("id") id: String): BaseResponse<AlbumInfoResponse>

    @GET("/rest/getAlbumInfo2")
    suspend fun getAlbumInfo2(@Query("id") id: String): BaseResponse<AlbumInfoResponse>

    @GET("/rest/getSimilarSongs")
    suspend fun getSimilarSongs(
        @Query("id") id: String,
        @Query("count") count: Int
    ): BaseResponse<SimilarSongsResponse>

    @GET("/rest/getSimilarSongs2")
    suspend fun getSimilarSongs2(
        @Query("id") id: String,
        @Query("count") count: Int
    ): BaseResponse<SimilarSongs2Response>

    @GET("/rest/getTopSongs")
    suspend fun getTopSongs(
        @Query("artist") artist: String,
        @Query("count") count: Int
    ): BaseResponse<TopSongsResponse>

    @GET("/rest/getAlbumList")
    suspend fun getAlbumList(
        @Query("type") type: String,
        @Query("size") size: Int,
        @Query("offset") offset: Int,
        @Query("fromYear") fromYear: Int? = null,
        @Query("toYear") toYear: Int? = null,
        @Query("genre") genre: String? = null,
        @Query("musicFolderId") musicFolderId: Long? = null
    ): BaseResponse<AlbumListResponse>

    @GET("/rest/getAlbumList2")
    suspend fun getAlbumList2(
        @Query("type") type: String,
        @Query("size") size: Int,
        @Query("offset") offset: Int,
        @Query("fromYear") fromYear: Int? = null,
        @Query("toYear") toYear: Int? = null,
        @Query("genre") genre: String? = null,
        @Query("musicFolderId") musicFolderId: Long? = null
    ): BaseResponse<AlbumList2Response>

    @GET("/rest/getRandomSongs")
    suspend fun getRandomSongs(
        @Query("size") size: Int,
        @Query("genre") genre: String? = null,
        @Query("fromYear") fromYear: Int? = null,
        @Query("toYear") toYear: Int? = null,
        @Query("musicFolderId") musicFolderId: Long? = null
    ): BaseResponse<RandomSongsResponse>

    @GET("/rest/getSongsByGenre")
    suspend fun getSongsByGenre(
        @Query("genre") genre: String,
        @Query("count") count: Int,
        @Query("offset") offset: Int? = null,
        @Query("musicFolderId") musicFolderId: Long? = null
    ): BaseResponse<SongsByGenreResponse>


    @GET("/rest/getNowPlaying")
    suspend fun getNowPlaying(): BaseResponse<NowPlayingResponse>

    @GET("/rest/getStarred")
    suspend fun getStarred(@Query("musicFolderId") musicFolderId: Long? = null): BaseResponse<StarredResponse>

    @GET("/rest/getStarred2")
    suspend fun getStarred2(@Query("musicFolderId") musicFolderId: Long? = null): BaseResponse<Starred2Response>
}