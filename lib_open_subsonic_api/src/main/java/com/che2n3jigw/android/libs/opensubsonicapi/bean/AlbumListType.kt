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
// 创建时间： 12/27/25
package com.che2n3jigw.android.libs.opensubsonicapi.bean

/**
 * 列表类型。必须是以下选项之一：random、newest、highest、frequent、recent。
 * 自 1.8.0 版本起，您还可以使用 alphabeticalByName 或 alphabeticalByArtist 按字母顺序浏览所有专辑，并使用 starred 检索已加星标的专辑。
 * 自 1.10.1 版本起，您可以使用 byYear 和 byGenre 按指定年份范围或流派列出专辑。
 */
sealed class AlbumListType(val value: String) {
    data object Random : AlbumListType("random")
    data object Newest : AlbumListType("newest")
    data object Highest : AlbumListType("highest")
    data object Frequent : AlbumListType("frequent")
    data object Recent : AlbumListType("recent")
    data object AlphabeticalByName : AlbumListType("alphabeticalByName")
    data object AlphabeticalByArtist : AlbumListType("alphabeticalByArtist")
    data object Starred : AlbumListType("starred")
    data object ByYear : AlbumListType("byYear")
    data object ByGenre : AlbumListType("byGenre")
}
