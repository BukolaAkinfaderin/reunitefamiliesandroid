package com.reunitefamilies.reunitefamilies.upLoadChildScreen;

import com.reunitefamilies.reunitefamilies.models.Child;

import io.reactivex.Observable;

public class UploadChildPresenter implements UploadChildContract.Presentation {
    private  UploadChildInteractor mInteractor;
    private UploadScreenCoordinator mCoordinator;

  public UploadChildPresenter(UploadChildInteractor interactor, UploadScreenCoordinator coordinator) {
      mInteractor = interactor;
      mCoordinator = coordinator;
  }


    @Override
    public Observable<String> uploadChild(Child child) {
        return mInteractor.uploadChild(child);
    }
}
