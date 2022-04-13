package com.webmingo.noonokababs.Rtrofit;


import com.webmingo.noonokababs.ModelRepo.Orderhistory.AllHistoryRepo;
import com.webmingo.noonokababs.ModelRepo.Orderhistory.HistoryDetailsRepo;
import com.webmingo.noonokababs.ModelRepo.RequestRepo.AddAddressRequest;
import com.webmingo.noonokababs.ModelRepo.RequestRepo.AddCartRequest;
import com.webmingo.noonokababs.ModelRepo.RequestRepo.CreateOrderReq;
import com.webmingo.noonokababs.ModelRepo.RequestRepo.ProfileUpdateReq;
import com.webmingo.noonokababs.ModelRepo.RequestRepo.SupportReq;
import com.webmingo.noonokababs.ModelRepo.RequestRepo.ViewCartRequest;
import com.webmingo.noonokababs.ModelRepo.Responsee.CardPayentRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.CheckOut.BillingAddressRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.CheckOut.BranchsRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.CheckOut.CreateOrderRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.CheckOut.DeliveryTypes;
import com.webmingo.noonokababs.ModelRepo.Responsee.CheckOut.GetTipAmountRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.CheckOut.GetTipPercentListings;
import com.webmingo.noonokababs.ModelRepo.Responsee.CheckOut.ScheduleDateRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.CheckOut.ShippingAddressRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.CheckOut.TimeSlotsRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.CountryRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.DashboardRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.FoodFavourit.FavouritefoodsRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.FoodFavourit.FoodDetailsOfferRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.FoodFavourit.FoodDetailsRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.FoodItemRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.GetAddressIDRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.MediaRespo.GuestReviewRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.MediaRespo.MediaReviewRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.OTPSendRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.OTPVerificationRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.ReferralRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.ReferredUserListingRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.SearchCategoriesRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.SearchRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.Stripee.ConnectionTokenRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.SupportRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.TermCondition;
import com.webmingo.noonokababs.ModelRepo.Responsee.UpdateNameAddressRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.AddNewAddressRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.CityRepoID;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.CountryRepoID;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.GetUserAddressRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.StateRepoID;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserProfileinfo;
import com.webmingo.noonokababs.ModelRepo.cart.AddToCartDetailsRepo;
import com.webmingo.noonokababs.ModelRepo.cart.CouponRepo;
import com.webmingo.noonokababs.ModelRepo.cart.FoodCartViewRepo;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface UserService {


    /*  */

    /**
     * File Name: UserService.java
     * Description: This file contains classes and functions for the Api.
     *
     * @author Devender
     * Date Created: 29/09/2021
     * Date Released:
     * Created by Devender Singh
     * Contact 8287018255
     */

    @GET("countries")
    Call<CountryRepo> GetCountry(
    );


    @GET("user/profile/info")
    Call<UserProfileinfo> UserProfileinfo(
    );


    @FormUrlEncoded
    @POST("user/create")
    Call<OTPSendRepo> DoSentOtp(
            @Field("country") String country,
            @Field("phone_code") String phone_code,
            @Field("global") String global
    );

    @FormUrlEncoded
    @POST("user/verify/otp")
    Call<OTPVerificationRepo> DoVerifyOtp(
            @Field("otp") String otp,
            @Field("device_type") String Android

    );

    @FormUrlEncoded
    @POST("user/update/some/info")
    Call<UpdateNameAddressRepo> UpdateNameAddress(
            @Field("name") String name,
            @Field("address") String address,
            @Field("_method") String _method
    );


    @Multipart
    @POST("user/update/profile-photo")
    Call<UpdateNameAddressRepo> uploadPic(
            @Part MultipartBody.Part image,
            @Part("_method") RequestBody _method
    );

    @GET("user/logout/Android")
    Call<ResponseBody> DoLogout(


    );


    @POST("user/update/profile")
    Call<ResponseBody> UpdateProfileDetails(
            @Body ProfileUpdateReq profileUpdateReq
    );


    @FormUrlEncoded
    @POST("all/food-items")
    Call<FoodItemRepo> GetFoodItem(
            @Field("page") String page
    );


    @FormUrlEncoded
    @POST("all/food-items")
    Call<FoodItemRepo> SearchFoodItem(
            @Field("search") String search,
            @Field("page") String page

    );


    @GET("food-item/detail/{food_id}")
    Call<FoodDetailsRepo> FoodDetails(
            @Path("food_id") String food_id
    );

    @GET("coupons/deals/{food_id}")
    Call<FoodDetailsOfferRepo> FoodDetailsOffeer(
            @Path("food_id") String food_id
    );


    @GET("user/dashboard")
    Call<DashboardRepo> LandingDetails(

    );


    @GET("all/categories/{Key}")
    Call<SearchCategoriesRepo> SearchCategories(
            @Path("Key") String Key
    );


    @GET("user/my/favourite/foods")
    Call<FavouritefoodsRepo> Favouritefood(

    );

    @GET("user/add/favourite/{food_id}")
    Call<ResponseBody> AddorRemoveFavourite(
            @Path("food_id") String food_id
    );

    @GET("food/add-to-cart/{food_id}")
    Call<AddToCartDetailsRepo> AddToCart(
            @Path("food_id") String food_id
    );


    @GET("user/my/address-book")
    Call<GetUserAddressRepo> GetUserAddressList(

    );

    @GET("schedule/dates")
    Call<ScheduleDateRepo> GetScheduleDateList(

    );

    @GET("time/slots/{dateid}")
    Call<TimeSlotsRepo> GetTimeSlotsList(
            @Path("dateid") String dateid
    );


    @GET("user/single/address-book/{address_id}")
    Call<GetAddressIDRepo> getidAddress(
            @Path("address_id") String address_id
    );

    @GET("user/my/address-book/{address_id}")
    Call<ResponseBody> SetasDeaultAddress(
            @Path("address_id") String address_id
    );


    /*
    URL
     Replace
    */

    @POST("user/card")
    Call<ResponseBody> AddPaymentCArd(
            @Body AddCartRequest addCartRequest
    );


    @GET("user/card")
    Call<CardPayentRepo> GetCardDetails(
    );


    @GET("delivery/types")
    Call<DeliveryTypes> GetDeliveryTypes(
    );

/*
    @POST("create/stripe/connection-token")
    Call<ConnectionTokenRepo> GetConnectionToken(
    );*/


    @FormUrlEncoded
    @POST("user/card/{Key}")
    Call<ResponseBody> DeletePaymentCard(
            @Path("Key") String Key,
            @Field("_method") String _method
    );


    @POST("user/card/{Key}")
    Call<ResponseBody> UpdatePaymentCArd(
            @Path("Key") String Key,
            @Body AddCartRequest addCartRequest

    );


    @FormUrlEncoded
    @POST("user/manage/notifications/settings")
    Call<ResponseBody> NotificationSettings(
            @Field("email_status") String email_status,
            @Field("mobile_status") String mobile_status
    );


    ///Adreesss Processs

    @POST("user/my/address-book")
    Call<AddNewAddressRepo> AddNewAddress(
            @Body AddAddressRequest addAddressRequest
    );

    @POST("user/my/address-book/{Key}")
    Call<AddNewAddressRepo> UpdateAddress(
            @Path("Key") String Key,
            @Body AddAddressRequest addAddressRequest

    );


    // https://miraclesaba.xyz/restaurant/api/user/my/address-book/{address_id}

    @DELETE("user/my/address-book/{address_id}")
    Call<ResponseBody> DoDeleteaddress(@Path("address_id") String TempCart_Id);

  /*  @FormUrlEncoded
    @POST("user/my/address-book/{address_id}")
    Call<UpdateNameAddressRepo> UpdateNameAddress(
            @Field("name") String name,
            @Field("address") String address,
            @Field("_method") String _method
    );
*/

    @FormUrlEncoded
    @POST("map/related/country")
    Call<CountryRepoID> GetCountryID(
            @Field("country_code") String country_code
    );

    @FormUrlEncoded
    @POST("map/related/state")
    Call<StateRepoID> GetStateID(
            @Field("name") String name
    );

    @FormUrlEncoded
    @POST("map/related/city")
    Call<CityRepoID> GetCityID(
            @Field("name") String name
    );


    @FormUrlEncoded
    @POST("food-items/search")
    Call<SearchRepo> SearchRepo(
            @Field("search") String search
    );


    @POST("food/view/cart")
    Call<FoodCartViewRepo> FoodCartView(
            @Body ViewCartRequest viewCartRequest
    );


    @FormUrlEncoded
    @POST("user/apply/coupon")
    Call<CouponRepo> CouponApply(
            @Field("coupon_code") String coupon_code,
            @Field("order_amount") String order_amount

    );

    @FormUrlEncoded
    @POST("user/remove/coupon")
    Call<ResponseBody> CouponRemove(

            @Field("coupon_id") String coupon_id
    );

    @POST("servicable/branchs")
    Call<BranchsRepo> GetBranchsList(
    );


    @GET("user/billing/address")
    Call<BillingAddressRepo> BillingAddresList(
    );


    @GET("user/shipping/address")
    Call<ShippingAddressRepo> ShippingAddresList(
    );


    @POST("all/food-items/{Key}")
    Call<FoodItemRepo> Categoriesitem(
            @Path("Key") String Key
    );

    @FormUrlEncoded
    @POST("user/order/give/ratings")
    Call<ResponseBody> GiveRatingOnOrder(
            @Field("order_id") String order_id,
            @Field("rating") String rating,
            @Field("feedback") String feedback

    );


    @GET("user/order/history/{type}")
    Call<AllHistoryRepo> AllHistory(
            @Path("type") String type
    );


    @GET("user/order/detail/{Order_id}")
    Call<HistoryDetailsRepo> HistoryDetails(
            @Path("Order_id") String type
    );


    @POST("user/create/order")
    Call<CreateOrderRepo> CreateOrder(
            @Body CreateOrderReq createOrderReq
    );


    @POST("support/send-query")
    Call<SupportRepo> support(
            @Body SupportReq supportReq
    );


    @FormUrlEncoded
    @POST("stripe/create-payment-intent")
    Call<ConnectionTokenRepo> GetConnectionToken(
            @Field("amount") String amount

    );


    @GET("tip/percents")
    Call<GetTipPercentListings> GetTipPercentListings(
    );


    @FormUrlEncoded
    @POST("get/tip/amount")
    Call<GetTipAmountRepo> GetTipAmount(
            @Field("amount") String amount,
            @Field("percent") String percent

    );


    @GET("home/term")
    Call<TermCondition> Termconditions(

    );


    @GET("home/policy")
    Call<TermCondition> Policyconditions(

    );


    //Refferee
    @GET("user/referral/content")
    Call<ReferralRepo> ReferralContentAPI();

    @GET("user/referred/users")
    Call<ReferredUserListingRepo> ReferredUserListingAPI();


    @GET("home/media/review")
    Call<MediaReviewRepo> MediaReview();


    @GET("home/guest/review")
    Call<GuestReviewRepo> GuestReview();


    @FormUrlEncoded
    @POST("user/update/password")
    Call<ResponseBody> UpdatePassword(
            @Field("old_passowrd") String old_passowrd,
            @Field("password") String password,
            @Field("password_confirmation") String password_confirmation,
            @Field("_method") String _method
    );


    //review
    //  https://miraclesaba.xyz/restaurant/api/user/card/{card_id}
}
