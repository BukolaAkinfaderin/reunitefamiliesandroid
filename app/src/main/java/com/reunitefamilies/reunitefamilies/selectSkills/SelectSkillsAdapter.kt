package com.reunitefamilies.reunitefamilies.selectSkills

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reunitefamilies.reunitefamilies.Api.models.Skill
import com.reunitefamilies.reunitefamilies.R
import kotlinx.android.synthetic.main.select_skills_row.view.*

class SelectSkillsAdapter : RecyclerView.Adapter<SelectSkillsAdapter.ViewHolder>() {
    var skills: MutableList<Skill> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.select_skills_row, parent, false))
    }

    override fun getItemCount(): Int = skills.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(skills[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(skill: Skill, ) {
            itemView.tvSkillName.text = skill.name
            itemView.cbSkillSelected.setOnClickListener {  }
        }

    }

}