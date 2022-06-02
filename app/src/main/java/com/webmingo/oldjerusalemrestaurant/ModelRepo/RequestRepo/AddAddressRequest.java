package com.webmingo.oldjerusalemrestaurant.ModelRepo.RequestRepo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddAddressRequest {

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("mobile_number")
    @Expose
    private String mobile_number;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("pincode")
    @Expose
    private String pincode;

    @SerializedName("address_type")
    @Expose
    private String address_type;

    @SerializedName("set_as_default")
    @Expose
    private String set_as_default;


    @SerializedName("_method")
    @Expose
    private String method;

    public AddAddressRequest(String address, String mobile_number, String country, String state, String city, String pincode, String address_type, String set_as_default, String method) {
        this.address = address;
        this.mobile_number = mobile_number;
        this.country = country;
        this.state = state;
        this.city = city;
        this.pincode = pincode;
        this.address_type = address_type;
        this.set_as_default = set_as_default;
        this.method = method;
    }


    public AddAddressRequest(String address, String mobile_number, String country, String state, String city, String pincode, String address_type, String set_as_default) {

        this.address = address;
        this.mobile_number = mobile_number;
        this.country = country;
        this.state = state;
        this.city = city;
        this.pincode = pincode;
        this.address_type = address_type;
        this.set_as_default = set_as_default;
    }
}