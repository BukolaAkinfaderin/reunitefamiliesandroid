package com.reunitefamilies.reunitefamilies.logIn

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.google.firebase.database.*
import com.reunitefamilies.reunitefamilies.R
import com.reunitefamilies.reunitefamilies.adapter.Adapter
import com.reunitefamilies.reunitefamilies.models.Child

class LogInActivity: AppCompatActivity() {
    companion object {
        fun startIntent(context: Context): Intent {
            val intent = Intent(context, LogInActivity::class.java)
            return intent
        }
    }

    private lateinit var presenter: Contract.Presentation
    private lateinit var coordinatior: Contract.Coordination

    private lateinit var list: RecyclerView
    private var adapter: Adapter? = null

    private lateinit var mDatabaseReference: DatabaseReference

    fun provide(coordinatior: Contract.Coordination, presenter: Contract.Presentation){
        this.presenter = presenter
        this.coordinatior = coordinatior
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_log_in)

        Dependencies().inject(this)

        list = findViewById(R.id.list)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        list.layoutManager = layoutManager

        adapter = Adapter()
        list.adapter = adapter

        adapter?.uploadChildForm { firstName, lastName, location ->
            mDatabaseReference = FirebaseDatabase.getInstance().reference
            mDatabaseReference.child("children").child(mDatabaseReference.push().key!!).setValue(
                    Child("origin", "dob", firstName, lastName, location, 5, "pending" ))

            // Attach a listener to read the data at our posts reference
            mDatabaseReference.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val post = dataSnapshot.getValue<Child>(Child::class.java)
                    Log.d("Testing", "Post is: " + post as Child)
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    println("The read failed: " + databaseError.code)
                }
            })
        }
    }
}