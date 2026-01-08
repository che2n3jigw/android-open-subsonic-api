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
import com.che2n3jigw.android.libs.opensubsonicapi.bean.AutoInfo
import com.che2n3jigw.android.libs.opensubsonicapi.service.MediaAnnotationService

class MediaAnnotationDataSource(
    baseUrl: String,
    authInfo: AutoInfo,
    enableLogging: Boolean = true
) : BaseDataSource(baseUrl, authInfo, enableLogging) {

    private val service: MediaAnnotationService = service()

    /**
     * 注册一个或多个媒体文件的本地播放
     * @param id            用于唯一表示要记录的文件的字符串
     * @param time          歌曲被收听的时间
     * @param submission    是'提交'通知还是'正在播放'通知?
     */
    suspend fun scrobble(id: String, time: Long? = null, submission: Boolean? = true): Boolean {
        val result = RequestUtils.safeApiCall { service.scrobble(id, time, submission) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            // 请求失败
            else -> false
        }
    }

    /**
     * 设置音乐评级
     * @param id        用于唯一标识要评分的歌曲/专辑/艺术家的字符串
     * @param rating    评分[0,5]
     */
    suspend fun setRating(id: String, rating: Int): Boolean {
        val result = RequestUtils.safeApiCall { service.setRating(id, rating) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            // 请求失败
            else -> false
        }
    }

    /**
     * 给歌曲/专辑/歌手添加一个星
     * @param id        用于唯一标识要评分的歌曲/专辑/艺术家的字符串
     * @param albumId   专辑id
     * @param artistId  艺术家id
     */
    suspend fun star(
        id: List<String>? = null,
        albumId: List<String>? = null,
        artistId: List<String>? = null
    ): Boolean {
        val result = RequestUtils.safeApiCall { service.star(id, albumId, artistId) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            // 请求失败
            else -> false
        }
    }

    /**
     * 给歌曲/专辑/歌手移除一个星
     * @param id        用于唯一标识要评分的歌曲/专辑/艺术家的字符串
     * @param albumId   专辑id
     * @param artistId  艺术家id
     */
    suspend fun unstar(
        id: List<String>? = null,
        albumId: List<String>? = null,
        artistId: List<String>? = null
    ): Boolean {
        val result = RequestUtils.safeApiCall { service.unstar(id, albumId, artistId) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            // 请求失败
            else -> false
        }
    }
}