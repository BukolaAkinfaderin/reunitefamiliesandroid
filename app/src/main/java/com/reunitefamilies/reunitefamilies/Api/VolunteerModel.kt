package com.reunitefamilies.reunitefamilies.Api

import java.io.Serializable

data class VolunteerModel (

    val id: String,
    val name: String,
    val location: String? = null,
    val firebase_id: String,
    val languages: List<String>
) : Serializable