package com.hariofspades.remote.features.userlist

import com.hariofspades.data.features.userlist.entity.ResultsItemEntity
import com.hariofspades.data.features.userlist.repository.UserRemote
import com.hariofspades.remote.features.userlist.mapper.RResultItemMapper
import io.reactivex.Single
import retrofit2.Retrofit

class UserRemoteImpl(

        retrofit: Retrofit,
        private val rResultItemMapper: RResultItemMapper

) : UserRemote {

    private val apiService = retrofit.create(UserService::class.java)

    override fun getRandomUserList(): Single<List<ResultsItemEntity>> {
        return apiService.getRandomUserList()
                .map {
                    it.results?.map {
                        rResultItemMapper.mapFromRemote(it)
                    }
                }
    }

}