package com.webmingo.noonokababs.Fragments.BottomNavFragment.Cart;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjesture.startupkit.AppTools;
import com.webmingo.noonokababs.ModelRepo.RequestRepo.ViewCartRequest;
import com.webmingo.noonokababs.ModelRepo.cart.FoodCartViewRepo;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.SharedPrefernce.ViewCartReqSharedPreferenc;
import com.webmingo.noonokababs.ViewPresenter.Cart.FoodCartPresenter;
import com.webmingo.noonokababs.ViewPresenter.DoProfileUpdateDetailsPresenter;
import com.webmingo.noonokababs.databinding.FragmentCheckOutCartBinding;
import com.webmingo.noonokababs.dialogue.ChangepasswordBottom;
import com.webmingo.noonokababs.dialogue.NotificationsBottom;

import java.util.ArrayList;
import java.util.List;

import de.mateware.snacky.Snacky;

public class CheckOutCartFragment extends Fragment implements FoodCartPresenter.FoodCartView {

    FragmentCheckOutCartBinding binding;
    private View view;
    FoodCartPresenter presenter;
    private ArrayList<ViewCartRequest> viewCartRequestList = new ArrayList<>();
    ViewCartRequest viewCartRequest;


    private ArrayList<ViewCartRequest.Cart> cartList = new ArrayList<>();
    private ArrayList<ViewCartRequest.Cart.Addon> addonList = new ArrayList<>();
    ArrayList<String> ingredientsArrayList = new ArrayList();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_check_out_cart, container, false);
        view = binding.getRoot();
        presenter = new FoodCartPresenter(this);



      /*  viewCartRequestList = ViewCartReqSharedPreferenc.readListFromPref(getContext());
        for (int i = 0; i < viewCartRequestList.size(); i++)
        {
             viewCartRequest=viewCartRequestList.get(i);
        }*/



     /*   "food_id" : 103,
                "quantity" : 1,
                "varient_id": 463,
                "required_item_id" : "2",
                "cooking_levels"   : null,
                "ingredients" :[16,7,17,18],
        "addons" : [
        {
            "id":458,
                "quantity":2
        }
			],
        "special_request": "Pls Provide Good Food"
                */

        ingredientsArrayList.add("16");
        ingredientsArrayList.add("7");
        ingredientsArrayList.add("17");
        ingredientsArrayList.add("18");
        ViewCartRequest.Cart.Addon addon = new ViewCartRequest.Cart.Addon("458", "2");

        addonList.add(addon);

        ViewCartRequest.Cart cart = new ViewCartRequest.Cart("103", "1", "463", "2", "null", ingredientsArrayList, addonList, "Pls Provide Good Food");
        cartList.add(cart);

        viewCartRequest = new ViewCartRequest(cartList);


        presenter.FoodAddToCart(getContext(), viewCartRequest);


/*
        List<String> ingredients = new ArrayList<String>();
        ingredients.add("16");
        ingredients.add("7");
        ingredients.add("17");
        ingredients.add("18");

        List<ViewCartRequest.Cart.Addon> addonList = new ArrayList<ViewCartRequest.Cart.Addon>();
        addonList.add(new ViewCartRequest.Cart.Addon("458", "2"));

        List<ViewCartRequest.Cart> itemCartList = new ArrayList<ViewCartRequest.Cart>();
        ViewCartRequest.Cart itemCart = new ViewCartRequest.Cart("103", "1", "463", "2", "null", ingredients, addonList, "Pls Provide Good Food");

        itemCartList.add(itemCart);

        ViewCartRequest viewCartRequest = new ViewCartRequest(itemCartList);

        presenter.FoodAddToCart(getContext(), viewCartRequest);
*/

        return binding.getRoot();
    }

    @Override
    public void onFoodCartDetailsError(String message) {
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
    public void onFoodCartDetailsFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onFoodCartSuccess(FoodCartViewRepo response, String message) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }
}