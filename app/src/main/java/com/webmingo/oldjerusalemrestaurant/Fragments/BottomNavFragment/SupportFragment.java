package com.webmingo.oldjerusalemrestaurant.Fragments.BottomNavFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.RequestRepo.SupportReq;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.SupportRepo;
import com.webmingo.oldjerusalemrestaurant.R;
import com.webmingo.oldjerusalemrestaurant.SharedPrefernce.SharedPrefManager;
import com.webmingo.oldjerusalemrestaurant.ViewPresenter.DoSupportPresenter;
import com.webmingo.oldjerusalemrestaurant.databinding.FragmentSupportBinding;
import com.webmingo.oldjerusalemrestaurant.dialogue.CustomDialog;

import de.mateware.snacky.Snacky;

public class SupportFragment extends Fragment implements DoSupportPresenter.DoSupportView {
    DoSupportPresenter presenter;
    FragmentSupportBinding binding;
    private View view;
    String name, email, phone, subject, message;


    public SupportFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_support, container, false);
        view = binding.getRoot();
        presenter = new DoSupportPresenter(this);

        binding.SubmitSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (SharedPrefManager.getInstance(getContext()).isLoggedIn()) {


                    Supportdata();
                } else {
                    CustomDialog logindialog = new CustomDialog(getContext());
                    logindialog.AlertDialogBox();

                }


            }
        });


        return binding.getRoot();


    }

    private void Supportdata() {
        name = binding.etPostName.getText().toString().trim();
        email = binding.etPostEmail.getText().toString().trim();
        phone = binding.etPostPhone.getText().toString().trim();
        subject = binding.etPostSubject.getText().toString().trim();
        message = binding.ACTV.getText().toString().trim();


        if (name.isEmpty()) {

            Snacky.builder()
                    .setActivity(getActivity())
                    .setText(" The name field is required. \n")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Snacky.builder()
                    .setActivity(getActivity())
                    .setText(" The email field is required. \n")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        } else if (phone.isEmpty()) {
            Snacky.builder()
                    .setActivity(getActivity())
                    .setText(" The Phone Number  field is required. \n")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();

        } else if (subject.isEmpty()) {
            Snacky.builder()
                    .setActivity(getActivity())
                    .setText("The subject field is required. \n")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();

        } else if (message.isEmpty()) {
            Snacky.builder()
                    .setActivity(getActivity())
                    .setText("The message field is required. ")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();

        } else {
            SupportReq supportReq = new SupportReq(name, email, phone, subject, message);
            presenter.SearchFoodItem(getContext(), supportReq);

        }


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onDoSupportError(String message) {


        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();


    }

    @Override
    public void onDoSupportSuccess(SupportRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            Toast.makeText(getContext(), response.getMessage() + "", Toast.LENGTH_LONG).show();
            Sneaker.with(getActivity())
                    .setTitle(response.getMessage())
                    .setMessage("")
                    .sneakSuccess();

            binding.etPostName.setText("");
            binding.etPostEmail.setText("");
            binding.etPostPhone.setText("");
            binding.etPostSubject.setText("");
            binding.ACTV.setText("");


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
    public void onDoSupportFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }
}