package com.webmingo.noonokababs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.rjesture.startupkit.AppTools;
import com.webmingo.noonokababs.Activity.Authentication.LoginActivity;
import com.webmingo.noonokababs.Fragments.DrawerLayoutFragment.NotificationsFragment;
import com.webmingo.noonokababs.ModelRepo.RequestRepo.ViewCartRequest;
import com.webmingo.noonokababs.ModelRepo.Responsee.DashboardRepo;
import com.webmingo.noonokababs.SharedPrefernce.SharedPrefManager;
import com.webmingo.noonokababs.SharedPrefernce.ViewCartReqSharedPreferenc;
import com.webmingo.noonokababs.ViewPresenter.DoLogoutPresenter;

import de.mateware.snacky.Snacky;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DoLogoutPresenter.DoLogoutView {

    NavController navController;
    DrawerLayout drawer;
    NavigationView navigationView;
    AppBarConfiguration appBarConfiguration;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;

    private View navHeader, navDrawer;
    TextView username, usergmail, text_cart_Count;
    ImageView img_discount, img_search;
    Boolean backhome = false;
    RelativeLayout relative, img_cart;
    private Context context;
    private Dialog dialog;
    private View view;
    Boolean CheckedLogin;
    int cartCount;
    ImageView switchIV;
    DoLogoutPresenter presenter;

    RelativeLayout relative_cart;

    ImageView profile_Image;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        SetBottomBarNavigationView();
        navHeader = navigationView.getHeaderView(0);
        initview();
    }

    private void initview() {
        presenter = new DoLogoutPresenter(this);
        switchIV = navHeader.findViewById(R.id.switchIV);
        username = navHeader.findViewById(R.id.nav_username);
        profile_Image = navHeader.findViewById(R.id.profile_Image);
        relative_cart = findViewById(R.id.relative_cart);
        presenter.DoName(MainActivity.this);
        switchIV.setOnClickListener(this);
        relative_cart.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {


        int fragmentsInStack = getSupportFragmentManager().getBackStackEntryCount();

        ///Toast.makeText(context, String.valueOf(getSupportFragmentManager().getBackStackEntryCount())+"", Toast.LENGTH_SHORT).show();
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }/*else if (bottomNavigationView.getSelectedItemId()==R.id.home_Fragment)
        {
            if (backhome ==true ){
                startActivity(new Intent(this, MainActivity.class));
                finish();
                backhome =false;
            }else{
                super.onBackPressed();

            }
        }*/
        /*else {
            if (bottomNavigationView.getSelectedItemId()==R.id.home_Fragment){
                if (backhome ==true ){
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                    backhome =false;
                }else{
                    new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText(getResources().getString(R.string.app_name))
                            .setContentText("Are you sure you want to close App?")
                            .setCancelText("Cancel")
                            .setConfirmText("Exit")
                            .showCancelButton(true)
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                    Intent a = new Intent(Intent.ACTION_MAIN);
                                    a.addCategory(Intent.CATEGORY_HOME);
                                    a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(a);
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                        finishAffinity();
                                    }
                                    finish();
                                    sweetAlertDialog.dismissWithAnimation();
                                }
                            })
                            .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    //  sDialog.cancel();
                                    sDialog.dismissWithAnimation();
                                }
                            })
                            .show();

                }
              }*/
        else {

            super.onBackPressed();

            // navController.getGraph().getLabel()

            //navController.toString();

          /*  R.id.home_Fragment;
            int fragmentsInStack = getSupportFragmentManager().getBackStackEntryCount();
            Fragment fr = getSupportFragmentManager().findFragmentById(R.id.main);
            String fragmentName = fr.getClass().getSimpleName();
            Toast.makeText(this, fragmentName + "", Toast.LENGTH_SHORT).show();*/

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.switchIV:

                AlertDialogBox();
                //startActivity(new Intent(LoginActivity.this, Succes.class));

                break;
            case R.id.relative_cart:

                navController.navigate(R.id.notificationsFragment);


                break;


        }


    }


    @Override
    public boolean onSupportNavigateUp() {
        // toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_icon_menu));
        return NavigationUI.navigateUp(navController, appBarConfiguration);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
    }

    private void SetBottomBarNavigationView() {
        drawer = findViewById(R.id.drawer);

        navigationView = findViewById(R.id.navigationView);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        navController = Navigation.findNavController(this, R.id.main);
        appBarConfiguration = new AppBarConfiguration.Builder(
                new int[]{R.id.home_Fragment,
                        R.id.supportFragment,
                        R.id.DashboardFragment,
                        R.id.foodFragment,
                        R.id.menuFragment,
                        R.id.profileFragment,
                        R.id.notificationsFragment,
                        R.id.orderhistoryFragment,
                        R.id.favoritesFragment,
                        R.id.addressBookFragment,
                        R.id.paymentsFragment,
                        R.id.howitworkFragment,
                        R.id.contactsupportFragment,
                        R.id.legalFragment,
                        R.id.sendfeedbackFragment,
                        R.id.reviewsFragment,
                        R.id.termsConditionsFragment,
                        R.id.RefundPolicy



                })
                .setDrawerLayout(drawer)
                .build();
        NavigationUI.setupWithNavController(navigationView, navController);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        // NavigationUI.setupWithNavController(toolbar,navController,drawer);
        //  toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_icon_menu));
        //toolbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getId() == R.id.notificationsFragment
                        || destination.getId() == R.id.orderhistoryFragment
                        || destination.getId() == R.id.favoritesFragment
                        || destination.getId() == R.id.editProfileFragment
                        || destination.getId() == R.id.addressBookFragment
                        || destination.getId() == R.id.paymentsFragment
                        || destination.getId() == R.id.howitworkFragment
                        || destination.getId() == R.id.contactsupportFragment
                        || destination.getId() == R.id.sendfeedbackFragment
                        || destination.getId() == R.id.legalFragment
                        || destination.getId() == R.id.reviewsFragment
                        || destination.getId() == R.id.writeReviewFragment
                        || destination.getId() == R.id.addCartFragment
                        || destination.getId() == R.id.searchFragment
                        || destination.getId() == R.id.mapsFragment
                        || destination.getId() == R.id.foodDetailFragment
                        || destination.getId() == R.id.addtoCartDetailsFragment
                        || destination.getId() == R.id.checkOutCartFragment
                        || destination.getId() == R.id.chackoutFragment
                        || destination.getId() == R.id.DashboardFragment
                        || destination.getId() == R.id.orderHistoryDetailsFragment
                        || destination.getId() == R.id.termsConditionsFragment


                ) {

                    bottomNavigationView.setVisibility(View.GONE);
                } /*else if (destination.getId() == R.id.address || destination.getId() == R.id.My_address || destination.getId() == R.id.ChangePassword || destination.getId() == R.id.ChangeEmail) {
                    img_search.setVisibility(View.VISIBLE);
                    bottomNavigationView.setVisibility(View.GONE);
                }*/ else {
                    /*img_discount.setVisibility(View.VISIBLE);
                    bottomNavigationView.setVisibility(View.VISIBLE);
                    img_search.setVisibility(View.GONE);*/

                    bottomNavigationView.setVisibility(View.VISIBLE);
                }


            }
        });
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    public void onDoLogoutError(String message) {
        Snacky.builder()
                .setActivity(this)
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onDoLogoutSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            Toast.makeText(this, "User Logout Successfully.", Toast.LENGTH_SHORT).show();
            SharedPrefManager.getInstance(this).logout();
            // ViewCartReqSharedPreferenc.ViewCartReqClear(this);

            SharedPreferences mPrefs = MainActivity.this.getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor prefsEditor = mPrefs.edit();
            prefsEditor.remove("viewCartRequest");
            prefsEditor.apply();

            startActivity(new Intent(this, LoginActivity.class));
            finish();
/*

            SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor prefsEditor = mPrefs.edit();
            Gson gson = new Gson();
            String json = gson.toJson(viewCartRequest);
            prefsEditor.putString("viewCartRequest", json);
            prefsEditor.commit();
*/



        /*    SharedPreferences sharedPreferences = context.getSharedPreferences("viewCartRequest", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
*/


        }

    }

    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showRequestDialog(this);

        } else {
            AppTools.hideDialog();

        }
    }

    @Override
    public void onDoHomePageSuccess(DashboardRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {

            username.setText(response.getData().getUserInfo().getName());

            if (response.getData().getUserInfo().getProfilePhoto() != null) {
                Glide.with(this)
                        .load(response.getData().getImageBaseUrl() + response.getData().getUserInfo().getProfilePhoto())
                        .into(profile_Image);
            }
        }
    }

    @Override
    public void onDoLogoutFailure(Throwable t) {
        Snacky.builder()
                .setActivity(this)
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }


    public void AlertDialogBox() {

        //Logout
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set title
        alertDialogBuilder.setTitle("Noon O Kababs");

        // set dialog message
        alertDialogBuilder.setIcon(R.mipmap.logo);
        alertDialogBuilder
                .setMessage("Are you sure to Logout !!!!!")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        presenter.DoOTPVerify(MainActivity.this);


                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();

                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
}