package com.webmingo.noonokababs.ViewPresenter.FoodFavourite;


import android.content.Context;

import com.webmingo.noonokababs.ModelRepo.Responsee.FoodItemRepo;
import com.webmingo.noonokababs.Rtrofit.ApiManager;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoFoodListPresenter {

    private DoFoodListView view;

    public DoFoodListPresenter(DoFoodListView view) {
        this.view = view;
    }


    public void DoFoodCategoriesList(Context context, String Key) {
        Call<FoodItemRepo> loginCall = ApiManager.getApi(context).Categoriesitem(Key);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<FoodItemRepo>() {
            @Override
            public void onResponse(Call<FoodItemRepo> call, Response<FoodItemRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoFoodCategoriesSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDoFoodListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoFoodListError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onDoFoodListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoFoodListError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<FoodItemRepo> call, Throwable t) {
                view.onDoFoodListFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public void DoFoodList(Context context, String Page) {
        Call<FoodItemRepo> loginCall = ApiManager.getApi(context).GetFoodItem(Page);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<FoodItemRepo>() {
            @Override
            public void onResponse(Call<FoodItemRepo> call, Response<FoodItemRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoFoodListSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDoFoodListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoFoodListError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onDoFoodListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoFoodListError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<FoodItemRepo> call, Throwable t) {
                view.onDoFoodListFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public void DoAddOrRemoveFavourite(Context context, String id) {
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
                        String message = jsonObject.getString("message");


                        view.onDoAddorRemoveFavouriteSuccess(response.body(), message);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDoFoodListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoFoodListError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onDoFoodListError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoFoodListError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onDoFoodListFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface DoFoodListView {

        void onDoFoodListError(String message);

        void onDoFoodListSuccess(FoodItemRepo response, String message);

        void onDoFoodCategoriesSuccess(FoodItemRepo response, String message);


        void onDoAddorRemoveFavouriteSuccess(ResponseBody response, String message);

        void showHideProgress(boolean isShow);

        void onDoFoodListFailure(Throwable t);
    }
}
