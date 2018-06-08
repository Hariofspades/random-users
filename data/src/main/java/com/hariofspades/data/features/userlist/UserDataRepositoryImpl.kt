package com.hariofspades.data.features.userlist

import com.hariofspades.data.features.userlist.db.UserDao
import com.hariofspades.data.features.userlist.mapper.ResultItemMapper
import com.hariofspades.data.features.userlist.repository.UserRemote
import com.hariofspades.domain.features.userlist.UserDataRepository
import com.hariofspades.domain.features.userlist.model.ResultsItem
import io.reactivex.Single
import timber.log.Timber

class UserDataRepositoryImpl(
        private val resultItemMapper: ResultItemMapper,
        private val userRemote: UserRemote

) : UserDataRepository {

    override fun getRandomUserList(isConnected: Boolean): Single<List<ResultsItem>> {

        if (isConnected) {
            Timber.e("Executed on NetworkConnection")
            return userRemote.getRandomUserList()
                    .map { it.map { resultItemMapper.mapFromEntity(it) } }
        } else {
            Timber.e("Executed on Disconnection")
            return userRemote.getRandomUserList()
                    .map { it.map { resultItemMapper.mapFromEntity(it) } }
        }
    }


}