package com.webmingo.noonokababs.ModelRepo.Orderhistory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllHistoryRepo {

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
        @SerializedName("orders")
        @Expose
        private List<Order> orders = null;

        public String getImageBaseUrl() {
            return imageBaseUrl;
        }

        public void setImageBaseUrl(String imageBaseUrl) {
            this.imageBaseUrl = imageBaseUrl;
        }

        public List<Order> getOrders() {
            return orders;
        }

        public void setOrders(List<Order> orders) {
            this.orders = orders;
        }

        public class Order {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("offer_amount")
            @Expose
            private Float offerAmount;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("order_id")
            @Expose
            private String orderId;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("order_datetime")
            @Expose
            private String orderDatetime;
            @SerializedName("order_food_detail")
            @Expose
            private List<OrderFoodDetail> orderFoodDetail = null;
            @SerializedName("rated")
            @Expose
            private String rated;


            @SerializedName("payment_status")
            @Expose
            private String payment_status;

            @SerializedName("payment_method")
            @Expose
            private String payment_method;

            public String getPayment_status() {
                return payment_status;
            }

            public void setPayment_status(String payment_status) {
                this.payment_status = payment_status;
            }

            public String getPayment_method() {
                return payment_method;
            }

            public void setPayment_method(String payment_method) {
                this.payment_method = payment_method;
            }

            @SerializedName("p_amount_summery")
            @Expose
            private PAmountSummery pAmountSummery;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }


            public Float getOfferAmount() {
                return offerAmount;
            }

            public void setOfferAmount(Float offerAmount) {
                this.offerAmount = offerAmount;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
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
                private String cookingLevel;
                @SerializedName("ingredients")
                @Expose
                private List<Ingredient> ingredients = null;

                /*
                @SerializedName("addons")
                @Expose
                private Addons addons;*/

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

                public String getCookingLevel() {
                    return cookingLevel;
                }

                public void setCookingLevel(String cookingLevel) {
                    this.cookingLevel = cookingLevel;
                }

                public List<Ingredient> getIngredients() {
                    return ingredients;
                }

                public void setIngredients(List<Ingredient> ingredients) {
                    this.ingredients = ingredients;
                }

                /* public Addons getAddons() {
                     return addons;
                 }

                 public void setAddons(Addons addons) {
                     this.addons = addons;
                 }
                 public class Addons {

                     @SerializedName("id")
                     @Expose
                     private Integer id;
                     @SerializedName("quantity")
                     @Expose
                     private Integer quantity;
                     @SerializedName("price")
                     @Expose
                     private String price;
                     @SerializedName("image")
                     @Expose
                     private String image;
                     @SerializedName("remark")
                     @Expose
                     private String remark;

                     public Integer getId() {
                         return id;
                     }

                     public void setId(Integer id) {
                         this.id = id;
                     }

                     public Integer getQuantity() {
                         return quantity;
                     }

                     public void setQuantity(Integer quantity) {
                         this.quantity = quantity;
                     }

                     public String getPrice() {
                         return price;
                     }

                     public void setPrice(String price) {
                         this.price = price;
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

                 }

           */      public class Ingredient {

                    @SerializedName("id")
                    @Expose
                    private Integer id;
                    @SerializedName("food_id")
                    @Expose
                    private String foodId;
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
                    private String remark;
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

                    public String getFoodId() {
                        return foodId;
                    }

                    public void setFoodId(String foodId) {
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

                    public String getRemark() {
                        return remark;
                    }

                    public void setRemark(String remark) {
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
                private String pBillingAmount;

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

                public String getpBillingAmount() {
                    return pBillingAmount;
                }

                public void setpBillingAmount(String pBillingAmount) {
                    this.pBillingAmount = pBillingAmount;
                }

            }
        }
    }

}