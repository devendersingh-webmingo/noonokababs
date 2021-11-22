package com.webmingo.noonokababs.ModelRepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class CardPayentRepo implements Serializable {



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

        @SerializedName("cards")
        @Expose
        private Cards cards;

        public Cards getCards() {
            return cards;
        }

        public void setCards(Cards cards) {
            this.cards = cards;
        }




        public class Cards {

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
                @SerializedName("card_number")
                @Expose
                private String cardNumber;
                @SerializedName("exp_month")
                @Expose
                private String expMonth;
                @SerializedName("exp_year")
                @Expose
                private String expYear;
                @SerializedName("cvv")
                @Expose
                private String cvv;
                @SerializedName("set_as_default")
                @Expose
                private String setAsDefault;
                @SerializedName("future_payment")
                @Expose
                private String futurePayment;
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

                public String getCardNumber() {
                    return cardNumber;
                }

                public void setCardNumber(String cardNumber) {
                    this.cardNumber = cardNumber;
                }

                public String getExpMonth() {
                    return expMonth;
                }

                public void setExpMonth(String expMonth) {
                    this.expMonth = expMonth;
                }

                public String getExpYear() {
                    return expYear;
                }

                public void setExpYear(String expYear) {
                    this.expYear = expYear;
                }

                public String getCvv() {
                    return cvv;
                }

                public void setCvv(String cvv) {
                    this.cvv = cvv;
                }

                public String getSetAsDefault() {
                    return setAsDefault;
                }

                public void setSetAsDefault(String setAsDefault) {
                    this.setAsDefault = setAsDefault;
                }

                public String getFuturePayment() {
                    return futurePayment;
                }

                public void setFuturePayment(String futurePayment) {
                    this.futurePayment = futurePayment;
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