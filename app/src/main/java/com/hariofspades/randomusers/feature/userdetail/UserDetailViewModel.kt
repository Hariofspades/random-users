package com.hariofspades.randomusers.feature.userdetail

import com.hariofspades.domain.features.userlist.UserDataRepository
import com.hariofspades.domain.features.userlist.model.ResultsItem
import com.hariofspades.randomusers.common.livedata.SingleLiveEvent
import com.hariofspades.randomusers.common.scheduling.SchedulerProvider
import com.hariofspades.randomusers.core.BaseViewModel
import io.reactivex.rxkotlin.addTo
import timber.log.Timber

/**
 *  ViewModel for our [UserDetailActivity], where we show info about one user
 *
 *  @param schedulerProvider
 *  @param userDataRepository
 */
class UserDetailViewModel(

        private val schedulerProvider: SchedulerProvider,
        private val userDataRepository: UserDataRepository

) : BaseViewModel() {

    private val userLiveData: SingleLiveEvent<ResultsItem> = SingleLiveEvent()

    /**
     *  by passing firstname, our primary key, we're querying for the
     *  individual data from Room.
     *
     *  @param firstName
     *  @return SingleLiveEvent<[ResultsItem]>
     */
    fun getThisUser(firstName: String): SingleLiveEvent<ResultsItem> {

        userDataRepository.getOneUser(firstName)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({
                    userLiveData.value = it
                    Timber.d("User found!")
                }, {
                    Timber.d("Error - User not found! - ${it.printStackTrace()}")
                }).addTo(disposables)

        return userLiveData
    }

    override fun onCleared() {
        onDetach()
        super.onCleared()
    }
}