package com.webmingo.noonokababs.ModelRepo.Responsee.CheckOut;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BranchsRepo {

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

        @SerializedName("branches")
        @Expose
        private List<Branch> branches = null;

        public List<Branch> getBranches() {
            return branches;
        }

        public void setBranches(List<Branch> branches) {
            this.branches = branches;
        }


        public class Branch {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("username")
            @Expose
            private String username;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("email")
            @Expose
            private String email;
            @SerializedName("mobile_number")
            @Expose
            private String mobileNumber;
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
            @SerializedName("get_country")
            @Expose
            private GetCountry getCountry;
            @SerializedName("get_state")
            @Expose
            private GetState getState;
            @SerializedName("get_city")
            @Expose
            private GetCity getCity;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getMobileNumber() {
                return mobileNumber;
            }

            public void setMobileNumber(String mobileNumber) {
                this.mobileNumber = mobileNumber;
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

            public GetCountry getGetCountry() {
                return getCountry;
            }

            public void setGetCountry(GetCountry getCountry) {
                this.getCountry = getCountry;
            }

            public GetState getGetState() {
                return getState;
            }

            public void setGetState(GetState getState) {
                this.getState = getState;
            }

            public GetCity getGetCity() {
                return getCity;
            }

            public void setGetCity(GetCity getCity) {
                this.getCity = getCity;
            }

            public class GetCity {

                @SerializedName("id")
                @Expose
                private Integer id;
                @SerializedName("state_id")
                @Expose
                private Integer stateId;
                @SerializedName("name")
                @Expose
                private String name;
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

                public Integer getStateId() {
                    return stateId;
                }

                public void setStateId(Integer stateId) {
                    this.stateId = stateId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
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

            public class GetCountry {

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

            public class GetState {

                @SerializedName("id")
                @Expose
                private Integer id;
                @SerializedName("country_id")
                @Expose
                private Integer countryId;
                @SerializedName("name")
                @Expose
                private String name;
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

                public Integer getCountryId() {
                    return countryId;
                }

                public void setCountryId(Integer countryId) {
                    this.countryId = countryId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
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



}
