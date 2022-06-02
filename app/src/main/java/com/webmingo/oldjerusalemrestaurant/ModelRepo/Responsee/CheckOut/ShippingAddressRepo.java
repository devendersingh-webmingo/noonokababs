package com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShippingAddressRepo {




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

        @SerializedName("shippings")
        @Expose
        private List<Shipping> shippings = null;

        public List<Shipping> getShippings() {
            return shippings;
        }

        public void setShippings(List<Shipping> shippings) {
            this.shippings = shippings;
        }


        public class Shipping {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("user_id")
            @Expose
            private Integer userId;
            @SerializedName("type")
            @Expose
            private String type;
            @SerializedName("country_id")
            @Expose
            private Integer countryId;
            @SerializedName("state_id")
            @Expose
            private Integer stateId;
            @SerializedName("city_id")
            @Expose
            private Integer cityId;
            @SerializedName("address")
            @Expose
            private String address;
            @SerializedName("landmark")
            @Expose
            private Object landmark;
            @SerializedName("pincode")
            @Expose
            private String pincode;
            @SerializedName("mobile_number")
            @Expose
            private String mobileNumber;
            @SerializedName("set_as_default")
            @Expose
            private String setAsDefault;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public Integer getCountryId() {
                return countryId;
            }

            public void setCountryId(Integer countryId) {
                this.countryId = countryId;
            }

            public Integer getStateId() {
                return stateId;
            }

            public void setStateId(Integer stateId) {
                this.stateId = stateId;
            }

            public Integer getCityId() {
                return cityId;
            }

            public void setCityId(Integer cityId) {
                this.cityId = cityId;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public Object getLandmark() {
                return landmark;
            }

            public void setLandmark(Object landmark) {
                this.landmark = landmark;
            }

            public String getPincode() {
                return pincode;
            }

            public void setPincode(String pincode) {
                this.pincode = pincode;
            }

            public String getMobileNumber() {
                return mobileNumber;
            }

            public void setMobileNumber(String mobileNumber) {
                this.mobileNumber = mobileNumber;
            }

            public String getSetAsDefault() {
                return setAsDefault;
            }

            public void setSetAsDefault(String setAsDefault) {
                this.setAsDefault = setAsDefault;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }

        }

    }



}
