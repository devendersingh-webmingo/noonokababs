package com.webmingo.oldjerusalemrestaurant.Fragments.DrawerLayoutFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rjesture.startupkit.AppTools;
import com.webmingo.oldjerusalemrestaurant.Adapters.CustomHomeAdapter;
import com.webmingo.oldjerusalemrestaurant.Adapters.FoodFavourite.favouirteFoodItemAdapter;
import com.webmingo.oldjerusalemrestaurant.Adapters.SlidingImageAdapter;
import com.webmingo.oldjerusalemrestaurant.Modal.HomeModal;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.HomePageRepo;
import com.webmingo.oldjerusalemrestaurant.R;
import com.webmingo.oldjerusalemrestaurant.ViewPresenter.DoNewHomePagePresenter;
import com.webmingo.oldjerusalemrestaurant.databinding.FragmentLegalBinding;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import de.mateware.snacky.Snacky;

public class NewHomeFragment extends Fragment implements CustomHomeAdapter.HomeAdapterClick , DoNewHomePagePresenter.DoHomePageView{

    FragmentLegalBinding binding;
    private View view;


    NavController navController;

    GridLayoutManager mGridLayoutManager;
    ArrayList<HomeModal> dataModels;
    private static CustomHomeAdapter adapter;

    DoNewHomePagePresenter presenter;

    private static int currentPage = 0;
    private static int No_page = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        dataModels= new ArrayList<>();
        dataModels.add(new HomeModal("My Profile", R.drawable.ic_profile,R.drawable.ic_profilebg));
        dataModels.add(new HomeModal("My Orders", R.drawable.ic_myorder,R.drawable.ic_myorderbg));
        dataModels.add(new HomeModal("Order Food", R.drawable.ic_foodorder,R.drawable.ic_orderfoodbg));
        dataModels.add(new HomeModal("Invite Friend", R.drawable.ic_invitefriend,R.drawable.ic_invitefriendbg));
        dataModels.add(new HomeModal("Support", R.drawable.ic_supportt,R.drawable.ic_supportbg));


        mGridLayoutManager = new GridLayoutManager(getContext().getApplicationContext(), 2);
        binding.homeRV.setLayoutManager(mGridLayoutManager);
        adapter= new CustomHomeAdapter(dataModels,getContext(),this);
        binding.homeRV.setAdapter(adapter);

        presenter=new DoNewHomePagePresenter(this);
        presenter.NewHomePage(getContext());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_legal, container, false);
        view = binding.getRoot();


        return binding.getRoot();
    }

    @Override
    public void AdapterClick(ArrayList<HomeModal> repo, int pos) {


        if (repo.get(pos).getName().equalsIgnoreCase("My Profile"))
        {

            navController.navigate(R.id.editProfileFragment);


        }
        else  if (repo.get(pos).getName().equalsIgnoreCase("My Orders"))
        {
            navController.navigate(R.id.orderhistoryFragment);


        }

        else  if (repo.get(pos).getName().equalsIgnoreCase("Order Food"))

        {

            navController.navigate(R.id.home_Fragment);


        }
        else  if (repo.get(pos).getName().equalsIgnoreCase("Invite Friend"))
        {

            navController.navigate(R.id.contactsupportFragment);

        }
        else  if (repo.get(pos).getName().equalsIgnoreCase("Support"))
        {
            navController.navigate(R.id.supportFragment);


        }


    }

    @Override
    public void onDoHomePageError(String message) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();


    }

    @Override
    public void onDoHomePageSuccess(HomePageRepo response, String message) {

        if (message.equalsIgnoreCase("ok"))
        {
            if (response.getData().getPromotionalBanners().size() > 0) {
                binding.imageSlider.setAdapter(new SlidingImageAdapter(response, getContext()));
                binding.indicator.setViewPager(binding.imageSlider);
                setIndicator(response.getData().getPromotionalBanners().size());
            }
        }

        Toast.makeText(getContext(),message+ "", Toast.LENGTH_SHORT).show();
    }

    public void setIndicator(int size) {
        final float density = getResources().getDisplayMetrics().density;
        //Set circle indicator radius
        binding.indicator.setRadius(5 * density);
        No_page = size;
        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == No_page) {
                    currentPage = 0;
                }
                binding.imageSlider.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        binding.indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
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
    public void onDoHomePageFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }
}