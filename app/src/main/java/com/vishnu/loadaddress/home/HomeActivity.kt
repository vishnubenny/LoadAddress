package com.vishnu.loadaddress.home

import android.os.Bundle
import com.jakewharton.rxbinding3.widget.textChanges
import com.vishnu.core.BaseActivity
import com.vishnu.loadaddress.BR
import com.vishnu.loadaddress.R
import com.vishnu.loadaddress.databinding.ActivityHomeBinding
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity<HomeNavigator, ActivityHomeBinding, HomeViewModel>() {

    private val homeViewModel: HomeViewModel by viewModel()

    private val listener = object : HomeNavigator {
        override fun getSearchLocationChanges(): Observable<CharSequence> {
            return edtTextSearch.textChanges()
        }
    }

    override fun getLayoutId(): Int = R.layout.activity_home

    override fun getViewModel(): HomeViewModel = homeViewModel

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getNavigator(): HomeNavigator = listener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel.observeDataChanges()
    }

}
