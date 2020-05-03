package com.vishnu.loadaddress.util.rx

import io.reactivex.Scheduler

interface SchedulerProvider {

    fun io(): Scheduler
    fun main(): Scheduler
}
