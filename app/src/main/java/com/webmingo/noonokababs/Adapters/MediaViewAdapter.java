package com.webmingo.noonokababs.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webmingo.noonokababs.R;

public class MediaViewAdapter extends RecyclerView.Adapter<MediaViewAdapter.myViewHolder> {

    //  FinacialCategoryRepo modelArrayList;
    Context context;
    private HomeAdapterClick itemClickListenerr;

   /*  public ExploreCategoriesAdapter(FinacialCategoryRepo modelArrayList, Context context, HomeAdapterClick itemClickListenerr) {
          this.modelArrayList = modelArrayList;
          this.context = context;
          this.itemClickListenerr = itemClickListenerr;
      }*/

    public MediaViewAdapter(Context context) {

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
        return 5;


    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

    public interface HomeAdapterClick {

        // void HomeAdapterClickk(FinacialCategoryRepo repo,int pos);


    }
}
