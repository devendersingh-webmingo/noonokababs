package com.webmingo.noonokababs.Fragments.BottomNavFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rjesture.startupkit.AppTools;
import com.webmingo.noonokababs.Adapters.ExploreCategoriesAdapter;
import com.webmingo.noonokababs.Adapters.ExploreFoodItemAdapter;
import com.webmingo.noonokababs.Fragments.SearchFragment;
import com.webmingo.noonokababs.ModelRepo.RequestRepo.ViewCartRequest;
import com.webmingo.noonokababs.ModelRepo.Responsee.DashboardRepo;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.SharedPrefernce.ViewCartReqSharedPreferenc;
import com.webmingo.noonokababs.ViewPresenter.DoHomePagePresenter;
import com.webmingo.noonokababs.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import de.mateware.snacky.Snacky;

public class HomeFragment extends Fragment implements DoHomePagePresenter.DoHomePageView, ExploreCategoriesAdapter.ExploreCategoriesClick, ExploreFoodItemAdapter.ExploreFoodClick {
    FragmentHomeBinding binding;
    private View view;
    DoHomePagePresenter presenter;
    NavController navController;


    private List<ViewCartRequest> ViewCartRequestList = new ArrayList<>();


    public HomeFragment() {


    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        view = binding.getRoot();


        presenter = new DoHomePagePresenter(this);
        presenter.DoAddPaymentList(getContext());
        ViewCartRequestList = ViewCartReqSharedPreferenc.readListFromPref(getContext());

        if (ViewCartRequestList != null) {
            Toast.makeText(getContext(), ViewCartRequestList.size() + "", Toast.LENGTH_SHORT).show();

            if (ViewCartRequestList.size() > 0) {
                binding.ll.setVisibility(View.VISIBLE);
            }


            for (int i = 0; i < ViewCartRequestList.size(); i++) {
                Log.e("ViewCartRequestList", ViewCartRequestList.get(i).getCart().get(i).getFoodId());

            }
        }

    /*    if (ViewCartRequestList == null)
            ViewCartRequestList = new ArrayList<>();*/

        binding.viewcartTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.checkOutCartFragment);

            }
        });
        binding.serachTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navController.navigate(R.id.searchFragment);

                Bundle bundle = new Bundle();
                bundle.putString("Key", "Home");
                navController.navigate(R.id.searchFragment, bundle);




           /*     FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment searchFragment = new SearchFragment();
                Bundle args = new Bundle();
                // args.putSerializable(ARG_ANIMALS, animals as Serializable)
                args.putString("Key", "Home");
                searchFragment.setArguments(args);
                fragmentTransaction.replace(R.id.main, searchFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
*/


            }
        });
        return binding.getRoot();
    }

    private void ExploreCategoriesAdapter(DashboardRepo dashboardRepo) {


        ExploreCategoriesAdapter gameAdapter = new ExploreCategoriesAdapter(dashboardRepo, getContext(), this);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.exploreCategoriesRecycler.setLayoutManager(mLayoutManager1);
        binding.exploreCategoriesRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.exploreCategoriesRecycler.setAdapter(gameAdapter);

    }


    private void ExploreFoodItemAdapter(DashboardRepo dashboardRepo) {


        ExploreFoodItemAdapter gameAdapter = new ExploreFoodItemAdapter(dashboardRepo, getContext(), this);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.recyclerViewExploreFoodItems.setLayoutManager(mLayoutManager1);
        binding.recyclerViewExploreFoodItems.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerViewExploreFoodItems.setAdapter(gameAdapter);

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
    public void onDoHomePageSuccess(DashboardRepo response, String message) {

        if (message.equalsIgnoreCase("ok")) {


            Getbless(response.getData().getUserInfo().getName());

            if (response.getData().getCategories().size() > 0) {
                ExploreCategoriesAdapter(response);
            }
            if (response.getData().getFoodItems().size() > 0) {
                ExploreFoodItemAdapter(response);

            }


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
    public void onDoHomePageFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();

    }

    @Override
    public void ExploreCategoriesClickk(DashboardRepo repo, int pos) {

     /*   Bundle bundle = new Bundle();
        bundle.putString("id", String.valueOf(repo.getData().getCategories().get(pos).getId()));
        navController.navigate(R.id.foodDetailFragment,bundle);*/

        Toast.makeText(getContext(), repo.getData().getCategories().get(pos).getName() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ExploreFoodClickk(DashboardRepo repo, int pos) {

     /*   Bundle bundle = new Bundle();
        bundle.putString("id", String.valueOf(repo.getData().getCategories().get(pos).getId()));
        navController.navigate(R.id.foodDetailFragment,bundle);*/

        Toast.makeText(getContext(), repo.getData().getFoodItems().get(pos).getName() + "", Toast.LENGTH_SHORT).show();

    }

    private void Getbless(String name) {
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 12) {
            //Toast.makeText(this, "Good Morning", Toast.LENGTH_SHORT).show();
            binding.nameTv.setText("Good Morning! " + name);

        } else if (timeOfDay >= 12 && timeOfDay < 16) {


            binding.nameTv.setText("Good Afternoon! " + name);


            // Toast.makeText(this, "Good Afternoon", Toast.LENGTH_SHORT).show();
        } else if (timeOfDay >= 16 && timeOfDay < 21) {
            // Toast.makeText(this, "Good Evening", Toast.LENGTH_SHORT).show();

            binding.nameTv.setText("Good Evening! " + name);

        } else if (timeOfDay >= 21 && timeOfDay < 24) {

            binding.nameTv.setText("Good Night! " + name);


            // Toast.makeText(this, "Good Night", Toast.LENGTH_SHORT).show();
        }

    }
}