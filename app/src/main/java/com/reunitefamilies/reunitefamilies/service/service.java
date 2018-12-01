package com.reunitefamilies.reunitefamilies.service;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.reunitefamilies.reunitefamilies.Utils.Utils;
import com.reunitefamilies.reunitefamilies.constants.Constants;
import com.reunitefamilies.reunitefamilies.landing.LandingActivity;
import com.reunitefamilies.reunitefamilies.preferences.AppPreferences;
import com.reunitefamilies.reunitefamilies.signup.SignupPresenter;
import com.reunitefamilies.reunitefamilies.signup.model.UserModel;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class service {

    private static service sSharedInstance;


    public static service getSharedInstance() {
        if (sSharedInstance == null) {
            sSharedInstance = new service();
        }
        return sSharedInstance;
    }





    public static Observable<String> addUserToDatabase(UserModel user) {

        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference();

                String key = user.getUid();

                mDatabaseReference.child("users").child(key).setValue(user, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        String uploadMessage = "";
                        if (databaseError != null) {
                            Log.w("UpLoadUser", "Error uploading user: " + databaseError.getMessage());

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



    public static Observable<UserModel> getUserInfo(String uId){
        return Observable.create(new ObservableOnSubscribe<UserModel>() {
            @Override
            public void subscribe(ObservableEmitter<UserModel> emitter) throws Exception {
                DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference();

                mDatabaseReference.child("users").child(uId)  .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot != null) {

                            UserModel userModel = dataSnapshot.getValue(UserModel.class);

                            emitter.onNext(userModel);

                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                }) ;
            }
        });
    }

}
