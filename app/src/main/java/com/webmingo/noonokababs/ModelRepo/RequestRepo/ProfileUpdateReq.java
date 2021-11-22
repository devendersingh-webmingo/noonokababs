package com.webmingo.noonokababs.ModelRepo.RequestRepo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ProfileUpdateReq {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mobile_number")
    @Expose
    private String mobileNumber;
    @SerializedName("address")
    @Expose
    private String adress;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("_method")
    @Expose
    private String _method;

    public ProfileUpdateReq(String name, String email, String mobileNumber, String adress, String dob, String gender, String _method) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.adress = adress;
        this.dob = dob;
        this.gender = gender;
        this._method = _method;
    }

}


