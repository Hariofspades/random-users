package com.hariofspades.randomusers.core

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.hariofspades.domain.features.userlist.UserDataRepository
import com.hariofspades.randomusers.common.scheduling.DefaultSchedulerProvider
import com.hariofspades.randomusers.common.scheduling.SchedulerProvider
import com.hariofspades.randomusers.feature.userlist.TempViewModel

class BaseModelFactory(

        private val schedulerProvider: SchedulerProvider,
        private val userDataRepository: UserDataRepository

) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(TempViewModel::class.java)) {

            return TempViewModel(
                    schedulerProvider,
                    userDataRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel")
    }
}