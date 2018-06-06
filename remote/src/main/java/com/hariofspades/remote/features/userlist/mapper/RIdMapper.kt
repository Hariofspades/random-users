package com.hariofspades.remote.features.userlist.mapper

import com.hariofspades.data.features.userlist.entity.IdEntity
import com.hariofspades.remote.common.mapper.EntityMapper
import com.hariofspades.remote.features.userlist.model.IdResponse

class RIdMapper : EntityMapper<IdResponse, IdEntity> {

    override fun mapFromRemote(type: IdResponse): IdEntity {
        return IdEntity(type.name, type.value)
    }
}