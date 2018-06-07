package com.hariofspades.data.features.userlist.mapper

import com.hariofspades.data.common.mapper.Mapper
import com.hariofspades.data.features.userlist.entity.ResponseEntity
import com.hariofspades.domain.features.userlist.model.Response

class ResponseMapper(

        private val resultItemMapper: ResultItemMapper,
        private val infoMapper: InfoMapper

) : Mapper<ResponseEntity, Response> {

    override fun mapFromEntity(type: ResponseEntity): Response {
        return Response(
                type.results?.map { resultItemMapper.mapFromEntity(it) },
                infoMapper.mapFromEntity(type.info)
        )
    }

    override fun mapToEntity(type: Response): ResponseEntity {
        return ResponseEntity(
                type.results?.map { resultItemMapper.mapToEntity(it) },
                infoMapper.mapToEntity(type.info)
        )
    }


}