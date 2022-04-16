package com.webmingo.noonokababs.Adapters.Reviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.webmingo.noonokababs.ModelRepo.Responsee.MediaRespo.GuestReviewRepo;
import com.webmingo.noonokababs.R;


public class GuestReviewslistAdapter extends RecyclerView.Adapter<GuestReviewslistAdapter.myViewHolder> {

    GuestReviewRepo modelArrayList;
    Context context;
    //  private CheckBoxListener itemClickListenerr;

   /* public ReferralUserAdapter(GuestReviewRepo modelArrayList, Context context, CheckBoxListener itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }
*/
 /*  public ReferralUserAdapter(Context context) {
       this.context = context;
   }*/

    public GuestReviewslistAdapter(GuestReviewRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.guestreviewsadapter, parent, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
/*
        holder.choosefile.setText(modelArrayList.getData().getHowWork().get(position).getHeading());
        holder.nameTv.setText(modelArrayList.getData().getHowWork().get(position).getTitle());*/
        if (modelArrayList.getData().getTestimonials().get(position).getImage() != null) {
            Glide.with(context)
                    .load(modelArrayList.getData().getImageBaseUrl()+modelArrayList.getData().getTestimonials().get(position).getImage())
                    .into(holder.userimage);


        }
        holder.nameTv.setText(modelArrayList.getData().getTestimonials().get(position).getName());

        holder.descriptionTv.setText(modelArrayList.getData().getTestimonials().get(position).getFeedback());



    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getTestimonials().size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView  nameTv,starsTV, descriptionTv;
        SimpleRatingBar text_rating;
        ImageView userimage;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.nameTv);
            starsTV = itemView.findViewById(R.id.starsTV);
            text_rating = itemView.findViewById(R.id.text_rating);
            userimage = itemView.findViewById(R.id.userimage);
            descriptionTv = itemView.findViewById(R.id.descriptionTv);

        }
    }

  /*  public interface CheckBoxListener {

        void CheckedClick(String id, int position, Boolean bb);


    }*/
}
