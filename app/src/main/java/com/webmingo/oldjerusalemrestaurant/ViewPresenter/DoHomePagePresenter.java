package com.webmingo.oldjerusalemrestaurant.ViewPresenter;


import android.content.Context;

import com.webmingo.oldjerusalemrestaurant.ModelRepo.RequestRepo.ViewCartRequest;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.DashboardRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.cart.FoodCartViewRepo;
import com.webmingo.oldjerusalemrestaurant.Rtrofit.ApiManager;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoHomePagePresenter {

    private DoHomePageView view;

    public DoHomePagePresenter(DoHomePageView view) {
        this.view = view;
    }


    public void DoAddPaymentList(Context context) {
        Call<DashboardRepo> loginCall = ApiManager.getApi(context).LandingDetails();
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<DashboardRepo>() {
            @Override
            public void onResponse(Call<DashboardRepo> call, Response<DashboardRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoHomePageSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDoHomePageError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoHomePageError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onDoHomePageError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoHomePageError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<DashboardRepo> call, Throwable t) {
                view.onDoHomePageFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public void FoodAddToCart(Context context, ViewCartRequest viewCartRequest) {
        Call<FoodCartViewRepo> loginCall = ApiManager.getApi(context).FoodCartView(viewCartRequest);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<FoodCartViewRepo>() {
            @Override
            public void onResponse(Call<FoodCartViewRepo> call, Response<FoodCartViewRepo> response) {
                view.showHideProgress(false);


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {

                    view.onFoodCartSuccess(response.body(), response.message());

                } /*else {
                    view.onDoHomePageError(String.valueOf(response.code()));

                }*/
                     if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDoHomePageError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoHomePageError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onDoHomePageError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoHomePageError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<FoodCartViewRepo> call, Throwable t) {
                view.onDoHomePageFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface DoHomePageView {

        void onDoHomePageError(String message);


        void onDoHomePageSuccess(DashboardRepo response, String message);

        void showHideProgress(boolean isShow);

        void onDoHomePageFailure(Throwable t);

        void onFoodCartSuccess(FoodCartViewRepo body, String message);
    }
}
