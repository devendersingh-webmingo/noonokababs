package com.webmingo.oldjerusalemrestaurant.ModelRepo.RequestRepo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ViewCartRequest {
    @SerializedName("cart")
    @Expose
    public List<Cart> cart ;


    @SerializedName("coupon_discount")
    @Expose
    private String coupon_discount;


    public List<Cart> getCart() {
        return cart;
    }

    public ViewCartRequest(List<Cart> cart) {
        this.cart = cart;
    }

    public ViewCartRequest(List<Cart> cart, String coupon_discount) {
        this.cart = cart;
        this.coupon_discount = coupon_discount;
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
        public List<Integer> ingredients = null;
        @SerializedName("addons")
        @Expose
        public List<Addon> addons = null;
        @SerializedName("special_request")
        @Expose
        public String specialRequest;

        public Cart() {
        }

        public Cart(String foodId, String quantity, String varientId, String requiredItemId, String cookingLevels, List<Integer> ingredients, List<Addon> addons, String specialRequest) {
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

        public List<Integer> getIngredients() {
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

            @Override
            public String toString() {
                return "Addon{" +
                        "id='" + id + '\'' +
                        ", quantity='" + quantity + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "Cart{" +
                    "foodId='" + foodId + '\'' +
                    ", quantity='" + quantity + '\'' +
                    ", varientId='" + varientId + '\'' +
                    ", requiredItemId='" + requiredItemId + '\'' +
                    ", cookingLevels='" + cookingLevels + '\'' +
                    ", ingredients=" + ingredients +
                    ", addons=" + addons +
                    ", specialRequest='" + specialRequest + '\'' +
                    '}';
        }
    }


  /*  @SerializedName("cart")
    @Expose
    private List<Cart> cart = null;

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
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

    }*/

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

}