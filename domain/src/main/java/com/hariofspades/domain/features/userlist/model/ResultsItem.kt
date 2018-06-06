package com.hariofspades.domain.features.userlist.model

data class ResultsItem(

        val nat: String = "NA",

        val gender: String = "NA",

        val phone: String = "NA",

        val dob: String = "NA",

        val name: Name,

        val registered: String = "NA",

        val location: Location,

        val cell: String = "NA",

        val email: String = "NA",

        val picture: Picture
)