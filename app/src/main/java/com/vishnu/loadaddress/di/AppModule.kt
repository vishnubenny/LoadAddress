package com.vishnu.loadaddress.di

import com.vishnu.loadaddress.home.di.homeModule
import org.koin.dsl.module

val appModule = module {
    homeModule
}
