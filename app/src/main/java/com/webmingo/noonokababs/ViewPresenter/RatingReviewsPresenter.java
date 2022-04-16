package com.webmingo.noonokababs.ViewPresenter;


import android.content.Context;

import com.webmingo.noonokababs.Rtrofit.ApiManager;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RatingReviewsPresenter {

    private RatingReviewsView view;

    public RatingReviewsPresenter(RatingReviewsView view) {
        this.view = view;
    }


    public void RatingReview(Context context, String order_id, String rating, String feedback) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).GiveRatingOnOrder(order_id, rating, feedback);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onRatingReviewSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onRatingReviewError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onRatingReviewError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onRatingReviewError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onRatingReviewError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onRatingReviewFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface RatingReviewsView {

        void onRatingReviewError(String message);

        void onRatingReviewSuccess(ResponseBody response, String message);


        void showHideProgress(boolean isShow);

        void onRatingReviewFailure(Throwable t);
    }
}
