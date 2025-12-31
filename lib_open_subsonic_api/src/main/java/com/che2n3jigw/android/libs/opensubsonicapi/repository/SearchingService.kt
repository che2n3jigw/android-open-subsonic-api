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
import com.che2n3jigw.android.libs.opensubsonicapi.response.searching.SearchResult2Response
import com.che2n3jigw.android.libs.opensubsonicapi.response.searching.SearchResult3Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * open subsonic searching api
 */
interface SearchingService {
    /**
     * Returns albums, artists and songs matching the given search criteria.
     * Supports paging through the result.
     */
    @GET("/rest/search2")
    suspend fun search2(
        @Query("query") query: String,
        @Query("artistCount") artistCount: Long,
        @Query("artistOffset") artistOffset: Long,
        @Query("albumCount") albumCount: Long,
        @Query("songCount") songCount: Long,
        @Query("songOffset") songOffset: Long,
        @Query("musicFolderId") musicFolderId: String
    ): BaseResponse<SearchResult2Response>

    /**
     * Returns albums, artists and songs matching the given search criteria.
     * Supports paging through the result.
     *
     * Music is organized according to ID3 tags.
     */
    @GET("/rest/search3")
    suspend fun search3(
        @Query("query") query: String,
        @Query("artistCount") artistCount: Long,
        @Query("artistOffset") artistOffset: Long,
        @Query("albumCount") albumCount: Long,
        @Query("songCount") songCount: Long,
        @Query("songOffset") songOffset: Long,
        @Query("musicFolderId") musicFolderId: String
    ): BaseResponse<SearchResult3Response>
}