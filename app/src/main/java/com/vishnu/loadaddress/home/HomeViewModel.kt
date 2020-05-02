package com.vishnu.loadaddress.home

import androidx.lifecycle.MutableLiveData
import com.vishnu.core.BaseViewModel
import com.vishnu.core.Constants.Companion.TIMEOUT_500L_MS
import com.vishnu.core.extension.getText
import com.vishnu.core.getaddress.model.AddressItem
import com.vishnu.loadaddress.home.getaddress.AddressViewState
import com.vishnu.loadaddress.home.getaddress.adapter.AddressAdapter
import java.util.concurrent.TimeUnit

class HomeViewModel(private val repository: HomeRepository) : BaseViewModel<HomeNavigator>() {

    val addressList = MutableLiveData<List<AddressItem>>()
    val loading = MutableLiveData(false)
    val addressAdapter = AddressAdapter()

    fun observeDataChanges() {
        navigator.getSearchLocationChanges()
            .skip(1)
            .debounce(TIMEOUT_500L_MS, TimeUnit.MILLISECONDS)
            .map { it.toString().getText() }
            .switchMap { repository.getAddress(it) }
            .subscribe({ viewState ->
                when (viewState) {
                    AddressViewState.Loading -> loading.postValue(true)
                    is AddressViewState.Success -> {
                        addressList.postValue(viewState.addressList)
                        loading.postValue(false)
                        addressAdapter.updateList(viewState.addressList)
                    }
                    is AddressViewState.Error -> {
                        loading.postValue(false)
                    }
                }
            }, { error(it.localizedMessage.getText()) })
    }

}
