package com.webmingo.noonokababs.Activity.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.webmingo.noonokababs.Adapters.CountrySpinnerAdapter;
import com.webmingo.noonokababs.Modal.Cuntorymodel;
import com.webmingo.noonokababs.ModelRepo.Responsee.CountryRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.OTPSendRepo;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.ViewPresenter.CountryPresenter;
import com.webmingo.noonokababs.ViewPresenter.DoSendOtpCreateUserPresenter;
import com.webmingo.noonokababs.databinding.ActivityLoginBinding;

import java.util.ArrayList;
import java.util.List;

import de.mateware.snacky.Snacky;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, CountryPresenter.CountryView , DoSendOtpCreateUserPresenter.DoSendOtpCreateUserView{
    ActivityLoginBinding activityLoginBinding;

    TextView MoveToSuccess;
    CountryPresenter presenter;
    String Email, Countryid, Phonecode;
    DoSendOtpCreateUserPresenter doSendOtpCreateUserPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);

        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        findViewById();
    }

    private void findViewById() {
        MoveToSuccess = findViewById(R.id.MoveToSuccess);

        doSendOtpCreateUserPresenter= new DoSendOtpCreateUserPresenter(this);
        presenter = new CountryPresenter(this);
        presenter.CountryRepo(this);

        //OnClickListeners
        setOnClickListener();
    }

    private void setOnClickListener() {
        MoveToSuccess.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.MoveToSuccess:
                //startActivity(new Intent(LoginActivity.this, Succes.class));
                DORegister();
            break;
        }
    }

    @Override
    public void onCountryError(String message) {

        Snacky.builder()
                .setActivity(LoginActivity.this)
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onDoSendOtpCreateUserSuccess(OTPSendRepo response, String message) {




        if (message.equalsIgnoreCase("ok"))
        {



         //   Toast.makeText(this, response.getMessage(), Toast.LENGTH_SHORT).show();


            Intent intent = new Intent(LoginActivity.this, VerifiyOTPActivity.class);// New activity
            intent.putExtra("Email", Email);
            intent.putExtra("Countryid", Countryid);
            intent.putExtra("Phonecode", Phonecode);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);


            Toast.makeText(this, response.getData().getOtp() + "", Toast.LENGTH_SHORT).show();




        }

    }

    @Override
    public void onCountrySuccess(CountryRepo response, String message) {
      /*  Snacky.builder()
                .setActivity(LoginActivity.this)
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();*/

        if (message.equalsIgnoreCase("ok")) {


            List<Cuntorymodel> list = new ArrayList<>();
            list.add(new Cuntorymodel("Select Country", "0", "0", "0"));
            for (int i = 0; i < response.getData().getCountries().size(); i++) {

                Cuntorymodel itemData = new Cuntorymodel(response.getData().getCountries().get(i).getName(),
                        response.getData().getCountries().get(i).getId(),
                        response.getData().getCountries().get(i).getPhonecode(),
                        response.getData().getCountries().get(i).getCode());
                list.add(itemData);

            }


            CountrySpinnerAdapter countrySpinnerAdapter = new CountrySpinnerAdapter(LoginActivity.this, R.id.coinName, list);
            activityLoginBinding.SpinnerCountry.setAdapter(countrySpinnerAdapter);
            activityLoginBinding.SpinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    activityLoginBinding.etNumber.setText("+"+list.get(position).getPhonecode());
                    Countryid=list.get(position).getId();
                    Phonecode=list.get(position).getPhonecode();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

        }


    }

    @Override
    public void showHideProgress(boolean isShow) {


        if (isShow) {
            activityLoginBinding.spinKit.setVisibility(View.VISIBLE);
        } else {
            activityLoginBinding.spinKit.setVisibility(View.GONE);
        }

    }

    @Override
    public void onCountryFailure(Throwable t) {

        Snacky.builder()
                .setActivity(LoginActivity.this)
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    private void DORegister() {
        Email=activityLoginBinding.emailET.getText().toString().trim();


        if (Email.trim().isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            Snacky.builder()
                    .setActivity(LoginActivity.this)
                    .setText("Email or Mobile number field must be required.")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        }
        else if (Countryid.equalsIgnoreCase("0"))
        {
                Snacky.builder()
                .setActivity(LoginActivity.this)
                .setText("The country field is required.")
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
        }else {
            ShowemailDialog();

        }


    }

    public void ShowemailDialog() {

        TextView emailid, editTv, okTv;
        AlertDialog alertDialog;

        LayoutInflater inflater = LayoutInflater.from(LoginActivity.this);
        View view = inflater.inflate(R.layout.editemaillayout, null);
        alertDialog = new androidx.appcompat.app.AlertDialog.Builder(LoginActivity.this)
                .setView(view)
                .setCancelable(false)
                .create();


        emailid = view.findViewById(R.id.emailid);
        editTv = view.findViewById(R.id.editTv);

        okTv = view.findViewById(R.id.okTv);
        emailid.setText(activityLoginBinding.emailET.getText().toString());
        okTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doSendOtpCreateUserPresenter.DoSendOtpCreateUser(LoginActivity.this,Countryid,Phonecode,Email);
                alertDialog.dismiss();
            }
        });

        editTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialog.dismiss();


            }
        });
        alertDialog.show();
    }

}

