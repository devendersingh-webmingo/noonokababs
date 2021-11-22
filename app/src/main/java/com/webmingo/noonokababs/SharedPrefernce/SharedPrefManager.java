package com.webmingo.noonokababs.SharedPrefernce;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;


public class SharedPrefManager {
    private static final String SHARED_PREF_NAME = "Prebhat";
    private static final String KEY_ID = "keyid";
    private static final String KEY_EMAIL = "keyemail";
    private static final String KEY_TOKEN = "KEY_TOKEN";
    private static final String KEY_REFERRAL_CODE = "KEY_REFERRAL_CODE";
    private static final String KEY_USERNAME = "KEY_USERNAME";
    private static final String KEY_USERPHONE = "KEY_USERPHONE";
    private static SharedPrefManager mInstance;

    private static Context mCtx;

    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    //method to let the user login
    //this method will store the user data in shared preferences

    //this method will checker whether user is already logged in or no
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_TOKEN, null) != null;
    }

    //this method will give the logged in user
    public User_Data getLoginDATA() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User_Data(
                sharedPreferences.getString(KEY_ID, null),
                 sharedPreferences.getString(KEY_EMAIL, null),
                sharedPreferences.getString(KEY_TOKEN, null),
                sharedPreferences.getString(KEY_REFERRAL_CODE, null),
                sharedPreferences.getString(KEY_USERNAME,null ),
                sharedPreferences.getString(KEY_USERPHONE,null)

                );
    }

    public void SetAccessToken(String Token) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_TOKEN, Token);
        editor.apply();
    }
    public void SetEmail(String Email) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_EMAIL, Email);
        editor.apply();
    }
    public String GetEmail() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_EMAIL, null);

    }

    public String GetAccessToken() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_TOKEN, null);

    }


    //this method will logout the user
    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        /*

        Intent intent = new Intent(mCtx, Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        mCtx.startActivity(intent);*/


    }
}