package com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RefoundPolicyRepo {


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

        @SerializedName("content")
        @Expose
        private Content content;

        public Content getContent() {
            return content;
        }

        public void setContent(Content content) {
            this.content = content;
        }

        public class Content {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("heading")
            @Expose
            private String heading;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("description")
            @Expose
            private String description;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getHeading() {
                return heading;
            }

            public void setHeading(String heading) {
                this.heading = heading;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

        }
    }
}
