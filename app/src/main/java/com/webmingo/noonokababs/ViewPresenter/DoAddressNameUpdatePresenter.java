package com.webmingo.noonokababs.ViewPresenter;


import android.content.Context;

import com.webmingo.noonokababs.ModelRepo.Responsee.UpdateNameAddressRepo;
import com.webmingo.noonokababs.Rtrofit.ApiManager;

import org.json.JSONObject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoAddressNameUpdatePresenter {

    private DoAddressNameUpdateView view;

    public DoAddressNameUpdatePresenter(DoAddressNameUpdateView view) {
        this.view = view;
    }


    public void DoOTPVerify(Context context,String name,String Address) {
        Call<UpdateNameAddressRepo> loginCall = ApiManager.getApi(context).UpdateNameAddress(name,Address,"put");
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<UpdateNameAddressRepo>() {
            @Override
            public void onResponse(Call<UpdateNameAddressRepo> call, Response<UpdateNameAddressRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onDoUpdateNameAddressSuccess(response.body(), response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onUpdateNameAddressError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onUpdateNameAddressError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onUpdateNameAddressError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onUpdateNameAddressError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<UpdateNameAddressRepo> call, Throwable t) {
                view.onUpdateNameAddressFailure(t);
                view.showHideProgress(false);

            }
        });

    }
    public void uploadImage(MultipartBody.Part image, RequestBody _method, Context context){
        view.showHideProgress(true);
        Call<UpdateNameAddressRepo> call = ApiManager.getApi(context).uploadPic(image,_method);
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
                        view.onUploadProfileImageSuccess(response.body(),response.message());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onUpdateNameAddressError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onUpdateNameAddressError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onUpdateNameAddressError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onUpdateNameAddressError(String.valueOf(response.code()));
                    }
                }



            }

            @Override
            public void onFailure(Call<UpdateNameAddressRepo> call, Throwable t) {
                view.showHideProgress(false);

                view.onUpdateNameAddressFailure(t);
            }
        });

    }


    public interface DoAddressNameUpdateView {

        void onUpdateNameAddressError(String message);


        void onUploadProfileImageSuccess(UpdateNameAddressRepo response, String message);

        void onDoUpdateNameAddressSuccess(UpdateNameAddressRepo response, String message);

        void showHideProgress(boolean isShow);


        void onUpdateNameAddressFailure(Throwable t);
    }
}
