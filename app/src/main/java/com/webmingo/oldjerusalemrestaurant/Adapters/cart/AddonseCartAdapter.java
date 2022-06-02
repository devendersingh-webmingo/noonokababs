package com.webmingo.oldjerusalemrestaurant.Adapters.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zcw.togglebutton.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.cart.AddToCartDetailsRepo;
import com.webmingo.oldjerusalemrestaurant.R;

public class AddonseCartAdapter extends RecyclerView.Adapter<AddonseCartAdapter.myViewHolder> {

    AddToCartDetailsRepo modelArrayList;
    Context context;
    private AddonseItemCartclick itemClickListenerr;
    int quantity;
    public AddonseCartAdapter(AddToCartDetailsRepo modelArrayList, Context context, AddonseItemCartclick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

   /* public AddonseCartAdapter(AddToCartDetailsRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }
*/
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.addonseadapter_cart, parent, false);

        return new AddonseCartAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

          Glide.with(context)
                .load(modelArrayList.getData().getImageBaseUrl() + modelArrayList.getData().getAddons().get(position).getGetGallery().get(0).getImage())
                .into(holder.imageView);

        if (modelArrayList.getData().getAddons().get(position).getGetAddonFoodVarients().size()>0)
        {
            holder.name.setText(modelArrayList.getData().getAddons().get(position).getGetAddonFoodVarients().get(0).getName());
            holder.tvPrice.setText(modelArrayList.getData().getAddons().get(position).getGetAddonFoodVarients().get(0).getFinalPrice());
            if (Integer.valueOf(modelArrayList.getData().getAddons().get(position).getGetAddonFoodVarients().get(0).getStockQuantity()) > 0) {
                holder.defualtcardTB.setVisibility(View.VISIBLE);
            }else {
                holder.outofstockTV.setVisibility(View.VISIBLE);
            }

        }


        holder.defualtcardTB.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                itemClickListenerr.EnableCheckedClick(modelArrayList,position,on);


                if (on == true) {
                    holder.quentityTvLL.setVisibility(View.VISIBLE);



                } else {

                    holder.quentityTvLL.setVisibility(View.GONE);

                }
            }
        });

        holder. Decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (quantity > 1) {
                    quantity--;

                    holder.quentityTv.setText(String.valueOf(quantity));

                    itemClickListenerr.DecressQuentity(String.valueOf(quantity),position,modelArrayList);

                }





            }
        });
        holder. Increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quantity = Integer.parseInt(holder.quentityTv.getText().toString());
                quantity++;
                holder.quentityTv.setText(String.valueOf(quantity));

                itemClickListenerr.IncreaseQuentity(String.valueOf(quantity),position,modelArrayList);








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
        return modelArrayList.getData().getAddons().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvPrice, name,outofstockTV,quentityTv;

        ToggleButton defualtcardTB;
        LinearLayout quentityTvLL;
        ImageView Decrease,Increase;



        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            name = itemView.findViewById(R.id.name);
            quentityTvLL = itemView.findViewById(R.id.quentityTvLL);
            defualtcardTB = itemView.findViewById(R.id.defualtcardTB);
            outofstockTV= itemView.findViewById(R.id.outofstockTV);
            Decrease= itemView.findViewById(R.id.Decrease);
            Increase= itemView.findViewById(R.id.Increase);
            quentityTv= itemView.findViewById(R.id.quentityTv);
            //切换无动画
        }
    }

    public interface AddonseItemCartclick {

        void IncreaseQuentity(String Quentity, int position, AddToCartDetailsRepo addToCartDetailsRepo);
        void DecressQuentity(String Quentity, int position,AddToCartDetailsRepo addToCartDetailsRepo);
        void  EnableCheckedClick(AddToCartDetailsRepo repo, int position, Boolean bb);

        //   void HomeAdapterClickk(FinacialCategoryRepo repo,int pos);


    }
}
