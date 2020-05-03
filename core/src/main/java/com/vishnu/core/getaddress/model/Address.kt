package com.vishnu.core.getaddress.model

data class Address(val addressList: List<AddressItem>)

data class AddressItem(val addressString: String)
