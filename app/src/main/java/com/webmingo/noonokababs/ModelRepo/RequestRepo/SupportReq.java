package com.webmingo.noonokababs.ModelRepo.RequestRepo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SupportReq {


    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mobile_number")
    @Expose
    private String mobile_number;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("message")
    @Expose
    private String message;


    public SupportReq(String name, String email, String mobile_number, String subject, String message) {
        this.name = name;
        this.email = email;
        this.mobile_number = mobile_number;
        this.subject = subject;
        this.message = message;
    }
}
