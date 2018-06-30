package com.reunitefamilies.reunitefamilies.upLoadChildScreen;

import com.reunitefamilies.reunitefamilies.models.Child;

import java.util.ArrayList;

import io.reactivex.Observable;

public interface UploadChildInteractor {

    Observable <String> uploadChild(Child childModel);
}
