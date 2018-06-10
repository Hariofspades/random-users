package com.hariofspades.domain.features.userlist

import com.hariofspades.domain.features.userlist.model.ResultsItem
import io.reactivex.Single

interface UserDataRepository {

    fun getRandomUserList(isConnected: Boolean): Single<List<ResultsItem>>

    fun getOneUser(firstName: String): Single<ResultsItem>

}