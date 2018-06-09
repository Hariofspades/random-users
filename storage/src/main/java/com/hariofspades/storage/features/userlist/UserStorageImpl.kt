package com.hariofspades.storage.features.userlist

import com.hariofspades.data.features.userlist.entity.ResultsItemEntity
import com.hariofspades.data.features.userlist.repository.UserStorage
import com.hariofspades.storage.features.userlist.dao.UserDao
import com.hariofspades.storage.features.userlist.database.UserDB
import com.hariofspades.storage.features.userlist.mapper.SResultItemMapper
import io.reactivex.Single
import io.reactivex.Completable
import timber.log.Timber


class UserStorageImpl(
        private val dao: UserDao,
        private val resultItemMapper: SResultItemMapper
) : UserStorage {


    override fun insertUsers(list: List<ResultsItemEntity>) {
        Completable.fromAction {

            dao.clearRows()

            dao.insert(list.map { resultItemMapper.mapFromEntity(it) })

        }.doOnError { Timber.d("insert error - ${it.printStackTrace()}") }.subscribe()
    }

    override fun getUsers(): Single<List<ResultsItemEntity>> {
        return Single.create { subscriber ->
            subscriber.onSuccess(
                    dao.getUserList().map { resultItemMapper.mapToEntity(it) }
            )
        }
    }
}