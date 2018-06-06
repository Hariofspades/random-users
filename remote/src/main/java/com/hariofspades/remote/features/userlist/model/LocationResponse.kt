package com.hariofspades.remote.features.userlist.model

import com.google.gson.annotations.SerializedName

data class LocationResponse(

        @SerializedName("city")
        val city: String = "NA",

        @SerializedName("street")
        val street: String = "NA",

        @SerializedName("postcode")
        val postcode: Int = 0,

        @SerializedName("state")
        val state: String = "NA"
)