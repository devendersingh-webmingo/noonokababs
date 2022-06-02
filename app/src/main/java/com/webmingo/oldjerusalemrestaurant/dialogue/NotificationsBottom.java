package com.webmingo.oldjerusalemrestaurant.dialogue;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.rjesture.startupkit.AppTools;
import com.webmingo.oldjerusalemrestaurant.R;
import com.webmingo.oldjerusalemrestaurant.ViewPresenter.FoodFavourite.NotificationSettingPresenter;

import de.mateware.snacky.Snacky;
import okhttp3.ResponseBody;

public class NotificationsBottom extends BottomSheetDialogFragment implements NotificationSettingPresenter.NotificationSettingView {


    TextView CancelTV, SaveTv;
    //EditText EditMoney;
    BottomSheetDialog bottomSheet;
    CheckBox MobileNotificationCheckBoox, EmailNotificationCheckBoox;

    NotificationSettingPresenter presenter;
    String Email, Mobile;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        bottomSheet = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);


        View view = View.inflate(getContext(), R.layout.notificationbottom, null);
        presenter = new NotificationSettingPresenter(this);

        MobileNotificationCheckBoox = view.findViewById(R.id.MobileNotificationCheckBoox);
        EmailNotificationCheckBoox = view.findViewById(R.id.EmailNotificationCheckBoox);
        CancelTV = view.findViewById(R.id.CancelTV);
        SaveTv = view.findViewById(R.id.SaveTv);

        bottomSheet.setContentView(view);
        bottomSheet.setCancelable(false);
        bottomSheet.setCanceledOnTouchOutside(false);


        SaveTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (MobileNotificationCheckBoox.isChecked()) {
                    Mobile = "Yes";

                } else {
                    Mobile = "No";

                }
                if (EmailNotificationCheckBoox.isChecked()) {
                    Email = "Yes";

                } else {
                    Email = "No";

                }


                presenter.NotificationSetting(getContext(), Mobile, Email);
                Toast.makeText(getContext(), Mobile+Email+"", Toast.LENGTH_SHORT).show();

            }
        });

        CancelTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheet.cancel();
            }
        });
        return bottomSheet;
    }


    @Override
    public void onNotificationSettingError(String message) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onNotificationSettingSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok")) {


            bottomSheet.cancel();

        /*    Snacky.builder()
                    .setActivity(getActivity())
                    .setText(message)
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();*/


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
    public void onNotificationSettingFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }
}
