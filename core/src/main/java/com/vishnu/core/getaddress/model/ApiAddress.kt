package com.vishnu.core.getaddress.model

data class ApiAddress(
    val requestId: String?,
    val data: ApiAddressData?
)

data class ApiAddressData(
    val autoCompleteRequestString: String?,
    val addressList: List<ApiAddressItem>?
)

data class ApiAddressItem(
    val id: String?,
    val city: String?,
    val addressString: String?,
    val label: String?,
    val latitude: Double?,
    val longitude: Double?
)
