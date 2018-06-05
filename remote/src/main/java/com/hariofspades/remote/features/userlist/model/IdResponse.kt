package com.hariofspades.remote.features.userlist.model

import com.google.gson.annotations.SerializedName

data class IdResponse(

        @SerializedName("name")
        val name: String = "NA",

        @SerializedName("value")
        val value: String = "NA"
)