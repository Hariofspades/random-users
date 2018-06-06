package com.hariofspades.randomusers.common.scheduling

import io.reactivex.Scheduler

interface SchedulerProvider {

    fun isUiThread(): Boolean

    fun computation(): Scheduler

    fun newThread(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler

    fun assertUiThread()
}