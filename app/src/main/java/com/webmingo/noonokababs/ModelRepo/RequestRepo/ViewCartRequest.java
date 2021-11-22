package com.webmingo.noonokababs.ModelRepo.RequestRepo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public  class ViewCartRequest {
    @SerializedName("cart")
    @Expose
    public List<Cart> cart ;
    public List<Cart> getCart() {
        return cart;
    }

    public ViewCartRequest(List<Cart> cart) {
        this.cart = cart;
    }
    public static class Cart {

        @SerializedName("food_id")
        @Expose
        public String foodId;
        @SerializedName("quantity")
        @Expose
        public String quantity;
        @SerializedName("varient_id")
        @Expose
        public String varientId;
        @SerializedName("required_item_id")
        @Expose
        public String requiredItemId;
        @SerializedName("cooking_levels")
        @Expose
        public String cookingLevels;
        @SerializedName("ingredients")
        @Expose
        public List<String> ingredients = null;
        @SerializedName("addons")
        @Expose
        public List<Addon> addons = null;
        @SerializedName("special_request")
        @Expose
        public String specialRequest;


        public Cart(String foodId, String quantity, String varientId, String requiredItemId, String cookingLevels, List<String> ingredients, List<Addon> addons, String specialRequest) {
            super();
            this.foodId = foodId;
            this.quantity = quantity;
            this.varientId = varientId;
            this.requiredItemId = requiredItemId;
            this.cookingLevels = cookingLevels;
            this.ingredients = ingredients;
            this.addons = addons;
            this.specialRequest = specialRequest;
        }


        public String getFoodId() {
            return foodId;
        }

        public String getQuantity() {
            return quantity;
        }

        public String getVarientId() {
            return varientId;
        }

        public String getRequiredItemId() {
            return requiredItemId;
        }

        public String getCookingLevels() {
            return cookingLevels;
        }

        public List<String> getIngredients() {
            return ingredients;
        }

        public List<Addon> getAddons() {
            return addons;
        }

        public String getSpecialRequest() {
            return specialRequest;
        }

        public static class Addon {

            @SerializedName("id")
            @Expose
            public String id;
            @SerializedName("quantity")
            @Expose
            public String quantity;


            public Addon(String id, String quantity) {
                super();
                this.id = id;
                this.quantity = quantity;
            }


            public String getId() {
                return id;
            }

            public String getQuantity() {
                return quantity;
            }
        }

    }


}