package com.reunitefamilies.reunitefamilies.signup;


import com.reunitefamilies.reunitefamilies.service.service;
import com.reunitefamilies.reunitefamilies.signup.model.UserModel;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by bakinfaderin on 2/5/18.
 */

public class SignupInteractorImpl implements SignupInteractor {


    @Override
    public Observable<String> uploadUser(UserModel userModel) {
        return service.getSharedInstance().addUserToDatabase(userModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
