package com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.UserAddressBook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityRepoID {


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



            @SerializedName("city")
            @Expose
            private City city;

            public City getCity() {
                return city;
            }

            public void setCity(City city) {
                this.city = city;
            }


        public class City {

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
    }

}
