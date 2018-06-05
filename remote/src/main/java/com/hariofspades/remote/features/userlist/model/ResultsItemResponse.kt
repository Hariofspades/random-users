package com.hariofspades.remote.features.userlist.model

import com.google.gson.annotations.SerializedName

data class ResultsItemResponse(

        @SerializedName("nat")
        val nat: String = "NA",

        @SerializedName("gender")
        val gender: String = "NA",

        @SerializedName("phone")
        val phone: String = "NA",

        @SerializedName("dob")
        val dob: String = "NA",

        @SerializedName("name")
        val name: NameResponse,

        @SerializedName("registered")
        val registered: String = "NA",

        @SerializedName("location")
        val location: Location,

        @SerializedName("id")
        val id: IdResponse,

        @SerializedName("login")
        val login: LoginResponse,

        @SerializedName("cell")
        val cell: String = "NA",

        @SerializedName("email")
        val email: String = "NA",

        @SerializedName("picture")
        val picture: PictureResponse
)