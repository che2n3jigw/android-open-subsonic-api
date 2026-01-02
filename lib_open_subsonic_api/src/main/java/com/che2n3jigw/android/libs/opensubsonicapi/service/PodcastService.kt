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
package com.che2n3jigw.android.libs.opensubsonicapi.service

import com.che2n3jigw.android.libs.opensubsonicapi.response.BaseResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.BaseSubsonicResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.podcast.GetNewestPodcastsResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.podcast.GetPodcastEpisodeResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.podcast.GetPodcastsResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Open Subsonic Podcast API
 */
interface PodcastService {
    /**
     * Adds a new Podcast channel. Note: The user must be authorized for Podcast administration (see Settings > Users > User is allowed to administrate Podcasts).
     */
    @GET("/rest/createPodcastChannel")
    suspend fun createPodcastChannel(@Query("url") url: String): BaseResponse<BaseSubsonicResponse>

    /**
     * Deletes a Podcast channel. Note: The user must be authorized for Podcast administration (see Settings > Users > User is allowed to administrate Podcasts).
     */
    @GET("/rest/deletePodcastChannel")
    suspend fun deletePodcastChannel(@Query("id") id: String): BaseResponse<BaseSubsonicResponse>

    /**
     * Deletes a Podcast episode. Note: The user must be authorized for Podcast administration (see Settings > Users > User is allowed to administrate Podcasts).
     */
    @GET("/rest/deletePodcastEpisode")
    suspend fun deletePodcastEpisode(@Query("id") id: String): BaseResponse<BaseSubsonicResponse>

    /**
     * Request the server to start downloading a given Podcast episode. Note: The user must be authorized for Podcast administration (see Settings > Users > User is allowed to administrate Podcasts).
     */
    @GET("/rest/downloadPodcastEpisode")
    suspend fun downloadPodcastEpisode(@Query("id") id: String): BaseResponse<BaseSubsonicResponse>

    /**
     * Returns the most recently published Podcast episodes.
     */
    @GET("/rest/getNewestPodcasts")
    suspend fun getNewestPodcasts(@Query("count") count: Long): BaseResponse<GetNewestPodcastsResponse>

    /**
     * OpenSubsonic extension name getPodcastEpisode (As returned by getOpenSubsonicExtensions). Returns details for a podcast episode.
     */
    @GET("/rest/getPodcastEpisode")
    suspend fun getPodcastEpisode(@Query("id") id: String): BaseResponse<GetPodcastEpisodeResponse>

    /**
     * Returns all Podcast channels the server subscribes to, and (optionally) their episodes.
     * This method can also be used to return details for only one channel - refer to the id parameter.
     * A typical use case for this method would be to first retrieve all channels without episodes, and then retrieve all episodes for the single channel the user selects.
     */
    @GET("/rest/getPodcasts")
    suspend fun getPodcasts(
        @Query("id") id: String? = null,
        @Query("includeEpisodes") includeEpisodes: Boolean? = null
    ): BaseResponse<GetPodcastsResponse>

    /**
     * Requests the server to check for new Podcast episodes. Note: The user must be authorized for Podcast administration (see Settings > Users > User is allowed to administrate Podcasts).
     */
    @GET("/rest/refreshPodcasts")
    suspend fun refreshPodcasts(): BaseResponse<BaseSubsonicResponse>

}