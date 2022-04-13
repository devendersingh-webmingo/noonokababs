package com.webmingo.noonokababs.ViewPresenter;


import android.content.Context;

import com.webmingo.noonokababs.ModelRepo.Orderhistory.AllHistoryRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.SearchRepo;
import com.webmingo.noonokababs.Rtrofit.ApiManager;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderHistoryPresenter {

    private OrderHistoryView view;

    public OrderHistoryPresenter(OrderHistoryView view) {
        this.view = view;
    }


    public void AllHistoryList(Context context, String key) {
        Call<AllHistoryRepo> loginCall = ApiManager.getApi(context).AllHistory(key);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<AllHistoryRepo>() {
            @Override
            public void onResponse(Call<AllHistoryRepo> call, Response<AllHistoryRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onOrderHistorySuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onOrderHistoryError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onOrderHistoryError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onOrderHistoryError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onOrderHistoryError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<AllHistoryRepo> call, Throwable t) {
                view.onOrderHistoryFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface OrderHistoryView {

        void onOrderHistoryError(String message);

        void onOrderHistorySuccess(AllHistoryRepo response, String message);


        void showHideProgress(boolean isShow);

        void onOrderHistoryFailure(Throwable t);
    }
}
