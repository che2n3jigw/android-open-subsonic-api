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

@Serializable
data class ReplayGain(
    /**
     * The track replay gain value.
     */
    val trackGain: Int? = null,

    /**
     * The album replay gain value.
     */
    val albumGain: Int? = null,

    /**
     * The track peak value.
     */
    val trackPeak: Int? = null,

    /**
     * The album peak value.
     */
    val albumPeak: Int? = null,

    /**
     * The base gain value.
     */
    val baseGain: Int? = null,

    /**
     * An optional fallback gain that clients should apply when the corresponding gain value is missing.
     */
    val fallbackGain: Int? = null
)