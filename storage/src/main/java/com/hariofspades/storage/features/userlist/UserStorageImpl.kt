package com.hariofspades.storage.features.userlist

import com.hariofspades.data.features.userlist.entity.ResultsItemEntity
import com.hariofspades.data.features.userlist.repository.UserStorage
import com.hariofspades.storage.features.userlist.dao.UserDao
import io.reactivex.Single
import io.reactivex.Completable
import timber.log.Timber


class UserStorageImpl(
        private val dao: UserDao
) : UserStorage {

    override fun insertUsers(list: List<ResultsItemEntity>) {
        Completable.fromAction { dao.insert(list) }
                .doOnSubscribe { dao.clearRows() }
                .doOnError { Timber.d("Error, unable to insert user") }
                .subscribe()
    }

    override fun getUsers(): Single<List<ResultsItemEntity>> {
        return Single.create { subscriber ->
            subscriber.onSuccess(
                    dao.getUserList()
            )
        }
    }

    override fun getOneUser(firstName: String): Single<ResultsItemEntity> {
        return Single.create {subscriber ->
            Timber.d("storage - ${dao.getOneUser(firstName)}")
            subscriber.onSuccess(dao.getOneUser(firstName))
        }
    }
}