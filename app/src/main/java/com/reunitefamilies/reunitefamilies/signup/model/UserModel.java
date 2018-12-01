package com.reunitefamilies.reunitefamilies.signup.model;

import java.io.Serializable;

/**
 * Created by bakinfaderin on 2/5/18.
 */

public class UserModel implements Serializable {
    String first_name;
    String last_name;
    String uid;
    String photoUrl;
    String email;
    String location;
    String profile_description;
    String accountType;




    public UserModel(){

    }



    public UserModel(String first_name, String last_name, String uid, String photo_url, String email,
                      String location, String description, String accountType) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.uid = uid;
        this.photoUrl = photo_url;
        this.email = email;
        this.location = location;
        this.profile_description = description;
        this.accountType = accountType;

    }

    public String getLast_name() {
        return last_name;
    }
    public String getFirst_name() {
        return first_name;
    }

    public String getUid() {
        return uid;
    }

    public String getPhotoUrl() {
        return  photoUrl;
    }

    public  String  getEmail() {
        return email;
    }


    public String getLocation() {
        return location;
    }

    public String getProfile_description() {
        if (profile_description == null)
            return "";
        else
            return profile_description;
    }



    public String getAccountType() {
            return accountType;
    }



}
