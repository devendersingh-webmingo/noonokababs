package com.webmingo.noonokababs.ViewPresenter;


import android.content.Context;

import com.webmingo.noonokababs.Rtrofit.ApiManager;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdatePasswordPresenter {

    private UpdatePasswordView view;

    public UpdatePasswordPresenter(UpdatePasswordView view) {
        this.view = view;
    }


    public void UpdatePassword(Context context,String oldPasword,String password,String NewPassword) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).UpdatePassword(oldPasword,password,NewPassword,"put");
        view.showHideProgress(true);

        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        view.onUpdatePasswordSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onUpdatePasswordError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onUpdatePasswordError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onUpdatePasswordError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onUpdatePasswordError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onUpdatePasswordFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface UpdatePasswordView {
        void onUpdatePasswordError(String message);
        void onUpdatePasswordSuccess(ResponseBody response, String message);
        void showHideProgress(boolean isShow);
        void onUpdatePasswordFailure(Throwable t);
    }
}
