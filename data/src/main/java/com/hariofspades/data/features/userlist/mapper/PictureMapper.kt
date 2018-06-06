package com.hariofspades.data.features.userlist.mapper

import com.hariofspades.data.common.mapper.Mapper
import com.hariofspades.data.features.userlist.entity.PictureEntity
import com.hariofspades.domain.features.userlist.model.Picture

class PictureMapper : Mapper<PictureEntity, Picture> {

    override fun mapFromEntity(type: PictureEntity): Picture {
        return Picture(type.thumbnail, type.large, type.medium)
    }

    override fun mapToEntity(type: Picture): PictureEntity {
        return PictureEntity(type.thumbnail, type.large, type.medium)
    }
}