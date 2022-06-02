package com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.UserAddressBook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryRepoID {


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

        @SerializedName("country")
        @Expose
        private Country country;

        public Country getCountry() {
            return country;
        }

        public void setCountry(Country country) {
            this.country = country;
        }

        public class Country {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("code")
            @Expose
            private String code;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("phonecode")
            @Expose
            private Integer phonecode;
            @SerializedName("created_at")
            @Expose
            private Object createdAt;
            @SerializedName("updated_at")
            @Expose
            private Object updatedAt;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getPhonecode() {
                return phonecode;
            }

            public void setPhonecode(Integer phonecode) {
                this.phonecode = phonecode;
            }

            public Object getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(Object createdAt) {
                this.createdAt = createdAt;
            }

            public Object getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(Object updatedAt) {
                this.updatedAt = updatedAt;
            }

        }
    }
}