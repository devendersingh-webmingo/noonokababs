package com.webmingo.oldjerusalemrestaurant.Adapters.cart.CheckOut;

import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.webmingo.oldjerusalemrestaurant.Modal.AddonseModal;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.cart.FoodCartViewRepo;
import com.webmingo.oldjerusalemrestaurant.R;

import java.util.ArrayList;

public class ItemOnCheckOutAdapter extends RecyclerView.Adapter<ItemOnCheckOutAdapter.myViewHolder> {


    FoodCartViewRepo modelArrayList;
    Context context;
    private ItemCartclick itemClickListenerr;
    int quantity;
    ArrayList<String> arrayList = new ArrayList<>();
    GridLayoutManager gridLayoutManager;
    ArrayList<FoodCartViewRepo.Data.CartDetail.Addon> AddonarrayList = new ArrayList<>();

    ArrayList<AddonseModal> arrayListadonsemodal = new ArrayList<>();

    public ItemOnCheckOutAdapter(FoodCartViewRepo modelArrayList, Context context, ItemCartclick itemClickListenerr) {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.productlistcart_adapter, parent, false);

        return new ItemOnCheckOutAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.reuiredRB.setText(modelArrayList.getData().getCartDetails().get(position).getVarient().getName());
        holder.tvPrice.setText(modelArrayList.getData().getCartDetails().get(position).getVarient().getFinalPrice());
        holder.quentityTv.setText(modelArrayList.getData().getCartDetails().get(position).getQuantity());
        if (modelArrayList.getData().getCartDetails().get(position).getFood().getRemark() != null) {
            holder.addonseTv.setText(Html.fromHtml(modelArrayList.getData().getCartDetails().get(position).getFood().getRemark()));

        }

        quantity = Integer.parseInt(modelArrayList.getData().getCartDetails().get(position).getQuantity());


        //   holder.tvPrice.setText(modelArrayList.getData().getCartDetails().get(position).getFood().get);
        if (modelArrayList.getData().getCartDetails().get(position).getRequiredItem() != null) {
            holder.required_itemTv.setVisibility(View.VISIBLE);
            holder.required_itemTv.setText(".Lunch Special:- " + modelArrayList.getData().getCartDetails().get(position).getRequiredItem().getName());
        }
        if (modelArrayList.getData().getCartDetails().get(position).getCookingLevel() != null) {
            holder.cooking_levelTv.setVisibility(View.VISIBLE);
            holder.cooking_levelTv.setText(".COOKING LEVEL:- " + modelArrayList.getData().getCartDetails().get(position).getCookingLevel().getName());
        }

        Log.e("modelArrayListadonse", String.valueOf(modelArrayList.getData().getCartDetails().get(position).getAddons().size()));
        Log.e("modeladonse", modelArrayList.getData().getCartDetails().get(position).getAddons().toString());

        if (modelArrayList.getData().getCartDetails().get(position).getAddons().size() > 0) {


            holder.AddonTv.setVisibility(View.VISIBLE);
            arrayListadonsemodal.clear();
            for (int i = 0; i < modelArrayList.getData().getCartDetails().get(position).getAddons().size(); i++) {
                arrayListadonsemodal.add(new AddonseModal(modelArrayList.getData().getCartDetails().get(position).getAddons().get(i).getName(),
                        String.valueOf(modelArrayList.getData().getCartDetails().get(position).getAddons().get(i).getQuantityId()),
                        modelArrayList.getData().getCartDetails().get(position).getAddons().get(i).getGetFood().getDescription(),

                        modelArrayList.getData().getCartDetails().get(position).getAddons().get(i).getPrice()));

            }
            AddonseitemCheckAdapter gameAdapter = new AddonseitemCheckAdapter(context, arrayListadonsemodal);
            RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            holder.productlistRV.setLayoutManager(mLayoutManager1);
            holder.productlistRV.setItemAnimator(new DefaultItemAnimator());
            holder.productlistRV.setAdapter(gameAdapter);






        /*    AddonseitemCheckAdapter gameAdapter = new AddonseitemCheckAdapter(response, context, this);
            RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            binding.productlistRV.setLayoutManager(mLayoutManager1);
            binding.productlistRV.setItemAnimator(new DefaultItemAnimator());
            binding.productlistRV.setAdapter(gameAdapter);

*/

        }
        int size = modelArrayList.getData().getCartDetails().get(position).getIngredients().size();
        //    Toast.makeText(context, size+"", Toast.LENGTH_SHORT).show();
        int number = 0;
        if (size > 0) {
            holder.extraingredientsLL.setVisibility(View.VISIBLE);
            arrayList.clear();
            for (int i = 0; i < size; i++) {
                number = number + 1;
                arrayList.add("." + modelArrayList.getData().getCartDetails().get(position).getIngredients().get(i).getName()+"\n $"+modelArrayList.getData().getCartDetails().get(position).getIngredients().get(i).getPrice());



            }

            gridLayoutManager = new GridLayoutManager(context, 1);
            IngredientsAdapter addonseorderAdapter = new IngredientsAdapter(arrayList, context, size);
            holder.EXTRAlistRV.setHasFixedSize(true);
            holder.EXTRAlistRV.setLayoutManager(gridLayoutManager);
            holder.EXTRAlistRV.setAdapter(addonseorderAdapter);

        }

        int adonsesize = modelArrayList.getData().getCartDetails().get(position).getAddons().size();
        //    Toast.makeText(context, size+"", Toast.LENGTH_SHORT).show();
        int adonsenumber = 0;
        if (adonsesize > 0) {
            holder.extraingredientsLL.setVisibility(View.VISIBLE);
            AddonarrayList.clear();
            for (int i = 0; i < adonsesize; i++) {
                adonsenumber = adonsenumber + 1;
                //  AddonarrayList.add(modelArrayList.getData().getCartDetails().get(position).getAddons());

            }

            gridLayoutManager = new GridLayoutManager(context, 1);
            IngredientsAdapter addonseorderAdapter = new IngredientsAdapter(arrayList, context, size);
            holder.EXTRAlistRV.setHasFixedSize(true);
            holder.EXTRAlistRV.setLayoutManager(gridLayoutManager);
            holder.EXTRAlistRV.setAdapter(addonseorderAdapter);

        }

        quantity = Integer.parseInt(modelArrayList.getData().getCartDetails().get(position).getQuantity());

        holder.Decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (quantity > 1) {
                    quantity--;

                    holder.quentityTv.setText(String.valueOf(quantity));

                    itemClickListenerr.DecressQuentity(String.valueOf(quantity), position, modelArrayList);

                }




             /*
                int count= Integer.parseInt(String.valueOf(holder.quentityTv.getText()));

                if (count == 1) {


                    holder.quentityTv.setText(String.valueOf(quantity));

                } else {
                    count -= 1;
                    holder.quentityTv.setText(""+count);


                }*/


            }
        });
        holder.Increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quantity = Integer.parseInt(holder.quentityTv.getText().toString());
                quantity++;
                holder.quentityTv.setText(String.valueOf(quantity));

                itemClickListenerr.IncreaseQuentity(String.valueOf(quantity), position, modelArrayList);


            }
        });

        holder.Remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                itemClickListenerr.CartRemovedItem(String.valueOf(quantity), position, modelArrayList);

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
        return modelArrayList.getData().getCartDetails().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {


        RadioButton reuiredRB;
        TextView addonseTv, quentityTv, tvPrice, required_itemTv, cooking_levelTv, AddonTv, Remove;

        ImageView Decrease, Increase;
        LinearLayout extraingredientsLL;
        RecyclerView EXTRAlistRV, productlistRV;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            reuiredRB = itemView.findViewById(R.id.reuiredRB);
            productlistRV = itemView.findViewById(R.id.productlistRV);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            Remove = itemView.findViewById(R.id.Remove);
            Decrease = itemView.findViewById(R.id.Decrease);
            Increase = itemView.findViewById(R.id.Increase);
            quentityTv = itemView.findViewById(R.id.quentityTv);
            addonseTv = itemView.findViewById(R.id.addonseTv);
            required_itemTv = itemView.findViewById(R.id.required_itemTv);
            cooking_levelTv = itemView.findViewById(R.id.cooking_levelTv);
            AddonTv = itemView.findViewById(R.id.AddonTv);
            extraingredientsLL = itemView.findViewById(R.id.extraingredientsLL);
            EXTRAlistRV = itemView.findViewById(R.id.EXTRAlistRV);
            //切换无动画
        }
    }

    public interface ItemCartclick {

        void IncreaseQuentity(String Quentity, int position, FoodCartViewRepo addToCartDetailsRepo);

        void DecressQuentity(String Quentity, int position, FoodCartViewRepo addToCartDetailsRepo);

        void CartRemovedItem(String Quentity, int position, FoodCartViewRepo addToCartDetailsRepo);


        //   void HomeAdapterClickk(FinacialCategoryRepo repo,int pos);


    }
}
