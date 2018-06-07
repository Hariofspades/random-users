package com.hariofspades.remote.features.userlist

import com.hariofspades.data.common.rx.dropBreadcrumb
import com.hariofspades.data.features.userlist.entity.ResponseEntity
import com.hariofspades.data.features.userlist.entity.ResultsItemEntity
import com.hariofspades.data.features.userlist.repository.UserRemote
import com.hariofspades.remote.features.userlist.mapper.RResponseMapper
import com.hariofspades.remote.features.userlist.mapper.RResultItemMapper
import io.reactivex.Single
import retrofit2.Retrofit

class UserRemoteImpl(

        retrofit: Retrofit,
        private val rResponseMapper: RResponseMapper

): UserRemote {

    private val apiService = retrofit.create(UserService::class.java)

    override fun getRandomUserList(page: Int): Single<ResponseEntity> {
        return apiService.getRandomUserList(page = page)
                .map(rResponseMapper::mapFromRemote)
                .dropBreadcrumb()

    }

}