package com.reunitefamilies.reunitefamilies.landing

import android.hardware.usb.UsbRequest
import com.reunitefamilies.reunitefamilies.signup.model.UserModel
import io.reactivex.Observable

interface LandingContract {

    interface Interaction {
        fun getUserInfo(userId: String): Observable<UserModel>
    }

    interface Presentation {
    fun getUserInfo(userId: String): Observable<UserModel>
    }

    interface  Coordination {

    }
}