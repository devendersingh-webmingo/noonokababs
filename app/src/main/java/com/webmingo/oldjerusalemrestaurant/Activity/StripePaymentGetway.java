package com.webmingo.oldjerusalemrestaurant.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rjesture.startupkit.AppTools;
import com.stripe.android.ApiResultCallback;
import com.stripe.android.PaymentIntentResult;
import com.stripe.android.Stripe;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.view.CardInputWidget;
import com.webmingo.oldjerusalemrestaurant.MainActivity;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.RequestRepo.CreateOrderReq;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut.CreateOrderRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.Stripee.ConnectionTokenRepo;
import com.webmingo.oldjerusalemrestaurant.R;
import com.webmingo.oldjerusalemrestaurant.SharedPrefernce.SharedPrefManager;
import com.webmingo.oldjerusalemrestaurant.ViewPresenter.D0PaymentTestPresenter;

import java.lang.ref.WeakReference;
import java.util.Objects;

import de.mateware.snacky.Snacky;

public class StripePaymentGetway extends AppCompatActivity implements D0PaymentTestPresenter.D0PaymentView {

    private String paymentIntentClientSecret;
    private Stripe stripe;
    private TextView amountTextView;
    D0PaymentTestPresenter presenter;

    CreateOrderReq createOrderReq, createOrderOnline;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        amountTextView = findViewById(R.id.amountTextView);
        startCheckoutt();
       /* // Configure the SDK with your Stripe publishable key so it can make requests to Stripe
           stripe = new Stripe(
                        getApplicationContext(),
                        Objects.requireNonNull("pk_test_51J7wDmSHlqWBtVLPqxM6DvnG6JnerMoHmSng2obgfTbDogSY8jWnITZnhLDqh0prFAwb2v0MbNXYPIPXYtiS9L4k00gbH9AZ25")
        );*/
       /* Gson gson = new Gson();
        createOrderReq  = gson.fromJson(getIntent().getStringExtra("myjson"), CreateOrderReq.class);
        Log.e("ViewViewCartRequuesting", createOrderReq.toString());

        if (createOrderReq != null) {

            createOrderOnline=new CreateOrderReq(createOrderReq.getName(),createOrderReq.getEmail(),createOrderReq.getMobileNumber(),createOrderReq.getBranch(),
                    createOrderReq.getCouponId(),createOrderReq.getCouponDiscount(),createOrderReq.getTotalPrice(),createOrderReq.getOfferPrice(),createOrderReq.getDiscount(),createOrderReq.getTaxAmount(),createOrderReq.getTaxPercent(),createOrderReq.getDiscountAmount(),createOrderReq.getPaymentMode(),createOrderReq.getDeliveryType(),
                    "Success",createOrderReq.getTotalDiscountAmount(),createOrderReq.getTipPercent(),createOrderReq.getTipAmount(),createOrderReq.getDeliveryDate(),createOrderReq.getDeliveryTime(),createOrderReq.getCreatedByDevice(),createOrderReq.getShippingAddressId(),createOrderReq.getBillingAddressId(),createOrderReq.getSameAsShipping(),createOrderReq.getSameAsBilling(),createOrderReq.getCart(),
                    "","","","","","");
            Log.e("createOrderOnline", createOrderOnline.toString());





        }
*/


    }

    private void startCheckoutt() {
        presenter = new D0PaymentTestPresenter(this);
        presenter.DoName(this, SharedPrefManager.getInstance(this).getTotal());

        Button payButton = findViewById(R.id.payButton);
        payButton.setOnClickListener((View view) -> {
          /*  CardInputWidget cardInputWidget = findViewById(R.id.cardInputWidget);
            PaymentMethodCreateParams params = cardInputWidget.getPaymentMethodCreateParams();
            if (params != null) {

                ConfirmPaymentIntentParams confirmParams = ConfirmPaymentIntentParams
                        .createWithPaymentMethodCreateParams(params, paymentIntentClientSecret);
                stripe.confirmPayment(this, confirmParams);


            }
*/


        });

    }

    private void displayAlert(@NonNull String title,
                              @Nullable String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message);
        builder.setPositiveButton("Ok", null);
        builder.create().show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Handle the result of stripe.confirmPayment
        Log.e("afaa", +requestCode + resultCode + data.toString());
        stripe.onPaymentResult(requestCode, data, new PaymentResultCallback(this));
    }

    @Override
    public void onD0PaymentError(String message) {
        Snacky.builder()
                .setActivity(this)
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onCreateOrderSuccess(CreateOrderRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {
            showDialog(String.valueOf(response.getData().getOrderDetails().getOfferAmount()), response.getData().getOrderDetails().getOrderId());
        }
    }

    @Override
    public void D0PaymentSuccess(ConnectionTokenRepo response, String message) {
        //   Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        if (message.equalsIgnoreCase("ok")) {

            //   Toast.makeText(this, response.getData().getClient_secret(), Toast.LENGTH_SHORT).show();

            // Configure the SDK with your Stripe publishable key so it can make requests to Stripe
            stripe = new Stripe(
                    getApplicationContext(),
                    Objects.requireNonNull(response.getData().getStripe_public_key())
            );
/*
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, String>>(){}.getType();
            Map<String, String> responseMap = gson.fromJson(
                    Objects.requireNonNull(response.body()).string(),
                    type
            );*/
            paymentIntentClientSecret = response.getData().getClient_secret();
            ShowStripePaymentCard();

        }

    }

    public void ShowStripePaymentCard() {

        EditText emailET;
        Dialog dialog;
        ImageView close;


        //LayoutInflater inflater = LayoutInflater.from(getContext());
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.layoutstriplayout);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        TextView PayTV = dialog.findViewById(R.id.PayTV);
        close = dialog.findViewById(R.id.close);
        emailET = dialog.findViewById(R.id.emailET);
        PayTV.setText("Pay $" + SharedPrefManager.getInstance(this).getTotal());
        PayTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CardInputWidget cardInputWidget = dialog.findViewById(R.id.cardInputWidget);
                PaymentMethodCreateParams params = cardInputWidget.getPaymentMethodCreateParams();
                if (params != null) {
                    Log.e("IntentClientSecret", paymentIntentClientSecret);
                    ConfirmPaymentIntentParams confirmParams = ConfirmPaymentIntentParams
                            .createWithPaymentMethodCreateParams(params, paymentIntentClientSecret);
                    stripe.confirmPayment(StripePaymentGetway.this, confirmParams);
                    // Toast.makeText(StripePaymentGetway.this, params + "", Toast.LENGTH_SHORT).show();
                    Log.e("confirmParams", String.valueOf(confirmParams));
                    dialog.dismiss();
                    AppTools.showRequestDialog(StripePaymentGetway.this);


                }
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent in = new Intent(StripePaymentGetway.this, MainActivity.class);
                startActivity(in);

            }
        });

        dialog.show();
    }

    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            // AppTools.showRequestDialog(this);

        } else {
            AppTools.hideDialog();

        }
    }

    @Override
    public void onD0PaymentFailure(Throwable t) {
        Snacky.builder()
                .setActivity(this)
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    private final class PaymentResultCallback
            implements ApiResultCallback<PaymentIntentResult> {
        @NonNull
        private final WeakReference<StripePaymentGetway> activityRef;

        PaymentResultCallback(@NonNull StripePaymentGetway activity) {
            activityRef = new WeakReference<>(activity);
        }

        @Override
        public void onSuccess(@NonNull PaymentIntentResult result) {
            final StripePaymentGetway activity = activityRef.get();
            if (activity == null) {
                return;
            }
            PaymentIntent paymentIntent = result.getIntent();
            PaymentIntent.Status status = paymentIntent.getStatus();
            if (status == PaymentIntent.Status.Succeeded) {

                Gson gson = new Gson();
                createOrderReq = gson.fromJson(getIntent().getStringExtra("myjson"), CreateOrderReq.class);
                Log.e("ViewViewCartRequuesting", createOrderReq.toString());
                Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
                Log.e("PaymentSucess", gson1.toJson(paymentIntent));
                if (createOrderReq != null) {

                    createOrderOnline = new CreateOrderReq(createOrderReq.getName(), createOrderReq.getEmail(), createOrderReq.getMobileNumber(), createOrderReq.getBranch(),
                            createOrderReq.getCouponId(), createOrderReq.getCouponDiscount(), createOrderReq.getTotalPrice(), createOrderReq.getOfferPrice(), createOrderReq.getDiscount(), createOrderReq.getTaxAmount(), createOrderReq.getTaxPercent(), createOrderReq.getDiscountAmount(), createOrderReq.getPaymentMode(), createOrderReq.getDeliveryType(),
                            "Success", createOrderReq.getTotalDiscountAmount(), createOrderReq.getTipPercent(), createOrderReq.getTipAmount(), createOrderReq.getDeliveryDate(), createOrderReq.getDeliveryTime(), createOrderReq.getCreatedByDevice(), createOrderReq.getShippingAddressId(), createOrderReq.getBillingAddressId(), createOrderReq.getSameAsShipping(), createOrderReq.getSameAsBilling(), createOrderReq.getCart(),
                            paymentIntent.getId().toString(), "", "", paymentIntent.getCurrency().toString(), "", paymentIntent.getPaymentMethodId());
                    Log.e("createOrderOnline", createOrderOnline.toString());


                    presenter.CreateOrder(activity, createOrderOnline);


                }

                // Payment completed successfully


             /*   activity.displayAlert(
                        "Payment completed",
                        gson1.toJson(paymentIntent)
                );
*/


            } else if (status == PaymentIntent.Status.RequiresPaymentMethod) {
                // Payment failed – allow retrying using a different payment method
                activity.displayAlert(
                        "Payment failed",
                        Objects.requireNonNull(paymentIntent.getLastPaymentError()).getMessage()
                );
            }
        }


        @Override
        public void onError(@NonNull Exception e) {
            final StripePaymentGetway activity = activityRef.get();
            if (activity == null) {
                return;
            }
            // Payment request failed – allow retrying using the same payment method
            activity.displayAlert("Error", e.toString());
            Log.e("onError", e.toString());

        }
    }

    public void showDialog(String amount, String Ordernumber) {
        TextView success, tvorderAmount, tvordernumber;
        Dialog dialog = new Dialog(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.setContentView(R.layout.createordersuccess);
        dialog.setCancelable(false);
        dialog.show();
        success = dialog.findViewById(R.id.success);
        tvorderAmount = dialog.findViewById(R.id.tvorderAmount);
        tvordernumber = dialog.findViewById(R.id.tvordernumber);
        tvordernumber.setText("Order Id: " + Ordernumber);
        tvorderAmount.setText("Order Amount: $" + amount);
        success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  navController.navigate(R.id.DashboardFragment);
                SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor prefsEditor = mPrefs.edit();
                prefsEditor.remove("viewCartRequest");
                prefsEditor.apply();
*/


                dialog.dismiss();
                Intent in = new Intent(StripePaymentGetway.this, MainActivity.class);
                in.putExtra("key", "Online");
                startActivity(in);
                SharedPreferences mPrefs = StripePaymentGetway.this.getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor prefsEditor = mPrefs.edit();
                prefsEditor.remove("viewCartRequest");
                prefsEditor.apply();


                //navController.navigate(R.id.DashboardFragment);


            }
        });

    }

}