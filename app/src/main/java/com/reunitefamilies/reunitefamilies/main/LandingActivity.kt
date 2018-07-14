package com.reunitefamilies.reunitefamilies.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.reunitefamilies.reunitefamilies.firstScreen.Contract


class LandingActivity: AppCompatActivity() {

    private lateinit var presenter: LandingContract.Presentation

    fun provide(presenter: LandingContract.Presentation) {
        this.presenter = presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        LandingDependencies().inject(this)

        this.presenter.openRegistrationIfNeeded()

    }

}