package com.deshAndDez.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.deshAndDez.R
import com.deshAndDez.base.BaseFragment
import com.deshAndDez.data.models.reels.TutorialVideos
import com.deshAndDez.databinding.FragmentVidesPlayerBinding
import com.deshAndDez.ui.dialogs.CommentsSheet
import com.deshAndDez.ui.dialogs.ReportConfirmationDialog
import com.deshAndDez.ui.fragment.adapter.ReelsAdapter
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "HomeVediosFragment"
@AndroidEntryPoint
class HomeVediosFragment : BaseFragment(R.layout.fragment_vides_player) {

    private lateinit var binding: FragmentVidesPlayerBinding
//    private val viewModel: TutorialViewModel by activityViewModels()


    val videosAdapter by lazy {
        ReelsAdapter(lifecycleScope,onItemClicked = {}, onLikesUsersClicked = {
            findNavController().navigate(R.id.paymentFragment)
        }, onViewsUsersClicked = {
            findNavController().navigate(R.id.viewsFragment)
        }, onReportClicked = {
            ReportConfirmationDialog(requireActivity(), onYesClick = {
                findNavController().navigate(R.id.reportStepOneFragment)
            }).show()
        }, onFilterClicked = {
            findNavController().navigate(R.id.filterFragment)
        }, onCommentsClicked = {
            CommentsSheet(requireActivity()).show()
        }, onViewAllImagesClicked = {
            openImagesSlider()
        })
    }

    private fun openImagesSlider() {
        findNavController().navigate(R.id.imagesSliderFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVidesPlayerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        requireActivity().window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        clearStackOfReport()
        setUpAdapter()

        binding.apply {
            swipeRefresh.setOnRefreshListener {
            }

            observeFlow()


        }

    }

    private fun clearStackOfReport() {
//        findNavController().popBackStack(R.id.reportStepOneFragment, false)
//        findNavController().popBackStack(R.id.reportStepTwoFragment, false)
//        findNavController().popBackStack(R.id.reportStepThreeFragment, false)
//        findNavController().popBackStack(R.id.reportStepFourFragment, false)
    }

    private fun setUpAdapter() {
        binding.apply {
            viewPager2.adapter = videosAdapter
            dotsIndicator.setViewPager2(viewPager2)
            viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    pauseAllPlayers()

                    // Play the selected video
                    // Play the current video
                    val currentViewHolder =
                        (binding.viewPager2.getChildAt(0) as RecyclerView).findViewHolderForAdapterPosition(
                            position
                        )
//                                as? ReelsAdapter.ViewHolder
                    when (currentViewHolder) {
                        is ReelsAdapter.ViewHolder -> {
                            currentViewHolder?.exoPlayer?.playWhenReady = true
                            currentViewHolder?.exoPlayer?.play()
                            currentViewHolder?.binding?.idExoPlayerVIewPause?.isVisible = false
                        }
                        is ReelsAdapter.ViewHolder1 -> {
                            // If ViewHolder1 also has an exoPlayer, pause it here
                            // currentViewHolder.exoPlayer?.playWhenReady = false
                            // currentViewHolder.exoPlayer?.pause()
                        }
                        is ReelsAdapter.ViewHolderAds -> {
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
                is ReelsAdapter.ViewHolder -> {
                    viewHolder.exoPlayer?.playWhenReady = false
                    viewHolder.exoPlayer?.pause()
                }
                is ReelsAdapter.ViewHolder1 -> {
                    // If ViewHolder1 also has an exoPlayer, pause it here
                    // viewHolder.exoPlayer?.playWhenReady = false
                    // viewHolder.exoPlayer?.pause()
                }
                is ReelsAdapter.ViewHolderAds -> {
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
                ) as? ReelsAdapter.ViewHolder
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
                url = "https://chefshub.site//storage//videos//1696189889.mp4", type = "images"
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