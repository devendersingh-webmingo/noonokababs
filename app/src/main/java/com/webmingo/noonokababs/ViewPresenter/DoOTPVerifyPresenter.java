package com.webmingo.noonokababs.ViewPresenter;


import android.content.Context;

import com.webmingo.noonokababs.ModelRepo.Responsee.OTPVerificationRepo;
import com.webmingo.noonokababs.Rtrofit.ApiManager;

import org.json.JSONObject;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoOTPVerifyPresenter {

    private DoOTPVerifyView view;

    public DoOTPVerifyPresenter(DoOTPVerifyView view) {
        this.view = view;
    }


    public void DoOTPVerify(Context context,String otp) {
        Call<OTPVerificationRepo> loginCall = ApiManager.getApi(context).DoVerifyOtp(otp,"Android");
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<OTPVerificationRepo>() {
            @Override
            public void onResponse(Call<OTPVerificationRepo> call, Response<OTPVerificationRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoOTPVerifySuccess(response.body(), response.message());
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
            public void onFailure(Call<OTPVerificationRepo> call, Throwable t) {
                view.onCountryFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface DoOTPVerifyView {

        void onCountryError(String message);


        void onDoOTPVerifySuccess(OTPVerificationRepo response, String message);

        void showHideProgress(boolean isShow);

        void onCountryFailure(Throwable t);
    }
}
