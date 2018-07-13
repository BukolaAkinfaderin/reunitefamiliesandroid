package com.reunitefamilies.reunitefamilies.adapter.models

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.reunitefamilies.reunitefamilies.R

class ChildRowModel(private val firstName: String, private val lastName: String): EpoxyModelWithHolder<ChildRowModel.ItemHolder>() {

    override fun getDefaultLayout(): Int = R.layout.child_row_model

    override fun createNewHolder(): ItemHolder = ItemHolder()

    override fun bind(holder: ItemHolder) {
        holder.bind(firstName, lastName)
    }

    inner class ItemHolder: EpoxyButterKnifeHolder() {

        lateinit var firstName: TextView
        lateinit var lastName: TextView

        override fun bindView(itemView: View) {
            firstName = itemView.findViewById(R.id.child_first_name)
            lastName = itemView.findViewById(R.id.child_last_name)
        }

        fun bind(firstName: String, lastName: String) {
            this.firstName.text = firstName
            this.lastName.text = lastName
        }

    }
}