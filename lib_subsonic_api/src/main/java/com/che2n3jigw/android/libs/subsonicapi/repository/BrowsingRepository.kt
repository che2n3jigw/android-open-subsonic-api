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
// 创建时间： 12/20/25
package com.che2n3jigw.android.libs.subsonicapi.repository

import com.che2n3jigw.android.libs.net.RequestClient
import com.che2n3jigw.android.libs.net.bean.RequestResult
import com.che2n3jigw.android.libs.net.utils.RequestUtils
import com.che2n3jigw.android.libs.subsonicapi.UnverifiedApi
import com.che2n3jigw.android.libs.subsonicapi.bean.AlbumListType
import com.che2n3jigw.android.libs.subsonicapi.bean.AutoInfo
import com.che2n3jigw.android.libs.subsonicapi.response.BaseResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.Album
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.AlbumInfoResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.AlbumList2Response
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.AlbumListResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.AlbumResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.ArtistInfo
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.ArtistInfo2Response
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.ArtistInfoResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.ArtistsResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.GenresResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.IndexesResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.IndexesResponse.Indexes
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.MusicDirectoryResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.MusicFoldersResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.NowPlayingResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.NowPlayingResponse.Entry
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.RandomSongsResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.SimilarSongs2Response
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.SimilarSongsResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.Song
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.SongResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.SongsByGenreResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.Starred
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.Starred2Response
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.StarredResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.TopSongsResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.VideoInfoResponse
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.VideoInfoResponse.VideoInfo
import com.che2n3jigw.android.libs.subsonicapi.response.browsing.VideosResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Subsonic Browsing API 远程库
 */
class BrowsingRepository(
    private val baseUrl: String,
    authInfo: AutoInfo,
    private val enableLogging: Boolean = true
) : BaseRepository(authInfo) {

    private val service = RequestClient.createService<Service>(
        baseUrl = baseUrl,
        enableLogging = enableLogging,
        interceptors = listOf(authInterceptor)
    )

    /**
     * 获取音乐文件夹
     */
    suspend fun getMusicFolders(): List<MusicFoldersResponse.MusicFolder> {
        val result = RequestUtils.safeApiCall {
            service.getMusicFolders()
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success ->
                result.data.response?.musicFolders?.musicFolder?.filterNotNull() ?: emptyList()
            // 请求失败
            else -> emptyList()
        }
    }

    /**
     * 获取索引结构
     * @return 所有艺术家的索引结构
     */
    suspend fun getIndexes(musicFolderId: Int? = null, ifModifiedSince: Long? = null): Indexes? {
        val result = RequestUtils.safeApiCall {
            service.getIndexes(musicFolderId, ifModifiedSince)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.indexes
            // 请求失败
            else -> null
        }
    }

    /**
     * 用于获取某个艺术家的专辑列表，或某个专辑的歌曲列表。
     * @param id 音乐目录的ID(艺术家id/专辑id),通过getIndexes/getMusicDirectory获取
     * @return 音乐目录中所有文件的列表
     */
    suspend fun getMusicDirectory(id: String): MusicDirectoryResponse.Directory? {
        val result = RequestUtils.safeApiCall {
            service.getMusicDirectory(id)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.directory
            // 请求失败
            else -> null
        }
    }

    /**
     * 获取流派
     */
    suspend fun getGenres(): List<GenresResponse.Genre> {
        val result = RequestUtils.safeApiCall {
            service.getGenres()
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.genres?.genre?.filterNotNull() ?: emptyList()
            }
            // 请求失败
            else -> emptyList()
        }
    }

    /**
     * 获取艺术家
     * 与 getIndexes 类似，但它是根据 ID3 标签对音乐进行组织。
     * @param musicFolderId 如果指定，则仅返回音乐文件夹中具有给定 ID 的艺术家。
     */
    suspend fun getArtists(musicFolderId: Long? = null): ArtistsResponse.Artists? {
        val result = RequestUtils.safeApiCall {
            service.getArtists(musicFolderId)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.artists
            }
            // 请求失败
            else -> null
        }
    }

    /**
     * 获取专辑
     * @param id 专辑的ID
     */
    suspend fun getAlbum(id: String): Album? {
        val result = RequestUtils.safeApiCall {
            service.getAlbum(id)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.album
            }
            // 请求失败
            else -> null
        }
    }

    /**
     * 获取歌曲
     * @param id 歌曲的ID
     */
    suspend fun getSong(id: String): Song? {
        val result = RequestUtils.safeApiCall {
            service.getSong(id)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.song
            }
            // 请求失败
            else -> null
        }
    }

    /**
     * 获取所有视频
     */
    @UnverifiedApi
    suspend fun getVideos(): List<VideosResponse.Video> {
        val result = RequestUtils.safeApiCall {
            service.getVideos()
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.videos?.video?.filterNotNull() ?: emptyList()
            }
            // 请求失败
            else -> emptyList()
        }
    }

    /**
     * 获取视频
     * @param id 视频的ID
     */
    @UnverifiedApi
    suspend fun getVideoInfo(id: String): VideoInfo? {
        val result = RequestUtils.safeApiCall {
            service.getVideoInfo(id)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.videoInfo
            // 请求失败
            else -> null
        }
    }

    /**
     * 获取艺术家信息
     * @param id                艺术家的ID
     * @param count             相似艺术家数量上限
     * @param includeNotPresent 是否归还媒体库中不存在的艺术家
     */
    suspend fun getArtistInfo(
        id: String,
        count: Int = 20,
        includeNotPresent: Boolean = false
    ): ArtistInfo? {
        val result = RequestUtils.safeApiCall {
            service.getArtistInfo(id, count, includeNotPresent)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.artistInfo
            // 请求失败
            else -> null
        }
    }

    /**
     * 获取艺术家信息，与getArtistInfo相似，但它是根据 ID3 标签对音乐进行分类。
     * @param id                艺术家的ID
     * @param count             相似艺术家数量上限
     * @param includeNotPresent 是否归还媒体库中不存在的艺术家
     */
    suspend fun getArtistInfo2(
        id: String,
        count: Int = 20,
        includeNotPresent: Boolean = false
    ): ArtistInfo? {
        val result = RequestUtils.safeApiCall {
            service.getArtistInfo2(id, count, includeNotPresent)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.artistInfo2
            // 请求失败
            else -> null
        }
    }

    /**
     * 获取专辑信息
     * @param id 专辑的ID/歌曲ID
     */
    suspend fun getAlbumInfo(id: String): AlbumInfoResponse.AlbumInfo? {
        val result = RequestUtils.safeApiCall {
            service.getAlbumInfo(id)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.albumInfo
            // 请求失败
            else -> null
        }
    }

    /**
     * 获取专辑信息
     * @param id 专辑的ID
     */
    suspend fun getAlbumInfo2(id: String): AlbumInfoResponse.AlbumInfo? {
        val result = RequestUtils.safeApiCall {
            service.getAlbumInfo2(id)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.albumInfo
            // 请求失败
            else -> null
        }
    }

    /**
     * 获取相似歌曲
     * @param id                歌曲的ID
     * @param count             相似歌曲数量上限
     */
    suspend fun getSimilarSongs(id: String, count: Int = 50): List<Song> {
        val result = RequestUtils.safeApiCall {
            service.getSimilarSongs(id, count)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.similarSongs?.song?.filterNotNull() ?: emptyList()
            }
            // 请求失败
            else -> emptyList()
        }
    }

    /**
     * 获取相似歌曲，但它是根据 ID3 标签对音乐进行分类。
     * @param id                歌曲的ID
     * @param count             相似歌曲数量上限
     */
    suspend fun getSimilarSongs2(id: String, count: Int = 50): List<Song> {
        val result = RequestUtils.safeApiCall {
            service.getSimilarSongs2(id, count)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.similarSongs2?.song?.filterNotNull() ?: emptyList()
            }
            // 请求失败
            else -> emptyList()
        }
    }

    /**
     * @param artist            歌手
     * @param count             热门歌曲数量上限
     * @return 给定歌手的热门歌曲，数据来自 last.fm。
     */
    suspend fun getTopSongs(artist: String, count: Int = 50): List<Song> {
        val result = RequestUtils.safeApiCall {
            service.getTopSongs(artist, count)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> {
                result.data.response?.topSongs?.song?.filterNotNull() ?: emptyList()
            }
            // 请求失败
            else -> emptyList()
        }
    }

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
        musicFolderId: Long? = null
    ): List<Album> {
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
        musicFolderId: Long? = null
    ): List<Album> {
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
        musicFolderId: Long? = null
    ): List<Song> {
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
        musicFolderId: Long? = null
    ): List<Song> {
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
     * 获取所有用户当前正在播放的歌曲
     */
    suspend fun getNowPlaying(): List<Entry?>? {
        val result = RequestUtils.safeApiCall {
            service.getNowPlaying()
        }
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
     * @param musicFolderId 音乐文件夹的ID
     * @return 返回星号歌曲、专辑和歌手。
     */
    suspend fun getStarred(musicFolderId: Long? = null): Starred? {
        val result = RequestUtils.safeApiCall {
            service.getStarred(musicFolderId)
        }
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
    suspend fun getStarred2(musicFolderId: Long? = null): Starred? {
        val result = RequestUtils.safeApiCall {
            service.getStarred2(musicFolderId)
        }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response?.starred2
            // 请求失败
            else -> null
        }
    }
}

interface Service {

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