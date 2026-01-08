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
// 创建时间： 1/3/26
package com.che2n3jigw.android.libs.opensubsonicapi.datasource

import com.che2n3jigw.android.libs.net.bean.RequestResult
import com.che2n3jigw.android.libs.net.utils.RequestUtils
import com.che2n3jigw.android.libs.opensubsonicapi.UnverifiedApi
import com.che2n3jigw.android.libs.opensubsonicapi.bean.AutoInfo
import com.che2n3jigw.android.libs.opensubsonicapi.response.bookmarks.Bookmarks
import com.che2n3jigw.android.libs.opensubsonicapi.response.bookmarks.PlayQueue
import com.che2n3jigw.android.libs.opensubsonicapi.response.bookmarks.PlayQueueByIndex
import com.che2n3jigw.android.libs.opensubsonicapi.service.BookmarksService

class BookmarksDataSource(
    baseUrl: String,
    authInfo: AutoInfo,
    enableLogging: Boolean = true
) : BaseDataSource(baseUrl, authInfo, enableLogging) {

    private val service: BookmarksService = service()

    /**
     * creates or updates a bookmark
     * @param id        ID of the media file to bookmark. if a bookmark already exists for this file it will be overwritten
     * @param position  The position within the media file
     * @param comment   A user-defined comment
     */
    suspend fun createBookmark(
        id: String,
        position: Long,
        comment: String? = null
    ): Boolean {
        val result = RequestUtils.safeApiCall { service.createBookmark(id, position, comment) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            // 请求失败
            else -> false
        }
    }

    /**
     * Delete a bookmark
     * @param id        ID of the media file to bookmark. if a bookmark already exists for this file it will be overwritten
     */
    suspend fun deleteBookmark(id: String): Boolean {
        val result = RequestUtils.safeApiCall { service.deleteBookmark(id) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            // 请求失败
            else -> false
        }
    }

    /**
     * return all bookmarks for this user
     */
    suspend fun getBookmarks(): Bookmarks? {
        val result = RequestUtils.safeApiCall { service.getBookmarks() }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.bookmarks
            // 请求失败
            else -> null
        }
    }

    /**
     * returns the state of the play queue for this user
     */
    suspend fun getPlayQueue(): PlayQueue? {
        val result = RequestUtils.safeApiCall { service.getPlayQueue() }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.playQueue
            // 请求失败
            else -> null
        }
    }


    /**
     * returns the state of the play queue for this user,using queue index
     */
    @UnverifiedApi
    suspend fun getPlayQueueByIndex(): PlayQueueByIndex? {
        val result = RequestUtils.safeApiCall { service.getPlayQueueByIndex() }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.playQueueByIndex
            // 请求失败
            else -> null
        }
    }

    /**
     * returns the state of the play queue for this user,using queue index
     * @param id        ID of a song in the play queue, Use one id parameter for each song in the play queue.Specify no IDs to clear
     * @param current   The ID of the current playing song. This is required if one or more IDs is provided
     * @param position  the position in milliseconds within the currently playing song.
     */
    suspend fun savePlayQueue(
        id: String? = null,
        current: String? = null,
        position: Long? = null
    ): Boolean {
        val result = RequestUtils.safeApiCall { service.savePlayQueue(id, current, position) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            // 请求失败
            else -> false
        }
    }

    /**
     * returns the state of the play queue for this user,using queue index
     * @param id            ID of a song in the play queue, Use one id parameter for each song in the play queue.Specify no IDs to clear
     * @param currentIndex  The index of the current playing song.This is required if one or more IDS is provided.
     * @param position      the position in milliseconds within the currently playing song.
     */
    @UnverifiedApi
    suspend fun savePlayQueueByIndex(
        id: String? = null,
        currentIndex: Long? = null,
        position: Long? = null
    ): Boolean {
        val result = RequestUtils.safeApiCall { service.savePlayQueueByIndex(id, currentIndex, position) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            // 请求失败
            else -> false
        }
    }
}