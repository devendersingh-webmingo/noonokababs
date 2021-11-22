package com.webmingo.noonokababs.Adapters.FoodFavourite;


import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.webmingo.noonokababs.ModelRepo.Responsee.FoodItemRepo;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.interfacec.OnLoadMoreListener;

import java.util.List;

class LoadingViewHolder extends RecyclerView.ViewHolder {
    public ProgressBar progressBar;

    public LoadingViewHolder(View view) {
        super(view);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar1);
    }
}

// "Normal item" ViewHolder
class UserViewHolder extends RecyclerView.ViewHolder {
   /* public TextView phone;
    public TextView email;*/

    TextView tv_descriptionp, tvPrice, foodname_TV, listfoodTV;
    ImageView food_IV, favouriteIV, favouriteRemoveIV;
    LinearLayout cardView;

    public UserViewHolder(View view) {
        super(view);
        tv_descriptionp = itemView.findViewById(R.id.tv_descriptionp);
        tvPrice = itemView.findViewById(R.id.tvPrice);
        foodname_TV = itemView.findViewById(R.id.foodname_TV);
        favouriteIV = itemView.findViewById(R.id.favouriteIV);
        food_IV = itemView.findViewById(R.id.food_IV);
        listfoodTV = itemView.findViewById(R.id.listfoodTV);
        cardView = itemView.findViewById(R.id.cardView);
        favouriteRemoveIV = itemView.findViewById(R.id.favouriteRemoveIV);


    }
}


public class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    FoodItemRepo modelArrayList;

    private boolean isLoading;
    private Activity activity;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;

    private OnLoadMoreListener onLoadMoreListener;

    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.onLoadMoreListener = mOnLoadMoreListener;
    }

    public ContactAdapter(RecyclerView recyclerView, FoodItemRepo modelArrayList, Activity activity) {
        this.modelArrayList = modelArrayList;
        this.activity = activity;

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onLoadMore();
                    }
                    isLoading = true;
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {


        return modelArrayList.getData().getFoodItems().getData().get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(activity).inflate(R.layout.fooditemadapter, parent, false);
            return new UserViewHolder(view);
        } else if (viewType == VIEW_TYPE_LOADING) {
            View view = LayoutInflater.from(activity).inflate(R.layout.item_loading, parent, false);
            return new LoadingViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if (holder instanceof UserViewHolder) {
            //     Contact contact = contacts.getData().get(position);

            UserViewHolder userViewHolder = (UserViewHolder) holder;
          /*  userViewHolder.phone.setText(contact.getEmail());
            userViewHolder.email.setText(contact.getPhone());*/

            if (modelArrayList.getData().getFoodItems().getData().get(position).getRemark() != null) {
                userViewHolder.tv_descriptionp.setText(Html.fromHtml(modelArrayList.getData().getFoodItems().getData().get(position).getRemark()));


            }
            userViewHolder.listfoodTV.setText(modelArrayList.getData().getFoodItems().getData().get(position).getDescription());
            userViewHolder.tvPrice.setText("$ " + modelArrayList.getData().getFoodItems().getData().get(position).getGetSinglePrice().getPrice());
            if (modelArrayList.getData().getFoodItems().getData().get(position).getGetGallery().size() > 0) {
                RequestOptions requestOptions = new RequestOptions();

          /*  Glide.with(context)
                    .load(modelArrayList.getData().getImageBaseUrl()+modelArrayList.getData().getFoodItems().getData().get(position).getGetGallery().get(0).getImage())
                    .into(holder.food_IV);
*/
                Glide.with(activity)
                        .setDefaultRequestOptions(requestOptions)
                        .load(modelArrayList.getData().getImageBaseUrl() + modelArrayList.getData().getFoodItems().getData().get(position).getGetGallery().get(0).getImage())

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
                        .into(userViewHolder.food_IV);


            }


            userViewHolder.foodname_TV.setText(modelArrayList.getData().getFoodItems().getData().get(position).getName());


            userViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // itemClickListenerr.FoodItemClick(modelArrayList, position);
                }
            });
            userViewHolder.favouriteIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //itemClickListenerr.FoodItemFavouriteClick(modelArrayList, position);
                    userViewHolder.favouriteRemoveIV.setVisibility(View.VISIBLE);
                    userViewHolder.favouriteIV.setVisibility(View.GONE);

                }
            });
            userViewHolder.favouriteRemoveIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    //itemClickListenerr.FoodItemFavouriteClick(modelArrayList, position);
                    userViewHolder.favouriteRemoveIV.setVisibility(View.GONE);
                    userViewHolder.favouriteIV.setVisibility(View.VISIBLE);

                }
            });


        } else if (holder instanceof LoadingViewHolder) {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getFoodItems() == null ? 0 : modelArrayList.getData().getFoodItems().getData().size();
    }

    public void setLoaded() {
        isLoading = false;
    }
}
