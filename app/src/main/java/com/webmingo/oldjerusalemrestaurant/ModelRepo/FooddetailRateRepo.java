package com.webmingo.oldjerusalemrestaurant.ModelRepo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FooddetailRateRepo {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("code")
    @Expose
    private Integer code;
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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
        @SerializedName("already_rated")
        @Expose
        private String alreadyRated;
        @SerializedName("order_info")
        @Expose
        private OrderInfo orderInfo;

        public String getImageBaseUrl() {
            return imageBaseUrl;
        }

        public void setImageBaseUrl(String imageBaseUrl) {
            this.imageBaseUrl = imageBaseUrl;
        }

        public String getAlreadyRated() {
            return alreadyRated;
        }

        public void setAlreadyRated(String alreadyRated) {
            this.alreadyRated = alreadyRated;
        }

        public OrderInfo getOrderInfo() {
            return orderInfo;
        }

        public void setOrderInfo(OrderInfo orderInfo) {
            this.orderInfo = orderInfo;
        }


        public class OrderInfo {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("order_datetime")
            @Expose
            private String orderDatetime;
            @SerializedName("order_food_detail")
            @Expose
            private List<OrderFoodDetail> orderFoodDetail = null;
            @SerializedName("rated")
            @Expose
            private String rated;
            @SerializedName("p_amount_summery")
            @Expose
            private PAmountSummery pAmountSummery;
            @SerializedName("delivery_datetime")
            @Expose
            private String deliveryDatetime;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }


            public String getOrderDatetime() {
                return orderDatetime;
            }

            public void setOrderDatetime(String orderDatetime) {
                this.orderDatetime = orderDatetime;
            }

            public List<OrderFoodDetail> getOrderFoodDetail() {
                return orderFoodDetail;
            }

            public void setOrderFoodDetail(List<OrderFoodDetail> orderFoodDetail) {
                this.orderFoodDetail = orderFoodDetail;
            }

            public String getRated() {
                return rated;
            }

            public void setRated(String rated) {
                this.rated = rated;
            }

            public PAmountSummery getpAmountSummery() {
                return pAmountSummery;
            }

            public void setpAmountSummery(PAmountSummery pAmountSummery) {
                this.pAmountSummery = pAmountSummery;
            }

            public String getDeliveryDatetime() {
                return deliveryDatetime;
            }

            public void setDeliveryDatetime(String deliveryDatetime) {
                this.deliveryDatetime = deliveryDatetime;
            }


            /*public class OrderFoodDetail {

                @SerializedName("food_id")
                @Expose
                private Integer foodId;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("image")
                @Expose
                private String image;
                @SerializedName("remark")
                @Expose
                private String remark;
                @SerializedName("amount")
                @Expose
                private String amount;
                @SerializedName("quantity")
                @Expose
                private Integer quantity;
                @SerializedName("cooking_level")
                @Expose
                private Object cookingLevel;
                @SerializedName("ingredients")
                @Expose
                private List<Ingredient> ingredients = null;
                @SerializedName("addons")
                @Expose
                private List<Object> addons = null;

                public Integer getFoodId() {
                    return foodId;
                }

                public void setFoodId(Integer foodId) {
                    this.foodId = foodId;
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

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public String getAmount() {
                    return amount;
                }

                public void setAmount(String amount) {
                    this.amount = amount;
                }

                public Integer getQuantity() {
                    return quantity;
                }

                public void setQuantity(Integer quantity) {
                    this.quantity = quantity;
                }

                public Object getCookingLevel() {
                    return cookingLevel;
                }

                public void setCookingLevel(Object cookingLevel) {
                    this.cookingLevel = cookingLevel;
                }

                public List<Ingredient> getIngredients() {
                    return ingredients;
                }

                public void setIngredients(List<Ingredient> ingredients) {
                    this.ingredients = ingredients;
                }

                public List<Object> getAddons() {
                    return addons;
                }

                public void setAddons(List<Object> addons) {
                    this.addons = addons;
                }

                public class Ingredient {

                    @SerializedName("id")
                    @Expose
                    private Integer id;
                    @SerializedName("food_id")
                    @Expose
                    private Object foodId;
                    @SerializedName("type")
                    @Expose
                    private String type;
                    @SerializedName("name")
                    @Expose
                    private String name;
                    @SerializedName("price")
                    @Expose
                    private String price;
                    @SerializedName("status")
                    @Expose
                    private String status;
                    @SerializedName("remark")
                    @Expose
                    private Object remark;
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

                    public Object getFoodId() {
                        return foodId;
                    }

                    public void setFoodId(Object foodId) {
                        this.foodId = foodId;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getPrice() {
                        return price;
                    }

                    public void setPrice(String price) {
                        this.price = price;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public Object getRemark() {
                        return remark;
                    }

                    public void setRemark(Object remark) {
                        this.remark = remark;
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


            }*/

            public class OrderFoodDetail {

                @SerializedName("food_id")
                @Expose
                private Integer foodId;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("image")
                @Expose
                private String image;
                @SerializedName("remark")
                @Expose
                private String remark;
                @SerializedName("amount")
                @Expose
                private String amount;
                @SerializedName("quantity")
                @Expose
                private Integer quantity;
                @SerializedName("cooking_level")
                @Expose
                private Object cookingLevel;

                /*@SerializedName("ingredients")
                @Expose
                private List<Ingredient> ingredients = null;
                */
                @SerializedName("addons")
                @Expose
                private List<Object> addons = null;
                @SerializedName("rated")
                @Expose
                private String rated;
                @SerializedName("given_rate")
                @Expose
                private GivenRate givenRate;

                public Integer getFoodId() {
                    return foodId;
                }

                public void setFoodId(Integer foodId) {
                    this.foodId = foodId;
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

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public String getAmount() {
                    return amount;
                }

                public void setAmount(String amount) {
                    this.amount = amount;
                }

                public Integer getQuantity() {
                    return quantity;
                }

                public void setQuantity(Integer quantity) {
                    this.quantity = quantity;
                }

                public Object getCookingLevel() {
                    return cookingLevel;
                }

                public void setCookingLevel(Object cookingLevel) {
                    this.cookingLevel = cookingLevel;
                }



                public List<Object> getAddons() {
                    return addons;
                }

                public void setAddons(List<Object> addons) {
                    this.addons = addons;
                }

                public String getRated() {
                    return rated;
                }

                public void setRated(String rated) {
                    this.rated = rated;
                }

                public GivenRate getGivenRate() {
                    return givenRate;
                }

                public void setGivenRate(GivenRate givenRate) {
                    this.givenRate = givenRate;
                }
                public class GivenRate {

                    @SerializedName("id")
                    @Expose
                    private Integer id;
                    @SerializedName("order_id")
                    @Expose
                    private Integer orderId;
                    @SerializedName("user_id")
                    @Expose
                    private Integer userId;
                    @SerializedName("food_id")
                    @Expose
                    private Integer foodId;
                    @SerializedName("rating")
                    @Expose
                    private Integer rating;
                    @SerializedName("review")
                    @Expose
                    private String review;
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

                    public Integer getOrderId() {
                        return orderId;
                    }

                    public void setOrderId(Integer orderId) {
                        this.orderId = orderId;
                    }

                    public Integer getUserId() {
                        return userId;
                    }

                    public void setUserId(Integer userId) {
                        this.userId = userId;
                    }

                    public Integer getFoodId() {
                        return foodId;
                    }

                    public void setFoodId(Integer foodId) {
                        this.foodId = foodId;
                    }

                    public Integer getRating() {
                        return rating;
                    }

                    public void setRating(Integer rating) {
                        this.rating = rating;
                    }

                    public String getReview() {
                        return review;
                    }

                    public void setReview(String review) {
                        this.review = review;
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

            public class PAmountSummery {

                @SerializedName("p_sub_total_amount")
                @Expose
                private Integer pSubTotalAmount;
                @SerializedName("p_total_discount_amount")
                @Expose
                private Integer pTotalDiscountAmount;
                @SerializedName("p_tax_amount")
                @Expose
                private Integer pTaxAmount;
                @SerializedName("p_tip_amount_amount")
                @Expose
                private Integer pTipAmountAmount;
                @SerializedName("p_billing_amount")
                @Expose
                private Integer pBillingAmount;

                public Integer getpSubTotalAmount() {
                    return pSubTotalAmount;
                }

                public void setpSubTotalAmount(Integer pSubTotalAmount) {
                    this.pSubTotalAmount = pSubTotalAmount;
                }

                public Integer getpTotalDiscountAmount() {
                    return pTotalDiscountAmount;
                }

                public void setpTotalDiscountAmount(Integer pTotalDiscountAmount) {
                    this.pTotalDiscountAmount = pTotalDiscountAmount;
                }

                public Integer getpTaxAmount() {
                    return pTaxAmount;
                }

                public void setpTaxAmount(Integer pTaxAmount) {
                    this.pTaxAmount = pTaxAmount;
                }

                public Integer getpTipAmountAmount() {
                    return pTipAmountAmount;
                }

                public void setpTipAmountAmount(Integer pTipAmountAmount) {
                    this.pTipAmountAmount = pTipAmountAmount;
                }

                public Integer getpBillingAmount() {
                    return pBillingAmount;
                }

                public void setpBillingAmount(Integer pBillingAmount) {
                    this.pBillingAmount = pBillingAmount;
                }




            }

        }


    }


}
