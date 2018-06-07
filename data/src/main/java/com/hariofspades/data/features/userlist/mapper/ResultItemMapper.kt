package com.hariofspades.data.features.userlist.mapper

import com.hariofspades.data.common.mapper.Mapper
import com.hariofspades.data.features.userlist.entity.ResultsItemEntity
import com.hariofspades.domain.features.userlist.model.ResultsItem

class ResultItemMapper(

        private val nameMapper: NameMapper,
        private val locationMapper: LocationMapper,
        private val pictureMapper: PictureMapper

) : Mapper<ResultsItemEntity, ResultsItem> {

    override fun mapFromEntity(type: ResultsItemEntity): ResultsItem {
        return ResultsItem(
                type.nat,
                type.gender,
                type.phone,
                type.dob,
                nameMapper.mapFromEntity(type.name),
                type.registered,
                locationMapper.mapFromEntity(type.location),
                type.cell,
                type.email,
                pictureMapper.mapFromEntity(type.picture)
        )
    }

    override fun mapToEntity(type: ResultsItem): ResultsItemEntity {
        return ResultsItemEntity(
                type.nat,
                type.gender,
                type.phone,
                type.dob,
                nameMapper.mapToEntity(type.name),
                type.registered,
                locationMapper.mapToEntity(type.location),
                type.cell,
                type.email,
                pictureMapper.mapToEntity(type.picture)
        )
    }
}