package com.hariofspades.randomusers

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import com.hariofspades.data.features.userlist.entity.ResultsItemEntity
import com.hariofspades.domain.features.userlist.UserDataRepository
import com.hariofspades.domain.features.userlist.model.ResultsItem
import com.hariofspades.randomusers.common.livedata.SingleLiveEvent
import com.hariofspades.randomusers.common.scheduling.TestSchedulerProvider
import com.hariofspades.randomusers.feature.userlist.UserListViewModel
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class ListViewModelTest {

    val result = ResultsItem(
            nat = "IND",
            gender = "male",
            phone = "9108278345",
            dob = "1983-07-14 07:29:45",
            firstName = "Hari",
            lastName = "Vignesh",
            title = "Mr",
            registered = "2010-09-24 02:10:42",
            city = "Bengaluru",
            street = "Kalena Agrahara",
            postcode = "560076",
            state = "Karnataka",
            cell = "9108278345",
            email = "hariutd@gmail.com",
            large = "https://randomuser.me/api/portraits/men/83.jpg",
            medium = "https://randomuser.me/api/portraits/med/men/83.jpg",
            thumbnail = "https://randomuser.me/api/portraits/thumb/men/83.jpg")

    val resultList = listOf(result)

    val isConnectedLiveData: SingleLiveEvent<Boolean> = SingleLiveEvent()

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val testScheduler = TestScheduler()

    lateinit var userListViewModel: UserListViewModel

    private val userDataRepository: UserDataRepository = mock()

    @Before
    fun setUp() {

        userListViewModel = UserListViewModel(TestSchedulerProvider(testScheduler), userDataRepository)

    }

    @Test
    fun `should get list of users form repository`() {
        doReturn(Single.just(resultList)).`when`(userDataRepository).getRandomUserList(true)
        val items = userDataRepository.getRandomUserList(true).blockingGet()
        assertEquals(resultList, items)
    }

    @Test
    fun `test observers`() {
        val observer = mock<Observer<List<ResultsItem>>>()
        userListViewModel.getRandomUserList().observeForever(observer)
        userListViewModel.userListLiveData.value = resultList

        verify(observer).onChanged(resultList)
    }
}