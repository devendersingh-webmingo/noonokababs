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
import com.webmingo.noonokababs.R;

public class ChangepasswordBottom  extends BottomSheetDialogFragment  {


    //TextView exit, otpContinue;
    //EditText EditMoney;
    BottomSheetDialog bottomSheet;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        bottomSheet = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);


        View view = View.inflate(getContext(), R.layout.changepasswordbottom, null);
        //exit = view.findViewById(R.id.exit);

        bottomSheet.setContentView(view);
        bottomSheet.setCancelable(false);
        bottomSheet.setCanceledOnTouchOutside(false);





        return bottomSheet;
    }




}
