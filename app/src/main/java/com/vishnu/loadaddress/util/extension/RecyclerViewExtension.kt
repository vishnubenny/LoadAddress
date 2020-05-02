package com.vishnu.loadaddress.util.extension

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vishnu.core.getaddress.model.AddressItem
import com.vishnu.loadaddress.home.getaddress.adapter.AddressAdapter

class RecyclerViewExtension {

    companion object {

        @BindingAdapter("addressListData")
        @JvmStatic
        fun addressListData(recyclerView: RecyclerView, addressList: List<AddressItem>) {
            val adapter = recyclerView.adapter
            if (adapter is AddressAdapter) adapter.updateList(addressList)
        }
    }
}
