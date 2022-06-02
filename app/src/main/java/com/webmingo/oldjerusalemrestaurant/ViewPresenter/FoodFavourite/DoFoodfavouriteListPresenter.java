package com.webmingo.oldjerusalemrestaurant.ViewPresenter.FoodFavourite;


import android.content.Context;

import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.FoodFavourit.FavouritefoodsRepo;
import com.webmingo.oldjerusalemrestaurant.Rtrofit.ApiManager;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoFoodfavouriteListPresenter {

    private DoFoodfavouriteListView view;

    public DoFoodfavouriteListPresenter(DoFoodfavouriteListView view) {
        this.view = view;
    }


    public void DoFoodfavouriteList(Context context) {
        Call<FavouritefoodsRepo> loginCall = ApiManager.getApi(context).Favouritefood();
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<FavouritefoodsRepo>() {
            @Override
            public void onResponse(Call<FavouritefoodsRepo> call, Response<FavouritefoodsRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoFoodfavouriteListSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDoFoodfavouriteListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoFoodfavouriteListError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onDoFoodfavouriteListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoFoodfavouriteListError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<FavouritefoodsRepo> call, Throwable t) {
                view.onDoFoodfavouriteListFailure(t);
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



                        view.onDoAddorRemoveFavouriteSuccess(response.body(), message, response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDoFoodfavouriteListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoFoodfavouriteListError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onDoFoodfavouriteListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoFoodfavouriteListError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onDoFoodfavouriteListFailure(t);
                view.showHideProgress(false);

            }
        });

    }
    public interface DoFoodfavouriteListView {

        void onDoFoodfavouriteListError(String message);
        void onDoAddorRemoveFavouriteSuccess(ResponseBody response, String message,String msg);


        void onDoFoodfavouriteListSuccess(FavouritefoodsRepo response, String message);

        void showHideProgress(boolean isShow);

        void onDoFoodfavouriteListFailure(Throwable t);
    }
}
