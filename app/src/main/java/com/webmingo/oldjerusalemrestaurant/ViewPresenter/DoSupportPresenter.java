package com.webmingo.oldjerusalemrestaurant.ViewPresenter;


import android.content.Context;

import com.webmingo.oldjerusalemrestaurant.ModelRepo.RequestRepo.SupportReq;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.SupportRepo;
import com.webmingo.oldjerusalemrestaurant.Rtrofit.ApiManager;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoSupportPresenter {

    private DoSupportView view;

    public DoSupportPresenter(DoSupportView view) {
        this.view = view;
    }


   
    public void SearchFoodItem(Context context, SupportReq  supportReq) {
        view.showHideProgress(true);
        Call<SupportRepo> loginCall = ApiManager.getApi(context).support(supportReq);
        loginCall.enqueue(new Callback<SupportRepo>() {
            @Override
            public void onResponse(Call<SupportRepo> call, Response<SupportRepo> response) {
                view.showHideProgress(false);


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoSupportSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDoSupportError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoSupportError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onDoSupportError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoSupportError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<SupportRepo> call, Throwable t) {
                view.onDoSupportFailure(t);
                view.showHideProgress(false);

            }
        });

    }

  


    public interface DoSupportView {

        void onDoSupportError(String message);

        void onDoSupportSuccess(SupportRepo response, String message);


        void showHideProgress(boolean isShow);

        void onDoSupportFailure(Throwable t);
    }
}
