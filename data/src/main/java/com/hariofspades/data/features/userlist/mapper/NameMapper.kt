package com.hariofspades.data.features.userlist.mapper

import com.hariofspades.data.common.mapper.Mapper
import com.hariofspades.data.features.userlist.entity.NameEntity
import com.hariofspades.domain.features.userlist.model.Name

class NameMapper : Mapper<NameEntity, Name> {

    override fun mapFromEntity(type: NameEntity): Name {
        return Name(type.last, type.title, type.first)
    }

    override fun mapToEntity(type: Name): NameEntity {
        return NameEntity(type.last, type.title, type.first)
    }
}