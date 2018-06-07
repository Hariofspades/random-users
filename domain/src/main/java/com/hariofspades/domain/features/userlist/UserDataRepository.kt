package com.hariofspades.domain.features.userlist

import com.hariofspades.domain.features.userlist.model.Response
import com.hariofspades.domain.features.userlist.model.ResultsItem
import io.reactivex.Single

interface UserDataRepository {

    fun getRandomUserList(page: Int): Single<Response>?
}