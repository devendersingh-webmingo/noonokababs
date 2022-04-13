package com.webmingo.noonokababs.Fragments;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rjesture.startupkit.AppTools;
import com.webmingo.noonokababs.Activity.Authentication.LoginActivity;
import com.webmingo.noonokababs.Activity.Authentication.ProfileInfoActivity;
import com.webmingo.noonokababs.ModelRepo.RequestRepo.ProfileUpdateReq;
import com.webmingo.noonokababs.ModelRepo.Responsee.UpdateNameAddressRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserProfileinfo;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.SharedPrefernce.SharedPrefManager;
import com.webmingo.noonokababs.Utils.ImagePath;
import com.webmingo.noonokababs.ViewPresenter.DoProfileUpdateDetailsPresenter;
import com.webmingo.noonokababs.databinding.FragmentEditProfileBinding;

import java.io.File;
import java.util.Calendar;

import de.mateware.snacky.Snacky;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import static android.app.Activity.RESULT_OK;

public class EditProfileFragment extends Fragment implements DoProfileUpdateDetailsPresenter.DoProfileUpdateDetailsView {
    FragmentEditProfileBinding binding;
    private View view;

    String FirstNAme, Email, MobileNumber, DOB, Gender, Address;
    DoProfileUpdateDetailsPresenter profileUpdateDetailsPresenter;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    ImageView mLogo;
    String key;

    public EditProfileFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_profile, container, false);
        view = binding.getRoot();
        profileUpdateDetailsPresenter = new DoProfileUpdateDetailsPresenter(this);
        profileUpdateDetailsPresenter.UserProfileinfo(getContext());
        mLogo = (ImageView) getActivity().findViewById(R.id.profile_Image);

        binding.emailET.setText(SharedPrefManager.getInstance(getContext()).GetEmail());


      /*  Intent intentReceived = getActivity().getIntent();
        Bundle data = intentReceived.getExtras();
        if(data != null){
            restaurantUsername = data.getString("Restaurant Username");
        }else{
            restaurantUsername = "";
        }*/




        try {
            if (getArguments().getString("Key") != null) {
                key = getArguments().getString("Key");
                if (key.equalsIgnoreCase("No")) {
                   // binding.adrressLL.setVisibility(View.GONE);
                    Toast.makeText(getContext(), key + "", Toast.LENGTH_SHORT).show();
                }
            }

        }catch (Exception e)
        {

        }



        binding.UpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UpdateProfile();

            }
        });
        binding.dobET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showPickerDialog();
            }
        });
        binding.OpenGalleryLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                On_click_OpenGallery();

            }
        });

        return binding.getRoot();
    }

    public void On_click_OpenGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        System.out.println("requestCode" + requestCode);
        switch (requestCode) {
            case ImagePath.REquestPermissionCode:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getContext(), "Permissin Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Permissin Deined", Toast.LENGTH_SHORT).show();
                }


        }


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            if (data == null)
                return;

            Uri uri = data.getData();
            System.out.println("urii  " + uri + " " + uri.getPath());
            String path = ImagePath.getPath(getActivity(), uri);
            System.out.println("urii path " + path);

            imageUri = data.getData();
            binding.ivProfilePhoto.setImageURI(imageUri);
            mLogo.setImageURI(imageUri);

            //circleImageView.setImageURI(imageUri);
            if (path != null && !path.equals("")) {
                File file = new File(path);


                uploadImage(file);


            }
        }
    }

    private void uploadImage(File file) {
        //  AppTools.showGifDialog(getActivity(), globalloader);
        Log.e("filefile", String.valueOf(file));
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part image = MultipartBody.Part.createFormData("image", file.getName(), requestFile);
        RequestBody _method = RequestBody.create(MediaType.parse("multipart/form-data"), "put");

        profileUpdateDetailsPresenter.uploadImage(image, _method, getContext());
    }

    private void UpdateProfile() {


        if (binding.Male.isChecked()) {

            Gender = binding.Male.getText().toString();
        } else if (binding.Female.isChecked()) {

            Gender = binding.Female.getText().toString();

        }


        FirstNAme = binding.firstnameET.getText().toString().trim();
        Email = binding.emailET.getText().toString().trim();
        MobileNumber = binding.numberET.getText().toString().trim();
        DOB = binding.dobET.getText().toString().trim();
        Address = binding.addressET.getText().toString().trim();

        if (FirstNAme.isEmpty()) {


            Snacky.builder()
                    .setActivity(getActivity())
                    .setText("The name field is required")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        } else if (Email.isEmpty()) {

            Snacky.builder()
                    .setActivity(getActivity())
                    .setText("The email field is required.")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        } else if (MobileNumber.isEmpty()) {

            Snacky.builder()
                    .setActivity(getActivity())
                    .setText("The mobile number field is required.")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        } else if (DOB.isEmpty()) {

            Snacky.builder()
                    .setActivity(getActivity())
                    .setText("The dob field is required.")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        } else if (Address.isEmpty()) {

            Snacky.builder()
                    .setActivity(getActivity())
                    .setText("The About Me field is required.")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        } else if (Gender.isEmpty()) {
            Snacky.builder()
                    .setActivity(getActivity())
                    .setText("The gender field is required.")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();

        } else {

            ProfileUpdateReq profileUpdateReq = new ProfileUpdateReq(FirstNAme, Email, MobileNumber, Address, DOB, Gender, "PATCH");
            profileUpdateDetailsPresenter.DoDoProfileUpdateDetails(getContext(), profileUpdateReq);

        }


    }

    private void showPickerDialog() {

        DatePickerDialog dtPickerDlg = new DatePickerDialog(getContext(), android.R.style.Theme_Holo_Dialog, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar c = Calendar.getInstance();
                c.set(Calendar.YEAR, year);
                c.set(Calendar.MONTH, month);
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String mDate = DateFormat.format("yyyy-MM-dd", c).toString();
                binding.dobET.setText(mDate);
            }
        }, 1999, 01, 01);
        dtPickerDlg.getDatePicker().setSpinnersShown(true);
        dtPickerDlg.getDatePicker().setCalendarViewShown(false);
        dtPickerDlg.setTitle("Select DOB");
        dtPickerDlg.show();
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

        if (message.equalsIgnoreCase("ok")) {

            profileUpdateDetailsPresenter.UserProfileinfo(getContext());
        }
    }

    @Override
    public void onDoUserProfileinfoSuccess(UserProfileinfo response, String message) {


        if (message.equalsIgnoreCase("ok")) {


            if (response.getData().getUserInfo().getName() != null) {
                binding.firstnameET.setText(response.getData().getUserInfo().getName());
            }
            if (response.getData().getUserInfo().getEmail() != null) {
                binding.emailET.setText(response.getData().getUserInfo().getEmail());
            }
            if (response.getData().getUserInfo().getMobileNumber() != null) {
                binding.numberET.setText(String.valueOf(response.getData().getUserInfo().getMobileNumber()));
            }
            if (response.getData().getUserInfo().getDob() != null) {
                binding.dobET.setText(String.valueOf(response.getData().getUserInfo().getDob()));
            }

            if (response.getData().getUserInfo().getAboutMe() != null) {
                binding.addressET.setText(String.valueOf(response.getData().getUserInfo().getAboutMe()));
            }


            if (response.getData().getUserInfo().getProfilePhoto() != null) {


                Glide.with(getContext())
                        .load(response.getData().getImageBaseUrl() + response.getData().getUserInfo().getProfilePhoto())
                        .into(mLogo);


                Glide.with(getContext())
                        .load(response.getData().getImageBaseUrl() + response.getData().getUserInfo().getProfilePhoto())
                        .into(binding.ivProfilePhoto);

            }


            if (response.getData().getUserInfo().getGender() != null) {

                if (response.getData().getUserInfo().getGender().trim().equalsIgnoreCase("Male")) {

                    binding.Male.setChecked(true);

                    binding.Female.setChecked(false);


                } else if (response.getData().getUserInfo().getGender().trim().equalsIgnoreCase("Female")) {


                    binding.Male.setChecked(false);

                    binding.Female.setChecked(true);


                } else {

                }

            }


        }


    }

    @Override
    public void onUploadProfileImageSuccess(UpdateNameAddressRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            Snacky.builder()
                    .setActivity(getActivity())
                    .setText(response.getMessage())
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
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
    public void onProfileUpdateDetailsFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }
}