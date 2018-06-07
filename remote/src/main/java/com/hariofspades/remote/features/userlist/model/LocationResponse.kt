package com.hariofspades.remote.features.userlist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LocationResponse(

        @SerializedName("city")
        @Expose
        val city: String = "NA",

        @SerializedName("street")
        @Expose
        val street: String = "NA",

        @SerializedName("postcode")
        @Expose
        val postcode: String = "NA",

        @SerializedName("state")
        @Expose
        val state: String = "NA"
)