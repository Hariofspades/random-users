package com.hariofspades.randomusers.common.scheduling

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DefaultSchedulerProvider : SchedulerProvider {

    override fun isUiThread(): Boolean {
        return AndroidPreconditions.isMainThread()
    }

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun newThread(): Scheduler {
        return Schedulers.newThread()
    }

    override fun io(): Scheduler {
       return Schedulers.io()
    }

    override fun ui(): Scheduler {
       return AndroidSchedulers.mainThread()
    }

    override fun assertUiThread() {
        if (!isUiThread()) {
            throw IllegalStateException(
                    "This task must be run on the Main thread and not on a worker thread."
            )
        }
    }

}