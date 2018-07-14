package com.reunitefamilies.reunitefamilies.main

import com.reunitefamilies.reunitefamilies.firstScreen.ReuniteFamilies

class LandingCoordinator(val activity: LandingActivity): LandingContract.Coordination {
    override fun openRegistrationAndExit() {
        activity.startActivity(ReuniteFamilies.startIntent(activity))
        activity.finish()
    }
}