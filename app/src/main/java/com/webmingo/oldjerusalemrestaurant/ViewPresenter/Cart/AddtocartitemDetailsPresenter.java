package com.webmingo.oldjerusalemrestaurant.ViewPresenter.Cart;

import android.content.Context;

import com.webmingo.oldjerusalemrestaurant.ModelRepo.cart.AddToCartDetailsRepo;
import com.webmingo.oldjerusalemrestaurant.Rtrofit.ApiManager;

import org.json.JSONObject;

import retrofit2.Call;

import retrofit2.Callback;
import retrofit2.Response;

public class AddtocartitemDetailsPresenter {

    private AddtoCartDetailsView view;

    public AddtocartitemDetailsPresenter(AddtoCartDetailsView view) {
        this.view = view;
    }


    public void AddToCart(Context context, String id) {
        Call<AddToCartDetailsRepo> loginCall = ApiManager.getApi(context).AddToCart(id);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<AddToCartDetailsRepo>() {
            @Override
            public void onResponse(Call<AddToCartDetailsRepo> call, Response<AddToCartDetailsRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {

                    view.onaddtocartSuccess(response.body(), response.message());

                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onAddtoCartDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onAddtoCartDetailsError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onAddtoCartDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onAddtoCartDetailsError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<AddToCartDetailsRepo> call, Throwable t) {
                view.onAddtoCartDetailsFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface AddtoCartDetailsView {
        void onAddtoCartDetailsError(String message);

        void showHideProgress(boolean isShow);

        void onAddtoCartDetailsFailure(Throwable t);

        void onaddtocartSuccess(AddToCartDetailsRepo response, String message);


    }
}
