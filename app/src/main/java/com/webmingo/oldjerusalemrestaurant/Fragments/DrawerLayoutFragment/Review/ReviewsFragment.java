package com.webmingo.oldjerusalemrestaurant.Fragments.DrawerLayoutFragment.Review;

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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjesture.startupkit.AppTools;
import com.webmingo.oldjerusalemrestaurant.Adapters.Reviews.MediaViewAdapter;
import com.webmingo.oldjerusalemrestaurant.Adapters.Reviews.GuestReviewslistAdapter;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.MediaRespo.GuestReviewRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.MediaRespo.MediaReviewRepo;
import com.webmingo.oldjerusalemrestaurant.R;
import com.webmingo.oldjerusalemrestaurant.ViewPresenter.ReviewPresenter;
import com.webmingo.oldjerusalemrestaurant.databinding.FragmentReviewsBinding;

import de.mateware.snacky.Snacky;

public class ReviewsFragment extends Fragment implements View.OnClickListener, ReviewPresenter.DoReviewView {
    FragmentReviewsBinding binding;
    private View view;
    NavController navController;
    ReviewPresenter reviewPresenter;

    public ReviewsFragment() {
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


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_reviews, container, false);
        view = binding.getRoot();
        reviewPresenter = new ReviewPresenter(this);
        reviewPresenter.GuestReview(getContext());
       /* binding.GuestReview.writeReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  navController.navigate(R.id.writeReviewFragment);
            }
        });*/
        binding.GuestReviewTV.setOnClickListener(this);

        binding.MediaReviewTV.setOnClickListener(this);


        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.GuestReview_TV:
                reviewPresenter.GuestReview(getContext());
                binding.GuestReviewTV.setTextColor(getActivity().getResources().getColor(R.color.white));
                binding.GuestReviewTV.setBackground(getActivity().getResources().getDrawable(R.drawable.btn_click_black_rectangle_with_semicircle_edge));
                binding.MediaReviewTV.setTextColor(getActivity().getResources().getColor(R.color.black));
                binding.MediaReviewTV.setBackground(getActivity().getResources().getDrawable(R.drawable.allsideborder));
                binding.ViewFillper.setDisplayedChild(0);
                binding.MediaReview.MediaReviewRC.setVisibility(View.GONE);
                break;

            case R.id.MediaReview_TV:

                reviewPresenter.MediaReview(getContext());

                binding.MediaReviewTV.setTextColor(getActivity().getResources().getColor(R.color.white));
                binding.MediaReviewTV.setBackground(getActivity().getResources().getDrawable(R.drawable.btn_click_black_rectangle_with_semicircle_edge));

                binding.GuestReviewTV.setTextColor(getActivity().getResources().getColor(R.color.black));
                binding.GuestReviewTV.setBackground(getActivity().getResources().getDrawable(R.drawable.allsideborder));

                binding.ViewFillper.setDisplayedChild(1);
                binding.MediaReview.MediaReviewRC.setVisibility(View.VISIBLE);



                break;


        }

    }

    @Override
    public void onDoReviewError(String message) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onDoMediaReviewSuccess(MediaReviewRepo response, String message) {
      //  Toast.makeText(getContext(), message + "", Toast.LENGTH_SHORT).show();

        if (message.equalsIgnoreCase("ok")) {

            if (response.getData().getReviews().size() > 0) {


                MediaViewAdapter mediaViewAdapter = new MediaViewAdapter(response,getContext());
                RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

                binding.MediaReview.MediaReviewRC.setLayoutManager(mLayoutManager1);
                binding.MediaReview.MediaReviewRC.setItemAnimator(new DefaultItemAnimator());
                binding.MediaReview.MediaReviewRC.setAdapter(mediaViewAdapter);






            }
        }




    }

    @Override
    public void onDoGuestReviewSuccess(GuestReviewRepo response, String message) {
      //  Toast.makeText(getContext(), message + "", Toast.LENGTH_SHORT).show();


        if (message.equalsIgnoreCase("ok")) {

            if (response.getData().getTestimonials().size() > 0) {

                GuestReviewslistAdapter gameAdapter = new GuestReviewslistAdapter(response, getContext());
                RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                binding.GuestReview.MediaReviewRC.setLayoutManager(mLayoutManager1);
                binding.GuestReview.MediaReviewRC.setItemAnimator(new DefaultItemAnimator());
                binding.GuestReview.MediaReviewRC.setAdapter(gameAdapter);

            }
        }
    }

    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showRequestDialog(getActivity());


        } else {
            AppTools.hideDialog();
            //  binding.rearrelUILL.setVisibility(View.VISIBLE);


        }
    }

    @Override
    public void onDoReviewFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }
}