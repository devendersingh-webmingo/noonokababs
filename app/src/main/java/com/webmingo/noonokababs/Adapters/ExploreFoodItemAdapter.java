package com.webmingo.noonokababs.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.webmingo.noonokababs.ModelRepo.Responsee.DashboardRepo;
import com.webmingo.noonokababs.R;

public class ExploreFoodItemAdapter extends RecyclerView.Adapter<ExploreFoodItemAdapter.myViewHolder> {
    DashboardRepo modelArrayList;
    Context context;
    private ExploreFoodClick itemClickListenerr;

    public ExploreFoodItemAdapter(DashboardRepo modelArrayList, Context context, ExploreFoodClick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.explore_food_items, parent, false);

        return new ExploreFoodItemAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {





        if (modelArrayList.getData().getFoodItems().get(position).getIn_stock().equalsIgnoreCase("No")) {


            holder.outofstockIV.setVisibility(View.VISIBLE);



        }



        holder.tv_title.setText(modelArrayList.getData().getFoodItems().get(position).getName());

        holder.tv_description.setText(modelArrayList.getData().getFoodItems().get(position).getDescription());
        Glide.with(context)
                .load(modelArrayList.getData().getImageBaseUrl() + modelArrayList.getData().getFoodItems().get(position).getGetGallery().get(0).getImage())
                .into(holder.imageView);
        if (modelArrayList.getData().getFoodItems().get(position).getGetSinglePrice().getPrice()!=null)
        {
            holder.tvPrice.setText("$ "+modelArrayList.getData().getFoodItems().get(position).getGetSinglePrice().getFinalPrice());
            holder.tvCutPrice.setText("$ "+modelArrayList.getData().getFoodItems().get(position).getGetSinglePrice().getPrice());
            if (modelArrayList.getData().getFoodItems().get(position).getGetSinglePrice().getDiscount()!=null)
            {
                holder.tv_discount.setText(modelArrayList.getData().getFoodItems().get(position).getGetSinglePrice().getDiscount()+"% Off");

            }else {
                holder.tv_discount.setVisibility(View.GONE);
                holder.tvCutPrice.setVisibility(View.GONE);

            }


        }



        holder.clickRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemClickListenerr.ExploreFoodClickk(modelArrayList,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getFoodItems().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, IV_corss,outofstockIV;
        TextView tv_title, tv_description, tvPrice, tvCutPrice, tv_discount;
        LinearLayout clickRL;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);

            outofstockIV = itemView.findViewById(R.id.outofstockIV);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_description = itemView.findViewById(R.id.tv_description);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvCutPrice = itemView.findViewById(R.id.tvCutPrice);
            tv_discount = itemView.findViewById(R.id.tv_discount);
            clickRL = itemView.findViewById(R.id.clickRL);
            IV_corss = itemView.findViewById(R.id.IV_corss);


        }
    }

    public interface ExploreFoodClick {

        void ExploreFoodClickk(DashboardRepo repo, int pos);


    }
}
