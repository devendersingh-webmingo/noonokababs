package com.webmingo.oldjerusalemrestaurant.ViewPresenter;


import android.content.Context;

import com.webmingo.oldjerusalemrestaurant.ModelRepo.Orderhistory.HistoryDetailsRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Orderhistory.InvoiceRepo;
import com.webmingo.oldjerusalemrestaurant.Rtrofit.ApiManager;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderHistoryDetailsPresenter {

    private OrderHistoryDetailsView view;

    public OrderHistoryDetailsPresenter(OrderHistoryDetailsView view) {
        this.view = view;
    }


    public void OrderHistoryDetails(Context context, String key) {
        Call<HistoryDetailsRepo> loginCall = ApiManager.getApi(context).HistoryDetails(key);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<HistoryDetailsRepo>() {
            @Override
            public void onResponse(Call<HistoryDetailsRepo> call, Response<HistoryDetailsRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onOrderHistoryDetailsSuccess(response.body(), response.message());
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
            public void onFailure(Call<HistoryDetailsRepo> call, Throwable t) {
                view.onOrderHistoryFailure(t);
                view.showHideProgress(false);

            }
        });

    }
    public void OrderInvoiceDetails(Context context, String key) {
        Call<InvoiceRepo> loginCall = ApiManager.getApi(context).InvoiceDetails(key);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<InvoiceRepo>() {
            @Override
            public void onResponse(Call<InvoiceRepo> call, Response<InvoiceRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onOrderInvoiceSuccess(response.body(), response.message());
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
            public void onFailure(Call<InvoiceRepo> call, Throwable t) {
                view.onOrderHistoryFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface OrderHistoryDetailsView {

        void onOrderHistoryError(String message);

        void onOrderHistoryDetailsSuccess(HistoryDetailsRepo response, String message);
        void onOrderInvoiceSuccess(InvoiceRepo response, String message);


        void showHideProgress(boolean isShow);

        void onOrderHistoryFailure(Throwable t);
    }
}
