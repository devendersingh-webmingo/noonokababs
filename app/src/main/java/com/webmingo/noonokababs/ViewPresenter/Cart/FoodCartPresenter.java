package com.webmingo.noonokababs.ViewPresenter.Cart;

import android.content.Context;
import android.widget.Toast;

import com.webmingo.noonokababs.ModelRepo.RequestRepo.ViewCartRequest;
import com.webmingo.noonokababs.ModelRepo.cart.FoodCartViewRepo;
import com.webmingo.noonokababs.Rtrofit.ApiManager;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodCartPresenter {

    private FoodCartView view;

    public FoodCartPresenter(FoodCartView view) {
        this.view = view;
    }


    public void FoodAddToCart(Context context, ViewCartRequest viewCartRequest) {
        Call<FoodCartViewRepo> loginCall = ApiManager.getApi(context).FoodCartView(viewCartRequest);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<FoodCartViewRepo>() {
            @Override
            public void onResponse(Call<FoodCartViewRepo> call, Response<FoodCartViewRepo> response) {
                view.showHideProgress(false);

                view.onFoodCartDetailsError(String.valueOf(response.code()));

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {

                    view.onFoodCartSuccess(response.body(), response.message());

                } else

                {
                    view.onFoodCartDetailsError(String.valueOf(response.code()));

                }
                    /* if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onFoodCartDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onFoodCartDetailsError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onFoodCartDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onFoodCartDetailsError(String.valueOf(response.code()));
                    }
                }*/
            }

            @Override
            public void onFailure(Call<FoodCartViewRepo> call, Throwable t) {
                view.onFoodCartDetailsFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface FoodCartView {
        void onFoodCartDetailsError(String message);

        void showHideProgress(boolean isShow);

        void onFoodCartDetailsFailure(Throwable t);

        void onFoodCartSuccess(FoodCartViewRepo response, String message);


    }
}
