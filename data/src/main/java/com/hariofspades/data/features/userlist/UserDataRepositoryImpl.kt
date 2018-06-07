package com.hariofspades.data.features.userlist

import com.hariofspades.data.common.rx.dropBreadcrumb
import com.hariofspades.data.features.userlist.mapper.ResponseMapper
import com.hariofspades.data.features.userlist.mapper.ResultItemMapper
import com.hariofspades.data.features.userlist.repository.UserRemote
import com.hariofspades.domain.features.userlist.UserDataRepository
import com.hariofspades.domain.features.userlist.model.Response
import com.hariofspades.domain.features.userlist.model.ResultsItem
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.exceptions.CompositeException

class UserDataRepositoryImpl(

        private val responseMapper: ResponseMapper,
        private val userRemote: UserRemote

) : UserDataRepository {

    override fun getRandomUserList(page: Int): Single<Response>? {
        return userRemote.getRandomUserList(page)
                .map(responseMapper::mapFromEntity)
                .dropBreadcrumb()
    }

}