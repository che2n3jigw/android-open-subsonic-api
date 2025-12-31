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

package com.che2n3jigw.android.libs.opensubsonicapi.response.common

import kotlinx.serialization.Serializable

/**
 * A contributor artist for a song or an album
 */
@Serializable
data class Contributor(
    /**
     * The contributor role.
     */
    val role: String? = null,

    /**
     * The subRole for roles that may require it. Ex: The instrument for the performer role (TMCL/performer tags).
     * Note: For consistency between different tag formats,
     * the TIPL sub roles should be directly exposed in the role field.
     */
    val subRole: String? = null,

    /**
     * An artist from ID3 tags.
     */
    val artist: ArtistID3? = null
)