package com.webmingo.oldjerusalemrestaurant.Adapters.FoodFavourite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.SearchRepo;
import com.webmingo.oldjerusalemrestaurant.R;


public class FoodItemSearchAdapter extends RecyclerView.Adapter<FoodItemSearchAdapter.myViewHolder> {
    SearchRepo arrayList;
    Context context;
    SearchRepoView clicklistener;

    public FoodItemSearchAdapter(SearchRepo arrayList, Context context, SearchRepoView clicklistener) {
        this.arrayList = arrayList;
        this.context = context;
        this.clicklistener = clicklistener;
    }
/*
    public SearchAdapter(SearchRepo arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }*/

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);

        return new myViewHolder(view);
    }

    @Override

    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.tv_title.setText(arrayList.getData().getItems().get(position).getLabel());

        holder.ll_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clicklistener.onSearchFoodItemclick(arrayList, position);

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.getData().getItems().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        LinearLayout ll_click;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            ll_click = itemView.findViewById(R.id.ll_click);


        }
    }

    public interface SearchRepoView {

        void onSearchFoodItemclick(SearchRepo SearchRepo, int pos);


    }
}
