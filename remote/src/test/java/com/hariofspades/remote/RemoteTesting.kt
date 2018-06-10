package com.hariofspades.remote

import com.hariofspades.data.features.userlist.repository.UserRemote
import com.hariofspades.remote.features.userlist.UserRemoteImpl
import com.hariofspades.remote.features.userlist.UserService
import com.hariofspades.remote.features.userlist.mapper.RResultItemMapper
import com.hariofspades.remote.features.userlist.model.*
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Test
import kotlin.test.assertEquals

class RemoteTesting {

    private val name = NameResponse(
            last = "Vignesh",
            title = "Mr",
            first = "Hari"
    )

    private val city = LocationResponse(
            city = "Bengaluru",
            street = "Kalena Agrahara",
            postcode = "560076",
            state = "Karnataka"
    )

    private val image = PictureResponse(
            large = "https://randomuser.me/api/portraits/men/83.jpg",
            medium = "https://randomuser.me/api/portraits/med/men/83.jpg",
            thumbnail = "https://randomuser.me/api/portraits/thumb/men/83.jpg"
    )

    private val id = IdResponse(
            "Hari",
            "1234"
    )

    private val login = LoginResponse(
            "1234",
            "1234",
            "1234",
            "1234",
            "1234",
            "1234"
    )

    private val item = ResultsItemResponse(
            nat = "IND",
            gender = "male",
            phone = "9108278345",
            dob = "1983-07-14 07:29:45",
            name = name,
            registered = "2010-09-24 02:10:42",
            location = city,
            cell = "9108278345",
            email = "hariutd@gmail.com",
            picture = image,
            id = id,
            login = login)

    private val rResultItemMapper: RResultItemMapper = RResultItemMapper()

    private val resutEntity = rResultItemMapper.mapFromRemote(item)

    private val userRemote: UserRemote = mock()

    @Test
    fun `test remote function`() {

        doReturn(Single.just(listOf(resutEntity))).`when`(userRemote).getRandomUserList()
        val items = userRemote.getRandomUserList().blockingGet()

        assertEquals(listOf(resutEntity), items)
    }
}