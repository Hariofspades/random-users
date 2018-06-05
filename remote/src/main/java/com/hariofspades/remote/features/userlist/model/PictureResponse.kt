package com.hariofspades.remote.features.userlist.model

import com.google.gson.annotations.SerializedName

data class PictureResponse(

        @SerializedName("thumbnail")
        val thumbnail: String = "NA",

        @SerializedName("large")
        val large: String = "NA",

        @SerializedName("medium")
        val medium: String = "NA"

)