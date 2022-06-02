package com.webmingo.oldjerusalemrestaurant.Fragments.DrawerLayoutFragment.Payment;

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
import com.webmingo.oldjerusalemrestaurant.Adapters.CartPaymentAdapter;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CardPayentRepo;
import com.webmingo.oldjerusalemrestaurant.R;
import com.webmingo.oldjerusalemrestaurant.ViewPresenter.Payment.DoCartpPayementListPresenter;
import com.webmingo.oldjerusalemrestaurant.databinding.FragmentPaymentsBinding;

import de.mateware.snacky.Snacky;
import okhttp3.ResponseBody;

public class PaymentsFragment extends Fragment implements DoCartpPayementListPresenter.DoCartpPayementView, CartPaymentAdapter.CartPaymentClick {


    NavController navController;
    FragmentPaymentsBinding binding;
    private View view;
    DoCartpPayementListPresenter presenter;
String lasttwochar;


    public PaymentsFragment() {
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

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_payments, container, false);
        view = binding.getRoot();
        presenter = new DoCartpPayementListPresenter(this);
        presenter.DoAddPaymentList(getContext());


        binding.AddCardTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("Key","add");
                navController.navigate(R.id.addCartFragment,bundle);

            }
        });

        return binding.getRoot();
    }

    @Override
    public void onCartpPayementError(String message) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();

    }

    @Override
    public void onCartpPayementSuccess(CardPayentRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            if (response.getData().getCards().getData().size() > 0) {

                CartPaymentAdapter cartPaymentAdapter = new CartPaymentAdapter(response, getContext(), this);
                RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                binding.addressRecyclerView.setLayoutManager(mLayoutManager1);
                binding.addressRecyclerView.setItemAnimator(new DefaultItemAnimator());
                binding.addressRecyclerView.setAdapter(cartPaymentAdapter);

                binding.tvCall.setVisibility(View.GONE);
                binding.addressRecyclerView.setVisibility(View.VISIBLE);

            } else {
                binding.tvCall.setVisibility(View.VISIBLE);
                binding.addressRecyclerView.setVisibility(View.GONE);


            }
        }

    }

    @Override
    public void onDeletePaymentCardSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok")) {


            presenter.DoAddPaymentList(getContext());

            Snacky.builder()
                    .setActivity(getActivity())
                    .setText("Card Deleted Sucecssfully.")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();


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
    public void onCartpPayementFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void EditCartPaymentClickk(CardPayentRepo repo, int pos) {



        if (repo.getData().getCards().getData().get(pos).getExpYear().length() > 2)
        {

            lasttwochar = repo.getData().getCards().getData().get(pos).getExpYear().substring(repo.getData().getCards().getData().get(pos).getExpYear().length() -2);

        }


        Bundle bundle = new Bundle();
        bundle.putString("Key","Edit");
        bundle.putString("cardNumber",repo.getData().getCards().getData().get(pos).getCardNumber());
        bundle.putString("ExpDate",repo.getData().getCards().getData().get(pos).getExpMonth()+"/"+lasttwochar);
        bundle.putString("CVV",repo.getData().getCards().getData().get(pos).getCvv());
        bundle.putString("defualt",repo.getData().getCards().getData().get(pos).getSetAsDefault());
        bundle.putString("future", repo.getData().getCards().getData().get(pos).getFuturePayment());
        bundle.putString("id",String.valueOf(repo.getData().getCards().getData().get(pos).getId()));


        navController.navigate(R.id.addCartFragment,bundle);

     /*   Snacky.builder()
                .setActivity(getActivity())
                .setText(pos)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();*/
    }

    @Override
    public void RemoveCartPaymentClickk(CardPayentRepo repo, int pos) {

        presenter.DoDeletePaymentItem(getContext(), String.valueOf(repo.getData().getCards().getData().get(pos).getId()));


    }
}