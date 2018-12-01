package com.reunitefamilies.reunitefamilies.Utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.provider.SyncStateContract;

import com.reunitefamilies.reunitefamilies.constants.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    static ProgressDialog mProgressDialog;


    public static void showProgressDialog(Context context) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(context);
            mProgressDialog.setCancelable(true);
            mProgressDialog.setMessage("Loading...");
        }
        if(!((Activity) context).isFinishing())
        {

        }

    }

    public static void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(Constants.EMAIL_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
