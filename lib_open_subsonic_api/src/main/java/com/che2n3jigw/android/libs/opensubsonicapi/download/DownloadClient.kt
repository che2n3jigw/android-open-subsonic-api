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

package com.che2n3jigw.android.libs.opensubsonicapi.download

import com.che2n3jigw.android.libs.opensubsonicapi.bean.AutoInfo
import com.che2n3jigw.android.libs.opensubsonicapi.interceptor.AuthenticationInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

/**
 * Subsonic资源下载客户端
 */
class DownloadClient(private val baseUrl: String, auth: AutoInfo) {

    /**
     * 日志拦截器
     */
    private val logging by lazy {
        HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.HEADERS)
        }
    }

    private val okHttpClient by lazy {
        val builder = OkHttpClient.Builder().apply {
            connectTimeout(15000, TimeUnit.MILLISECONDS)
            readTimeout(0, TimeUnit.MILLISECONDS)
            // 添加日志拦截器
            addInterceptor(logging)
            addInterceptor(AuthenticationInterceptor(auth))
        }
        builder.build()
    }

    val retrofit: Retrofit by lazy {
        val builder = Retrofit.Builder().apply {
            // 域名
            baseUrl(baseUrl)
            client(okHttpClient)
        }
        builder.build()
    }

    inline fun <reified T> createService(): T {
        return retrofit.create(T::class.java)
    }
}