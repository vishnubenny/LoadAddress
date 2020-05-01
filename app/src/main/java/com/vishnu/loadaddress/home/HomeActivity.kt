package com.vishnu.loadaddress.home

import com.vishnu.core.BaseActivity
import com.vishnu.loadaddress.BR
import com.vishnu.loadaddress.R
import com.vishnu.loadaddress.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity<HomeNavigator, ActivityHomeBinding, HomeViewModel>() {

    private val listener = object : HomeNavigator {

    }

    override fun getLayoutId(): Int = R.layout.activity_home

    override fun getViewModel(): HomeViewModel = HomeViewModel()

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getNavigator(): HomeNavigator = listener

}
