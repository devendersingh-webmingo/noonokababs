package com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.FoodFavourit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodDetailsOfferRepo {


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
        @SerializedName("coupons")
        @Expose
        private List<Coupon> coupons = null;

        public String getImageBaseUrl() {
            return imageBaseUrl;
        }

        public void setImageBaseUrl(String imageBaseUrl) {
            this.imageBaseUrl = imageBaseUrl;
        }

        public List<Coupon> getCoupons() {
            return coupons;
        }

        public void setCoupons(List<Coupon> coupons) {
            this.coupons = coupons;
        }

        public class Coupon {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("code")
            @Expose
            private String code;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("category")
            @Expose
            private String category;
            @SerializedName("sub_category")
            @Expose
            private Object subCategory;
            @SerializedName("food_items")
            @Expose
            private String foodItems;
            @SerializedName("discount")
            @Expose
            private String discount;
            @SerializedName("max_discount")
            @Expose
            private String maxDiscount;
            @SerializedName("min_order")
            @Expose
            private String minOrder;
            @SerializedName("start_date")
            @Expose
            private String startDate;
            @SerializedName("end_date")
            @Expose
            private String endDate;
            @SerializedName("apply_for")
            @Expose
            private String applyFor;
            @SerializedName("usages")
            @Expose
            private String usages;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("image")
            @Expose
            private String image;
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

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public Object getSubCategory() {
                return subCategory;
            }

            public void setSubCategory(Object subCategory) {
                this.subCategory = subCategory;
            }

            public String getFoodItems() {
                return foodItems;
            }

            public void setFoodItems(String foodItems) {
                this.foodItems = foodItems;
            }

            public String getDiscount() {
                return discount;
            }

            public void setDiscount(String discount) {
                this.discount = discount;
            }

            public String getMaxDiscount() {
                return maxDiscount;
            }

            public void setMaxDiscount(String maxDiscount) {
                this.maxDiscount = maxDiscount;
            }

            public String getMinOrder() {
                return minOrder;
            }

            public void setMinOrder(String minOrder) {
                this.minOrder = minOrder;
            }

            public String getStartDate() {
                return startDate;
            }

            public void setStartDate(String startDate) {
                this.startDate = startDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public String getApplyFor() {
                return applyFor;
            }

            public void setApplyFor(String applyFor) {
                this.applyFor = applyFor;
            }

            public String getUsages() {
                return usages;
            }

            public void setUsages(String usages) {
                this.usages = usages;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
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
