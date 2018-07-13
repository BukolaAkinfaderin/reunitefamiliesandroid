package com.reunitefamilies.reunitefamilies.adapter.models

import android.view.View
import android.widget.Button
import android.widget.EditText
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.reunitefamilies.reunitefamilies.R

class UploadChildFormModel(private val function: (firstName: String, lastName: String, location: String) -> Unit) : EpoxyModelWithHolder<UploadChildFormModel.ItemHolder>() {

    override fun getDefaultLayout(): Int = R.layout.upload_child_form_model

    override fun createNewHolder(): UploadChildFormModel.ItemHolder = ItemHolder()

    override fun bind(holder: UploadChildFormModel.ItemHolder) {
        holder.bind()
    }

    inner class ItemHolder : EpoxyButterKnifeHolder() {
        lateinit var firstName: EditText
        lateinit var lastName: EditText
        lateinit var location: EditText
        lateinit var button: Button

        override fun bindView(itemView: View) {
            firstName = itemView.findViewById(R.id.first_name_form_edit)
            lastName = itemView.findViewById(R.id.last_name_form_edit)
            location = itemView.findViewById(R.id.location_form_edit)
            button = itemView.findViewById(R.id.save_button)
        }

        fun bind() {
            button.setOnClickListener{
                function.invoke(this.firstName.text.toString(),
                        this.lastName.text.toString(),
                        this.location.text.toString())
            }
        }
    }
}