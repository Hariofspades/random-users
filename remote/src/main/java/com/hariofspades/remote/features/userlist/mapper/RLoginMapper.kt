package com.hariofspades.remote.features.userlist.mapper

import com.hariofspades.data.features.userlist.entity.LoginEntity
import com.hariofspades.remote.common.mapper.EntityMapper
import com.hariofspades.remote.features.userlist.model.LoginResponse

class RLoginMapper : EntityMapper<LoginResponse, LoginEntity> {

    override fun mapFromRemote(type: LoginResponse): LoginEntity {
        return LoginEntity(
                type.sha1,
                type.password,
                type.salt,
                type.sha256,
                type.username,
                type.md
        )
    }
}