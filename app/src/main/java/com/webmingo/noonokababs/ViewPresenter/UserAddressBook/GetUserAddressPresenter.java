package com.webmingo.noonokababs.ViewPresenter.UserAddressBook;


import android.content.Context;

import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.GetUserAddressRepo;
import com.webmingo.noonokababs.Rtrofit.ApiManager;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetUserAddressPresenter {

    private GetUserAddressView view;

    public GetUserAddressPresenter(GetUserAddressView view) {
        this.view = view;
    }
    
    
    public void GetUserAddressList(Context context) {
        Call<GetUserAddressRepo> loginCall = ApiManager.getApi(context).GetUserAddressList();
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<GetUserAddressRepo>() {
            @Override
            public void onResponse(Call<GetUserAddressRepo> call, Response<GetUserAddressRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onGetUserAddressSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onGetUserAddressError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGetUserAddressError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onGetUserAddressError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGetUserAddressError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<GetUserAddressRepo> call, Throwable t) {
                view.onGetUserAddressFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void deleteAddress(Context context,String id) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).DoDeleteaddress(id);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.DeleteAddressSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onGetUserAddressError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGetUserAddressError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onGetUserAddressError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGetUserAddressError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onGetUserAddressFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public void SetasDeaultAddress(Context context,String id) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).SetasDeaultAddress(id);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.SetasDeaultAddressSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onGetUserAddressError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGetUserAddressError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onGetUserAddressError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onGetUserAddressError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onGetUserAddressFailure(t);
                view.showHideProgress(false);

            }
        });

    }
    public interface GetUserAddressView {

        void onGetUserAddressError(String message);


        void onGetUserAddressSuccess(GetUserAddressRepo response, String message);
        void DeleteAddressSuccess(ResponseBody response, String message);
        void SetasDeaultAddressSuccess(ResponseBody response, String message);


        void showHideProgress(boolean isShow);
        void onGetUserAddressFailure(Throwable t);
    }
}
