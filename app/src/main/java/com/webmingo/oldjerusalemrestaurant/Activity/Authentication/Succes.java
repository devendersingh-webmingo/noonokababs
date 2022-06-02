package com.webmingo.oldjerusalemrestaurant.Activity.Authentication;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.webmingo.oldjerusalemrestaurant.R;
import com.webmingo.oldjerusalemrestaurant.databinding.ActivitySuccessBinding;

public class Succes extends AppCompatActivity {

    ActivitySuccessBinding activitySuccessBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_welcome);
        activitySuccessBinding = DataBindingUtil.setContentView(this, R.layout.activity_success);
        activitySuccessBinding.llSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Succes.this, "this", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
