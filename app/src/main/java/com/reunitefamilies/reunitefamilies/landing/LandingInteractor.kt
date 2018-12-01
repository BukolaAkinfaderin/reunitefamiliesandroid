package com.reunitefamilies.reunitefamilies.landing

import com.reunitefamilies.reunitefamilies.service.service
import com.reunitefamilies.reunitefamilies.signup.model.UserModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LandingInteractor : LandingContract.Interaction {

    override fun getUserInfo(userId: String): Observable<UserModel> {
        return service.getUserInfo(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}