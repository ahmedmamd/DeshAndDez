package com.deshAndDez.commons.helpers.viewpager2_autoscroll_utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.deshAndDez.R
import kotlinx.coroutines.CoroutineScope

class ViewPager2Utils {
    companion object {
        fun setupViewPager2AsImageSlider(viewPager2: ViewPager2, imageUrls: List<SliderITem>) {
            val adapter = ImageSliderAdapter(imageUrls)
            viewPager2.adapter = adapter
        }
    }

    internal class ImageSliderAdapter(private val imageUrls: List<SliderITem>) :
        RecyclerView.Adapter<ImageSliderAdapter.ImageSliderViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSliderViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout_image_slider, parent, false)
            return ImageSliderViewHolder(view)
        }

        override fun onBindViewHolder(holder: ImageSliderViewHolder, position: Int) {
            val imagePath = imageUrls[position].imageUrl
            // Load and display the image using an image loading library (e.g., Picasso, Glide)
            Glide.with(holder.imageView.context)
                .load(imagePath)
                .into(holder.imageView)
        }

        override fun getItemCount(): Int {
            return imageUrls.size
        }

        inner class ImageSliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imageView: ImageView = itemView.findViewById(R.id.slider_image_imageview)
        }
    }
}
