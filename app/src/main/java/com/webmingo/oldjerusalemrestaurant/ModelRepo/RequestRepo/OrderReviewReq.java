package com.webmingo.oldjerusalemrestaurant.ModelRepo.RequestRepo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderReviewReq {


    @SerializedName("food_id")
    @Expose
    private String foodId;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("review")
    @Expose
    private String review;


    public OrderReviewReq(String foodId, String rating, String review) {
        this.foodId = foodId;
        this.rating = rating;
        this.review = review;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

}