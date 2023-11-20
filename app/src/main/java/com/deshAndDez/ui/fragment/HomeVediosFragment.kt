package com.deshAndDez.ui.fragment

import android.os.Bundle
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

@AndroidEntryPoint
class HomeVediosFragment : BaseFragment(R.layout.fragment_vides_player) {

    private lateinit var binding: FragmentVidesPlayerBinding
//    private val viewModel: TutorialViewModel by activityViewModels()


    val videosAdapter by lazy {
        ReelsAdapter(lifecycleScope,onItemClicked = {}, onLikesUsersClicked = {
            findNavController().navigate(R.id.likesFragment)
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
        })
    }
//
//    private fun toggleSaved(it: Int) {
//        if (PreferencesGateway(requireContext()).isSaved(PrefKeys.IS_USER_LOGGED).not()) {
//            videosAdapter.removeVideo()
//            (activity as BaseActivity).apply {
//                videosAdapter.removeVideo()
//                startActivity(LoginActivity::class.java)
//            }
//        }
//        viewModel.addSavedVideo(it)
//    }
//
//    private fun toggleFollow(it: Int) {
//        viewModel.toggleFollow(it)
//    }
//
//    private fun addFavorite(it: Int) {
//        viewModel.addFavorite(it)
//    }
//
//    @Inject
//    lateinit var preferencesGateway: PreferencesGateway
//    private fun getUserImage() = preferencesGateway.load(PrefKeys.USER, UserModel())?.avatarPath
//
//    private fun openProfile(it: Int) {
//        findNavController().navigate(R.id.profileFragmentFragment, bundleOf("value" to it))
//    }
//
//    private fun searchFor(it: String) {
//        findNavController().navigate(R.id.navigation_search, bundleOf("value" to it))
//    }
//
//    private fun openComments(id: Int, num: Int) {
//        findNavController().navigate(
//            R.id.commentsFragment,
//            bundleOf(CommentsFragment.POST_ID to id, CommentsFragment.NUM_COMMENTS to num)
//        )
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVidesPlayerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
//    private lateinit var internalRecyclerView: RecyclerView

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
                        ) as? ReelsAdapter.ViewHolder
                    currentViewHolder?.exoPlayer?.playWhenReady = true
                    currentViewHolder?.binding?.idExoPlayerVIewPause?.isVisible = false
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
            val viewHolder =
                (binding.viewPager2.getChildAt(0) as RecyclerView).findViewHolderForAdapterPosition(
                    i
                ) as? ReelsAdapter.ViewHolder
            viewHolder?.exoPlayer?.playWhenReady = false
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

        var list = ArrayList<TutorialVideos>()
        list.add(
            TutorialVideos(
                1,
                null,
                url = "https://chefshub.site//storage//videos//1696189889.mp4"
            )
        )
        list.add(
            TutorialVideos(
                2,
                null,
                url = "https://chefshub.site//storage//videos//1696189889.mp4"
            )
        )
        list.add(
            TutorialVideos(
                3,
                null,
                url = "https://chefshub.site//storage//videos//1696189889.mp4"
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