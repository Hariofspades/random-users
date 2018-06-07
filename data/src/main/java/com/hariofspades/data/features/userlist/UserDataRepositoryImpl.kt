package com.hariofspades.data.features.userlist

import com.hariofspades.data.features.userlist.mapper.ResultItemMapper
import com.hariofspades.data.features.userlist.repository.UserRemote
import com.hariofspades.domain.features.userlist.UserDataRepository
import com.hariofspades.domain.features.userlist.model.ResultsItem
import io.reactivex.Single

class UserDataRepositoryImpl(

        private val resultItemMapper: ResultItemMapper,
        private val userRemote: UserRemote

) : UserDataRepository {

    override fun getRandomUserList(page: Int): Single<List<ResultsItem>> {
        return userRemote.getRandomUserList(page)
                .map { it.map { resultItemMapper.mapFromEntity(it) } }
    }

}