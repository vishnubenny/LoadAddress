package com.vishnu.loadaddress.home

import com.vishnu.core.BaseViewModel

class HomeViewModel(private val repository: HomeRepository) : BaseViewModel<HomeNavigator>() {

    fun getAddress() {
        repository.getAddress("delhi")
            .subscribe({
                it
            }, {
                it
            })
    }

}
