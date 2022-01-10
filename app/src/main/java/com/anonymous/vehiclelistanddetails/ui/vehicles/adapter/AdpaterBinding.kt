package com.anonymous.vehiclelistanddetails.ui.vehicles.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageResource")
fun setImage(imageView: ImageView,source:String?){
    source?.let {
        Glide.with(imageView.context).load(source).into(imageView)
    }
}