package com.webmingo.oldjerusalemrestaurant.Fragments.DrawerLayoutFragment.Policy;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjesture.startupkit.AppTools;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.RefoundPolicyRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.TermCondition;
import com.webmingo.oldjerusalemrestaurant.R;
import com.webmingo.oldjerusalemrestaurant.ViewPresenter.DoTermConditionPresenter;
import com.webmingo.oldjerusalemrestaurant.databinding.FragmentRefundPolicyBinding;

import de.mateware.snacky.Snacky;

public class RefundPolicyFragment extends Fragment implements DoTermConditionPresenter.DoTermConditionView {

    FragmentRefundPolicyBinding binding;
    private View view;
    DoTermConditionPresenter presenter;


    public RefundPolicyFragment() {
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_refund_policy, container, false);
        view = binding.getRoot();
        presenter = new DoTermConditionPresenter(this);
        presenter.RefoundPolicy(getContext());
        return binding.getRoot();
    }


    @Override
    public void onTermConditionError(String message) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onDoOTPVerifySuccess(TermCondition response, String message) {
       /* if (message.equalsIgnoreCase("ok")) {


            binding.headingtv.setText(Html.fromHtml(response.getData().getTerm().getHeading()));
            binding.titletv.setText(Html.fromHtml(response.getData().getTerm().getTitle()));
            binding.tvDescription.setText(Html.fromHtml(response.getData().getTerm().getDescription()));
            binding.tvDescription.setMovementMethod(new ScrollingMovementMethod());


        }*/
    }

    @Override
    public void onDoRefoundPolicySuccess(RefoundPolicyRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {


            binding.headingtv.setText(Html.fromHtml(response.getData().getContent().getHeading()));
            binding.titletv.setText(Html.fromHtml(response.getData().getContent().getTitle()));
            binding.tvDescription.setText(Html.fromHtml(response.getData().getContent().getDescription()));
            binding.tvDescription.setMovementMethod(new ScrollingMovementMethod());


        }
    }

    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showRequestDialog(getActivity());
            binding.LLTermsCondition.setVisibility(View.GONE);

        } else {
            AppTools.hideDialog();
            binding.LLTermsCondition.setVisibility(View.VISIBLE);

        }

    }

    @Override
    public void onTermConditionFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();

    }
}