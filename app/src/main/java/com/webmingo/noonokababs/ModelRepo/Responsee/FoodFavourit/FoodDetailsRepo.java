
package com.webmingo.noonokababs.ModelRepo.Responsee.FoodFavourit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodDetailsRepo {
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
        @SerializedName("food_detail")
        @Expose
        private FoodDetail foodDetail;

        public String getImageBaseUrl() {
            return imageBaseUrl;
        }

        public void setImageBaseUrl(String imageBaseUrl) {
            this.imageBaseUrl = imageBaseUrl;
        }

        public FoodDetail getFoodDetail() {
            return foodDetail;
        }

        public void setFoodDetail(FoodDetail foodDetail) {
            this.foodDetail = foodDetail;
        }


        public class FoodDetail {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("type_id")
            @Expose
            private String typeId;
            @SerializedName("category_id")
            @Expose
            private String categoryId;
            @SerializedName("sub_category_id")
            @Expose
            private Object subCategoryId;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("remark")
            @Expose
            private String remark;
            @SerializedName("meta_title")
            @Expose
            private String metaTitle;
            @SerializedName("keyword")
            @Expose
            private String keyword;
            @SerializedName("description")
            @Expose
            private String description;
            @SerializedName("stock")
            @Expose
            private String stock;
            @SerializedName("inventory")
            @Expose
            private String inventory;
            @SerializedName("cod")
            @Expose
            private String cod;
            @SerializedName("home_delivery")
            @Expose
            private String homeDelivery;
            @SerializedName("takeaway")
            @Expose
            private String takeaway;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("favourite")
            @Expose
            private Object favourite;
            @SerializedName("delivery_time")
            @Expose
            private String deliveryTime;
            @SerializedName("promotional")
            @Expose
            private String promotional;
            @SerializedName("levels")
            @Expose
            private String levels;
            @SerializedName("ingredients")
            @Expose
            private String ingredients;
            @SerializedName("addons")
            @Expose
            private String addons;
            @SerializedName("mandatory")
            @Expose
            private String mandatory;
            @SerializedName("avg_rating")
            @Expose
            private String avgRating;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("deleted_at")
            @Expose
            private Object deletedAt;
            @SerializedName("in_stock")
            @Expose
            private String inStock;
            @SerializedName("total_rating")
            @Expose
            private String totalRating;
            @SerializedName("rating")
            @Expose
            private String rating;
            @SerializedName("get_gallery")
            @Expose
            private List<GetGallery> getGallery = null;
            @SerializedName("get_varients")
            @Expose
            private List<GetVarient> getVarients = null;
            @SerializedName("get_category")
            @Expose
            private GetCategory getCategory;
            @SerializedName("get_sub_category")
            @Expose
            private Object getSubCategory;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTypeId() {
                return typeId;
            }

            public void setTypeId(String typeId) {
                this.typeId = typeId;
            }

            public String getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(String categoryId) {
                this.categoryId = categoryId;
            }

            public Object getSubCategoryId() {
                return subCategoryId;
            }

            public void setSubCategoryId(Object subCategoryId) {
                this.subCategoryId = subCategoryId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getMetaTitle() {
                return metaTitle;
            }

            public void setMetaTitle(String metaTitle) {
                this.metaTitle = metaTitle;
            }

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getStock() {
                return stock;
            }

            public void setStock(String stock) {
                this.stock = stock;
            }

            public String getInventory() {
                return inventory;
            }

            public void setInventory(String inventory) {
                this.inventory = inventory;
            }

            public String getCod() {
                return cod;
            }

            public void setCod(String cod) {
                this.cod = cod;
            }

            public String getHomeDelivery() {
                return homeDelivery;
            }

            public void setHomeDelivery(String homeDelivery) {
                this.homeDelivery = homeDelivery;
            }

            public String getTakeaway() {
                return takeaway;
            }

            public void setTakeaway(String takeaway) {
                this.takeaway = takeaway;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public Object getFavourite() {
                return favourite;
            }

            public void setFavourite(Object favourite) {
                this.favourite = favourite;
            }

            public String getDeliveryTime() {
                return deliveryTime;
            }

            public void setDeliveryTime(String deliveryTime) {
                this.deliveryTime = deliveryTime;
            }

            public String getPromotional() {
                return promotional;
            }

            public void setPromotional(String promotional) {
                this.promotional = promotional;
            }

            public String getLevels() {
                return levels;
            }

            public void setLevels(String levels) {
                this.levels = levels;
            }

            public String getIngredients() {
                return ingredients;
            }

            public void setIngredients(String ingredients) {
                this.ingredients = ingredients;
            }

            public String getAddons() {
                return addons;
            }

            public void setAddons(String addons) {
                this.addons = addons;
            }

            public String getMandatory() {
                return mandatory;
            }

            public void setMandatory(String mandatory) {
                this.mandatory = mandatory;
            }

            public String getAvgRating() {
                return avgRating;
            }

            public void setAvgRating(String avgRating) {
                this.avgRating = avgRating;
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

            public Object getDeletedAt() {
                return deletedAt;
            }

            public void setDeletedAt(Object deletedAt) {
                this.deletedAt = deletedAt;
            }

            public String getInStock() {
                return inStock;
            }

            public void setInStock(String inStock) {
                this.inStock = inStock;
            }

            public String getTotalRating() {
                return totalRating;
            }

            public void setTotalRating(String totalRating) {
                this.totalRating = totalRating;
            }

            public String getRating() {
                return rating;
            }

            public void setRating(String rating) {
                this.rating = rating;
            }

            public List<GetGallery> getGetGallery() {
                return getGallery;
            }

            public void setGetGallery(List<GetGallery> getGallery) {
                this.getGallery = getGallery;
            }

            public List<GetVarient> getGetVarients() {
                return getVarients;
            }

            public void setGetVarients(List<GetVarient> getVarients) {
                this.getVarients = getVarients;
            }

            public GetCategory getGetCategory() {
                return getCategory;
            }

            public void setGetCategory(GetCategory getCategory) {
                this.getCategory = getCategory;
            }

            public Object getGetSubCategory() {
                return getSubCategory;
            }

            public void setGetSubCategory(Object getSubCategory) {
                this.getSubCategory = getSubCategory;
            }


            public class GetGallery {

                @SerializedName("id")
                @Expose
                private String id;
                @SerializedName("food_id")
                @Expose
                private String foodId;
                @SerializedName("image")
                @Expose
                private String image;
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

            public class GetVarient {

                @SerializedName("id")
                @Expose
                private String id;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("food_id")
                @Expose
                private String foodId;
                @SerializedName("quantity_id")
                @Expose
                private String quantityId;
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

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getFoodId() {
                    return foodId;
                }

                public void setFoodId(String foodId) {
                    this.foodId = foodId;
                }

                public String getQuantityId() {
                    return quantityId;
                }

                public void setQuantityId(String quantityId) {
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


            public class GetCategory {

                @SerializedName("id")
                @Expose
                private String id;
                @SerializedName("parent_id")
                @Expose
                private Object parentId;
                @SerializedName("image")
                @Expose
                private String image;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("slug")
                @Expose
                private String slug;
                @SerializedName("remark")
                @Expose
                private String remark;
                @SerializedName("meta_title")
                @Expose
                private String metaTitle;
                @SerializedName("meta_keywords")
                @Expose
                private String metaKeywords;
                @SerializedName("meta_Description")
                @Expose
                private String metaDescription;
                @SerializedName("status")
                @Expose
                private String status;
                @SerializedName("type_id")
                @Expose
                private String typeId;
                @SerializedName("created_at")
                @Expose
                private String createdAt;
                @SerializedName("updated_at")
                @Expose
                private String updatedAt;
                @SerializedName("deleted_at")
                @Expose
                private Object deletedAt;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public Object getParentId() {
                    return parentId;
                }

                public void setParentId(Object parentId) {
                    this.parentId = parentId;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getSlug() {
                    return slug;
                }

                public void setSlug(String slug) {
                    this.slug = slug;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public String getMetaTitle() {
                    return metaTitle;
                }

                public void setMetaTitle(String metaTitle) {
                    this.metaTitle = metaTitle;
                }

                public String getMetaKeywords() {
                    return metaKeywords;
                }

                public void setMetaKeywords(String metaKeywords) {
                    this.metaKeywords = metaKeywords;
                }

                public String getMetaDescription() {
                    return metaDescription;
                }

                public void setMetaDescription(String metaDescription) {
                    this.metaDescription = metaDescription;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getTypeId() {
                    return typeId;
                }

                public void setTypeId(String typeId) {
                    this.typeId = typeId;
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

                public Object getDeletedAt() {
                    return deletedAt;
                }

                public void setDeletedAt(Object deletedAt) {
                    this.deletedAt = deletedAt;
                }

            }

        }

    }


}




















/*
package com.webmingo.noonokababs.ModelRepo.Responsee.FoodFavourit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodDetailsRepo {


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
        @SerializedName("food_detail")
        @Expose
        private FoodDetail foodDetail;

        public String getImageBaseUrl() {
            return imageBaseUrl;
        }

        public void setImageBaseUrl(String imageBaseUrl) {
            this.imageBaseUrl = imageBaseUrl;
        }

        public FoodDetail getFoodDetail() {
            return foodDetail;
        }

        public void setFoodDetail(FoodDetail foodDetail) {
            this.foodDetail = foodDetail;
        }

        public class FoodDetail {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("type_id")
            @Expose
            private String typeId;
            @SerializedName("category_id")
            @Expose
            private String categoryId;
            @SerializedName("sub_category_id")
            @Expose
            private Object subCategoryId;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("slug")
            @Expose
            private String slug;
            @SerializedName("remark")
            @Expose
            private String remark;
            @SerializedName("meta_title")
            @Expose
            private String metaTitle;
            @SerializedName("keyword")
            @Expose
            private String keyword;
            @SerializedName("description")
            @Expose
            private String description;
            @SerializedName("stock")
            @Expose
            private String stock;
            @SerializedName("inventory")
            @Expose
            private String inventory;
            @SerializedName("cod")
            @Expose
            private String cod;
            @SerializedName("home_delivery")
            @Expose
            private String homeDelivery;
            @SerializedName("takeaway")
            @Expose
            private String takeaway;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("favourite")
            @Expose
            private Object favourite;
            @SerializedName("delivery_time")
            @Expose
            private String deliveryTime;
            @SerializedName("promotional")
            @Expose
            private String promotional;

            @SerializedName("levels")
            @Expose

            private String avg_rating;
            @SerializedName("avg_rating")
            @Expose
            private String total_rating;
            @SerializedName("total_rating")
            @Expose


            private String rating;
            @SerializedName("rating")
            @Expose


            private Object levels;

            @SerializedName("ingredients")
            @Expose
            private Object ingredients;
            @SerializedName("addons")
            @Expose
            private Object addons;
            @SerializedName("mandatory")
            @Expose
            private Object mandatory;


            @SerializedName("created_at")
            @Expose
            private String createdAt;


            @SerializedName("in_stock")
            @Expose
            private String in_stock;

            public String getIn_stock() {
                return in_stock;
            }

            public void setIn_stock(String in_stock) {
                this.in_stock = in_stock;
            }

            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("deleted_at")
            @Expose
            private Object deletedAt;
            @SerializedName("get_gallery")
            @Expose
            private List<GetGallery> getGallery = null;
            @SerializedName("get_varients")
            @Expose
            private List<GetVarient> getVarients = null;
            @SerializedName("get_category")
            @Expose
            private GetCategory getCategory;
            @SerializedName("get_sub_category")
            @Expose
            private Object getSubCategory;

            public String getAvg_rating() {
                return avg_rating;
            }

            public void setAvg_rating(String avg_rating) {
                this.avg_rating = avg_rating;
            }

            public String getTotal_rating() {
                return total_rating;
            }


            public String getRating() {
                return rating;
            }

            public void setRating(String rating) {
                this.rating = rating;
            }

            public void setTotal_rating(String total_rating) {
                this.total_rating = total_rating;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id  = id;
            }

            public String getTypeId() {
                return typeId;
            }

            public void setTypeId(String typeId) {
                this.typeId = typeId;
            }

            public String getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(String categoryId) {
                this.categoryId = categoryId;
            }

            public Object getSubCategoryId() {
                return subCategoryId;
            }

            public void setSubCategoryId(Object subCategoryId) {
                this.subCategoryId = subCategoryId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getMetaTitle() {
                return metaTitle;
            }

            public void setMetaTitle(String metaTitle) {
                this.metaTitle = metaTitle;
            }

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getStock() {
                return stock;
            }

            public void setStock(String stock) {
                this.stock = stock;
            }

            public String getInventory() {
                return inventory;
            }

            public void setInventory(String inventory) {
                this.inventory = inventory;
            }

            public String getCod() {
                return cod;
            }

            public void setCod(String cod) {
                this.cod = cod;
            }

            public String getHomeDelivery() {
                return homeDelivery;
            }

            public void setHomeDelivery(String homeDelivery) {
                this.homeDelivery = homeDelivery;
            }

            public String getTakeaway() {
                return takeaway;
            }

            public void setTakeaway(String takeaway) {
                this.takeaway = takeaway;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public Object getFavourite() {
                return favourite;
            }

            public void setFavourite(Object favourite) {
                this.favourite = favourite;
            }

            public String getDeliveryTime() {
                return deliveryTime;
            }

            public void setDeliveryTime(String deliveryTime) {
                this.deliveryTime = deliveryTime;
            }

            public String getPromotional() {
                return promotional;
            }

            public void setPromotional(String promotional) {
                this.promotional = promotional;
            }

            public Object getLevels() {
                return levels;
            }

            public void setLevels(Object levels) {
                this.levels = levels;
            }

            public Object getIngredients() {
                return ingredients;
            }

            public void setIngredients(Object ingredients) {
                this.ingredients = ingredients;
            }

            public Object getAddons() {
                return addons;
            }

            public void setAddons(Object addons) {
                this.addons = addons;
            }

            public Object getMandatory() {
                return mandatory;
            }

            public void setMandatory(Object mandatory) {
                this.mandatory = mandatory;
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

            public Object getDeletedAt() {
                return deletedAt;
            }

            public void setDeletedAt(Object deletedAt) {
                this.deletedAt = deletedAt;
            }

            public List<GetGallery> getGetGallery() {
                return getGallery;
            }

            public void setGetGallery(List<GetGallery> getGallery) {
                this.getGallery = getGallery;
            }

            public List<GetVarient> getGetVarients() {
                return getVarients;
            }

            public void setGetVarients(List<GetVarient> getVarients) {
                this.getVarients = getVarients;
            }

            public GetCategory getGetCategory() {
                return getCategory;
            }

            public void setGetCategory(GetCategory getCategory) {
                this.getCategory = getCategory;
            }

            public Object getGetSubCategory() {
                return getSubCategory;
            }

            public void setGetSubCategory(Object getSubCategory) {
                this.getSubCategory = getSubCategory;
            }

            public class GetGallery {

                @SerializedName("id")
                @Expose
                private String id;
                @SerializedName("food_id")
                @Expose
                private String foodId;
                @SerializedName("image")
                @Expose
                private String image;
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

            public class GetVarient {

                @SerializedName("id")
                @Expose
                private String id;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("food_id")
                @Expose
                private String foodId;
                @SerializedName("quantity_id")
                @Expose
                private String quantityId;
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

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getFoodId() {
                    return foodId;
                }

                public void setFoodId(String foodId) {
                    this.foodId = foodId;
                }

                public String getQuantityId() {
                    return quantityId;
                }

                public void setQuantityId(String quantityId) {
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

            public class GetCategory {

                @SerializedName("id")
                @Expose
                private String id;
                @SerializedName("parent_id")
                @Expose
                private Object parentId;
                @SerializedName("image")
                @Expose
                private String image;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("slug")
                @Expose
                private String slug;
                @SerializedName("remark")
                @Expose
                private String remark;
                @SerializedName("meta_title")
                @Expose
                private String metaTitle;
                @SerializedName("meta_keywords")
                @Expose
                private String metaKeywords;
                @SerializedName("meta_Description")
                @Expose
                private String metaDescription;
                @SerializedName("status")
                @Expose
                private String status;
                @SerializedName("type_id")
                @Expose
                private String typeId;
                @SerializedName("created_at")
                @Expose
                private String createdAt;
                @SerializedName("updated_at")
                @Expose
                private String updatedAt;
                @SerializedName("deleted_at")
                @Expose
                private Object deletedAt;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public Object getParentId() {
                    return parentId;
                }

                public void setParentId(Object parentId) {
                    this.parentId = parentId;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getSlug() {
                    return slug;
                }

                public void setSlug(String slug) {
                    this.slug = slug;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public String getMetaTitle() {
                    return metaTitle;
                }

                public void setMetaTitle(String metaTitle) {
                    this.metaTitle = metaTitle;
                }

                public String getMetaKeywords() {
                    return metaKeywords;
                }

                public void setMetaKeywords(String metaKeywords) {
                    this.metaKeywords = metaKeywords;
                }

                public String getMetaDescription() {
                    return metaDescription;
                }

                public void setMetaDescription(String metaDescription) {
                    this.metaDescription = metaDescription;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getTypeId() {
                    return typeId;
                }

                public void setTypeId(String typeId) {
                    this.typeId = typeId;
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

                public Object getDeletedAt() {
                    return deletedAt;
                }

                public void setDeletedAt(Object deletedAt) {
                    this.deletedAt = deletedAt;
                }

            }


        }
    }

}
*/



