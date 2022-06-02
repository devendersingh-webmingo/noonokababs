package com.webmingo.oldjerusalemrestaurant.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.ReferralRepo;
import com.webmingo.oldjerusalemrestaurant.R;


public class ReferralUserlistAdapter extends RecyclerView.Adapter<ReferralUserlistAdapter.myViewHolder> {

    ReferralRepo modelArrayList;
    Context context;
    //  private CheckBoxListener itemClickListenerr;

   /* public ReferralUserAdapter(ReferralRepo modelArrayList, Context context, CheckBoxListener itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }
*/
 /*  public ReferralUserAdapter(Context context) {
       this.context = context;
   }*/

    public ReferralUserlistAdapter(ReferralRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.howitsadapter, parent, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.choosefile.setText(modelArrayList.getData().getHowWork().get(position).getHeading());
        holder.newText.setText(modelArrayList.getData().getHowWork().get(position).getTitle());
        if (modelArrayList.getData().getHowWork().get(position).getImage() != null) {
            Glide.with(context)
                    .load(modelArrayList.getData().getHowWork().get(position).getImage())
                    .into(holder.ivImages);


        }


    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getHowWork().size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView choosefile, newText;
        ImageView ivImages;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            choosefile = itemView.findViewById(R.id.choosefile);
            newText = itemView.findViewById(R.id.newText);
            ivImages = itemView.findViewById(R.id.ivImages);

        }
    }

  /*  public interface CheckBoxListener {

        void CheckedClick(String id, int position, Boolean bb);


    }*/
}
