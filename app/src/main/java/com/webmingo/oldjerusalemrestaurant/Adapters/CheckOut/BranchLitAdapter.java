package com.webmingo.oldjerusalemrestaurant.Adapters.CheckOut;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CheckOut.BranchsRepo;
import com.webmingo.oldjerusalemrestaurant.R;

public class BranchLitAdapter extends RecyclerView.Adapter<BranchLitAdapter.myViewHolder> {

    BranchsRepo modelArrayList;
    Context context;
    private AddressAdapterClick itemClickListenerr;
    String selectedId = "dfdffd";

    public BranchLitAdapter(BranchsRepo modelArrayList, Context context, AddressAdapterClick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.choosebranch_adapter, parent, false);
        return new BranchLitAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.nameTv.setText(modelArrayList.getData().getBranches().get(position).getName());
        holder.AddresTv.setText(modelArrayList.getData().getBranches().get(position).getAddress()+modelArrayList.getData().getBranches().get(position).getGetCity().getName()+",  "+modelArrayList.getData().getBranches().get(position).getGetState().getName()+ ",  "+modelArrayList.getData().getBranches().get(position).getGetCountry().getName());
        //itemClickListenerr.Setas(modelArrayList,position);

        if (selectedId.equalsIgnoreCase("dfdffd")) {
            selectedId = String.valueOf(modelArrayList.getData().getBranches().get(position).getId());
        }



        if (!selectedId.equalsIgnoreCase(String.valueOf(modelArrayList.getData().getBranches().get(position).getId()))) {
            holder.LlSelcet.setBackgroundResource(R.drawable.allsideborder);


        } else {

            holder.LlSelcet.setBackgroundResource(R.drawable.shape);
            itemClickListenerr.Setas(modelArrayList,position);

        }

        holder.LlSelcet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedId = String.valueOf(modelArrayList.getData().getBranches().get(position).getId());
                itemClickListenerr.Setas(modelArrayList,position);
                holder.LlSelcet.setBackgroundResource(R.drawable.allsideborder);
                notifyDataSetChanged();





            }
        });



    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getBranches().size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView nameTv, AddresTv;

        LinearLayout LlSelcet;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.nameTv);
            AddresTv = itemView.findViewById(R.id.AddresTv);
            LlSelcet= itemView.findViewById(R.id.LlSelcet);

        }
    }

    public interface AddressAdapterClick {

        void Setas(BranchsRepo repo, int pos);



    }
}
