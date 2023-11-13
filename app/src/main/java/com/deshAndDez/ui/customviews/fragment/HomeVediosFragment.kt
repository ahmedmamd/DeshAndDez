package com.deshAndDez.ui.customviews.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.deshAndDez.R
import com.deshAndDez.base.BaseFragment
import com.deshAndDez.databinding.FragmentVidesPlayerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeVediosFragment : BaseFragment(R.layout.fragment_vides_player) {

    private lateinit var binding: FragmentVidesPlayerBinding
//    private val viewModel: TutorialViewModel by activityViewModels()


    val videosAdapter by lazy {
//        VideosAdapter(
//            requireActivity(),
//            onSearchHasTag = { searchFor(it) },
//            onOpenProfile = { openProfile(it) },
//            onComments = { openComments(it.first, it.second) },
//            onToggleFollow = { toggleFollow(it) },
//            onFavorite = { addFavorite(it) },
//            onSaved = { toggleSaved(it) },
//            myImage = getUserImage(),
//            viewModel = viewModel,
//            fragment = this
//        )
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        binding.apply {
            swipeRefresh.setOnRefreshListener {
//                videosAdapter.refresh()
//                viewModel.refreshList()


//                binding.viewPager2.postInvalidate()

//                viewPager2.currentItem = 0
//                videosAdapter.currentPosition = 0

            }
//                videosAdapter.currentPosition = 0

            observeFlow()

//            viewPager2.adapter = videosAdapter
//            viewPager2.offscreenPageLimit = 4
//            viewPager2.setHasTransientState(false)
            viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
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
        setAdapterStates()
    }


    private fun setAdapterStates() {

    }

    private fun observeFlow() {

//        handleSharedFlow(viewModel.randomVideo, onSuccess = {
//            Toast.makeText(requireContext(), " " + it, Toast.LENGTH_SHORT).show()
//            if (it is ArrayList<*>) {
//                Log.e(TAG, "observeFlow:random video ${it} " )
//                homeVideosAdapter.setAll(it as ArrayList<TutorialModel>)
//            }
//        })


        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
//            viewModel.list.collectLatest {
//                videosAdapter.submitData(it)
//            }
        }
    }

    override fun onPause() {
        super.onPause()
//        videosAdapter.pauseVideo()
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        videosAdapter.removeVideo()
//        videosAdapter.viewHolderList.forEach { item ->
//            videosAdapter.viewHolderList[if (item.layoutPosition < 0) 0 else item.layoutPosition].item.idExoPlayerVIew.player?.release()
//        }
    }

//    override fun onResume() {
//        super.onResume()
//        viewModel.randomVideo(1)
//    }
}