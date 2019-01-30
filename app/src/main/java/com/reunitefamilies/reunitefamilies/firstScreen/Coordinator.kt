package com.reunitefamilies.reunitefamilies.firstScreen

import com.reunitefamilies.reunitefamilies.logIn.LogInActivity
import com.reunitefamilies.reunitefamilies.signIn.SigninActivity

class Coordinator(presenter: Presenter): Contract.Coordination {
    override fun signInWasTapped(activity: ReuniteFamilies) {
        activity.startActivity(SigninActivity.startIntent(activity))
    }

    override fun logInWasTapped(activity: ReuniteFamilies) {
        activity.startActivity(LogInActivity.startIntent(activity))
    }

}