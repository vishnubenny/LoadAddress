package com.vishnu.core.getaddress

import com.vishnu.core.getaddress.model.Address
import io.reactivex.Single

class GetAddressFetcher(
    private val getAddressBackend: GetAddressBackend,
    private val addressConverter: AddressConverter
) : GetAddressApiFetcher {

    override fun getAddress(requestParam: Map<String, String>): Single<Address> {
        return getAddressBackend.getAddress(requestParam)
            .map(addressConverter)
    }
}
