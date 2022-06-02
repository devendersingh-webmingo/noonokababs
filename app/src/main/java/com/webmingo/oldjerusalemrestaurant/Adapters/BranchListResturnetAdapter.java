package com.webmingo.oldjerusalemrestaurant.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut.BranchsRepo;
import com.webmingo.oldjerusalemrestaurant.R;

public class BranchListResturnetAdapter extends RecyclerView.Adapter<BranchListResturnetAdapter.myViewHolder> {

    BranchsRepo modelArrayList;
    Context context;
    private AddressAdapterClick itemClickListenerr;



    public BranchListResturnetAdapter(BranchsRepo modelArrayList, Context context, AddressAdapterClick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.branchaddress, parent, false);
        return new BranchListResturnetAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

       /* if ((Integer.parseInt(String.valueOf(modelArrayList.getData().getBranches().get(position))) % 2)== 0) {


            holder.view.setBackgroundColor(Color.parseColor("#6B8E23"));

            holder.BranchLocationIV.setBackgroundResource(R.drawable.ic_greenpickup);

        }else
        {
            holder.BranchLocationIV.setBackgroundResource(R.drawable.ic_delivery_icon);
            holder.view.setBackgroundColor(Color.parseColor("#D7A00D"));

        }*/

        holder.nameTv.setText(modelArrayList.getData().getBranches().get(position).getName());
        holder.AddresTv.setText(modelArrayList.getData().getBranches().get(position).getAddress()+", \n"+modelArrayList.getData().getBranches().get(position).getGetCity().getName()+",  "+modelArrayList.getData().getBranches().get(position).getGetState().getName()+ ",  "+modelArrayList.getData().getBranches().get(position).getGetCountry().getName());
        //itemClickListenerr.Setas(modelArrayList,position);





        holder.RlSelcet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                itemClickListenerr.Setas(modelArrayList,position);







            }
        });



    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getBranches().size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView nameTv, AddresTv;

        RelativeLayout RlSelcet;
        ImageView BranchLocationIV;
        View view;





        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.nameTv);
            AddresTv = itemView.findViewById(R.id.AddresTv);
            RlSelcet= itemView.findViewById(R.id.RlSelcet);
            BranchLocationIV= itemView.findViewById(R.id.BranchLocationIV);
            view= itemView.findViewById(R.id.view);


        }
    }

    public interface AddressAdapterClick {

        void Setas(BranchsRepo repo, int pos);



    }
}
