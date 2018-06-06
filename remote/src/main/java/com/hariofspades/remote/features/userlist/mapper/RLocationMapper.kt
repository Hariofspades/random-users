package com.hariofspades.remote.features.userlist.mapper

import com.hariofspades.data.features.userlist.entity.LocationEntity
import com.hariofspades.remote.common.mapper.EntityMapper
import com.hariofspades.remote.features.userlist.model.LocationResponse

class RLocationMapper : EntityMapper<LocationResponse, LocationEntity> {

    override fun mapFromRemote(type: LocationResponse): LocationEntity {
        return LocationEntity(
                city = type.city,
                state = type.state,
                postcode = type.postcode,
                street = type.street
        )
    }
}