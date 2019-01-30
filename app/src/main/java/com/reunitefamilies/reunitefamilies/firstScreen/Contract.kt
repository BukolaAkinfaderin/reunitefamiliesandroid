package com.reunitefamilies.reunitefamilies.firstScreen

interface Contract {
    interface Interaction {

    }

    interface Presentation {

    }

    interface Coordination {
        fun signInWasTapped(activity: ReuniteFamilies)
        fun logInWasTapped(activity: ReuniteFamilies)
    }
}