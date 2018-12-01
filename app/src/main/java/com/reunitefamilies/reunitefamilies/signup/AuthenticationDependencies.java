package com.reunitefamilies.reunitefamilies.signup;

import android.app.Activity;

import com.reunitefamilies.reunitefamilies.signIn.SigninActivity;

/**
 * Created by bakinfaderin on 1/23/18.
 */

public class AuthenticationDependencies {

    public static void inject(Activity activity) {



        if (activity instanceof SignupActivity) {
            final SignupInteractorImpl interactor = new SignupInteractorImpl();
            final SignupPresenterImpl presenter = new SignupPresenterImpl(interactor);

            ((SignupActivity) activity).provide(presenter);

        }


    }
}
