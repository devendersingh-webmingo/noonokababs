package com.webmingo.noonokababs.Fragments.DrawerLayoutFragment.Address;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rjesture.startupkit.AppTools;
import com.webmingo.noonokababs.Adapters.AddressBookAdapter;
import com.webmingo.noonokababs.MainActivity;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.GetUserAddressRepo;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.ViewPresenter.UserAddressBook.GetUserAddressPresenter;
import com.webmingo.noonokababs.databinding.FragmentAddressBookBinding;

import de.mateware.snacky.Snacky;
import okhttp3.ResponseBody;

public class AddressBookFragment extends Fragment implements GetUserAddressPresenter.GetUserAddressView, AddressBookAdapter.AddressAdapterClick {

    FragmentAddressBookBinding binding;
    private View view;
    NavController navController;

    GetUserAddressPresenter presenter;


    public AddressBookFragment() {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_address_book, container, false);
        view = binding.getRoot();

        presenter = new GetUserAddressPresenter(this);
        presenter.GetUserAddressList(getContext());
        binding.btnAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("id", "id");
                navController.navigate(R.id.mapsFragment, bundle);



            }
        });


        return binding.getRoot();

    }

    @Override
    public void onGetUserAddressError(String message) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onGetUserAddressSuccess(GetUserAddressRepo response, String message) {

      //  Toast.makeText(getContext(), response.getData().getAddressBooks().getData().size() + "", Toast.LENGTH_SHORT).show();

        if (message.equalsIgnoreCase("ok")) {
            if (response.getData().getAddressBooks().getData().size() > 0) {
                AddressBookAdapter addressBookAdapterr = new AddressBookAdapter(response, getContext(), this);
                RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                binding.addressRecyclerView.setLayoutManager(mLayoutManager1);
                binding.addressRecyclerView.setItemAnimator(new DefaultItemAnimator());
                binding.addressRecyclerView.setAdapter(addressBookAdapterr);

            }


        }

    }

    @Override
    public void DeleteAddressSuccess(ResponseBody response, String message) {

        if (message.equalsIgnoreCase("ok"))
        {
            presenter.GetUserAddressList(getContext());
            Toast.makeText(getContext(), "Address Deleted Sucecssfully.", Toast.LENGTH_LONG).show();

        }

    }

    @Override
    public void SetasDeaultAddressSuccess(ResponseBody response, String message) {
        if (message.equalsIgnoreCase("ok"))
        {
            presenter.GetUserAddressList(getContext());
            Toast.makeText(getContext(), "This Address Successfully Added As A Default Address.", Toast.LENGTH_LONG).show();

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
    public void onGetUserAddressFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void EditAdapterClickk(GetUserAddressRepo repo, int pos) {



        Bundle bundle = new Bundle();
        bundle.putString("id", String.valueOf(repo.getData().getAddressBooks().getData().get(pos).getId()));
       // GetUserAddressRepo getUserAddressRepo=new GetUserAddressRepo();
       // bundle.putParcelable("",repo.getData().getAddressBooks());
        navController.navigate(R.id.mapsFragment, bundle);



    }

    @Override
    public void RemoveAdapterClickk(GetUserAddressRepo repo, int pos) {



        AlertDialogBox(String.valueOf(repo.getData().getAddressBooks().getData().get(pos).getId()));
    }

    @Override
    public void SetasDefeultClickk(GetUserAddressRepo repo, int pos) {
        presenter.SetasDeaultAddress(getContext(), String.valueOf(repo.getData().getAddressBooks().getData().get(pos).getId()));

    }


    public void AlertDialogBox(String Addressid) {

        //Logout
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());

        // set title
        alertDialogBuilder.setTitle("Are you sure?");

        // set dialog message
        alertDialogBuilder.setIcon(R.mipmap.logo);
        alertDialogBuilder
                .setMessage("Delete This Address.")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        presenter.deleteAddress(getContext(),Addressid);


                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
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