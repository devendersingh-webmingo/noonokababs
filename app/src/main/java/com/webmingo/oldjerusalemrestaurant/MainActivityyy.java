/*
package com.webmingo.oldjerusalemrestaurant;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.navigation.NavigationView;
import com.irozon.sneaker.Sneaker;
import imtrade.mShop.android.shopping.Model.ResponseModel.UpdateProfileResponse;
import imtrade.mShop.android.shopping.SharedPerfence.MyPreferences;
import imtrade.mShop.android.shopping.SharedPerfence.PrefConf;
import imtrade.mShop.android.shopping.SharedPrefernce.SharedPrefManager;
import imtrade.mShop.android.shopping.SharedPrefernce.User_Data;
import imtrade.mShop.android.shopping.utils.AppUtils;
import imtrade.mShop.android.shopping.view_presenter.MainActivity_Presenter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import okhttp3.ResponseBody;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainActivity_Presenter.MainActivityView {
    NavController navController;
    DrawerLayout drawer;
    NavigationView navigationView;
    AppBarConfiguration appBarConfiguration;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    private View navHeader, navDrawer;
    TextView username, usergmail, text_cart_Count, txt_gems;
    ImageView img_discount, profile_Image, img_search, img_backet, img_leadBoard;
    Boolean backhome = false;
    User_Data user_data;
    RelativeLayout relative, img_cart;
    private Context context;
    private Dialog dialog;
    private View view;
    private MainActivity_Presenter presenter;
    Boolean CheckedLogin;
    int cartCount;
    LinearLayout linearLayout;
    MaterialCardView card_gems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppUtils.checkAndRequestPermissions(this);
        toolbar = findViewById(R.id.toolbar);
        img_discount = (ImageView) findViewById(R.id.img_discount);
        img_cart = (RelativeLayout) findViewById(R.id.relative_cart);
        relative = (RelativeLayout) findViewById(R.id.relative);
        text_cart_Count = (TextView) findViewById(R.id.text_cart_Count);
        img_search = (ImageView) findViewById(R.id.img_search);
        img_backet = (ImageView) findViewById(R.id.img_backet);
        linearLayout = (LinearLayout) findViewById(R.id.linear);
        txt_gems = (TextView) findViewById(R.id.txt_gems);
        card_gems = (MaterialCardView) findViewById(R.id.card_gems);
        img_leadBoard = (ImageView) findViewById(R.id.img_leadBoard);


        setSupportActionBar(toolbar);
        toolbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        changeStatusBarColor();
        SetBottomBarNavigationView();
        navHeader = navigationView.getHeaderView(0);
        username = (TextView) navHeader.findViewById(R.id.nav_username);
        usergmail = (TextView) navHeader.findViewById(R.id.nav_usergmail);
        profile_Image = (ImageView) navHeader.findViewById(R.id.profile_Image);
        user_data = SharedPrefManager.getInstance(this).getLoginDATA();
        CheckedLogin = MyPreferences.getInstance(MainActivity.this).getBoolean(PrefConf.LOGINCHECK, false);


        context = MainActivity.this;
        dialog = AppUtils.hideShowProgress(context);

        presenter = new MainActivity_Presenter(this);
        presenter.GetUpdateProfile(MainActivity.this);
        presenter.GetCartCount(MainActivity.this);

        if (user_data.getUserName() == null) {
            username.setText("UserName");
            usergmail.setText("UserName@gmail.com");
        } else {
            username.setText(user_data.getUserName());
            usergmail.setText(user_data.getEmail());
        }


        String profileImage = MyPreferences.getInstance(context).getString(PrefConf.ProfileImage, null);
        if (profileImage == null) {
            Glide.with(context).load(profileImage).apply(new RequestOptions().circleCrop()).placeholder(R.drawable.ic_profile_image).into(profile_Image);

        } else if (!profileImage.equalsIgnoreCase("https://stargazeevents.s3.ap-south-1.amazonaws.com/pfiles/profile.png")) {
            Glide.with(context).load(PrefConf.IMAGE_URL + profileImage).apply(new RequestOptions().circleCrop()).placeholder(R.drawable.ic_profile_image).into(profile_Image);

        } else {
            Glide.with(context).load(profileImage).apply(new RequestOptions().circleCrop()).placeholder(R.drawable.ic_profile_image).into(profile_Image);

        }

        //   NavigationUI.setupWithNavController(navigationView, navController);


        img_cart.setOnClickListener(this);
        img_search.setOnClickListener(this);
        img_leadBoard.setOnClickListener(this);

        moreNavigationOptions();
    }


    private void SetBottomBarNavigationView() {
        drawer = findViewById(R.id.drawer);

        navigationView = findViewById(R.id.navigationView);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        navController = Navigation.findNavController(this, R.id.main);


        appBarConfiguration = new AppBarConfiguration.Builder(new int[]{R.id.home_Fragment, R.id.activity, R.id.location, R.id.Games, R.id.profile, R.id.nav_Referral})
                .setDrawerLayout(drawer)
                .build();
        NavigationUI.setupWithNavController(navigationView, navController);

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //NavigationUI.setupActionBarWithNavController(this,navController);
        // NavigationUI.setupWithNavController(toolbar,navController,drawer);


        //  toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_icon_menu));
        //toolbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getId() == R.id.Search_nearBy || destination.getId() == R.id.categories || destination.getId() == R.id.product_Fragemet || destination.getId() == R.id.filter_Fragment
                        || destination.getId() == R.id.update_profile || destination.getId() == R.id.product_Details_Fragment || destination.getId() == R.id.see_all_fragment || destination.getId() == R.id.subCategoriesFragment
                        || destination.getId() == R.id.searchProduct || destination.getId() == R.id.mainSubSubCategories || destination.getId() == R.id.subSubCategories) {
                    img_cart.setVisibility(View.VISIBLE);
                    img_search.setVisibility(View.GONE);
                    img_discount.setVisibility(View.VISIBLE);
                    bottomNavigationView.setVisibility(View.GONE);
                } else if (destination.getId() == R.id.address || destination.getId() == R.id.My_address || destination.getId() == R.id.ChangePassword || destination.getId() == R.id.ChangeEmail || destination.getId() == R.id.myOrder) {
                    img_search.setVisibility(View.VISIBLE);
                    bottomNavigationView.setVisibility(View.GONE);
                    img_cart.setVisibility(View.VISIBLE);
                    img_discount.setVisibility(View.VISIBLE);

                    //   DefalutStatusBarColor();
                } else if (destination.getId() == R.id.myOrder || destination.getId() == R.id.myOrderDetails) {
                    img_search.setVisibility(View.VISIBLE);
                    bottomNavigationView.setVisibility(View.GONE);
                    img_cart.setVisibility(View.VISIBLE);
                    img_discount.setVisibility(View.VISIBLE);


                } else if (destination.getId() == R.id.CartFragment) {
                    img_cart.setVisibility(View.GONE);
                    img_search.setVisibility(View.VISIBLE);
                    img_discount.setVisibility(View.VISIBLE);
                    bottomNavigationView.setVisibility(View.GONE);
                } else if (destination.getId() == R.id.OrderSummaryFragment || destination.getId() == R.id.add_DeliveryInstructions) {
                    img_cart.setVisibility(View.GONE);
                    img_search.setVisibility(View.GONE);
                    img_discount.setVisibility(View.GONE);
                    bottomNavigationView.setVisibility(View.GONE);
                } else if (destination.getId() == R.id.Games) {
                    relative.setBackgroundColor(getResources().getColor(R.color.white));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.white));
                    linearLayout.setBackgroundColor(getResources().getColor(R.color.white));
                    toolbar.setTitleTextColor(getResources().getColor(R.color.product_name));
                    toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_icon_menu));
                    card_gems.setVisibility(View.VISIBLE);
                    img_leadBoard.setVisibility(View.VISIBLE);
                    img_cart.setVisibility(View.GONE);
                    img_search.setVisibility(View.GONE);
                    img_discount.setVisibility(View.GONE);
                    relative.setVisibility(View.VISIBLE);
                    bottomNavigationView.setVisibility(View.VISIBLE);
                } else if (destination.getId() == R.id.play_Game || destination.getId() == R.id.leaderboard) {
                    relative.setVisibility(View.GONE);
                    bottomNavigationView.setVisibility(View.GONE);


                } else if (destination.getId() == R.id.daily_Usable_Products || destination.getId() == R.id.grocry_SeeAll_Product) {
                    GercryStatusBarColor();
                    relative.setBackgroundColor(getResources().getColor(R.color.grocry_color));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.grocry_color));
                    linearLayout.setBackgroundColor(getResources().getColor(R.color.grocry_color));
                    img_backet.setVisibility(View.VISIBLE);
                    img_cart.setVisibility(View.GONE);
                    img_discount.setVisibility(View.GONE);
                    bottomNavigationView.setVisibility(View.GONE);
                } else {
                    DefalutStatusBarColor();
                    relative.setBackgroundColor(getResources().getColor(R.color.toolbar_color));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.toolbar_color));
                    linearLayout.setBackgroundColor(getResources().getColor(R.color.toolbar_color));
                    toolbar.setTitleTextColor(getResources().getColor(R.color.white));

                    img_backet.setVisibility(View.GONE);
                    img_cart.setVisibility(View.VISIBLE);
                    img_discount.setVisibility(View.VISIBLE);
                    img_discount.setVisibility(View.VISIBLE);
                    bottomNavigationView.setVisibility(View.VISIBLE);
                    img_search.setVisibility(View.GONE);
                    card_gems.setVisibility(View.GONE);
                    img_leadBoard.setVisibility(View.GONE);
                    relative.setVisibility(View.VISIBLE);


                }
            }
        });


    }


    @Override
    public boolean onSupportNavigateUp() {
        // toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_icon_menu));
        return NavigationUI.navigateUp(navController, appBarConfiguration);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        */
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
              }*//*

        else {
            super.onBackPressed();
        }
    }

    private void GercryStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.grocry_color));
        }
    }

    private void DefalutStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.toolbar_color));
        }
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.relative_cart:
                if (CheckedLogin == true) {
                    //  startActivity(new Intent(MainActivity.this, CartActivity.class));
                    navController.navigate(R.id.CartFragment);
                } else {
                    Sneaker.with(MainActivity.this)
                            .setTitle("Your Can't access this app  please First Login ")
                            .setMessage("")
                            .setCornerRadius(4)
                            .setDuration(1500)
                            .sneakError();
                }

                break;

            case R.id.img_search:
                navController.navigate(R.id.searchProduct);
                break;

            case R.id.img_leadBoard:
                navController.navigate(R.id.leaderboard);
                break;
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
    }

    private void moreNavigationOptions() {
        Menu menu = navigationView.getMenu();

        MenuItem logout = menu.findItem(R.id.nav_logout);

        logout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                drawer.closeDrawer(GravityCompat.START);
                LogoutAlertBox();
                return true;
            }
        });

      */
/*  MenuItem share = menu.findItem(R.id.nav_Share_us);

        share.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                drawer.closeDrawer(GravityCompat.START);
                AppUtils.shareApp(MainActivity.this);
                return true;
            }
        });*//*

    }

    private void LogoutAlertBox() {
        //Logout
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

        // set title
        alertDialogBuilder.setTitle(getResources().getString(R.string.app_name));

        // set dialog message
        alertDialogBuilder.setIcon(R.mipmap.ic_launcher_round);
        alertDialogBuilder
                .setMessage("Are you sure to Logout !!!!!")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SharedPrefManager.getInstance(getApplicationContext()).logout();
                        MyPreferences.getInstance(MainActivity.this).clearPreferences();
                        clearApplicationData();
                        Toast.makeText(MainActivity.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
                        finish();

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

    @SuppressLint("LongLogTag")
    public void clearApplicationData() {
        File cache = getCacheDir();
        File appDir = new File(cache.getParent());
        if (appDir.exists()) {
            String[] children = appDir.list();
            for (String s : children) {
                if (!s.equals("lib")) {
                    deleteDir(new File(appDir, s));
                    Log.i("EEEEEERRRRRRROOOOOOORRRR", "**************** File /data/data/APP_PACKAGE/" + s + " DELETED *******************");
                }
            }
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }

        return dir.delete();
    }

    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            dialog.show();
        } else {
            dialog.dismiss();
        }

    }

    @Override
    public void onError(String message) {
        // Toast.makeText(MainActivity.this, "" + message, Toast.LENGTH_SHORT).show();
        text_cart_Count.setText("0");
    }

    @Override
    public void onUpdateProfileSuccess(UpdateProfileResponse updateProfileResponse, String message) {
        if (message.equalsIgnoreCase("ok")) {
            User_Data userData = new User_Data(user_data.getId(), updateProfileResponse.getEmail(), user_data.getToken(), user_data.getReferral_code(), updateProfileResponse.getFirstName(), updateProfileResponse.getPhone());
            SharedPrefManager.getInstance(MainActivity.this).SetLoginData(userData);
            username.setText(updateProfileResponse.getFirstName());
            usergmail.setText(updateProfileResponse.getEmail());
            MyPreferences.getInstance(MainActivity.this).putString(PrefConf.ProfileImage, updateProfileResponse.getProfileImage());
            if (!updateProfileResponse.getProfileImage().equalsIgnoreCase("https://stargazeevents.s3.ap-south-1.amazonaws.com/pfiles/profile.png")) {
                Glide.with(context).load(PrefConf.IMAGE_URL + updateProfileResponse.getProfileImage()).apply(new RequestOptions().circleCrop()).placeholder(R.drawable.ic_profile_image).into(profile_Image);

            } else {
                Glide.with(context).load(updateProfileResponse.getProfileImage()).apply(new RequestOptions().circleCrop()).placeholder(R.drawable.ic_profile_image).into(profile_Image);

            }

        }
    }

    @Override
    public void onCartCountSuccess(ResponseBody responseBody, String message) {
        try {
            String s = responseBody.string();
            JSONObject object = new JSONObject(s);
            text_cart_Count.setText(object.getString("count"));
            MyPreferences.getInstance(MainActivity.this).putString(PrefConf.CARTCOUNT, object.getString("count"));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(MainActivity.this, "" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.GetCartCount(MainActivity.this);
    }


}
*/
