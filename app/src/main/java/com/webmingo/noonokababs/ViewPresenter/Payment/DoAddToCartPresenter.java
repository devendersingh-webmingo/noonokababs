package com.webmingo.noonokababs.ViewPresenter.Payment;


import android.content.Context;

import com.webmingo.noonokababs.ModelRepo.RequestRepo.AddCartRequest;

import com.webmingo.noonokababs.Rtrofit.ApiManager;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoAddToCartPresenter {

    private DoAddToCartView view;

    public DoAddToCartPresenter(DoAddToCartView view) {
        this.view = view;
    }


    public void  DoAddToCartt(Context context, AddCartRequest addCartRequest) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context). AddPaymentCArd(addCartRequest);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onAddtoCartSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onAddtoCartError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onAddtoCartError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onAddtoCartError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onAddtoCartError(String.valueOf(response.code()));
                    }
                }
                else if (response.code() == 422) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onAddtoCartError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onAddtoCartError(String.valueOf(response.code()));
                    }
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onAddtoCartFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void  DoUpdateCart(Context context, AddCartRequest addCartRequest,String id) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context). UpdatePaymentCArd(id,addCartRequest);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.OnUpdateCartSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onAddtoCartError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onAddtoCartError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onAddtoCartError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onAddtoCartError(String.valueOf(response.code()));
                    }
                }
                else if (response.code() == 422) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onAddtoCartError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onAddtoCartError(String.valueOf(response.code()));
                    }
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onAddtoCartFailure(t);
                view.showHideProgress(false);

            }
        });

    }
    public interface DoAddToCartView {

        void onAddtoCartError(String message);


        void onAddtoCartSuccess(ResponseBody response, String message);
        void OnUpdateCartSuccess(ResponseBody response, String message);

        void showHideProgress(boolean isShow);

        void onAddtoCartFailure(Throwable t);
    }
}
