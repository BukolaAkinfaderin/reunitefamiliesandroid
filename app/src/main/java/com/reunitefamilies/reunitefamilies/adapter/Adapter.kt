package com.reunitefamilies.reunitefamilies.adapter

import com.airbnb.epoxy.EpoxyAdapter
import com.reunitefamilies.reunitefamilies.adapter.models.ChildRowModel
import com.reunitefamilies.reunitefamilies.adapter.models.UploadChildFormModel

open class Adapter: EpoxyAdapter() {

    init {
        this.enableDiffing()
    }

    fun childRow(firstName: String, lastName: String){
        addModel(ChildRowModel(firstName, lastName))
    }

    fun uploadChildForm(function: (String, String, String) -> Unit) {
        addModel(UploadChildFormModel(function))
    }

}