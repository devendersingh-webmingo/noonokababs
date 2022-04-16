package com.webmingo.noonokababs.dialogue;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.rjesture.startupkit.AppTools;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.ViewPresenter.UpdatePasswordPresenter;

import okhttp3.ResponseBody;

public class ChangepasswordBottom extends BottomSheetDialogFragment implements UpdatePasswordPresenter.UpdatePasswordView {


    TextView saveTv, cancelTv;
    EditText oldpasswordET, passwordET, ConfirmPasswordTV;
    BottomSheetDialog bottomSheet;
    UpdatePasswordPresenter presenter;
    String oldpassword, password, confirmpassword;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        bottomSheet = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);


        View view = View.inflate(getContext(), R.layout.changepasswordbottom, null);
        saveTv = view.findViewById(R.id.saveTv);
        cancelTv = view.findViewById(R.id.cancelTv);


        oldpasswordET = view.findViewById(R.id.oldpasswordET);
        passwordET = view.findViewById(R.id.passwordET);
        ConfirmPasswordTV = view.findViewById(R.id.ConfirmPasswordTV);

        presenter = new UpdatePasswordPresenter(this);

        bottomSheet.setContentView(view);
        bottomSheet.setCancelable(false);
        bottomSheet.setCanceledOnTouchOutside(false);

        cancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheet.cancel();
            }
        });

        saveTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oldpassword = oldpasswordET.getText().toString().trim();
                password = passwordET.getText().toString().trim();
                confirmpassword = ConfirmPasswordTV.getText().toString().trim();

                if (oldpassword.isEmpty()) {
                    Toast.makeText(getContext(), "Old Password is required", Toast.LENGTH_LONG).show();

                } else if (password.isEmpty()) {
                    Toast.makeText(getContext(), "New Password is required", Toast.LENGTH_LONG).show();

                } else if (confirmpassword.isEmpty() ) {
                    Toast.makeText(getContext(), "Confirm Password is required", Toast.LENGTH_LONG).show();

                } else  if (!password.matches(confirmpassword)) {
                    Toast.makeText(getContext(), "Confirm Password is not matched", Toast.LENGTH_LONG).show();

                } else {
                    presenter.UpdatePassword(getContext(), oldpassword, password, confirmpassword);
                }


            }
        });

        return bottomSheet;
    }


    @Override
    public void onUpdatePasswordError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();


    }

    @Override
    public void onUpdatePasswordSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            Toast.makeText(getContext(), "Your Password Updated Successfully.", Toast.LENGTH_LONG).show();
            bottomSheet.cancel();

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
    public void onUpdatePasswordFailure(Throwable t) {
        Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

    }
}
