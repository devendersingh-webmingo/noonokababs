package com.webmingo.noonokababs.Adapters.FoodFavourite;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
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

import com.webmingo.noonokababs.ModelRepo.Responsee.FoodFavourit.FavouritefoodsRepo;
import com.webmingo.noonokababs.R;

public class favouirteFoodItemAdapter extends RecyclerView.Adapter<favouirteFoodItemAdapter.myViewHolder> {

    FavouritefoodsRepo modelArrayList;
    Context context;
    private FoodFavouriteItemClick itemClickListenerr;

    public favouirteFoodItemAdapter(FavouritefoodsRepo modelArrayList, Context context, FoodFavouriteItemClick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fooditemadapter, parent, false);
        return new favouirteFoodItemAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.favouriteIV.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_fillheart));
        holder.foodname_TV.setText(modelArrayList.getData().getFavFoods().getData().get(position).getName());
        // holder.listfoodTV.setText(modelArrayList.getData().getFavFoods().getData().get(position).getRemark());


        holder.listfoodTV.setText(Html.fromHtml(modelArrayList.getData().getFavFoods().getData().get(position).getDescription()));
        if (modelArrayList.getData().getFavFoods().getData().get(position).getRemark() != null) {
            holder.tv_descriptionp.setText(Html.fromHtml(modelArrayList.getData().getFavFoods().getData().get(position).getRemark()));

        }
        if (modelArrayList.getData().getFavFoods().getData().get(position).getGetGallery().size()>0)
        {
            Glide.with(context)
                    .load(modelArrayList.getData().getImageBaseUrl() + modelArrayList.getData().getFavFoods().getData().get(position).getGetGallery().get(0).getImage())
                    .into(holder.food_IV);
        }




        holder.tvPrice.setText("$ " + modelArrayList.getData().getFavFoods().getData().get(position).getGetSinglePrice().getPrice());


        holder.favouriteIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemClickListenerr.RemoveFoodItemFavouriteClick(modelArrayList, position);

            }
        });

      /*  if (modelArrayList.getData().getFoodItems().get(position).getGetGallery().size() > 0) {
            RequestOptions requestOptions = new RequestOptions();

          *//*  Glide.with(context)
                    .load(modelArrayList.getData().getImageBaseUrl()+modelArrayList.getData().getFoodItems().get(position).getGetGallery().get(0).getImage())
                    .into(holder.food_IV);
*//*
            Glide.with(context)
                    .setDefaultRequestOptions(requestOptions)
                    .load(modelArrayList.getData().getImageBaseUrl() + modelArrayList.getData().getFoodItems().get(position).getGetGallery().get(0).getImage())

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
*/


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.FoodItemClick(modelArrayList, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getFavFoods().getData().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tv_descriptionp, tvPrice, foodname_TV, listfoodTV;
        ImageView food_IV, favouriteIV;
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

        }
    }

    public interface FoodFavouriteItemClick {

        void FoodItemClick(FavouritefoodsRepo repo, int pos);

        void RemoveFoodItemFavouriteClick(FavouritefoodsRepo repo, int pos);
    }
}
