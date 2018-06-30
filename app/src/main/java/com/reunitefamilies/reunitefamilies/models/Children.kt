package com.reunitefamilies.reunitefamilies.models

import com.google.firebase.database.IgnoreExtraProperties

import java.io.Serializable

@IgnoreExtraProperties
class Children : Serializable {

    var country_of_origin: String? = null
    var dob: String? = null
    var first_name: String? = null
    var last_name: String? = null
    var location: String? = null
    var age: Int? = null
    var reunite_status: String? = null

    constructor() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    constructor(countryOfOrigin: String, dob: String, firstName: String, lastName: String, location: String, age: Int, reuniteStatus: String) {
        this.country_of_origin = countryOfOrigin
        this.dob = dob
        this.first_name = firstName
        this.last_name = lastName
        this.location = location
        this.age = age
        this.reunite_status = reuniteStatus
    }

}
