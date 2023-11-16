package com.deshAndDez.ui.fragment.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.deshAndDez.R
import com.deshAndDez.base.adapters.CustomBaseAdapter
import com.deshAndDez.data.models.reels.TutorialVideos
import com.deshAndDez.databinding.ItemHomeReelsBinding
import com.deshAndDez.databinding.ItemReelsBinding
import com.deshAndDez.databinding.RecyclerItemLayoutReportBinding
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer

class ReelsAdapter(private val onItemClicked: (TutorialVideos) -> Unit) :
    CustomBaseAdapter<TutorialVideos, ReelsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemReelsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(val binding: ItemReelsBinding) : RecyclerView.ViewHolder(binding.root) {
        //        private val binding = ItemReelsBinding.bind(itemView)
        init {
            binding.apply {
                sound.setOnClickListener {
                    if (idExoPlayerVIew.player?.volume == 0f) {
                        idExoPlayerVIew.player?.volume = 1f
                        sound.setImageResource(R.drawable.sound)
                    } else {
                        idExoPlayerVIew.player?.volume = 0f
                        sound.setImageResource(R.drawable.mute_icon)
                    }
                }

                llClearMode.setOnClickListener {
                    if (nestedScrollView.isVisible){
                        menuAds.isVisible=false
                        nestedScrollView.isVisible=false
                        allMenuAds.isVisible =false
                        linearIcons.isVisible=false
                        idAlert.isVisible=false
                        llClearMode.isVisible=true
                    }else{
                        menuAds.isVisible=true
                        nestedScrollView.isVisible=true
                        allMenuAds.isVisible =true
                        linearIcons.isVisible=true
                        idAlert.isVisible=true
                    }
                }

                idExoPlayerVIew.setOnClickListener {
                    if (idExoPlayerVIew.player?.isPlaying == true) {
                        idExoPlayerVIewPause.isVisible = true
                        idExoPlayerVIew.player?.pause()
                    } else {
                        idExoPlayerVIew.player?.play()
                        idExoPlayerVIewPause.isVisible = false
                    }
                }
                menuAds.setOnClickListener {
                    menuAds.isVisible=false
                    allMenuAds.isVisible =true
                    val fadeInAnimation: Animation =
                        AnimationUtils.loadAnimation(menuAds.context, R.anim.fade_in)
                    // Hier ersetzen Sie "textView" durch die ID Ihres Views, auf die Sie die Animation anwenden möchten.
                    allMenuAds.startAnimation(fadeInAnimation)
                }
                allAdsBtn.setOnClickListener {
                    menuAds.isVisible=true
                    allMenuAds.isVisible =false
                }


            }
        }


         var exoPlayer: SimpleExoPlayer? = null

        fun bind(data: TutorialVideos) {
            Log.e("onResume", " adapter position data  " + data)

            binding.apply {
                nameStar.setSelected(true)

                if (exoPlayer == null) {
                    exoPlayer = SimpleExoPlayer.Builder(root.context).build()
                    idExoPlayerVIew.player = exoPlayer
                    exoPlayer?.repeatMode = Player.REPEAT_MODE_ALL
                }

                // Create and set the MediaItem for the current video
                val videoUri = data.url
                val mediaItem = videoUri?.let { MediaItem.fromUri(it) }
                if (mediaItem != null) {
                    exoPlayer?.setMediaItem(mediaItem)
                }

                // Prepare and start playback
                exoPlayer?.prepare()
                exoPlayer?.playWhenReady = false

//                exoPlayer?.play()
            }
        }
    }
}