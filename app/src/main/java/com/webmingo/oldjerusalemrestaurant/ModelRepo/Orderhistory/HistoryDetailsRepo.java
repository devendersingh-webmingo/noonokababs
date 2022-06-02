package com.webmingo.oldjerusalemrestaurant.ModelRepo.Orderhistory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HistoryDetailsRepo {



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
        @SerializedName("order_detail")
        @Expose
        private OrderDetail orderDetail;

        public String getImageBaseUrl() {
            return imageBaseUrl;
        }

        public void setImageBaseUrl(String imageBaseUrl) {
            this.imageBaseUrl = imageBaseUrl;
        }

        public OrderDetail getOrderDetail() {
            return orderDetail;
        }

        public void setOrderDetail(OrderDetail orderDetail) {
            this.orderDetail = orderDetail;
        }



        public class OrderDetail {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("order_id")
            @Expose
            private String orderId;
            @SerializedName("invoice_id")
            @Expose
            private String invoiceId;
            @SerializedName("branch_id")
            @Expose
            private String branchId;
            @SerializedName("delivery_partner_id")
            @Expose
            private String deliveryPartnerId;
            @SerializedName("user_id")
            @Expose
            private String userId;
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
            private String countryId;
            @SerializedName("state_id")
            @Expose
            private String stateId;
            @SerializedName("city_id")
            @Expose
            private String cityId;
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
            @SerializedName("total_amount")
            @Expose
            private String totalAmount;
            @SerializedName("offer_amount")
            @Expose
            private String offerAmount;
            @SerializedName("discount")
            @Expose
            private String discount;
            @SerializedName("discount_amount")
            @Expose
            private String discountAmount;
            @SerializedName("coupon_discount")
            @Expose
            private String couponDiscount;
            @SerializedName("total_discount_amount")
            @Expose
            private String totalDiscountAmount;
            @SerializedName("tax_amount")
            @Expose
            private String taxAmount;
            @SerializedName("tax_percent")
            @Expose
            private String taxPercent;
            @SerializedName("payment_method")
            @Expose
            private String paymentMethod;
            @SerializedName("delivery_type")
            @Expose
            private String deliveryType;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("payment_status")
            @Expose
            private String paymentStatus;
            @SerializedName("delivery_time")
            @Expose
            private String deliveryTime;
            @SerializedName("device_info")
            @Expose
            private String deviceInfo;
            @SerializedName("remark_status")
            @Expose
            private String remarkStatus;
            @SerializedName("remark_payment_status")
            @Expose
            private String remarkPaymentStatus;



            @SerializedName("delivery_datetime")
            @Expose
            private String delivery_datetime;

            public String getDelivery_datetime() {
                return delivery_datetime;
            }

            public void setDelivery_datetime(String delivery_datetime) {
                this.delivery_datetime = delivery_datetime;
            }

            @SerializedName("tip_percent")
            @Expose
            private String tipPercent;


            @SerializedName("get_branch_info")
            @Expose
            private GetBranchInfo getBranchInfo;

            public GetBranchInfo getGetBranchInfo() {
                return getBranchInfo;
            }

            public void setGetBranchInfo(GetBranchInfo getBranchInfo) {
                this.getBranchInfo = getBranchInfo;
            }

            @SerializedName("tip_amount")
            @Expose
            private String tipAmount;
            @SerializedName("order_date")
            @Expose
            private String orderDate;
            @SerializedName("order_time")
            @Expose
            private String orderTime;
            @SerializedName("landmark")
            @Expose
            private String landmark;
            @SerializedName("billing_landmark")
            @Expose
            private String billingLandmark;
            @SerializedName("created_by_device")
            @Expose
            private String createdByDevice;
            @SerializedName("cancellation_reason")
            @Expose
            private String cancellationReason;
            @SerializedName("cancellation_reply")
            @Expose
            private String cancellationReply;
            @SerializedName("payment_screenshot")
            @Expose
            private String paymentScreenshot;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
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
            @SerializedName("get_country")
            @Expose
            private GetCountry getCountry;
            @SerializedName("get_state")
            @Expose
            private GetState getState;
            @SerializedName("get_city")
            @Expose
            private GetCity getCity;


            @SerializedName("get_delivery_boy")
            @Expose
            private GetDeliveryBoy getDeliveryBoy;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

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

            public String getBranchId() {
                return branchId;
            }

            public void setBranchId(String branchId) {
                this.branchId = branchId;
            }

            public String getDeliveryPartnerId() {
                return deliveryPartnerId;
            }

            public void setDeliveryPartnerId(String deliveryPartnerId) {
                this.deliveryPartnerId = deliveryPartnerId;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
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

            public String getCountryId() {
                return countryId;
            }

            public void setCountryId(String countryId) {
                this.countryId = countryId;
            }

            public String getStateId() {
                return stateId;
            }

            public void setStateId(String stateId) {
                this.stateId = stateId;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
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

            public String getTotalAmount() {
                return totalAmount;
            }

            public void setTotalAmount(String totalAmount) {
                this.totalAmount = totalAmount;
            }

            public String getOfferAmount() {
                return offerAmount;
            }

            public void setOfferAmount(String offerAmount) {
                this.offerAmount = offerAmount;
            }

            public String getDiscount() {
                return discount;
            }

            public void setDiscount(String discount) {
                this.discount = discount;
            }

            public String getDiscountAmount() {
                return discountAmount;
            }

            public void setDiscountAmount(String discountAmount) {
                this.discountAmount = discountAmount;
            }

            public String getCouponDiscount() {
                return couponDiscount;
            }

            public void setCouponDiscount(String couponDiscount) {
                this.couponDiscount = couponDiscount;
            }

            public String getTotalDiscountAmount() {
                return totalDiscountAmount;
            }

            public void setTotalDiscountAmount(String totalDiscountAmount) {
                this.totalDiscountAmount = totalDiscountAmount;
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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getPaymentStatus() {
                return paymentStatus;
            }

            public void setPaymentStatus(String paymentStatus) {
                this.paymentStatus = paymentStatus;
            }

            public String getDeliveryTime() {
                return deliveryTime;
            }

            public void setDeliveryTime(String deliveryTime) {
                this.deliveryTime = deliveryTime;
            }

            public String getDeviceInfo() {
                return deviceInfo;
            }

            public void setDeviceInfo(String deviceInfo) {
                this.deviceInfo = deviceInfo;
            }

            public String getRemarkStatus() {
                return remarkStatus;
            }

            public void setRemarkStatus(String remarkStatus) {
                this.remarkStatus = remarkStatus;
            }

            public String getRemarkPaymentStatus() {
                return remarkPaymentStatus;
            }

            public void setRemarkPaymentStatus(String remarkPaymentStatus) {
                this.remarkPaymentStatus = remarkPaymentStatus;
            }

            public String getTipPercent() {
                return tipPercent;
            }

            public void setTipPercent(String tipPercent) {
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

            public String getLandmark() {
                return landmark;
            }

            public void setLandmark(String landmark) {
                this.landmark = landmark;
            }

            public String getBillingLandmark() {
                return billingLandmark;
            }

            public void setBillingLandmark(String billingLandmark) {
                this.billingLandmark = billingLandmark;
            }

            public String getCreatedByDevice() {
                return createdByDevice;
            }

            public void setCreatedByDevice(String createdByDevice) {
                this.createdByDevice = createdByDevice;
            }

            public String getCancellationReason() {
                return cancellationReason;
            }

            public void setCancellationReason(String cancellationReason) {
                this.cancellationReason = cancellationReason;
            }

            public String getCancellationReply() {
                return cancellationReply;
            }

            public void setCancellationReply(String cancellationReply) {
                this.cancellationReply = cancellationReply;
            }

            public String getPaymentScreenshot() {
                return paymentScreenshot;
            }

            public void setPaymentScreenshot(String paymentScreenshot) {
                this.paymentScreenshot = paymentScreenshot;
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

            public GetCountry getGetCountry() {
                return getCountry;
            }

            public void setGetCountry(GetCountry getCountry) {
                this.getCountry = getCountry;
            }

            public GetState getGetState() {
                return getState;
            }

            public void setGetState(GetState getState) {
                this.getState = getState;
            }

            public GetCity getGetCity() {
                return getCity;
            }

            public void setGetCity(GetCity getCity) {
                this.getCity = getCity;
            }




            public GetDeliveryBoy getGetDeliveryBoy() {
                return getDeliveryBoy;
            }

            public void setGetDeliveryBoy(GetDeliveryBoy getDeliveryBoy) {
                this.getDeliveryBoy = getDeliveryBoy;
            }

            public class PAmountSummery {

                @SerializedName("p_sub_total_amount")
                @Expose
                private String pSubTotalAmount;
                @SerializedName("p_total_discount_amount")
                @Expose
                private String pTotalDiscountAmount;
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

                public String getpTotalDiscountAmount() {
                    return pTotalDiscountAmount;
                }

                public void setpTotalDiscountAmount(String pTotalDiscountAmount) {
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

            public class GetCountry {

                @SerializedName("id")
                @Expose
                private String id;
                @SerializedName("code")
                @Expose
                private String code;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("phonecode")
                @Expose
                private String phonecode;
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

                public String getPhonecode() {
                    return phonecode;
                }

                public void setPhonecode(String phonecode) {
                    this.phonecode = phonecode;
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
               /* public GetBranchInfo getGetBranchInfo() {
                    return getBranchInfo;
                }*/

               /* public void setGetBranchInfo(GetBranchInfo getBranchInfo) {
                    this.getBranchInfo = getBranchInfo;
                }*/
            }


            public class GetState {

                @SerializedName("id")
                @Expose
                private String id;
                @SerializedName("country_id")
                @Expose
                private String countryId;
                @SerializedName("name")
                @Expose
                private String name;
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

                public String getCountryId() {
                    return countryId;
                }

                public void setCountryId(String countryId) {
                    this.countryId = countryId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
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
            public class GetCity {

                @SerializedName("id")
                @Expose
                private String id;
                @SerializedName("state_id")
                @Expose
                private String stateId;
                @SerializedName("name")
                @Expose
                private String name;
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

                public String getStateId() {
                    return stateId;
                }

                public void setStateId(String stateId) {
                    this.stateId = stateId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
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
            public class GetDeliveryBoy {

                @SerializedName("id")
                @Expose
                private String id;
                @SerializedName("username")
                @Expose
                private String username;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("email")
                @Expose
                private String email;
                @SerializedName("mobile_number")
                @Expose
                private String mobileNumber;
                @SerializedName("state_id")
                @Expose
                private String stateId;
                @SerializedName("city_id")
                @Expose
                private String cityId;
                @SerializedName("address")
                @Expose
                private String address;
                @SerializedName("get_state")
                @Expose
                private GetState__1 getState;
                @SerializedName("get_city")
                @Expose
                private GetCity__1 getCity;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
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

                public String getStateId() {
                    return stateId;
                }

                public void setStateId(String stateId) {
                    this.stateId = stateId;
                }

                public String getCityId() {
                    return cityId;
                }

                public void setCityId(String cityId) {
                    this.cityId = cityId;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public GetState__1 getGetState() {
                    return getState;
                }

                public void setGetState(GetState__1 getState) {
                    this.getState = getState;
                }

                public GetCity__1 getGetCity() {
                    return getCity;
                }

                public void setGetCity(GetCity__1 getCity) {
                    this.getCity = getCity;
                }



                public class GetCity__1 {

                    @SerializedName("id")
                    @Expose
                    private String id;
                    @SerializedName("state_id")
                    @Expose
                    private String stateId;
                    @SerializedName("name")
                    @Expose
                    private String name;
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

                    public String getStateId() {
                        return stateId;
                    }

                    public void setStateId(String stateId) {
                        this.stateId = stateId;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
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
                public class GetState__1 {

                    @SerializedName("id")
                    @Expose
                    private String id;
                    @SerializedName("country_id")
                    @Expose
                    private String countryId;
                    @SerializedName("name")
                    @Expose
                    private String name;
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

                    public String getCountryId() {
                        return countryId;
                    }

                    public void setCountryId(String countryId) {
                        this.countryId = countryId;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
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

            public class OrderFoodDetail {

                @SerializedName("food_id")
                @Expose
                private String foodId;
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
                private String quantity;
                @SerializedName("cooking_level")
                @Expose
                private String cookingLevel;

                @SerializedName("ingredients")
                @Expose
                private List<Ingredient> ingredients = null;



                @SerializedName("addons")
                @Expose
                private List<Addon> addons = null;

                public List<Addon> getAddons() {
                    return addons;
                }

                public void setAddons(List<Addon> addons) {
                    this.addons = addons;
                }

                public String getFoodId() {
                    return foodId;
                }

                public void setFoodId(String foodId) {
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

                public String getQuantity() {
                    return quantity;
                }

                public void setQuantity(String quantity) {
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
                    private String id;
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

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
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
            public class GetBranchInfo {

                @SerializedName("id")
                @Expose
                private Integer id;
                @SerializedName("username")
                @Expose
                private String username;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("email")
                @Expose
                private String email;
                @SerializedName("mobile_number")
                @Expose
                private String mobileNumber;
                @SerializedName("state_id")
                @Expose
                private Integer stateId;
                @SerializedName("city_id")
                @Expose
                private Integer cityId;
                @SerializedName("address")
                @Expose
                private String address;
                @SerializedName("get_state")
                @Expose
                private GetState__1 getState;
                @SerializedName("get_city")
                @Expose
                private GetCity__1 getCity;

                public Integer getId() {
                    return id;
                }

                public void setId(Integer id) {
                    this.id = id;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
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

                public GetState__1 getGetState() {
                    return getState;
                }

                public void setGetState(GetState__1 getState) {
                    this.getState = getState;
                }

                public GetCity__1 getGetCity() {
                    return getCity;
                }

                public void setGetCity(GetCity__1 getCity) {
                    this.getCity = getCity;
                }

                public class GetState__1 {

                    @SerializedName("id")
                    @Expose
                    private Integer id;
                    @SerializedName("country_id")
                    @Expose
                    private Integer countryId;
                    @SerializedName("name")
                    @Expose
                    private String name;
                    @SerializedName("created_at")
                    @Expose
                    private Object createdAt;
                    @SerializedName("updated_at")
                    @Expose
                    private Object updatedAt;

                    public Integer getId() {
                        return id;
                    }

                    public void setId(Integer id) {
                        this.id = id;
                    }

                    public Integer getCountryId() {
                        return countryId;
                    }

                    public void setCountryId(Integer countryId) {
                        this.countryId = countryId;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public Object getCreatedAt() {
                        return createdAt;
                    }

                    public void setCreatedAt(Object createdAt) {
                        this.createdAt = createdAt;
                    }

                    public Object getUpdatedAt() {
                        return updatedAt;
                    }

                    public void setUpdatedAt(Object updatedAt) {
                        this.updatedAt = updatedAt;
                    }

                }

                public class GetCity__1 {

                    @SerializedName("id")
                    @Expose
                    private Integer id;
                    @SerializedName("state_id")
                    @Expose
                    private Integer stateId;
                    @SerializedName("name")
                    @Expose
                    private String name;
                    @SerializedName("created_at")
                    @Expose
                    private Object createdAt;
                    @SerializedName("updated_at")
                    @Expose
                    private Object updatedAt;

                    public Integer getId() {
                        return id;
                    }

                    public void setId(Integer id) {
                        this.id = id;
                    }

                    public Integer getStateId() {
                        return stateId;
                    }

                    public void setStateId(Integer stateId) {
                        this.stateId = stateId;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public Object getCreatedAt() {
                        return createdAt;
                    }

                    public void setCreatedAt(Object createdAt) {
                        this.createdAt = createdAt;
                    }

                    public Object getUpdatedAt() {
                        return updatedAt;
                    }

                    public void setUpdatedAt(Object updatedAt) {
                        this.updatedAt = updatedAt;
                    }

                }
            }


        }

    }



}
