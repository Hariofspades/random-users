package com.hariofspades.data.features.userlist.mapper

import com.hariofspades.data.common.mapper.Mapper
import com.hariofspades.data.features.userlist.entity.InfoEntity
import com.hariofspades.domain.features.userlist.model.Info

class InfoMapper : Mapper<InfoEntity, Info> {

    override fun mapFromEntity(type: InfoEntity): Info {
        return Info(
                type.seed,
                type.page,
                type.results,
                type.version
        )
    }

    override fun mapToEntity(type: Info): InfoEntity {
        return InfoEntity(
                type.seed,
                type.page,
                type.results,
                type.version
        )
    }
}