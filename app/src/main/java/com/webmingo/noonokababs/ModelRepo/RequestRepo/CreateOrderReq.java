package com.webmingo.noonokababs.ModelRepo.RequestRepo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateOrderReq {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("mobile_number")
    @Expose
    public String mobileNumber;
    @SerializedName("branch")
    @Expose
    public String branch;
    @SerializedName("coupon_id")
    @Expose
    public String couponId;
    @SerializedName("coupon_discount")
    @Expose
    public String couponDiscount;
    @SerializedName("total_price")
    @Expose
    public String totalPrice;
    @SerializedName("offer_price")
    @Expose
    public String offerPrice;
    @SerializedName("discount")
    @Expose
    public String discount;
    @SerializedName("tax_amount")
    @Expose
    public String taxAmount;
    @SerializedName("tax_percent")
    @Expose
    public String taxPercent;
    @SerializedName("discount_amount")
    @Expose
    public String discountAmount;
    @SerializedName("payment_mode")
    @Expose
    public String paymentMode;
    @SerializedName("delivery_type")
    @Expose
    public String deliveryType;
    @SerializedName("payment_status")
    @Expose
    public String paymentStatus;
    @SerializedName("total_discount_amount")
    @Expose
    public String totalDiscountAmount;
    @SerializedName("tip_percent")
    @Expose
    public String tipPercent;
    @SerializedName("tip_amount")
    @Expose
    public String tipAmount;


    @SerializedName("gateway_charge_id")
    @Expose
    public String gateway_charge_id;
    @SerializedName("gateway_payment_id")
    @Expose
    public String gateway_payment_id;
    @SerializedName("gateway_receipt")
    @Expose
    public String gateway_receipt;
    @SerializedName("gateway_currency")
    @Expose
    public String gateway_currency;
    @SerializedName("gateway_description")
    @Expose
    public String gateway_description;
    @SerializedName("gateway_payment_method")
    @Expose
    public String gateway_payment_method;




    @SerializedName("delivery_date")
    @Expose
    public String deliveryDate;
    @SerializedName("delivery_time")
    @Expose
    public String deliveryTime;
    @SerializedName("created_by_device")
    @Expose
    public String createdByDevice;
    @SerializedName("shipping_address_id")
    @Expose
    public String shippingAddressId;
    @SerializedName("billing_address_id")
    @Expose
    public String billingAddressId;
    @SerializedName("same_as_shipping")
    @Expose
    public String sameAsShipping;
    @SerializedName("same_as_billing")
    @Expose
    public String sameAsBilling;
    @SerializedName("cart")
    @Expose
    public List<ViewCartRequest.Cart> cart = null;


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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(String couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(String offerPrice) {
        this.offerPrice = offerPrice;
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

    public CreateOrderReq() {
    }

    public CreateOrderReq(String name, String email, String mobileNumber, String branch, String couponId, String couponDiscount, String totalPrice, String offerPrice, String discount, String taxAmount, String taxPercent, String discountAmount, String paymentMode, String deliveryType, String paymentStatus, String totalDiscountAmount, String tipPercent, String tipAmount, String deliveryDate, String deliveryTime, String createdByDevice, String shippingAddressId, String billingAddressId, String sameAsShipping, String sameAsBilling, List<ViewCartRequest.Cart> cart) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.branch = branch;
        this.couponId = couponId;
        this.couponDiscount = couponDiscount;
        this.totalPrice = totalPrice;
        this.offerPrice = offerPrice;
        this.discount = discount;
        this.taxAmount = taxAmount;
        this.taxPercent = taxPercent;
        this.discountAmount = discountAmount;
        this.paymentMode = paymentMode;
        this.deliveryType = deliveryType;
        this.paymentStatus = paymentStatus;
        this.totalDiscountAmount = totalDiscountAmount;
        this.tipPercent = tipPercent;
        this.tipAmount = tipAmount;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        this.createdByDevice = createdByDevice;
        this.shippingAddressId = shippingAddressId;
        this.billingAddressId = billingAddressId;
        this.sameAsShipping = sameAsShipping;
        this.sameAsBilling = sameAsBilling;
        this.cart = cart;
    }

    public CreateOrderReq(String name, String email, String mobileNumber, String branch, String couponId, String couponDiscount, String totalPrice, String offerPrice, String discount, String taxAmount, String taxPercent, String discountAmount, String paymentMode, String deliveryType, String paymentStatus, String totalDiscountAmount, String tipPercent, String tipAmount, String deliveryDate, String deliveryTime, String createdByDevice, String shippingAddressId, String billingAddressId, String sameAsShipping, String sameAsBilling, List<ViewCartRequest.Cart> cart, String gateway_charge_id, String gateway_payment_id, String gateway_receipt, String gateway_currency, String gateway_description, String gateway_payment_method) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.branch = branch;
        this.couponId = couponId;
        this.couponDiscount = couponDiscount;
        this.totalPrice = totalPrice;
        this.offerPrice = offerPrice;
        this.discount = discount;
        this.taxAmount = taxAmount;
        this.taxPercent = taxPercent;
        this.discountAmount = discountAmount;
        this.paymentMode = paymentMode;
        this.deliveryType = deliveryType;
        this.paymentStatus = paymentStatus;
        this.totalDiscountAmount = totalDiscountAmount;
        this.tipPercent = tipPercent;
        this.tipAmount = tipAmount;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        this.createdByDevice = createdByDevice;
        this.shippingAddressId = shippingAddressId;
        this.billingAddressId = billingAddressId;
        this.sameAsShipping = sameAsShipping;
        this.sameAsBilling = sameAsBilling;
        this.cart = cart;


        this.gateway_charge_id = gateway_charge_id;
        this.gateway_payment_id = gateway_payment_id;
        this.gateway_receipt = gateway_receipt;
        this.gateway_currency = gateway_currency;
        this.gateway_description = gateway_description;
        this.gateway_payment_method = gateway_payment_method;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
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

    public String getTotalDiscountAmount() {
        return totalDiscountAmount;
    }

    public void setTotalDiscountAmount(String totalDiscountAmount) {
        this.totalDiscountAmount = totalDiscountAmount;
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

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getCreatedByDevice() {
        return createdByDevice;
    }

    public void setCreatedByDevice(String createdByDevice) {
        this.createdByDevice = createdByDevice;
    }

    public String getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(String shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public String getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(String billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    public String getSameAsShipping() {
        return sameAsShipping;
    }

    public void setSameAsShipping(String sameAsShipping) {
        this.sameAsShipping = sameAsShipping;
    }

    public String getSameAsBilling() {
        return sameAsBilling;
    }

    public void setSameAsBilling(String sameAsBilling) {
        this.sameAsBilling = sameAsBilling;
    }

    public List<ViewCartRequest.Cart> getCart() {
        return cart;
    }

    public void setCart(List<ViewCartRequest.Cart> cart) {
        this.cart = cart;
    }


    public String getGateway_charge_id() {
        return gateway_charge_id;
    }

    public String getGateway_payment_id() {
        return gateway_payment_id;
    }

    public String getGateway_receipt() {
        return gateway_receipt;
    }

    public String getGateway_currency() {
        return gateway_currency;
    }

    public String getGateway_description() {
        return gateway_description;
    }

    public String getGateway_payment_method() {
        return gateway_payment_method;
    }


    public void setGateway_charge_id(String gateway_charge_id) {
        this.gateway_charge_id = gateway_charge_id;
    }

    public void setGateway_payment_id(String gateway_payment_id) {
        this.gateway_payment_id = gateway_payment_id;
    }

    public void setGateway_receipt(String gateway_receipt) {
        this.gateway_receipt = gateway_receipt;
    }

    public void setGateway_currency(String gateway_currency) {
        this.gateway_currency = gateway_currency;
    }

    public void setGateway_description(String gateway_description) {
        this.gateway_description = gateway_description;
    }

    public void setGateway_payment_method(String gateway_payment_method) {
        this.gateway_payment_method = gateway_payment_method;
    }


    @Override
    public String toString() {
        return "CreateOrderReq{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", branch='" + branch + '\'' +
                ", couponId='" + couponId + '\'' +
                ", couponDiscount='" + couponDiscount + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", offerPrice='" + offerPrice + '\'' +
                ", discount='" + discount + '\'' +
                ", taxAmount='" + taxAmount + '\'' +
                ", taxPercent='" + taxPercent + '\'' +
                ", discountAmount='" + discountAmount + '\'' +
                ", paymentMode='" + paymentMode + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", totalDiscountAmount='" + totalDiscountAmount + '\'' +
                ", tipPercent='" + tipPercent + '\'' +
                ", tipAmount='" + tipAmount + '\'' +
                ", gateway_charge_id='" + gateway_charge_id + '\'' +
                ", gateway_payment_id='" + gateway_payment_id + '\'' +
                ", gateway_receipt='" + gateway_receipt + '\'' +
                ", gateway_currency='" + gateway_currency + '\'' +
                ", gateway_description='" + gateway_description + '\'' +
                ", gateway_payment_method='" + gateway_payment_method + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", createdByDevice='" + createdByDevice + '\'' +
                ", shippingAddressId='" + shippingAddressId + '\'' +
                ", billingAddressId='" + billingAddressId + '\'' +
                ", sameAsShipping='" + sameAsShipping + '\'' +
                ", sameAsBilling='" + sameAsBilling + '\'' +
                ", cart=" + cart +
                '}';
    }
}