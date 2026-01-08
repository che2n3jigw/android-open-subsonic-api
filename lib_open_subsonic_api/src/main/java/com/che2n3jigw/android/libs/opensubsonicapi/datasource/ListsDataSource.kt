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
// 创建时间： 12/31/25
package com.che2n3jigw.android.libs.opensubsonicapi.datasource

import com.che2n3jigw.android.libs.net.bean.RequestResult
import com.che2n3jigw.android.libs.net.utils.RequestUtils
import com.che2n3jigw.android.libs.opensubsonicapi.bean.AlbumListType
import com.che2n3jigw.android.libs.opensubsonicapi.bean.AutoInfo
import com.che2n3jigw.android.libs.opensubsonicapi.response.common.Child
import com.che2n3jigw.android.libs.opensubsonicapi.response.lists.NowPlayingEntry
import com.che2n3jigw.android.libs.opensubsonicapi.response.lists.Starred
import com.che2n3jigw.android.libs.opensubsonicapi.response.lists.Starred2
import com.che2n3jigw.android.libs.opensubsonicapi.service.ListsService

class ListsDataSource(
    baseUrl: String,
    authInfo: AutoInfo,
    enableLogging: Boolean = true
) : BaseDataSource(baseUrl, authInfo, enableLogging) {

    private val service: ListsService = service()

    /**
     * 获取专辑列表
     * @param type          列表类型
     * @param size          专辑返回数,最大500
     * @param offset        列表偏移量。例如，如果您想翻阅最新专辑列表，这将非常有用。
     * @param fromYear      返回指定范围内的第一年。fromYear > toYear，返回一个按时间**倒序**排列的列表。
     * @param toYear        范围的最后一年
     * @param genre         流派
     * @param musicFolderId 音乐文件夹的ID,仅返回音乐文件夹中具有给定 ID 的专辑。
     * @return 一个包含随机、最新、评分最高等专辑的列表。类似于Subsonic网页界面首页上的专辑列表。
     */
    suspend fun getAlbumList(
        type: AlbumListType,
        size: Int = 10,
        offset: Int = 0,
        fromYear: Int? = null,
        toYear: Int? = null,
        genre: String? = null,
        musicFolderId: String? = null
    ): List<Child> {
        val result = RequestUtils.safeApiCall {
            service.getAlbumList(type.value, size, offset, fromYear, toYear, genre, musicFolderId)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.albumList?.album?.filterNotNull() ?: emptyList()
            }
            // 请求失败
            else -> emptyList()
        }
    }

    /**
     * 获取专辑列表,但它会根据 ID3 标签对音乐进行分类。
     * @param type          列表类型
     * @param size          专辑返回数,最大500
     * @param offset        列表偏移量。例如，如果您想翻阅最新专辑列表，这将非常有用。
     * @param fromYear      返回指定范围内的第一年。fromYear > toYear，返回一个按时间**倒序**排列的列表。
     * @param toYear        范围的最后一年
     * @param genre         流派
     * @param musicFolderId 音乐文件夹的ID,仅返回音乐文件夹中具有给定 ID 的专辑。
     * @return 一个包含随机、最新、评分最高等专辑的列表。类似于Subsonic网页界面首页上的专辑列表。
     */
    suspend fun getAlbumList2(
        type: AlbumListType,
        size: Int = 10,
        offset: Int = 0,
        fromYear: Int? = null,
        toYear: Int? = null,
        genre: String? = null,
        musicFolderId: String? = null
    ): List<Child> {
        val result = RequestUtils.safeApiCall {
            service.getAlbumList2(type.value, size, offset, fromYear, toYear, genre, musicFolderId)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.albumList2?.album?.filterNotNull() ?: emptyList()
            }
            // 请求失败
            else -> emptyList()
        }
    }

    /**
     * 获取所有用户当前正在播放的歌曲
     */
    suspend fun getNowPlaying(): List<NowPlayingEntry?>? {
        val result = RequestUtils.safeApiCall { service.getNowPlaying() }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.nowPlaying?.entry?.filterNotNull() ?: emptyList()
            }
            // 请求失败
            else -> emptyList()
        }
    }

    /**
     * 获取随即歌曲列表
     * @param size          专辑返回数,最大500
     * @param fromYear      返回指定范围内的第一年。fromYear > toYear，返回一个按时间**倒序**排列的列表。
     * @param toYear        范围的最后一年
     * @param genre         流派
     * @param musicFolderId 音乐文件夹的ID,仅返回音乐文件夹中具有给定 ID 的专辑。
     * @return 符合给定条件的随机歌曲。
     */
    suspend fun getRandomSongs(
        size: Int = 10,
        fromYear: Int? = null,
        toYear: Int? = null,
        genre: String? = null,
        musicFolderId: String? = null
    ): List<Child> {
        val result = RequestUtils.safeApiCall {
            service.getRandomSongs(size, genre, fromYear, toYear, musicFolderId)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.randomSongs?.song?.filterNotNull() ?: emptyList()
            }
            // 请求失败
            else -> emptyList()
        }
    }

    /**
     * 获取歌曲列表通过流派
     * @param genre         流派
     * @param count         歌曲返回数量 最大500
     * @param offset        列表偏移量。例如，如果您想翻阅最新专辑列表，这将非常有用。
     * @param musicFolderId 音乐文件夹的ID,仅返回音乐文件夹中具有给定 ID 的专辑。
     * @return 符合给定条件的随机歌曲。
     */
    suspend fun getSongsByGenre(
        genre: String,
        count: Int = 10,
        offset: Int = 0,
        musicFolderId: String? = null
    ): List<Child> {
        val result = RequestUtils.safeApiCall {
            service.getSongsByGenre(genre, count, offset, musicFolderId)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.songsByGenre?.song?.filterNotNull() ?: emptyList()
            }
            // 请求失败
            else -> emptyList()
        }
    }

    /**
     * @param musicFolderId 音乐文件夹的ID
     * @return 返回星号歌曲、专辑和歌手。
     */
    suspend fun getStarred(musicFolderId: String? = null): Starred? {
        val result = RequestUtils.safeApiCall { service.getStarred(musicFolderId) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.starred
            // 请求失败
            else -> null
        }
    }

    /**
     * @param musicFolderId 音乐文件夹的ID
     * @return 返回星号歌曲、专辑和歌手。但它会根据 ID3 标签对音乐进行分类。
     */
    suspend fun getStarred2(musicFolderId: String? = null): Starred2? {
        val result = RequestUtils.safeApiCall { service.getStarred2(musicFolderId) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.starred2
            // 请求失败
            else -> null
        }
    }
}