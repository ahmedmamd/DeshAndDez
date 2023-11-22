package com.deshAndDez.ui.screens.interest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.deshAndDez.R
import com.deshAndDez.base.BaseFragment
import com.deshAndDez.commons.helpers.viewpager2_autoscroll_utils.SliderITem
import com.deshAndDez.commons.helpers.viewpager2_autoscroll_utils.ViewPager2Utils
import com.deshAndDez.databinding.FragmentImagesSliderBinding
import com.deshAndDez.databinding.FragmentInterestsBinding
import com.deshAndDez.databinding.FragmentLanguageBinding
import com.deshAndDez.databinding.FragmentViewsBinding
import com.deshAndDez.ui.adapters.*

class ImagesSliderFragment : BaseFragment(R.layout.fragment_images_slider) {

    // Declare view and objects
    lateinit var binding: FragmentImagesSliderBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentImagesSliderBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImagesSliderBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupListeners()
    }


    // Set up the UI components
    private fun setupUI() {
        // Set up any UI-related configurations here
        ViewPager2Utils.setupViewPager2AsImageSlider(
            binding.sliderImageViewpager2,
            mutableListOf(
                SliderITem("https://i.pinimg.com/236x/b2/84/d6/b284d653ff401b21ba345dff6769e5fd.jpg"),
                SliderITem("https://wallpapers.com/images/hd/samurai-in-japanese-alley-3t4agok0fdvwadfz.jpg"),
                SliderITem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtiBOMNFs_QYdzDJa1ZYhlCtk9LBo2zcpUwWmvubSv7O1Y9IGzv6__RlKdOIlcD0nMaqA&usqp=CAU")
            )
        )
    }


    // Set up event listeners for button clicks and other interactions
    private fun setupListeners() {
        binding.backImageview.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}