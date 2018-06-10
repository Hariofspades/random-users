package com.hariofspades.remote

import com.hariofspades.remote.features.userlist.mapper.RResultItemMapper
import com.hariofspades.remote.features.userlist.model.*
import org.junit.Before
import org.junit.Test

class RemoteMapperTest {

    val name = NameResponse(
            last = "Vignesh",
            title = "Mr",
            first = "Hari"
    )

    val city = LocationResponse(
            city = "Bengaluru",
            street = "Kalena Agrahara",
            postcode = "560076",
            state = "Karnataka"
    )

    val image = PictureResponse(
            large = "https://randomuser.me/api/portraits/men/83.jpg",
            medium = "https://randomuser.me/api/portraits/med/men/83.jpg",
            thumbnail = "https://randomuser.me/api/portraits/thumb/men/83.jpg"
    )

    val id = IdResponse(
            "Hari",
            "1234"
    )

    val login = LoginResponse(
            "1234",
            "1234",
            "1234",
            "1234",
            "1234",
            "1234"
    )

    val item = ResultsItemResponse(
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

    lateinit var rResultItemMapper: RResultItemMapper

    @Before
    fun setUp() {
        rResultItemMapper = RResultItemMapper()
    }

    @Test
    fun `test mapping function`() {
        val result = rResultItemMapper.mapFromRemote(item)

        assert(result.large == item.picture.large)
        assert(result.firstName == item.name.first)
        assert(result.cell == item.cell)
        assert(result.postcode == item.location.postcode)
    }


}