package com.hariofspades.data.features.userlist.mapper

import com.hariofspades.data.common.mapper.Mapper
import com.hariofspades.data.features.userlist.entity.ResultsItemEntity
import com.hariofspades.domain.features.userlist.model.ResultsItem

class ResultItemMapper : Mapper<ResultsItemEntity, ResultsItem> {

    override fun mapFromEntity(type: ResultsItemEntity): ResultsItem {
        return ResultsItem(
                type.nat,
                type.gender,
                type.phone,
                type.dob,
                type.firstName,
                type.lastName,
                type.title,
                type.registered,
                type.city,
                type.street,
                type.postcode,
                type.state,
                type.cell,
                type.email,
                type.thumbnail,
                type.large,
                type.medium
        )
    }

    override fun mapToEntity(type: ResultsItem): ResultsItemEntity {
        return ResultsItemEntity(
                type.nat,
                type.gender,
                type.phone,
                type.dob,
                type.firstName,
                type.lastName,
                type.title,
                type.registered,
                type.city,
                type.street,
                type.postcode,
                type.state,
                type.cell,
                type.email,
                type.thumbnail,
                type.large,
                type.medium
        )
    }
}