package com.webmingo.noonokababs.Fragments.BottomNavFragment.Food;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Toast;

import com.rjesture.startupkit.AppTools;
import com.webmingo.noonokababs.Adapters.FoodFavourite.FoodItemAdapter;
import com.webmingo.noonokababs.MainActivity;
import com.webmingo.noonokababs.ModelRepo.Responsee.FoodItemRepo;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.SharedPrefernce.SharedPrefManager;
import com.webmingo.noonokababs.ViewPresenter.FoodFavourite.DoFoodListPresenter;
import com.webmingo.noonokababs.databinding.FragmentFoodBinding;
import com.webmingo.noonokababs.dialogue.CustomDialog;
import com.webmingo.noonokababs.dialogue.FiltersBottom;

import java.util.ArrayList;

import de.mateware.snacky.Snacky;
import okhttp3.ResponseBody;


public class FoodFragment extends Fragment implements DoFoodListPresenter.DoFoodListView, FoodItemAdapter.FoodItemClick {
    FragmentFoodBinding binding;

    private View view;
    DoFoodListPresenter presenter;
    LinearLayoutManager linearLayoutManager;
    NavController navController;


    ArrayList<FoodItemRepo.Data.FoodItems.Datum> items = new ArrayList<>();
    GridLayoutManager mGridLayoutManager;
    boolean isLoading = false;
    Boolean isScrolling = false;
    int currrentitem, totalitem, scrolloutiem;
    int scrolling_page = 1;
    FoodItemAdapter foodItemAdapter;
    Bundle extras;
    String rating_hight_to_low, price_low_to_high, popular, neww;
    String id = "no";


    public FoodFragment() {

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


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_food, container, false);
        view = binding.getRoot();
        presenter = new DoFoodListPresenter(this);


        extras = getArguments();
        if (extras != null) {
            id = getArguments().getString("id");


            if (id.equalsIgnoreCase("no")) {
                rating_hight_to_low = getArguments().getString("rating_hight_to_low");
                price_low_to_high = getArguments().getString("price_low_to_high");
                popular = getArguments().getString("popular");
                neww = getArguments().getString("neww");
                Toast.makeText(getContext(), id, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), id, Toast.LENGTH_SHORT).show();

                presenter.DoFoodCategoriesList(getContext(), id);


            }
        } else {
            presenter.DoFoodList(getContext(), String.valueOf(scrolling_page));

        }
        isLoading = true;

       /*

        presenter.DoFoodList(getContext(), String.valueOf(scrolling_page));
       scrolling_page += 1;
        isFirst = false;*/

       /* RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mLayoutManager1.setAutoMeasureEnabled(false);

        binding.recyclerViewFoodItems.setLayoutManager(mLayoutManager1);

        binding.recyclerViewFoodItems.setItemAnimator(new DefaultItemAnimator());*/

        binding.microphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FiltersBottom filtersBottom = new FiltersBottom();
                filtersBottom.show(getActivity().getSupportFragmentManager(), filtersBottom.getTag());

            }
        });
        binding.serchFoodTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  navController.navigate(R.id.searchFragment);


                Bundle bundle = new Bundle();
                bundle.putString("Key", "Food");
                navController.navigate(R.id.searchFragment, bundle);





         /*       FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment searchFragment = new SearchFragment();
                Bundle args = new Bundle();
                // args.putSerializable(ARG_ANIMALS, animals as Serializable)
                args.putString("Key", "Food");
                searchFragment.setArguments(args);
                fragmentTransaction.replace(R.id.main, searchFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
*/
            }
        });
        return binding.getRoot();

    }

    @Override
    public void onDoFoodListError(String message) {

        Log.e("dfkjnakfn", message);


        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onDoFoodListSuccess(FoodItemRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {

            if (response.getData().getFoodItems().getData().size() > 0) {
                setup_cart_items(response);



             /*  for (int i =0 ; i<response.getData().getFoodItems().getData().size();i++){
                   FoodItemRepo.Data.FoodItems.Datum datum = new FoodItemRepo.Data.FoodItems.Datum();

                   datum.setRemark(response.getData().getFoodItems().getData().get(i).getRemark());
                   datum.setDescription(response.getData().getFoodItems().getData().get(i).getDescription());
                   datum.setGetSinglePrice(response.getData().getFoodItems().getData().get(i).getGetSinglePrice());
                   datum.setGetGallery(response.getData().getFoodItems().getData().get(i).getGetGallery());
                   datum.setName(response.getData().getFoodItems().getData().get(i).getName());

                   items.add(datum);
               }*/

               /* FoodItemRepo foodItemRepo = response;
                items.addAll(foodItemRepo.getData().getFoodItems().getData());
                linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                binding.recyclerViewFoodItems.setHasFixedSize(true);
                binding.recyclerViewFoodItems.setLayoutManager(linearLayoutManager);

                FoodItemAdapter foodItemAdapter = new FoodItemAdapter(response, items, getContext(), this);
                foodItemAdapter.notifyDataSetChanged();
                binding.recyclerViewFoodItems.setAdapter(foodItemAdapter);



                binding.recyclerViewFoodItems.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                        if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                            isScrolling = true;
                        }
                    }

                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);


                        currentItems = linearLayoutManager.getChildCount();
                        totalItems = linearLayoutManager.getItemCount();
                        scrollOutItems = linearLayoutManager.findFirstVisibleItemPosition();

                        if (isScrolling && (currentItems + scrollOutItems == totalItems)) {
                            isScrolling = false;
                            page += 1;
                            Toast.makeText(getContext(), "Please wait", Toast.LENGTH_SHORT).show();

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    presenter.DoFoodList(getContext(), String.valueOf(page));

                                }
                            }, 500);

                            //  getData();
                        }
                    }
                });
                // setup_cart_items(response);


*/


            }
        }

    }

    @Override
    public void onDoFoodCategoriesSuccess(FoodItemRepo response, String message) {


        if (message.equalsIgnoreCase("ok")) {

            if (response.getData().getFoodItems().getData().size() > 0) {
                setup_cart_items(response);



             /*  for (int i =0 ; i<response.getData().getFoodItems().getData().size();i++){
                   FoodItemRepo.Data.FoodItems.Datum datum = new FoodItemRepo.Data.FoodItems.Datum();

                   datum.setRemark(response.getData().getFoodItems().getData().get(i).getRemark());
                   datum.setDescription(response.getData().getFoodItems().getData().get(i).getDescription());
                   datum.setGetSinglePrice(response.getData().getFoodItems().getData().get(i).getGetSinglePrice());
                   datum.setGetGallery(response.getData().getFoodItems().getData().get(i).getGetGallery());
                   datum.setName(response.getData().getFoodItems().getData().get(i).getName());

                   items.add(datum);
               }*/

               /* FoodItemRepo foodItemRepo = response;
                items.addAll(foodItemRepo.getData().getFoodItems().getData());
                linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                binding.recyclerViewFoodItems.setHasFixedSize(true);
                binding.recyclerViewFoodItems.setLayoutManager(linearLayoutManager);

                FoodItemAdapter foodItemAdapter = new FoodItemAdapter(response, items, getContext(), this);
                foodItemAdapter.notifyDataSetChanged();
                binding.recyclerViewFoodItems.setAdapter(foodItemAdapter);



                binding.recyclerViewFoodItems.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                        if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                            isScrolling = true;
                        }
                    }

                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);


                        currentItems = linearLayoutManager.getChildCount();
                        totalItems = linearLayoutManager.getItemCount();
                        scrollOutItems = linearLayoutManager.findFirstVisibleItemPosition();

                        if (isScrolling && (currentItems + scrollOutItems == totalItems)) {
                            isScrolling = false;
                            page += 1;
                            Toast.makeText(getContext(), "Please wait", Toast.LENGTH_SHORT).show();

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    presenter.DoFoodList(getContext(), String.valueOf(page));

                                }
                            }, 500);

                            //  getData();
                        }
                    }
                });
                // setup_cart_items(response);


*/


            }
        }
        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onDoAddorRemoveFavouriteSuccess(ResponseBody response, String message) {
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
    public void onDoFoodListFailure(Throwable t) {

        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void FoodItemClick(ArrayList<FoodItemRepo.Data.FoodItems.Datum> modelArrayList, int pos) {

        Bundle bundle = new Bundle();
        bundle.putString("id", String.valueOf(modelArrayList.get(pos).getId()));
        navController.navigate(R.id.foodDetailFragment, bundle);
        //      Toast.makeText(getContext(), repo.getData().getFoodItems().get(pos).getName() + "", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void FoodItemFavouriteClick(ArrayList<FoodItemRepo.Data.FoodItems.Datum> modelArrayList, int pos) {
        presenter.DoAddOrRemoveFavourite(getContext(), String.valueOf(modelArrayList.get(pos).getId()));


    }


    void setup_cart_items(FoodItemRepo response) {

        if (id.equalsIgnoreCase("no")) {

            FoodItemRepo foodItemRepo = response;

            items.addAll(foodItemRepo.getData().getFoodItems().getData());
            mGridLayoutManager = new GridLayoutManager(getContext(), 1);


            binding.recyclerViewFoodItems.setLayoutManager(mGridLayoutManager);
            foodItemAdapter = new FoodItemAdapter(response, items, getContext(), this);


            binding.recyclerViewFoodItems.setAdapter(foodItemAdapter);

            binding.recyclerViewFoodItems.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);

                    if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                        isScrolling = true;

                    }


                }

                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    currrentitem = mGridLayoutManager.getChildCount();
                    totalitem = mGridLayoutManager.getItemCount();
                    scrolloutiem = mGridLayoutManager.findFirstVisibleItemPosition();

                    if (isScrolling && (currrentitem + scrolloutiem == totalitem)) {
                        scrolling_page += 1;

                        presenter.DoFoodList(getContext(), String.valueOf(scrolling_page));
                        foodItemAdapter.notifyDataSetChanged();
                        ;

                    }
                }
            });


        } else {
            FoodItemRepo foodItemRepo = response;
            items.addAll(foodItemRepo.getData().getFoodItems().getData());
            mGridLayoutManager = new GridLayoutManager(getContext(), 1);
            binding.recyclerViewFoodItems.setLayoutManager(mGridLayoutManager);
            foodItemAdapter = new FoodItemAdapter(response, items, getContext(), this);
            binding.recyclerViewFoodItems.setAdapter(foodItemAdapter);


        }


    }


}