package com.reunitefamilies.reunitefamilies.main

interface LandingContract {
    interface Interaction {

    }

    interface Presentation {
        fun openRegistrationIfNeeded()
    }

    interface Coordination {
        fun openRegistrationAndExit()
    }
}