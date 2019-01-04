package com.can.huazhen.image

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.can.huazhen.image.widget.CircleProgressView
import com.can.huazhen.image.widget.GlideImageView

class MainActivity : Activity() {

    private var iv: GlideImageView? = null
    private var cpv : CircleProgressView?=null

    private val image = "https://raw.githubusercontent.com/sfsheng0322/GlideImageView/master/resources/cat.jpg"
    private val thumb = "https://raw.githubusercontent.com/sfsheng0322/GlideImageView/master/resources/cat_thumbnail.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val options : RequestOptions = RequestOptions().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE)

        iv = findViewById(R.id.iv)
        cpv = findViewById(R.id.cpv)

        val load = iv!!.imageLoader

        iv!!.apply(options).error(R.drawable.drawable_default)

        iv!!.load(image,R.drawable.drawable_default) {
            isComplete, percentage, bytesRead, totalBytes ->
            cpv!!.progress = percentage
            cpv!!.visibility = if(isComplete) View.GONE else View.VISIBLE
            Log.i("ImageLoader","isComplete = $isComplete , percentage = $percentage , bytesRead =  $bytesRead , totalBytes = $totalBytes ")
        }
    }
}
