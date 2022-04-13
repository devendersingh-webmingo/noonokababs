package com.webmingo.noonokababs.ViewPresenter;


import android.content.Context;

import com.webmingo.noonokababs.ModelRepo.Responsee.ReferralRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.ReferredUserListingRepo;
import com.webmingo.noonokababs.Rtrofit.ApiManager;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReferredPresenter {

    private DoReferredView view;

    public ReferredPresenter(DoReferredView view) {
        this.view = view;
    }
    public void ReferralContentAPI(Context context) {
        view.showHideProgress(true);
        Call<ReferralRepo> loginCall = ApiManager.getApi(context).ReferralContentAPI();
        loginCall.enqueue(new Callback<ReferralRepo>() {
            @Override
            public void onResponse(Call<ReferralRepo> call, Response<ReferralRepo> response) {
                view.showHideProgress(false);


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoReferredSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDoReferredError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoReferredError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onDoReferredError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoReferredError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ReferralRepo> call, Throwable t) {
                view.onDoReferredFailure(t);
                view.showHideProgress(false);

            }
        });

    }
    public void ReferredUserList(Context context) {
        view.showHideProgress(true);
        Call<ReferredUserListingRepo> loginCall = ApiManager.getApi(context).ReferredUserListingAPI();
        loginCall.enqueue(new Callback<ReferredUserListingRepo>() {
            @Override
            public void onResponse(Call<ReferredUserListingRepo> call, Response<ReferredUserListingRepo> response) {
                view.showHideProgress(false);


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoReferredUserListSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDoReferredError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoReferredError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onDoReferredError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoReferredError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ReferredUserListingRepo> call, Throwable t) {
                view.onDoReferredFailure(t);
                view.showHideProgress(false);

            }
        });

    }

  


    public interface DoReferredView {

        void onDoReferredError(String message);

        void onDoReferredSuccess(ReferralRepo response, String message);

        void onDoReferredUserListSuccess(ReferredUserListingRepo response, String message);

        void showHideProgress(boolean isShow);

        void onDoReferredFailure(Throwable t);
    }
}
