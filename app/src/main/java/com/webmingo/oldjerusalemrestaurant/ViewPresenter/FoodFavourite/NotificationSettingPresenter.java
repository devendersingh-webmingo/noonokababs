package com.webmingo.oldjerusalemrestaurant.ViewPresenter.FoodFavourite;


import android.content.Context;

import com.webmingo.oldjerusalemrestaurant.Rtrofit.ApiManager;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationSettingPresenter {

    private NotificationSettingView view;

    public NotificationSettingPresenter(NotificationSettingView view) {
        this.view = view;
    }


    public void NotificationSetting(Context context, String email_status, String mobile_status) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).NotificationSettings(email_status, mobile_status);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onNotificationSettingSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onNotificationSettingError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onNotificationSettingError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onNotificationSettingError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onNotificationSettingError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onNotificationSettingFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface NotificationSettingView {

        void onNotificationSettingError(String message);

        void onNotificationSettingSuccess(ResponseBody response, String message);

        void showHideProgress(boolean isShow);

        void onNotificationSettingFailure(Throwable t);


    }
}
