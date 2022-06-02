package com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.UserAddressBook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddNewAddressRepo {



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

        @SerializedName("address")
        @Expose
        private Address address;

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public class Address {

            @SerializedName("user_id")
            @Expose
            private Integer userId;
            @SerializedName("type")
            @Expose
            private String type;
            @SerializedName("country_id")
            @Expose
            private String countryId;
            @SerializedName("state_id")
            @Expose
            private String stateId;
            @SerializedName("city_id")
            @Expose
            private String cityId;
            @SerializedName("address")
            @Expose
            private String address;
            @SerializedName("pincode")
            @Expose
            private String pincode;
            @SerializedName("mobile_number")
            @Expose
            private String mobileNumber;
            @SerializedName("set_as_default")
            @Expose
            private String setAsDefault;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("id")
            @Expose
            private Integer id;

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

            public String getCountryId() {
                return countryId;
            }

            public void setCountryId(String countryId) {
                this.countryId = countryId;
            }

            public String getStateId() {
                return stateId;
            }

            public void setStateId(String stateId) {
                this.stateId = stateId;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
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

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

        }
    }


}
