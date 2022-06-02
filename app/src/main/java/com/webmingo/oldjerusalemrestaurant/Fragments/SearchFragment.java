package com.webmingo.oldjerusalemrestaurant.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rjesture.startupkit.AppTools;
import com.webmingo.oldjerusalemrestaurant.Adapters.FoodFavourite.FoodItemSearchAdapter;
import com.webmingo.oldjerusalemrestaurant.Adapters.SearchAdapter;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.SearchCategoriesRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.SearchRepo;
import com.webmingo.oldjerusalemrestaurant.R;
import com.webmingo.oldjerusalemrestaurant.ViewPresenter.DoSearchPresenter;
import com.webmingo.oldjerusalemrestaurant.databinding.FragmentSearchBinding;

import de.mateware.snacky.Snacky;

public class SearchFragment extends Fragment implements DoSearchPresenter.DoSearchView,SearchAdapter.SearchListener,FoodItemSearchAdapter.SearchRepoView{
    FragmentSearchBinding binding;
    private View view;
    DoSearchPresenter presenter;
    String key;
    NavController navController;

    public SearchFragment() {

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


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        view = binding.getRoot();
        presenter=new DoSearchPresenter(this);

        if (getArguments().getString("Key") != null) {

            key=getArguments().getString("Key");
            //presenter.GetAddAddressById(getContext(), getArguments().getString("id"));

        }
        binding.edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                String text = s.toString();
                presenter.SearchFoodItem(getContext(), text);
                binding.recyclerView.setVisibility(View.GONE);

/*

                if (key.equalsIgnoreCase("Home"))
                {
                    String text = s.toString();
                    presenter.DoSearchList(getContext(), text);
                    binding.recyclerView.setVisibility(View.GONE);

                }else {

                    String text = s.toString();
                    presenter.SearchFoodItem(getContext(), text);
                    binding.recyclerView.setVisibility(View.GONE);
                }

*/

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return binding.getRoot();
    }

    @Override
    public void onDoSearchError(String message) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();


    }

    @Override
    public void onDoFoodItemSuccess(SearchRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {

            LinearLayoutManager linearLayoutManager = (new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            binding.recyclerView.setLayoutManager(linearLayoutManager);
            binding.recyclerView.setHasFixedSize(true);
            FoodItemSearchAdapter foodItemSearchAdapter = new FoodItemSearchAdapter(response, getContext(), this);
            binding.recyclerView.setAdapter(foodItemSearchAdapter);
            binding.recyclerView.setVisibility(View.VISIBLE);





        }
    }

    @Override
    public void onDoSearchSuccess(SearchCategoriesRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {
            LinearLayoutManager linearLayoutManager = (new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            binding.recyclerView.setLayoutManager(linearLayoutManager);
            binding.recyclerView.setHasFixedSize(true);
            SearchAdapter searchAdapter = new SearchAdapter(response, getContext(), this);
            binding.recyclerView.setAdapter(searchAdapter);
            binding.recyclerView.setVisibility(View.VISIBLE);





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
    public void onDoSearchFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onSearchclick(SearchCategoriesRepo SearchCategoriesRepo, int pos) {
        Toast.makeText(getContext(),SearchCategoriesRepo.getData().getCategories().get(pos).getName()+ "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSearchFoodItemclick(SearchRepo searchRepo, int pos) {
        Bundle bundle = new Bundle();
        bundle.putString("id", String.valueOf(searchRepo.getData().getItems().get(pos).getFoodId()));
        navController.navigate(R.id.foodDetailFragment, bundle);

    }
}