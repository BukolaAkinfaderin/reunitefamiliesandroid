package com.reunitefamilies.reunitefamilies.Api;



import android.util.Log;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.reunitefamilies.reunitefamilies.models.Child;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class apiservice {

    private static apiservice sSharedInstance;


    public static apiservice getSharedInstance() {
        if (sSharedInstance == null) {
            sSharedInstance = new apiservice();
        }
        return sSharedInstance;
    }

    public static Observable<String> addChildToDatabase(final Child childModel) {

        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(final ObservableEmitter<String> emitter) throws Exception {
                DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference();

                String key = mDatabaseReference.push().getKey();


                mDatabaseReference.child("children").child(key).setValue(childModel, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        String uploadMessage = "";
                        if (databaseError != null) {
                            Log.w("UpLoadChild", "Error uploading child: " + databaseError.getMessage());

                            uploadMessage = "Error";
                        }
                        else {

                            uploadMessage = "Success";
                        }
                        emitter.onNext(uploadMessage);
                    }
                });

            }
        });
    }

    public static Observable<List<TaskModel>> getTasks() {
        return Observable.create(new ObservableOnSubscribe<List<TaskModel>>() {
            @Override
            public void subscribe(final ObservableEmitter<List<TaskModel>> emitter) throws Exception {

            }
        });
    }
}
