package com.hariofspades.remote.features.userlist.mapper

import com.hariofspades.data.features.userlist.entity.ResultsItemEntity
import com.hariofspades.remote.common.mapper.EntityMapper
import com.hariofspades.remote.features.userlist.model.ResultsItemResponse

class RResultItemMapper : EntityMapper<ResultsItemResponse, ResultsItemEntity> {

    override fun mapFromRemote(type: ResultsItemResponse): ResultsItemEntity {
        return ResultsItemEntity(
                type.nat,
                type.gender,
                type.phone,
                type.dob,
                type.name.first,
                type.name.last,
                type.name.title,
                type.registered,
                type.location.city,
                type.location.street,
                type.location.postcode,
                type.location.state,
                type.cell,
                type.email,
                type.picture.thumbnail,
                type.picture.large,
                type.picture.medium
        )
    }
}