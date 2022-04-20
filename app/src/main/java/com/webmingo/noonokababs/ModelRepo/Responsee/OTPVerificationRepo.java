package com.webmingo.noonokababs.ModelRepo.Responsee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OTPVerificationRepo {

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

        @SerializedName("user")
        @Expose
        private User user;
        @SerializedName("access_token")
        @Expose
        private String accessToken;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }


        public class User {

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
            private String walletAmount;
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

            public String getWalletAmount() {
                return walletAmount;
            }

            public void setWalletAmount(String walletAmount) {
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
