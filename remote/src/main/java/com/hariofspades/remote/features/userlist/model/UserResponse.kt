package com.hariofspades.remote.features.userlist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserResponse(

        @SerializedName("results")
        val results: List<ResultsItemResponse>?,

        @SerializedName("info")
        val info: InfoResponse
)