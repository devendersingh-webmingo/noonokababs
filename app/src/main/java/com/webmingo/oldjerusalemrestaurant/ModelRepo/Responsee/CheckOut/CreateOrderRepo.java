package com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateOrderRepo {



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

        @SerializedName("order_details")
        @Expose
        private OrderDetails orderDetails;

        public OrderDetails getOrderDetails() {
            return orderDetails;
        }

        public void setOrderDetails(OrderDetails orderDetails) {
            this.orderDetails = orderDetails;
        }


        public class OrderDetails {
            @Override
            public String toString() {
                return "OrderDetails{" +
                        "orderId='" + orderId + '\'' +
                        ", invoiceId='" + invoiceId + '\'' +
                        ", branchId=" + branchId +
                        ", userId=" + userId +
                        ", couponId=" + couponId +
                        ", name='" + name + '\'' +
                        ", email='" + email + '\'' +
                        ", mobileNumber='" + mobileNumber + '\'' +
                        ", countryId=" + countryId +
                        ", stateId=" + stateId +
                        ", cityId=" + cityId +
                        ", address='" + address + '\'' +
                        ", pincode='" + pincode + '\'' +
                        ", billingCountryId=" + billingCountryId +
                        ", billingStateId=" + billingStateId +
                        ", billingCityId=" + billingCityId +
                        ", billingAddress=" + billingAddress +
                        ", billingPincode=" + billingPincode +
                        ", billingLandmark=" + billingLandmark +
                        ", totalAmount=" + totalAmount +
                        ", offerAmount=" + offerAmount +
                        ", discount=" + discount +
                        ", taxAmount='" + taxAmount + '\'' +
                        ", taxPercent='" + taxPercent + '\'' +
                        ", discountAmount=" + discountAmount +
                        ", paymentMethod='" + paymentMethod + '\'' +
                        ", deliveryType='" + deliveryType + '\'' +
                        ", paymentStatus='" + paymentStatus + '\'' +
                        ", couponDiscount=" + couponDiscount +
                        ", totalDiscountAmount=" + totalDiscountAmount +
                        ", tipPercent=" + tipPercent +
                        ", tipAmount=" + tipAmount +
                        ", orderDate='" + orderDate + '\'' +
                        ", orderTime='" + orderTime + '\'' +
                        ", createdByDevice='" + createdByDevice + '\'' +
                        ", updatedAt='" + updatedAt + '\'' +
                        ", createdAt='" + createdAt + '\'' +
                        ", id=" + id +
                        ", orderDatetime='" + orderDatetime + '\'' +
                        ", orderFoodDetail=" + orderFoodDetail +
                        ", rated='" + rated + '\'' +
                        ", pAmountSummery=" + pAmountSummery +
                        '}';
            }

            @SerializedName("order_id")
            @Expose
            private String orderId;
            @SerializedName("invoice_id")
            @Expose
            private String invoiceId;
            @SerializedName("branch_id")
            @Expose
            private Integer branchId;
            @SerializedName("user_id")
            @Expose
            private Integer userId;
            @SerializedName("coupon_id")
            @Expose
            private String couponId;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("email")
            @Expose
            private String email;
            @SerializedName("mobile_number")
            @Expose
            private String mobileNumber;
            @SerializedName("country_id")
            @Expose
            private Integer countryId;
            @SerializedName("state_id")
            @Expose
            private Integer stateId;
            @SerializedName("city_id")
            @Expose
            private Integer cityId;
            @SerializedName("address")
            @Expose
            private String address;
            @SerializedName("pincode")
            @Expose
            private String pincode;
            @SerializedName("billing_country_id")
            @Expose
            private String billingCountryId;
            @SerializedName("billing_state_id")
            @Expose
            private String billingStateId;
            @SerializedName("billing_city_id")
            @Expose
            private String billingCityId;
            @SerializedName("billing_address")
            @Expose
            private String billingAddress;
            @SerializedName("billing_pincode")
            @Expose
            private String billingPincode;
            @SerializedName("billing_landmark")
            @Expose
            private String billingLandmark;
            @SerializedName("total_amount")
            @Expose
            private double totalAmount;
            @SerializedName("offer_amount")
            @Expose
            private double offerAmount;
            @SerializedName("discount")
            @Expose
            private String discount;
            @SerializedName("tax_amount")
            @Expose
            private String taxAmount;
            @SerializedName("tax_percent")
            @Expose
            private String taxPercent;
            @SerializedName("discount_amount")
            @Expose
            private String discountAmount;
            @SerializedName("payment_method")
            @Expose
            private String paymentMethod;
            @SerializedName("delivery_type")
            @Expose
            private String deliveryType;
            @SerializedName("payment_status")
            @Expose
            private String paymentStatus;
            @SerializedName("coupon_discount")
            @Expose
            private Integer couponDiscount;
            @SerializedName("total_discount_amount")
            @Expose
            private Integer totalDiscountAmount;
            @SerializedName("tip_percent")
            @Expose
            private double tipPercent;
            @SerializedName("tip_amount")
            @Expose
            private String tipAmount;
            @SerializedName("order_date")
            @Expose
            private String orderDate;
            @SerializedName("order_time")
            @Expose
            private String orderTime;
            @SerializedName("created_by_device")
            @Expose
            private String createdByDevice;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
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

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getInvoiceId() {
                return invoiceId;
            }

            public void setInvoiceId(String invoiceId) {
                this.invoiceId = invoiceId;
            }

            public Integer getBranchId() {
                return branchId;
            }

            public void setBranchId(Integer branchId) {
                this.branchId = branchId;
            }

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            public String getCouponId() {
                return couponId;
            }

            public void setCouponId(String couponId) {
                this.couponId = couponId;
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

            public Integer getCountryId() {
                return countryId;
            }

            public void setCountryId(Integer countryId) {
                this.countryId = countryId;
            }

            public Integer getStateId() {
                return stateId;
            }

            public void setStateId(Integer stateId) {
                this.stateId = stateId;
            }

            public Integer getCityId() {
                return cityId;
            }

            public void setCityId(Integer cityId) {
                this.cityId = cityId;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getPincode() {
                return pincode;
            }

            public void setPincode(String pincode) {
                this.pincode = pincode;
            }

            public String getBillingCountryId() {
                return billingCountryId;
            }

            public void setBillingCountryId(String billingCountryId) {
                this.billingCountryId = billingCountryId;
            }

            public String getBillingStateId() {
                return billingStateId;
            }

            public void setBillingStateId(String billingStateId) {
                this.billingStateId = billingStateId;
            }

            public String getBillingCityId() {
                return billingCityId;
            }

            public void setBillingCityId(String billingCityId) {
                this.billingCityId = billingCityId;
            }

            public String getBillingAddress() {
                return billingAddress;
            }

            public void setBillingAddress(String billingAddress) {
                this.billingAddress = billingAddress;
            }

            public String getBillingPincode() {
                return billingPincode;
            }

            public void setBillingPincode(String billingPincode) {
                this.billingPincode = billingPincode;
            }

            public String getBillingLandmark() {
                return billingLandmark;
            }

            public void setBillingLandmark(String billingLandmark) {
                this.billingLandmark = billingLandmark;
            }

            public double getTotalAmount() {
                return totalAmount;
            }

            public void setTotalAmount(double totalAmount) {
                this.totalAmount = totalAmount;
            }

            public double getOfferAmount() {
                return offerAmount;
            }

            public void setOfferAmount(double offerAmount) {
                this.offerAmount = offerAmount;
            }

            public String getDiscount() {
                return discount;
            }

            public void setDiscount(String discount) {
                this.discount = discount;
            }

            public String getTaxAmount() {
                return taxAmount;
            }

            public void setTaxAmount(String taxAmount) {
                this.taxAmount = taxAmount;
            }

            public String getTaxPercent() {
                return taxPercent;
            }

            public void setTaxPercent(String taxPercent) {
                this.taxPercent = taxPercent;
            }

            public String getDiscountAmount() {
                return discountAmount;
            }

            public void setDiscountAmount(String discountAmount) {
                this.discountAmount = discountAmount;
            }

            public String getPaymentMethod() {
                return paymentMethod;
            }

            public void setPaymentMethod(String paymentMethod) {
                this.paymentMethod = paymentMethod;
            }

            public String getDeliveryType() {
                return deliveryType;
            }

            public void setDeliveryType(String deliveryType) {
                this.deliveryType = deliveryType;
            }

            public String getPaymentStatus() {
                return paymentStatus;
            }

            public void setPaymentStatus(String paymentStatus) {
                this.paymentStatus = paymentStatus;
            }

            public Integer getCouponDiscount() {
                return couponDiscount;
            }

            public void setCouponDiscount(Integer couponDiscount) {
                this.couponDiscount = couponDiscount;
            }

            public Integer getTotalDiscountAmount() {
                return totalDiscountAmount;
            }

            public void setTotalDiscountAmount(Integer totalDiscountAmount) {
                this.totalDiscountAmount = totalDiscountAmount;
            }

            public double getTipPercent() {
                return tipPercent;
            }

            public void setTipPercent(double tipPercent) {
                this.tipPercent = tipPercent;
            }

            public String getTipAmount() {
                return tipAmount;
            }

            public void setTipAmount(String tipAmount) {
                this.tipAmount = tipAmount;
            }

            public String getOrderDate() {
                return orderDate;
            }

            public void setOrderDate(String orderDate) {
                this.orderDate = orderDate;
            }

            public String getOrderTime() {
                return orderTime;
            }

            public void setOrderTime(String orderTime) {
                this.orderTime = orderTime;
            }

            public String getCreatedByDevice() {
                return createdByDevice;
            }

            public void setCreatedByDevice(String createdByDevice) {
                this.createdByDevice = createdByDevice;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

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
                @SerializedName("addons")
                @Expose
                private List<Addon> addons = null;

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

                public List<Addon> getAddons() {
                    return addons;
                }

                public void setAddons(List<Addon> addons) {
                    this.addons = addons;
                }

                public class Addon {

                    @SerializedName("id")
                    @Expose
                    private Integer id;
                    @SerializedName("quantity")
                    @Expose
                    private Integer quantity;
                    @SerializedName("price")
                    @Expose
                    private String price;
                    @SerializedName("name")
                    @Expose
                    private String name;
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

                }

                public class Ingredient {

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
                private String pSubTotalAmount;
                @SerializedName("p_total_discount_amount")
                @Expose
                private Integer pTotalDiscountAmount;
                @SerializedName("p_tax_amount")
                @Expose
                private String pTaxAmount;
                @SerializedName("p_tip_amount_amount")
                @Expose
                private String pTipAmountAmount;
                @SerializedName("p_billing_amount")
                @Expose
                private String pBillingAmount;

                public String getpSubTotalAmount() {
                    return pSubTotalAmount;
                }

                public void setpSubTotalAmount(String pSubTotalAmount) {
                    this.pSubTotalAmount = pSubTotalAmount;
                }

                public Integer getpTotalDiscountAmount() {
                    return pTotalDiscountAmount;
                }

                public void setpTotalDiscountAmount(Integer pTotalDiscountAmount) {
                    this.pTotalDiscountAmount = pTotalDiscountAmount;
                }

                public String getpTaxAmount() {
                    return pTaxAmount;
                }

                public void setpTaxAmount(String pTaxAmount) {
                    this.pTaxAmount = pTaxAmount;
                }

                public String getpTipAmountAmount() {
                    return pTipAmountAmount;
                }

                public void setpTipAmountAmount(String pTipAmountAmount) {
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
