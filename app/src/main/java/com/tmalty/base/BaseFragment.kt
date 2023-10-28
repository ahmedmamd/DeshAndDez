package com.tmalty.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.tmalty.commons.events.EventBus
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
abstract class BaseFragment(@LayoutRes val resId: Int?) : Fragment() {
    @Inject
    lateinit var intEventBus: EventBus<Int>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return resId?.let {
            inflater.inflate(resId, container, false)
        }
    }
}