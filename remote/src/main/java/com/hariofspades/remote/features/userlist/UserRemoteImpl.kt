package com.hariofspades.remote.features.userlist

import com.hariofspades.data.features.userlist.entity.ResultsItemEntity
import com.hariofspades.data.features.userlist.repository.UserRemote
import com.hariofspades.remote.features.userlist.mapper.RResultItemMapper
import io.reactivex.Single
import retrofit2.Retrofit

/**
 * Remote/network implementation of our APP. Request will be fetched from API call
 *
 * @param apiService - created from [UserService]
 * @param rResultItemMapper - object mapper
 *
 * @author Hari Vignesh Jayapalan
 */
class UserRemoteImpl(

        private val apiService: UserService,
        private val rResultItemMapper: RResultItemMapper

) : UserRemote {


    override fun getRandomUserList(): Single<List<ResultsItemEntity>> {
        return apiService.getRandomUserList()
                .map {
                    it.results?.map {
                        rResultItemMapper.mapFromRemote(it)
                    }
                }
    }

}