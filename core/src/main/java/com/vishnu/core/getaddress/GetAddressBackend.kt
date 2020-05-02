package com.vishnu.core.getaddress

import com.vishnu.core.getaddress.model.ApiAddress
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface GetAddressBackend {

    @GET("compassLocation/rest/address/autocomplete")
    fun getAddress(@QueryMap requestParam: Map<String, String>): Single<ApiAddress>
}
