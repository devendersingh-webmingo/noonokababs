package com.webmingo.noonokababs.Activity.Authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rjesture.startupkit.AppTools;
import com.webmingo.noonokababs.ModelRepo.Responsee.RefoundPolicyRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.TermCondition;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.ViewPresenter.DoTermConditionPresenter;

import de.mateware.snacky.Snacky;

public class PrivacyPolicyActivity extends AppCompatActivity implements DoTermConditionPresenter.DoTermConditionView {
    Intent intent;
    String key;
    DoTermConditionPresenter presenter;
    TextView headingtv, titletv, tv_description;
    LinearLayout llPrivacylayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        presenter = new DoTermConditionPresenter(this);
        titletv = findViewById(R.id.titletv);
        headingtv = findViewById(R.id.headingtv);
        tv_description = findViewById(R.id.tv_description);

        llPrivacylayout = findViewById(R.id.llPrivacylayout);

        intent = getIntent();
        if (intent != null) {
            key = intent.getStringExtra("key");

            if (key.equalsIgnoreCase("PrivacyPolicy")) {

                presenter.DopolicyVerify(this);
               /* String url = "https://www.miraclesaba.xyz/restaurant/policy";
                simpleWebView.getSettings().setJavaScriptEnabled(true);
                simpleWebView.loadUrl(url); // load the url on the web view
                */


                // AppTools.hideDialog();

            } else {

                presenter.DoTermConditionVerify(this);
              /*  String url = "https://www.miraclesaba.xyz/restaurant/terms";
                simpleWebView.getSettings().setJavaScriptEnabled(true);
                simpleWebView.loadUrl(url); // load the url on the web view*/


            }


        }


        headingtv.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onTermConditionError(String message) {
        Snacky.builder()
                .setActivity(this)
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onDoOTPVerifySuccess(TermCondition response, String message) {
        if (message.equalsIgnoreCase("ok")) {

            headingtv.setText(Html.fromHtml(response.getData().getTerm().getHeading()));
            titletv.setText(Html.fromHtml(response.getData().getTerm().getTitle()));
            tv_description.setText(Html.fromHtml(response.getData().getTerm().getDescription()));
            tv_description.setMovementMethod(new ScrollingMovementMethod());


        }


    }

    @Override
    public void onDoRefoundPolicySuccess(RefoundPolicyRepo response, String message) {

    }

    @Override
    public void showHideProgress(boolean isShow) {

        if (isShow) {
            AppTools.showRequestDialog(this);
            llPrivacylayout.setVisibility(View.GONE);

        } else {
            AppTools.hideDialog();
            llPrivacylayout.setVisibility(View.VISIBLE);

        }

    }


    @Override
    public void onTermConditionFailure(Throwable t) {
        Snacky.builder()
                .setActivity(this)
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }
}