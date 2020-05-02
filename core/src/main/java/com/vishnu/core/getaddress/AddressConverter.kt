package com.vishnu.core.getaddress

import com.vishnu.core.extension.getText
import com.vishnu.core.getaddress.model.Address
import com.vishnu.core.getaddress.model.AddressItem
import com.vishnu.core.getaddress.model.ApiAddress
import io.reactivex.functions.Function

class AddressConverter : Function<ApiAddress, Address> {

    override fun apply(apiAddress: ApiAddress): Address {
        val addressList = mutableListOf<AddressItem>()
        apiAddress.data?.addressList?.forEach {
            if (it.addressString.getText().isNotEmpty())
                addressList.add(AddressItem(it.addressString.getText()))
        }
        return Address(addressList)
    }
}
