package com.reunitefamilies.reunitefamilies.landing

import com.reunitefamilies.reunitefamilies.signup.model.UserModel
import io.reactivex.Observable

class LandingPresenter(interactor: LandingInteractor, coordinator: LandingCoordinator): LandingContract.Presentation {
    val mInteractor = interactor
    override fun getUserInfo(userId: String): Observable<UserModel> {
        return mInteractor.getUserInfo(userId)

    }

}