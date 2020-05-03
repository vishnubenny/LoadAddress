package com.vishnu.core.getaddress

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.whenever
import com.vishnu.core.getaddress.model.Address
import com.vishnu.core.getaddress.model.ApiAddress
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetAddressFetcherTest {

    private val backend = Mockito.mock(GetAddressBackend::class.java)
    private val converter = Mockito.mock(AddressConverter::class.java)
    private val apiAddress = Mockito.mock(ApiAddress::class.java)
    private val address = Mockito.mock(Address::class.java)

    private val requestMap = emptyMap<String, String>()

    private lateinit var fetcher: GetAddressFetcher

    @Before
    fun setUp() {
        whenever(backend.getAddress(requestMap)).thenReturn(Single.just(apiAddress))
        whenever(converter.apply(apiAddress)).thenReturn(address)
        fetcher = GetAddressFetcher(backend, converter)
    }

    @Test
    fun `should get response from API if the backend returns data`() {
        val observer = fetcher.getAddress(requestMap).test()

        assertThat(observer.values().first()).isEqualTo(address)
    }
}
