package com.webmingo.noonokababs.ModelRepo.Responsee.MediaRespo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GuestReviewRepo {



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
        @SerializedName("testimonials")
        @Expose
        private List<Testimonial> testimonials = null;
        @SerializedName("testimonial_setting")
        @Expose
        private TestimonialSetting testimonialSetting;

        public String getImageBaseUrl() {
            return imageBaseUrl;
        }

        public void setImageBaseUrl(String imageBaseUrl) {
            this.imageBaseUrl = imageBaseUrl;
        }

        public List<Testimonial> getTestimonials() {
            return testimonials;
        }

        public void setTestimonials(List<Testimonial> testimonials) {
            this.testimonials = testimonials;
        }

        public TestimonialSetting getTestimonialSetting() {
            return testimonialSetting;
        }

        public void setTestimonialSetting(TestimonialSetting testimonialSetting) {
            this.testimonialSetting = testimonialSetting;
        }


        public class Testimonial {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("user_id")
            @Expose
            private Integer userId;
            @SerializedName("image")
            @Expose
            private String image;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("email")
            @Expose
            private String email;
            @SerializedName("mobile_number")
            @Expose
            private String mobileNumber;
            @SerializedName("applications")
            @Expose
            private String applications;
            @SerializedName("feedback")
            @Expose
            private String feedback;
            @SerializedName("approve_status")
            @Expose
            private String approveStatus;
            @SerializedName("added_by")
            @Expose
            private String addedBy;
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

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
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

            public String getApplications() {
                return applications;
            }

            public void setApplications(String applications) {
                this.applications = applications;
            }

            public String getFeedback() {
                return feedback;
            }

            public void setFeedback(String feedback) {
                this.feedback = feedback;
            }

            public String getApproveStatus() {
                return approveStatus;
            }

            public void setApproveStatus(String approveStatus) {
                this.approveStatus = approveStatus;
            }

            public String getAddedBy() {
                return addedBy;
            }

            public void setAddedBy(String addedBy) {
                this.addedBy = addedBy;
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
        public class TestimonialSetting {

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
            @SerializedName("image")
            @Expose
            private String image;
            @SerializedName("image_two")
            @Expose
            private String imageTwo;
            @SerializedName("ids")
            @Expose
            private Object ids;
            @SerializedName("description")
            @Expose
            private String description;
            @SerializedName("pick_up")
            @Expose
            private String pickUp;
            @SerializedName("home_delivery")
            @Expose
            private String homeDelivery;
            @SerializedName("open_time")
            @Expose
            private Object openTime;
            @SerializedName("close_time")
            @Expose
            private Object closeTime;
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

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getImageTwo() {
                return imageTwo;
            }

            public void setImageTwo(String imageTwo) {
                this.imageTwo = imageTwo;
            }

            public Object getIds() {
                return ids;
            }

            public void setIds(Object ids) {
                this.ids = ids;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getPickUp() {
                return pickUp;
            }

            public void setPickUp(String pickUp) {
                this.pickUp = pickUp;
            }

            public String getHomeDelivery() {
                return homeDelivery;
            }

            public void setHomeDelivery(String homeDelivery) {
                this.homeDelivery = homeDelivery;
            }

            public Object getOpenTime() {
                return openTime;
            }

            public void setOpenTime(Object openTime) {
                this.openTime = openTime;
            }

            public Object getCloseTime() {
                return closeTime;
            }

            public void setCloseTime(Object closeTime) {
                this.closeTime = closeTime;
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
