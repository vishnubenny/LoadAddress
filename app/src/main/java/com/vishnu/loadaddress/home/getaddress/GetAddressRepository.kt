package com.vishnu.loadaddress.home.getaddress

import com.vishnu.core.extension.getText
import com.vishnu.core.getaddress.GetAddressFetcher
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

private const val CONFIGURABLE_API_QUERY_STRING_VALUE = "airtel"
private const val API_REQUEST_MAP_QUERY_STRING_PARAM = "queryString"
private const val API_REQUEST_MAP_CITY_PARAM = "city"

class GetAddressRepository(
    private val fetcher: GetAddressFetcher,
    private val addressViewStateConverter: AddressViewStateConverter
) {

    fun getAddress(searchLocation: String): Observable<AddressViewState> {
        return fetcher.getAddress(getQueryParam(searchLocation))
            .toObservable()
            .map(addressViewStateConverter)
            .startWith(AddressViewState.Loading)
            .compose(GetAddressErrorConverter())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun getQueryParam(searchLocation: String): Map<String, String> {
        val queryParam = mutableMapOf<String, String>()
        queryParam[API_REQUEST_MAP_QUERY_STRING_PARAM] =
            CONFIGURABLE_API_QUERY_STRING_VALUE
        queryParam[API_REQUEST_MAP_CITY_PARAM] = searchLocation
        return queryParam
    }

    class GetAddressErrorConverter : ObservableTransformer<AddressViewState, AddressViewState> {
        override fun apply(upstream: Observable<AddressViewState>): ObservableSource<AddressViewState> {
            return upstream.onErrorResumeNext(Function<Throwable, ObservableSource<AddressViewState>> {
                Observable.just(AddressViewState.Error(it.localizedMessage.getText()))
            })
        }
    }

}
