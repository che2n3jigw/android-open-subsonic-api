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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subsonic_api_test)

        findViewById<Button>(R.id.btn_ping).setOnClickListener {
            lifecycleScope.launch {
                // <editor-fold defaultState="collapsed" desc="System">
//                val repository = SystemRepository("http://192.168.50.245:4533", authInfo)
//                repository.ping()
//                repository.getLicense()
//                repository.getOpenSubsonicExtensions()
//                @OptIn(UnverifiedApi::class)
//                repository.tokenInfo()
                // </editor-fold>

                // <editor-fold defaultState="collapsed" desc="browsing">
//                val songId = "5e35d304abfd8c2dc66c0000e4dc814b"
//                val albumId = "ada350bb42c91b863c0beef6e203a7d4"
//                val artistId = "7a8941058aaf4df5147042ce104568da"
//                val repository = BrowsingRepository("http://192.168.50.245:4533", authInfo)
//                repository.getMusicFolders()
//                repository.getIndexes()
//                repository.getMusicDirectory(artistId)
//                repository.getGenres()
//                repository.getArtists()
//                repository.getAlbum(albumId)
//                repository.getSong(songId)
//                @OptIn(UnverifiedApi::class)
//                repository.getVideos()
//                repository.getArtistInfo(artistId)
//                repository.getArtistInfo2(artistId)
//                repository.getAlbumInfo(albumId)
//                repository.getAlbumInfo2(songId)
//                repository.getSimilarSongs(songId)
//                repository.getSimilarSongs2(songId)
//                repository.getTopSongs("周杰伦")
//                repository.getAlbumList(AlbumListType.Random)
//                repository.getAlbumList2(AlbumListType.Random)
//                repository.getRandomSongs()
//                repository.getSongsByGenre("Pop")
//                repository.getNowPlaying()
//                repository.getStarred()
//                repository.getStarred2()
                // </editor-fold>
            }
        }
    }
}