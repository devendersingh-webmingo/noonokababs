package com.webmingo.oldjerusalemrestaurant.ViewPresenter;


import android.content.Context;

import com.webmingo.oldjerusalemrestaurant.ModelRepo.RequestRepo.CreateOrderReq;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut.CreateOrderRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.Stripee.ConnectionTokenRepo;
import com.webmingo.oldjerusalemrestaurant.Rtrofit.ApiManager;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class D0PaymentTestPresenter {

    private D0PaymentView view;

    public D0PaymentTestPresenter(D0PaymentView view) {
        this.view = view;
    }
    
    
    public void DoName(Context context,String Amount) {
        Call<ConnectionTokenRepo> loginCall = ApiManager.getApi(context).GetConnectionToken(Amount);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<ConnectionTokenRepo>() {
            @Override
            public void onResponse(Call<ConnectionTokenRepo> call, Response<ConnectionTokenRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.D0PaymentSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onD0PaymentError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onD0PaymentError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onD0PaymentError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onD0PaymentError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ConnectionTokenRepo> call, Throwable t) {
                view.onD0PaymentFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public void CreateOrder(Context context , CreateOrderReq createOrderReq) {
        Call<CreateOrderRepo> loginCall = ApiManager.getApi(context).CreateOrder(createOrderReq);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<CreateOrderRepo>() {
            @Override
            public void onResponse(Call<CreateOrderRepo> call, Response<CreateOrderRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onCreateOrderSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onD0PaymentError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onD0PaymentError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onD0PaymentError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onD0PaymentError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<CreateOrderRepo> call, Throwable t) {
                view.onD0PaymentFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface D0PaymentView {

        void onD0PaymentError(String message);

 void onCreateOrderSuccess(CreateOrderRepo response, String message);


        void showHideProgress(boolean isShow);
        void D0PaymentSuccess(ConnectionTokenRepo response, String message);


        void onD0PaymentFailure(Throwable t);
    }
}
