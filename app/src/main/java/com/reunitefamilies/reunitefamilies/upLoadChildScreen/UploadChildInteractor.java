package com.reunitefamilies.reunitefamilies.upLoadChildScreen;

import com.reunitefamilies.reunitefamilies.Api.apiservice;
import com.reunitefamilies.reunitefamilies.models.Child;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UploadChildInteractor implements UploadChildContract.Interaction {
    @Override
    public Observable<String> uploadChild(Child childModel) {
        return apiservice.getSharedInstance().addChildToDatabase(childModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
