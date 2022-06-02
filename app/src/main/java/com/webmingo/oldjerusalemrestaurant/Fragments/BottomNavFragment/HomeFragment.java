package com.webmingo.oldjerusalemrestaurant.Fragments.BottomNavFragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import com.google.gson.Gson;
import com.rjesture.startupkit.AppTools;
import com.webmingo.oldjerusalemrestaurant.Adapters.ExploreCategoriesAdapter;
import com.webmingo.oldjerusalemrestaurant.Adapters.ExploreFoodItemAdapter;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.RequestRepo.ViewCartRequest;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.DashboardRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.cart.FoodCartViewRepo;
import com.webmingo.oldjerusalemrestaurant.R;
import com.webmingo.oldjerusalemrestaurant.SharedPrefernce.SharedPrefManager;
import com.webmingo.oldjerusalemrestaurant.SharedPrefernce.ViewCartReqSharedPreferenc;
import com.webmingo.oldjerusalemrestaurant.ViewPresenter.DoHomePagePresenter;
import com.webmingo.oldjerusalemrestaurant.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import de.mateware.snacky.Snacky;

public class HomeFragment extends Fragment implements DoHomePagePresenter.DoHomePageView, ExploreCategoriesAdapter.ExploreCategoriesClick, ExploreFoodItemAdapter.ExploreFoodClick {
    FragmentHomeBinding binding;
    private View view;
    DoHomePagePresenter presenter;
    NavController navController;


    private List<ViewCartRequest> ViewCartRequestList = new ArrayList<>();


    public HomeFragment() {


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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        view = binding.getRoot();


       // Log.e("SharedPrefManager", SharedPrefManager.getInstance(getContext()).GetAccessToken());

        presenter = new DoHomePagePresenter(this);
        presenter.DoAddPaymentList(getContext());
        ViewCartRequestList = ViewCartReqSharedPreferenc.readListFromPref(getContext());



        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString("viewCartRequest", "");
        ViewCartRequest viewCartRequest1 = gson.fromJson(json, ViewCartRequest.class);
        // Log.e("viewCartRequest1",viewCartRequest1.getCart().toString());
        if (viewCartRequest1 != null) {
            binding.ll.setVisibility(View.VISIBLE);
            presenter.FoodAddToCart(getContext(), viewCartRequest1);

        }
        binding.PickupanddropTV.setText(SharedPrefManager.getInstance(getContext()).GetDroptype());



/*
        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
        String json = mPrefs.getString("viewCartRequest", "");
        List<ViewCartRequest> arrayItems;
        if (json != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<ViewCartRequest>>(){}.getType();
            arrayItems = gson.fromJson(json, type);

            if (arrayItems.size() >0) {
                binding.ll.setVisibility(View.VISIBLE);
                presenter.FoodAddToCart(getContext(), viewCartRequest1);

            }
        }*/




     /*   Gson gson = new Gson();
        ViewCartRequest viewCartRequest1 = gson.fromJson(json, ViewCartRequest.class);
        // Log.e("viewCartRequest1",viewCartRequest1.getCart().toString());
        if (viewCartRequest1 != null) {
            binding.ll.setVisibility(View.VISIBLE);
            presenter.FoodAddToCart(getContext(), viewCartRequest1);

        }
*/






      /*  if (ViewCartRequestList != null) {
            Toast.makeText(getContext(), ViewCartRequestList.size() + "", Toast.LENGTH_SHORT).show();

            if (ViewCartRequestList.size() > 0) {
                binding.ll.setVisibility(View.VISIBLE);
            }


            for (int i = 0; i < ViewCartRequestList.size(); i++) {
                Log.e("ViewCartRequestList", ViewCartRequestList.get(i).getCart().get(i).getFoodId());

            }
        }
*/
    /*    if (ViewCartRequestList == null)
            ViewCartRequestList = new ArrayList<>();*/

        binding.viewcartTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.checkOutCartFragment);

            }
        });
        binding.serachTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navController.navigate(R.id.searchFragment);

                Bundle bundle = new Bundle();
                bundle.putString("Key", "Home");
                navController.navigate(R.id.searchFragment, bundle);




           /*     FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment searchFragment = new SearchFragment();
                Bundle args = new Bundle();
                // args.putSerializable(ARG_ANIMALS, animals as Serializable)
                args.putString("Key", "Home");
                searchFragment.setArguments(args);
                fragmentTransaction.replace(R.id.main, searchFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
*/


            }
        });
        return binding.getRoot();
    }

    private void ExploreCategoriesAdapter(DashboardRepo dashboardRepo) {


        ExploreCategoriesAdapter gameAdapter = new ExploreCategoriesAdapter(dashboardRepo, getContext(), this);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.exploreCategoriesRecycler.setLayoutManager(mLayoutManager1);
        binding.exploreCategoriesRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.exploreCategoriesRecycler.setAdapter(gameAdapter);

    }


    private void ExploreFoodItemAdapter(DashboardRepo dashboardRepo) {


        ExploreFoodItemAdapter gameAdapter = new ExploreFoodItemAdapter(dashboardRepo, getContext(), this);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.recyclerViewExploreFoodItems.setLayoutManager(mLayoutManager1);
        binding.recyclerViewExploreFoodItems.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerViewExploreFoodItems.setAdapter(gameAdapter);

    }

    @Override
    public void onDoHomePageError(String message) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();


    }

    @Override
    public void onDoHomePageSuccess(DashboardRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {

            if (SharedPrefManager.getInstance(getContext()).isLoggedIn()) {
            //    Getbless(response.getData().getUserInfo().getName());

            }


            if (response.getData().getCategories().size() > 0) {
                ExploreCategoriesAdapter(response);
            }
            if (response.getData().getFoodItems().size() > 0) {
                ExploreFoodItemAdapter(response);

            }


        }
    }

    @Override
    public void showHideProgress(boolean isShow) {

        if (isShow) {
            AppTools.showRequestDialog(getActivity());
            binding.HomePageRL.setVisibility(View.GONE);

        } else {
            AppTools.hideDialog();

            binding.HomePageRL.setVisibility(View.VISIBLE);

        }

    }

    @Override
    public void onDoHomePageFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();

    }

    @Override
    public void onFoodCartSuccess(FoodCartViewRepo body, String message) {
        if (message.equalsIgnoreCase("ok")) {
            binding.itemidTV.setText(String.valueOf(body.getData().getCartDetails().size()) + " ITEM");
            binding.pricetv.setText("$ " + body.getData().getBillingAmount());
        }


    }

    @Override
    public void ExploreCategoriesClickk(DashboardRepo repo, int pos) {

     /*   Bundle bundle = new Bundle();
        bundle.putString("id", String.valueOf(repo.getData().getCategories().get(pos).getId()));
        navController.navigate(R.id.foodDetailFragment,bundle);*/

        Bundle bundle = new Bundle();
        bundle.putString("id", String.valueOf(repo.getData().getCategories().get(pos).getId()));
        navController.navigate(R.id.foodFragment, bundle);


    }

    @Override
    public void ExploreFoodClickk(DashboardRepo repo, int pos) {

     /*   Bundle bundle = new Bundle();
        bundle.putString("id", String.valueOf(repo.getData().getCategories().get(pos).getId()));
        navController.navigate(R.id.foodDetailFragment,bundle);*/
        Bundle bundle = new Bundle();
        bundle.putString("id", String.valueOf(repo.getData().getFoodItems().get(pos).getId()));
        navController.navigate(R.id.foodDetailFragment, bundle);

    }

    private void Getbless(String name) {
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 12) {
            //Toast.makeText(this, "Good Morning", Toast.LENGTH_SHORT).show();
            binding.nameTv.setText("Good Morning! " + name);

        } else if (timeOfDay >= 12 && timeOfDay < 16) {


            binding.nameTv.setText("Good Afternoon! " + name);


            // Toast.makeText(this, "Good Afternoon", Toast.LENGTH_SHORT).show();
        } else if (timeOfDay >= 16 && timeOfDay < 21) {
            // Toast.makeText(this, "Good Evening", Toast.LENGTH_SHORT).show();

            binding.nameTv.setText("Good Evening! " + name);

        } else if (timeOfDay >= 21 && timeOfDay < 24) {

            binding.nameTv.setText("Good Night! " + name);


            // Toast.makeText(this, "Good Night", Toast.LENGTH_SHORT).show();
        }

    }
}