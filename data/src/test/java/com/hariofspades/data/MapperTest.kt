package com.hariofspades.data

import com.hariofspades.data.features.userlist.mapper.ResultItemMapper
import com.hariofspades.domain.features.userlist.model.ResultsItem
import org.junit.Before
import org.junit.Test

class MapperTest {

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

    private lateinit var resultItemMapper: ResultItemMapper

    @Before
    fun setup() {
        resultItemMapper = ResultItemMapper()
    }

    @Test
    fun `test mapping functions`() {
        val entity = resultItemMapper.mapToEntity(result)

        assert(entity.firstName == result.firstName)
        assert(entity.city == result.city)
        assert(entity.large == result.large)
    }
}