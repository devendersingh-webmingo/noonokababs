package com.webmingo.noonokababs.ViewPresenter;


import android.content.Context;

import com.webmingo.noonokababs.ModelRepo.Responsee.DashboardRepo;
import com.webmingo.noonokababs.Rtrofit.ApiManager;

import org.json.JSONObject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoLogoutPresenter {

    private DoLogoutView view;

    public DoLogoutPresenter(DoLogoutView view) {
        this.view = view;
    }
    
    
    public void DoName(Context context) {
        Call<DashboardRepo> loginCall = ApiManager.getApi(context).LandingDetails();
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<DashboardRepo>() {
            @Override
            public void onResponse(Call<DashboardRepo> call, Response<DashboardRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoHomePageSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDoLogoutError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoLogoutError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onDoLogoutError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoLogoutError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<DashboardRepo> call, Throwable t) {
                view.onDoLogoutFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public void DoOTPVerify(Context context) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).DoLogout();
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoLogoutSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDoLogoutError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoLogoutError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onDoLogoutError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoLogoutError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onDoLogoutFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface DoLogoutView {

        void onDoLogoutError(String message);


        void onDoLogoutSuccess(ResponseBody response, String message);


        void showHideProgress(boolean isShow);
        void onDoHomePageSuccess(DashboardRepo response, String message);


        void onDoLogoutFailure(Throwable t);
    }
}
