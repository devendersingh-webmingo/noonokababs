package com.webmingo.oldjerusalemrestaurant.Fragments.DrawerLayoutFragment.OrderHistory;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.core.text.HtmlCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rjesture.startupkit.AppTools;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Orderhistory.HistoryDetailsRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Orderhistory.InvoiceRepo;
import com.webmingo.oldjerusalemrestaurant.R;
import com.webmingo.oldjerusalemrestaurant.ViewPresenter.OrderHistoryDetailsPresenter;
import com.webmingo.oldjerusalemrestaurant.ViewPresenter.OrderHistoryPresenter;
import com.webmingo.oldjerusalemrestaurant.databinding.FragmentInvoiceWebBinding;

import de.mateware.snacky.Snacky;

public class InvoiceWebFragment extends Fragment  implements OrderHistoryDetailsPresenter.OrderHistoryDetailsView {
    FragmentInvoiceWebBinding binding;

    private View view;
    NavController navController;
    String id;
    OrderHistoryDetailsPresenter presenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_invoice_web, container, false);
        view = binding.getRoot();


        presenter = new OrderHistoryDetailsPresenter(this);

        if (getArguments().getString("id") != null) {
            id = getArguments().getString("id");




            presenter.OrderInvoiceDetails(getContext(), id);


              Toast.makeText(getContext(), id, Toast.LENGTH_SHORT).show();

        } else {
            //Toast.makeText(getContext(), id, Toast.LENGTH_SHORT).show();
        }

//        presenter = new OrderHistoryPresenter(this);
  //      presenter.AllHistoryList(getContext(), "All");


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
    public void onOrderHistoryDetailsSuccess(HistoryDetailsRepo response, String message) {

    }

    @Override
    public void onOrderInvoiceSuccess(InvoiceRepo response, String message) {
        if (message.equalsIgnoreCase("ok"))
        {


           binding.simpleWebView.getSettings().setJavaScriptEnabled(true);
            binding.simpleWebView.loadUrl(response.geturl()); // load the url on the web view


        }

    }

    @Override
    public void showHideProgress(boolean isShow) {


        if (isShow) {
            AppTools.showRequestDialog(getActivity());
        } else {
            AppTools.hideDialog();
//            binding.orderhsitoryLL.setVisibility(View.VISIBLE);
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
}