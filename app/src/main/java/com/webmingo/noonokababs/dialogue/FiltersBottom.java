package com.webmingo.noonokababs.dialogue;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.webmingo.noonokababs.Adapters.FilterbottomAdapter;
import com.webmingo.noonokababs.Adapters.NotificationAdapter;
import com.webmingo.noonokababs.Fragments.BottomNavFragment.Food.FoodFragment;
import com.webmingo.noonokababs.Modal.Filtermodel;
import com.webmingo.noonokababs.R;

import java.util.ArrayList;

public class FiltersBottom extends BottomSheetDialogFragment implements FilterbottomAdapter.CheckBoxListener {


    //TextView exit, otpContinue;
    //EditText EditMoney;
    BottomSheetDialog bottomSheet;
    RecyclerView recyclerView_Filter;
    ArrayList<Filtermodel> arrayList = new ArrayList<>();
    NavController navController;

    TextView apply;
    String rating_hight_to_low, price_low_to_high, popular, neww;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        bottomSheet = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);


        View view = View.inflate(getContext(), R.layout.filtersbottom, null);
        recyclerView_Filter = view.findViewById(R.id.recyclerView_Filter);
        apply = view.findViewById(R.id.apply);
        bottomSheet.setContentView(view);
        bottomSheet.setCancelable(false);
        bottomSheet.setCanceledOnTouchOutside(false);
        arrayList.add(new Filtermodel("rating_hight_to_low", "Rating High to Low"));

        arrayList.add(new Filtermodel("price_low_to_high", "Pricing Low to High"));
        arrayList.add(new Filtermodel("popular", "Popular Dishes"));
        arrayList.add(new Filtermodel("new", "New Dishes"));


        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), rating_hight_to_low + price_low_to_high + popular + neww, Toast.LENGTH_SHORT).show();


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment safeHealthFragment = new FoodFragment();
                Bundle args = new Bundle();
                args.putString("rating_hight_to_low", rating_hight_to_low);

                args.putString("price_low_to_high", price_low_to_high);
                args.putString("popular", popular);
                args.putString("neww", neww);

                args.putString("id", "no");

                safeHealthFragment.setArguments(args);
                fragmentTransaction.replace(R.id.main, safeHealthFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                bottomSheet.dismiss();


            }
        });


        FilterbottomAdapter gameAdapter = new FilterbottomAdapter(arrayList, getContext(), this);

        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView_Filter.setLayoutManager(mLayoutManager1);
        recyclerView_Filter.setItemAnimator(new DefaultItemAnimator());
        recyclerView_Filter.setAdapter(gameAdapter);


        return bottomSheet;
    }


    @Override
    public void CheckedClick(String id, int position, Boolean bb) {


        if (bb == true) {

            if (position == 0) {
                rating_hight_to_low = id;


            } else if (position == 1) {
                price_low_to_high = id;


            } else if (position == 2) {
                popular = id;
            } else if (position == 3) {
                neww = id;
            }

        } else {

            if (position == 0) {
                rating_hight_to_low = " ";

            } else if (position == 1) {

                price_low_to_high = " ";

            } else if (position == 2) {

                popular = " ";

            } else if (position == 3) {

                neww = " ";
            }

        }


    }
}
