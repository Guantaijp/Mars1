package com.example.mars1

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mars1.network.MarsPhotos
import kotlin.jvm.JvmStatic as JvmStatic1

class BindingAdapters {

    companion object{
        @JvmStatic1
    @BindingAdapter("listData")
        fun bindRecyclerView(recyclerView: RecyclerView,
                         data: List<MarsPhotos>?) {
        val adapter = recyclerView.adapter as PhotoGridAdapter
        adapter.submitList(data)
    }


    @JvmStatic1
    @BindingAdapter("imageUrl")
    fun bindImage(imgView: ImageView, imgUrl: String?, ) {
        imgUrl ?.let {
            val imgUrl = imgUrl.toUri().buildUpon().scheme("https").build()
                imgView.load(imgUrl){
                    placeholder(R.drawable.loading_animation)
                    error(R.drawable.ic_broken_image)
                }
        }
    }
}}