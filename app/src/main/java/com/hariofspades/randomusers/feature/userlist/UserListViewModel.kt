package com.hariofspades.randomusers.feature.userlist

import android.arch.lifecycle.MutableLiveData
import com.hariofspades.domain.features.userlist.UserDataRepository
import com.hariofspades.domain.features.userlist.model.ResultsItem
import com.hariofspades.randomusers.common.livedata.SingleLiveEvent
import com.hariofspades.randomusers.common.scheduling.SchedulerProvider
import com.hariofspades.randomusers.core.BaseViewModel
import io.reactivex.rxkotlin.addTo
import timber.log.Timber

/**
 *  ViewModel for [UserListActivity], where we show the list of users
 *
 *  @param schedulerProvider
 *  @param userDataRepository
 *
 *  @author Hari Vignesh Jayapalan
 */
class UserListViewModel(

        private val schedulerProvider: SchedulerProvider,
        private val userDataRepository: UserDataRepository

) : BaseViewModel() {

    val userListLiveData: SingleLiveEvent<List<ResultsItem>> = SingleLiveEvent()

    var isConnected: MutableLiveData<Boolean> = MutableLiveData()

    /**
     * The value is returned from DB, if internet is not connected and from network,
     * if it is connected. New values will be updated to the db. This logic is at
     * [UserDataRepository]
     *
     * @return LiveData
     */
    fun getRandomUserList(): SingleLiveEvent<List<ResultsItem>> {

        isConnected.value?.let {
            userDataRepository.getRandomUserList(it)
                    .subscribeOn(schedulerProvider.io())
                    .observeOn(schedulerProvider.ui())
                    .subscribe({

                        Timber.d("Received user list")
                        userListLiveData.value = it

                    }, {

                        Timber.d("Error in receiving the user list - ${it.printStackTrace()}")

                    })?.addTo(disposables)
        }


        return userListLiveData
    }

    override fun onCleared() {
        onDetach()
        super.onCleared()
    }
}