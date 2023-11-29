package com.deshAndDez.ui.main_activity

import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.deshAndDez.R
import com.deshAndDez.base.BaseActivity
import com.deshAndDez.databinding.ActivityMainBinding
import com.deshAndDez.ui.fragment.HomeVediosFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity(){

    private lateinit var binding: ActivityMainBinding
    private var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFragment(HomeVediosFragment())
//        window.statusBarColor = ContextCompat.getColor(this, R.color.transparent)

    }

    fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
    }
