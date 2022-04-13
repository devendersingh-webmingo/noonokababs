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

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjesture.startupkit.AppTools;
import com.webmingo.noonokababs.Adapters.OrderHistoryAdapter.OrderDetailsAdapter;
import com.webmingo.noonokababs.ModelRepo.Orderhistory.HistoryDetailsRepo;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.ViewPresenter.OrderHistoryDetailsPresenter;
import com.webmingo.noonokababs.databinding.FragmentOrderHistoryDetailsBinding;

import de.mateware.snacky.Snacky;

public class OrderHistoryDetailsFragment extends Fragment implements OrderHistoryDetailsPresenter.OrderHistoryDetailsView {


    FragmentOrderHistoryDetailsBinding binding;

    private View view;
    NavController navController;

    OrderHistoryDetailsPresenter presenter;
    String id;


    public OrderHistoryDetailsFragment() {
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


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_order_history_details, container, false);
        view = binding.getRoot();
        presenter = new OrderHistoryDetailsPresenter(this);


        if (getArguments().getString("id") != null) {
            id = getArguments().getString("id");
            presenter.OrderHistoryDetails(getContext(), id);


            //  Toast.makeText(getContext(), id, Toast.LENGTH_SHORT).show();

        } else {
            //Toast.makeText(getContext(), id, Toast.LENGTH_SHORT).show();
        }


        return binding.getRoot();

    }


    @Override
    public void onOrderHistoryDetailsSuccess(HistoryDetailsRepo response, String message) {
      /*  Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();*/
        if (message.equalsIgnoreCase("ok")) {


            Log.e("onOrderHistoryError",response.getData().getOrderDetail().toString());


            binding.ordernumbertv.setText("Your  Order :- " + response.getData().getOrderDetail().getOrderId());

            binding.mrp.setText("$ " + response.getData().getOrderDetail().getpAmountSummery().getpSubTotalAmount());
            binding.prediscount.setText("$ " + response.getData().getOrderDetail().getpAmountSummery().getpTotalDiscountAmount());
            binding.coupondiscount.setText("$ 0");

            binding.subtotal.setText("$ " + response.getData().getOrderDetail().getpAmountSummery().getpSubTotalAmount());
            // binding.taxname.setText(response.getData().getTaxName() + "(" + response.getData().getTaxPercent() + "):");
            binding.txt.setText("$ " + response.getData().getOrderDetail().getpAmountSummery().getpTaxAmount());
            binding.total.setText("$ " + response.getData().getOrderDetail().getpAmountSummery().getpBillingAmount());

            binding.serveDate.setText( response.getData().getOrderDetail().getOrderDatetime());

            if (response.getData().getOrderDetail().getTipAmount()!=null)
            {
                binding.tipAmountRL.setVisibility(View.VISIBLE);
                binding.tipAmount.setText(response.getData().getOrderDetail().getTipAmount());

            }

            if (response.getData().getOrderDetail().getTipPercent()!=null)
            {
                binding.tipPercentRL.setVisibility(View.VISIBLE);
                binding.tipPercent.setText(response.getData().getOrderDetail().getTipPercent()+"%");

            }

            if (response.getData().getOrderDetail().getGetDeliveryBoy()!=null)
            {
                binding.partnerinformation.setVisibility(View.VISIBLE);
                binding.VaccinatedTv.setText(response.getData().getOrderDetail().getGetDeliveryBoy().getName());

                binding.PartnerNameTv.setText(response.getData().getOrderDetail().getGetDeliveryBoy().getMobileNumber());

            }


            OrderDetailsAdapter gameAdapter = new OrderDetailsAdapter(response, getContext());
            RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            binding.productlistRV.setLayoutManager(mLayoutManager1);
            binding.productlistRV.setItemAnimator(new DefaultItemAnimator());
            binding.productlistRV.setAdapter(gameAdapter);
        }
    }


    @Override
    public void onOrderHistoryError(String message) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();


        Log.e("onOrderHistoryError",message);
    }


    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showRequestDialog(getActivity());
            binding.orderhsitoryLL.setVisibility(View.GONE);
        } else {
            AppTools.hideDialog();
            binding.orderhsitoryLL.setVisibility(View.VISIBLE);
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

        Log.e("onOrderHistoryError",t.getLocalizedMessage());

    }

}