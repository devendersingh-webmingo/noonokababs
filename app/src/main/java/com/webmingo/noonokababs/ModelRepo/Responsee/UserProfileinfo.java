package com.webmingo.noonokababs.ModelRepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserProfileinfo {


    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("code")
    @Expose
    private String code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
        @SerializedName("user_info")
        @Expose
        private UserInfo userInfo;

        public String getImageBaseUrl() {
            return imageBaseUrl;
        }

        public void setImageBaseUrl(String imageBaseUrl) {
            this.imageBaseUrl = imageBaseUrl;
        }

        public UserInfo getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfo userInfo) {
            this.userInfo = userInfo;
        }


        public class UserInfo {

            @SerializedName("id")
            @Expose
            private String id;




            @SerializedName("google_id")
            @Expose
            private String google_id;

            public String getGoogle_id() {
                return google_id;
            }

            public void setGoogle_id(String google_id) {
                this.google_id = google_id;
            }

            @SerializedName("branch_id")
            @Expose
            private String branchId;
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
            private String countryCode;
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
            private String countryId;
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
            private String walletAmount;
            @SerializedName("sender_amount")
            @Expose
            private String senderAmount;
            @SerializedName("receiver_amount")
            @Expose
            private String receiverAmount;
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
            @SerializedName("email_notification")
            @Expose
            private String emailNotification;
            @SerializedName("mobile_notification")
            @Expose
            private String mobileNotification;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("deleted_at")
            @Expose
            private String deletedAt;
            @SerializedName("get_country")
            @Expose
            private GetCountry getCountry;
            @SerializedName("get_state")
            @Expose
            private String getState;
            @SerializedName("get_city")
            @Expose
            private String getCity;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getBranchId() {
                return branchId;
            }

            public void setBranchId(String branchId) {
                this.branchId = branchId;
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

            public String getCountryCode() {
                return countryCode;
            }

            public void setCountryCode(String countryCode) {
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

            public String getCountryId() {
                return countryId;
            }

            public void setCountryId(String countryId) {
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

            public String getWalletAmount() {
                return walletAmount;
            }

            public void setWalletAmount(String walletAmount) {
                this.walletAmount = walletAmount;
            }

            public String getSenderAmount() {
                return senderAmount;
            }

            public void setSenderAmount(String senderAmount) {
                this.senderAmount = senderAmount;
            }

            public String getReceiverAmount() {
                return receiverAmount;
            }

            public void setReceiverAmount(String receiverAmount) {
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

            public String getEmailNotification() {
                return emailNotification;
            }

            public void setEmailNotification(String emailNotification) {
                this.emailNotification = emailNotification;
            }

            public String getMobileNotification() {
                return mobileNotification;
            }

            public void setMobileNotification(String mobileNotification) {
                this.mobileNotification = mobileNotification;
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

            public GetCountry getGetCountry() {
                return getCountry;
            }

            public void setGetCountry(GetCountry getCountry) {
                this.getCountry = getCountry;
            }

            public String getGetState() {
                return getState;
            }

            public void setGetState(String getState) {
                this.getState = getState;
            }

            public String getGetCity() {
                return getCity;
            }

            public void setGetCity(String getCity) {
                this.getCity = getCity;
            }


            public class GetCountry {

                @SerializedName("id")
                @Expose
                private String id;
                @SerializedName("code")
                @Expose
                private String code;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("phonecode")
                @Expose
                private String phonecode;
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

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPhonecode() {
                    return phonecode;
                }

                public void setPhonecode(String phonecode) {
                    this.phonecode = phonecode;
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


