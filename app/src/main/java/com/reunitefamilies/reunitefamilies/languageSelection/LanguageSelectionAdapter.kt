/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package com.reunitefamilies.reunitefamilies.languageSelection

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.reunitefamilies.reunitefamilies.R

class LanguageSelectionAdapter : RecyclerView.Adapter<LanguageSelectionViewHolder>() {

    private var selectionOptions: List<LanguageSelection> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageSelectionViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.language_selection_tile, parent, false)
        val checkbox = root.findViewById<CheckBox>(R.id.language_selection_checkbox)
        val languageView = root.findViewById<TextView>(R.id.language_selection_text_view)
        return LanguageSelectionViewHolder(root, languageView, checkbox)
    }

    override fun getItemCount(): Int = selectionOptions.size

    override fun onBindViewHolder(holder: LanguageSelectionViewHolder, position: Int) {
        val selection = selectionOptions[position]
        holder.checkBox.isChecked = selection.selected
        holder.languageTv.text = selection.language
    }

    fun setLanguages(options: List<LanguageSelection>) {
        selectionOptions = options
        notifyDataSetChanged()
    }
}

class LanguageSelectionViewHolder(
        val itemView: View,
        val languageTv: TextView,
        val checkBox: CheckBox
) : RecyclerView.ViewHolder(itemView)
