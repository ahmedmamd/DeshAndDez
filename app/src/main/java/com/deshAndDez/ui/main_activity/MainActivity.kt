package com.deshAndDez.ui.main_activity

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.deshAndDez.R
import com.deshAndDez.base.BaseActivity
import com.deshAndDez.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity(){

    private lateinit var binding: ActivityMainBinding
    private var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

    }

    override fun onBackPressed() {
        if (navController == null) finish()
        if (navController?.navigateUp()?.not() == true)
            super.onBackPressed()
    }


}