package com.webmingo.noonokababs.Adapters.FoodFavourite;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.webmingo.noonokababs.ModelRepo.Responsee.FoodItemRepo;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.SharedPrefernce.SharedPrefManager;
import com.webmingo.noonokababs.dialogue.CustomDialog;

import java.util.ArrayList;
import java.util.List;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.myViewHolder> {

    //  FoodItemRepo modelArrayList;

    ArrayList<FoodItemRepo.Data.FoodItems.Datum> modelArrayList;
    FoodItemRepo foodItemRepo;
    Context context;
    private FoodItemClick itemClickListenerr;
    boolean b = false;

    public FoodItemAdapter(FoodItemRepo foodItemRepo, ArrayList<FoodItemRepo.Data.FoodItems.Datum> modelArrayList, Context context, FoodItemClick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
        this.foodItemRepo = foodItemRepo;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fooditemadapter, parent, false);
        return new FoodItemAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        if (modelArrayList.get(position).getRemark() != null) {
            holder.tv_descriptionp.setText(Html.fromHtml(modelArrayList.get(position).getRemark()));


        }
        holder.listfoodTV.setText(modelArrayList.get(position).getDescription());

        holder.text_rating.setText(modelArrayList.get(position).getRating());

        holder.tvPrice.setText("$ " + modelArrayList.get(position).getGetSinglePrice().getPrice());


        if (modelArrayList.get(position).getIn_stock().equalsIgnoreCase("No")) {
            holder.outofstockIV.setVisibility(View.VISIBLE);
        }


        if (modelArrayList.get(position).getGetGallery().size() > 0) {
            RequestOptions requestOptions = new RequestOptions();

          /*  Glide.with(context)
                    .load(modelArrayList.getData().getImageBaseUrl()+modelArrayList.getData().getFoodItems().get(position).getGetGallery().get(0).getImage())
                    .into(holder.food_IV);
*/
            Glide.with(context)
                    .setDefaultRequestOptions(requestOptions)
                    .load(foodItemRepo.getData().getImageBaseUrl() + modelArrayList.get(position).getGetGallery().get(0).getImage())


                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .thumbnail(0.05f)
                    .placeholder(R.drawable.placeholder)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            // holder.pb.setVisibility(View.GONE);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, com.bumptech.glide.load.DataSource dataSource, boolean isFirstResource) {
                            //  holder.pb.setVisibility(View.GONE);
                            return false;
                        }

                    })
                    .into(holder.food_IV);

        }


        holder.foodname_TV.setText(modelArrayList.get(position).getName());


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.FoodItemClick(modelArrayList, position);
            }
        });
        holder.favouriteIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (SharedPrefManager.getInstance(context).isLoggedIn()) {

                    itemClickListenerr.FoodItemFavouriteClick(modelArrayList, position);
                    holder.favouriteRemoveIV.setVisibility(View.VISIBLE);
                    holder.favouriteIV.setVisibility(View.GONE);
                } else {
                    CustomDialog logindialog = new CustomDialog(context);
                    logindialog.setLoginDialog();

                }


            }
        });
        holder.favouriteRemoveIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (SharedPrefManager.getInstance(context).isLoggedIn()) {

                    itemClickListenerr.FoodItemFavouriteClick(modelArrayList, position);
                    holder.favouriteRemoveIV.setVisibility(View.GONE);
                    holder.favouriteIV.setVisibility(View.VISIBLE);
                } else {
                    CustomDialog logindialog = new CustomDialog(context);
                    logindialog.setLoginDialog();

                }


            }
        });


    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tv_descriptionp, tvPrice, foodname_TV, listfoodTV, text_rating;
        ImageView food_IV, favouriteIV, favouriteRemoveIV, outofstockIV;
        LinearLayout cardView;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_descriptionp = itemView.findViewById(R.id.tv_descriptionp);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            foodname_TV = itemView.findViewById(R.id.foodname_TV);
            favouriteIV = itemView.findViewById(R.id.favouriteIV);
            food_IV = itemView.findViewById(R.id.food_IV);
            listfoodTV = itemView.findViewById(R.id.listfoodTV);
            cardView = itemView.findViewById(R.id.cardView);
            outofstockIV = itemView.findViewById(R.id.outofstockIV);
            favouriteRemoveIV = itemView.findViewById(R.id.favouriteRemoveIV);
            text_rating = itemView.findViewById(R.id.text_rating);


        }
    }

    public interface FoodItemClick {


        void FoodItemClick(ArrayList<FoodItemRepo.Data.FoodItems.Datum> modelArrayList, int pos);

        void FoodItemFavouriteClick(ArrayList<FoodItemRepo.Data.FoodItems.Datum> modelArrayList, int pos);
    }
}
