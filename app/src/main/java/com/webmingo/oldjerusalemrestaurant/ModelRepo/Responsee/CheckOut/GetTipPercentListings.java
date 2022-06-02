package com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetTipPercentListings {



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

        @SerializedName("percents")
        @Expose
        private List<Percent> percents = null;

        public List<Percent> getPercents() {
            return percents;
        }

        public void setPercents(List<Percent> percents) {
            this.percents = percents;
        }

        public class Percent {

            @SerializedName("label")
            @Expose
            private String label;
            @SerializedName("value")
            @Expose
            private Integer value;

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public Integer getValue() {
                return value;
            }

            public void setValue(Integer value) {
                this.value = value;
            }

        }
    }


}
