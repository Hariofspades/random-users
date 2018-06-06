package com.hariofspades.data.features.userlist.mapper

import com.hariofspades.data.common.mapper.Mapper
import com.hariofspades.data.features.userlist.entity.LocationEntity
import com.hariofspades.domain.features.userlist.model.Location

class LocationMapper : Mapper<LocationEntity, Location> {

    override fun mapFromEntity(type: LocationEntity): Location {
        return Location(type.city, type.street, type.postcode, type.state)
    }

    override fun mapToEntity(type: Location): LocationEntity {
        return LocationEntity(type.city, type.street, type.postcode, type.state)
    }
}