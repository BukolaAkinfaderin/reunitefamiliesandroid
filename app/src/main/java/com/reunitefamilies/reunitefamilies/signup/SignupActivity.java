package com.reunitefamilies.reunitefamilies.signup;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.reunitefamilies.reunitefamilies.R;
import com.reunitefamilies.reunitefamilies.Utils.Utils;
import com.reunitefamilies.reunitefamilies.landing.LandingActivity;
import com.reunitefamilies.reunitefamilies.main.BaseActivity;
import com.reunitefamilies.reunitefamilies.preferences.AppPreferences;
import com.reunitefamilies.reunitefamilies.signIn.SigninActivity;
import com.reunitefamilies.reunitefamilies.signup.model.UserModel;

import java.util.Vector;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class SignupActivity extends BaseActivity {

    Button signupButton;
    Button signinButton;
    SignupPresenter mSignupPresenter;
    EditText firstNameEditText;

    EditText emailEditText;
    EditText passwordField;
    ImageView hideShowPassword;

    String email = "";
    String password = "";
    String name = "";
    String lastName = "";
    String accountType ="guardian";

    ProgressBar progressBar;

    CompositeDisposable mCompositedisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        AuthenticationDependencies.inject(this);

        signupButton = findViewById(R.id.sign_up_button);
        signinButton = findViewById(R.id.sign_up_signin_button);
        firstNameEditText = findViewById(R.id.first_name_editText);

        emailEditText = findViewById(R.id.email_editText);
        passwordField = findViewById(R.id.edittext_password);
        hideShowPassword = findViewById(R.id.signup_show_hide);

        hideShowPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideShowPasswordAction();
            }
        });

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidateUser(accountType);
            }
        });

    }


    private void hideShowPasswordAction() {

        final int invisiblePassword = InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT;
        final int visiblePassword = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD | InputType.TYPE_CLASS_TEXT;

        final boolean isPasswordVisible = passwordField.getInputType() == visiblePassword;

        final int newPasswordVisibility = isPasswordVisible ? invisiblePassword : visiblePassword;
        passwordField.setInputType(newPasswordVisibility);

        final float enabledAlpha = (float) 1.0;
        final float disabledAlpha = (float) 0.6;
        final float alpha = isPasswordVisible ? disabledAlpha : enabledAlpha;
        hideShowPassword.setAlpha(alpha);

    }

    public void provide(final SignupPresenter presenter) {
        this.mSignupPresenter = presenter;
    }

    public void ValidateUser(String accountType) {
        email =  emailEditText.getText().toString();
        password = passwordField.getText().toString();
        name = firstNameEditText.getText().toString();




        //validation
        Vector<String> checkValid =new Vector<String>();
        if (!Utils.isValidEmail(email)) {
            checkValid.addElement("Please Enter a Valid Email");
        }
        if (password.equalsIgnoreCase("")) {
            checkValid.addElement("Please enter a Password");
        }
        if (name.isEmpty()) {
            checkValid.addElement("Please enter your firstname");
        }

        if ( checkValid.size()==0) {
            Utils.showProgressDialog(this);


          Register(email, password, name, accountType);
        }
        else {
            String validMessage = checkValid.elementAt(0).toString();
            Toast.makeText(getApplicationContext(), validMessage, Toast.LENGTH_LONG).show();
        }

    }


    public void Register(final String email, String password, final String firstName,
                                final String accountType) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //  Log.d(TAG, "createUser:onComplete:" + task.isSuccessful());
                        Utils.hideProgressDialog();

                        if (task.isSuccessful()) {
                            //preferences.setIsRegisteredUser(true);
                            //Utils.LogAnalytics("Register", " User Registered", context);
                            onAuthSuccess(firstName, "", task.getResult().getUser(), accountType);


                        } else {
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                            //Utils.LogAnalytics("Register", " User Register Failure", context);
                        }
                        if (progressBar != null)
                            progressBar.setVisibility(View.INVISIBLE);
                    }
                });

    }

    private void onAuthSuccess(final String firstName, String lastName, final FirebaseUser user, String accountType) {
        AppPreferences preferences = new AppPreferences(this);

        UserModel userModel = new UserModel(firstName, lastName, user.getUid(),"", user.getEmail(), "unknown", "", accountType);
        preferences.saveCurrentUser(userModel);

        // Go to MainActivity

        if (userModel != null) {
             UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
             .setDisplayName(firstName + " " + lastName).build();

             user.updateProfile(profileUpdates);

            logUserToDatabase(userModel);
        }

        Intent intent = new Intent(this, LandingActivity.class);
        this.startActivity(intent);

    }

    public void logUserToDatabase(UserModel userModel) {

        CompositeDisposable compositeDisposable = new CompositeDisposable();

        compositeDisposable.add(mSignupPresenter.uploadUser(userModel).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {

                if (s.equalsIgnoreCase("success")){
                gotoMain();
                }
                else {
                    Toast.makeText(SignupActivity.this, "Sign up error", Toast.LENGTH_LONG).show();
                }

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e("user_upload_error", "onError(): ", throwable);
            }
        }));

    }

    private void gotoMain() {
        Intent intent = new Intent(this, LandingActivity.class);
                startActivity(intent);

    }

}
