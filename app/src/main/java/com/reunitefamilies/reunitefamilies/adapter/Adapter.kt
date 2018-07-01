package com.reunitefamilies.reunitefamilies.adapter

import com.airbnb.epoxy.EpoxyAdapter
import com.reunitefamilies.reunitefamilies.adapter.models.ChildRowModel

open class Adapter: EpoxyAdapter() {

    init {
        this.enableDiffing()
    }

    fun childRow(firstName: String, lastName: String){
        addModel(ChildRowModel(firstName, lastName))
    }

}