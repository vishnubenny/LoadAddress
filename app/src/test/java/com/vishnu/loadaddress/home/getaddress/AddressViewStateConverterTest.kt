package com.vishnu.loadaddress.home.getaddress

import com.google.common.truth.Truth.assertThat
import com.vishnu.core.getaddress.model.Address
import com.vishnu.core.getaddress.model.AddressItem
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AddressViewStateConverterTest {

    private lateinit var converter: AddressViewStateConverter

    private val addressItem = AddressItem("address string")
    private val address = Address(listOf(addressItem, addressItem))

    @Before
    fun setUp() {
        converter = AddressViewStateConverter()
    }

    @Test
    fun `should convert address into success view state with address item list`() {
        val expected = AddressViewState.Success(listOf(addressItem, addressItem))

        val converted = converter.apply(address)

        assertThat(converted).isEqualTo(expected)
    }

    @Test
    fun `should convert address into success view state with empty list if the address is with empty list`() {
        val expected = AddressViewState.Success(emptyList())

        val converted = converter.apply(Address(emptyList()))

        assertThat(converted).isEqualTo(expected)
    }
}
