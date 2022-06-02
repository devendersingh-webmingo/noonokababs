package com.webmingo.oldjerusalemrestaurant.ViewPresenter;


import android.content.Context;

import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.RefoundPolicyRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.TermCondition;
import com.webmingo.oldjerusalemrestaurant.Rtrofit.ApiManager;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoTermConditionPresenter {

    private  DoTermConditionView view;

    public DoTermConditionPresenter(DoTermConditionView view) {
        this.view = view;
    }


    public void DoTermConditionVerify(Context context) {
        Call<TermCondition> loginCall = ApiManager.getApi(context).Termconditions();
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<TermCondition>() {
            @Override
            public void onResponse(Call<TermCondition> call, Response<TermCondition> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoOTPVerifySuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onTermConditionError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onTermConditionError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onTermConditionError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onTermConditionError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<TermCondition> call, Throwable t) {
                view.onTermConditionFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public void DopolicyVerify(Context context) {
        Call<TermCondition> loginCall = ApiManager.getApi(context).Policyconditions();
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<TermCondition>() {
            @Override
            public void onResponse(Call<TermCondition> call, Response<TermCondition> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoOTPVerifySuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onTermConditionError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onTermConditionError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onTermConditionError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onTermConditionError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<TermCondition> call, Throwable t) {
                view.onTermConditionFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void RefoundPolicy(Context context) {
        Call<RefoundPolicyRepo> loginCall = ApiManager.getApi(context).RefoundPolicy();
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<RefoundPolicyRepo>() {
            @Override
            public void onResponse(Call<RefoundPolicyRepo> call, Response<RefoundPolicyRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoRefoundPolicySuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onTermConditionError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onTermConditionError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onTermConditionError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onTermConditionError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<RefoundPolicyRepo> call, Throwable t) {
                view.onTermConditionFailure(t);
                view.showHideProgress(false);

            }
        });

    }



    public interface DoTermConditionView {

        void onTermConditionError(String message);


        void onDoOTPVerifySuccess(TermCondition response, String message);
        void onDoRefoundPolicySuccess(RefoundPolicyRepo response, String message);


        void showHideProgress(boolean isShow);

        void onTermConditionFailure(Throwable t);
    }
}
