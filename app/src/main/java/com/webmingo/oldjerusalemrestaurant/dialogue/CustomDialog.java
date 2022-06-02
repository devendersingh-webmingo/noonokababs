package com.webmingo.oldjerusalemrestaurant.dialogue;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.webmingo.oldjerusalemrestaurant.Activity.Authentication.LoginActivity;
import com.webmingo.oldjerusalemrestaurant.Activity.Authentication.ProfileInfoActivity;
import com.webmingo.oldjerusalemrestaurant.Activity.Authentication.WelcomeActivity;
import com.webmingo.oldjerusalemrestaurant.Activity.DeliverylocationActivity;
import com.webmingo.oldjerusalemrestaurant.MainActivity;
import com.webmingo.oldjerusalemrestaurant.R;

public class CustomDialog {


    Dialog dialog1;
    AlertDialog loginDialog;
    Context context;

    public CustomDialog(Context context) {
        this.context = context;
    }


    public void showGIFloader() {
        dialog1 = new Dialog(context);
        dialog1.setContentView(R.layout.dialog_add_to_cart);
        // dialog.getWindow().setBackgroundDrawableResource(R.drawable.back);
        dialog1.show();


    }

    public void dissmiss() {
        dialog1.dismiss();
    }


    public void setLoginDialog() {



        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.alertdialoglogin, null);
        loginDialog = new AlertDialog.Builder(context)
                .setView(view)
                .setCancelable(false)
                .create();



/*
        loginDialog = new Dialog(context,android.R.style.Theme_Dialog);
        loginDialog.setContentView(R.layout.alertdialoglogin);
        loginDialog.setCancelable(false);*/
        loginDialog.show();
     loginDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Button buttonCancel = (Button) loginDialog.findViewById(R.id.buttonCancel);
        Button buttonLogin = (Button) loginDialog.findViewById(R.id.buttonLogin);

        ///builder.setView();
        // builder.setView(loginDialog)

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginDialog.dismiss();


            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                loginDialog.dismiss();
                Intent intent = new Intent(context, LoginActivity.class);// New activity
                context.startActivity(intent);



            }
        });


    }



    public void AlertDialogBox() {




        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("You need to login first.").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //do things
                dialog.dismiss();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();


    }

    public void RemovedLogindissmiss() {
        loginDialog.dismiss();
    }

    public void showloader() {
        Dialog dialog;

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_success);
        dialog.show();
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        TextView tv_dial_subtitle = (TextView) dialog.findViewById(R.id.tv_dial_subtitle);
        tv_dial_subtitle.setText("Order added to cart");
        TextView tv_dial_desc = (TextView) dialog.findViewById(R.id.tv_dial_desc);
        tv_dial_desc.setText("Please check your order in cart");

        Button btn = (Button) dialog.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialog.dismiss();


            }
        });


    }
}
