package com.hariofspades.remote.features.userlist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NameResponse(

        @SerializedName("last")
        @Expose
        val last: String = "NA",

        @SerializedName("title")
        @Expose
        val title: String = "NA",

        @SerializedName("first")
        @Expose
        val first: String = "NA"
)