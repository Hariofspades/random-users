package com.hariofspades.remote.features.userlist.mapper

import com.hariofspades.data.features.userlist.entity.InfoEntity
import com.hariofspades.remote.common.mapper.EntityMapper
import com.hariofspades.remote.features.userlist.model.InfoResponse

class RInfoMapper : EntityMapper<InfoResponse, InfoEntity> {

    override fun mapFromRemote(type: InfoResponse): InfoEntity {
        return InfoEntity(
                type.seed,
                type.page,
                type.results,
                type.version
        )
    }

}