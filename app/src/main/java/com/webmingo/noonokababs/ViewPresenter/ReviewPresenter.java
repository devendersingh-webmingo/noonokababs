package com.webmingo.noonokababs.ViewPresenter;


import android.content.Context;


import com.webmingo.noonokababs.ModelRepo.Responsee.MediaRespo.GuestReviewRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.MediaRespo.MediaReviewRepo;
import com.webmingo.noonokababs.Rtrofit.ApiManager;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewPresenter {

    private DoReviewView view;

    public ReviewPresenter(DoReviewView view) {
        this.view = view;
    }

    public void MediaReview(Context context) {
        view.showHideProgress(true);
        Call<MediaReviewRepo> loginCall = ApiManager.getApi(context).MediaReview();
        loginCall.enqueue(new Callback<MediaReviewRepo>() {
            @Override
            public void onResponse(Call<MediaReviewRepo> call, Response<MediaReviewRepo> response) {
                view.showHideProgress(false);


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoMediaReviewSuccess(response.body(), response.message());
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
            public void onFailure(Call<MediaReviewRepo> call, Throwable t) {
                view.onDoReviewFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void GuestReview(Context context) {
        view.showHideProgress(true);
        Call<GuestReviewRepo> loginCall = ApiManager.getApi(context).GuestReview();
        loginCall.enqueue(new Callback<GuestReviewRepo>() {
            @Override
            public void onResponse(Call<GuestReviewRepo> call, Response<GuestReviewRepo> response) {
                view.showHideProgress(false);
                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoGuestReviewSuccess(response.body(), response.message());
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
            public void onFailure(Call<GuestReviewRepo> call, Throwable t) {
                view.onDoReviewFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface DoReviewView {

        void onDoReviewError(String message);

        void onDoMediaReviewSuccess(MediaReviewRepo response, String message);

        void onDoGuestReviewSuccess(GuestReviewRepo response, String message);

        void showHideProgress(boolean isShow);

        void onDoReviewFailure(Throwable t);
    }
}
