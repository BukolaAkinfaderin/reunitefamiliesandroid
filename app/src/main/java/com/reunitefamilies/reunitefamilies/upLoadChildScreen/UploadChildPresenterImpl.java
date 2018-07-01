package com.reunitefamilies.reunitefamilies.upLoadChildScreen;

import com.reunitefamilies.reunitefamilies.models.Child;

import io.reactivex.Observable;

public class UploadChildPresenterImpl implements UploadChildPresenter {
    private final UploadChildInteractor mInteractor;


    public UploadChildPresenterImpl(final UploadChildInteractor interactor) {
        mInteractor = interactor;
    }
    @Override
    public Observable<String> uploadChild(Child child) {
        return mInteractor.uploadChild(child);
    }

    @Override
    public void onDestroy() {

    }
}
