package com.vishnu.loadaddress.home.getaddress

import com.vishnu.core.getaddress.model.Address
import io.reactivex.functions.Function

class AddressViewStateConverter : Function<Address, AddressViewState> {
    override fun apply(address: Address): AddressViewState {
        return AddressViewState.Success(address.addressList)
    }
}
