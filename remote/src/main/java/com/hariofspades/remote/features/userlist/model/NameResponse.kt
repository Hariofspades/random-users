package com.hariofspades.remote.features.userlist.model

import com.google.gson.annotations.SerializedName

data class NameResponse(

        @SerializedName("last")
        val last: String = "NA",

        @SerializedName("title")
        val title: String = "NA",

        @SerializedName("first")
        val first: String = "NA"
)