package com.webmingo.noonokababs.Fragments.BottomNavFragment.Food;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rjesture.startupkit.AppTools;
import com.webmingo.noonokababs.Adapters.FoodFavourite.FoodItemAdapter;
import com.webmingo.noonokababs.Adapters.FoodFavourite.favouirteFoodItemAdapter;
import com.webmingo.noonokababs.ModelRepo.Responsee.FoodFavourit.FavouritefoodsRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.FoodItemRepo;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.Utils.util;
import com.webmingo.noonokababs.ViewPresenter.FoodFavourite.DoFoodListPresenter;
import com.webmingo.noonokababs.ViewPresenter.FoodFavourite.DoFoodfavouriteListPresenter;
import com.webmingo.noonokababs.databinding.FragmentFavoritesBinding;

import de.mateware.snacky.Snacky;
import okhttp3.ResponseBody;

public class FavoritesFragment extends Fragment implements DoFoodfavouriteListPresenter.DoFoodfavouriteListView, favouirteFoodItemAdapter.FoodFavouriteItemClick {
    FragmentFavoritesBinding binding;
    private View view;
    DoFoodfavouriteListPresenter presenter;
    GridLayoutManager mGridLayoutManager;


    /*
    boolean isLastPage = false, isFirst = false;
    boolean isLoading = false;
    int scrolling_page = 0, PAGE_SIZE = 10;*/
    NavController navController;

    public FavoritesFragment() {
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


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorites, container, false);
        view = binding.getRoot();

        presenter = new DoFoodfavouriteListPresenter(this);
        presenter.DoFoodfavouriteList(getContext());
        return binding.getRoot();
    }

    @Override
    public void onDoFoodfavouriteListError(String message) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onDoAddorRemoveFavouriteSuccess(ResponseBody response, String message, String msg) {
        if (msg.equalsIgnoreCase("ok")) {

            Snacky.builder()
                    .setActivity(getActivity())
                    .setText(message)
                    .setTextColor(getResources().getColor(R.color.white))
                    .success()
                    .show();
            presenter.DoFoodfavouriteList(getContext());


        }

    }

    @Override
    public void onDoFoodfavouriteListSuccess(FavouritefoodsRepo response, String message) {


        if (message.equalsIgnoreCase("ok")) {

            if (response.getData().getFavFoods().getData().size() > 0) {
                binding.tvCall.setVisibility(View.GONE);

                setup_cart_items(response);
            } else {
                binding.tvCall.setVisibility(View.VISIBLE);

                binding.recyclerViewFoodItems.setVisibility(View.GONE);
            }
        }
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
    public void onDoFoodfavouriteListFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    void setup_cart_items(FavouritefoodsRepo response) {

        mGridLayoutManager = new GridLayoutManager(getContext().getApplicationContext(), 1);
        binding.recyclerViewFoodItems.setLayoutManager(mGridLayoutManager);
        favouirteFoodItemAdapter foodItemAdapter = new favouirteFoodItemAdapter(response, getContext(), this);
        binding.recyclerViewFoodItems.setAdapter(foodItemAdapter);


//        gridViewAdapter.notifyDataSetChanged();

      /*  binding.recyclerViewFoodItems.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int visibleItemCount = mGridLayoutManager.getChildCount();
                int totalItemCount = mGridLayoutManager.getItemCount();
                int firstVisibleItemPosition = mGridLayoutManager.findFirstVisibleItemPosition();

                if (!isLoading && !isLastPage) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                            && firstVisibleItemPosition >= 0
                            && totalItemCount >= PAGE_SIZE) {
                        if (!util.isNetworkConnected(getActivity().getApplicationContext())) {
                            Toast.makeText(getContext(), "No Internet, Reconnect and Retry", Toast.LENGTH_SHORT).show();

                        } else {
                            scrolling_page += 1;
                            isFirst = false;
                            //hit();
                            Log.d("Scroll", "onScrollStateChanged: " + scrolling_page);


                        }
                    }
                }


            }


        });*/
    }


    @Override
    public void FoodItemClick(FavouritefoodsRepo repo, int pos) {


        Bundle bundle = new Bundle();
        bundle.putString("id", String.valueOf(repo.getData().getFavFoods().getData().get(pos).getId()));
        navController.navigate(R.id.foodDetailFragment, bundle);



    }

    @Override
    public void RemoveFoodItemFavouriteClick(FavouritefoodsRepo repo, int pos) {
        presenter.DoAddOrRemoveFavourite(getContext(), String.valueOf(repo.getData().getFavFoods().getData().get(pos).getId()));

    }


}