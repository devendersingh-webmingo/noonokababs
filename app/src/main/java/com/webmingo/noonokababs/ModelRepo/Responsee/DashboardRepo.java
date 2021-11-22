package com.webmingo.noonokababs.ModelRepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DashboardRepo {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("code")
    @Expose
    private Integer code;
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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
        @SerializedName("categories")
        @Expose
        private List<Category> categories = null;
        @SerializedName("food_items")
        @Expose
        private List<FoodItem> foodItems = null;
        @SerializedName("user_info")
        @Expose
        private UserInfo userInfo;

        public String getImageBaseUrl() {
            return imageBaseUrl;
        }

        public void setImageBaseUrl(String imageBaseUrl) {
            this.imageBaseUrl = imageBaseUrl;
        }

        public List<Category> getCategories() {
            return categories;
        }

        public void setCategories(List<Category> categories) {
            this.categories = categories;
        }

        public List<FoodItem> getFoodItems() {
            return foodItems;
        }

        public void setFoodItems(List<FoodItem> foodItems) {
            this.foodItems = foodItems;
        }

        public UserInfo getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfo userInfo) {
            this.userInfo = userInfo;
        }

        public class Category {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("parent_id")
            @Expose
            private String parentId;
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
            private Integer typeId;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("deleted_at")
            @Expose
            private String deletedAt;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
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

            public Integer getTypeId() {
                return typeId;
            }

            public void setTypeId(Integer typeId) {
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

            public String getDeletedAt() {
                return deletedAt;
            }

            public void setDeletedAt(String deletedAt) {
                this.deletedAt = deletedAt;
            }

        }

        public class FoodItem {

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
            private String subCategoryId;
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
            private String favourite;
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
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("deleted_at")
            @Expose
            private String deletedAt;
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

            public String getSubCategoryId() {
                return subCategoryId;
            }

            public void setSubCategoryId(String subCategoryId) {
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

            public String getFavourite() {
                return favourite;
            }

            public void setFavourite(String favourite) {
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

            public String getDeletedAt() {
                return deletedAt;
            }

            public void setDeletedAt(String deletedAt) {
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
                private String discount;
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
                private String required;
                @SerializedName("required_price")
                @Expose
                private String requiredPrice;
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

                public String getDiscount() {
                    return discount;
                }

                public void setDiscount(String discount) {
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

                public String getRequired() {
                    return required;
                }

                public void setRequired(String required) {
                    this.required = required;
                }

                public String getRequiredPrice() {
                    return requiredPrice;
                }

                public void setRequiredPrice(String requiredPrice) {
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


        public class UserInfo {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("referral_user_id")
            @Expose
            private String referralUserId;
            @SerializedName("referral_master_id")
            @Expose
            private String referralMasterId;
            @SerializedName("role")
            @Expose
            private String role;
            @SerializedName("username")
            @Expose
            private String username;
            @SerializedName("profile_photo")
            @Expose
            private String profilePhoto;
            @SerializedName("gender")
            @Expose
            private String gender;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("email")
            @Expose
            private String email;
            @SerializedName("country_code")
            @Expose
            private Integer countryCode;
            @SerializedName("mobile_number")
            @Expose
            private String mobileNumber;
            @SerializedName("phone_number")
            @Expose
            private String phoneNumber;
            @SerializedName("dob")
            @Expose
            private String dob;
            @SerializedName("address")
            @Expose
            private String address;
            @SerializedName("about_me")
            @Expose
            private String aboutMe;
            @SerializedName("website")
            @Expose
            private String website;
            @SerializedName("manager_name")
            @Expose
            private String managerName;
            @SerializedName("country_id")
            @Expose
            private Integer countryId;
            @SerializedName("state_id")
            @Expose
            private String stateId;
            @SerializedName("city_id")
            @Expose
            private String cityId;
            @SerializedName("date_of_open")
            @Expose
            private String dateOfOpen;
            @SerializedName("facebook")
            @Expose
            private String facebook;
            @SerializedName("twitter")
            @Expose
            private String twitter;
            @SerializedName("youtube")
            @Expose
            private String youtube;
            @SerializedName("linkedin")
            @Expose
            private String linkedin;
            @SerializedName("marital_status")
            @Expose
            private String maritalStatus;
            @SerializedName("email_verified_at")
            @Expose
            private String emailVerifiedAt;
            @SerializedName("mobile_verified_at")
            @Expose
            private String mobileVerifiedAt;
            @SerializedName("company_name")
            @Expose
            private String companyName;
            @SerializedName("user_status")
            @Expose
            private String userStatus;
            @SerializedName("wallet_amount")
            @Expose
            private Integer walletAmount;
            @SerializedName("sender_amount")
            @Expose
            private Integer senderAmount;
            @SerializedName("receiver_amount")
            @Expose
            private Integer receiverAmount;
            @SerializedName("sender_referral_status")
            @Expose
            private String senderReferralStatus;
            @SerializedName("receiver_referral_status")
            @Expose
            private String receiverReferralStatus;
            @SerializedName("other_email")
            @Expose
            private String otherEmail;
            @SerializedName("other_mobile_number")
            @Expose
            private String otherMobileNumber;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("deleted_at")
            @Expose
            private String deletedAt;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getReferralUserId() {
                return referralUserId;
            }

            public void setReferralUserId(String referralUserId) {
                this.referralUserId = referralUserId;
            }

            public String getReferralMasterId() {
                return referralMasterId;
            }

            public void setReferralMasterId(String referralMasterId) {
                this.referralMasterId = referralMasterId;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getProfilePhoto() {
                return profilePhoto;
            }

            public void setProfilePhoto(String profilePhoto) {
                this.profilePhoto = profilePhoto;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
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

            public Integer getCountryCode() {
                return countryCode;
            }

            public void setCountryCode(Integer countryCode) {
                this.countryCode = countryCode;
            }

            public String getMobileNumber() {
                return mobileNumber;
            }

            public void setMobileNumber(String mobileNumber) {
                this.mobileNumber = mobileNumber;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public String getDob() {
                return dob;
            }

            public void setDob(String dob) {
                this.dob = dob;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getAboutMe() {
                return aboutMe;
            }

            public void setAboutMe(String aboutMe) {
                this.aboutMe = aboutMe;
            }

            public String getWebsite() {
                return website;
            }

            public void setWebsite(String website) {
                this.website = website;
            }

            public String getManagerName() {
                return managerName;
            }

            public void setManagerName(String managerName) {
                this.managerName = managerName;
            }

            public Integer getCountryId() {
                return countryId;
            }

            public void setCountryId(Integer countryId) {
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

            public String getDateOfOpen() {
                return dateOfOpen;
            }

            public void setDateOfOpen(String dateOfOpen) {
                this.dateOfOpen = dateOfOpen;
            }

            public String getFacebook() {
                return facebook;
            }

            public void setFacebook(String facebook) {
                this.facebook = facebook;
            }

            public String getTwitter() {
                return twitter;
            }

            public void setTwitter(String twitter) {
                this.twitter = twitter;
            }

            public String getYoutube() {
                return youtube;
            }

            public void setYoutube(String youtube) {
                this.youtube = youtube;
            }

            public String getLinkedin() {
                return linkedin;
            }

            public void setLinkedin(String linkedin) {
                this.linkedin = linkedin;
            }

            public String getMaritalStatus() {
                return maritalStatus;
            }

            public void setMaritalStatus(String maritalStatus) {
                this.maritalStatus = maritalStatus;
            }

            public String getEmailVerifiedAt() {
                return emailVerifiedAt;
            }

            public void setEmailVerifiedAt(String emailVerifiedAt) {
                this.emailVerifiedAt = emailVerifiedAt;
            }

            public String getMobileVerifiedAt() {
                return mobileVerifiedAt;
            }

            public void setMobileVerifiedAt(String mobileVerifiedAt) {
                this.mobileVerifiedAt = mobileVerifiedAt;
            }

            public String getCompanyName() {
                return companyName;
            }

            public void setCompanyName(String companyName) {
                this.companyName = companyName;
            }

            public String getUserStatus() {
                return userStatus;
            }

            public void setUserStatus(String userStatus) {
                this.userStatus = userStatus;
            }

            public Integer getWalletAmount() {
                return walletAmount;
            }

            public void setWalletAmount(Integer walletAmount) {
                this.walletAmount = walletAmount;
            }

            public Integer getSenderAmount() {
                return senderAmount;
            }

            public void setSenderAmount(Integer senderAmount) {
                this.senderAmount = senderAmount;
            }

            public Integer getReceiverAmount() {
                return receiverAmount;
            }

            public void setReceiverAmount(Integer receiverAmount) {
                this.receiverAmount = receiverAmount;
            }

            public String getSenderReferralStatus() {
                return senderReferralStatus;
            }

            public void setSenderReferralStatus(String senderReferralStatus) {
                this.senderReferralStatus = senderReferralStatus;
            }

            public String getReceiverReferralStatus() {
                return receiverReferralStatus;
            }

            public void setReceiverReferralStatus(String receiverReferralStatus) {
                this.receiverReferralStatus = receiverReferralStatus;
            }

            public String getOtherEmail() {
                return otherEmail;
            }

            public void setOtherEmail(String otherEmail) {
                this.otherEmail = otherEmail;
            }

            public String getOtherMobileNumber() {
                return otherMobileNumber;
            }

            public void setOtherMobileNumber(String otherMobileNumber) {
                this.otherMobileNumber = otherMobileNumber;
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

            public String getDeletedAt() {
                return deletedAt;
            }

            public void setDeletedAt(String deletedAt) {
                this.deletedAt = deletedAt;
            }

        }
    }

}