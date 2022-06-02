package com.webmingo.oldjerusalemrestaurant.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.rjesture.startupkit.AppTools;
import com.webmingo.oldjerusalemrestaurant.Activity.Authentication.LoginActivity;
import com.webmingo.oldjerusalemrestaurant.Activity.Authentication.WelcomeActivity;
import com.webmingo.oldjerusalemrestaurant.Adapters.BranchListResturnetAdapter;
import com.webmingo.oldjerusalemrestaurant.Adapters.DeliverylistAdapter;
import com.webmingo.oldjerusalemrestaurant.MainActivity;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut.BranchsRepo;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut.DeliveryTypes;
import com.webmingo.oldjerusalemrestaurant.R;
import com.webmingo.oldjerusalemrestaurant.SharedPrefernce.SharedPrefManager;
import com.webmingo.oldjerusalemrestaurant.ViewPresenter.BranchListPresenter;
import com.webmingo.oldjerusalemrestaurant.databinding.ActivityDeliverylocationBinding;

import de.mateware.snacky.Snacky;

public class DeliverylocationActivity extends AppCompatActivity implements  BranchListPresenter.GetUserAddressView,DeliverylistAdapter.AddressAdapterClick{
    ActivityDeliverylocationBinding binding;
    Intent intent;
    String key,branchid;
    BranchListPresenter branchListPresenter;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_deliverylocation);

        intent = getIntent();
        if (intent != null) {
            key = intent.getStringExtra("key");
            branchid = intent.getStringExtra("branchid");


        }
        branchListPresenter=new BranchListPresenter(this);
        branchListPresenter.GetDeliveryTypes(DeliverylocationActivity.this);

        binding.IVimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();

            }
        });
     //   Log.e("Branchcccc",SharedPrefManager.getInstance(DeliverylocationActivity.this).GetBranch()+"\n"+SharedPrefManager.getInstance(DeliverylocationActivity.this).GetDroptype());


       /* binding.deliveryRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (key.equalsIgnoreCase("OrderNow"))
                {

                    Intent intent = new Intent(DeliverylocationActivity.this, MainActivity.class);// New activity
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(DeliverylocationActivity.this, LoginActivity.class);// New activity
                    startActivity(intent);
                }

                Toast.makeText(DeliverylocationActivity.this, "delivery", Toast.LENGTH_SHORT).show();

            }
        });*/
       /* binding.pickupRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (key.equalsIgnoreCase("OrderNow"))
                {

                    Intent intent = new Intent(DeliverylocationActivity.this, MainActivity.class);// New activity
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(DeliverylocationActivity.this, LoginActivity.class);// New activity
                    startActivity(intent);
                }


                SharedPrefManager.getInstance(getApplicationContext())
                        .SetBranchAndDrop();

                //Toast.makeText(DeliverylocationActivity.this, "pickup", Toast.LENGTH_SHORT).show();
            }
        });*/

    }
    @Override
    public void onGetUserAddressError(String message) {

        Snacky.builder()
                .setActivity(DeliverylocationActivity.this)
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onGetBranchsListSuccess(BranchsRepo response, String message) {



    }

    @Override
    public void onGetDeliveryTypesSuccess(DeliveryTypes response, String message) {

        if (message.equalsIgnoreCase("ok"))
        {
            if (response.getData().getTypes().size()>0){

                DeliverylistAdapter branchListResturnetAdapter = new DeliverylistAdapter(response, DeliverylocationActivity.this, this);

                RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(DeliverylocationActivity.this, LinearLayoutManager.VERTICAL, false);


               binding.deleveryRV.setLayoutManager(mLayoutManager1);
                binding.deleveryRV.setItemAnimator(new DefaultItemAnimator());
                binding.deleveryRV.setAdapter(branchListResturnetAdapter);
            }
        }
    }


    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showRequestDialog(DeliverylocationActivity.this);

        } else {
            AppTools.hideDialog();

        }
    }

    @Override
    public void onGetUserAddressFailure(Throwable t) {
        Snacky.builder()
                .setActivity(DeliverylocationActivity.this)
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void Setas(DeliveryTypes repo, int pos) {
        if (key.equalsIgnoreCase("OrderNow"))
        {


            SharedPrefManager.getInstance(getApplicationContext())
                    .SetBranchAndDrop(branchid,repo.getData().getTypes().get(pos).getValue());
            Intent intent = new Intent(DeliverylocationActivity.this, MainActivity.class);// New activity
            startActivity(intent);
        }else {

            SharedPrefManager.getInstance(getApplicationContext())
                    .SetBranchAndDrop(branchid,repo.getData().getTypes().get(pos).getValue());
            Intent intent = new Intent(DeliverylocationActivity.this, LoginActivity.class);// New activity
            startActivity(intent);
        }


    }
}