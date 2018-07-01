package com.reunitefamilies.reunitefamilies.upLoadChildScreen;

import com.reunitefamilies.reunitefamilies.models.Child;

import io.reactivex.Observable;

public interface UploadChildPresenter {

    Observable<String> uploadChild(Child child);
    void onDestroy();

}
