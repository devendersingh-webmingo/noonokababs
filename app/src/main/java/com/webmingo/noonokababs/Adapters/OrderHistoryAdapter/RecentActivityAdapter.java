package com.webmingo.noonokababs.Adapters.OrderHistoryAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.GetUserAddressRepo;
import com.webmingo.noonokababs.R;

public class RecentActivityAdapter extends RecyclerView.Adapter<RecentActivityAdapter.myViewHolder> {

    GetUserAddressRepo modelArrayList;
    Context context;
   // private AddressAdapterClick itemClickListenerr;

/*

    public YourRecentOrdersAdapter(GetUserAddressRepo modelArrayList, Context context, AddressAdapterClick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }
*/

    public RecentActivityAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboardadapter_lay, parent, false);

        return new RecentActivityAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 2;//modelArrayList.getData().getAddressBooks().getData().size();



    }

    public class myViewHolder extends RecyclerView.ViewHolder {


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
/*
    public interface AddressAdapterClick {

        void EditAdapterClickk(GetUserAddressRepo repo, int pos);

        void RemoveAdapterClickk(GetUserAddressRepo repo, int pos);
        void SetasDefeultClickk(GetUserAddressRepo repo, int pos);



    }*/
}
