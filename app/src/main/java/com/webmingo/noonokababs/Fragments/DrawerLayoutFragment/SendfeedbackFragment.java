package com.webmingo.noonokababs.Fragments.DrawerLayoutFragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.rjesture.startupkit.AppTools;
import com.webmingo.noonokababs.ModelRepo.Responsee.RefoundPolicyRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.TermCondition;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.SharedPrefernce.SharedPrefManager;
import com.webmingo.noonokababs.ViewPresenter.DoProfileUpdateDetailsPresenter;
import com.webmingo.noonokababs.ViewPresenter.DoTermConditionPresenter;
import com.webmingo.noonokababs.databinding.FragmentSendfeedbackBinding;

import de.mateware.snacky.Snacky;

public class SendfeedbackFragment extends Fragment implements DoTermConditionPresenter.DoTermConditionView {


    FragmentSendfeedbackBinding binding;
    private View view;
    DoTermConditionPresenter presenter;


    public SendfeedbackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sendfeedback, container, false);
        view = binding.getRoot();
        presenter = new DoTermConditionPresenter(this);
        presenter.DopolicyVerify(getContext());


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
        if (message.equalsIgnoreCase("ok")) {


            binding.headingtv.setText(Html.fromHtml(response.getData().getTerm().getHeading()));
            binding.titletv.setText(Html.fromHtml(response.getData().getTerm().getTitle()));
            binding.tvDescription.setText(Html.fromHtml(response.getData().getTerm().getDescription()));
            binding.tvDescription.setMovementMethod(new ScrollingMovementMethod());


        }
    }

    @Override
    public void onDoRefoundPolicySuccess(RefoundPolicyRepo response, String message) {

    }

    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showRequestDialog(getActivity());
            binding.LLSendFeedback.setVisibility(View.GONE);

        } else {
            AppTools.hideDialog();
            binding.LLSendFeedback.setVisibility(View.VISIBLE);

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