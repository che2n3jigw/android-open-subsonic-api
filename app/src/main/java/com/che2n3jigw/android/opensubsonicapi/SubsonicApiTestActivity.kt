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
// 创建时间： 12/18/25
package com.che2n3jigw.android.opensubsonicapi

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.che2n3jigw.android.libs.opensubsonicapi.bean.AutoInfo
import kotlinx.coroutines.launch

class SubsonicApiTestActivity : AppCompatActivity() {

    private val authInfo = AutoInfo("直播", "123456")
    private val baseUrl = "http://192.168.50.245:4533"
    private val songId = "5e35d304abfd8c2dc66c0000e4dc814b"
    private val albumId = "ada350bb42c91b863c0beef6e203a7d4"
    private val artistId = "7a8941058aaf4df5147042ce104568da"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subsonic_api_test)

        findViewById<Button>(R.id.btn_api_test).setOnClickListener {
            lifecycleScope.launch {
                // <editor-fold defaultState="collapsed" desc="System">
//                val source = SystemDataSource(baseUrl, authInfo)
//                val response = source.getLicense()
//                val response = source.getOpenSubsonicExtensions()
//                val response = source.ping()
//                @OptIn(UnverifiedApi::class)
//                val response = source.tokenInfo()
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="User Management">
//                val source = UserManagementDataSource(baseUrl, authInfo)
//                @OptIn(UnverifiedApi::class)
//                val response = source.changePassword("直播", "11111")
//                @OptIn(UnverifiedApi::class)
//                val response = source.createUser("test", "123456", "123@qq.com")
//                @OptIn(UnverifiedApi::class)
//                val response = source.deleteUser("直播")
//                val response = source.getUser("直播")
//                val response = source.getUsers()
//                @OptIn(UnverifiedApi::class)
//                val response = source.updateUser("直播", "11111")
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="media library scanning">
//                val source = MediaLibraryScanningDataSource(baseUrl, authInfo)
//                val response = source.getScanStatus()
//                val response = source.startScan()
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="searching">
//                val source = SearchingDataSource(baseUrl, authInfo)
//                val response = source.search2("LATATA")
//                val response = source.search3("LATATA")
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="browsing">
//                val source = BrowsingDataSource(baseUrl, authInfo)
//                val response = source.getAlbum(albumId)
//                val response = source.getAlbumInfo(albumId)
//                val response = source.getAlbumInfo2(albumId)
//
//                val response = source.getArtist(artistId)
//                val response = source.getArtistInfo(artistId)
//                val response = source.getArtistInfo2(artistId)
//                val response = source.getArtists()
//
//                val response = source.getGenres()
//                val response = source.getIndexes()
//                val response = source.getMusicDirectory(artistId)
//                val response = source.getMusicFolders()
//
//                val response = source.getSimilarSongs(songId)
//                val response = source.getSimilarSongs2(songId)
//
//                val response = source.getSong(songId)
//                val response = source.getTopSongs("周杰伦")
//
//                @OptIn(UnverifiedApi::class)
//                val response =source.getVideos()
//                val response = source.getVideoInfo()
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="Playlists">
//                val source = PlaylistsDataSource(baseUrl, authInfo)
//                val response = source.createPlaylist(name = "测试")
//                val response = source.deletePlaylist("6bf65806-a916-44b0-b0c3-e4649f4234fa")
//                val response = source.getPlaylist("9f5ff9e6-c823-405a-8a6a-6011b51aac1d")
//                val response = source.getPlaylists()
//                val response =
//                    source.updatePlaylist("9f5ff9e6-c823-405a-8a6a-6011b51aac1d", "直播1")
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="lists">
//                val source = ListsDataSource(baseUrl, authInfo)
//                val response = source.getAlbumList(AlbumListType.Random)
//                val response = source.getAlbumList2(AlbumListType.Random)
//                val response = source.getNowPlaying()
//                val response = source.getRandomSongs()
//                val response = source.getSongsByGenre("Pop")
//                val response = source.getStarred()
//                val response = source.getStarred2()
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="Media Retrieval">
//                val source = MediaRetrievalDataSource(baseUrl, authInfo)
//                val response = source.download("ada350bb42c91b863c0beef6e203a7d4")
//                DownloadUtils.download(this@SubsonicApiTestActivity, response)
//                val response = source.getAvatar("直播")
//                DownloadUtils.download(this@SubsonicApiTestActivity, response, "avatar.png")
//                val response = source.getCoverArt(artistId)
//                DownloadUtils.download(this@SubsonicApiTestActivity, response, "${artistId}.webp")
//                val response = source.getLyrics("周杰伦", "烟花易冷")
//                val response = source.getLyricsBySongId(songId)
//                val response = source.hls(songId)
//                val response = source.stream(songId)
//                DownloadUtils.download(this@SubsonicApiTestActivity, response)
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="Media Annotation">
//                val source = MediaAnnotationDataSource(baseUrl, authInfo)
//                val response = source.scrobble(songId, submission = false)
//                val response = source.setRating(songId, 5)
//                val response = source.star(listOf(songId))
//                val response = source.unstar(listOf(songId))
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="Sharing">
//                val source = SharingDataSource(baseUrl, authInfo)
//                @OptIn(UnverifiedApi::class)
//                val response = source.createShare(listOf(songId))
//                @OptIn(UnverifiedApi::class)
//                val response = source.getShares()
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="Bookmarks">
//                val source = BookmarksDataSource(baseUrl, authInfo)
//                val response = source.createBookmark("100", 2000L)
//                val response = source.deleteBookmark("100")
//                val response = source.getBookmarks()
//                val response = source.getPlayQueueByIndex()
//                val response = source.savePlayQueue(songId)
//                val response = source.savePlayQueueByIndex(songId)
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="Podcast">
//                val source = PodcastDataSource(baseUrl, authInfo)
//                val response = source.getNewestPodcasts()
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="jukebox">
//                val source = JukeboxDataSource(baseUrl, authInfo)
//                val response = source.jukeboxControl("status")
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="jukebox">
//                val source = ChatDataSource(baseUrl, authInfo)
//                val response = source.getChatMessages()
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="Transcoding">
//                val source = TranscodingDataSource(baseUrl, authInfo)
//                val response = source.getTranscodeDecision(songId, "song")
//                val response = source.getTranscodeStream(songId, "song")
                // </editor-fold>

//                Log.d("===cjw", "onCreate: $response")
            }
        }
    }
}