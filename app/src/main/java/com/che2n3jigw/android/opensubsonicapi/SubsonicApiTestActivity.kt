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
import android.util.Log
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
//                val repository = SystemRepository(baseUrl, authInfo)
//                val response = repository.getLicense()
//                val response = repository.getOpenSubsonicExtensions()
//                val response = repository.ping()
//                @OptIn(UnverifiedApi::class)
//                val response = repository.tokenInfo()
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="User Management">
//                val repository = UserManagementRepository(baseUrl, authInfo)
//                @OptIn(UnverifiedApi::class)
//                val response = repository.changePassword("直播", "11111")
//                @OptIn(UnverifiedApi::class)
//                val response = repository.createUser("test", "123456", "123@qq.com")
//                @OptIn(UnverifiedApi::class)
//                val response = repository.deleteUser("直播")
//                val response = repository.getUser("直播")
//                val response = repository.getUsers()
//                @OptIn(UnverifiedApi::class)
//                val response = repository.updateUser("直播", "11111")
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="media library scanning">
//                val repository = MediaLibraryScanningRepository(baseUrl, authInfo)
//                val response = repository.getScanStatus()
//                val response = repository.startScan()
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="searching">
//                val repository = SearchingRepository(baseUrl, authInfo)
//                val response = repository.search2("LATATA")
//                val response = repository.search3("LATATA")
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="browsing">
//                val repository = BrowsingRepository(baseUrl, authInfo)
//                val response = repository.getAlbum(albumId)
//                val response = repository.getAlbumInfo(albumId)
//                val response = repository.getAlbumInfo2(albumId)

//                val response = repository.getArtist(artistId)
//                val response = repository.getArtistInfo(artistId)
//                val response = repository.getArtistInfo2(artistId)
//                val response = repository.getArtists()

//                val response = repository.getGenres()
//                val response = repository.getIndexes()
//                val response = repository.getMusicDirectory(artistId)
//                val response = repository.getMusicFolders()

//                val response = repository.getSimilarSongs(songId)
//                val response = repository.getSimilarSongs2(songId)

//                val response = repository.getSong(songId)
//                val response = repository.getTopSongs("周杰伦")

//                @OptIn(UnverifiedApi::class)
//                val response =repository.getVideos()
//                val response = repository.getVideoInfo()
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="Playlists">
//                val repository = PlaylistsRepository(baseUrl, authInfo)
//                val response = repository.createPlaylist(name = "测试")
//                val response = repository.deletePlaylist("6bf65806-a916-44b0-b0c3-e4649f4234fa")
//                val response = repository.getPlaylist("9f5ff9e6-c823-405a-8a6a-6011b51aac1d")
//                val response = repository.getPlaylists()
//                val response =
//                    repository.updatePlaylist("9f5ff9e6-c823-405a-8a6a-6011b51aac1d", "直播1")
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="lists">
//                val repository = ListsRepository(baseUrl, authInfo)
//                val response = repository.getAlbumList(AlbumListType.Random)
//                val response = repository.getAlbumList2(AlbumListType.Random)
//                val response = repository.getNowPlaying()
//                val response = repository.getRandomSongs()
//                val response = repository.getSongsByGenre("Pop")
//                val response = repository.getStarred()
//                val response = repository.getStarred2()
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="Media Retrieval">
//                val repository = MediaRetrievalRepository(baseUrl, authInfo)
//                val response = repository.download("ada350bb42c91b863c0beef6e203a7d4")
//                DownloadUtils.download(this@SubsonicApiTestActivity, response)
//                val response = repository.getAvatar("直播")
//                DownloadUtils.download(this@SubsonicApiTestActivity, response, "avatar.png")
//                val response = repository.getCoverArt(artistId)
//                DownloadUtils.download(this@SubsonicApiTestActivity, response, "${artistId}.webp")
//                val response = repository.getLyrics("周杰伦", "烟花易冷")
//                val response = repository.getLyricsBySongId(songId)
//                val response = repository.hls(songId)
//                val response = repository.stream(songId)
//                DownloadUtils.download(this@SubsonicApiTestActivity, response)
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="Media Annotation">
//                val repository = MediaAnnotationRepository(baseUrl, authInfo)
//                val response = repository.scrobble(songId, submission = false)
//                val response = repository.setRating(songId, 5)
//                val response = repository.star(listOf(songId))
//                val response = repository.unstar(listOf(songId))
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="Sharing">
//                val repository = SharingRepository(baseUrl, authInfo)
//                @OptIn(UnverifiedApi::class)
//                val response = repository.createShare(listOf(songId))
//                @OptIn(UnverifiedApi::class)
//                val response = repository.getShares()
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="Bookmarks">
//                val repository = BookmarksRepository(baseUrl, authInfo)
//                val response = repository.createBookmark("100", 2000L)
//                val response = repository.deleteBookmark("100")
//                val response = repository.getBookmarks()
//                val response = repository.getPlayQueueByIndex()
//                val response = repository.savePlayQueue(songId)
//                val response = repository.savePlayQueueByIndex(songId)
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="Podcast">
//                val repository = PodcastRepository(baseUrl, authInfo)
//                val response = repository.getNewestPodcasts()
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="jukebox">
//                val repository = JukeboxRepository(baseUrl, authInfo)
//                val response = repository.jukeboxControl("status")
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="jukebox">
//                val repository = ChatRepository(baseUrl, authInfo)
//                val response = repository.getChatMessages()
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="Transcoding">
//                val repository = TranscodingRepository(baseUrl, authInfo)
//                val response = repository.getTranscodeDecision(songId, "song")
//                val response = repository.getTranscodeStream(songId, "song")
                // </editor-fold>

//                Log.d("===cjw", "onCreate: $response")
            }
        }
    }
}