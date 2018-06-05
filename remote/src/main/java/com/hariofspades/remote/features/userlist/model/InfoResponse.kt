package com.hariofspades.remote.features.userlist.model

import com.google.gson.annotations.SerializedName

data class InfoResponse(

        @SerializedName("seed")
        val seed: String = "NA",

        @SerializedName("page")
        val page: Int = 0,

        @SerializedName("results")
        val results: Int = 0,

        @SerializedName("version")
        val version: String = "NA"
)