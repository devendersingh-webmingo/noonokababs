package com.webmingo.noonokababs.Fragments.DrawerLayoutFragment;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.text.HtmlCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.webmingo.noonokababs.Adapters.ExploreCategoriesAdapter;
import com.webmingo.noonokababs.Adapters.ReferralUserAdapter;
import com.webmingo.noonokababs.Adapters.ReferralUserlistAdapter;
import com.webmingo.noonokababs.ModelRepo.Responsee.ReferralRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.ReferredUserListingRepo;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.SharedPrefernce.SharedPrefManager;
import com.webmingo.noonokababs.ViewPresenter.DoHomePagePresenter;
import com.webmingo.noonokababs.ViewPresenter.ReferredPresenter;
import com.webmingo.noonokababs.databinding.FragmentContactsupportBindingImpl;
import com.webmingo.noonokababs.databinding.FragmentHomeBinding;

import de.mateware.snacky.Snacky;

public class ContactsupportFragment extends Fragment implements ReferredPresenter.DoReferredView {


    ReferredPresenter presenter;
    FragmentContactsupportBindingImpl binding;
    private View view;

    NavController navController;


    public ContactsupportFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contactsupport, container, false);

        view = binding.getRoot();


        presenter = new ReferredPresenter(this);
        presenter.ReferralContentAPI(getContext());
        presenter.ReferredUserList(getContext());


        binding.CopyLinkTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CopyLink();
            }
        });


        binding.sharingcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Share();
            }
        });
        return binding.getRoot();

    }

    @Override
    public void onDoReferredError(String message) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();

    }

    @Override
    public void onDoReferredSuccess(ReferralRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {

            Log.e("onDoReferredSuccess",response.getData().toString());

            binding.headingtv.setText(Html.fromHtml(response.getData().getHeading()));
            binding.titletv.setText(Html.fromHtml(response.getData().getTitle()));
                binding.refferalcodeTV.setText(response.getData().getReferralCode());
            binding.AmountTv.setText("\u20B9"+response.getData().getTotalEarn());


            Glide.with(getContext())
                    .load(response.getData().getImage())
                    .into(binding.imageview);


            if (response.getData().getHowWork().size() > 0) {

                ReferralUserlistAdapter gameAdapter = new ReferralUserlistAdapter(response, getContext());
                RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                binding.recyclerHowitwork.setLayoutManager(mLayoutManager1);
                binding.recyclerHowitwork.setItemAnimator(new DefaultItemAnimator());
                binding.recyclerHowitwork.setAdapter(gameAdapter);

            }
        }
        /*
        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
*/

        //Toast.makeText(getContext(), message + "", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onDoReferredUserListSuccess(ReferredUserListingRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            if (response.getData().getUsers().size() > 0) {
                Toast.makeText(getContext(), response.getData().getUsers().size()+"", Toast.LENGTH_SHORT).show();

                ReferralUserAdapter gameAdapter = new ReferralUserAdapter(response, getContext());
                RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                binding.recyclerView.setLayoutManager(mLayoutManager1);
                binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
                binding.recyclerView.setAdapter(gameAdapter);

            }
        }

     /*   Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();*/
      //  Toast.makeText(getContext(), message + "", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showHideProgress(boolean isShow) {

        if (isShow) {
            AppTools.showRequestDialog(getActivity());
            binding.rearrelUILL.setVisibility(View.GONE);


        } else {
            AppTools.hideDialog();
            binding.rearrelUILL.setVisibility(View.VISIBLE);


        }
    }

    @Override
    public void onDoReferredFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();

    }

    private void CopyLink() {


        ClipboardManager cm = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        cm.setText(binding.refferalcodeTV.getText().toString());
        Sneaker.with(getActivity())
                .setTitle("Successfully Copied \n the Code is : " + binding.refferalcodeTV.getText().toString())

                .setMessage("")
                .sneakSuccess();

    }


    private void Share() {
        try {


            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            String sAux = "Hi,\n" + SharedPrefManager.getInstance(getContext()).GetName() + " has invited you to join Noon O Kababs.\n You can win up to Rs 3000/-by our referral program.\n"


                    + "Register your account with referral code= " + binding.refferalcodeTV.getText().toString() + "  to avail discount on your first booking with us.\n";

         /*   sAux = sAux + "To download Apps, click on link: " + "https://play.google.com/store/apps/details?id=" + getActivity().getPackageName() + "\n";
*/
            sAux = sAux + "Steps:  Download the app > Sign Up > Enter Referral Code > Complete your personal information > Choose Your Password > Submit\n \n" + "Thanks Team Noon O Kababs.\n";


            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "choose one"));
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}