package com.vishnu.loadaddress.home

import com.vishnu.loadaddress.home.getaddress.AddressViewState
import com.vishnu.loadaddress.home.getaddress.GetAddressRepository
import io.reactivex.Observable

class HomeRepository(private val getAddressRepository: GetAddressRepository) {

    fun getAddress(searchLocation: String): Observable<AddressViewState> {
        return getAddressRepository.getAddress(searchLocation)
    }
}
