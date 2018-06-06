package com.hariofspades.remote.features.userlist

import com.hariofspades.remote.features.userlist.model.UserResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("api")
    fun getRandomUserList(
            @Query("page")page: Int,
            @Query("results")result: Int = 15
    ): Single<UserResponse>

}