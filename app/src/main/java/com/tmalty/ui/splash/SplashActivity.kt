package com.tmalty.ui.splash

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.tmalty.base.BaseActivity
import com.tmalty.databinding.ActivityMainBinding
import com.tmalty.databinding.ActivitySplashBinding
import com.tmalty.ui.auth.login.LoginActivity
import com.tmalty.ui.main.activities.MainActivity
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {

    //declare view and objects
    lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActivity()
    }

    //Entry point to this activity
    private fun setupActivity() {
//        setUpNotification()
        lifecycleScope.launch {
            viewModel.uiSuccessState.collectLatest { resultState ->
                when (resultState) {
                    SplashUiState.Initial -> {}
                    is SplashUiState.AuthenticatedUserState -> {
                        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                        finish()
                    }
                    is SplashUiState.UnAuthenticatedUserState -> {
                        startActivity(
                            Intent(
                                this@SplashActivity, LoginActivity::class.java
                            )
                        )
                        finish()
                    }
                }
            }
        }
        viewModel.startSplashTimer()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}