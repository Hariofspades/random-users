package com.hariofspades.remote.features.userlist.mapper

import com.hariofspades.data.features.userlist.entity.PictureEntity
import com.hariofspades.remote.common.mapper.EntityMapper
import com.hariofspades.remote.features.userlist.model.PictureResponse

class RPictureMapper : EntityMapper<PictureResponse, PictureEntity> {

    override fun mapFromRemote(type: PictureResponse): PictureEntity {
        return PictureEntity(type.thumbnail, type.large, type.medium)
    }
}