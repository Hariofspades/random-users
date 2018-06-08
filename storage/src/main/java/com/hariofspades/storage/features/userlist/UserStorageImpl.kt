package com.hariofspades.storage.features.userlist

import com.hariofspades.data.features.userlist.entity.ResultsItemEntity
import com.hariofspades.data.features.userlist.repository.UserStorage
import com.hariofspades.storage.features.userlist.database.UserDB
import com.hariofspades.storage.features.userlist.mapper.SResultItemMapper
import io.reactivex.Single
import io.reactivex.Completable



class UserStorageImpl(
        private val database: UserDB,
        private val resultItemMapper: SResultItemMapper
) : UserStorage {


    override fun insertUsers(list: List<ResultsItemEntity>) {
        Completable.fromAction {
            database.userDao().insert(
                    list.map { resultItemMapper.mapFromEntity(it) }
            )
        }
    }

    override fun getUsers(): Single<List<ResultsItemEntity>> {
        return Single.create { subscriber ->
            subscriber.onSuccess(
                    database.userDao().getUserList().map { resultItemMapper.mapToEntity(it) }
            )
        }
    }
}