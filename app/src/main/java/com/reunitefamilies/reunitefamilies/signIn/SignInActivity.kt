package com.reunitefamilies.reunitefamilies.signIn

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.reunitefamilies.reunitefamilies.R
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import com.reunitefamilies.reunitefamilies.adapter.Adapter
import com.reunitefamilies.reunitefamilies.models.Children

class SignInActivity: AppCompatActivity() {
    companion object {
        fun startIntent(context: Context): Intent {
            val intent = Intent(context, SignInActivity::class.java)
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
        setContentView(R.layout.activity_sign_in)

        Dependencies().inject(this)

        list = findViewById(R.id.list)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        list.layoutManager = layoutManager

        adapter = Adapter()
        list.adapter = adapter

        mDatabaseReference = FirebaseDatabase.getInstance().reference
        mDatabaseReference.child("children").child(mDatabaseReference.push().key!!).setValue(
                Children("origin", "dob", "first_name", "last_name", "location", 5, "pending" ))

//        // Attach a listener to read the data at our posts reference
//        mDatabaseReference.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                val post = dataSnapshot.getValue<Children>(Children::class.java)
//                Log.d("Testing", "Post is: " + post as Children)
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {
//                println("The read failed: " + databaseError.code)
//            }
//        })

        val childrenList = ArrayList<Children>()
        val database = FirebaseDatabase.getInstance().reference


        database.child("children").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (childrenDataSnapshot in dataSnapshot.children) {
                    val child = childrenDataSnapshot.getValue(Children::class.java)
                    childrenList.add(child!!)
                    adapter?.childRow(child.first_name!!, child.last_name!!)
                }

                Log.d("Testing", ">>>>> children List is: " + childrenList)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                println("The read failed: " + databaseError.code)
            }
        })
    }
}