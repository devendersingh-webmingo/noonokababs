package com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.UserAddressBook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetUserAddressRepo {
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

        @SerializedName("address_books")
        @Expose
        private AddressBooks addressBooks;

        public AddressBooks getAddressBooks() {
            return addressBooks;
        }

        public void setAddressBooks(AddressBooks addressBooks) {
            this.addressBooks = addressBooks;
        }



        public class AddressBooks {

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
                @SerializedName("user_id")
                @Expose
                private Integer userId;
                @SerializedName("type")
                @Expose
                private String type;
                @SerializedName("country_id")
                @Expose
                private Integer countryId;
                @SerializedName("state_id")
                @Expose
                private Integer stateId;
                @SerializedName("city_id")
                @Expose
                private Integer cityId;
                @SerializedName("address")
                @Expose
                private String address;
                @SerializedName("landmark")
                @Expose
                private Object landmark;
                @SerializedName("pincode")
                @Expose
                private String pincode;
                @SerializedName("mobile_number")
                @Expose
                private String mobileNumber;
                @SerializedName("set_as_default")
                @Expose
                private String setAsDefault;
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

                public Integer getUserId() {
                    return userId;
                }

                public void setUserId(Integer userId) {
                    this.userId = userId;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public Integer getCountryId() {
                    return countryId;
                }

                public void setCountryId(Integer countryId) {
                    this.countryId = countryId;
                }

                public Integer getStateId() {
                    return stateId;
                }

                public void setStateId(Integer stateId) {
                    this.stateId = stateId;
                }

                public Integer getCityId() {
                    return cityId;
                }

                public void setCityId(Integer cityId) {
                    this.cityId = cityId;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public Object getLandmark() {
                    return landmark;
                }

                public void setLandmark(Object landmark) {
                    this.landmark = landmark;
                }

                public String getPincode() {
                    return pincode;
                }

                public void setPincode(String pincode) {
                    this.pincode = pincode;
                }

                public String getMobileNumber() {
                    return mobileNumber;
                }

                public void setMobileNumber(String mobileNumber) {
                    this.mobileNumber = mobileNumber;
                }

                public String getSetAsDefault() {
                    return setAsDefault;
                }

                public void setSetAsDefault(String setAsDefault) {
                    this.setAsDefault = setAsDefault;
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