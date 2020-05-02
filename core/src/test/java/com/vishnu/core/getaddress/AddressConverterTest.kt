package com.vishnu.core.getaddress

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.whenever
import com.vishnu.core.getaddress.model.Address
import com.vishnu.core.getaddress.model.ApiAddress
import com.vishnu.core.getaddress.model.ApiAddressData
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AddressConverterTest {

    private val apiAddress = Mockito.mock(ApiAddress::class.java)
    private val apiAddressData = Mockito.mock(ApiAddressData::class.java)
    private lateinit var converter: AddressConverter

    @Before
    fun setUp() {
        converter = AddressConverter()
    }

    @Test
    fun `should convert to Address data with empty list if the API have no address list`() {
        whenever(apiAddress.data).thenReturn(apiAddressData)
        whenever(apiAddressData.addressList).thenReturn(emptyList())
        val expected = Address(emptyList())

        val converted = converter.apply(apiAddress)

        assertThat(converted).isEqualTo(expected)
    }
}
