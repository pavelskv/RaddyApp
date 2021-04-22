package com.shechkov.raddyapp.ui.home

import android.os.Bundle
import android.view.View
import com.shechkov.raddyapp.databinding.FragmentHomeBinding
import com.shechkov.raddyapp.databinding.FragmentLoginBinding
import com.shechkov.raddyapp.ui.base.BaseFragment

class HomeFragment: BaseFragment<HomeViewModel, FragmentHomeBinding>(
    FragmentHomeBinding::inflate
){

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getViewModel(): Class<HomeViewModel> = HomeViewModel::class.java

}