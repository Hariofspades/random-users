package com.hariofspades.data.features.userlist

import com.hariofspades.data.features.userlist.mapper.ResultItemMapper
import com.hariofspades.data.features.userlist.repository.UserRemote
import com.hariofspades.data.features.userlist.repository.UserStorage
import com.hariofspades.domain.features.userlist.UserDataRepository
import com.hariofspades.domain.features.userlist.model.ResultsItem
import io.reactivex.Single
import io.reactivex.rxkotlin.Singles
import timber.log.Timber

class UserDataRepositoryImpl(
        private val resultItemMapper: ResultItemMapper,
        private val userRemote: UserRemote,
        private val userStorage: UserStorage

) : UserDataRepository {

    override fun getOneUser(firstName: String): Single<ResultsItem> {
        return userStorage.getOneUser(firstName).map(resultItemMapper::mapFromEntity)
    }

    override fun getRandomUserList(isConnected: Boolean): Single<List<ResultsItem>> {

        if (isConnected) {
            //get from network and save to db

            val storage = userStorage.getUsers()
            val remote = userRemote.getRandomUserList()

            return Singles.zip(remote, storage)
                    .doOnError{
                        Timber.d("error - ${it.printStackTrace()}")
                    }
                    .doOnSuccess{ (remote, _) ->
                        userStorage.insertUsers(remote)
                    }
                    .flatMap { (remoteList, _) ->

                        Single.just(remoteList.map { resultItemMapper.mapFromEntity(it) })
                    }
        } else {
            //get from db
            return userStorage.getUsers().map {
                it.map { resultItemMapper.mapFromEntity(it) }
            }.doOnError { Timber.d("db error - ${it.printStackTrace()}") }
        }
    }


}