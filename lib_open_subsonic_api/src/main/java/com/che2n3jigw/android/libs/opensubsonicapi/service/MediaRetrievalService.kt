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
package com.che2n3jigw.android.libs.opensubsonicapi.service

import com.che2n3jigw.android.libs.opensubsonicapi.response.BaseResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.retrieval.GetLyricsBySongIdResponse
import com.che2n3jigw.android.libs.opensubsonicapi.response.retrieval.GetLyricsResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Streaming

/**
 * open subsonic media retrieval api
 */
interface MediaRetrievalService {

    /**
     * Downloads a given media file. Similar to stream,
     * but this method returns the original media data without transcoding or downsampling.
     */
    @GET("/rest/download")
    @Streaming
    suspend fun download(@Query("id") id: String): Response<ResponseBody>

    /**
     * Returns the avatar (personal image) for a user.
     */
    @GET("/rest/getAvatar")
    @Streaming
    suspend fun getAvatar(@Query("username") username: String): Response<ResponseBody>

    /**
     * Returns captions (subtitles) for a video.
     * Use getVideoInfo to get a list of available captions.
     */
    @GET("/rest/getCaptions")
    suspend fun getCaptions(
        @Query("id") id: String,
        @Query("format") format: String? = null
    ): Response<ResponseBody>

    /**
     * Returns a cover art image.
     */
    @GET("/rest/getCoverArt")
    @Streaming
    suspend fun getCoverArt(
        @Query("id") id: String,
        @Query("size") size: Long? = null
    ): Response<ResponseBody>

    /**
     * Searches for and returns lyrics for a given song.
     */
    @GET("/rest/getLyrics")
    suspend fun getLyrics(
        @Query("artist") artist: String? = null,
        @Query("title") title: String? = null
    ): BaseResponse<GetLyricsResponse>

    /**
     * OpenSubsonic extension name songLyrics (As returned by getOpenSubsonicExtensions).
     * Retrieves all structured lyrics from the server for a given song.
     * The lyrics can come from embedded tags (SYLT/USLT), LRC file/text file, or any other external source.
     */
    @GET("/rest/getLyricsBySongId")
    suspend fun getLyricsBySongId(@Query("id") id: String): BaseResponse<GetLyricsBySongIdResponse>


    /**
     * Creates an HLS (HTTP Live Streaming) playlist used for streaming video or audio.
     * HLS is a streaming protocol implemented by Apple and works by breaking the overall stream into a sequence of small HTTP-based file downloads.
     * It’s supported by iOS and newer versions of Android. This method also supports adaptive bitrate streaming, see the bitRate parameter.
     */
    @GET("/rest/hls.m3u8")
    suspend fun hls(
        @Query("id") id: String,
        @Query("bitRate") bitRate: Long? = null,
        @Query("audioTrack") audioTrack: String? = null
    ): Response<ResponseBody>

    /**
     * Streams a given media file.
     *
     * OpenSubsonic servers must not count access to this endpoint as a play and increase playcount. Clients can use the Scrobble endpoint to indicate that a media is played ensuring proper data in all cases.
     *
     * If the server support the Transcode Offet extension, then it must accept the timeOffset parameter for music too.
     */
    @GET("/rest/stream")
    suspend fun stream(
        @Query("id") id: String,
        @Query("maxBitRate") maxBitRate: Long? = null,
        @Query("format") format: String? = null,
        @Query("timeOffset") timeOffset: Long? = null,
        @Query("size") size: String? = null,
        @Query("estimateContentLength") estimateContentLength: Boolean? = null,
        @Query("converted") converted: Boolean? = null
    ): Response<ResponseBody>
}