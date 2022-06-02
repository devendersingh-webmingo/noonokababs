package com.webmingo.oldjerusalemrestaurant.ViewPresenter;


import android.content.Context;

import com.webmingo.oldjerusalemrestaurant.ModelRepo.RequestRepo.ProfileUpdateReq;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.UpdateNameAddressRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.UserProfileinfo;
import com.webmingo.oldjerusalemrestaurant.Rtrofit.ApiManager;

import org.json.JSONObject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoProfileUpdateDetailsPresenter {

    private DoProfileUpdateDetailsView view;

    public DoProfileUpdateDetailsPresenter(DoProfileUpdateDetailsView view) {
        this.view = view;
    }


    public void DoDoProfileUpdateDetails(Context context, ProfileUpdateReq profileUpdateReq) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).UpdateProfileDetails(profileUpdateReq);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoProfileUpdateDetailsSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onProfileUpdateDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onProfileUpdateDetailsError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onProfileUpdateDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onProfileUpdateDetailsError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onProfileUpdateDetailsFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void UserProfileinfo(Context context) {
        Call<UserProfileinfo> loginCall = ApiManager.getApi(context).UserProfileinfo();
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<UserProfileinfo>() {
            @Override
            public void onResponse(Call<UserProfileinfo> call, Response<UserProfileinfo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoUserProfileinfoSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onProfileUpdateDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onProfileUpdateDetailsError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onProfileUpdateDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onProfileUpdateDetailsError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<UserProfileinfo> call, Throwable t) {
                view.onProfileUpdateDetailsFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void uploadImage(MultipartBody.Part image, RequestBody _method, Context context) {
        view.showHideProgress(true);
        Call<UpdateNameAddressRepo> call = ApiManager.getApi(context).uploadPic(image, _method);
        call.enqueue(new Callback<UpdateNameAddressRepo>() {
            @Override
            public void onResponse(Call<UpdateNameAddressRepo> call, Response<UpdateNameAddressRepo> response) {

                view.showHideProgress(false);

              /*  if (response.isSuccessful() && response.code() == 200 && response.body() != null) {
                    view.onUploadProfileImageSuccess(response.body(),response.message());
                } else {
                    try {
                        String errorRes = response.errorBody().string();
                        JSONObject jsonObject =new JSONObject(errorRes);
                        String err_msg  = jsonObject.getString("error");
                        int status= jsonObject.getInt("status");
                        view.onUpdateNameAddressError(err_msg);
                    }
                    catch (Exception ex){
                        ex.printStackTrace();
                    }




                }

*/


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onUploadProfileImageSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onProfileUpdateDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onProfileUpdateDetailsError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onProfileUpdateDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onProfileUpdateDetailsError(String.valueOf(response.code()));
                    }
                }


            }

            @Override
            public void onFailure(Call<UpdateNameAddressRepo> call, Throwable t) {
                view.showHideProgress(false);

                view.onProfileUpdateDetailsFailure(t);
            }
        });

    }


    public void DeactivateAccount(Context context) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).DeactivateAccount();
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoDeactivateAccountSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onProfileUpdateDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onProfileUpdateDetailsError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onProfileUpdateDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onProfileUpdateDetailsError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onProfileUpdateDetailsFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface DoProfileUpdateDetailsView {

        void onProfileUpdateDetailsError(String message);


        void onDoProfileUpdateDetailsSuccess(ResponseBody response, String message);

        void onDoDeactivateAccountSuccess(ResponseBody response, String message);

        void onDoUserProfileinfoSuccess(UserProfileinfo response, String message);

        void onUploadProfileImageSuccess(UpdateNameAddressRepo response, String message);


        void showHideProgress(boolean isShow);

        void onProfileUpdateDetailsFailure(Throwable t);
    }
}
