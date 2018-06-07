package com.hariofspades.domain.features.userlist.model

import android.arch.persistence.room.Entity

@Entity(tableName = "users")
data class ResultsItem(

        val nat: String = "NA",

        val gender: String = "NA",

        val phone: String = "NA",

        val dob: String = "NA",

        val firstName: String = "NA",

        val lasttName: String = "NA",

        val title: String = "NA",

        val registered: String = "NA",

        val city: String = "NA",

        val street: String = "NA",

        val postcode: String = "NA",

        val state: String = "NA",

        val cell: String = "NA",

        val email: String = "NA",

        val thumbnail: String = "NA",

        val large: String = "NA",

        val medium: String = "NA"

)