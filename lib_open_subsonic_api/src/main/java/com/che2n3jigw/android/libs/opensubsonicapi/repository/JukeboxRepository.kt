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
package com.che2n3jigw.android.libs.opensubsonicapi.repository

import com.che2n3jigw.android.libs.net.bean.RequestResult
import com.che2n3jigw.android.libs.net.utils.RequestUtils
import com.che2n3jigw.android.libs.opensubsonicapi.UnverifiedApi
import com.che2n3jigw.android.libs.opensubsonicapi.bean.AutoInfo
import com.che2n3jigw.android.libs.opensubsonicapi.response.jukebox.JukeboxControlSuccessResponse
import com.che2n3jigw.android.libs.opensubsonicapi.service.JukeboxService

class JukeboxRepository(
    baseUrl: String,
    authInfo: AutoInfo,
    enableLogging: Boolean = true
) : BaseRepository(baseUrl, authInfo, enableLogging) {

    private val service: JukeboxService = service()

    /**
     * Controls the jukebox,i.e.,playback directly on the server's audio hardware.
     * @param action    The operation to perform.Must be one of [get, status, set, start, stop, skip, add, clear, remove, shuffle, setGain]
     * @param index     used by skip and remove, zero-based index of the song to skip to or remove
     * @param offset    used by skip.Start playing this many seconds into the track
     * @param id        used by add and set. Id of song to add to the jukebox playlist.
     * @param gain      used by setGain to control the playback volume,between 0.0 to 1.0
     */
    @UnverifiedApi
    suspend fun jukeboxControl(
        action: String,
        index: Int? = null,
        offset: Int? = null,
        id: List<String>? = null,
        gain: Float? = null
    ): JukeboxControlSuccessResponse? {
        val result =
            RequestUtils.safeApiCall { service.jukeboxControl(action, index, offset, id, gain) }
        return when (result) {
            // 请求成功
            is RequestResult.Success -> result.data.response
            // 请求失败
            else -> null
        }
    }
}