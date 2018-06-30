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
import com.reunitefamilies.reunitefamilies.models.Children
import android.widget.Toast

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
    private lateinit var mPostReference: DatabaseReference

    fun provide(coordinatior: Contract.Coordination, presenter: Contract.Presentation){
        this.presenter = presenter
        this.coordinatior = coordinatior
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        Dependencies().inject(this)

        mDatabaseReference = FirebaseDatabase.getInstance().reference

        mDatabaseReference.child("children").child(mDatabaseReference.push().key!!).setValue(
                Children("origin", "dob", "first_name", "last_name", "location", 5, "pending" ))

        // Attach a listener to read the data at our posts reference
        mDatabaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val post = dataSnapshot.getValue<Children>(Children::class.java)
                Log.d("Testing", "Post is: " + post as Children)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                println("The read failed: " + databaseError.code)
            }
        })

        mPostReference = FirebaseDatabase.getInstance().getReference().child("children")

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                val post = dataSnapshot.getValue<Children>(Children::class.java)
                Log.d("Testing", "Post is: " + post as Children)

            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("Testing", "loadPost:onCancelled", databaseError.toException())

                Toast.makeText(this@SignInActivity, "Failed to load post.", Toast.LENGTH_SHORT).show()

            }
        }
        mPostReference.addValueEventListener(postListener)
    }
}