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
import com.che2n3jigw.android.libs.opensubsonicapi.response.podcast.PodcastChannel
import com.che2n3jigw.android.libs.opensubsonicapi.response.podcast.PodcastEpisode
import com.che2n3jigw.android.libs.opensubsonicapi.service.PodcastService

class PodcastDataSource(
    baseUrl: String,
    authInfo: AutoInfo,
    enableLogging: Boolean = true
) : BaseDataSource(baseUrl, authInfo, enableLogging) {

    private val service: PodcastService = service()

    /**
     * adds a new Podcast channel
     * @param url   The URL of the Podcast to add
     */
    suspend fun createInternetRadioStation(url: String): Boolean {
        val result = RequestUtils.safeApiCall { service.createPodcastChannel(url) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            // 请求失败
            else -> false
        }
    }

    /**
     * Deletes a Podcast channel
     * @param id The ID of the Podcast channel to delete
     */
    suspend fun deletePodcastChannel(id: String): Boolean {
        val result = RequestUtils.safeApiCall { service.deletePodcastChannel(id) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            // 请求失败
            else -> false
        }
    }

    /**
     * Deletes a Podcast episode
     * @param id The ID of the Podcast episode to delete
     */
    suspend fun deletePodcastEpisode(id: String): Boolean {
        val result = RequestUtils.safeApiCall { service.deletePodcastEpisode(id) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            // 请求失败
            else -> false
        }
    }

    /**
     * Request the server to start downloading a given Podcast episode
     * @param id The ID of the Podcast episode to download
     */
    suspend fun downloadPodcastEpisode(id: String): Boolean {
        val result = RequestUtils.safeApiCall { service.downloadPodcastEpisode(id) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            // 请求失败
            else -> false
        }
    }

    /**
     * returns the most recently published Podcast episodes
     * @param count The maximum number of episodes to return
     */
    @UnverifiedApi
    suspend fun getNewestPodcasts(count: Long = 20): List<PodcastEpisode> {
        val result = RequestUtils.safeApiCall { service.getNewestPodcasts(count) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.newestPodcasts?.episode?.filterNotNull() ?: emptyList()
            }
            // 请求失败
            else -> emptyList()
        }
    }


    /**
     * returns details for a podcast episode.
     * @param count The maximum number of episodes to return
     */
    suspend fun getPodcastEpisode(id: String): PodcastEpisode? {
        val result = RequestUtils.safeApiCall { service.getPodcastEpisode(id) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.podcastEpisode
            // 请求失败
            else -> null
        }
    }

    /**
     * returns all podcast channels the server subscribes to,and their episode.
     * @param id                if specified, only return the Podcast channel with this ID
     * @param includeEpisodes   Whether to include Podcast episode in the returned result.
     *
     */
    suspend fun getPodcasts(
        id: String? = null,
        includeEpisodes: Boolean? = null
    ): List<PodcastChannel>? {
        val result = RequestUtils.safeApiCall { service.getPodcasts(id, includeEpisodes) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.podcasts?.channel?.filterNotNull() ?: emptyList()
            }
            // 请求失败
            else -> emptyList()
        }
    }

    /**
     * Requests the server to check for new Podcast episodes
     */
    suspend fun refreshPodcasts(): Boolean {
        val result = RequestUtils.safeApiCall { service.refreshPodcasts() }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.status == STATUS_OK
            // 请求失败
            else -> false
        }
    }
}