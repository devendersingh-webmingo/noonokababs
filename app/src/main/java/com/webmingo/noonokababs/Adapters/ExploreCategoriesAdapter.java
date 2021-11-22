package com.webmingo.noonokababs.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.webmingo.noonokababs.ModelRepo.Responsee.DashboardRepo;
import com.webmingo.noonokababs.R;

public class ExploreCategoriesAdapter extends RecyclerView.Adapter<ExploreCategoriesAdapter.myViewHolder> {

    DashboardRepo modelArrayList;
    Context context;
    private ExploreCategoriesClick itemClickListenerr;


    public ExploreCategoriesAdapter(DashboardRepo modelArrayList, Context context, ExploreCategoriesClick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.explorecategories, parent, false);

        return new ExploreCategoriesAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.TV_name.setText(modelArrayList.getData().getCategories().get(position).getName());
        Glide.with(context)
                .load(modelArrayList.getData().getImageBaseUrl() + modelArrayList.getData().getCategories().get(position).getImage())
                .into(holder.IV_image);
        holder.clickRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.ExploreCategoriesClickk(modelArrayList, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getCategories().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView IV_image;
        TextView TV_name;
        LinearLayout clickRL;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            IV_image = itemView.findViewById(R.id.IV_image);
            TV_name = itemView.findViewById(R.id.TV_name);
            clickRL = itemView.findViewById(R.id.clickRL);
        }
    }

    public interface ExploreCategoriesClick {

        void ExploreCategoriesClickk(DashboardRepo repo, int pos);


    }
}
