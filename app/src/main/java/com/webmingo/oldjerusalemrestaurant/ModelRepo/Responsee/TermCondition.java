package com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TermCondition {



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

        @SerializedName("term")
        @Expose
        private Term term;

        public Term getTerm() {
            return term;
        }

        public void setTerm(Term term) {
            this.term = term;
        }

        public class Term {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("heading")
            @Expose
            private String heading;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("description")
            @Expose
            private String description;
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

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
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
