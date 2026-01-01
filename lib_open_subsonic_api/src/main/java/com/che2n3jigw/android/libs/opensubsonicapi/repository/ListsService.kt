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
package com.che2n3jigw.android.libs.opensubsonicapi.repository

import com.che2n3jigw.android.libs.opensubsonicapi.response.BaseResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.browsing.SongsByGenreResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.lists.GetAlbumList2Response
import com.che2n3jigw.android.libs.opensubsonicapi.response.lists.GetAlbumListResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.lists.GetNowPlayingResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.lists.GetRandomSongsResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.lists.GetStarred2Response
import com.che2n3jigw.android.libs.opensubsonicapi.response.lists.StarredResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Open Subsonic Lists API
 */
interface ListsService {

    /**
     * Returns a list of random, newest, highest rated etc. albums.
     * Similar to the album lists on the home page of the Subsonic web interface.
     */
    @GET("/rest/getAlbumList")
    suspend fun getAlbumList(
        @Query("type") type: String,
        @Query("size") size: Int? = null,
        @Query("offset") offset: Int? = null,
        @Query("fromYear") fromYear: Int? = null,
        @Query("toYear") toYear: Int? = null,
        @Query("genre") genre: String? = null,
        @Query("musicFolderId") musicFolderId: String? = null
    ): BaseResponse<GetAlbumListResponse>

    /**
     * Similar to getAlbumList, but organizes music according to ID3 tags.
     */
    @GET("/rest/getAlbumList2")
    suspend fun getAlbumList2(
        @Query("type") type: String,
        @Query("size") size: Int? = null,
        @Query("offset") offset: Int? = null,
        @Query("fromYear") fromYear: Int? = null,
        @Query("toYear") toYear: Int? = null,
        @Query("genre") genre: String? = null,
        @Query("musicFolderId") musicFolderId: String? = null
    ): BaseResponse<GetAlbumList2Response>

    /**
     * Returns what is currently being played by all users. Takes no extra parameters.
     */
    @GET("/rest/getNowPlaying")
    suspend fun getNowPlaying(): BaseResponse<GetNowPlayingResponse>

    /**
     * Returns random songs matching the given criteria.
     */
    @GET("/rest/getRandomSongs")
    suspend fun getRandomSongs(
        @Query("size") size: Int? = null,
        @Query("genre") genre: String? = null,
        @Query("fromYear") fromYear: Int? = null,
        @Query("toYear") toYear: Int? = null,
        @Query("musicFolderId") musicFolderId: String? = null
    ): BaseResponse<GetRandomSongsResponse>

    /**
     * Returns songs in a given genre.
     */
    @GET("/rest/getSongsByGenre")
    suspend fun getSongsByGenre(
        @Query("genre") genre: String,
        @Query("count") count: Int? = null,
        @Query("offset") offset: Int? = null,
        @Query("musicFolderId") musicFolderId: String? = null
    ): BaseResponse<SongsByGenreResponse>

    /**
     * Returns starred songs, albums and artists.
     */
    @GET("/rest/getStarred")
    suspend fun getStarred(@Query("musicFolderId") musicFolderId: String? = null): BaseResponse<StarredResponse>

    /**
     * Similar to getStarred, but organizes music according to ID3 tags.
     */
    @GET("/rest/getStarred2")
    suspend fun getStarred2(@Query("musicFolderId") musicFolderId: String? = null): BaseResponse<GetStarred2Response>

}