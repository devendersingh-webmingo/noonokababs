package com.webmingo.oldjerusalemrestaurant.ModelRepo.Orderhistory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InvoiceRepo {

    @SerializedName("url")
    @Expose
    private String url;

    public String geturl() {
        return url;
    }

    public void seturl(String url) {
        this.url = url;
    }

}