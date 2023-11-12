package com.deshAndDez.ui.aboutApp

import android.os.Bundle
import androidx.activity.viewModels
import com.deshAndDez.base.BaseActivity
import com.deshAndDez.databinding.ActivityAboutUsBinding

class AboutUsActivity : BaseActivity() {

    lateinit var binding : ActivityAboutUsBinding
    val aboutAppViewModel : AboutAppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActivity()
    }


    private fun setupActivity() {
        setupUI()
        setUpData()
    }

    private fun setUpData() {
    }

    fun setupUI(){
    }

}