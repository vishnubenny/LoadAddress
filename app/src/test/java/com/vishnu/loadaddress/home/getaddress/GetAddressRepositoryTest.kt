package com.vishnu.loadaddress.home.getaddress

import com.nhaarman.mockitokotlin2.whenever
import com.vishnu.core.getaddress.GetAddressFetcher
import com.vishnu.core.getaddress.model.Address
import com.vishnu.loadaddress.util.rx.AppScheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetAddressRepositoryTest {

    private val fetcher = Mockito.mock(GetAddressFetcher::class.java)
    private val converter = Mockito.mock(AddressViewStateConverter::class.java)
    private val scheduler = Mockito.mock(AppScheduler::class.java)
    private lateinit var requestParam: Map<String, String>
    private val address = Mockito.mock(Address::class.java)
    private val success = Mockito.mock(AddressViewState.Success::class.java)

    private val searchLocation = "Delhi"

    private lateinit var repository: GetAddressRepository

    @Before
    fun setUp() {
        requestParam = getRequestParam()
        whenever(fetcher.getAddress(requestParam)).thenReturn(Single.just(address))
        whenever(converter.apply(address)).thenReturn(success)
        whenever(scheduler.main()).thenReturn(Schedulers.trampoline())
        whenever(scheduler.io()).thenReturn(Schedulers.trampoline())
        repository = GetAddressRepository(fetcher, converter, scheduler)
    }

    @Test
    fun `should invoke API data with loading and success if the API returns value`() {
        val observer = repository.getAddress(searchLocation).test()

        observer.assertValues(AddressViewState.Loading, success)
    }

    private fun getRequestParam(): Map<String, String> {
        val param = mutableMapOf<String, String>()
        param["queryString"] = "airtel"
        param["city"] = searchLocation
        return param
    }
}
