package com.hariofspades.remote.features.userlist.mapper

import com.hariofspades.data.features.userlist.entity.NameEntity
import com.hariofspades.remote.common.mapper.EntityMapper
import com.hariofspades.remote.features.userlist.model.NameResponse

class RNameMapper : EntityMapper<NameResponse, NameEntity> {

    override fun mapFromRemote(type: NameResponse): NameEntity {
        return NameEntity(type.last, type.title, type.first)
    }
}