package com.heptagon.heptagontaskappdemo.utils
import android.content.Context
import android.widget.ImageView
import com.pixplicity.sharp.Sharp
import okhttp3.*
import java.io.IOException
import java.io.InputStream


object SVGImageLoader {

    private var httpClient: OkHttpClient? = null

    fun fetchSvg(context: Context, url: String?, target: ImageView) {
        if (httpClient == null) {
            httpClient = OkHttpClient.Builder()
                .cache(Cache(context.cacheDir, 5 * 1024 * 1014))
                .build()
        }
        val request: Request? = url?.let { Request.Builder().url(it).build() }
        if (request != null) {
            httpClient!!.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                }

                override fun onResponse(call: Call, response: Response) {
                    val stream: InputStream? = response.body?.byteStream()
                    Sharp.loadInputStream(stream).into(target)
                    stream?.close()
                }

            })
        }


    }
}