package com.vishnu.loadaddress.home.getaddress.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vishnu.core.getaddress.model.AddressItem
import com.vishnu.loadaddress.R

class AddressAdapter : RecyclerView.Adapter<AddressViewHolder>() {

    private val list = mutableListOf<AddressItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_address_item, parent, false)
        return AddressViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    fun updateList(list: List<AddressItem>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}
