package com.hariofspades.remote.features.userlist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse(

        @SerializedName("sha1")
        @Expose
        val sha1: String = "NA",

        @SerializedName("password")
        @Expose
        val password: String = "NA",

        @SerializedName("salt")
        @Expose
        val salt: String = "NA",

        @SerializedName("sha256")
        @Expose
        val sha256: String = "NA",

        @SerializedName("username")
        @Expose
        val username: String = "NA",

        @SerializedName("md5")
        @Expose
        val md: String = "NA"

)