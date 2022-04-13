package com.webmingo.noonokababs.Activity.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.webmingo.noonokababs.MainActivity;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.SharedPrefernce.SharedPrefManager;
import com.webmingo.noonokababs.Utils.util;
import com.webmingo.noonokababs.databinding.ActivityWelcomeBinding;

import de.mateware.snacky.Snacky;

public class WelcomeActivity extends AppCompatActivity {

    ActivityWelcomeBinding activityWelcomeBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_welcome);
        activityWelcomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);

        util.checkDexter(WelcomeActivity.this);

        activityWelcomeBinding.AgreeandContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!util.isNetworkConnected(WelcomeActivity.this)) {


                    Snacky.builder()
                            .setActivity(WelcomeActivity.this)
                            .setText("No Internet, Reconnect and Retry !")
                            .setTextColor(getResources().getColor(R.color.white))
                            .warning()
                            .show();
                    Toast.makeText(WelcomeActivity.this, "No Internet, Reconnect and Retry !", Toast.LENGTH_LONG).show();

                } else {
                    startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
                    finish();
                }


                // Toast.makeText(WelcomeActivity.this, "this", Toast.LENGTH_SHORT).show();


            }
        });

        activityWelcomeBinding.TermsofService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(WelcomeActivity.this,PrivacyPolicyActivity.class);
                in.putExtra("key","TermsofService");
                startActivity(in);

               // Toast.makeText(WelcomeActivity.this, "TermsofService", Toast.LENGTH_SHORT).show();
            }
        });

        activityWelcomeBinding.PrivacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(WelcomeActivity.this,PrivacyPolicyActivity.class);
                in.putExtra("key","PrivacyPolicy");
                startActivity(in);

            }
        });




    }

    @Override
    protected void onStart() {
        super.onStart();
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}