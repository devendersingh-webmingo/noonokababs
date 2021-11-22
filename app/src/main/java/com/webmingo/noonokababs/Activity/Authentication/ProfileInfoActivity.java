package com.webmingo.noonokababs.Activity.Authentication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.webmingo.noonokababs.MainActivity;
import com.webmingo.noonokababs.ModelRepo.Responsee.UpdateNameAddressRepo;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.Utils.ImagePath;
import com.webmingo.noonokababs.ViewPresenter.DoAddressNameUpdatePresenter;
import com.webmingo.noonokababs.databinding.ActivityProfileInfoBinding;

import java.io.File;

import de.mateware.snacky.Snacky;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ProfileInfoActivity extends AppCompatActivity implements DoAddressNameUpdatePresenter.DoAddressNameUpdateView {

    ActivityProfileInfoBinding binding;
    String Name, Address;
    DoAddressNameUpdatePresenter presenter;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile_info);
        findViewById();
    }

    private void findViewById() {
        presenter = new DoAddressNameUpdatePresenter(this);

        binding.donetv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UpdateNameAddress();

            }
        });


        binding.OpenGalleryLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                On_click_OpenGallery();

            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        System.out.println("requestCode" + requestCode);
        switch (requestCode) {
            case ImagePath.REquestPermissionCode:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(ProfileInfoActivity.this, "Permissin Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ProfileInfoActivity.this, "Permissin Deined", Toast.LENGTH_SHORT).show();
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
            String path = ImagePath.getPath(ProfileInfoActivity.this, uri);
            System.out.println("urii path " + path);

            imageUri = data.getData();
            binding.ivProfilePhoto.setImageURI(imageUri);

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

        presenter.uploadImage(image,_method, ProfileInfoActivity.this);
    }

    public void On_click_OpenGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    private void UpdateNameAddress() {

        Name = binding.NameEt.getText().toString().trim();
        Address = binding.locationET.getText().toString().trim();

        if (Name.isEmpty()) {

            Snacky.builder()
                    .setActivity(ProfileInfoActivity.this)
                    .setText("Enter Your Name")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();

        } else if (Address.isEmpty()) {

            Snacky.builder()
                    .setActivity(ProfileInfoActivity.this)
                    .setText("Enter Your Location")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();
        } else {

            presenter.DoOTPVerify(ProfileInfoActivity.this, Name, Address);


        }
    }


    @Override
    public void onUpdateNameAddressError(String message) {
        Snacky.builder()
                .setActivity(ProfileInfoActivity.this)
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();

    }

    @Override
    public void onUploadProfileImageSuccess(UpdateNameAddressRepo response, String message) {
        Snacky.builder()
                .setActivity(ProfileInfoActivity.this)
                .setText(response.getMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onDoUpdateNameAddressSuccess(UpdateNameAddressRepo response, String message) {


        Snacky.builder()
                .setActivity(ProfileInfoActivity.this)
                .setText(response.getMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
        if (message.equalsIgnoreCase("ok")) {

            showDialog();


        }

    }

    @Override
    public void showHideProgress(boolean isShow) {


        if (isShow) {
            binding.spinKit.setVisibility(View.VISIBLE);
        } else {
            binding.spinKit.setVisibility(View.GONE);
        }

    }

    @Override
    public void onUpdateNameAddressFailure(Throwable t) {
        Snacky.builder()
                .setActivity(ProfileInfoActivity.this)
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }


    public void showDialog() {
        TextView initiTv, pleasewaitTv;

        Dialog dialog = new Dialog(ProfileInfoActivity.this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.setContentView(R.layout.activity_splesh_screen);
        dialog.setCancelable(false);
        dialog.show();
        initiTv = dialog.findViewById(R.id.initiTv);
        pleasewaitTv = dialog.findViewById(R.id.pleasewaitTv);
        initiTv.setVisibility(View.VISIBLE);
        pleasewaitTv.setVisibility(View.VISIBLE);


        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {

                        startActivity(new Intent(ProfileInfoActivity.this, MainActivity.class));
                        finish();


                    }
                }, 1500);


    }
}