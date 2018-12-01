package com.reunitefamilies.reunitefamilies.signup;

import com.reunitefamilies.reunitefamilies.models.Child;
import com.reunitefamilies.reunitefamilies.signup.model.UserModel;

import io.reactivex.Observable;

public interface SignupInteractor {

    Observable <String> uploadUser(UserModel userModel);
}
