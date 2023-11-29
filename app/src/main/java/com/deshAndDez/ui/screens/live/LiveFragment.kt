package com.deshAndDez.ui.screens.live

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.deshAndDez.R
import com.deshAndDez.base.BaseFragment
import com.deshAndDez.data.models.all_reels_tutorial.TutorialVideos
import com.deshAndDez.databinding.FragmentLivePlayerBinding
import com.deshAndDez.ui.dialogs.CommentsSheet
import com.deshAndDez.ui.dialogs.ReportConfirmationDialog
import com.deshAndDez.ui.screens.filter.FilterFragment
import com.deshAndDez.ui.screens.interest.ImagesSliderFragment
import com.deshAndDez.ui.screens.likes.LikesFragment
import com.deshAndDez.ui.screens.live.adapter.LiveAdapter
import com.deshAndDez.ui.screens.report.ReportStepOneFragment
import com.deshAndDez.ui.screens.views.ViewsFragment
import com.deshAndDez.utils.replaceFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LiveFragment : BaseFragment(R.layout.fragment_live_player) {

    private lateinit var binding: FragmentLivePlayerBinding
//    private val viewModel: TutorialViewModel by activityViewModels()

    val videosAdapter by lazy {
        LiveAdapter(lifecycleScope, onItemClicked = {}, onLikesUsersClicked = {
            activity?.replaceFragment(LikesFragment(), R.id.fragment_container)
        }, onViewsUsersClicked = {
            activity?.replaceFragment(ViewsFragment(), R.id.fragment_container)
        }, onReportClicked = {
            ReportConfirmationDialog(requireActivity(), onYesClick = {
                activity?.replaceFragment(ReportStepOneFragment(), R.id.fragment_container)
            }).show()
        }, onFilterClicked = {
            activity?.replaceFragment(FilterFragment(), R.id.fragment_container)
        }, onCommentsClicked = {
            CommentsSheet(requireActivity()).show()
        }, onViewAllImagesClicked = {
            openImagesSlider()
        }, onViewUserImageClicked = {
        })
    }

    private fun openImagesSlider() {
        activity?.replaceFragment(ImagesSliderFragment(), R.id.fragment_container)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLivePlayerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        requireActivity().window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setUpAdapter()

        binding.apply {
            swipeRefresh.setOnRefreshListener {
            }
            observeFlow()
        }
    }

    private fun setUpAdapter() {
        binding.apply {
            viewPager2.adapter = videosAdapter
            viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    pauseAllPlayers()

                    val currentViewHolder =
                        (binding.viewPager2.getChildAt(0) as RecyclerView).findViewHolderForAdapterPosition(
                            position
                        )
                    when (currentViewHolder) {
                        is LiveAdapter.ViewHolder -> {
                            currentViewHolder?.exoPlayer?.playWhenReady = true
                            currentViewHolder?.exoPlayer?.play()
                            currentViewHolder?.binding?.idExoPlayerVIewPause?.isVisible = false
                        }
                    }
                }

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)

                }

                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                }
            })
        }
    }


    fun pauseAllPlayers() {
        for (i in 0 until videosAdapter.itemCount) {
            val viewHolder = (binding.viewPager2.getChildAt(0) as RecyclerView)
                .findViewHolderForAdapterPosition(i)

            when (viewHolder) {
                is LiveAdapter.ViewHolder -> {
                    viewHolder.exoPlayer?.playWhenReady = false
                    viewHolder.exoPlayer?.pause()
                }
            }
        }
    }


    fun releaseAllPlayers() {
        for (i in 0 until videosAdapter.itemCount) {
            val viewHolder =
                (binding.viewPager2.getChildAt(0) as RecyclerView).findViewHolderForAdapterPosition(
                    i
                ) as? LiveAdapter.ViewHolder
            viewHolder?.exoPlayer?.release()
        }
    }


    private fun observeFlow() {

        val list = ArrayList<TutorialVideos>()
        list.add(
            TutorialVideos(
                1,
                null,
                url = "https://chefshub.site//storage//videos//1696189889.mp4", type = "reels"
            )
        )
        list.add(
            TutorialVideos(
                2,
                null,
                url = "https://chefshub.site//storage//videos//1692733836.mp4", type = "images"
            )
        )
        list.add(
            TutorialVideos(
                3,
                null,
                url = "https://chefshub.site//storage//videos//1696189889.mp4", type = "ads"
            )
        )
        videosAdapter.setData(list)
    }

    override fun onPause() {
        super.onPause()
        pauseAllPlayers()
        videosAdapter.stopAutoScroll()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        releaseAllPlayers()
    }

}