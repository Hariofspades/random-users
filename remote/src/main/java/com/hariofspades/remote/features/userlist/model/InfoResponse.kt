package com.hariofspades.remote.features.userlist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class InfoResponse(

        @SerializedName("seed")
        @Expose
        val seed: String = "NA",

        @SerializedName("page")
        @Expose
        val page: Int = 0,

        @SerializedName("results")
        @Expose
        val results: Int = 0,

        @SerializedName("version")
        @Expose
        val version: String = "NA"
)