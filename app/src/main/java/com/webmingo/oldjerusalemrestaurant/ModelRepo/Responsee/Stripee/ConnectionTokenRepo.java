package com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.Stripee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConnectionTokenRepo {

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

        @SerializedName("client_secret")
        @Expose
        private String client_secret;


        @SerializedName("stripe_public_key")
        @Expose
        private String stripe_public_key;
        @SerializedName("stripe_secret_key")
        @Expose
        private String stripe_secret_key;


        public String getClient_secret() {
            return client_secret;
        }

        public void setClient_secret(String client_secret) {
            this.client_secret = client_secret;
        }

        public String getStripe_public_key() {
            return stripe_public_key;
        }

        public void setStripe_public_key(String stripe_public_key) {
            this.stripe_public_key = stripe_public_key;
        }

        public String getStripe_secret_key() {
            return stripe_secret_key;
        }

        public void setStripe_secret_key(String stripe_secret_key) {
            this.stripe_secret_key = stripe_secret_key;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "client_secret='" + client_secret + '\'' +
                    ", stripe_public_key='" + stripe_public_key + '\'' +
                    ", stripe_secret_key='" + stripe_secret_key + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ConnectionTokenRepo{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}