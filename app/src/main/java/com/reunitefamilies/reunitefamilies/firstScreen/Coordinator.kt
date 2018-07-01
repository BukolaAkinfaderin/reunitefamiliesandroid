package com.reunitefamilies.reunitefamilies.firstScreen

import com.reunitefamilies.reunitefamilies.signIn.SignInActivity

class Coordinator(presenter: Presenter): Contract.Coordination {
    override fun signInWasTapped(activity: ReuniteFamilies) {
        activity.startActivity(SignInActivity.startIntent(activity))
    }

    override fun logInWasTapped(activity: ReuniteFamilies) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}