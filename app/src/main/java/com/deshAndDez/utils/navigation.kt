package com.deshAndDez.utils

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.deshAndDez.R



    fun FragmentActivity.replaceFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.beginTransaction().apply {
            replace(frameId, fragment)
            addToBackStack(null)
            commit()
        }
    }

    fun FragmentActivity.addFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.beginTransaction().apply {
            add(frameId, fragment)
            addToBackStack(null) // Optional. Remove if you don't want this transaction in the back stack.
            commit()
        }
    }


    fun FragmentActivity.replaceFragmentWithStack(fragment: Fragment, frameId: Int) {
        supportFragmentManager.beginTransaction().apply {
            replace(frameId, fragment)
            commit()
        }
    }

    fun FragmentActivity.addFragmentWithStack(fragment: Fragment, frameId: Int) {
        supportFragmentManager.beginTransaction().apply {
            add(frameId, fragment)
            commit()
        }
    }
