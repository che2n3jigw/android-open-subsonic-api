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
package com.che2n3jigw.android.libs.opensubsonicapi.download

import android.content.Context
import android.util.Log
import android.webkit.MimeTypeMap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.File

/**
 * Subsonic资源下载工具类(示例,请根据实际情况修改)
 */
object DownloadUtils {

    private const val TAG = "DownloadUtils"

    /**
     * 保存文件
     * @param fileNameAndType 明确文件名字和类型
     */
    suspend fun download(
        context: Context,
        response: Response<ResponseBody>?,
        fileNameAndType: String? = null
    ) {
        response ?: return
        withContext(Dispatchers.IO) {
            val file = getFile(context, response, fileNameAndType)
            response.body()?.byteStream().use { input ->
                file.outputStream().use { output ->
                    input?.copyTo(output)
                }
            }
            Log.d(TAG, "Saved to: ${file.absolutePath}")
        }
    }

    private fun getFile(
        context: Context,
        response: Response<ResponseBody>,
        fileNameAndType: String? = null
    ): File {
        val file: File
        if (!fileNameAndType.isNullOrEmpty()) {
            return File(context.getExternalFilesDir(null), fileNameAndType)
        }

        // 文件名
        val fileName = parseFileName(response.headers()["Content-Disposition"])
        Log.d(TAG, "download: fileName = $fileName")
        if (fileName.isNullOrEmpty()) {
            // 文件类型
            val contentType = response.body()?.contentType()?.toString()
            val extension = MimeTypeMap.getSingleton().getExtensionFromMimeType(contentType)
            Log.d(TAG, "download: fileType = $extension")
            file = if (extension.isNullOrEmpty()) {
                File(context.getExternalFilesDir(null), "file")
            } else {
                File(context.getExternalFilesDir(null), "file.$extension")
            }
        } else {
            file = File(context.getExternalFilesDir(null), fileName)
        }
        return file
    }

    /**
     * 解析文件名
     */
    private fun parseFileName(contentDisposition: String?): String? {
        if (contentDisposition == null) return null

        // 方案 A：快速正则匹配 filename="xxx"
        val filenameRegex = "filename\\*?=['\"]?([^'\";]+)['\"]?".toRegex(RegexOption.IGNORE_CASE)
        val matchResult = filenameRegex.find(contentDisposition)

        return matchResult?.groupValues?.get(1)?.let { rawName ->
            // 方案 B：如果是 URL 编码过的（例如 filename*=UTF-8''...），需要解码
            try {
                java.net.URLDecoder.decode(rawName, "UTF-8")
            } catch (e: Exception) {
                rawName
            }
        }
    }
}