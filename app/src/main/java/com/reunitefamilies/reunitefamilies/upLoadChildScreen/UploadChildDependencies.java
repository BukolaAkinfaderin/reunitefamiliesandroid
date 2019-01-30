package com.reunitefamilies.reunitefamilies.upLoadChildScreen;

import android.app.Activity;

/**
 * Created by bakinfaderin on 1/23/18.
 */

public class UploadChildDependencies {

    public static void inject(Activity activity) {

        if (activity instanceof UploadChildActivity) {
            UploadChildInteractor interactor = new UploadChildInteractor();
            UploadScreenCoordinator coordinator = new UploadScreenCoordinator(activity);
            final UploadChildPresenter presenter = new UploadChildPresenter(interactor, coordinator) ;




           ((UploadChildActivity) activity).provide(presenter);

        }




    }
}
