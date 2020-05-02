package com.vishnu.loadaddress.home

import com.vishnu.core.getaddress.GetAddressFetcher
import com.vishnu.core.getaddress.model.ApiAddress
import io.reactivex.Observable

private const val CONFIGURABLE_API_QUERY_STRING_VALUE = "airtel"
private const val API_REQUEST_MAP_QUERY_STRING_PARAM = "queryString"
private const val API_REQUEST_MAP_CITY_PARAM = "city"

class GetAddressRepository(private val fetcher: GetAddressFetcher) {

    fun getAddress(searchLocation: String): Observable<ApiAddress> {
        return fetcher.getAddress(getQueryParam(searchLocation))
            .toObservable()
    }

    private fun getQueryParam(searchLocation: String): Map<String, String> {
        val queryParam = mutableMapOf<String, String>()
        queryParam[API_REQUEST_MAP_QUERY_STRING_PARAM] = CONFIGURABLE_API_QUERY_STRING_VALUE
        queryParam[API_REQUEST_MAP_CITY_PARAM] = searchLocation
        return queryParam
    }
}
