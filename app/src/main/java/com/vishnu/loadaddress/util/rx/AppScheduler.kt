package com.vishnu.loadaddress.util.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AppScheduler : SchedulerProvider {

    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun main(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}
