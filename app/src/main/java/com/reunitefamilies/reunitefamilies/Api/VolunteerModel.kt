package com.reunitefamilies.reunitefamilies.Api

import java.io.Serializable

class VolunteerModel: Serializable  {

    var id: String? = null
    var name: String? = null
    var location: String? = null
    var firebase_id: String? = null
    var languages: ArrayList<String>? = null
}