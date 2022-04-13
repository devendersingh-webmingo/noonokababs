package com.webmingo.noonokababs.Adapters.Reviews;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webmingo.noonokababs.ModelRepo.Responsee.MediaRespo.MediaReviewRepo;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.Utils.util;

public class MediaViewAdapter extends RecyclerView.Adapter<MediaViewAdapter.myViewHolder> {

    MediaReviewRepo modelArrayList;
    Context context;


    public MediaViewAdapter(MediaReviewRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mediareviewsadapter, parent, false);
        return new MediaViewAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.titleTv.setText(modelArrayList.getData().getReviews().get(position).getName());
        holder.SubtitleTv.setText(modelArrayList.getData().getReviews().get(position).getGetCategory().getName());
        holder.Descriptiontv.setText(Html.fromHtml(modelArrayList.getData().getReviews().get(position).getReview()));
        holder.clientnamedateTV.setText(util.getDate(modelArrayList.getData().getReviews().get(position).getCreatedAt()) + " By " + modelArrayList.getData().getReviews().get(position).getClientName());



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
        return modelArrayList.getData().getReviews().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView titleTv, SubtitleTv, Descriptiontv, clientnamedateTV;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            SubtitleTv = itemView.findViewById(R.id.SubtitleTv);
            titleTv = itemView.findViewById(R.id.titleTv);

            Descriptiontv = itemView.findViewById(R.id.Descriptiontv);
            clientnamedateTV = itemView.findViewById(R.id.clientnamedateTV);


        }
    }

}
