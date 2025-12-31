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
// 创建时间： 12/31/25
package com.che2n3jigw.android.libs.opensubsonicapi.response.user

import kotlinx.serialization.Serializable

@Serializable
data class User(
    /**
     * 用户名
     */
    val username: String? = null,
    /**
     * Scrobbling enabled
     */
    val scrobblingEnabled: Boolean? = null,
    val maxBitRate: Int? = null,
    /**
     * Whether the user is an admin
     */
    val adminRole: Boolean? = null,
    /**
     * Whether the user is can edit settings
     */
    val settingsRole: Boolean? = null,
    /**
     * Whether the user can download
     */
    val downloadRole: Boolean? = null,
    /**
     * Whether the user can upload
     */
    val uploadRole: Boolean? = null,
    /**
     * Whether the user can create playlists
     */
    val playlistRole: Boolean? = null,
    /**
     * Whether the user can get cover art
     */
    val coverArtRole: Boolean? = null,
    /**
     * Whether the user can create comments
     */
    val commentRole: Boolean? = null,
    /**
     * Whether the user can create/refresh podcasts
     */
    val podcastRole: Boolean? = null,
    /**
     * Whether the user can stream
     */
    val streamRole: Boolean? = null,
    /**
     * Whether the user can control the jukebox
     */
    val jukeboxRole: Boolean? = null,
    /**
     * Whether the user can create a stream
     */
    val shareRole: Boolean? = null,
    /**
     * Whether the user can convert videos
     */
    val videoConversionRole: Boolean? = null,
    /**
     * Last time the avatar was changed
     */
    val avatarLastChanged: String? = null,
    /**
     * Folder ID(s)
     */
    val folder: List<Int?>? = null
)