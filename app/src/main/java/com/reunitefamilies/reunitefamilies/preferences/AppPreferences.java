package com.reunitefamilies.reunitefamilies.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.reunitefamilies.reunitefamilies.constants.Constants;
import com.reunitefamilies.reunitefamilies.main.BaseApplication;
import com.reunitefamilies.reunitefamilies.signup.model.UserModel;

public class AppPreferences {

    private final Context context;
    private static AppPreferences sSharedInstance;

    public AppPreferences(Context context) {
        this.context = context;
    }

    private SharedPreferences getSharedPreferences() {
        return context.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    /**
     * getSharedInstance.
     *
     * @return Preferences
     */
    public static AppPreferences getSharedInstance() {
        if (sSharedInstance == null) {
            sSharedInstance = new AppPreferences(BaseApplication.getAppContext());
        }
        return sSharedInstance;
    }

    public void saveCurrentUser(UserModel userModel){
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        Gson gson = new Gson();
        String json = gson.toJson(userModel);
        edit.putString(Constants.PREFS_CurrentUser, json);
        edit.commit();
    }

    public UserModel getCurrentUser() {
        Gson gson = new Gson();
        String json = getSharedPreferences().getString(Constants.PREFS_CurrentUser, "");
        return gson.fromJson(json, UserModel.class);
    }
}
