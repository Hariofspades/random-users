package com.hariofspades.remote.features.userlist.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

        @SerializedName("sha1")
        val sha1: String = "NA",

        @SerializedName("password")
        val password: String = "NA",

        @SerializedName("salt")
        val salt: String = "NA",

        @SerializedName("sha256")
        val sha256: String = "NA",

        @SerializedName("username")
        val username: String = "NA",

        @SerializedName("md5")
        val md: String = "NA"

)