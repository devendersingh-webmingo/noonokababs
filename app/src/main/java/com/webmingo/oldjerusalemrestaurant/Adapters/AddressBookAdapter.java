package com.webmingo.oldjerusalemrestaurant.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.UserAddressBook.GetUserAddressRepo;
import com.webmingo.oldjerusalemrestaurant.R;

public class AddressBookAdapter extends RecyclerView.Adapter<AddressBookAdapter.myViewHolder> {

    GetUserAddressRepo modelArrayList;
    Context context;
    private AddressAdapterClick itemClickListenerr;


    public AddressBookAdapter(GetUserAddressRepo modelArrayList, Context context, AddressAdapterClick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_address_layout, parent, false);

        return new AddressBookAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.txt_SHIPPING.setText(modelArrayList.getData().getAddressBooks().getData().get(position).getType());
        holder.contactnumber.setText(modelArrayList.getData().getAddressBooks().getData().get(position).getMobileNumber());
        holder.address.setText(modelArrayList.getData().getAddressBooks().getData().get(position).getAddress());

        holder.productName.setText(modelArrayList.getData().getAddressBooks().getData().get(position).getType());

        if (modelArrayList.getData().getAddressBooks().getData().get(position).getSetAsDefault().equalsIgnoreCase("No")) {
            holder.SetasDefeult_TV.setVisibility(View.VISIBLE);
        }

        holder.SetasDefeult_TV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.SetasDefeultClickk(modelArrayList, position);
            }
        });



        holder.EditTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.EditAdapterClickk(modelArrayList, position);
            }
        });

        holder.removeTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.RemoveAdapterClickk(modelArrayList, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getAddressBooks().getData().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView txt_SHIPPING, productName, contactnumber, address, EditTV, removeTV, SetasDefeult_TV;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_SHIPPING = itemView.findViewById(R.id.txt_SHIPPING);
            productName = itemView.findViewById(R.id.productName);
            contactnumber = itemView.findViewById(R.id.contactnumber);
            address = itemView.findViewById(R.id.address);
            EditTV = itemView.findViewById(R.id.EditTV);
            removeTV = itemView.findViewById(R.id.removeTV);
            SetasDefeult_TV = itemView.findViewById(R.id.SetasDefeult_TV);

        }
    }

    public interface AddressAdapterClick {

        void EditAdapterClickk(GetUserAddressRepo repo, int pos);

        void RemoveAdapterClickk(GetUserAddressRepo repo, int pos);
        void SetasDefeultClickk(GetUserAddressRepo repo, int pos);



    }
}
