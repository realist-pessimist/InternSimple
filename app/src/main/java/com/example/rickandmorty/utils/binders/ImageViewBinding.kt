package com.example.rickandmorty.utils.binders

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.rickandmorty.R

@BindingAdapter(value = ["imageUrl", "imageCircle", "placeholder"], requireAll = false)
fun loadImage(
    view: ImageView,
    url: String?,
    isCircle: Boolean,
    @DrawableRes placeholderId: Int = R.drawable.ic_person_placeholder
) {
    Glide.with(view.context)
        .load(url ?: "")
        .transform(if (isCircle) CircleCrop() else CenterCrop())
        .placeholder(placeholderId)
        .into(view)
}
