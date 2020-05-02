package com.vishnu.loadaddress.home.getaddress.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.vishnu.core.getaddress.model.AddressItem
import kotlinx.android.synthetic.main.row_address_item.view.*

class AddressViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bindData(addressItem: AddressItem) {
        view.txtVwAddress.text = addressItem.addressString
    }
}
