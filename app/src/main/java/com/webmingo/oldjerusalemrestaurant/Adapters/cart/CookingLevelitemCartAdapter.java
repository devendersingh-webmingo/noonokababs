package com.webmingo.oldjerusalemrestaurant.Adapters.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webmingo.oldjerusalemrestaurant.ModelRepo.cart.AddToCartDetailsRepo;
import com.webmingo.oldjerusalemrestaurant.R;

public class CookingLevelitemCartAdapter extends RecyclerView.Adapter<CookingLevelitemCartAdapter.myViewHolder> {
    public int mSelectedItem = -1;

    AddToCartDetailsRepo modelArrayList;
    Context context;
    private RequriedItemCartclick itemClickListenerr;
    public CookingLevelitemCartAdapter(AddToCartDetailsRepo modelArrayList, Context context, RequriedItemCartclick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.requiredadapter_cart, parent, false);

        return new CookingLevelitemCartAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.reuiredRB.setText(modelArrayList.getData().getCookingLevels().get(position).getName());
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
        return modelArrayList.getData().getCookingLevels().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {


        RadioButton reuiredRB;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            reuiredRB = itemView.findViewById(R.id.reuiredRB);
            View.OnClickListener clickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListenerr.CookingItemselected(modelArrayList,getAdapterPosition());

                    mSelectedItem = getAdapterPosition();
                    notifyDataSetChanged();

                }
            };
            itemView.setOnClickListener(clickListener);
            reuiredRB.setOnClickListener(clickListener);
        }
    }

    public interface RequriedItemCartclick {
        void CookingItemselected(AddToCartDetailsRepo repo, int pos);

        //   void HomeAdapterClickk(FinacialCategoryRepo repo,int pos);


    }
}
