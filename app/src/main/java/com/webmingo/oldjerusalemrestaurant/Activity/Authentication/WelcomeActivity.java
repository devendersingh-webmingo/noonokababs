package com.webmingo.oldjerusalemrestaurant.Activity.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rjesture.startupkit.AppTools;
import com.webmingo.oldjerusalemrestaurant.Activity.DeliverylocationActivity;
import com.webmingo.oldjerusalemrestaurant.Adapters.BranchListResturnetAdapter;
import com.webmingo.oldjerusalemrestaurant.Adapters.CheckOut.BranchLitAdapter;
import com.webmingo.oldjerusalemrestaurant.Adapters.ExploreFoodItemAdapter;
import com.webmingo.oldjerusalemrestaurant.MainActivity;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut.BranchsRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut.DeliveryTypes;
import com.webmingo.oldjerusalemrestaurant.R;
import com.webmingo.oldjerusalemrestaurant.SharedPrefernce.SharedPrefManager;
import com.webmingo.oldjerusalemrestaurant.Utils.util;
import com.webmingo.oldjerusalemrestaurant.ViewPresenter.BranchListPresenter;
import com.webmingo.oldjerusalemrestaurant.databinding.ActivityWelcomeBinding;

import de.mateware.snacky.Snacky;

public class WelcomeActivity extends AppCompatActivity  implements BranchListResturnetAdapter.AddressAdapterClick, BranchListPresenter.GetUserAddressView{

    ActivityWelcomeBinding activityWelcomeBinding;

    AlertDialog alertDialog;
    BranchListPresenter branchListPresenter;
    String branchid;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_welcome);
        activityWelcomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);
        util.checkDexter(WelcomeActivity.this);
        branchListPresenter=new BranchListPresenter(this);
        branchListPresenter.GetBranchList(WelcomeActivity.this);


        activityWelcomeBinding.OrderNowTV.setOnClickListener(new View.OnClickListener() {
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


                    Intent intent = new Intent(WelcomeActivity.this, DeliverylocationActivity.class);// New activity
                    intent.putExtra("key", "OrderNow");;
                    intent.putExtra("branchid", branchid);

                    startActivity(intent);


                }




                // Toast.makeText(WelcomeActivity.this, "this", Toast.LENGTH_SHORT).show();


            }
        });
        activityWelcomeBinding.Logintoyouraccount.setOnClickListener(new View.OnClickListener() {
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
                   /* Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                    startActivity(intent);
*/

                    Intent intent = new Intent(WelcomeActivity.this, DeliverylocationActivity.class);// New activity
                    intent.putExtra("key", "Logintoyouraccount");
                    intent.putExtra("branchid", branchid);
                    startActivity(intent);

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



        activityWelcomeBinding.BranchLocationIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                branchListPresenter.GetBranchList(WelcomeActivity.this);
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


    public void ShowemailDialog(BranchsRepo branchsRepo) {

        RecyclerView branchlistRV;



        LayoutInflater inflater = LayoutInflater.from(WelcomeActivity.this);
        View view = inflater.inflate(R.layout.branchresturnetlist, null);
        alertDialog = new androidx.appcompat.app.AlertDialog.Builder(WelcomeActivity.this)
                .setView(view)
                .setCancelable(false)
                .create();



        branchlistRV = view.findViewById(R.id.branchlistRV);



        BranchListResturnetAdapter branchListResturnetAdapter = new BranchListResturnetAdapter(branchsRepo, WelcomeActivity.this, this);

        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(WelcomeActivity.this, LinearLayoutManager.VERTICAL, false);

        branchlistRV.setLayoutManager(mLayoutManager1);
        branchlistRV.setItemAnimator(new DefaultItemAnimator());
        branchlistRV.setAdapter(branchListResturnetAdapter);


        alertDialog.show();
    }

    @Override
    public void Setas(BranchsRepo response, int pos) {

        alertDialog.dismiss();
        activityWelcomeBinding.branchaddresTV.setText(response.getData().getBranches().get(pos).getAddress()+response.getData().getBranches().get(pos).getGetCity().getName()+", \n"+response.getData().getBranches().get(pos).getGetState().getName()+response.getData().getBranches().get(pos).getGetCountry().getName());
        branchid=  String.valueOf(response.getData().getBranches().get(pos).getId());





    }

    @Override
    public void onGetUserAddressError(String message) {

        Snacky.builder()
                .setActivity(WelcomeActivity.this)
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onGetBranchsListSuccess(BranchsRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {

            if (response.getData().getBranches().size() > 1) {

                ShowemailDialog(response);

            }
            if (response.getData().getBranches().size() == 1) {

                //holder.AddresTv.setText(modelArrayList.getData().getBranches().get(position).getAddress()+modelArrayList.getData().getBranches().get(position).getGetCity().getName()+",\n  "+modelArrayList.getData().getBranches().get(position).getGetState().getName()+ ",  "+modelArrayList.getData().getBranches().get(position).getGetCountry().getName());

                activityWelcomeBinding.branchaddresTV.setText(response.getData().getBranches().get(0).getAddress()+", "+response.getData().getBranches().get(0).getGetCity().getName()+", "+response.getData().getBranches().get(0).getGetState().getName()+" \n"+response.getData().getBranches().get(0).getGetCountry().getName());
                branchid=  String.valueOf(response.getData().getBranches().get(0).getId());





            }
            else {

                activityWelcomeBinding.branchaddresTV.setText("Your nearest location not available");
            }
        }


    }

    @Override
    public void onGetDeliveryTypesSuccess(DeliveryTypes response, String message) {

    }


    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showRequestDialog(WelcomeActivity.this);

        } else {
            AppTools.hideDialog();

        }
    }

    @Override
    public void onGetUserAddressFailure(Throwable t) {
        Snacky.builder()
                .setActivity(WelcomeActivity.this)
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }
}