package com.webmingo.noonokababs.ModelRepo.RequestRepo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CartRequest {



    @SerializedName("cart")
    @Expose
    private List<Cart> cart ;

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    public CartRequest(List<Cart> cart) {
        this.cart = cart;
    }

    public class Cart {

        @SerializedName("food_id")
        @Expose
        private String foodId;
        @SerializedName("quantity")
        @Expose
        private String quantity;
        @SerializedName("varient_id")
        @Expose
        private String varientId;
        @SerializedName("required_item_id")
        @Expose
        private String requiredItemId;
        @SerializedName("cooking_levels")
        @Expose
        private String cookingLevels;
        @SerializedName("ingredients")
        @Expose
        private List<String> ingredients = null;
        @SerializedName("addons")
        @Expose
        private List<Addon> addons = null;
        @SerializedName("special_request")
        @Expose
        private String specialRequest;


        public Cart(String foodId, String quantity, String varientId, String requiredItemId, String cookingLevels, List<String> ingredients, List<Addon> addons, String specialRequest) {

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

        public void setFoodId(String foodId) {
            this.foodId = foodId;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getVarientId() {
            return varientId;
        }

        public void setVarientId(String varientId) {
            this.varientId = varientId;
        }

        public String getRequiredItemId() {
            return requiredItemId;
        }

        public void setRequiredItemId(String requiredItemId) {
            this.requiredItemId = requiredItemId;
        }

        public String getCookingLevels() {
            return cookingLevels;
        }

        public void setCookingLevels(String cookingLevels) {
            this.cookingLevels = cookingLevels;
        }

        public List<String> getIngredients() {
            return ingredients;
        }

        public void setIngredients(List<String> ingredients) {
            this.ingredients = ingredients;
        }

        public List<Addon> getAddons() {
            return addons;
        }

        public void setAddons(List<Addon> addons) {
            this.addons = addons;
        }

        public String getSpecialRequest() {
            return specialRequest;
        }

        public void setSpecialRequest(String specialRequest) {
            this.specialRequest = specialRequest;
        }

        public class Addon {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("quantity")
            @Expose
            private String quantity;


            public Addon(String id, String quantity) {
                this.id = id;
                this.quantity = quantity;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getQuantity() {
                return quantity;
            }

            public void setQuantity(String quantity) {
                this.quantity = quantity;
            }

        }
    }



}