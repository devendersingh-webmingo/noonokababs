package com.webmingo.oldjerusalemrestaurant.Fragments.DrawerLayoutFragment.Review;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.webmingo.oldjerusalemrestaurant.R;
import com.webmingo.oldjerusalemrestaurant.ViewPresenter.RatingReviewsPresenter;
import com.webmingo.oldjerusalemrestaurant.databinding.FragmentWriteReviewBinding;

import okhttp3.ResponseBody;

public class WriteReviewFragment extends Fragment implements RatingReviewsPresenter.RatingReviewsView {

    String id = "no", comment, ratingg;

    FragmentWriteReviewBinding binding;

    private View view;
    NavController navController;
    RatingReviewsPresenter presenter;


    public WriteReviewFragment() {
        // Required empty public constructor
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


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_write_review, container, false);
        view = binding.getRoot();

        presenter = new RatingReviewsPresenter(this);


        if (getArguments().getString("id") != null) {
            id = getArguments().getString("id");


            //  Toast.makeText(getContext(), id, Toast.LENGTH_SHORT).show();

        } else {
            //Toast.makeText(getContext(), id, Toast.LENGTH_SHORT).show();
        }


        binding.textRating.setOnRatingBarChangeListener(new SimpleRatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(SimpleRatingBar simpleRatingBar, float rating, boolean fromUser) {

                char first = String.valueOf(rating).charAt(0);
                ratingg = String.valueOf(first);

                // Toast.makeText(getContext(), ratingg, Toast.LENGTH_SHORT).show();
            }
        });

        binding.SubmitTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RatingData();
            }
        });

        return binding.getRoot();


    }

    public void RatingData() {

        if (ratingg == null) {
/*

            Snacky.builder()
                    .setActivity(getActivity())
                    .setText("Please Give Rating")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
*/


            Sneaker.with(getActivity())
                    .setTitle("Please Give Rating")
                    .setMessage("")
                    .sneakWarning();

          /*  Sneaker.with(this)
                    .setTitle("Please Give Rating")
                    .setMessage("")
                    .sneakError();*/
        } else {


            presenter.RatingReview(getContext(), id, ratingg, binding.descTv.getText().toString());

            /*
            AppTools.showRequestDialog(this);

            ReviewRequest reviewRequest = new ReviewRequest(id, comment, ratingg);
            presenter.AddReview(this, reviewRequest);*/

        }

    }

    @Override
    public void onRatingReviewError(String message) {

        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakWarning();
    }

    @Override
    public void onRatingReviewSuccess(ResponseBody response, String message) {


        if (message.equalsIgnoreCase("ok")) {
            Toast.makeText(getContext(), "Your Rating And Review Successfully Submitted.", Toast.LENGTH_LONG).show();


            navController.navigate(R.id.orderhistoryFragment);


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
    public void onRatingReviewFailure(Throwable t) {
        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakWarning();
    }
}