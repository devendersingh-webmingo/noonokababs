package com.webmingo.oldjerusalemrestaurant.Fragments.DrawerLayoutFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rjesture.startupkit.AppTools;
import com.webmingo.oldjerusalemrestaurant.Adapters.OrderHistoryAdapter.RecentActivityAdapter;
import com.webmingo.oldjerusalemrestaurant.Adapters.OrderHistoryAdapter.RecentPaymentsAdapter;
import com.webmingo.oldjerusalemrestaurant.Adapters.OrderHistoryAdapter.YourRecentOrdersAdapter;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Orderhistory.AllHistoryRepo;
import com.webmingo.oldjerusalemrestaurant.R;
import com.webmingo.oldjerusalemrestaurant.SharedPrefernce.SharedPrefManager;
import com.webmingo.oldjerusalemrestaurant.ViewPresenter.OrderHistoryPresenter;
import com.webmingo.oldjerusalemrestaurant.databinding.FragmentAccountBinding;

import de.mateware.snacky.Snacky;
import okhttp3.ResponseBody;

public class DashboardFragment extends Fragment implements OrderHistoryPresenter.OrderHistoryView, YourRecentOrdersAdapter.YourRecentOrdersClick {

    FragmentAccountBinding binding;

    private View view;
    NavController navController;
    OrderHistoryPresenter presenter;

    AlertDialog alertDialog;

    public DashboardFragment() {
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


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false);
        view = binding.getRoot();
        presenter = new OrderHistoryPresenter(this);
        presenter.AllHistoryList(getContext(), "Recent");
        binding.welcomTV.setText("Welcome to Dashboard " + SharedPrefManager.getInstance(getContext()).GetName());


        RecentActivityAdapter recentActivityAdapter = new RecentActivityAdapter(getContext());
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.recentActivityRV.setLayoutManager(mLayoutManager2);
        binding.recentActivityRV.setItemAnimator(new DefaultItemAnimator());
        binding.recentActivityRV.setAdapter(recentActivityAdapter);


        RecentPaymentsAdapter recentPaymentsAdapter = new RecentPaymentsAdapter(getContext());
        RecyclerView.LayoutManager mLayoutManager3 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.recentPaymentsRV.setLayoutManager(mLayoutManager3);
        binding.recentPaymentsRV.setItemAnimator(new DefaultItemAnimator());
        binding.recentPaymentsRV.setAdapter(recentPaymentsAdapter);


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
                Toast.makeText(getContext(), response.getData().getOrders().size() + "", Toast.LENGTH_SHORT).show();

                YourRecentOrdersAdapter yourRecentOrdersAdapter = new YourRecentOrdersAdapter(response, getContext(), this);
                RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                binding.recentOrdersAdapter.setLayoutManager(mLayoutManager1);
                binding.recentOrdersAdapter.setItemAnimator(new DefaultItemAnimator());
                binding.recentOrdersAdapter.setAdapter(yourRecentOrdersAdapter);
            } else {
                binding.DashboardPageLL.setVisibility(View.GONE);
                binding.tvCall.setVisibility(View.VISIBLE);
            }


        }
    }

    @Override
    public void onCancelorderSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            Toast.makeText(getContext(), "Your order cancellation request has been taken, wait you will be notified.", Toast.LENGTH_SHORT).show();
            presenter.AllHistoryList(getContext(), "All");

        }

    }

    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showRequestDialog(getActivity());
            binding.DashboardPageLL.setVisibility(View.GONE);

        } else {
            AppTools.hideDialog();
            binding.DashboardPageLL.setVisibility(View.VISIBLE);
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


        Bundle bundle = new Bundle();
        bundle.putString("id", String.valueOf(repo.getData().getOrders().get(pos).getId()));
        navController.navigate(R.id.orderHistoryDetailsFragment, bundle);

//        Toast.makeText(getContext(), repo.getData().getOrders().get(pos).getStatus() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnClickCancelOrder(AllHistoryRepo repo, int pos) {
        ShowCancelOrderDialog(String.valueOf(repo.getData().getOrders().get(pos).getId()));

    }


    @Override
    public void OnClickItemRating(AllHistoryRepo repo, int pos) {

        Bundle bundle = new Bundle();
        bundle.putString("id", String.valueOf(repo.getData().getOrders().get(pos).getId()));
        navController.navigate(R.id.writeReviewFragment, bundle);

    }

    public void ShowCancelOrderDialog(String id) {

        TextView tvCancel, okTv;
        ImageView close;

        EditText descET;


        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.cancelorderalertbox, null);
        alertDialog = new androidx.appcompat.app.AlertDialog.Builder(getContext())
                .setView(view)
                .setCancelable(false)
                .create();

        close = view.findViewById(R.id.close);
        tvCancel = view.findViewById(R.id.tvCancel);
        descET = view.findViewById(R.id.descET);
        okTv = view.findViewById(R.id.tvDelete);
        okTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // doSendOtpCreateUserPresenter.DoSendOtpCreateUser(LoginActivity.this, "231", "1", Email);

                String Desc = descET.getText().toString().trim();
                if (Desc.isEmpty()) {
                    Toast.makeText(getContext(), "Please enter Cancellation Reason", Toast.LENGTH_SHORT).show();

                } else {

                    presenter.Cancelorder(getContext(), id, Desc);
                    alertDialog.dismiss();

                }
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialog.dismiss();
            }
        });

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();


            }
        });
        alertDialog.show();
    }
}