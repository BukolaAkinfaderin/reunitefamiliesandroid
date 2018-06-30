package com.reunitefamilies.reunitefamilies.signIn

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.reunitefamilies.reunitefamilies.R
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener



class SignInActivity: AppCompatActivity() {
    companion object {
        fun startIntent(context: Context): Intent {
            val intent = Intent(context, SignInActivity::class.java)
            return intent
        }
    }

    private lateinit var presenter: Contract.Presentation
    private lateinit var coordinatior: Contract.Coordination

    private lateinit var mDatabaseReference: DatabaseReference

    fun provide(coordinatior: Contract.Coordination, presenter: Contract.Presentation){
        this.presenter = presenter
        this.coordinatior = coordinatior
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        Dependencies().inject(this)

        mDatabaseReference = FirebaseDatabase.getInstance().reference

        mDatabaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)
                Log.d("Testing", "Value is: " + value!!)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Testing", "Failed to read value.", error.toException())
            }
        })

    }
}