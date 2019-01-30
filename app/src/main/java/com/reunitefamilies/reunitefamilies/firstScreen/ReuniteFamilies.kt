package com.reunitefamilies.reunitefamilies.firstScreen

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.reunitefamilies.reunitefamilies.R
import com.reunitefamilies.reunitefamilies.signIn.SigninActivity

class ReuniteFamilies : AppCompatActivity() {
    companion object {
        fun startIntent(context: Context): Intent {
            return Intent(context, SigninActivity::class.java)
        }
    }

    private lateinit var presenter: Contract.Presentation
    private lateinit var coordinatior: Contract.Coordination

    private lateinit var signInButton: Button
    private lateinit var logInButton: Button

    fun provide(coordinatior: Contract.Coordination, presenter: Contract.Presentation){
        this.presenter = presenter
        this.coordinatior = coordinatior
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reunite_families)

        Dependencies().inject(this)

        signInButton = findViewById(R.id.sign_in_button)
        logInButton = findViewById(R.id.log_in_button)

        signInButton.setOnClickListener {
            this.coordinatior.signInWasTapped(this)
        }

        logInButton.setOnClickListener {
            this.coordinatior.logInWasTapped(this)
        }
    }
}
