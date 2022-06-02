package com.webmingo.oldjerusalemrestaurant.ModelRepo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomePageRepo{


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

        @SerializedName("image_base_url")
        @Expose
        private String imageBaseUrl;
        @SerializedName("promotional_banners")
        @Expose
        private List<PromotionalBanner> promotionalBanners = null;

        public String getImageBaseUrl() {
            return imageBaseUrl;
        }

        public void setImageBaseUrl(String imageBaseUrl) {
            this.imageBaseUrl = imageBaseUrl;
        }

        public List<PromotionalBanner> getPromotionalBanners() {
            return promotionalBanners;
        }

        public void setPromotionalBanners(List<PromotionalBanner> promotionalBanners) {
            this.promotionalBanners = promotionalBanners;
        }


        public class PromotionalBanner {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("image")
            @Expose
            private String image;
            @SerializedName("position")
            @Expose
            private Integer position;
            @SerializedName("text_required")
            @Expose
            private String textRequired;
            @SerializedName("text")
            @Expose
            private String text;
            @SerializedName("applications")
            @Expose
            private String applications;
            @SerializedName("remark")
            @Expose
            private String remark;
            @SerializedName("status")
            @Expose
            private String status;
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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public Integer getPosition() {
                return position;
            }

            public void setPosition(Integer position) {
                this.position = position;
            }

            public String getTextRequired() {
                return textRequired;
            }

            public void setTextRequired(String textRequired) {
                this.textRequired = textRequired;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getApplications() {
                return applications;
            }

            public void setApplications(String applications) {
                this.applications = applications;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
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