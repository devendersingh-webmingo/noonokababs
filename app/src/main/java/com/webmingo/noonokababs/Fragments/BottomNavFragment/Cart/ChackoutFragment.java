package com.webmingo.noonokababs.Fragments.BottomNavFragment.Cart;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rjesture.startupkit.AppTools;
import com.stripe.android.ApiResultCallback;
import com.stripe.android.PaymentIntentResult;
import com.stripe.android.Stripe;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.payments.paymentlauncher.PaymentLauncher;
import com.stripe.android.payments.paymentlauncher.PaymentResult;
import com.stripe.android.view.CardInputWidget;
import com.webmingo.noonokababs.Activity.Authentication.LoginActivity;
import com.webmingo.noonokababs.Activity.StripePaymentGetway;
import com.webmingo.noonokababs.Adapters.AddressBookAdapter;
import com.webmingo.noonokababs.Adapters.CheckOut.BranchLitAdapter;
import com.webmingo.noonokababs.Adapters.CountrySpinnerAdapter;
import com.webmingo.noonokababs.Adapters.cart.AddonseCartAdapter;
import com.webmingo.noonokababs.MainActivity;
import com.webmingo.noonokababs.Modal.Cuntorymodel;
import com.webmingo.noonokababs.ModelRepo.RequestRepo.CreateOrderReq;
import com.webmingo.noonokababs.ModelRepo.RequestRepo.ViewCartRequest;
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
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.SharedPrefernce.SharedPrefManager;
import com.webmingo.noonokababs.ViewPresenter.Cart.FoodCartPresenter;
import com.webmingo.noonokababs.ViewPresenter.Checkout.UserAddressPresenter;
import com.webmingo.noonokababs.databinding.FragmentChackoutBinding;
import com.webmingo.noonokababs.databinding.FragmentCheckOutCartBinding;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import de.mateware.snacky.Snacky;

public class ChackoutFragment extends Fragment implements UserAddressPresenter.GetUserAddressView, BranchLitAdapter.AddressAdapterClick {

    private static final String TAG = "discounttt";
    NavController navController;
    FragmentChackoutBinding binding;
    private View view;
    UserAddressPresenter presenter;
    String delivery_type, delivery_date, delivery_time, branch, billing_address_id, shipping_address_id, payment_mode, tip_percent = " ", tip_amount = " ";
    CreateOrderReq createOrderReq;
    ViewCartRequest viewCartRequest1;


    String paymentIntentClientSecret;
    Stripe stripe;

    public ChackoutFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chackout, container, false);
        view = binding.getRoot();
        presenter = new UserAddressPresenter(this);

        presenter.GetScheduleDateList(getContext());
        presenter.GetDeliveryTypes(getContext());
        presenter.GetTipPercentListings(getContext());

        binding.nameET.setText(SharedPrefManager.getInstance(getContext()).GetName());

        binding.PhoneEt.setText(SharedPrefManager.getInstance(getContext()).Getphone());
        binding.EmailET.setText(SharedPrefManager.getInstance(getContext()).GetEmailid());

        binding.cartdetaillayout.AddToCartTv.setText("Pay Now");
        binding.cartdetaillayout.toalamont.setText("Grand Total");
        binding.cartdetaillayout.TotalPrice.setText("$ " + SharedPrefManager.getInstance(getContext()).getTotal());

        binding.taxname.setText(SharedPrefManager.getInstance(getContext()).getTaxName() + "(" + SharedPrefManager.getInstance(getContext()).getTaxPercent() + "%):");

        binding.mrp.setText("$ " + SharedPrefManager.getInstance(getContext()).getMRP());
        binding.prediscount.setText("$ " + SharedPrefManager.getInstance(getContext()).getDiscount());

        Log.e("discounttt", SharedPrefManager.getInstance(getContext()).getcoupon_discount());

        //   Toast.makeText(getContext(), SharedPrefManager.getInstance(getContext()).getcoupon_discount() + "", Toast.LENGTH_SHORT).show();

        if (!SharedPrefManager.getInstance(getContext()).getcoupon_discount().equalsIgnoreCase("")) {
            binding.coupondiscountRL.setVisibility(View.VISIBLE);
            binding.coupondiscount.setText("$ " + SharedPrefManager.getInstance(getContext()).getcoupon_discount());
        }
        binding.subtotal.setText("$ " + SharedPrefManager.getInstance(getContext()).getSubtotal());
        binding.txt.setText("$ " + SharedPrefManager.getInstance(getContext()).getTaxes());
        binding.total.setText("$ " + SharedPrefManager.getInstance(getContext()).getTotal());

        binding.ShippingAddnewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putString("id", "CheckoutpageShipping");
                navController.navigate(R.id.mapsFragment, bundle);
            }
        });
        binding.BillingAddnewAddreess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Bundle bundle = new Bundle();
                bundle.putString("id", "CheckoutpageBilling");
                navController.navigate(R.id.mapsFragment, bundle);
            }

        });
        binding.cartdetaillayout.AddToCartTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(getContext(), "On Progress", Toast.LENGTH_SHORT).show();
                checkoutvalidation();

            }
        });
        binding.GratitudeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked == true) {
                    binding.LLTippercentLayout.setVisibility(View.VISIBLE);
                    binding.GratitudeRL.setVisibility(View.VISIBLE);
                } else {
                    binding.LLTippercentLayout.setVisibility(View.GONE);
                    binding.GratitudeRL.setVisibility(View.GONE);
                    tip_percent = " ";
                    tip_amount = " ";

                }


            }
        });

        return binding.getRoot();
    }


    private void checkoutvalidation() {


        if (binding.RdPaywithstripe.isChecked()) {

            payment_mode = "stripe";
        } else if (binding.rdCOD.isChecked()) {
            payment_mode = "cod";
        }


        if (delivery_type == null) {


            Snacky.builder()
                    .setActivity(getActivity())
                    .setText(" Delivery type field must be required.\n")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        } else if (delivery_date == null) {
            Snacky.builder()
                    .setActivity(getActivity())
                    .setText(" Delivery date field must be required.\n")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        } else if (delivery_time == null) {
            Snacky.builder()
                    .setActivity(getActivity())
                    .setText(" Delivery time field must be required.\n")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        } else if (billing_address_id == null) {
            Snacky.builder()
                    .setActivity(getActivity())
                    .setText(" Please select Billing Address.\n")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        } else if (shipping_address_id == null) {
            Snacky.builder()
                    .setActivity(getActivity())
                    .setText(" Please select Shipping Address.\n")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        } else if (branch == null) {
            Snacky.builder()
                    .setActivity(getActivity())
                    .setText(" Please select branch.\n")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        } else {


            if (payment_mode.equalsIgnoreCase("cod")) {
                GetCreatOrderData();
            } else {
                //  presenter.GetConnectionToken(getContext(),SharedPrefManager.getInstance(getContext()).getTotal());
                /*

                 */

                createOrderReq = new CreateOrderReq();
                SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                Gson gson = new Gson();
                String json = mPrefs.getString("viewCartRequest", "");
                viewCartRequest1 = gson.fromJson(json, ViewCartRequest.class);
                if (viewCartRequest1 != null) {

                    //presenter.FoodAddToCart(getContext(), viewCartRequest1);
                    createOrderReq = new CreateOrderReq(
                            SharedPrefManager.getInstance(getContext()).GetName(),
                            SharedPrefManager.getInstance(getContext()).GetEmailid(),
                            SharedPrefManager.getInstance(getContext()).Getphone(),
                            branch,
                            SharedPrefManager.getInstance(getContext()).getCouponId(),
                            SharedPrefManager.getInstance(getContext()).getcoupon_discount(),
                            SharedPrefManager.getInstance(getContext()).getSubtotal()
                            , SharedPrefManager.getInstance(getContext()).getTotal(),
                            SharedPrefManager.getInstance(getContext()).getDiscount(),
                            SharedPrefManager.getInstance(getContext()).getTaxes(),
                            SharedPrefManager.getInstance(getContext()).getTaxPercent(), SharedPrefManager.getInstance(getContext()).getDiscount(), payment_mode,
                            delivery_type, "Pending", SharedPrefManager.getInstance(getContext()).GettotalDiscountAmount(), tip_percent, tip_amount, delivery_date, delivery_time, "Android", shipping_address_id, billing_address_id, " ", " ", viewCartRequest1.cart);
                    //createOrderReq.cart=viewCartRequest1.cart;
                    Log.e("ViewCartRequuesting", createOrderReq.toString());


                    Bundle bundle = new Bundle();
                    Gson gson1 = new Gson();
                    String myJson = gson1.toJson(createOrderReq);
                    bundle.putString("myjson", myJson);
                    navController.navigate(R.id.StripePyamentGetway, bundle);

                }


            }
        }


    }

    @Override
    public void onGetUserAddressError(String message) {
        Log.e("onGetUserAddressError", message);

        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();


    }

    @Override
    public void onGetUserAddressSuccess(GetUserAddressRepo response, String message) {


        if (message.equalsIgnoreCase("ok")) {

            if (response.getData().getAddressBooks().getData().size() > 0) {
                List<Cuntorymodel> list;
                list = new ArrayList<>();
                list.add(new Cuntorymodel("Select Shipping Address ", "0", "0", "0"));


                for (int i = 0; i < response.getData().getAddressBooks().getData().size(); i++) {

                    Cuntorymodel itemData = new Cuntorymodel(response.getData().getAddressBooks().getData().get(i).getAddress(),
                            String.valueOf(response.getData().getAddressBooks().getData().get(i).getId()),
                            "",
                            "");
                    list.add(itemData);

                }
                CountrySpinnerAdapter countrySpinnerAdapter = new CountrySpinnerAdapter(getContext(), R.id.coinName, list);
                binding.BillingAddressSp.setAdapter(countrySpinnerAdapter);
                binding.BillingAddressSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (list.get(position).getId().equalsIgnoreCase("0")) {

                            //  Toast.makeText(getContext(), "Not", Toast.LENGTH_SHORT).show();

                        } else {


                            // Toast.makeText(getContext(), list.get(position).getName(), Toast.LENGTH_SHORT).show();

                        }


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });


            }


        }
    }

    @Override
    public void onScheduleDateListSuccess(ScheduleDateRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {

            if (response.getData().size() > 0) {
                List<Cuntorymodel> list = new ArrayList<>();
                list.add(new Cuntorymodel("Select Date ", "0", "0", "0"));
                for (int i = 0; i < response.getData().size(); i++) {

                    Cuntorymodel itemData = new Cuntorymodel(response.getData().get(i).getShow(),
                            response.getData().get(i).getValue(),
                            "",
                            "");
                    list.add(itemData);

                }


                CountrySpinnerAdapter countrySpinnerAdapter = new CountrySpinnerAdapter(getContext(), R.id.coinName, list);
                binding.SPDate.setAdapter(countrySpinnerAdapter);
                binding.SPDate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (list.get(position).getId().equalsIgnoreCase("0")) {

                            //  Toast.makeText(getContext(), "Not", Toast.LENGTH_SHORT).show();

                        } else {

                            presenter.GetTimeSlotsList(getContext(), list.get(position).getId());

                            delivery_date = list.get(position).getId();
                            //   Toast.makeText(getContext(), list.get(position).getId(), Toast.LENGTH_SHORT).show();

                        }


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

            }


        }

    }

    @Override
    public void onGetShippingAddressSuccess(ShippingAddressRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            List<Cuntorymodel> list = new ArrayList<>();
            list.clear();
            if (response.getData().getShippings().size() > 0) {

                list.add(new Cuntorymodel("Select Shipping Address ", "0", "0", "0"));
                for (int i = 0; i < response.getData().getShippings().size(); i++) {

                    Cuntorymodel itemData = new Cuntorymodel(response.getData().getShippings().get(i).getAddress(),
                            String.valueOf(response.getData().getShippings().get(i).getId()),
                            "",
                            "");
                    list.add(itemData);

                }


                CountrySpinnerAdapter countrySpinnerAdapter = new CountrySpinnerAdapter(getContext(), R.id.coinName, list);
                binding.ShippingSp.setAdapter(countrySpinnerAdapter);
                binding.ShippingSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (list.get(position).getId().equalsIgnoreCase("0")) {

                            //  Toast.makeText(getContext(), "Not", Toast.LENGTH_SHORT).show();

                        } else {

                            // presenter.GetTimeSlotsList(getContext(), list.get(position).getId());

                            shipping_address_id = list.get(position).getId();
                            // Toast.makeText(getContext(), list.get(position).getId(), Toast.LENGTH_SHORT).show();

                        }


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

            } else {

            }


        }
    }

    @Override
    public void onGetBillingAddressSuccess(BillingAddressRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            List<Cuntorymodel> list = new ArrayList<>();
            list.clear();
            if (response.getData().getBillingss().size() > 0) {


                list.add(new Cuntorymodel("Select Billing  Address ", "0", "0", "0"));
                for (int i = 0; i < response.getData().getBillingss().size(); i++) {

                    Cuntorymodel itemData = new Cuntorymodel(response.getData().getBillingss().get(i).getAddress(),
                            String.valueOf(response.getData().getBillingss().get(i).getId()),
                            "",
                            "");
                    list.add(itemData);

                }


                CountrySpinnerAdapter countrySpinnerAdapter = new CountrySpinnerAdapter(getContext(), R.id.coinName, list);
                binding.BillingAddressSp.setAdapter(countrySpinnerAdapter);
                binding.BillingAddressSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (list.get(position).getId().equalsIgnoreCase("0")) {

                            //  Toast.makeText(getContext(), "Not", Toast.LENGTH_SHORT).show();

                        } else {

                            // presenter.GetTimeSlotsList(getContext(), list.get(position).getId());

                            presenter.GetBranchList(getContext());
                            billing_address_id = list.get(position).getId();
                            //  Toast.makeText(getContext(), list.get(position).getId(), Toast.LENGTH_SHORT).show();

                        }


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

            } else {


            }


        }
    }

    @Override
    public void onGetTimeSlotsListSuccess(TimeSlotsRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {


            if (response.getData().size() > 0) {
                List<Cuntorymodel> list = new ArrayList<>();
                list.add(new Cuntorymodel("Select Time ", "0", "0", "0"));
                for (int i = 0; i < response.getData().size(); i++) {

                    Cuntorymodel itemData = new Cuntorymodel(response.getData().get(i).getShow(),
                            String.valueOf(response.getData().get(i).getId()),
                            "",
                            "");
                    list.add(itemData);

                }


                CountrySpinnerAdapter countrySpinnerAdapter = new CountrySpinnerAdapter(getContext(), R.id.coinName, list);
                binding.SPTime.setAdapter(countrySpinnerAdapter);
                binding.SPTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        if (list.get(position).getId().equalsIgnoreCase("0")) {

                            //  Toast.makeText(getContext(), "Not", Toast.LENGTH_SHORT).show();

                        } else {

                            // presenter.GetTimeSlotsList(getContext(), list.get(position).getId());
                            delivery_time = list.get(position).getId();
                            //    Toast.makeText(getContext(), list.get(position).getId() + "", Toast.LENGTH_SHORT).show();

                        }


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });


            }


        }
    }

    @Override
    public void onGetDeliveryTypesSuccess(DeliveryTypes response, String message) {

        if (message.equalsIgnoreCase("ok")) {

            if (response.getData().getTypes().size() > 0) {
                List<Cuntorymodel> list = new ArrayList<>();
                list.clear();
                list.add(new Cuntorymodel("Choose Type", "0", "0", "0"));

                for (int i = 0; i < response.getData().getTypes().size(); i++) {

                    Cuntorymodel itemData = new Cuntorymodel(response.getData().getTypes().get(i).getName(),
                            String.valueOf(response.getData().getTypes().get(i).getValue()),
                            "",
                            "");
                    list.add(itemData);

                }


                CountrySpinnerAdapter countrySpinnerAdapter = new CountrySpinnerAdapter(getContext(), R.id.coinName, list);
                binding.SPAddresstype.setAdapter(countrySpinnerAdapter);
                //  binding.SPDate.setAdapter(countrySpinnerAdapter);
                binding.SPAddresstype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (list.get(position).getId().equalsIgnoreCase("0")) {

                            //  Toast.makeText(getContext(), "Not", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getContext(), list.get(position).getName(), Toast.LENGTH_SHORT).show();

                            if (list.get(position).getName().equalsIgnoreCase("pick up")) {

                                presenter.BillingAddresList(getContext());
                                binding.ShippingAddressLL.setVisibility(View.GONE);
                                binding.Billingll.setVisibility(View.VISIBLE);
                                delivery_type = list.get(position).getId();
                                billing_address_id = null;
                                shipping_address_id = " ";

                            } else {
                                presenter.BillingAddresList(getContext());
                                presenter.ShippingAddresList(getContext());
                                binding.Billingll.setVisibility(View.VISIBLE);
                                binding.ShippingAddressLL.setVisibility(View.VISIBLE);
                                delivery_type = list.get(position).getId();
                                billing_address_id = null;


                            }
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

            }


        }


    }

    @Override
    public void onGetTipPercentListingsSuccess(GetTipPercentListings response, String message) {
        if (message.equalsIgnoreCase("ok")) {

            if (response.getData().getPercents().size() > 0) {
                List<Cuntorymodel> list = new ArrayList<>();
                list.clear();
                list.add(new Cuntorymodel("Choose Tip ", "0", "0", "0"));

                for (int i = 0; i < response.getData().getPercents().size(); i++) {

                    Cuntorymodel itemData = new Cuntorymodel(response.getData().getPercents().get(i).getLabel(),
                            String.valueOf(response.getData().getPercents().get(i).getValue()),
                            "",
                            "");
                    list.add(itemData);

                }


                CountrySpinnerAdapter countrySpinnerAdapter = new CountrySpinnerAdapter(getContext(), R.id.coinName, list);
                binding.SPTippercent.setAdapter(countrySpinnerAdapter);
                //  binding.SPDate.setAdapter(countrySpinnerAdapter);
                binding.SPTippercent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (list.get(position).getId().equalsIgnoreCase("0")) {

                            //  Toast.makeText(getContext(), "Not", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getContext(), list.get(position).getName(), Toast.LENGTH_SHORT).show();

                            tip_percent = list.get(position).getId();
                            presenter.GetTipAmount(getContext(), SharedPrefManager.getInstance(getContext()).getTotal(), tip_percent);
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

            }


        }

    }

    @Override
    public void onGetTipAmountSuccess(GetTipAmountRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            tip_amount = response.getData().getTipAmount();
            binding.TipAmountEt.setText("$" + tip_amount);
            binding.GratuityTV.setText("$"+tip_amount);

        }

    }

    @Override
    public void onGetBranchsListSuccess(BranchsRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            if (response.getData().getBranches().size() > 0) {
                binding.branchll.setVisibility(View.VISIBLE);


                BranchLitAdapter gameAdapter = new BranchLitAdapter(response, getContext(), this);
                RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                binding.recyclerViewChooseBranch.setLayoutManager(mLayoutManager1);
                binding.recyclerViewChooseBranch.setItemAnimator(new DefaultItemAnimator());
                binding.recyclerViewChooseBranch.setAdapter(gameAdapter);


            } else {
                binding.branchll.setVisibility(View.GONE);

            }
        }


    }

    @Override
    public void onCreateOrderSuccess(CreateOrderRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {


            Log.e("onCreateOrderSuccess", response.getData().getOrderDetails().toString());
            showDialog(String.valueOf(response.getData().getOrderDetails().getOfferAmount()), response.getData().getOrderDetails().getOrderId());
        }

    }
/*

    @Override
    public void onConnectionTokenSuccess(ConnectionTokenRepo response, String message) {
        Toast.makeText(getContext(), response.getMessage() + "", Toast.LENGTH_SHORT).show();
        Log.e("ConnectionToken",response.getData().toString());



        if (message.equalsIgnoreCase("ok")) {
            Toast.makeText(getActivity(), response.getData().getClient_secret(), Toast.LENGTH_SHORT).show();
            paymentIntentClientSecret = response.getData().getClient_secret();

            // Configure the SDK with your Stripe publishable key so it can make requests to Stripe
            stripe = new Stripe(
                    getActivity().getApplicationContext(),
                    Objects.requireNonNull(response.getData().getStripe_public_key())
            );

*/
/*
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, String>>(){}.getType();
            Map<String, String> responseMap = gson.fromJson(
                    Objects.requireNonNull(response.body()).string(),
                    type
            );*//*



        }
    }
*/

    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showRequestDialog(getActivity());

        } else {
            AppTools.hideDialog();

        }
    }

    @Override
    public void onGetUserAddressFailure(Throwable t) {

        Log.e("onGetUserAddressFailure", t.getLocalizedMessage());
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void Setas(BranchsRepo repo, int pos) {
        //   Toast.makeText(getContext(), repo.getData().getBranches().get(pos).getId() + "", Toast.LENGTH_SHORT).show();

        branch = String.valueOf(repo.getData().getBranches().get(pos).getId());


    }

    private void GetCreatOrderData() {


        createOrderReq = new CreateOrderReq();
        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString("viewCartRequest", "");
        viewCartRequest1 = gson.fromJson(json, ViewCartRequest.class);
        if (viewCartRequest1 != null) {

            //presenter.FoodAddToCart(getContext(), viewCartRequest1);
            createOrderReq = new CreateOrderReq(
                    SharedPrefManager.getInstance(getContext()).GetName(),
                    SharedPrefManager.getInstance(getContext()).GetEmailid(),
                    SharedPrefManager.getInstance(getContext()).Getphone(),
                    branch,
                    SharedPrefManager.getInstance(getContext()).getCouponId(),
                    SharedPrefManager.getInstance(getContext()).getcoupon_discount(),
                    SharedPrefManager.getInstance(getContext()).getSubtotal()
                    , SharedPrefManager.getInstance(getContext()).getTotal(),
                    SharedPrefManager.getInstance(getContext()).getDiscount(),
                    SharedPrefManager.getInstance(getContext()).getTaxes(),
                    SharedPrefManager.getInstance(getContext()).getTaxPercent(), SharedPrefManager.getInstance(getContext()).getDiscount(), payment_mode,
                    delivery_type, "Pending", SharedPrefManager.getInstance(getContext()).GettotalDiscountAmount(), tip_percent, tip_amount, delivery_date, delivery_time, "Android", shipping_address_id, billing_address_id, " ", " ", viewCartRequest1.cart);
            //createOrderReq.cart=viewCartRequest1.cart;
            Log.e("ViewCartRequuesting", createOrderReq.toString());
            Log.e("tip_percent", SharedPrefManager.getInstance(getContext()).getTaxPercent());
            Log.e("tip_percenttip_percent",tip_percent);

            presenter.CreateOrder(getContext(), createOrderReq);


        }


    }

    public void showDialog(String amount, String Ordernumber) {
        TextView success, tvorderAmount, tvordernumber;
        Dialog dialog = new Dialog(getActivity(), android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.setContentView(R.layout.createordersuccess);
        dialog.setCancelable(false);
        dialog.show();
        success = dialog.findViewById(R.id.success);
        tvorderAmount = dialog.findViewById(R.id.tvorderAmount);
        tvordernumber = dialog.findViewById(R.id.tvordernumber);
        tvordernumber.setText("Order Id: " + Ordernumber);
        tvorderAmount.setText("Order Amount: $" + amount);
        success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                navController.navigate(R.id.DashboardFragment);
                SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor prefsEditor = mPrefs.edit();
                prefsEditor.remove("viewCartRequest");
                prefsEditor.apply();
            }
        });

    }


}