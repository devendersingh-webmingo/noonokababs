package com.webmingo.oldjerusalemrestaurant.ViewPresenter;


import android.content.Context;

import com.webmingo.oldjerusalemrestaurant.ModelRepo.HomePageRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.RequestRepo.ViewCartRequest;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.cart.FoodCartViewRepo;
import com.webmingo.oldjerusalemrestaurant.Rtrofit.ApiManager;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoNewHomePagePresenter {

    private DoHomePageView view;

    public DoNewHomePagePresenter(DoHomePageView view) {
        this.view = view;
    }


    public void NewHomePage(Context context) {
        Call<HomePageRepo> loginCall = ApiManager.getApi(context).NewHomePage();
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<HomePageRepo>() {
            @Override
            public void onResponse(Call<HomePageRepo> call, Response<HomePageRepo> response) {
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
            public void onFailure(Call<HomePageRepo> call, Throwable t) {
                view.onDoHomePageFailure(t);
                view.showHideProgress(false);

            }
        });

    }





    public interface DoHomePageView {

        void onDoHomePageError(String message);


        void onDoHomePageSuccess(HomePageRepo response, String message);

        void showHideProgress(boolean isShow);

        void onDoHomePageFailure(Throwable t);

    }
}
