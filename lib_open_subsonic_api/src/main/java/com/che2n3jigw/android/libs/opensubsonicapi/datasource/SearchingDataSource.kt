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
// 创建时间： 1/2/26
package com.che2n3jigw.android.libs.opensubsonicapi.datasource

import com.che2n3jigw.android.libs.net.bean.RequestResult
import com.che2n3jigw.android.libs.net.utils.RequestUtils
import com.che2n3jigw.android.libs.opensubsonicapi.bean.AutoInfo
import com.che2n3jigw.android.libs.opensubsonicapi.response.searching.SearchResult2
import com.che2n3jigw.android.libs.opensubsonicapi.response.searching.SearchResult3
import com.che2n3jigw.android.libs.opensubsonicapi.service.SearchingService

class SearchingDataSource(
    baseUrl: String,
    authInfo: AutoInfo,
    enableLogging: Boolean = true
) : BaseDataSource(baseUrl, authInfo, enableLogging) {

    private val service: SearchingService = service()

    /**
     * 返回符合给定搜索条件的专辑、艺术家和歌曲。
     * 支持对结果进行分页。
     */
    suspend fun search2(
        query: String,
        artistCount: Long? = null,
        artistOffset: Long? = null,
        albumCount: Long? = null,
        songCount: Long? = null,
        songOffset: Long? = null,
        musicFolderId: String? = null
    ): SearchResult2? {
        val result = RequestUtils.safeApiCall {
            service.search2(
                query, artistCount, artistOffset, albumCount, songCount, songOffset, musicFolderId
            )
        }
        return when (result) {
            is RequestResult.Success -> result.data.response?.searchResult2
            is RequestResult.Error -> null
        }
    }

    /**
     * 返回符合给定搜索条件的专辑、艺术家和歌曲。
     * 支持分页浏览结果。
     * 音乐按 ID3 标签分类。
     */
    suspend fun search3(
        query: String,
        artistCount: Long? = null,
        artistOffset: Long? = null,
        albumCount: Long? = null,
        songCount: Long? = null,
        songOffset: Long? = null,
        musicFolderId: String? = null
    ): SearchResult3? {
        val result = RequestUtils.safeApiCall {
            service.search3(
                query, artistCount, artistOffset, albumCount, songCount, songOffset, musicFolderId
            )
        }
        return when (result) {
            is RequestResult.Success -> result.data.response?.searchResult3
            is RequestResult.Error -> null
        }
    }
}