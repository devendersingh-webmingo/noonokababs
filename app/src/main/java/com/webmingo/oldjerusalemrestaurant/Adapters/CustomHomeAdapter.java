package com.webmingo.oldjerusalemrestaurant.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webmingo.oldjerusalemrestaurant.Modal.HomeModal;
import com.webmingo.oldjerusalemrestaurant.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomHomeAdapter  extends RecyclerView.Adapter<CustomHomeAdapter.myViewHolder> {


    private ArrayList<HomeModal> dataSet;
    Context context;
    HomeAdapterClick homeAdapterClick;


    public CustomHomeAdapter(ArrayList<HomeModal> dataSet, Context context, HomeAdapterClick homeAdapterClick) {
        this.dataSet = dataSet;
        this.context = context;
        this.homeAdapterClick = homeAdapterClick;
    }



    @NonNull
    @Override
    public CustomHomeAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homeadapter, parent, false);

        return new CustomHomeAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHomeAdapter.myViewHolder holder, int position) {

        holder.iconIv.setImageResource(dataSet.get(position).getIcon());
        holder.deshboarditemTV.setText(dataSet.get(position).getName());
      holder.LinerlayoputLL.setBackgroundResource(dataSet.get(position).getBackgroundImage());

      holder.LinerlayoputLL.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              homeAdapterClick.AdapterClick(dataSet, position);
          }
      });


      
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
        


    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView deshboarditemTV;
        ImageView iconIv;

        LinearLayout LinerlayoputLL;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            deshboarditemTV = itemView.findViewById(R.id.deshboarditemTV);
            iconIv = itemView.findViewById(R.id.iconIv);
            LinerlayoputLL = itemView.findViewById(R.id.LinerlayoputLL);


        }
    }

    public interface HomeAdapterClick {

        void AdapterClick(ArrayList<HomeModal>  repo, int pos);



    }
}
