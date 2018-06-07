package com.hariofspades.remote.features.userlist.mapper

import com.hariofspades.data.features.userlist.entity.ResultsItemEntity
import com.hariofspades.remote.common.mapper.EntityMapper
import com.hariofspades.remote.features.userlist.model.ResultsItemResponse

class RResultItemMapper(
        private val rIdMapper: RIdMapper,
        private val rLocationMapper: RLocationMapper,
        private val rNameMapper: RNameMapper,
        private val rPictureMapper: RPictureMapper,
        private val rLoginMapper: RLoginMapper
) : EntityMapper<ResultsItemResponse, ResultsItemEntity> {

    override fun mapFromRemote(type: ResultsItemResponse): ResultsItemEntity {
        return ResultsItemEntity(
                type.nat,
                type.gender,
                type.phone,
                type.dob,
                rNameMapper.mapFromRemote(type.name),
                type.registered,
                rLocationMapper.mapFromRemote(type.location),
                type.cell,
                type.email,
                rPictureMapper.mapFromRemote(type.picture)
        )
    }
}