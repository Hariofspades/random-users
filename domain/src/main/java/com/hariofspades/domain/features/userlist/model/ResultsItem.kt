package com.hariofspades.domain.features.userlist.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users")
data class ResultsItem(

        var nat: String = "NA",

        var gender: String = "NA",

        var phone: String = "NA",

        var dob: String = "NA",

        @PrimaryKey
        var firstName: String = "NA",

        var lastName: String = "NA",

        var title: String = "NA",

        var registered: String = "NA",

        var city: String = "NA",

        var street: String = "NA",

        var postcode: String = "NA",

        var state: String = "NA",

        var cell: String = "NA",

        var email: String = "NA",

        var thumbnail: String = "NA",

        var large: String = "NA",

        var medium: String = "NA"

)