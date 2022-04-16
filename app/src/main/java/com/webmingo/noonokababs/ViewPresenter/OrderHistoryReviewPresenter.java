package com.webmingo.noonokababs.ViewPresenter;


import android.content.Context;

import com.webmingo.noonokababs.ModelRepo.FooddetailRateRepo;

import com.webmingo.noonokababs.ModelRepo.RequestRepo.OrderReviewReq;
import com.webmingo.noonokababs.Rtrofit.ApiManager;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderHistoryReviewPresenter {

    private DoReviewView view;

    public OrderHistoryReviewPresenter(DoReviewView view) {
        this.view = view;
    }

    public void FooddetailRate(Context context, String id) {
        view.showHideProgress(true);
        Call<FooddetailRateRepo> loginCall = ApiManager.getApi(context).FooddetailRate(id);
        loginCall.enqueue(new Callback<FooddetailRateRepo>() {
            @Override
            public void onResponse(Call<FooddetailRateRepo> call, Response<FooddetailRateRepo> response) {
                view.showHideProgress(false);


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoFooddetailRateSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDoReviewError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoReviewError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onDoReviewError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoReviewError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<FooddetailRateRepo> call, Throwable t) {
                view.onDoReviewFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void onDoOrderReview(Context context, String id, OrderReviewReq reviewReq) {
        view.showHideProgress(true);
        Call<ResponseBody> loginCall = ApiManager.getApi(context).OrderReviewReq(id, reviewReq);
        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoOrderReviewSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDoReviewError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoReviewError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onDoReviewError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoReviewError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onDoReviewFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface DoReviewView {

        void onDoReviewError(String message);

        void onDoFooddetailRateSuccess(FooddetailRateRepo response, String message);

        void onDoOrderReviewSuccess(ResponseBody response, String message);


        void showHideProgress(boolean isShow);

        void onDoReviewFailure(Throwable t);
    }
}
