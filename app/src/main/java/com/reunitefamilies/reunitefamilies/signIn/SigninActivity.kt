package com.reunitefamilies.reunitefamilies.signIn

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle

import android.support.v7.widget.RecyclerView
import android.text.InputType
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.reunitefamilies.reunitefamilies.R
import com.reunitefamilies.reunitefamilies.IdentityVerification.VerificationActivity
import com.reunitefamilies.reunitefamilies.Utils.Utils
import com.reunitefamilies.reunitefamilies.adapter.UploadChildAdapter
import com.reunitefamilies.reunitefamilies.landing.LandingActivity
import com.reunitefamilies.reunitefamilies.main.BaseActivity
import com.reunitefamilies.reunitefamilies.signup.SignupActivity
import kotlinx.android.synthetic.main.activity_sign_in.*

class SigninActivity: BaseActivity() {
    companion object {
        fun startIntent(context: Context): Intent {
            val intent = Intent(context, SigninActivity::class.java)
            return intent
        }
    }

    private lateinit var presenter: Contract.Presentation
    private lateinit var coordinatior: Contract.Coordination
    var registerButton: Button? = null
    var signInButton: Button? = null
    var mEmailField: EditText? = null
    var mPasswordField: EditText? = null
    var mShowHideImageView: ImageView? =  null
    private var mAuth: FirebaseAuth? = null
    private var mProgressDialog: ProgressDialog? = null

    private lateinit var list: RecyclerView
    private var uploadChildAdapter: UploadChildAdapter? = null

    private lateinit var mDatabaseReference: DatabaseReference

    fun provide(coordinatior: Contract.Coordination, presenter: Contract.Presentation){
        this.presenter = presenter
        this.coordinatior = coordinatior
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        Dependencies().inject(this)

        registerButton = this.findViewById(R.id.register_button)
        signInButton = findViewById(R.id.sign_in_button_main)
        mEmailField = findViewById(R.id.signin_email)
        mPasswordField = findViewById(R.id.signin_password)
        mShowHideImageView = findViewById(R.id.signin_show_hide)

        mShowHideImageView!!.setOnClickListener({
            hideShowPasswordAction()
        })

        mAuth = FirebaseAuth.getInstance()
        mEmailField!!.setText("tlopez@gmail.com")
        mPasswordField!!.setText("password")
        signInButton!!.setOnClickListener ({
          showProgressDialog()
           signIn()
        }
        )
        registerButton!!.setOnClickListener({
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        })



    }

    fun showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog(this)
            mProgressDialog!!.setCancelable(false)
            mProgressDialog!!.setMessage("Loading...")
        }

        mProgressDialog!!.show()
    }

    private fun hideShowPasswordAction() {

        val invisiblePassword = InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT
        val visiblePassword = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD or InputType.TYPE_CLASS_TEXT

        val isPasswordVisible = mPasswordField!!.getInputType() == visiblePassword

        val newPasswordVisibility = if (isPasswordVisible) invisiblePassword else visiblePassword
        mPasswordField!!.setInputType(newPasswordVisibility)

        val enabledAlpha = 1.0.toFloat()
        val disabledAlpha = 0.6.toFloat()
        val alpha = if (isPasswordVisible) disabledAlpha else enabledAlpha
        mShowHideImageView!!.setAlpha(alpha)

    }

    private fun validateForm(): Boolean {

        var result = true

        if (!Utils.isValidEmail(mEmailField!!.getText().toString())) {
            mEmailField!!.setError("Valid email Required")
            result = false
        } else {
            mEmailField!!.setError(null)
        }

        if (TextUtils.isEmpty(mPasswordField!!.getText().toString())) {
            mPasswordField!!.setError("Required")
            result = false
        } else {
            mPasswordField!!.setError(null)
        }

        return result
    }

    private fun onAuthSuccess(user: FirebaseUser) {
        startActivity(Intent(this@SigninActivity, LandingActivity::class.java))
        finish()
    }

    private fun signIn() {
        Log.d("signin", "signIn")
        if (!validateForm()) {
            return
        }

        Utils.showProgressDialog(this)
        val email = mEmailField!!.getText().toString()
        val password = mPasswordField!!.getText().toString()

        mAuth!!.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(OnCompleteListener<AuthResult> { task ->
                    Log.d("signin", "signIn:onComplete:" + task.isSuccessful)
                    Utils.hideProgressDialog()

                    if (task.isSuccessful) {
                        onAuthSuccess(task.result.user)
                    } else {
                        Toast.makeText(this@SigninActivity, task.exception!!.message,
                                Toast.LENGTH_LONG).show()
                    }
                })
    }
}