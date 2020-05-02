package com.vishnu.loadaddress.home

import com.vishnu.core.getaddress.model.ApiAddress
import com.vishnu.loadaddress.home.getaddress.GetAddressRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeRepository(private val getAddressRepository: GetAddressRepository) {

    fun getAddress(searchLocation: String): Observable<ApiAddress> {
        return getAddressRepository.getAddress(searchLocation)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
