package com.webmingo.oldjerusalemrestaurant.ModelRepo.RequestRepo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddCartRequest {

    @SerializedName("card_number")
    @Expose
    private String cardNumber;
    @SerializedName("expiration_month")
    @Expose
    private String expirationMonth;
    @SerializedName("expiration_year")
    @Expose
    private String expirationYear;
    @SerializedName("cvc")
    @Expose
    private String cvc;
    @SerializedName("set_as_default")
    @Expose
    private String setAsDefault;
    @SerializedName("future_payment")
    @Expose
    private String futurePayment;


    @SerializedName("_method")
    @Expose
    private String _method;

    public AddCartRequest(String cardNumber, String expirationMonth, String expirationYear, String cvc, String setAsDefault, String futurePayment, String _method) {
        this.cardNumber = cardNumber;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.cvc = cvc;
        this.setAsDefault = setAsDefault;
        this.futurePayment = futurePayment;
        this._method = _method;
    }

    public AddCartRequest(String cardNumber, String expirationMonth, String expirationYear, String cvc, String setAsDefault, String futurePayment) {

        this.cardNumber = cardNumber;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.cvc = cvc;
        this.setAsDefault = setAsDefault;
        this.futurePayment = futurePayment;
    }
}