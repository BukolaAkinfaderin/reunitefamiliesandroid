package com.reunitefamilies.reunitefamilies.signup;

import com.reunitefamilies.reunitefamilies.signup.model.UserModel;

import io.reactivex.Observable;

public interface SignupPresenter {

    Observable<String> uploadUser(UserModel userModel);
}
