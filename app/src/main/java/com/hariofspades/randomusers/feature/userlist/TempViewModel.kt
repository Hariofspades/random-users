package com.hariofspades.randomusers.feature.userlist

import com.hariofspades.domain.features.userlist.UserDataRepository
import com.hariofspades.domain.features.userlist.model.ResultsItem
import com.hariofspades.randomusers.common.livedata.SingleLiveEvent
import com.hariofspades.randomusers.common.scheduling.SchedulerProvider
import com.hariofspades.randomusers.core.BaseViewModel
import io.reactivex.rxkotlin.addTo
import timber.log.Timber

class TempViewModel(

        private val schedulerProvider: SchedulerProvider,
        private val userDataRepository: UserDataRepository

) : BaseViewModel() {

    private val userListLiveData: SingleLiveEvent<List<ResultsItem>> = SingleLiveEvent()

    fun getRandomUserList(page: Int): SingleLiveEvent<List<ResultsItem>> {

        userDataRepository.getRandomUserList(page).subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({

                    Timber.d("Received user list")
                    userListLiveData.value = it

                }, {

                    Timber.d("Error in receiving the user list - ${it.printStackTrace()}")

                })?.addTo(disposables)

        return userListLiveData
    }
}