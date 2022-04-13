package com.webmingo.noonokababs.Fragments.BottomNavFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.rjesture.startupkit.AppTools;
import com.webmingo.noonokababs.ModelRepo.Responsee.UpdateNameAddressRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserProfileinfo;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.ViewPresenter.DoProfileUpdateDetailsPresenter;
import com.webmingo.noonokababs.databinding.ChangepasswordbottomBinding;
import com.webmingo.noonokababs.databinding.FragmentHomeBinding;
import com.webmingo.noonokababs.databinding.FragmentProfileBinding;
import com.webmingo.noonokababs.dialogue.ChangepasswordBottom;
import com.webmingo.noonokababs.dialogue.NotificationsBottom;

import de.mateware.snacky.Snacky;
import okhttp3.ResponseBody;

public class ProfileFragment extends Fragment implements DoProfileUpdateDetailsPresenter.DoProfileUpdateDetailsView {
    FragmentProfileBinding binding;
    private View view;
    NavController navController;
    DoProfileUpdateDetailsPresenter presenter;


    public ProfileFragment() {

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
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);
        view = binding.getRoot();
        presenter=new DoProfileUpdateDetailsPresenter(this);
        presenter.UserProfileinfo(getContext());
        binding.editprofileTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   navController.navigate(R.id.editProfileFragment);
                Bundle bundle = new Bundle();
                bundle.putString("Key", "No");
                navController.navigate(R.id.editProfileFragment, bundle);


            }
        });

        binding.passwordLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangepasswordBottom changepasswordBottom = new ChangepasswordBottom();
                changepasswordBottom.show(getActivity().getSupportFragmentManager(), changepasswordBottom.getTag());

            }
        });

        binding.notificationLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationsBottom notificationsBottom = new NotificationsBottom();
                notificationsBottom.show(getActivity().getSupportFragmentManager(), notificationsBottom.getTag());

            }
        });

        return binding.getRoot();
    }

    @Override
    public void onProfileUpdateDetailsError(String message) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onDoProfileUpdateDetailsSuccess(ResponseBody response, String message) {

    }

    @Override
    public void onDoUserProfileinfoSuccess(UserProfileinfo response, String message) {


        if (message.equalsIgnoreCase("ok")) {


            if (response.getData().getUserInfo().getName() != null) {
                binding.name.setText(response.getData().getUserInfo().getName());
            }
            if (response.getData().getUserInfo().getEmail() != null) {
                binding.email.setText(response.getData().getUserInfo().getEmail());
            }



            if (response.getData().getUserInfo().getProfilePhoto() != null) {
                Glide.with(getContext())
                        .load(response.getData().getImageBaseUrl() + response.getData().getUserInfo().getProfilePhoto())
                        .into(binding.ivProfilePhoto);
            }




        }


    }

    @Override
    public void onUploadProfileImageSuccess(UpdateNameAddressRepo response, String message) {

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
    public void onProfileUpdateDetailsFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }
}