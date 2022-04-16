package com.webmingo.noonokababs.ModelRepo.Responsee.CheckOut;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTipAmountRepo {


    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }




    public class Data {

        @SerializedName("tip_amount")
        @Expose
        private String tipAmount;
        @SerializedName("tip_discount_percent")
        @Expose
        private String tipDiscountPercent;

        public String getTipAmount() {
            return tipAmount;
        }

        public void setTipAmount(String tipAmount) {
            this.tipAmount = tipAmount;
        }

        public String getTipDiscountPercent() {
            return tipDiscountPercent;
        }

        public void setTipDiscountPercent(String tipDiscountPercent) {
            this.tipDiscountPercent = tipDiscountPercent;
        }

    }



}
