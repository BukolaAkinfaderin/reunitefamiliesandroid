package com.reunitefamilies.reunitefamilies.firstScreen

interface Contract {
    interface Interaction {

    }

    interface Presentation {

    }

    interface Coordination {
        fun signInWasTapped(reuniteFamilies: ReuniteFamilies)
        fun logInWasTapped(reuniteFamilies: ReuniteFamilies)
    }
}