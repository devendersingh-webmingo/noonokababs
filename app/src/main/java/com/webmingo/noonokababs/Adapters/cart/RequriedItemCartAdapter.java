package com.webmingo.noonokababs.Adapters.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webmingo.noonokababs.ModelRepo.cart.AddToCartDetailsRepo;
import com.webmingo.noonokababs.R;

public class RequriedItemCartAdapter extends RecyclerView.Adapter<RequriedItemCartAdapter.myViewHolder> {
    public int mSelectedItem = -1;

    AddToCartDetailsRepo modelArrayList;
    Context context;
    private RequriedItemCartclick itemClickListenerr;
    public RequriedItemCartAdapter(AddToCartDetailsRepo modelArrayList, Context context, RequriedItemCartclick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.requiredadapter_cart, parent, false);

        return new RequriedItemCartAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.reuiredRB.setText(modelArrayList.getData().getRequiredItems().get(position).getName());
        holder.reuiredRB.setChecked(position == mSelectedItem);




      /*  holder.tvSend.setText(modelArrayList.getData().getCategories().get(position).getName());
        Picasso.get().load(modelArrayList.getData().getCategories().get(position).getImage()).into(holder.ivimageone);

        holder.clickRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.HomeAdapterClickk(modelArrayList,position);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getRequiredItems().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {


        RadioButton reuiredRB;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            reuiredRB = itemView.findViewById(R.id.reuiredRB);
            View.OnClickListener clickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListenerr.RequriedItemselected(modelArrayList,getAdapterPosition());

                    mSelectedItem = getAdapterPosition();
                    notifyDataSetChanged();

                }
            };
            itemView.setOnClickListener(clickListener);
            reuiredRB.setOnClickListener(clickListener);
        }
    }

    public interface RequriedItemCartclick {
        void RequriedItemselected(AddToCartDetailsRepo repo, int pos);

        //   void HomeAdapterClickk(FinacialCategoryRepo repo,int pos);


    }
}
