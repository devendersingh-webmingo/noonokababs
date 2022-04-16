package com.webmingo.noonokababs.dialogue;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.webmingo.noonokababs.R;

public class CustomDialog {


    Dialog dialog1, loginDialog;
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

        loginDialog = new Dialog(context);
        loginDialog.setContentView(R.layout.alertdialoglogin);
        loginDialog.show();
        loginDialog.setCancelable(false);
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
                loginDialog.dismiss();


            }
        });


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
