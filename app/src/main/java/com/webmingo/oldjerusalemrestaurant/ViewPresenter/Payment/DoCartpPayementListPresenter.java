package com.webmingo.oldjerusalemrestaurant.ViewPresenter.Payment;


import android.content.Context;

import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CardPayentRepo;
import com.webmingo.oldjerusalemrestaurant.Rtrofit.ApiManager;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoCartpPayementListPresenter {

    private DoCartpPayementView view;

    public DoCartpPayementListPresenter(DoCartpPayementView view) {
        this.view = view;
    }


    public void DoAddPaymentList(Context context) {
        Call<CardPayentRepo> loginCall = ApiManager.getApi(context).GetCardDetails();
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<CardPayentRepo>() {
            @Override
            public void onResponse(Call<CardPayentRepo> call, Response<CardPayentRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onCartpPayementSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onCartpPayementError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onCartpPayementError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onCartpPayementError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onCartpPayementError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<CardPayentRepo> call, Throwable t) {
                view.onCartpPayementFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void DoDeletePaymentItem(Context context ,String id) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).DeletePaymentCard(id,"DELETE");
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDeletePaymentCardSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onCartpPayementError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onCartpPayementError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onCartpPayementError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onCartpPayementError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onCartpPayementFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface DoCartpPayementView {

        void onCartpPayementError(String message);


        void onCartpPayementSuccess(CardPayentRepo response, String message);
        void onDeletePaymentCardSuccess(ResponseBody response, String message);

        void showHideProgress(boolean isShow);

        void onCartpPayementFailure(Throwable t);
    }
}
