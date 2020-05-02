package com.vishnu.loadaddress.util.extension

import android.view.View
import androidx.databinding.BindingAdapter

class ViewExtension {

    companion object {
        @BindingAdapter("visibility")
        @JvmStatic
        fun visibility(view: View, isVisible: Boolean) {
            view.visibility = when {
                isVisible -> View.VISIBLE
                else -> View.GONE
            }
        }
    }
}
