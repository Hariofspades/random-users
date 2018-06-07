package com.hariofspades.data.features.userlist.entity

data class ResultsItemEntity(

        val nat: String = "NA",

        val gender: String = "NA",

        val phone: String = "NA",

        val dob: String = "NA",

        val name: NameEntity,

        val registered: String = "NA",

        val location: LocationEntity,

        val cell: String = "NA",

        val email: String = "NA",

        val picture: PictureEntity
)