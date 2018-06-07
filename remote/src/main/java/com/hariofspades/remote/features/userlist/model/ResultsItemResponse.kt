package com.hariofspades.remote.features.userlist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResultsItemResponse(

        @SerializedName("nat")
        @Expose
        val nat: String = "NA",

        @SerializedName("gender")
        @Expose
        val gender: String = "NA",

        @SerializedName("phone")
        @Expose
        val phone: String = "NA",

        @SerializedName("dob")
        @Expose
        val dob: String = "NA",

        @SerializedName("name")
        @Expose
        val name: NameResponse,

        @SerializedName("registered")
        @Expose
        val registered: String = "NA",

        @SerializedName("location")
        @Expose
        val location: LocationResponse,

        @SerializedName("id")
        @Expose
        val id: IdResponse,

        @SerializedName("login")
        @Expose
        val login: LoginResponse,

        @SerializedName("cell")
        @Expose
        val cell: String = "NA",

        @SerializedName("email")
        @Expose
        val email: String = "NA",

        @SerializedName("picture")
        @Expose
        val picture: PictureResponse
)