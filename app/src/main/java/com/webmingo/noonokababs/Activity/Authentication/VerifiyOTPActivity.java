package com.webmingo.noonokababs.Activity.Authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.webmingo.noonokababs.MainActivity;
import com.webmingo.noonokababs.ModelRepo.Responsee.OTPSendRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.OTPVerificationRepo;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.SharedPrefernce.SharedPrefManager;
import com.webmingo.noonokababs.SharedPrefernce.User_Data;
import com.webmingo.noonokababs.ViewPresenter.DoOTPVerifyPresenter;
import com.webmingo.noonokababs.ViewPresenter.DoSendOtpCreateUserPresenter;
import com.webmingo.noonokababs.databinding.ActivityVerifiyOTPBinding;

import de.mateware.snacky.Snacky;

public class VerifiyOTPActivity extends AppCompatActivity implements DoSendOtpCreateUserPresenter.DoSendOtpCreateUserView, DoOTPVerifyPresenter.DoOTPVerifyView {
    ActivityVerifiyOTPBinding binding;
    private View view;
    Intent intent;
    String Email, Countryid, Phonecode;
    DoSendOtpCreateUserPresenter presenter;
    DoOTPVerifyPresenter doOTPVerifyPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = DataBindingUtil.setContentView(this, R.layout.activity_verifiy_o_t_p);
        presenter = new DoSendOtpCreateUserPresenter(this);
        doOTPVerifyPresenter = new DoOTPVerifyPresenter(this);

        intent = getIntent();
        if (intent != null) {
            Email = intent.getStringExtra("Email");
            Countryid = intent.getStringExtra("Countryid");
            Phonecode = intent.getStringExtra("Phonecode");

            binding.emailid.setText("OTP sent to " + Email);

        }

        binding.DoneOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp = binding.pinview.getText().toString();
                if (otp.length() < 6) {
                    Snacky.builder()
                            .setActivity(VerifiyOTPActivity.this)
                            .setText("The otp field is required.")
                            .setTextColor(getResources().getColor(R.color.white))
                            .success()
                            .show();


                } else {
                    doOTPVerifyPresenter.DoOTPVerify(VerifiyOTPActivity.this, otp);


                }


            }
        });
        binding.ResendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.DoSendOtpCreateUser(VerifiyOTPActivity.this, "231", "1", Email);
            }
        });


    }

    @Override
    public void onCountryError(String message) {
        Snacky.builder()
                .setActivity(VerifiyOTPActivity.this)
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onDoOTPVerifySuccess(OTPVerificationRepo response, String message) {

/*
        Snacky.builder()
                .setActivity(VerifiyOTPActivity.this)
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .success()
                .show();*/

        if (message.equalsIgnoreCase("ok")) {

            SharedPrefManager.getInstance(VerifiyOTPActivity.this)
                    .SetAccessToken(response.getData().getAccessToken());

            SharedPrefManager.getInstance(VerifiyOTPActivity.this)
                    .SetEmail(response.getData().getUser().getEmail());

            showDialog(response.getData().getUser().getName());
            User_Data user_data = new User_Data(response.getData().getUser().getEmail(), response.getData().getUser().getName(), response.getData().getUser().getMobileNumber());
            SharedPrefManager.getInstance(getApplicationContext())
                    .UserDetails(user_data);


        }

    }

    @Override
    public void onDoSendOtpCreateUserSuccess(OTPSendRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {

            Snacky.builder()
                    .setActivity(VerifiyOTPActivity.this)
                    .setText("OTP successfully send on your email id, please verify OTP and login to your account")
                    .setTextColor(getResources().getColor(R.color.white))
                    .success()
                    .show();

            Toast.makeText(this, response.getData().getOtp() + "", Toast.LENGTH_SHORT).show();
            Snacky.builder()
                    .setActivity(VerifiyOTPActivity.this)
                    .setText(response.getData().getOtp())

                    .setTextColor(getResources().getColor(R.color.white))
                    .success()
                    .show();

        }

    }

    @Override
    public void showHideProgress(boolean isShow) {

        if (isShow) {
            binding.spinKit.setVisibility(View.VISIBLE);
        } else {
            binding.spinKit.setVisibility(View.GONE);
        }

    }

    @Override
    public void onCountryFailure(Throwable t) {
        Snacky.builder()
                .setActivity(VerifiyOTPActivity.this)
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    public void showDialog(String name) {


        Dialog dialog = new Dialog(VerifiyOTPActivity.this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.setContentView(R.layout.activity_success);
        dialog.setCancelable(false);
        dialog.show();


        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {

                        if (name == null) {


                            startActivity(new Intent(VerifiyOTPActivity.this, ProfileInfoActivity.class));
                            finish();


                        } else {

                            startActivity(new Intent(VerifiyOTPActivity.this, MainActivity.class));
                            finish();


                        }


                    }
                }, 1500);


    }


}