package com.webmingo.oldjerusalemrestaurant.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut.DeliveryTypes;
import com.webmingo.oldjerusalemrestaurant.R;

public class DeliverylistAdapter extends RecyclerView.Adapter<DeliverylistAdapter.myViewHolder> {

    DeliveryTypes modelArrayList;
    Context context;
    private AddressAdapterClick itemClickListenerr;



    public DeliverylistAdapter(DeliveryTypes modelArrayList, Context context, AddressAdapterClick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deliverylocationadapter, parent, false);
        return new DeliverylistAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {


        if (modelArrayList.getData().getTypes().get(position).getName().equalsIgnoreCase("Pick Up")) {


            holder.BranchLocationIV.setImageResource(R.drawable.ic_greenpickup);
            holder.IV_image.setImageResource(R.drawable.ic_pick_up);


        }else if (modelArrayList.getData().getTypes().get(position).getName().equalsIgnoreCase("Home Delivery")) {

            holder.IV_image.setImageResource(R.drawable.ic_delivery);
            holder.BranchLocationIV.setImageResource(R.drawable.ic_delivery_icon);








        }

        holder.TV_name.setText(modelArrayList.getData().getTypes().get(position).getName());







        holder.pickupRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                itemClickListenerr.Setas(modelArrayList,position);







            }
        });



    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getTypes().size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView TV_name;

        RelativeLayout pickupRL;
        ImageView IV_image,BranchLocationIV;






        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            TV_name = itemView.findViewById(R.id.TV_name);
            IV_image = itemView.findViewById(R.id.IV_image);
            pickupRL= itemView.findViewById(R.id.pickupRL);
            BranchLocationIV= itemView.findViewById(R.id.BranchLocationIV);


        }
    }

    public interface AddressAdapterClick {

        void Setas(DeliveryTypes repo, int pos);



    }
}
