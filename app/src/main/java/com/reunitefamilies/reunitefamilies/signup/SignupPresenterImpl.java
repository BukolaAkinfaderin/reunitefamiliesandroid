package com.reunitefamilies.reunitefamilies.signup;


import com.reunitefamilies.reunitefamilies.signup.model.UserModel;

import io.reactivex.Observable;

/**
 * Created by bakinfaderin on 2/5/18.
 */

public class SignupPresenterImpl implements SignupPresenter {
    private final SignupInteractor mInteractor;


    public SignupPresenterImpl(final SignupInteractor interactor) {
        mInteractor = interactor;
    }


    @Override
    public Observable<String> uploadUser(UserModel userModel) {
        return mInteractor.uploadUser(userModel);
    }
}
