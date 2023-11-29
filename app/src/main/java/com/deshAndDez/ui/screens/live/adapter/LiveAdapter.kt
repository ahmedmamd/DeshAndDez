package com.deshAndDez.ui.screens.live.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deshAndDez.R
import com.deshAndDez.base.adapters.CustomBaseAdapter
import com.deshAndDez.commons.helpers.viewpager2_autoscroll_utils.PagerAutoScrollJob
import com.deshAndDez.data.models.all_reels_tutorial.TutorialVideos
import com.deshAndDez.databinding.ItemLiveBinding
import com.deshAndDez.data.models.all_reels.comments.Comment
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LiveAdapter(
    private val coroutineScope: CoroutineScope,
    private val onItemClicked: (TutorialVideos) -> Unit,
    private val onLikesUsersClicked: (TutorialVideos) -> Unit,
    private val onViewsUsersClicked: (TutorialVideos) -> Unit,
    private val onReportClicked: (TutorialVideos) -> Unit,
    private val onFilterClicked: (TutorialVideos) -> Unit,
    private val onCommentsClicked: (TutorialVideos) -> Unit,
    private val onViewAllImagesClicked: (TutorialVideos) -> Unit,
    private val onViewUserImageClicked: (TutorialVideos) -> Unit,
) : CustomBaseAdapter<TutorialVideos, RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view =
                ItemLiveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
       ( holder as ViewHolder).bind(item)
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }

    inner class ViewHolder(val binding: ItemLiveBinding) : RecyclerView.ViewHolder(binding.root) {
        val coroutineScope = CoroutineScope(Dispatchers.Main)
        var exoPlayer: SimpleExoPlayer? = null
        val commentAdapter  = CommentsLiveAdapter()
        val commentsList = ArrayList<Comment>()

        fun bind(videoItem: TutorialVideos) {
            binding.apply {
                commentsList.add(Comment(image = R.drawable.test_user_image2))
                commentsList.add(Comment(image = R.drawable.test_user_image1))
                commentsList.add(Comment(image = R.drawable.test_user_image2))
                commentsList.add(Comment(image = R.drawable.test_user_image3))
                commentAdapter.setData(commentsList)

                rvComments.apply {
                    layoutManager = LinearLayoutManager(binding.root.context)
                    adapter = commentAdapter
                }

                Log.e("TAG", "bindjjjjjjjjjjj: ${commentAdapter.itemCount}" )
                sound.setOnClickListener {
                    if (idExoPlayerVIew.player?.volume == 0f) {
                        idExoPlayerVIew.player?.volume = 1f
                        sound.setImageResource(R.drawable.sound)
                    } else {
                        idExoPlayerVIew.player?.volume = 0f
                        sound.setImageResource(R.drawable.mute_icon)
                    }
                }
                userImage.setOnClickListener {
                    onViewUserImageClicked(videoItem)
                }

                llClearMode.setOnClickListener {
                    if (conLive.isVisible) {
                        menuAds.isVisible = false
                        conLive.isVisible = false
                        allMenuAds.isVisible = false
                        linearIcons.isVisible = false
                        idAlert.isVisible = false
                        llClearMode.isVisible = true
                    } else {
                        menuAds.isVisible = true
                        conLive.isVisible = true
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

//                exoPlayer?.play()
            }
        }
    }

    fun stopAutoScroll() {
        PagerAutoScrollJob.stopAutoScroll()
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        super.onViewRecycled(holder)
    }

}