package com.vishnu.loadaddress.home

import com.vishnu.core.BaseNavigator
import io.reactivex.Observable

interface HomeNavigator : BaseNavigator {

    fun getSearchLocationChanges(): Observable<CharSequence>
}
