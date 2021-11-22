package com.webmingo.noonokababs.ModelRepo.cart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddToCartDetailsRepo {


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
        @SerializedName("food")
        @Expose
        private Food food;
        @SerializedName("varient")
        @Expose
        private Varient varient;
        @SerializedName("required_items")
        @Expose
        private List<RequiredItem> requiredItems = null;
        @SerializedName("cooking_levels")
        @Expose
        private List<Object> cookingLevels = null;
        @SerializedName("ingredients")
        @Expose
        private List<Ingredient> ingredients = null;
        @SerializedName("all_varients")
        @Expose
        private List<AllVarient> allVarients = null;
        @SerializedName("addons")
        @Expose
        private List<Addon> addons = null;

        public String getImageBaseUrl() {
            return imageBaseUrl;
        }

        public void setImageBaseUrl(String imageBaseUrl) {
            this.imageBaseUrl = imageBaseUrl;
        }

        public Food getFood() {
            return food;
        }

        public void setFood(Food food) {
            this.food = food;
        }

        public Varient getVarient() {
            return varient;
        }

        public void setVarient(Varient varient) {
            this.varient = varient;
        }

        public List<RequiredItem> getRequiredItems() {
            return requiredItems;
        }

        public void setRequiredItems(List<RequiredItem> requiredItems) {
            this.requiredItems = requiredItems;
        }

        public List<Object> getCookingLevels() {
            return cookingLevels;
        }

        public void setCookingLevels(List<Object> cookingLevels) {
            this.cookingLevels = cookingLevels;
        }

        public List<Ingredient> getIngredients() {
            return ingredients;
        }

        public void setIngredients(List<Ingredient> ingredients) {
            this.ingredients = ingredients;
        }

        public List<AllVarient> getAllVarients() {
            return allVarients;
        }

        public void setAllVarients(List<AllVarient> allVarients) {
            this.allVarients = allVarients;
        }

        public List<Addon> getAddons() {
            return addons;
        }

        public void setAddons(List<Addon> addons) {
            this.addons = addons;
        }


        public class Food {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("remark")
            @Expose
            private String remark;
            @SerializedName("description")
            @Expose
            private String description;
            @SerializedName("levels")
            @Expose
            private Object levels;
            @SerializedName("ingredients")
            @Expose
            private String ingredients;
            @SerializedName("mandatory")
            @Expose
            private String mandatory;
            @SerializedName("addons")
            @Expose
            private String addons;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public Object getLevels() {
                return levels;
            }

            public void setLevels(Object levels) {
                this.levels = levels;
            }

            public String getIngredients() {
                return ingredients;
            }

            public void setIngredients(String ingredients) {
                this.ingredients = ingredients;
            }

            public String getMandatory() {
                return mandatory;
            }

            public void setMandatory(String mandatory) {
                this.mandatory = mandatory;
            }

            public String getAddons() {
                return addons;
            }

            public void setAddons(String addons) {
                this.addons = addons;
            }

        }

        public class Varient {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("food_id")
            @Expose
            private Integer foodId;
            @SerializedName("quantity_id")
            @Expose
            private Integer quantityId;
            @SerializedName("price")
            @Expose
            private String price;
            @SerializedName("discount")
            @Expose
            private Object discount;
            @SerializedName("final_price")
            @Expose
            private String finalPrice;
            @SerializedName("stock_quantity")
            @Expose
            private String stockQuantity;
            @SerializedName("addon")
            @Expose
            private String addon;
            @SerializedName("required")
            @Expose
            private Object required;
            @SerializedName("required_price")
            @Expose
            private Object requiredPrice;
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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getFoodId() {
                return foodId;
            }

            public void setFoodId(Integer foodId) {
                this.foodId = foodId;
            }

            public Integer getQuantityId() {
                return quantityId;
            }

            public void setQuantityId(Integer quantityId) {
                this.quantityId = quantityId;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public Object getDiscount() {
                return discount;
            }

            public void setDiscount(Object discount) {
                this.discount = discount;
            }

            public String getFinalPrice() {
                return finalPrice;
            }

            public void setFinalPrice(String finalPrice) {
                this.finalPrice = finalPrice;
            }

            public String getStockQuantity() {
                return stockQuantity;
            }

            public void setStockQuantity(String stockQuantity) {
                this.stockQuantity = stockQuantity;
            }

            public String getAddon() {
                return addon;
            }

            public void setAddon(String addon) {
                this.addon = addon;
            }

            public Object getRequired() {
                return required;
            }

            public void setRequired(Object required) {
                this.required = required;
            }

            public Object getRequiredPrice() {
                return requiredPrice;
            }

            public void setRequiredPrice(Object requiredPrice) {
                this.requiredPrice = requiredPrice;
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

        public class RequiredItem {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("quantity")
            @Expose
            private String quantity;
            @SerializedName("description")
            @Expose
            private String description;
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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getQuantity() {
                return quantity;
            }

            public void setQuantity(String quantity) {
                this.quantity = quantity;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
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

        public class AllVarient {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("food_id")
            @Expose
            private Integer foodId;
            @SerializedName("quantity_id")
            @Expose
            private Integer quantityId;
            @SerializedName("price")
            @Expose
            private String price;
            @SerializedName("discount")
            @Expose
            private Object discount;
            @SerializedName("final_price")
            @Expose
            private String finalPrice;
            @SerializedName("stock_quantity")
            @Expose
            private String stockQuantity;
            @SerializedName("addon")
            @Expose
            private String addon;
            @SerializedName("required")
            @Expose
            private Object required;
            @SerializedName("required_price")
            @Expose
            private Object requiredPrice;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("get_quantity")
            @Expose
            private GetQuantity getQuantity;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getFoodId() {
                return foodId;
            }

            public void setFoodId(Integer foodId) {
                this.foodId = foodId;
            }

            public Integer getQuantityId() {
                return quantityId;
            }

            public void setQuantityId(Integer quantityId) {
                this.quantityId = quantityId;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public Object getDiscount() {
                return discount;
            }

            public void setDiscount(Object discount) {
                this.discount = discount;
            }

            public String getFinalPrice() {
                return finalPrice;
            }

            public void setFinalPrice(String finalPrice) {
                this.finalPrice = finalPrice;
            }

            public String getStockQuantity() {
                return stockQuantity;
            }

            public void setStockQuantity(String stockQuantity) {
                this.stockQuantity = stockQuantity;
            }

            public String getAddon() {
                return addon;
            }

            public void setAddon(String addon) {
                this.addon = addon;
            }

            public Object getRequired() {
                return required;
            }

            public void setRequired(Object required) {
                this.required = required;
            }

            public Object getRequiredPrice() {
                return requiredPrice;
            }

            public void setRequiredPrice(Object requiredPrice) {
                this.requiredPrice = requiredPrice;
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

            public GetQuantity getGetQuantity() {
                return getQuantity;
            }

            public void setGetQuantity(GetQuantity getQuantity) {
                this.getQuantity = getQuantity;
            }

            public class GetQuantity {

                @SerializedName("id")
                @Expose
                private Integer id;
                @SerializedName("type")
                @Expose
                private String type;
                @SerializedName("remark")
                @Expose
                private String remark;
                @SerializedName("status")
                @Expose
                private String status;
                @SerializedName("deleted_at")
                @Expose
                private Object deletedAt;
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

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public Object getDeletedAt() {
                    return deletedAt;
                }

                public void setDeletedAt(Object deletedAt) {
                    this.deletedAt = deletedAt;
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

        public class Addon {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("get_gallery")
            @Expose
            private List<GetGallery> getGallery = null;
            @SerializedName("get_addon_food_varients")
            @Expose
            private List<GetAddonFoodVarient> getAddonFoodVarients = null;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<GetGallery> getGetGallery() {
                return getGallery;
            }

            public void setGetGallery(List<GetGallery> getGallery) {
                this.getGallery = getGallery;
            }

            public List<GetAddonFoodVarient> getGetAddonFoodVarients() {
                return getAddonFoodVarients;
            }

            public void setGetAddonFoodVarients(List<GetAddonFoodVarient> getAddonFoodVarients) {
                this.getAddonFoodVarients = getAddonFoodVarients;
            }

            public class GetGallery {

                @SerializedName("id")
                @Expose
                private Integer id;
                @SerializedName("food_id")
                @Expose
                private Integer foodId;
                @SerializedName("image")
                @Expose
                private String image;
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

                public Integer getFoodId() {
                    return foodId;
                }

                public void setFoodId(Integer foodId) {
                    this.foodId = foodId;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
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

            public class GetAddonFoodVarient {

                @SerializedName("id")
                @Expose
                private Integer id;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("food_id")
                @Expose
                private Integer foodId;
                @SerializedName("quantity_id")
                @Expose
                private Integer quantityId;
                @SerializedName("price")
                @Expose
                private String price;
                @SerializedName("discount")
                @Expose
                private Object discount;
                @SerializedName("final_price")
                @Expose
                private String finalPrice;
                @SerializedName("stock_quantity")
                @Expose
                private String stockQuantity;
                @SerializedName("addon")
                @Expose
                private String addon;
                @SerializedName("required")
                @Expose
                private Object required;
                @SerializedName("required_price")
                @Expose
                private Object requiredPrice;
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

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Integer getFoodId() {
                    return foodId;
                }

                public void setFoodId(Integer foodId) {
                    this.foodId = foodId;
                }

                public Integer getQuantityId() {
                    return quantityId;
                }

                public void setQuantityId(Integer quantityId) {
                    this.quantityId = quantityId;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public Object getDiscount() {
                    return discount;
                }

                public void setDiscount(Object discount) {
                    this.discount = discount;
                }

                public String getFinalPrice() {
                    return finalPrice;
                }

                public void setFinalPrice(String finalPrice) {
                    this.finalPrice = finalPrice;
                }

                public String getStockQuantity() {
                    return stockQuantity;
                }

                public void setStockQuantity(String stockQuantity) {
                    this.stockQuantity = stockQuantity;
                }

                public String getAddon() {
                    return addon;
                }

                public void setAddon(String addon) {
                    this.addon = addon;
                }

                public Object getRequired() {
                    return required;
                }

                public void setRequired(Object required) {
                    this.required = required;
                }

                public Object getRequiredPrice() {
                    return requiredPrice;
                }

                public void setRequiredPrice(Object requiredPrice) {
                    this.requiredPrice = requiredPrice;
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

    }
}

