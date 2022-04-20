package com.webmingo.noonokababs.Fragments.BottomNavFragment.Food;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rjesture.startupkit.AppTools;
import com.webmingo.noonokababs.ModelRepo.Responsee.FoodFavourit.FoodDetailsOfferRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.FoodFavourit.FoodDetailsRepo;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.ViewPresenter.FoodFavourite.DoFoodDetailsPresenter;
import com.webmingo.noonokababs.ViewPresenter.FoodFavourite.DoFoodfavouriteListPresenter;
import com.webmingo.noonokababs.databinding.FragmentFoodDetailBinding;

import de.mateware.snacky.Snacky;
import okhttp3.ResponseBody;


public class FoodDetailFragment extends Fragment implements DoFoodDetailsPresenter.DoFoodDetailsView {
    FragmentFoodDetailBinding binding;
    private View view;
    String id;
    DoFoodDetailsPresenter presenter;

    int quantity;
    NavController navController;


    public FoodDetailFragment() {
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


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_food_detail, container, false);
        view = binding.getRoot();
        presenter = new DoFoodDetailsPresenter(this);

        if (getArguments().getString("id") != null) {

            id = getArguments().getString("id");
            presenter.DoFoodDetails(getContext(), id);

           Toast.makeText(getContext(), id + "", Toast.LENGTH_SHORT).show();


        }
        binding.AddFavTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.DoAddOrRemoveFavourite(getContext(), id);
            }
        });


        binding.AddCartTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                navController.navigate(R.id.addtoCartDetailsFragment, bundle);


               // Toast.makeText(getContext(), id + "", Toast.LENGTH_SHORT).show();

            }
        });


        binding.Increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                quantity = Integer.parseInt(binding.quentityTv.getText().toString());
                quantity++;
                binding.quentityTv.setText(String.valueOf(quantity));
            }
        });


        binding.Decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (quantity > 1) {
                    quantity--;

                    binding.quentityTv.setText(String.valueOf(quantity));


                }


            }
        });


        return binding.getRoot();
    }

    @Override
    public void onDoFoodDetailsError(String message) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();


    }

    @Override
    public void onDoFoodDetailsSuccess(FoodDetailsRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {
            binding.Categoris.setText("Categories: " + response.getData().getFoodDetail().getGetCategory().getName());
            binding.Name.setText("" + response.getData().getFoodDetail().getName());
            if (response.getData().getFoodDetail().getRemark()!=null)
            {

                binding.remark.setText(Html.fromHtml(response.getData().getFoodDetail().getRemark()));
            }
            binding.timimg.setText(response.getData().getFoodDetail().getDeliveryTime());
            binding.tvPrice.setText("$" + response.getData().getFoodDetail().getGetVarients().get(0).getPrice());
            //binding.Avergeratingtv.setText( response.getData().getFoodDetail().getTotal_rating());
            // binding.TotalRatingTV.setText(response.getData().getFoodDetail().getAvg_rating()+"+ Rating");
         /*   Toast.makeText(getContext(), response.getData().getFoodDetail().getAvg_rating()+"", Toast.LENGTH_SHORT).show();

            if (response.getData().getFoodDetail().getAvg_rating()!=null){
                binding.textRating.setRating(Float.parseFloat(String.valueOf(response.getData().getFoodDetail().getAvg_rating())));

            }*/

            if (response.getData().getFoodDetail().getGetGallery().get(0).getImage() != null) {
                Glide.with(getContext())
                        .load(response.getData().getImageBaseUrl() + response.getData().getFoodDetail().getGetGallery().get(0).getImage())
                        .into(binding.foodIV);
            }


           // Toast.makeText(getContext(), response.getData().getFoodDetail().getInStock() + " ", Toast.LENGTH_SHORT).show();
            if (response.getData().getFoodDetail().getInStock().equalsIgnoreCase("Yes")) {


                binding.nextproduced.setVisibility(View.VISIBLE);
                binding.outofstockTV.setVisibility(View.GONE);
            }

            presenter.DoFoodoffer(getContext(), id);

         //   Log.e("avg_rating ",response.getData().getFoodDetail().getAvgRating());
            binding.TotalRatingTV.setText(response.getData().getFoodDetail().getAvgRating() + "+ Rating");
            if (response.getData().getFoodDetail().getAvgRating() != null) {
                binding.textRating.setRating(Float.parseFloat(response.getData().getFoodDetail().getAvgRating()));

            }

            binding.FoodDetailsLL.setVisibility(View.VISIBLE);


        }


    }

    @Override
    public void onDoFoodDetailsOfferSuccess(FoodDetailsOfferRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {

            binding.offername.setText("20% off up to $300 on orders above $1000 | Use Name  " + response.getData().getCoupons().get(0).getName().toUpperCase());
            binding.cuponname.setText("15% off upto $100 with SBI credit cards, once per week | Use code " + response.getData().getCoupons().get(0).getCode().toUpperCase());

        }
    }

    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showRequestDialog(getActivity());
            binding.FoodDetailsLL.setVisibility(View.GONE);

        } else {
            AppTools.hideDialog();

        }
    }

    @Override
    public void onDoFoodDetailsFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
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


}