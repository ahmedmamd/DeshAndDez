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
import androidx.viewpager2.widget.ViewPager2
import com.deshAndDez.R
import com.deshAndDez.base.adapters.CustomBaseAdapter
import com.deshAndDez.commons.helpers.viewpager2_autoscroll_utils.PagerAutoScrollJob
import com.deshAndDez.commons.helpers.viewpager2_autoscroll_utils.SliderITem
import com.deshAndDez.commons.helpers.viewpager2_autoscroll_utils.ViewPager2Utils
import com.deshAndDez.data.models.reels.TutorialVideos
import com.deshAndDez.databinding.ItemHomeReelsBinding
import com.deshAndDez.databinding.ItemReelImagesBinding
import com.deshAndDez.databinding.ItemReelsAdsBinding
import com.deshAndDez.databinding.ItemReelsBinding
import com.deshAndDez.databinding.RecyclerItemLayoutReportBinding
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ReelsAdapter(
    private val coroutineScope: CoroutineScope,
    private val onItemClicked: (TutorialVideos) -> Unit,
    private val onLikesUsersClicked: (TutorialVideos) -> Unit,
    private val onViewsUsersClicked: (TutorialVideos) -> Unit,
    private val onReportClicked: (TutorialVideos) -> Unit,
    private val onFilterClicked: (TutorialVideos) -> Unit,
    private val onCommentsClicked: (TutorialVideos) -> Unit,
) :
    CustomBaseAdapter<TutorialVideos, RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0) {
            val view =
                ItemReelsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(view)
        } else if (viewType == 1){
            val view =
                ItemReelImagesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder1(view)
        } else {
            val view =
                ItemReelsAdsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolderAds(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val item = getItem(position)
        when (holder.itemViewType) {
            0 -> (holder as ViewHolder).bind(item)
            1 -> (holder as ViewHolder1).bind(item)
            2 -> (holder as ViewHolderAds).bind(item)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return when (item.type) {
            "reels" -> 0
            "images" -> 1
            "ads" -> 2
            else -> 3
        }
    }


    inner class ViewHolder(val binding: ItemReelsBinding) : RecyclerView.ViewHolder(binding.root) {
        val coroutineScope = CoroutineScope(Dispatchers.Main)
        var exoPlayer: SimpleExoPlayer? = null

        fun bind(videoItem: TutorialVideos) {
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
                    if (nestedScrollView.isVisible) {
                        menuAds.isVisible = false
                        nestedScrollView.isVisible = false
                        allMenuAds.isVisible = false
                        linearIcons.isVisible = false
                        idAlert.isVisible = false
                        llClearMode.isVisible = true
                    } else {
                        menuAds.isVisible = true
                        nestedScrollView.isVisible = true
                        linearIcons.isVisible = true
                        idAlert.isVisible = true
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
                like.setOnClickListener {
                    lottieAnimationView.isVisible = true
                    lottieAnimationView.setAnimation("love_anim.json")
                    lottieAnimationView.playAnimation()

                    coroutineScope.launch {
                        delay(3000)
                        lottieAnimationView.cancelAnimation()
                        lottieAnimationView.clearAnimation()
                        lottieAnimationView.isVisible = false
                    }
                }
                menuAds.setOnClickListener {
                    menuAds.isVisible = false
                    allMenuAds.isVisible = true
                    val fadeInAnimation: Animation =
                        AnimationUtils.loadAnimation(menuAds.context, R.anim.fade_in)
                    // Hier ersetzen Sie "textView" durch die ID Ihres Views, auf die Sie die Animation anwenden möchten.
                    allMenuAds.startAnimation(fadeInAnimation)
                }
                allAdsBtn.setOnClickListener {
                    menuAds.isVisible = true
                    allMenuAds.isVisible = false
                }

                llNumLikeUsers.setOnClickListener {
                    onLikesUsersClicked(videoItem)
                }
                llNumFollow.setOnClickListener {
                    onViewsUsersClicked(videoItem)
                }
                report.setOnClickListener {
                    onReportClicked(videoItem)
                }
                deutio.setOnClickListener {
                    onFilterClicked(videoItem)
                }
                ivComments.setOnClickListener {
                    onCommentsClicked(videoItem)
                }
                tvComments.setOnClickListener {
                    onCommentsClicked(videoItem)
                }
                nameStar.setSelected(true)

                if (exoPlayer == null) {
                    exoPlayer = SimpleExoPlayer.Builder(root.context).build()
                    idExoPlayerVIew.player = exoPlayer
                    exoPlayer?.repeatMode = Player.REPEAT_MODE_ALL
                }
                // Create and set the SliderITem for the current video
                val videoUri = videoItem.url
                val mediaItem = videoUri?.let { MediaItem.fromUri(it) }
                if (mediaItem != null) {
                    exoPlayer?.setMediaItem(mediaItem)
                }

                // Prepare and start playback
                exoPlayer?.prepare()
                exoPlayer?.playWhenReady = false

            }
        }
    }

    fun stopAutoScroll() {
        PagerAutoScrollJob.stopAutoScroll()
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        super.onViewRecycled(holder)
    }

    inner class ViewHolderAds(val binding: ItemReelsAdsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val coroutineScope = CoroutineScope(Dispatchers.Main)
        var exoPlayer: SimpleExoPlayer? = null

        fun bind(videoItem: TutorialVideos) {
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
                    if (nestedScrollView.isVisible) {
                        nestedScrollView.isVisible = false
                        conSocial.isVisible =false
                        linearIcons.isVisible = false
                        idAlert.isVisible = false
                        llClearMode.isVisible = true
                        userImage.isVisible=false
                    } else {
                        nestedScrollView.isVisible = true
                        linearIcons.isVisible = true
                        idAlert.isVisible = true
                        conSocial.isVisible=true
                        userImage.isVisible=true
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
                like.setOnClickListener {
                    lottieAnimationView.isVisible = true
                    lottieAnimationView.setAnimation("love_anim.json")
                    lottieAnimationView.playAnimation()

                    coroutineScope.launch {
                        delay(3000)
                        lottieAnimationView.cancelAnimation()
                        lottieAnimationView.clearAnimation()
                        lottieAnimationView.isVisible = false
                    }
                }
                if (exoPlayer == null) {
                    exoPlayer = SimpleExoPlayer.Builder(root.context).build()
                    idExoPlayerVIew.player = exoPlayer
                    exoPlayer?.repeatMode = Player.REPEAT_MODE_ALL
                }
                // Create and set the SliderITem for the current video
                val videoUri = videoItem.url
                val mediaItem = videoUri?.let { MediaItem.fromUri(it) }
                if (mediaItem != null) {
                    exoPlayer?.setMediaItem(mediaItem)
                }

                // Prepare and start playback
                exoPlayer?.prepare()
                exoPlayer?.playWhenReady = false
            }
        }
    }
        inner class ViewHolder1(val binding: ItemReelImagesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(videoItem: TutorialVideos) {
            ViewPager2Utils.setupViewPager2AsImageSlider(
                binding.sliderImageViewpager2,
                mutableListOf(
                    SliderITem("https://i.pinimg.com/236x/b2/84/d6/b284d653ff401b21ba345dff6769e5fd.jpg"),
                    SliderITem("https://wallpapers.com/images/hd/samurai-in-japanese-alley-3t4agok0fdvwadfz.jpg"),
                    SliderITem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtiBOMNFs_QYdzDJa1ZYhlCtk9LBo2zcpUwWmvubSv7O1Y9IGzv6__RlKdOIlcD0nMaqA&usqp=CAU")
                )
            )
            binding.apply {
                PagerAutoScrollJob.startAutoScroll(coroutineScope, sliderImageViewpager2)
                dotsIndicator.setViewPager2(sliderImageViewpager2)
                llClearMode.setOnClickListener {
                    if (nestedScrollView.isVisible) {
                        menuAds.isVisible = false
                        nestedScrollView.isVisible = false
                        allMenuAds.isVisible = false
                        linearIcons.isVisible = false
                        idAlert.isVisible = false
                        llClearMode.isVisible = true
                    } else {
                        menuAds.isVisible = true
                        nestedScrollView.isVisible = true
                        linearIcons.isVisible = true
                        idAlert.isVisible = true
                    }
                }
                menuAds.setOnClickListener {
                    menuAds.isVisible = false
                    allMenuAds.isVisible = true
                    val fadeInAnimation: Animation =
                        AnimationUtils.loadAnimation(menuAds.context, R.anim.fade_in)
                    // Hier ersetzen Sie "textView" durch die ID Ihres Views, auf die Sie die Animation anwenden möchten.
                    allMenuAds.startAnimation(fadeInAnimation)
                }
                allAdsBtn.setOnClickListener {
                    menuAds.isVisible = true
                    allMenuAds.isVisible = false
                }

                llNumLikeUsers.setOnClickListener {
                    onLikesUsersClicked(videoItem)
                }
                llNumFollow.setOnClickListener {
                    onViewsUsersClicked(videoItem)
                }
                report.setOnClickListener {
                    onReportClicked(videoItem)
                }
                deutio.setOnClickListener {
                    onFilterClicked(videoItem)
                }
                ivComments.setOnClickListener {
                    onCommentsClicked(videoItem)
                }
                tvComments.setOnClickListener {
                    onCommentsClicked(videoItem)
                }
                nameStar.setSelected(true)
            }
        }
    }


}