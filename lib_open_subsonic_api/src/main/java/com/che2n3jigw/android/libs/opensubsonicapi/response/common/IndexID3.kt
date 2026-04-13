// 作者: che2n3jigw
// 邮箱: che2n3jigw@163.com
// 博客: che2n3jigw.github.io
// 创建时间： 2026/4/13 16:04
package com.che2n3jigw.android.libs.opensubsonicapi.response.common

import kotlinx.serialization.Serializable

@Serializable
data class IndexID3(
    /**
     * Index name.
     */
    val name: String? = null,
    /**
     * Artist list
     */
    val artist: List<ArtistID3>? = null
)