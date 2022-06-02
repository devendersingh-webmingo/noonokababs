package com.webmingo.oldjerusalemrestaurant.Adapters.cart.CheckOut;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.webmingo.oldjerusalemrestaurant.R;

import java.util.ArrayList;


public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.myViewHolder> {
    ArrayList<String> arrayList=new ArrayList<>();
    Context context;
    int size;

    public IngredientsAdapter(ArrayList<String> arrayList, Context context, int size) {
        this.arrayList = arrayList;
        this.context = context;
        this.size = size;
    }

    @NonNull
    @Override
    public IngredientsAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.extraingredients, parent, false);

        return new IngredientsAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsAdapter.myViewHolder holder, int position) {

       // Toast.makeText(context, arrayList.size()+"", Toast.LENGTH_SHORT).show();


         holder.tv_name.setText(arrayList.get(position));

        // holder.tvtext.setText(Html.fromHtmal(String.valueOf(arrayList.getData().get(position).getPackage().getAboutPackage())));


    }

    @Override
    public int getItemCount() {
        return arrayList.size();// arrayList.size();//get(Position).getAddons().size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_itemName);


        }
    }

}
