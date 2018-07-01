package com.reunitefamilies.reunitefamilies.upLoadChildScreen;

import com.reunitefamilies.reunitefamilies.models.Child;
import com.reunitefamilies.reunitefamilies.service.service;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UpLoadChildInteractorImpl implements UploadChildInteractor {
    @Override
    public Observable<String> uploadChild(Child childModel) {
        return service.getSharedInstance().addChildToDatabase(childModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
