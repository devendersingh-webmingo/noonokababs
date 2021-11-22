package com.webmingo.noonokababs.ModelRepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchCategoriesRepo {
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
        @SerializedName("categories")
        @Expose
        private List<Category> categories = null;

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




        public class Category {

            @SerializedName("id")
            @Expose
            private Integer id;
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
            private Integer typeId;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("deleted_at")
            @Expose
            private Object deletedAt;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
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

            public Object getDeletedAt() {
                return deletedAt;
            }

            public void setDeletedAt(Object deletedAt) {
                this.deletedAt = deletedAt;
            }

        }

    }

}