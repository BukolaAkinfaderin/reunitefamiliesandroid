package com.reunitefamilies.reunitefamilies.upLoadChildScreen;

import com.reunitefamilies.reunitefamilies.models.Child;

import io.reactivex.Observable;

public interface UploadChildContract {

    interface Interaction {
        Observable<String> uploadChild(Child childModel);
    }

    interface Presentation {

        Observable<String> uploadChild(Child child);
    }

    interface  Coordination {
        void uploadButtonClicked(UploadChildActivity activity);

    }


}
