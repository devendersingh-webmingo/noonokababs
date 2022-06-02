package com.webmingo.oldjerusalemrestaurant.SharedPrefernce;

public class CheckAmount {
   public String MRP,Discount,CouponDiscount,Subtotal,Taxes,Total,CouponId,coupon_discount,TaxName,TaxPercent,
           total_discount_amount;


   /* public CheckAmount(String MRP, String discount, String couponDiscount, String subtotal, String taxes, String total) {
        this.MRP = MRP;
        Discount = discount;
        CouponDiscount = couponDiscount;
        Subtotal = subtotal;
        Taxes = taxes;
        Total = total;
    }*/

    public CheckAmount(String MRP, String discount, String couponDiscount, String subtotal, String taxes, String total, String couponId, String coupon_discount, String taxName, String taxPercent,String total_discount_amount) {
        this.MRP = MRP;
        Discount = discount;
        CouponDiscount = couponDiscount;
        Subtotal = subtotal;
        Taxes = taxes;
        Total = total;
        CouponId = couponId;
        this.coupon_discount = coupon_discount;
        TaxName = taxName;
        TaxPercent = taxPercent;
        total_discount_amount = total_discount_amount;



    }

  /*  public CheckAmount(String MRP, String discount, String couponDiscount, String subtotal, String taxes, String total, String couponId, String coupon_discount) {
        this.MRP = MRP;
        Discount = discount;
        CouponDiscount = couponDiscount;
        Subtotal = subtotal;
        Taxes = taxes;
        Total = total;
        CouponId = couponId;
        this.coupon_discount = coupon_discount;
    }*/

    public String getMRP() {
        return MRP;
    }

    public void setMRP(String MRP) {
        this.MRP = MRP;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getCouponDiscount() {
        return CouponDiscount;
    }

    public void setCouponDiscount(String couponDiscount) {
        CouponDiscount = couponDiscount;
    }

    public String getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(String subtotal) {
        Subtotal = subtotal;
    }

    public String getTaxes() {
        return Taxes;
    }

    public void setTaxes(String taxes) {
        Taxes = taxes;
    }

    public String getTotal() {
        return Total;
    }

    public String getCouponId() {
        return CouponId;
    }

    public void setCouponId(String couponId) {
        CouponId = couponId;
    }

    public String getCoupon_discount() {
        return coupon_discount;
    }

    public void setCoupon_discount(String coupon_discount) {
        this.coupon_discount = coupon_discount;
    }

    public void setTotal(String total) {
        Total = total;
    }


    public String getTaxName() {
        return TaxName;
    }

    public void setTaxName(String taxName) {
        TaxName = taxName;
    }

    public String getTaxPercent() {
        return TaxPercent;
    }

    public void setTaxPercent(String taxPercent) {
        TaxPercent = taxPercent;
    }

    public String getTotal_discount_amount() {
        return total_discount_amount;
    }

    public void setTotal_discount_amount(String total_discount_amount) {
        this.total_discount_amount = total_discount_amount;
    }
}
