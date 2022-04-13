package com.webmingo.noonokababs.ModelRepo.cart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CouponRepo {


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

        @SerializedName("offered_amount")
        @Expose
        private String offeredAmount;
        @SerializedName("discount_amount")
        @Expose
        private String discountAmount;
        @SerializedName("discount_percent")
        @Expose
        private Integer discountPercent;
        @SerializedName("coupon_details")
        @Expose
        private CouponDetails couponDetails;

        public String getOfferedAmount() {
            return offeredAmount;
        }

        public void setOfferedAmount(String offeredAmount) {
            this.offeredAmount = offeredAmount;
        }

        public String getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(String discountAmount) {
            this.discountAmount = discountAmount;
        }

        public Integer getDiscountPercent() {
            return discountPercent;
        }

        public void setDiscountPercent(Integer discountPercent) {
            this.discountPercent = discountPercent;
        }

        public CouponDetails getCouponDetails() {
            return couponDetails;
        }

        public void setCouponDetails(CouponDetails couponDetails) {
            this.couponDetails = couponDetails;
        }



        public class CouponDetails {

            @SerializedName("id")
            @Expose
            private Integer id;
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
            private Integer discount;
            @SerializedName("max_discount")
            @Expose
            private Float maxDiscount;
            @SerializedName("min_order")
            @Expose
            private Float minOrder;
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
            private Integer usages;
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

            public Integer getDiscount() {
                return discount;
            }

            public void setDiscount(Integer discount) {
                this.discount = discount;
            }

            public Float getMaxDiscount() {
                return maxDiscount;
            }

            public void setMaxDiscount(Float maxDiscount) {
                this.maxDiscount = maxDiscount;
            }

            public Float getMinOrder() {
                return minOrder;
            }

            public void setMinOrder(Float minOrder) {
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

            public Integer getUsages() {
                return usages;
            }

            public void setUsages(Integer usages) {
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

        @Override
        public String toString() {
            return "Data{" +
                    "offeredAmount='" + offeredAmount + '\'' +
                    ", discountAmount='" + discountAmount + '\'' +
                    ", discountPercent=" + discountPercent +
                    ", couponDetails=" + couponDetails +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CouponRepo{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
