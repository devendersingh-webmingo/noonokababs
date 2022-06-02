package com.webmingo.oldjerusalemrestaurant.Fragments.DrawerLayoutFragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webmingo.oldjerusalemrestaurant.R;
import com.webmingo.oldjerusalemrestaurant.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {
    FragmentNotificationsBinding binding;
    private View view;

    public NotificationsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notifications, container, false);
        view = binding.getRoot();



       /* NotificationAdapter gameAdapter = new NotificationAdapter(getContext());

        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        binding.recyclerViewNotifcation.setLayoutManager(mLayoutManager1);
        binding.recyclerViewNotifcation.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerViewNotifcation.setAdapter(gameAdapter);*/

        return binding.getRoot();

    }
}