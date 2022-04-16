package com.webmingo.noonokababs.ViewPresenter.Cart;

import android.content.Context;
import android.widget.Toast;

import com.webmingo.noonokababs.ModelRepo.RequestRepo.ViewCartRequest;
import com.webmingo.noonokababs.ModelRepo.cart.CouponRepo;
import com.webmingo.noonokababs.ModelRepo.cart.FoodCartViewRepo;
import com.webmingo.noonokababs.Rtrofit.ApiManager;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodCartPresenter {

    private FoodCartView view;

    public FoodCartPresenter(FoodCartView view) {
        this.view = view;
    }


    public void FoodAddToCart(Context context, ViewCartRequest viewCartRequest) {
        Call<FoodCartViewRepo> loginCall = ApiManager.getApi(context).FoodCartView(viewCartRequest);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<FoodCartViewRepo>() {
            @Override
            public void onResponse(Call<FoodCartViewRepo> call, Response<FoodCartViewRepo> response) {
                view.showHideProgress(false);


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {

                    view.onFoodCartSuccess(response.body(), response.message());

                }/* else {
                    view.onFoodCartDetailsError(String.valueOf(response.code()));

                }*/
                     if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onFoodCartDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onFoodCartDetailsError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onFoodCartDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onFoodCartDetailsError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<FoodCartViewRepo> call, Throwable t) {
                view.onFoodCartDetailsFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public void CouponApply(Context context, String Cupon, String Amount) {
        Call<CouponRepo> loginCall = ApiManager.getApi(context).CouponApply(Cupon, Amount);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<CouponRepo>() {
            @Override
            public void onResponse(Call<CouponRepo> call, Response<CouponRepo> response) {
                view.showHideProgress(false);


                //Toast.makeText(context, String.valueOf(response.code()) + "", Toast.LENGTH_SHORT).show();


                if (response.isSuccessful() && response.body() != null && response.code() == 200) {

                    view.onCouponApplySuccess(response.body(), response.message());

                }else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onFoodCartDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onFoodCartDetailsError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onFoodCartDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onFoodCartDetailsError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<CouponRepo> call, Throwable t) {
                view.onFoodCartDetailsFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void CouponRemove(Context context, String Cuponid) {
        Call<ResponseBody> loginCall = ApiManager.getApi(context).CouponRemove(Cuponid );
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                view.showHideProgress(false);

                //Toast.makeText(context, String.valueOf(response.code()) + "", Toast.LENGTH_SHORT).show();

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    view.onCouponRemoveSuccess(response.body(), response.message());
                }else if (response.code() == 500) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");
                        view.onFoodCartDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onFoodCartDetailsError(String.valueOf(response.code()));
                    }

                } else if (response.code() == 401) {
                    try {
                        String errorStr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(errorStr);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("message");

                        view.onFoodCartDetailsError(jsonObject1.getString("error"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.onFoodCartDetailsError(String.valueOf(response.code()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.onFoodCartDetailsFailure(t);
                view.showHideProgress(false);

            }
        });

    }



    public interface FoodCartView {
        void onFoodCartDetailsError(String message);

        void showHideProgress(boolean isShow);

        void onFoodCartDetailsFailure(Throwable t);

        void onFoodCartSuccess(FoodCartViewRepo response, String message);

        void onCouponApplySuccess(CouponRepo response, String message);

        void onCouponRemoveSuccess(ResponseBody response, String message);



    }
}
