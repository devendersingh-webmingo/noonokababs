package com.webmingo.noonokababs.Fragments.DrawerLayoutFragment.Review;

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

import com.webmingo.noonokababs.Adapters.MediaViewAdapter;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.databinding.FragmentReviewsBinding;

public class ReviewsFragment extends Fragment implements View.OnClickListener {
    FragmentReviewsBinding binding;
    private View view;
    NavController navController;

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
        binding.GuestReview.writeReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.writeReviewFragment);
            }
        });
        binding.GuestReviewTV.setOnClickListener(this);

        binding.MediaReviewTV.setOnClickListener(this);


        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.GuestReview_TV:
                binding.GuestReviewTV.setTextColor(getActivity().getResources().getColor(R.color.white));
                binding.GuestReviewTV.setBackground(getActivity().getResources().getDrawable(R.drawable.btn_click_black_rectangle_with_semicircle_edge));
                binding.MediaReviewTV.setTextColor(getActivity().getResources().getColor(R.color.black));
                binding.MediaReviewTV.setBackground(getActivity().getResources().getDrawable(R.drawable.allsideborder));
                binding.ViewFillper.setDisplayedChild(0);

                binding.MediaReview.MediaReviewRC.setVisibility(View.GONE);
                break;

            case R.id.MediaReview_TV:

                binding.MediaReviewTV.setTextColor(getActivity().getResources().getColor(R.color.white));
                binding.MediaReviewTV.setBackground(getActivity().getResources().getDrawable(R.drawable.btn_click_black_rectangle_with_semicircle_edge));

                binding.GuestReviewTV.setTextColor(getActivity().getResources().getColor(R.color.black));
                binding.GuestReviewTV.setBackground(getActivity().getResources().getDrawable(R.drawable.allsideborder));

                binding.ViewFillper.setDisplayedChild(1);
                binding.MediaReview.MediaReviewRC.setVisibility(View.VISIBLE);


                MediaViewAdapter  mediaViewAdapter = new MediaViewAdapter(getContext());
                RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

                binding.MediaReview.MediaReviewRC.setLayoutManager(mLayoutManager1);
                binding.MediaReview.MediaReviewRC.setItemAnimator(new DefaultItemAnimator());
                binding.MediaReview.MediaReviewRC.setAdapter(mediaViewAdapter);

                break;


        }

    }
}