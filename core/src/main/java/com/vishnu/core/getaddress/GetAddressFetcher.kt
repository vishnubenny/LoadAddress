package com.vishnu.core.getaddress

import com.vishnu.core.getaddress.model.ApiAddress
import io.reactivex.Single

class GetAddressFetcher(private val getAddressBackend: GetAddressBackend) : GetAddressApiFetcher {

    override fun getAddress(requestParam: Map<String, String>): Single<ApiAddress> {
        return getAddressBackend.getAddress(requestParam)
    }
}
