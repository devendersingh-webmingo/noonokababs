package com.webmingo.noonokababs.ModelRepo.Responsee.FoodFavourit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FavouritefoodsRepo {


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
        @SerializedName("fav_foods")
        @Expose
        private FavFoods favFoods;

        public String getImageBaseUrl() {
            return imageBaseUrl;
        }

        public void setImageBaseUrl(String imageBaseUrl) {
            this.imageBaseUrl = imageBaseUrl;
        }

        public FavFoods getFavFoods() {
            return favFoods;
        }

        public void setFavFoods(FavFoods favFoods) {
            this.favFoods = favFoods;
        }


        public class FavFoods {

            @SerializedName("current_page")
            @Expose
            private Integer currentPage;
            @SerializedName("data")
            @Expose
            private List<Datum> data = null;
            @SerializedName("first_page_url")
            @Expose
            private String firstPageUrl;
            @SerializedName("from")
            @Expose
            private Integer from;
            @SerializedName("last_page")
            @Expose
            private Integer lastPage;
            @SerializedName("last_page_url")
            @Expose
            private String lastPageUrl;
            @SerializedName("links")
            @Expose
            private List<Link> links = null;
            @SerializedName("next_page_url")
            @Expose
            private Object nextPageUrl;
            @SerializedName("path")
            @Expose
            private String path;
            @SerializedName("per_page")
            @Expose
            private Integer perPage;
            @SerializedName("prev_page_url")
            @Expose
            private Object prevPageUrl;
            @SerializedName("to")
            @Expose
            private Integer to;
            @SerializedName("total")
            @Expose
            private Integer total;

            public Integer getCurrentPage() {
                return currentPage;
            }

            public void setCurrentPage(Integer currentPage) {
                this.currentPage = currentPage;
            }

            public List<Datum> getData() {
                return data;
            }

            public void setData(List<Datum> data) {
                this.data = data;
            }

            public String getFirstPageUrl() {
                return firstPageUrl;
            }

            public void setFirstPageUrl(String firstPageUrl) {
                this.firstPageUrl = firstPageUrl;
            }

            public Integer getFrom() {
                return from;
            }

            public void setFrom(Integer from) {
                this.from = from;
            }

            public Integer getLastPage() {
                return lastPage;
            }

            public void setLastPage(Integer lastPage) {
                this.lastPage = lastPage;
            }

            public String getLastPageUrl() {
                return lastPageUrl;
            }

            public void setLastPageUrl(String lastPageUrl) {
                this.lastPageUrl = lastPageUrl;
            }

            public List<Link> getLinks() {
                return links;
            }

            public void setLinks(List<Link> links) {
                this.links = links;
            }

            public Object getNextPageUrl() {
                return nextPageUrl;
            }

            public void setNextPageUrl(Object nextPageUrl) {
                this.nextPageUrl = nextPageUrl;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public Integer getPerPage() {
                return perPage;
            }

            public void setPerPage(Integer perPage) {
                this.perPage = perPage;
            }

            public Object getPrevPageUrl() {
                return prevPageUrl;
            }

            public void setPrevPageUrl(Object prevPageUrl) {
                this.prevPageUrl = prevPageUrl;
            }

            public Integer getTo() {
                return to;
            }

            public void setTo(Integer to) {
                this.to = to;
            }

            public Integer getTotal() {
                return total;
            }

            public void setTotal(Integer total) {
                this.total = total;
            }


            public class Datum {

                @SerializedName("id")
                @Expose
                private Integer id;
                @SerializedName("type_id")
                @Expose
                private Integer typeId;
                @SerializedName("category_id")
                @Expose
                private Integer categoryId;
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
                private Integer favourite;
                @SerializedName("delivery_time")
                @Expose
                private String deliveryTime;
                @SerializedName("promotional")
                @Expose
                private String promotional;
                @SerializedName("levels")
                @Expose
                private Object levels;
                @SerializedName("ingredients")
                @Expose
                private String ingredients;
                @SerializedName("addons")
                @Expose
                private Object addons;
                @SerializedName("mandatory")
                @Expose
                private Object mandatory;
                @SerializedName("created_at")
                @Expose
                private String createdAt;
                @SerializedName("updated_at")
                @Expose
                private String updatedAt;
                @SerializedName("deleted_at")
                @Expose
                private Object deletedAt;
                @SerializedName("get_gallery")
                @Expose
                private List<GetGallery> getGallery = null;
                @SerializedName("get_single_price")
                @Expose
                private GetSinglePrice getSinglePrice;

                public Integer getId() {
                    return id;
                }

                public void setId(Integer id) {
                    this.id = id;
                }

                public Integer getTypeId() {
                    return typeId;
                }

                public void setTypeId(Integer typeId) {
                    this.typeId = typeId;
                }

                public Integer getCategoryId() {
                    return categoryId;
                }

                public void setCategoryId(Integer categoryId) {
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

                public Integer getFavourite() {
                    return favourite;
                }

                public void setFavourite(Integer favourite) {
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

                public String getIngredients() {
                    return ingredients;
                }

                public void setIngredients(String ingredients) {
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

                public GetSinglePrice getGetSinglePrice() {
                    return getSinglePrice;
                }

                public void setGetSinglePrice(GetSinglePrice getSinglePrice) {
                    this.getSinglePrice = getSinglePrice;
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

                public class GetSinglePrice {

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

            public class Link {

                @SerializedName("url")
                @Expose
                private Object url;
                @SerializedName("label")
                @Expose
                private String label;
                @SerializedName("active")
                @Expose
                private Boolean active;

                public Object getUrl() {
                    return url;
                }

                public void setUrl(Object url) {
                    this.url = url;
                }

                public String getLabel() {
                    return label;
                }

                public void setLabel(String label) {
                    this.label = label;
                }

                public Boolean getActive() {
                    return active;
                }

                public void setActive(Boolean active) {
                    this.active = active;
                }

            }
        }

    }


}