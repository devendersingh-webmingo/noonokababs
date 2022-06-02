package com.webmingo.oldjerusalemrestaurant.Adapters.OrderHistoryAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.FooddetailRateRepo;
import com.webmingo.oldjerusalemrestaurant.R;

public class HistoryPorductRatingAdapter extends RecyclerView.Adapter<HistoryPorductRatingAdapter.myViewHolder> {

    FooddetailRateRepo modelArrayList;
    Context context;
    HistoryProductEvent clicklistener;
    String ratingg = "null";

    public HistoryPorductRatingAdapter(FooddetailRateRepo modelArrayList, Context context, HistoryProductEvent clicklistener) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.clicklistener = clicklistener;
    }

  /*  public HistoryPorductRatingAdapter(FooddetailRateRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }*/
/*
    public HistoryPorductRatingAdapter(Context context) {
        this.context = context;
    }*/

    /* public AddonseCartAdapter(AddToCartDetailsRepo modelArrayList, Context context) {
             this.modelArrayList = modelArrayList;
             this.context = context;
         }
     */
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ratingreviesadapter, parent, false);

        return new HistoryPorductRatingAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        if (modelArrayList.getData().getOrderInfo().getOrderFoodDetail().get(position).getRated().equalsIgnoreCase("Yes")) {
            holder.SubmitTV.setVisibility(View.GONE);
        }
        if (modelArrayList.getData().getOrderInfo().getOrderFoodDetail().get(position).getGivenRate() != null) {
            holder.text_rating.setIndicator(true);
            holder.descTv.setEnabled(false);

            holder.text_rating.setRating(Float.valueOf(modelArrayList.getData().getOrderInfo().getOrderFoodDetail().get(position).getGivenRate().getRating()));
            holder.descTv.setText(modelArrayList.getData().getOrderInfo().getOrderFoodDetail().get(position).getGivenRate().getReview());

        }

        holder.foodname_TV.setText(modelArrayList.getData().getOrderInfo().getOrderFoodDetail().get(position).getName());

        holder.FoodQuentityTv.setText("Product Qty:- " + String.valueOf(modelArrayList.getData().getOrderInfo().getOrderFoodDetail().get(position).getQuantity()));

        holder.FoodPriceTv.setText("$" + modelArrayList.getData().getOrderInfo().getOrderFoodDetail().get(position).getAmount());


        if (modelArrayList.getData().getOrderInfo().getOrderFoodDetail().get(position).getImage() != null) {

            Glide.with(context)
                    .load(modelArrayList.getData().getImageBaseUrl() + modelArrayList.getData().getOrderInfo().getOrderFoodDetail().get(position).getImage())

                    .into(holder.food_IV);

        }
        holder.text_rating.setOnRatingBarChangeListener(new SimpleRatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(SimpleRatingBar simpleRatingBar, float rating, boolean fromUser) {


                char first = String.valueOf(rating).charAt(0);
                ratingg = String.valueOf(first);


            }
        });

     /*   holder.descTv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                String text = s.toString();

                clicklistener.Reivews(modelArrayList, position, text);


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/
        holder.SubmitTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.descTv.getText().toString().isEmpty()) {
                    Toast.makeText(context, "The Review field is required.", Toast.LENGTH_SHORT).show();


                } else if (ratingg.equalsIgnoreCase("null")) {
                    Toast.makeText(context, "The Rating field is required.", Toast.LENGTH_SHORT).show();

                } else {

                    clicklistener.ReivewsRating(String.valueOf(modelArrayList.getData().getOrderInfo().getOrderFoodDetail().get(position).getFoodId()), ratingg, holder.descTv.getText().toString().trim());

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getOrderInfo().getOrderFoodDetail().size();


    }


    public class myViewHolder extends RecyclerView.ViewHolder {

        ImageView food_IV;
        TextView foodname_TV, FoodQuentityTv, FoodPriceTv, SubmitTV;
        SimpleRatingBar text_rating;
        EditText descTv;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            food_IV = itemView.findViewById(R.id.food_IV);
            FoodPriceTv = itemView.findViewById(R.id.FoodPriceTv);
            foodname_TV = itemView.findViewById(R.id.foodname_TV);
            FoodQuentityTv = itemView.findViewById(R.id.FoodQuentityTv);
            text_rating = itemView.findViewById(R.id.text_rating);
            descTv = itemView.findViewById(R.id.descTv);
            SubmitTV = itemView.findViewById(R.id.SubmitTV);


            //切换无动画
        }
    }

    public interface HistoryProductEvent {


        void ReivewsRating(String food_id, String rating, String Reviews);


    }


}
