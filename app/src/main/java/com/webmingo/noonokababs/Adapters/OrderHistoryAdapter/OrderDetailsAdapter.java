package com.webmingo.noonokababs.Adapters.OrderHistoryAdapter;

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

import com.webmingo.noonokababs.Adapters.cart.CheckOut.AddonseitemCheckAdapter;
import com.webmingo.noonokababs.Adapters.cart.CheckOut.IngredientsAdapter;
import com.webmingo.noonokababs.Modal.AddonseModal;
import com.webmingo.noonokababs.ModelRepo.Orderhistory.HistoryDetailsRepo;
import com.webmingo.noonokababs.R;

import java.util.ArrayList;

public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.myViewHolder> {

    HistoryDetailsRepo modelArrayList;
    Context context;
    ArrayList<String> arrayList = new ArrayList<>();
    GridLayoutManager gridLayoutManager;

    ArrayList<AddonseModal> arrayListadonsemodal = new ArrayList<>();

    public OrderDetailsAdapter(HistoryDetailsRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    /* public AddonseCartAdapter(AddToCartDetailsRepo modelArrayList, Context context) {
         this.modelArrayList = modelArrayList;
         this.context = context;
     }
 */
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orderdetailsadapter, parent, false);

        return new OrderDetailsAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.reuiredRB.setText(modelArrayList.getData().getOrderDetail().getOrderFoodDetail().get(position).getName());
        holder.amounTV.setText("Quantity :-" + modelArrayList.getData().getOrderDetail().getOrderFoodDetail().get(position).getQuantity());
        holder.quentityTv.setText("$" + modelArrayList.getData().getOrderDetail().getOrderFoodDetail().get(position).getAmount());
        //   holder.tvPrice.setText(modelArrayList.getData().getCartDetails().get(position).getFood().get);

        if (modelArrayList.getData().getOrderDetail().getOrderFoodDetail().get(position).getAddons() != null) {


            if (modelArrayList.getData().getOrderDetail().getOrderFoodDetail().get(position).getAddons().size() > 0) {
                holder.lladdonse.setVisibility(View.VISIBLE);
                arrayListadonsemodal.clear();

                for (int i = 0; i < modelArrayList.getData().getOrderDetail().getOrderFoodDetail().get(position).getAddons().size(); i++) {

                    arrayListadonsemodal.add(new AddonseModal(modelArrayList.getData().getOrderDetail().getOrderFoodDetail().get(position).getAddons().get(i).getName(),
                            String.valueOf(modelArrayList.getData().getOrderDetail().getOrderFoodDetail().get(position).getAddons().get(i).getQuantity()),
                            " ",
                            modelArrayList.getData().getOrderDetail().getOrderFoodDetail().get(position).getAddons().get(i).getPrice()));
                }

                AddonseiOrderDetailsAdapter gameAdapter = new AddonseiOrderDetailsAdapter(context, arrayListadonsemodal);
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


        }
        if (modelArrayList.getData().getOrderDetail().getOrderFoodDetail().get(position).getIngredients() != null) {

            if (modelArrayList.getData().getOrderDetail().getOrderFoodDetail().get(position).getIngredients().size() > 0) {
                int number = 0;
                holder.extraingredientsLL.setVisibility(View.VISIBLE);
                arrayList.clear();
                for (int i = 0; i < modelArrayList.getData().getOrderDetail().getOrderFoodDetail().get(position).getIngredients().size(); i++) {
                    number = number + 1;
                    arrayList.add("." + modelArrayList.getData().getOrderDetail().getOrderFoodDetail().get(position).getIngredients().get(i).getName());
                }
                gridLayoutManager = new GridLayoutManager(context, 1);
                IngredientsAdapter addonseorderAdapter = new IngredientsAdapter(arrayList, context, modelArrayList.getData().getOrderDetail().getOrderFoodDetail().get(position).getIngredients().size());
                holder.EXTRAlistRV.setHasFixedSize(true);
                holder.EXTRAlistRV.setLayoutManager(gridLayoutManager);
                holder.EXTRAlistRV.setAdapter(addonseorderAdapter);
            }

        }


    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getOrderDetail().getOrderFoodDetail().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {


        RadioButton reuiredRB;
        TextView amounTV, quentityTv;

        LinearLayout lladdonse, extraingredientsLL;
        RecyclerView EXTRAlistRV, productlistRV;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            reuiredRB = itemView.findViewById(R.id.reuiredRB);
            lladdonse = itemView.findViewById(R.id.lladdonse);
            quentityTv = itemView.findViewById(R.id.quentityTv);
            amounTV = itemView.findViewById(R.id.amounTV);
            extraingredientsLL = itemView.findViewById(R.id.extraingredientsLL);
            EXTRAlistRV = itemView.findViewById(R.id.EXTRAlistRV);
            productlistRV = itemView.findViewById(R.id.productlistRV);
            //切换无动画
        }
    }


}
