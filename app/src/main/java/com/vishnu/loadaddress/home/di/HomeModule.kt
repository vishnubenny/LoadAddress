package com.vishnu.loadaddress.home.di

import com.vishnu.loadaddress.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {

    viewModel { HomeViewModel() }
}
