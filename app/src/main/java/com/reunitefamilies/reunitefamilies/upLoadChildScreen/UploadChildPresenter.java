package com.reunitefamilies.reunitefamilies.upLoadChildScreen;

import com.reunitefamilies.reunitefamilies.models.Child;

import io.reactivex.Observable;

public class UploadChildPresenter implements UploadChildContract.Presentation {
    private  UploadChildInteractor mInteractor;

    @Override
    public void UploadChildPresenterImpl(UploadChildInteractor interactor) {
        mInteractor = interactor;
    }

    @Override
    public Observable<String> uploadChild(Child child) {
        return mInteractor.uploadChild(child);
    }
}
