package com.webmingo.noonokababs.Fragments.DrawerLayoutFragment;

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
import android.widget.Toast;

import com.rjesture.startupkit.AppTools;
import com.webmingo.noonokababs.Adapters.OrderHistoryAdapter.YourRecentOrdersAdapter;
import com.webmingo.noonokababs.ModelRepo.Orderhistory.AllHistoryRepo;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.ViewPresenter.OrderHistoryPresenter;
import com.webmingo.noonokababs.databinding.FragmentOrderhistoryBinding;

import de.mateware.snacky.Snacky;

public class OrderhistoryFragment extends Fragment implements OrderHistoryPresenter.OrderHistoryView, YourRecentOrdersAdapter.YourRecentOrdersClick {


    FragmentOrderhistoryBinding binding;

    private View view;
    NavController navController;

    OrderHistoryPresenter presenter;


    public OrderhistoryFragment() {
        // Required empty public constructor
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


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_orderhistory, container, false);
        view = binding.getRoot();
        presenter = new OrderHistoryPresenter(this);
        presenter.AllHistoryList(getContext(), "All");


        return binding.getRoot();

    }


    @Override
    public void onOrderHistoryError(String message) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onOrderHistorySuccess(AllHistoryRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {
            if (response.getData().getOrders().size() > 0) {

                Toast.makeText(getContext(), response.getData().getOrders().size()+"", Toast.LENGTH_SHORT).show();

                YourRecentOrdersAdapter yourRecentOrdersAdapter = new YourRecentOrdersAdapter(response, getContext(), this);
                RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                binding.recyclerViewFoodItems.setLayoutManager(mLayoutManager1);
                binding.recyclerViewFoodItems.setItemAnimator(new DefaultItemAnimator());
                binding.recyclerViewFoodItems.setAdapter(yourRecentOrdersAdapter);


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
    public void onOrderHistoryFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }


    @Override
    public void OnClickItemOrderdetails(AllHistoryRepo repo, int pos) {

//        Toast.makeText(getContext(), repo.getData().getOrders().get(pos).getStatus() + "", Toast.LENGTH_SHORT).show();


        Bundle bundle = new Bundle();
        bundle.putString("id", String.valueOf(repo.getData().getOrders().get(pos).getId()));
        navController.navigate(R.id.orderHistoryDetailsFragment, bundle);

    }

    @Override
    public void OnClickItemRating(AllHistoryRepo repo, int pos) {

        Bundle bundle = new Bundle();
        bundle.putString("id", String.valueOf(repo.getData().getOrders().get(pos).getId()));
        navController.navigate(R.id.writeReviewFragment, bundle);

    }
}