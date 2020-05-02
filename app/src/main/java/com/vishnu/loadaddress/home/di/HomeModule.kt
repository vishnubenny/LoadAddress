package com.vishnu.loadaddress.home.di

import com.vishnu.core.getaddress.GetAddressBackend
import com.vishnu.core.getaddress.GetAddressFetcher
import com.vishnu.loadaddress.home.HomeRepository
import com.vishnu.loadaddress.home.HomeViewModel
import com.vishnu.loadaddress.home.getaddress.GetAddressRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val homeModule = module {

    factory { provideGetAddressBackend(get()) }
    factory { GetAddressFetcher(get()) }
    factory { GetAddressRepository(get()) }

    factory { HomeRepository(get()) }
    viewModel { HomeViewModel(get()) }
}

fun provideGetAddressBackend(retrofit: Retrofit.Builder): GetAddressBackend {
    return retrofit
        .build()
        .create(GetAddressBackend::class.java)
}
