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

package com.che2n3jigw.android.libs.subsonicapi.interceptor

import com.che2n3jigw.android.libs.subsonicapi.bean.AutoInfo
import okhttp3.Interceptor
import okhttp3.Response

/**
 * 认证拦截器
 */
class AuthenticationInterceptor(
    private val auth: AutoInfo
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        // 原始请求
        val originalRequest = chain.request()
        // 原始请求地址
        val originalHttpUrl = originalRequest.url
        // 原始地址追加参数
        val url = originalHttpUrl.newBuilder()
            // 用户名
            .addQueryParameter("u", auth.username)
            // 密码
            .addQueryParameter("p", auth.password)
            // 协议版本
            .addQueryParameter("v", auth.version)
            // 客户端标识
            .addQueryParameter("c", auth.client)
            // 响应数据格式 json
            .addQueryParameter("f", auth.format)
            .build()

        val request = originalRequest.newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }
}