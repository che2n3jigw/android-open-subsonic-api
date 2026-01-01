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
// 创建时间： 1/1/26
package com.che2n3jigw.android.libs.opensubsonicapi.response.sharing

import com.che2n3jigw.android.libs.opensubsonicapi.response.common.Child
import kotlinx.serialization.Serializable


@Serializable
data class Share(
    /**
     * The share Id
     */
    val id: String? = null,
    /**
     * The share url
     */
    val url: String? = null,
    /**
     * A description
     */
    val description: String? = null,
    /**
     * The username
     */
    val username: String? = null,
    /**
     * Creation date
     */
    val created: String? = null,
    /**
     * Share expiration
     */
    val expires: String? = null,
    /**
     * Last visit
     */
    val lastVisited: String? = null,
    /**
     * Visit count
     */
    val visitCount: Int? = null,
    /**
     * A list of share
     */
    val entry: List<Child>? = null
)