package com.hariofspades.data.features.userlist.repository

import com.hariofspades.data.features.userlist.entity.ResultsItemEntity
import io.reactivex.Single

interface UserStorage {

    fun insertUsers(list: List<ResultsItemEntity>)

    fun getUsers(): Single<List<ResultsItemEntity>>

    fun getOneUser(firstName: String): Single<ResultsItemEntity>
}