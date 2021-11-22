package com.webmingo.noonokababs.ViewPresenter;


import android.content.Context;

import com.webmingo.noonokababs.ModelRepo.Responsee.SearchRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.SearchCategoriesRepo;
import com.webmingo.noonokababs.Rtrofit.ApiManager;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoSearchPresenter {

    private DoSearchView view;

    public DoSearchPresenter(DoSearchView view) {
        this.view = view;
    }


    public void DoSearchList(Context context,String key) {
        Call<SearchCategoriesRepo> loginCall = ApiManager.getApi(context).SearchCategories(key);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<SearchCategoriesRepo>() {
            @Override
            public void onResponse(Call<SearchCategoriesRepo> call, Response<SearchCategoriesRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoSearchSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDoSearchError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoSearchError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onDoSearchError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoSearchError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<SearchCategoriesRepo> call, Throwable t) {
                view.onDoSearchFailure(t);
                view.showHideProgress(false);

            }
        });

    }
    public void SearchFoodItem(Context context,String key) {
        Call<SearchRepo> loginCall = ApiManager.getApi(context).SearchRepo(key);
        loginCall.enqueue(new Callback<SearchRepo>() {
            @Override
            public void onResponse(Call<SearchRepo> call, Response<SearchRepo> response) {


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoFoodItemSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onDoSearchError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoSearchError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onDoSearchError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onDoSearchError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<SearchRepo> call, Throwable t) {
                view.onDoSearchFailure(t);

            }
        });

    }

  


    public interface DoSearchView {

        void onDoSearchError(String message);

        void onDoFoodItemSuccess(SearchRepo response, String message);

        void onDoSearchSuccess(SearchCategoriesRepo response, String message);

        void showHideProgress(boolean isShow);

        void onDoSearchFailure(Throwable t);
    }
}
