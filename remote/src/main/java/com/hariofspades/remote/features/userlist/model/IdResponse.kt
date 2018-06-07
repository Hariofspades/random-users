package com.hariofspades.remote.features.userlist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class IdResponse(

        @SerializedName("name")
        @Expose
        val name: String = "NA",

        @SerializedName("value")
        @Expose
        val value: String? = "NA"
)