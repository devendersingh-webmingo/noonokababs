package com.webmingo.noonokababs.Adapters.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webmingo.noonokababs.ModelRepo.cart.AddToCartDetailsRepo;
import com.webmingo.noonokababs.R;

public class integedientItemCartAdapter extends RecyclerView.Adapter<integedientItemCartAdapter.myViewHolder> {

    AddToCartDetailsRepo modelArrayList;
    Context context;
    private  RequriedItemCartclick itemClickListenerr;

    public integedientItemCartAdapter(AddToCartDetailsRepo modelArrayList, Context context, RequriedItemCartclick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }



    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.extraingredients_adapter, parent, false);

        return new integedientItemCartAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.simpleCheckBox.setText(modelArrayList.getData().getIngredients().get(position).getName());

        holder.simpleCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                itemClickListenerr.RequriedItemCheckedClick(modelArrayList, position, isChecked);


            }
        });
    /*    Picasso.get().load(modelArrayList.getData().getCategories().get(position).getImage()).into(holder.ivimageone);

        holder.clickRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.HomeAdapterClickk(modelArrayList,position);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getIngredients().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {


        CheckBox simpleCheckBox;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            simpleCheckBox = itemView.findViewById(R.id.simpleCheckBox);

        }
    }

    public interface RequriedItemCartclick {

        void  RequriedItemCheckedClick(AddToCartDetailsRepo repo, int position, Boolean bb);


      //   void HomeAdapterClickk(FinacialCategoryRepo repo,int pos);


    }
}
