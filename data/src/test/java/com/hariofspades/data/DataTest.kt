package com.hariofspades.data

import com.hariofspades.domain.features.userlist.UserDataRepository
import com.hariofspades.domain.features.userlist.model.ResultsItem
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.Single
import org.junit.Test
import kotlin.test.assertEquals

class DataTest {

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

    val userDataRepository: UserDataRepository = mock()

    @Test
    fun `return list of users when internet is connected`() {
        doReturn(Single.just(resultList)).`when`(userDataRepository).getRandomUserList(true)
        val list = userDataRepository.getRandomUserList(true).blockingGet()
        assertEquals(resultList, list)
    }

    @Test
    fun `return list of users when internet is not connected`() {
        doReturn(Single.just(resultList)).`when`(userDataRepository).getRandomUserList(false)
        val list = userDataRepository.getRandomUserList(false).blockingGet()
        assertEquals(resultList, list)
    }

}