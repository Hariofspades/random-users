package com.hariofspades.remote.features.userlist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PictureResponse(

        @SerializedName("thumbnail")
        @Expose
        val thumbnail: String = "NA",

        @SerializedName("large")
        @Expose
        val large: String = "NA",

        @SerializedName("medium")
        @Expose
        val medium: String = "NA"

)