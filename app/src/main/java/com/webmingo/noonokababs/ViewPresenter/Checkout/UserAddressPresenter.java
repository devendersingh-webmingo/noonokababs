package com.webmingo.noonokababs.ViewPresenter.Checkout;


import android.content.Context;

import com.webmingo.noonokababs.ModelRepo.RequestRepo.CreateOrderReq;
import com.webmingo.noonokababs.ModelRepo.Responsee.CheckOut.BillingAddressRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.CheckOut.BranchsRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.CheckOut.CreateOrderRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.CheckOut.DeliveryTypes;
import com.webmingo.noonokababs.ModelRepo.Responsee.CheckOut.GetTipAmountRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.CheckOut.GetTipPercentListings;
import com.webmingo.noonokababs.ModelRepo.Responsee.CheckOut.ScheduleDateRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.CheckOut.ShippingAddressRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.CheckOut.TimeSlotsRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.Stripee.ConnectionTokenRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.GetUserAddressRepo;
import com.webmingo.noonokababs.Rtrofit.ApiManager;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserAddressPresenter {

    private GetUserAddressView view;

    public UserAddressPresenter(GetUserAddressView view) {
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

    public void ShippingAddresList(Context context) {
        Call<ShippingAddressRepo> loginCall = ApiManager.getApi(context).ShippingAddresList();
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<ShippingAddressRepo>() {
            @Override
            public void onResponse(Call<ShippingAddressRepo> call, Response<ShippingAddressRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onGetShippingAddressSuccess(response.body(), response.message());
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
            public void onFailure(Call<ShippingAddressRepo> call, Throwable t) {
                view.onGetUserAddressFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void BillingAddresList(Context context) {
        Call<BillingAddressRepo> loginCall = ApiManager.getApi(context).BillingAddresList();
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<BillingAddressRepo>() {
            @Override
            public void onResponse(Call<BillingAddressRepo> call, Response<BillingAddressRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onGetBillingAddressSuccess(response.body(), response.message());
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
            public void onFailure(Call<BillingAddressRepo> call, Throwable t) {
                view.onGetUserAddressFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public void GetBranchList(Context context) {
        Call<BranchsRepo> loginCall = ApiManager.getApi(context).GetBranchsList();
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<BranchsRepo>() {
            @Override
            public void onResponse(Call<BranchsRepo> call, Response<BranchsRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onGetBranchsListSuccess(response.body(), response.message());
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
            public void onFailure(Call<BranchsRepo> call, Throwable t) {
                view.onGetUserAddressFailure(t);
                view.showHideProgress(false);

            }
        });

    }
    public void GetScheduleDateList(Context context) {
        Call<ScheduleDateRepo> loginCall = ApiManager.getApi(context).GetScheduleDateList();
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<ScheduleDateRepo>() {
            @Override
            public void onResponse(Call<ScheduleDateRepo> call, Response<ScheduleDateRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onScheduleDateListSuccess(response.body(), response.message());
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
            public void onFailure(Call<ScheduleDateRepo> call, Throwable t) {
                view.onGetUserAddressFailure(t);
                view.showHideProgress(false);

            }
        });

    }
    public void GetTimeSlotsList(Context context,String id ) {
        Call<TimeSlotsRepo> loginCall = ApiManager.getApi(context).GetTimeSlotsList(id);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<TimeSlotsRepo>() {
            @Override
            public void onResponse(Call<TimeSlotsRepo> call, Response<TimeSlotsRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onGetTimeSlotsListSuccess(response.body(), response.message());
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
            public void onFailure(Call<TimeSlotsRepo> call, Throwable t) {
                view.onGetUserAddressFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public void GetDeliveryTypes(Context context ) {
        Call<DeliveryTypes> loginCall = ApiManager.getApi(context).GetDeliveryTypes();
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<DeliveryTypes>() {
            @Override
            public void onResponse(Call<DeliveryTypes> call, Response<DeliveryTypes> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onGetDeliveryTypesSuccess(response.body(), response.message());
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
            public void onFailure(Call<DeliveryTypes> call, Throwable t) {
                view.onGetUserAddressFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void GetConnectionToken(Context context,String amount ) {
        Call<ConnectionTokenRepo> loginCall = ApiManager.getApi(context).GetConnectionToken(amount);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<ConnectionTokenRepo>() {
            @Override
            public void onResponse(Call<ConnectionTokenRepo> call, Response<ConnectionTokenRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                      //  view.onConnectionTokenSuccess(response.body(), response.message());
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
            public void onFailure(Call<ConnectionTokenRepo> call, Throwable t) {
                view.onGetUserAddressFailure(t);
                view.showHideProgress(false);

            }
        });

    }
    public void CreateOrder(Context context , CreateOrderReq createOrderReq) {
        Call<CreateOrderRepo> loginCall = ApiManager.getApi(context).CreateOrder(createOrderReq);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<CreateOrderRepo>() {
            @Override
            public void onResponse(Call<CreateOrderRepo> call, Response<CreateOrderRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onCreateOrderSuccess(response.body(), response.message());
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
            public void onFailure(Call<CreateOrderRepo> call, Throwable t) {
                view.onGetUserAddressFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void GetTipPercentListings(Context context ) {
        Call<GetTipPercentListings> loginCall = ApiManager.getApi(context).GetTipPercentListings();
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<GetTipPercentListings>() {
            @Override
            public void onResponse(Call<GetTipPercentListings> call, Response<GetTipPercentListings> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onGetTipPercentListingsSuccess(response.body(), response.message());
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
            public void onFailure(Call<GetTipPercentListings> call, Throwable t) {
                view.onGetUserAddressFailure(t);
                view.showHideProgress(false);

            }
        });

    }

    public void GetTipAmount(Context context,String amount,String percent ) {
        Call<GetTipAmountRepo> loginCall = ApiManager.getApi(context).GetTipAmount(amount,percent);
        view.showHideProgress(true);
        loginCall.enqueue(new Callback<GetTipAmountRepo>() {
            @Override
            public void onResponse(Call<GetTipAmountRepo> call, Response<GetTipAmountRepo> response) {
                view.showHideProgress(false);

                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    try {
                        view.onGetTipAmountSuccess(response.body(), response.message());
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
            public void onFailure(Call<GetTipAmountRepo> call, Throwable t) {
                view.onGetUserAddressFailure(t);
                view.showHideProgress(false);

            }
        });

    }


    public interface GetUserAddressView {
        void onGetUserAddressError(String message);

        void onGetUserAddressSuccess(GetUserAddressRepo response, String message);
        void onScheduleDateListSuccess(ScheduleDateRepo response, String message);
        void onGetShippingAddressSuccess(ShippingAddressRepo response, String message);
        void onGetBillingAddressSuccess(BillingAddressRepo response, String message);
        void onGetTimeSlotsListSuccess(TimeSlotsRepo response, String message);
        void onGetDeliveryTypesSuccess(DeliveryTypes response, String message);
        void onGetTipPercentListingsSuccess(GetTipPercentListings response, String message);
        void onGetTipAmountSuccess(GetTipAmountRepo response, String message);


        void onGetBranchsListSuccess(BranchsRepo response, String message);
        void onCreateOrderSuccess(CreateOrderRepo response, String message);
       /* void onConnectionTokenSuccess(ConnectionTokenRepo response, String message);*/


        void showHideProgress(boolean isShow);
        void onGetUserAddressFailure(Throwable t);
    }
}
