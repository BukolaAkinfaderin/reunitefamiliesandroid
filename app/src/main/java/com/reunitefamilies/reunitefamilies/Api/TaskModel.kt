package com.reunitefamilies.reunitefamilies.Api

data class TaskModel(
        val taskType: String,
        val status: String,
        val description: String,
        val needsTranslation: Boolean)