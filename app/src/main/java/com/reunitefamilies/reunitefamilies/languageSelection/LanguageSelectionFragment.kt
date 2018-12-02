package com.reunitefamilies.reunitefamilies.languageSelection


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.reunitefamilies.reunitefamilies.R

class LanguageSelectionFragment : Fragment(), LanguageSelectionContract.View {

    private lateinit var languagesRecyclerView: RecyclerView

    private val languageAdapter = LanguageSelectionAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_language_selection, container, false)
        initViews(root)
        return root
    }

    private fun initViews(root: View) {
        languagesRecyclerView = root.findViewById(R.id.language_selection_recycler_view)
    }

    override fun setSuggestedLanguages(suggestedLanguages: List<LanguageSelection>) {
        languageAdapter.setLanguages(suggestedLanguages)
    }
}
