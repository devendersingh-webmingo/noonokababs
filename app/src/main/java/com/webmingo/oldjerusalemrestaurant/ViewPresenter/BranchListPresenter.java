package com.webmingo.oldjerusalemrestaurant.ViewPresenter;


import android.content.Context;

import com.webmingo.oldjerusalemrestaurant.ModelRepo.RequestRepo.CreateOrderReq;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut.BillingAddressRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut.BranchsRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut.CreateOrderRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut.DeliveryTypes;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut.GetTipAmountRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut.GetTipPercentListings;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut.ScheduleDateRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut.ShippingAddressRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut.TimeSlotsRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.Stripee.ConnectionTokenRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.UserAddressBook.GetUserAddressRepo;
import com.webmingo.oldjerusalemrestaurant.Rtrofit.ApiManager;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BranchListPresenter {

    private GetUserAddressView view;

    public BranchListPresenter(GetUserAddressView view) {
        this.view = view;
    }



    public void GetBranchList(Context context) {
        Call<BranchsRepo> loginCall = ApiManager.getApi(context).GetBranchsList();
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<BranchsRepo>() {
            @Override
            public void onResponse(Call<BranchsRepo> call, Response<BranchsRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onGetBranchsListSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onGetUserAddressError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGetUserAddressError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onGetUserAddressError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGetUserAddressError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<BranchsRepo> call, Throwable t) {
                view.onGetUserAddressFailure(t);
                view.showHideProgress(false);

            }
        });

    }
    public void GetDeliveryTypes(Context context ) {
        Call<DeliveryTypes> loginCall = ApiManager.getApi(context).GetDeliveryTypes();
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<DeliveryTypes>() {
            @Override
            public void onResponse(Call<DeliveryTypes> call, Response<DeliveryTypes> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onGetDeliveryTypesSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onGetUserAddressError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGetUserAddressError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onGetUserAddressError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGetUserAddressError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<DeliveryTypes> call, Throwable t) {
                view.onGetUserAddressFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface GetUserAddressView {
        void onGetUserAddressError(String message);



        void onGetBranchsListSuccess(BranchsRepo response, String message);
        void onGetDeliveryTypesSuccess(DeliveryTypes response, String message);


        void showHideProgress(boolean isShow);
        void onGetUserAddressFailure(Throwable t);
    }
}
