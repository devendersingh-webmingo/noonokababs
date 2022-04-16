package com.webmingo.noonokababs.Fragments.DrawerLayoutFragment.OrderHistory;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rjesture.startupkit.AppTools;
import com.webmingo.noonokababs.Adapters.OrderHistoryAdapter.HistoryPorductRatingAdapter;
import com.webmingo.noonokababs.Adapters.OrderHistoryAdapter.YourRecentOrdersAdapter;
import com.webmingo.noonokababs.ModelRepo.FooddetailRateRepo;
import com.webmingo.noonokababs.ModelRepo.Orderhistory.HistoryDetailsRepo;
import com.webmingo.noonokababs.ModelRepo.RequestRepo.OrderReviewReq;
import com.webmingo.noonokababs.ModelRepo.RequestRepo.ViewCartRequest;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.ViewPresenter.OrderHistoryDetailsPresenter;
import com.webmingo.noonokababs.ViewPresenter.OrderHistoryReviewPresenter;
import com.webmingo.noonokababs.databinding.FragmentOrderReviewBinding;

import java.util.ArrayList;
import java.util.Arrays;

import de.mateware.snacky.Snacky;
import okhttp3.ResponseBody;

public class OrderReviewFragment extends Fragment implements OrderHistoryReviewPresenter.DoReviewView, HistoryPorductRatingAdapter.HistoryProductEvent {

    FragmentOrderReviewBinding binding;

    private View view;
    NavController navController;

    String id;

    OrderHistoryReviewPresenter presenter;


    public OrderReviewFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_order_review, container, false);
        view = binding.getRoot();


        if (getArguments().getString("id") != null) {
            id = getArguments().getString("id");
            presenter = new OrderHistoryReviewPresenter(this);
            presenter.FooddetailRate(getContext(), id);


            Toast.makeText(getContext(), id, Toast.LENGTH_SHORT).show();

        } else {
            //Toast.makeText(getContext(), id, Toast.LENGTH_SHORT).show();
        }


        return binding.getRoot();

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
    public void onDoFooddetailRateSuccess(FooddetailRateRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {
            if (response.getData().getOrderInfo().getOrderFoodDetail().size() > 0) {

                HistoryPorductRatingAdapter historyPorductRatingAdapter = new HistoryPorductRatingAdapter(response, getContext(), this);

                RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                binding.recyclerViewFoodItems.setLayoutManager(mLayoutManager1);
                binding.recyclerViewFoodItems.setItemAnimator(new DefaultItemAnimator());
                binding.recyclerViewFoodItems.setAdapter(historyPorductRatingAdapter);


            }
        }

    }

    @Override
    public void onDoOrderReviewSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            Toast.makeText(getContext(), "Rating Successfully Submitted.", Toast.LENGTH_LONG).show();
            presenter.FooddetailRate(getContext(), id);
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
    public void onDoReviewFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }


    @Override
    public void ReivewsRating(String food_id, String rating, String Reviews) {
        OrderReviewReq orderReviewReq = new OrderReviewReq(food_id, rating, Reviews);

        presenter.onDoOrderReview(getContext(), id, orderReviewReq);


    }
}

