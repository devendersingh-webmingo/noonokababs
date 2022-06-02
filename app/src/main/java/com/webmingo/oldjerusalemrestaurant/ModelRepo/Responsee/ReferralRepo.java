package com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReferralRepo {



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


        @Override
        public String toString() {
            return "Data{" +
                    "heading='" + heading + '\'' +
                    ", title='" + title + '\'' +
                    ", image='" + image + '\'' +
                    ", referralCode='" + referralCode + '\'' +
                    ", totalEarn=" + totalEarn +
                    ", howWork=" + howWork +
                    '}';
        }

        @SerializedName("heading")
        @Expose
        private String heading;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("referral_code")
        @Expose
        private String referralCode;
        @SerializedName("total_earn")
        @Expose
        private String  totalEarn;
        @SerializedName("how_work")
        @Expose
        private List<HowWork> howWork = null;

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

        public String getReferralCode() {
            return referralCode;
        }

        public void setReferralCode(String referralCode) {
            this.referralCode = referralCode;
        }

        public String getTotalEarn() {
            return totalEarn;
        }

        public void setTotalEarn(String totalEarn) {
            this.totalEarn = totalEarn;
        }

        public List<HowWork> getHowWork() {
            return howWork;
        }

        public void setHowWork(List<HowWork> howWork) {
            this.howWork = howWork;
        }



        public class HowWork {

            @SerializedName("id")
            @Expose
            private String id;
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
            private Object image;
            @SerializedName("image_two")
            @Expose
            private Object imageTwo;
            @SerializedName("ids")
            @Expose
            private Object ids;
            @SerializedName("description")
            @Expose
            private Object description;
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

            public String getId() {
                return id;
            }

            public void setId(String id) {
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

            public Object getImage() {
                return image;
            }

            public void setImage(Object image) {
                this.image = image;
            }

            public Object getImageTwo() {
                return imageTwo;
            }

            public void setImageTwo(Object imageTwo) {
                this.imageTwo = imageTwo;
            }

            public Object getIds() {
                return ids;
            }

            public void setIds(Object ids) {
                this.ids = ids;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
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
