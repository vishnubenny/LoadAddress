package com.vishnu.core.getaddress

import com.vishnu.core.getaddress.model.Address
import io.reactivex.Single

interface GetAddressApiFetcher {

    fun getAddress(requestParam: Map<String, String>): Single<Address>
}
