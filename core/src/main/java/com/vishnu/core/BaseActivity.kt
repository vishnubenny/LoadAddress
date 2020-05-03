package com.vishnu.core

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<N : BaseNavigator, T : ViewDataBinding, V : BaseViewModel<N>> :
    AppCompatActivity() {

    private lateinit var binding: T
    private lateinit var viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        if (!this::viewModel.isInitialized) {
            viewModel = getViewModel()
            viewModel.navigator = getNavigator()
        }
        binding.setVariable(getBindingVariable(), viewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): V

    abstract fun getBindingVariable(): Int

    abstract fun getNavigator(): N

}
