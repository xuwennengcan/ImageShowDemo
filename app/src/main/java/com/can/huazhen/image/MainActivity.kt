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

    private val image = "https://static.dingtalk.com/media/lADPDgQ9qb7pRqvNC9DND8A_4032_3024.jpg?auth_bizType=IM&auth_bizEntity=%7B%22cid%22%3A%224248001%3A284146280%22%2C%22msgId%22%3A%22769665707059%22%7D&open_id=284146280"
    private val thumb = "https://raw.githubusercontent.com/sfsheng0322/GlideImageView/master/resources/cat_thumbnail.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val options : RequestOptions = RequestOptions().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE)

        iv = findViewById(R.id.iv)
        cpv = findViewById(R.id.cpv)

        val load = iv!!.imageLoader

        iv!!.apply(options).error(R.drawable.drawable_default)

        iv!!.load(image,0) {
            isComplete, percentage, bytesRead, totalBytes ->
            cpv!!.progress = percentage
            cpv!!.visibility = if(isComplete) View.GONE else View.VISIBLE
            Log.i("ImageLoader","isComplete = $isComplete , percentage = $percentage , bytesRead =  $bytesRead , totalBytes = $totalBytes ")
        }
    }
}
