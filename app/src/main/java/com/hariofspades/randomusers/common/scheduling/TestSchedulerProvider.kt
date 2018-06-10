package com.hariofspades.randomusers.common.scheduling

import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler

class TestSchedulerProvider(private val testScheduler: TestScheduler) : SchedulerProvider {

    override fun isUiThread(): Boolean {
        return true
    }

    override fun computation(): Scheduler {
        return testScheduler
    }

    override fun newThread(): Scheduler {
        return testScheduler
    }

    override fun io(): Scheduler {
        return testScheduler
    }

    override fun ui(): Scheduler {
        return testScheduler
    }

    override fun assertUiThread() {
        // assert?
    }

}