package com.webmingo.noonokababs.Rtrofit;


import com.webmingo.noonokababs.ModelRepo.RequestRepo.AddAddressRequest;
import com.webmingo.noonokababs.ModelRepo.RequestRepo.AddCartRequest;
import com.webmingo.noonokababs.ModelRepo.RequestRepo.ProfileUpdateReq;
import com.webmingo.noonokababs.ModelRepo.RequestRepo.ViewCartRequest;
import com.webmingo.noonokababs.ModelRepo.Responsee.CardPayentRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.CountryRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.DashboardRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.FoodFavourit.FavouritefoodsRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.FoodFavourit.FoodDetailsOfferRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.FoodFavourit.FoodDetailsRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.FoodItemRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.OTPSendRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.OTPVerificationRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.SearchCategoriesRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.SearchRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.UpdateNameAddressRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.AddNewAddressRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.CityRepoID;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.CountryRepoID;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.GetUserAddressRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.StateRepoID;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserProfileinfo;
import com.webmingo.noonokababs.ModelRepo.cart.AddToCartDetailsRepo;
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
import retrofit2.http.PATCH;
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
            @Field("otp") String otp
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

    @GET("user/logout")
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
    //  https://miraclesaba.xyz/restaurant/api/user/card/{card_id}
}
