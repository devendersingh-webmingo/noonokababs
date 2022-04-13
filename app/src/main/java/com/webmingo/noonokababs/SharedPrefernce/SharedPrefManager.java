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

    public void UserDetails(User_Data user_data) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("email", user_data.getEmail());
        editor.putString("name", user_data.getUserName());
        editor.putString("phone", user_data.getPhoneNo());

        editor.apply();

    }

    public String GetEmailid() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("email", null);

    }  public String GetName() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("name", null);

    }  public String Getphone() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("phone", null);

    }

    public void SavecheckOutAmount(CheckAmount checkAmount) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("MRP", checkAmount.getMRP());
        editor.putString("Discount", checkAmount.getDiscount());
        editor.putString("CouponDiscount", checkAmount.getCouponDiscount());
        editor.putString("Subtotal", checkAmount.getSubtotal());
        editor.putString("Taxes", checkAmount.getTaxes());
        editor.putString("Total", checkAmount.getTotal());
        editor.putString("CouponId", checkAmount.getCouponId());
        editor.putString("coupon_discount", checkAmount.getCoupon_discount());
        editor.putString("TaxName", checkAmount.TaxName);
        editor.putString("TaxPercent", checkAmount.TaxPercent);
        editor.putString("total_discount_amount", checkAmount.total_discount_amount);
        editor.apply();

    }




    public String getTaxName() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("TaxName", null);

    }



    public String getTaxPercent() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("TaxPercent", null);

    }

    public String GettotalDiscountAmount() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("total_discount_amount", null);

    }




    public String getcoupon_discount() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("coupon_discount", null);

    }

    public String getCouponId() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("CouponId", null);

    }

    public String getMRP() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("MRP", null);

    }

    public String getDiscount() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("Discount", null);

    }

    public String getCouponDiscount() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("CouponDiscount", null);

    }

    public String getSubtotal() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("Subtotal", null);

    }

    public String getTaxes() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("Taxes", null);

    }

    public String getTotal() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("Total", null);

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