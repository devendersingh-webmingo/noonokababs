package com.webmingo.oldjerusalemrestaurant.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.SearchCategoriesRepo;
import com.webmingo.oldjerusalemrestaurant.R;


public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.myViewHolder>{
    SearchCategoriesRepo arrayList;
    Context context;
    SearchListener clicklistener;

    public SearchAdapter(SearchCategoriesRepo arrayList, Context context, SearchListener clicklistener) {
        this.arrayList = arrayList;
        this.context = context;
        this.clicklistener = clicklistener;
    }
/*
    public SearchAdapter(SearchCategoriesRepo arrayList, Context context) {
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

        holder.tv_title.setText(arrayList.getData().getCategories().get(position).getName());

        holder.ll_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clicklistener.onSearchclick(arrayList,position);

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.getData().getCategories().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        LinearLayout ll_click ;
      
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title= itemView.findViewById(R.id.tv_title);
            ll_click= itemView.findViewById(R.id.ll_click);


        }
    }
    public interface SearchListener {

        void onSearchclick(SearchCategoriesRepo SearchCategoriesRepo,int pos);


    }
}
