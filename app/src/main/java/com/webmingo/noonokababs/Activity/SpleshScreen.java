package com.webmingo.noonokababs.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.webmingo.noonokababs.Activity.Authentication.WelcomeActivity;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.Utils.util;
import com.webmingo.noonokababs.databinding.ActivitySpleshScreenBinding;

import de.mateware.snacky.Snacky;

public class SpleshScreen extends AppCompatActivity {
    ActivitySpleshScreenBinding spleshScreenBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_splesh_screen);
        spleshScreenBinding = DataBindingUtil.setContentView(this, R.layout.activity_splesh_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


        if (util.isOnline(getApplicationContext())) {

            new Handler().postDelayed(
                    new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(SpleshScreen.this, WelcomeActivity.class));
                            finish();

                        }
                    }, 3000);
        } else {

            //   new CheckInternetConnection(this).checkConnection();

            Snacky.builder()
                    .setActivity(SpleshScreen.this)
                    .setText("No Internet, Reconnect and Retry !")
                    .setTextColor(getResources().getColor(R.color.white))
                    .error()
                    .show();
            Toast.makeText(SpleshScreen.this, "No Internet, Reconnect and Retry !", Toast.LENGTH_LONG).show();


        }


    }


}
