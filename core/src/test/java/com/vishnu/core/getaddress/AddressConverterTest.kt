package com.vishnu.core.getaddress

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.whenever
import com.vishnu.core.getaddress.model.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AddressConverterTest {

    private val apiAddress = Mockito.mock(ApiAddress::class.java)
    private val apiAddressData = Mockito.mock(ApiAddressData::class.java)
    private val apiAddressItem = Mockito.mock(ApiAddressItem::class.java)
    private lateinit var converter: AddressConverter

    @Before
    fun setUp() {
        whenever(apiAddress.data).thenReturn(apiAddressData)
        whenever(apiAddressItem.addressString).thenReturn("address string")
        converter = AddressConverter()
    }

    @Test
    fun `should convert to Address data with empty list if the API have no address list`() {
        whenever(apiAddressData.addressList).thenReturn(emptyList())
        val expected = Address(emptyList())

        val converted = converter.apply(apiAddress)

        assertThat(converted).isEqualTo(expected)
    }

    @Test
    fun `should convert to Address data list with proper value if the API having data`() {
        whenever(apiAddressData.addressList).thenReturn(listOf(apiAddressItem, apiAddressItem))
        val addressItem = AddressItem("address string")
        val expected = Address(listOf(addressItem, addressItem))

        val converted = converter.apply(apiAddress)

        assertThat(converted).isEqualTo(expected)
    }
}
