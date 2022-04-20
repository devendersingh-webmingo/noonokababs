package com.webmingo.noonokababs.Fragments.BottomNavFragment.Cart;

import static android.content.Context.MODE_PRIVATE;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.webmingo.noonokababs.Adapters.cart.CheckOut.ItemOnCheckOutAdapter;
import com.webmingo.noonokababs.Adapters.cart.RequriedItemCartAdapter;
import com.webmingo.noonokababs.MainActivity;
import com.webmingo.noonokababs.ModelRepo.RequestRepo.ViewCartRequest;
import com.webmingo.noonokababs.ModelRepo.Responsee.FoodFavourit.FoodDetailsOfferRepo;
import com.webmingo.noonokababs.ModelRepo.cart.CouponRepo;
import com.webmingo.noonokababs.ModelRepo.cart.FoodCartViewRepo;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.SharedPrefernce.CheckAmount;
import com.webmingo.noonokababs.SharedPrefernce.SharedPrefManager;
import com.webmingo.noonokababs.SharedPrefernce.ViewCartReqSharedPreferenc;
import com.webmingo.noonokababs.ViewPresenter.Cart.FoodCartPresenter;
import com.webmingo.noonokababs.ViewPresenter.DoProfileUpdateDetailsPresenter;
import com.webmingo.noonokababs.databinding.FragmentCheckOutCartBinding;
import com.webmingo.noonokababs.dialogue.ChangepasswordBottom;
import com.webmingo.noonokababs.dialogue.CustomDialog;
import com.webmingo.noonokababs.dialogue.NotificationsBottom;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import de.mateware.snacky.Snacky;
import okhttp3.ResponseBody;

public class CheckOutCartFragment extends Fragment implements FoodCartPresenter.FoodCartView, ItemOnCheckOutAdapter.ItemCartclick {

    FragmentCheckOutCartBinding binding;
    private View view;
    FoodCartPresenter presenter;


    String offer_price, total_price;


    String CouponId, coupon_discount = "";
    ViewCartRequest viewCartRequest1;
    ArrayList<ViewCartRequest.Cart> Cartlist = new ArrayList<>();
    ArrayList<Integer> ingredients = new ArrayList<>();
    ArrayList<ViewCartRequest.Cart.Addon> Addonlist = new ArrayList<>();


    NavController navController;

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_check_out_cart, container, false);
        view = binding.getRoot();
        presenter = new FoodCartPresenter(this);

        binding.cartdetaillayout.AddToCartTv.setText("Checkout");

        binding.cartdetaillayout.toalamont.setText("Grand Total");

        binding.cartdetaillayout.AddToCartTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (SharedPrefManager.getInstance(getContext()).isLoggedIn()) {
                    navController.navigate(R.id.chackoutFragment);

                } else {
                    CustomDialog logindialog = new CustomDialog(getContext());
                    logindialog.setLoginDialog();

                }

            }
        });
        binding.apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String promcode = binding.etPromo.getText().toString().trim();

                if (promcode.isEmpty()) {
                    Snacky.builder()
                            .setActivity(getActivity())
                            .setText("Enter Coupon code")
                            .setTextColor(getResources().getColor(R.color.white))
                            .warning()
                            .show();
                } else {


                    Toast.makeText(getContext(), offer_price + "", Toast.LENGTH_SHORT).show();
                    presenter.CouponApply(getContext(), promcode, offer_price);
                }
            }
        });

        binding.Remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.CouponRemove(getContext(), CouponId);


            }
        });




        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString("viewCartRequest", "");
        viewCartRequest1 = gson.fromJson(json, ViewCartRequest.class);

        if (viewCartRequest1 != null) {

            presenter.FoodAddToCart(getContext(), viewCartRequest1);
            Log.e("ViewCartRequuesting", viewCartRequest1.cart.toString());


        }


        return binding.getRoot();
    }

    @Override
    public void onFoodCartDetailsError(String message) {


        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();

        Toast.makeText(getContext(), message + "", Toast.LENGTH_LONG).show();

    }

    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showRequestDialog(getActivity());
            binding.PayoutdetailLL.setVisibility(View.GONE);

        } else {
            AppTools.hideDialog();

            binding.PayoutdetailLL.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public void onFoodCartDetailsFailure(Throwable t) {


        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();

        Toast.makeText(getContext(), t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onFoodCartSuccess(FoodCartViewRepo response, String message) {


        Log.e("tax_percent", response.getData().getTaxPercent());
        if (message.equalsIgnoreCase("ok")) {
            presenter.DoFoodoffer(getContext(),"");
            binding.mrp.setText("$ " + response.getData().getMrpTotalAmount());
            binding.prediscount.setText("$ " + response.getData().getPreDiscountAmount());
            binding.subtotal.setText("$ " + response.getData().getSubTotalAmount());
            binding.taxname.setText(response.getData().getTaxName() + "(" + response.getData().getTaxPercent() + "%):");
            binding.txt.setText("$ " + response.getData().getTaxAmount());
            binding.total.setText("$ " + response.getData().getBillingAmount());
            //   offer_price = response.getData().getBillingAmount();
            offer_price = response.getData().getSubTotalAmount();

            CheckAmount checkAmount = new CheckAmount(response.getData().getMrpTotalAmount(),
                    response.getData().getPreDiscountAmount()
                    , response.getData().getCouponDiscountAmount(),
                    response.getData().getSubTotalAmount(),
                    response.getData().getTaxAmount(),
                    response.getData().getBillingAmount(),
                    CouponId, coupon_discount, response.getData().getTaxName(), response.getData().getTaxPercent(), response.getData().getTotal_discount_amount());


            SharedPrefManager.getInstance(getContext())
                    .SavecheckOutAmount(checkAmount);

            binding.cartdetaillayout.TotalPrice.setText("$ " + offer_price);


            if (!SharedPrefManager.getInstance(getContext()).getcoupon_discount().equalsIgnoreCase("")) {
                binding.coupondiscountRL.setVisibility(View.VISIBLE);
                binding.coupondiscount.setText("$ " + coupon_discount);
            }
            if (response.getData().getCartDetails().size() > 0) {
                Log.e("FoodCartViewRepoFoodC", String.valueOf(response.getData().getCartDetails().get(0).getAddons().size()));


                ItemOnCheckOutAdapter gameAdapter = new ItemOnCheckOutAdapter(response, getContext(), this);
                RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                binding.productlistRV.setLayoutManager(mLayoutManager1);
                binding.productlistRV.setItemAnimator(new DefaultItemAnimator());
                binding.productlistRV.setAdapter(gameAdapter);

            } else {


            }

        }

    }

    @Override
    public void onDoFoodOfferSuccess(FoodDetailsOfferRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {

            if (response.getData().getCoupons().get(0).getCode() != null) {

                binding.AvailableCoupons.setVisibility(View.VISIBLE);
                binding.coupondetails.setVisibility(View.VISIBLE);
                binding.coupondetails.setText("GRAB " + response.getData().getCoupons().get(0).getDiscount() +
                        "% Off! Use coupon " + response.getData().getCoupons().get(0).getCode() + " for your first "
                        + response.getData().getCoupons().get(0).getUsages() + " order"
                );

                binding.coupondetails.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        binding.etPromo.setText( response.getData().getCoupons().get(0).getCode());

                    }
                });

            }

        }


    }

    @Override
    public void onCouponApplySuccess(CouponRepo response, String message) {
       /* Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
*/
        if (message.equalsIgnoreCase("ok")) {
            binding.removeLL.setVisibility(View.VISIBLE);

            binding.applyLL.setVisibility(View.GONE);
            CouponId = String.valueOf(response.getData().getCouponDetails().getId());

            Log.e("responseresponse", response.getData().toString());

            coupon_discount = String.valueOf(response.getData().getDiscountAmount());
            binding.coupondiscount.setText("$ " + coupon_discount);

            double total_pricee = Double.valueOf(offer_price) - Double.valueOf(coupon_discount);
            total_price = new DecimalFormat("##.##").format(total_pricee);
            binding.cartdetaillayout.TotalPrice.setText("$ " + total_price);
            Sneaker.with(getActivity())
                    .setTitle(response.getMessage())
                    .setMessage("")
                    .sneakSuccess();
            ViewCartRequest viewCartRequest2 = new ViewCartRequest(viewCartRequest1.cart, coupon_discount);
            presenter.FoodAddToCart(getContext(), viewCartRequest2);
            //presenter.FoodAddToCart(getContext(), viewCartRequest1);
            Log.e("onCouponApplySuccess", viewCartRequest1.cart.toString());


            //  Toast.makeText(getContext(), response.getData().getOfferedAmount() + "", Toast.LENGTH_SHORT).show();


        }

    }

    @Override
    public void onCouponRemoveSuccess(ResponseBody response, String message) {

        if (message.equalsIgnoreCase("ok")) {
            Snacky.builder()
                    .setActivity(getActivity())
                    .setText("Coupon removed successfully.")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
            binding.removeLL.setVisibility(View.GONE);
            binding.applyLL.setVisibility(View.VISIBLE);

            Log.e("coupon_discount", coupon_discount);

            double total_pricee = Double.valueOf(total_price) + Double.valueOf(coupon_discount);
            Log.e("totalpriceetot", String.valueOf(offer_price));
            Log.e("coupon_discount", String.valueOf(coupon_discount));


            total_price = new DecimalFormat("##.##").format(total_pricee);
            Log.e("total_price", String.valueOf(total_price));
            binding.cartdetaillayout.TotalPrice.setText("$ " + total_price);
            coupon_discount = "";
            binding.coupondiscount.setText("$ 0");

            presenter.FoodAddToCart(getContext(), viewCartRequest1);
            Log.e("onCouponRemoveSuccess", viewCartRequest1.cart.toString());


        }

    }

    @Override
    public void IncreaseQuentity(String Quentity, int position, FoodCartViewRepo
            addToCartDetailsRepo) {

        //cartList=viewCartRequest1.getCart();
        if (viewCartRequest1.getCart().size() > 0) {
            Toast.makeText(getContext(), viewCartRequest1.getCart().size() + "", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getContext(), cartList.size() + "", Toast.LENGTH_SHORT).show();
            for (int i = 0; i < viewCartRequest1.getCart().size(); i++) {
                if (addToCartDetailsRepo.getData().getCartDetails().get(position).getFood().getId() == Integer.parseInt(viewCartRequest1.getCart().get(i).getFoodId())) {
                    Toast.makeText(getContext(), addToCartDetailsRepo.getData().getCartDetails().get(position).getFood().getId() + "", Toast.LENGTH_SHORT).show();

                    if (viewCartRequest1.getCart().get(i).getIngredients().size() > 0) {
                        ingredients.clear();
                        for (int j = 0; j < viewCartRequest1.getCart().get(i).getIngredients().size(); j++) {
                            ingredients.add(viewCartRequest1.getCart().get(i).getIngredients().get(j));
                        }
                    }
                    if (viewCartRequest1.getCart().get(i).getAddons().size() > 0) {
                        Addonlist.clear();
                        for (int j = 0; j < viewCartRequest1.getCart().get(i).getAddons().size(); j++) {
                            ViewCartRequest.Cart.Addon addon = new ViewCartRequest.Cart.Addon(viewCartRequest1.getCart().get(i).getAddons().get(j).getId(),
                                    viewCartRequest1.getCart().get(i).getAddons().get(j).getQuantity());
                            Addonlist.add(addon);
                           /* Addonlist.add(viewCartRequest1.getCart().get(i).getAddons().get(j).getId(),
                                    viewCartRequest1.getCart().get(i).getAddons().get(j).getQuantity());*/
                        }
                    }

                    ViewCartRequest.Cart cart = new ViewCartRequest.Cart(viewCartRequest1.getCart().get(i).getFoodId(), Quentity, viewCartRequest1.getCart().get(i).getVarientId(), viewCartRequest1.getCart().get(i).getRequiredItemId(), viewCartRequest1.getCart().get(i).getCookingLevels(), ingredients, Addonlist, viewCartRequest1.getCart().get(i).getSpecialRequest());
                    //
                    // Cartlist.add(cart);

                    // Cartlist.replace(cart);


                    // Log.e("toStringtoString",viewCartRequest.toString());
                    //  Log.e("toStringtoString", viewCartRequest.getCart().toString());
                    viewCartRequest1.cart.set(i, cart);

                    presenter.FoodAddToCart(getContext(), viewCartRequest1);
                    //ViewCartRequest viewCartRequest = new ViewCartRequest(Cartlist);
                    save(viewCartRequest1);
                    Cartlist.clear();
               /*
                    presenter.FoodAddToCart(getContext(), viewCartRequest);
                    Cartlist.clear();


                    SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                    Gson gson = new Gson();
                    String json = mPrefs.getString("viewCartRequest", "");
                    ViewCartRequest viewCartRequest1 = gson.fromJson(json, ViewCartRequest.class);

*/                    // Toast.makeText(getContext(), Quentity + "", Toast.LENGTH_SHORT).show();

                }

            }

        }


    }


    @Override
    public void DecressQuentity(String Quentity, int position, FoodCartViewRepo
            addToCartDetailsRepo) {

        Toast.makeText(getContext(), Quentity + "", Toast.LENGTH_SHORT).show();
        if (viewCartRequest1.getCart().size() > 0) {
            Toast.makeText(getContext(), viewCartRequest1.getCart().size() + "", Toast.LENGTH_SHORT).show();
            // Toast.makeText(getContext(), cartList.size() + "", Toast.LENGTH_SHORT).show();
            for (int i = 0; i < viewCartRequest1.getCart().size(); i++) {
                if (addToCartDetailsRepo.getData().getCartDetails().get(position).getFood().getId() == Integer.parseInt(viewCartRequest1.getCart().get(i).getFoodId())) {
                    Toast.makeText(getContext(), addToCartDetailsRepo.getData().getCartDetails().get(position).getFood().getId() + "", Toast.LENGTH_SHORT).show();

                    if (viewCartRequest1.getCart().get(i).getIngredients().size() > 0) {
                        ingredients.clear();
                        for (int j = 0; j < viewCartRequest1.getCart().get(i).getIngredients().size(); j++) {
                            ingredients.add(viewCartRequest1.getCart().get(i).getIngredients().get(j));
                        }
                    }
                    if (viewCartRequest1.getCart().get(i).getAddons().size() > 0) {
                        Addonlist.clear();
                        for (int j = 0; j < viewCartRequest1.getCart().get(i).getAddons().size(); j++) {
                            ViewCartRequest.Cart.Addon addon = new ViewCartRequest.Cart.Addon(viewCartRequest1.getCart().get(i).getAddons().get(j).getId(),
                                    viewCartRequest1.getCart().get(i).getAddons().get(j).getQuantity());
                            Addonlist.add(addon);
                           /* Addonlist.add(viewCartRequest1.getCart().get(i).getAddons().get(j).getId(),
                                    viewCartRequest1.getCart().get(i).getAddons().get(j).getQuantity());*/
                        }
                    }

                    ViewCartRequest.Cart cart = new ViewCartRequest.Cart(viewCartRequest1.getCart().get(i).getFoodId(), Quentity, viewCartRequest1.getCart().get(i).getVarientId(), viewCartRequest1.getCart().get(i).getRequiredItemId(), viewCartRequest1.getCart().get(i).getCookingLevels(), ingredients, Addonlist, viewCartRequest1.getCart().get(i).getSpecialRequest());
                    //
                    // Cartlist.add(cart);
                    //ViewCartRequest viewCartRequest = new ViewCartRequest(Cartlist);
                    // save(viewCartRequest);
                    // Log.e("toStringtoString",viewCartRequest.toString());
                    //Log.e("toStringtoString", viewCartRequest.getCart().toString());
                    // presenter.FoodAddToCart(getContext(), viewCartRequest);
                    //  Cartlist.clear();


                    viewCartRequest1.cart.set(i, cart);
                    presenter.FoodAddToCart(getContext(), viewCartRequest1);
                    //ViewCartRequest viewCartRequest = new ViewCartRequest(Cartlist);
                    save(viewCartRequest1);
                    Cartlist.clear();


               /*
                    presenter.FoodAddToCart(getContext(), viewCartRequest);
                    Cartlist.clear();


                    SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                    Gson gson = new Gson();
                    String json = mPrefs.getString("viewCartRequest", "");
                    ViewCartRequest viewCartRequest1 = gson.fromJson(json, ViewCartRequest.class);

*/                    // Toast.makeText(getContext(), Quentity + "", Toast.LENGTH_SHORT).show();

                }

            }

        }


    }

    @Override
    public void CartRemovedItem(String Quentity, int position, FoodCartViewRepo addToCartDetailsRepo) {
        // Toast.makeText(getContext(), "Removed Item", Toast.LENGTH_SHORT).show();


        AlertDialogBox(position, addToCartDetailsRepo);


    }

    public void AlertDialogBox(int position, FoodCartViewRepo addToCartDetailsRepo) {

        //Logout
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());

        // set title
        alertDialogBuilder.setTitle("Are you sure?");

        // set dialog message
        alertDialogBuilder.setIcon(R.drawable.ic_alert);
        alertDialogBuilder
                .setMessage("Remove This Food Item From Cart.\n")
                .setCancelable(false)
                .setPositiveButton(Html.fromHtml("<font color='#2B2B2B'>Ok</font>"), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {




                       /* SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                        SharedPreferences.Editor prefsEditor = mPrefs.edit();
                        prefsEditor.remove("viewCartRequest");
                        prefsEditor.apply();
                        navController.navigate(R.id.home_Fragment);
*/

                        if (viewCartRequest1.getCart().size() > 0) {
                            Toast.makeText(getContext(), viewCartRequest1.getCart().size() + "", Toast.LENGTH_SHORT).show();
                            // Toast.makeText(getContext(), cartList.size() + "", Toast.LENGTH_SHORT).show();
                            for (int i = 0; i < viewCartRequest1.getCart().size(); i++) {
                                if (addToCartDetailsRepo.getData().getCartDetails().get(position).getFood().getId() == Integer.parseInt(viewCartRequest1.getCart().get(i).getFoodId())) {
                                    Toast.makeText(getContext(), addToCartDetailsRepo.getData().getCartDetails().get(position).getFood().getId() + "", Toast.LENGTH_SHORT).show();


                                    if (viewCartRequest1.getCart().size() == 1) {
                                        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                                        SharedPreferences.Editor prefsEditor = mPrefs.edit();
                                        prefsEditor.remove("viewCartRequest");
                                        prefsEditor.apply();
                                        navController.navigate(R.id.home_Fragment);
                                    } else {
                                        viewCartRequest1.cart.remove(i);
                                        presenter.FoodAddToCart(getContext(), viewCartRequest1);
                                        //ViewCartRequest viewCartRequest = new ViewCartRequest(Cartlist);
                                        save(viewCartRequest1);

                                    }


                                }

                            }

                        }


                    }
                })
                .setNegativeButton(Html.fromHtml("<font color='#2B2B2B'>Cancel</font>"), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();

                    }
                });
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();

    }

    public void save(ViewCartRequest viewCartRequest) {


        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();

        Gson gson = new Gson();
        String json = gson.toJson(viewCartRequest);
        prefsEditor.putString("viewCartRequest", json);
        prefsEditor.commit();
    }


}