package com.vishnu.core.getaddress

import com.vishnu.core.getaddress.model.ApiAddress
import io.reactivex.Single

interface GetAddressApiFetcher {

    fun getAddress(requestParam: Map<String, String>): Single<ApiAddress>
}
