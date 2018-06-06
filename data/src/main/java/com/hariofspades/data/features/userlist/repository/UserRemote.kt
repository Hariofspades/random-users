package com.hariofspades.data.features.userlist.repository

import com.hariofspades.data.features.userlist.entity.ResultsItemEntity
import io.reactivex.Single

interface UserRemote {

    fun getRandomUserList(page: Int): Single<List<ResultsItemEntity>>
}