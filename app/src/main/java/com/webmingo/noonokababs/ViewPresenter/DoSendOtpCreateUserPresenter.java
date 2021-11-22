package com.webmingo.noonokababs.ViewPresenter;


import android.content.Context;

import com.webmingo.noonokababs.ModelRepo.Responsee.OTPSendRepo;
import com.webmingo.noonokababs.Rtrofit.ApiManager;

import org.json.JSONObject;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoSendOtpCreateUserPresenter {

    private DoSendOtpCreateUserView view;

    public DoSendOtpCreateUserPresenter(DoSendOtpCreateUserView view) {
        this.view = view;
    }


    public void DoSendOtpCreateUser(Context context,String country,String phone_code,String global) {
        Call<OTPSendRepo> loginCall = ApiManager.getApi(context).DoSentOtp(country,phone_code,global);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<OTPSendRepo>() {
            @Override
            public void onResponse(Call<OTPSendRepo> call, Response<OTPSendRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoSendOtpCreateUserSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onCountryError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onCountryError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onCountryError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onCountryError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<OTPSendRepo> call, Throwable t) {
                view.onCountryFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface DoSendOtpCreateUserView {

        void onCountryError(String message);


        void onDoSendOtpCreateUserSuccess(OTPSendRepo response, String message);

        void showHideProgress(boolean isShow);

        void onCountryFailure(Throwable t);
    }
}
