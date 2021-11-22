package com.webmingo.noonokababs.ViewPresenter.UserAddressBook;


import android.content.Context;

import com.webmingo.noonokababs.ModelRepo.RequestRepo.AddAddressRequest;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.CityRepoID;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.CountryRepoID;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.AddNewAddressRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.StateRepoID;
import com.webmingo.noonokababs.Rtrofit.ApiManager;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUserAddressPresenter {

    private AddUserAddressView view;

    public AddUserAddressPresenter(AddUserAddressView view) {
        this.view = view;
    }


    public void AddNewAddress(Context context, AddAddressRequest addAddressRequest) {
        Call<AddNewAddressRepo> loginCall = ApiManager.getApi(context).AddNewAddress(addAddressRequest);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<AddNewAddressRepo>() {
            @Override
            public void onResponse(Call<AddNewAddressRepo> call, Response<AddNewAddressRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onAddAddressSuccess(response.body(), response.message());
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
            public void onFailure(Call<AddNewAddressRepo> call, Throwable t) {
                view.onGetUserAddressFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public void GetCountryID(Context context, String CountryCode) {
        Call<CountryRepoID> loginCall = ApiManager.getApi(context).GetCountryID(CountryCode);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<CountryRepoID>() {
            @Override
            public void onResponse(Call<CountryRepoID> call, Response<CountryRepoID> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onCountrySuccess(response.body(), response.message());
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
            public void onFailure(Call<CountryRepoID> call, Throwable t) {
                view.onGetUserAddressFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void GetStateID(Context context, String StateName) {
        Call<StateRepoID> loginCall = ApiManager.getApi(context).GetStateID(StateName);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<StateRepoID>() {
            @Override
            public void onResponse(Call<StateRepoID> call, Response<StateRepoID> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onStateSuccess(response.body(), response.message());
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
            public void onFailure(Call<StateRepoID> call, Throwable t) {
                view.onGetUserAddressFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void GetCityID(Context context, String CityName) {
        Call<CityRepoID> loginCall = ApiManager.getApi(context).GetCityID(CityName);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<CityRepoID>() {
            @Override
            public void onResponse(Call<CityRepoID> call, Response<CityRepoID> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onCitySuccess(response.body(), response.message());
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
            public void onFailure(Call<CityRepoID> call, Throwable t) {
                view.onGetUserAddressFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public interface AddUserAddressView {

        void onGetUserAddressError(String message);


        void onAddAddressSuccess(AddNewAddressRepo response, String message);

        void onCountrySuccess(CountryRepoID response, String message);

        void onStateSuccess(StateRepoID response, String message);

        void onCitySuccess(CityRepoID response, String message);


        void showHideProgress(boolean isShow);


        void onGetUserAddressFailure(Throwable t);
    }
}
