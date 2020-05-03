package com.vishnu.loadaddress.home.getaddress

import com.vishnu.core.getaddress.model.AddressItem

sealed class AddressViewState {
    object Loading : AddressViewState()
    data class Success(val addressList: List<AddressItem>) : AddressViewState()
    data class Error(val errorCause: String) : AddressViewState()
}
