package com.reunitefamilies.reunitefamilies.signup;

import com.reunitefamilies.reunitefamilies.models.Child;

import io.reactivex.Observable;

public interface SignupInteractor {

    Observable <String> registerUser(Child childModel);
}
