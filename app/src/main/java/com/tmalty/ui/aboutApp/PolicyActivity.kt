package com.tmalty.ui.aboutApp

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.tmalty.base.BaseActivity
import com.tmalty.databinding.ActivityPolicyBinding

class PolicyActivity : BaseActivity() {
    lateinit var binding: ActivityPolicyBinding
    private val aboutAppViewModel: AboutAppViewModel by viewModels()

    override fun setUpLayoutView(savedInstanceState: Bundle?): View {
        binding = ActivityPolicyBinding.inflate(layoutInflater)
        setupActivity()
        return binding.root
    }

    private fun setupActivity() {
        setupUI()
        setUpData()
    }

    private fun setUpData() {
    }

    fun setupUI() {
    }
}