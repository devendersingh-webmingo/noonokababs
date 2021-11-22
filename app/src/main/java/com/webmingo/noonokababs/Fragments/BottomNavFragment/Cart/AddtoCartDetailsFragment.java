
package com.webmingo.noonokababs.Fragments.BottomNavFragment.Cart;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.rjesture.startupkit.AppTools;
import com.webmingo.noonokababs.Activity.Authentication.LoginActivity;
import com.webmingo.noonokababs.Activity.Authentication.WelcomeActivity;
import com.webmingo.noonokababs.Activity.SpleshScreen;
import com.webmingo.noonokababs.Adapters.CountrySpinnerAdapter;
import com.webmingo.noonokababs.Adapters.NotificationAdapter;
import com.webmingo.noonokababs.Adapters.cart.AddonseCartAdapter;
import com.webmingo.noonokababs.Adapters.cart.RequriedItemCartAdapter;
import com.webmingo.noonokababs.Adapters.cart.integedientItemCartAdapter;
import com.webmingo.noonokababs.Modal.Cuntorymodel;
import com.webmingo.noonokababs.ModelRepo.RequestRepo.ViewCartRequest;
import com.webmingo.noonokababs.ModelRepo.cart.AddToCartDetailsRepo;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.SharedPrefernce.ViewCartReqSharedPreferenc;
import com.webmingo.noonokababs.ViewPresenter.Cart.AddtocartitemDetailsPresenter;
import com.webmingo.noonokababs.ViewPresenter.FoodFavourite.DoFoodDetailsPresenter;
import com.webmingo.noonokababs.databinding.FragmentAddCartBinding;
import com.webmingo.noonokababs.databinding.FragmentAddtoCartDetailsBinding;
import com.webmingo.noonokababs.dialogue.CustomDialog;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import de.mateware.snacky.Snacky;

public class AddtoCartDetailsFragment extends Fragment implements AddtocartitemDetailsPresenter.AddtoCartDetailsView, RequriedItemCartAdapter.RequriedItemCartclick, integedientItemCartAdapter.RequriedItemCartclick, AddonseCartAdapter.AddonseItemCartclick {

    FragmentAddtoCartDetailsBinding binding;
    private View view;
    AddtocartitemDetailsPresenter presenter;
    String id, totalprice;
    int quantity;
    CustomDialog customDialog;


    public String foodId, quantityy, varientId, requiredItemId, cookingLevels, specialRequest;


    ArrayList<String> ingredients = new ArrayList<>();
    ArrayList<ViewCartRequest.Cart.Addon> Addonlist = new ArrayList<>();
    ArrayList<ViewCartRequest.Cart> Cartlist = new ArrayList<>();
    ArrayList<ViewCartRequest> ViewCartRequestlist = new ArrayList<>();


    private List<ViewCartRequest> ViewCartRequestList = new ArrayList<>();

    public AddtoCartDetailsFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_addto_cart_details, container, false);
        view = binding.getRoot();
        presenter = new AddtocartitemDetailsPresenter(this);
        customDialog = new CustomDialog(getContext());

        if (getArguments().getString("id") != null) {

            id = getArguments().getString("id");

            Log.e("iddddd",id);
          presenter.AddToCart(getContext(), id);
           // presenter.AddToCart(getContext(), "103");

        }

        binding.Increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                quantity = Integer.parseInt(binding.quentityTv.getText().toString());
                quantity++;
                binding.quentityTv.setText(String.valueOf(quantity));


                totalprice = String.valueOf(Float.parseFloat(totalprice) + Float.parseFloat(binding.price.getText().toString()));
                binding.cartdetaillayout.TotalPrice.setText("$ " + totalprice);

                // tv.setText(new DecimalFormat("##.##").format(i2));

                //binding.cartdetaillayout.TotalPrice.setText("$ "+new DecimalFormat("##.##").format(totalprice ));
/*

                totalprice=     String.valueOf(Float.parseFloat(binding.price.getText().toString()) * Integer.parseInt(binding.quentityTv.getText().toString()));
                binding.cartdetaillayout.TotalPrice.setText("$ " + totalprice);
*/

            }
        });
        binding.Decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (quantity > 1) {
                    quantity--;
                    binding.quentityTv.setText(String.valueOf(quantity));
                    totalprice = String.valueOf(Float.parseFloat(totalprice) - Float.parseFloat(binding.price.getText().toString()));
                    //binding.cartdetaillayout.TotalPrice.setText("$ "+new DecimalFormat("##.##").format(totalprice ));

                    binding.cartdetaillayout.TotalPrice.setText("$ " + totalprice);


                }


            }
        });

        binding.cartdetaillayout.AddToCartTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                quantityy = binding.quentityTv.getText().toString();


                if (binding.specialrequestET.getText().toString().isEmpty()) {

                    specialRequest = "noting";
                } else {
                    specialRequest = binding.specialrequestET.getText().toString();

                }

                if (requiredItemId == null) {
                    Snacky.builder()
                            .setActivity(getActivity())
                            .setText("Lunch Special Required ")
                            .setTextColor(getResources().getColor(R.color.white))
                            .warning()
                            .show();
                } else {


                    ViewCartRequest.Cart cart = new ViewCartRequest.Cart(foodId, quantityy, varientId, requiredItemId, cookingLevels, ingredients, Addonlist, specialRequest);
                    Cartlist.add(cart);

                    ViewCartRequest viewCartRequest = new ViewCartRequest(Cartlist);
                    ViewCartRequestlist.add(viewCartRequest);
                    //ViewCartReqSharedPreferenc.writeListInPref(getContext(), ViewCartRequestlist);


                    //  AddingCartItem();
                    ViewCartRequestList = ViewCartReqSharedPreferenc.readListFromPref(getContext());


                    if (ViewCartRequestList != null) {
                        for (int i = 0; i < ViewCartRequestList.size(); i++) {

                            if (ViewCartRequestList.get(i).getCart().get(i).getFoodId().equalsIgnoreCase(foodId)) {
                                Snacky.builder()
                                        .setActivity(getActivity())
                                        .setText("Product allready added in cart!")
                                        .setTextColor(getResources().getColor(R.color.white))
                                        .warning()
                                        .show();


                            } else {
                                Toast.makeText(getContext(), "else 1", Toast.LENGTH_SHORT).show();
                                ViewCartReqSharedPreferenc.writeListInPref(getContext(), ViewCartRequestlist);
                                AddingCartItem();
                            }
                        }
                    } else {
                        Toast.makeText(getContext(), "else 2", Toast.LENGTH_SHORT).show();

                        ViewCartReqSharedPreferenc.writeListInPref(getContext(), ViewCartRequestlist);
                        AddingCartItem();

                    }




                          /*  if (ingredients.size() > 0) {

                    for (int i = 0; i < ingredients.size(); i++) {
                        Log.e("ingredients", ingredients.get(i));
                    }
                    //   Toast.makeText(getContext(), arrayList.size()+"", Toast.LENGTH_SHORT).show();
                    *//*SharedPrefManager.getInstance(getActivity())
                            .addon_service_Array_Id(addon_service_Array_Id.trim());*//*
                }*/

           /*     if (Addonlist.size() > 0) {

                    for (int i = 0; i < Addonlist.size(); i++) {
                        Log.e("Addonlist", Addonlist.get(i).getId() + " \n" + Addonlist.get(i).getQuantity());
                    }

                } else {
                    Log.e("Remove", "");

                }
*/

                }
            }
        });

        return binding.getRoot();
    }


    @Override
    public void onAddtoCartDetailsError(String message) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showRequestDialog(getActivity());

        } else {
            AppTools.hideDialog();

        }
    }

    @Override
    public void onAddtoCartDetailsFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onaddtocartSuccess(AddToCartDetailsRepo response, String message) {
        /*Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();*/
        if (message.equalsIgnoreCase("ok")) {

            foodId = String.valueOf(response.getData().getFood().getId());
            varientId = String.valueOf(response.getData().getVarient().getId());
            binding.nameTV.setText(Html.fromHtml(response.getData().getFood().getName()));

            binding.RemarkTv.setText(Html.fromHtml(response.getData().getFood().getRemark()));

            binding.price.setText(response.getData().getVarient().getFinalPrice());
            binding.cartdetaillayout.TotalPrice.setText("$ " + response.getData().getVarient().getFinalPrice());
            totalprice = response.getData().getVarient().getFinalPrice();
            if (response.getData().getRequiredItems().size() > 0) {
                binding.LunchSpecialLL.setVisibility(View.VISIBLE);
                RequriedItemCartAdapter gameAdapter = new RequriedItemCartAdapter(response, getContext(), this);
                RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                binding.LunchSpecialRV.setLayoutManager(mLayoutManager1);
                binding.LunchSpecialRV.setItemAnimator(new DefaultItemAnimator());
                binding.LunchSpecialRV.setAdapter(gameAdapter);

            }else {
                requiredItemId=" ";
            }
            if (response.getData().getIngredients().size() > 0) {
                binding.extraingredientsLL.setVisibility(View.VISIBLE);
                integedientItemCartAdapter gameAdapter = new integedientItemCartAdapter(response, getContext(), this);
                RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                binding.extraingredientsRV.setLayoutManager(mLayoutManager1);
                binding.extraingredientsRV.setItemAnimator(new DefaultItemAnimator());
                binding.extraingredientsRV.setAdapter(gameAdapter);


            }
            if (response.getData().getAddons().size() > 0) {
                binding.addonseLL.setVisibility(View.VISIBLE);
                AddonseCartAdapter gameAdapter = new AddonseCartAdapter(response, getContext(), this);
                RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                binding.addonseRv.setLayoutManager(mLayoutManager1);
                binding.addonseRv.setItemAnimator(new DefaultItemAnimator());
                binding.addonseRv.setAdapter(gameAdapter);
            }

            if (response.getData().getAllVarients().size() > 0) {

                List<Cuntorymodel> list = new ArrayList<>();
                // list.add(new Cuntorymodel("Select Country", "0", "0", "0"));
                for (int i = 0; i < response.getData().getAllVarients().size(); i++) {

                    Cuntorymodel itemData = new Cuntorymodel(response.getData().getAllVarients().get(i).getGetQuantity().getType(),
                            String.valueOf(response.getData().getAllVarients().get(i).getGetQuantity().getId()),
                            "", "");
                    list.add(itemData);

                }


                CountrySpinnerAdapter countrySpinnerAdapter = new CountrySpinnerAdapter(getContext(), R.id.coinName, list);
                binding.allvarientsSpinner.setAdapter(countrySpinnerAdapter);
                binding.allvarientsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getContext(), list.get(position).getName() + "", Toast.LENGTH_SHORT).show();


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
            }
            //showloader();

        }
    }

    @Override
    public void RequriedItemselected(AddToCartDetailsRepo repo, int pos) {

        requiredItemId = String.valueOf(repo.getData().getRequiredItems().get(pos).getId());


    }

    @Override
    public void RequriedItemCheckedClick(AddToCartDetailsRepo repo, int position, Boolean bb) {
        Toast.makeText(getContext(), repo.getData().getIngredients().get(position).getName() + "", Toast.LENGTH_SHORT).show();

        if (bb == true) {
            ingredients.add(String.valueOf(repo.getData().getIngredients().get(position).getId()));

        } else {
            ingredients.remove(String.valueOf(repo.getData().getIngredients().get(position).getId()));

        }


      /*  if (bb == true) {
            // arrayList.add(id);

        } else {
            //arrayList.remove(id);
        }*/

    }

    @Override
    public void IncreaseQuentity(String Quentity, int position, AddToCartDetailsRepo addToCartDetailsRepo) {


        totalprice = String.valueOf(Float.parseFloat(totalprice) + Float.parseFloat(addToCartDetailsRepo.getData().getAddons().get(position).getGetAddonFoodVarients().get(0).getFinalPrice()));
        binding.cartdetaillayout.TotalPrice.setText("$ " + totalprice);

        if (Addonlist.size() > 0) {

            for (int i = 0; i < Addonlist.size(); i++) {

                if (Addonlist.get(i).getId().equalsIgnoreCase(String.valueOf(addToCartDetailsRepo.getData().getAddons().get(position).getId()))) {

                    ViewCartRequest.Cart.Addon addon = new ViewCartRequest.Cart.Addon(String.valueOf(addToCartDetailsRepo.getData().getAddons().get(position).getId()), Quentity);
                    Addonlist.set(i, addon);


                }
                // Log.e("Addonlist",Addonlist.get(i).getId()+" \n"+Addonlist.get(i).getQuantity());
            }


        }
    }

    @Override
    public void DecressQuentity(String Quentity, int position, AddToCartDetailsRepo addToCartDetailsRepo) {

        totalprice = String.valueOf(Float.parseFloat(totalprice) - Float.parseFloat(addToCartDetailsRepo.getData().getAddons().get(position).getGetAddonFoodVarients().get(0).getFinalPrice()));
        binding.cartdetaillayout.TotalPrice.setText("$ " + totalprice);


        if (Addonlist.size() > 0) {

            for (int i = 0; i < Addonlist.size(); i++) {

                if (Addonlist.get(i).getId().equalsIgnoreCase(String.valueOf(addToCartDetailsRepo.getData().getAddons().get(position).getId()))) {

                    ViewCartRequest.Cart.Addon addon = new ViewCartRequest.Cart.Addon(String.valueOf(addToCartDetailsRepo.getData().getAddons().get(position).getId()), Quentity);
                    Addonlist.set(i, addon);


                }
                // Log.e("Addonlist",Addonlist.get(i).getId()+" \n"+Addonlist.get(i).getQuantity());
            }
        }
    }

    @Override
    public void EnableCheckedClick(AddToCartDetailsRepo repo, int position, Boolean bb) {

        if (bb == true) {
            totalprice = String.valueOf(Float.parseFloat(totalprice) + Float.parseFloat(repo.getData().getAddons().get(position).getGetAddonFoodVarients().get(0).getFinalPrice()));
            binding.cartdetaillayout.TotalPrice.setText("$ " + totalprice);

            ViewCartRequest.Cart.Addon addon = new ViewCartRequest.Cart.Addon(String.valueOf(repo.getData().getAddons().get(position).getId()), "1");
            Addonlist.add(addon);


        } else {
            totalprice = String.valueOf(Float.parseFloat(totalprice) - Float.parseFloat(repo.getData().getAddons().get(position).getGetAddonFoodVarients().get(0).getFinalPrice()));
            binding.cartdetaillayout.TotalPrice.setText("$ " + totalprice);

            if (Addonlist.size() > 0) {

                for (int i = 0; i < Addonlist.size(); i++) {
                    if (Addonlist.get(i).getId().equalsIgnoreCase(String.valueOf(repo.getData().getAddons().get(position).getId()))) {
                        Addonlist.remove(i);


                    }
                    // Log.e("Addonlist",Addonlist.get(i).getId()+" \n"+Addonlist.get(i).getQuantity());
                }
                //   Toast.makeText(getContext(), arrayList.size()+"", Toast.LENGTH_SHORT).show();
                    /*SharedPrefManager.getInstance(getActivity())
                            .addon_service_Array_Id(addon_service_Array_Id.trim());*/
            }


           /* ViewCartRequest.Cart.Addon addon =new ViewCartRequest.Cart.Addon(String.valueOf(repo.getData().getAddons().get(position).getId()),"1");
            Addonlist.remove(addon);*/

        }

    }

    private void AddToCart() {

/*

        quantityy = binding.quentityTv.getText().toString();
        specialRequest = binding.specialrequestET.getText().toString();
        if (requiredItemId == null) {
            Snacky.builder()
                    .setActivity(getActivity())
                    .setText("Lunch Special Required ")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        } else {

            ViewCartRequest.Cart cart = new ViewCartRequest.Cart(foodId, quantityy, varientId, requiredItemId, cookingLevels, ingredients, Addonlist, specialRequest);
            Cartlist.add(cart);

            ViewCartRequest viewCartRequest = new ViewCartRequest(Cartlist);
            ViewCartRequestlist.add(viewCartRequest);
            ViewCartReqSharedPreferenc.writeListInPref(getContext(), ViewCartRequestlist);

          //  AddingCartItem();
          //  ViewCartRequestList = ViewCartReqSharedPreferenc.readListFromPref(getContext());


         */
/*   if (ViewCartRequestList != null) {
                for (int i = 0; i < ViewCartRequestList.size(); i++) {

                    if (ViewCartRequestList.get(i).getCart().get(i).getFoodId().equalsIgnoreCase(foodId)) {
                        Snacky.builder()
                                .setActivity(getActivity())
                                .setText("Product allready added in cart!")
                                .setTextColor(getResources().getColor(R.color.white))
                                .warning()
                                .show();


                    } else {
                        Toast.makeText(getContext(), "else 1", Toast.LENGTH_SHORT).show();
                        ViewCartReqSharedPreferenc.writeListInPref(getContext(), ViewCartRequestlist);
                        AddingCartItem();
                    }
                }
            } else {
                Toast.makeText(getContext(), "else 2", Toast.LENGTH_SHORT).show();

                ViewCartReqSharedPreferenc.writeListInPref(getContext(), ViewCartRequestlist);
                AddingCartItem();

            }
*//*

        }

*/

    }

    private void AddingCartItem() {
        customDialog.showGIFloader();

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        customDialog.dissmiss();

                        customDialog.showloader();
                    }
                }, 3000);
    }


}