package com.webmingo.noonokababs.ViewPresenter.FoodFavourite;


import android.content.Context;

import com.webmingo.noonokababs.ModelRepo.Responsee.FoodFavourit.FoodDetailsOfferRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.FoodFavourit.FoodDetailsRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.FoodItemRepo;
import com.webmingo.noonokababs.Rtrofit.ApiManager;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoFoodDetailsPresenter {

    private DoFoodDetailsView view;

    public DoFoodDetailsPresenter(DoFoodDetailsView view) {
        this.view = view;
    }


    public void DoFoodDetails(Context context,String foodid) {
        Call<FoodDetailsRepo> loginCall = ApiManager.getApi(context).FoodDetails(foodid);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<FoodDetailsRepo>() {
            @Override
            public void onResponse(Call<FoodDetailsRepo> call, Response<FoodDetailsRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoFoodDetailsSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDoFoodDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoFoodDetailsError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onDoFoodDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoFoodDetailsError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<FoodDetailsRepo> call, Throwable t) {
                view.onDoFoodDetailsFailure(t);
                view.showHideProgress(false);

            }
        });

    }
    public void DoFoodoffer(Context context,String foodid) {
        Call<FoodDetailsOfferRepo> loginCall = ApiManager.getApi(context).FoodDetailsOffeer(foodid);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<FoodDetailsOfferRepo>() {
            @Override
            public void onResponse(Call<FoodDetailsOfferRepo> call, Response<FoodDetailsOfferRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoFoodDetailsOfferSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDoFoodDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoFoodDetailsError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onDoFoodDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoFoodDetailsError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<FoodDetailsOfferRepo> call, Throwable t) {
                view.onDoFoodDetailsFailure(t);
                view.showHideProgress(false);

            }
        });

    }
    public void DoAddOrRemoveFavourite(Context context,String id) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).AddorRemoveFavourite(id);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {

                        String errorStr = response.body().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        String message= jsonObject.getString("message");



                        view.onDoAddorRemoveFavouriteSuccess(response.body(), message);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDoFoodDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoFoodDetailsError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onDoFoodDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoFoodDetailsError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onDoFoodDetailsFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface DoFoodDetailsView {
        void onDoFoodDetailsError(String message);
        void onDoFoodDetailsSuccess(FoodDetailsRepo response, String message);
        void onDoFoodDetailsOfferSuccess(FoodDetailsOfferRepo response, String message);
        void showHideProgress(boolean isShow);
        void onDoFoodDetailsFailure(Throwable t);
        void onDoAddorRemoveFavouriteSuccess(ResponseBody response, String message);



    }
}
