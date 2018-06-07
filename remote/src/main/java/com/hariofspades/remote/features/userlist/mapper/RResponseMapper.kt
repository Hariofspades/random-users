package com.hariofspades.remote.features.userlist.mapper

import com.hariofspades.data.features.userlist.entity.ResponseEntity
import com.hariofspades.remote.common.mapper.EntityMapper
import com.hariofspades.remote.features.userlist.model.UserResponse

class RResponseMapper(

        private val rResultItemMapper: RResultItemMapper,
        private val rInfoMapper: RInfoMapper

) : EntityMapper<UserResponse, ResponseEntity> {

    override fun mapFromRemote(type: UserResponse): ResponseEntity {
        return ResponseEntity(
                type.results?.map { rResultItemMapper.mapFromRemote(it) },
                rInfoMapper.mapFromRemote(type.info)
        )
    }
}