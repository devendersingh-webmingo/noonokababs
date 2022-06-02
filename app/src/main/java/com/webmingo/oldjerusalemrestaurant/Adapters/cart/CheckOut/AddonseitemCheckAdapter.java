package com.webmingo.oldjerusalemrestaurant.Adapters.cart.CheckOut;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webmingo.oldjerusalemrestaurant.Modal.AddonseModal;
import com.webmingo.oldjerusalemrestaurant.R;

import java.util.ArrayList;

public class AddonseitemCheckAdapter extends RecyclerView.Adapter<AddonseitemCheckAdapter.myViewHolder> {
//modelArrayList.getData().getCartDetails().get().getAddons().size()

    Context context;
    private AddonseItemCartclick itemClickListenerr;
    int quantity;
    ArrayList<AddonseModal> arrayListadonsemodal = new ArrayList<>();

    public AddonseitemCheckAdapter(Context context, ArrayList<AddonseModal> arrayListadonsemodal) {
        this.context = context;
        this.arrayListadonsemodal = arrayListadonsemodal;
    }/*

    public AddonseitemCheckAdapter(ArrayList<AddonseModal> arrayListadonsemodal, Context context, AddonseItemCartclick itemClickListenerr) {
        this.arrayListadonsemodal = arrayListadonsemodal;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }*/

    /* public AddonseCartAdapter(AddToCartDetailsRepo modelArrayList, Context context) {
         this.modelArrayList = modelArrayList;
         this.context = context;
     }
 */
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.productadonselistcart_adapter, parent, false);

        return new AddonseitemCheckAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        if (arrayListadonsemodal.get(position) != null) {

            if (arrayListadonsemodal.get(position).getName() != null) {
                holder.AddonseRB.setText(arrayListadonsemodal.get(position).getName());
                holder.addonseTv.setText(Html.fromHtml(arrayListadonsemodal.get(position).getName()));

            }


            holder.quentityTv.setText(Html.fromHtml(arrayListadonsemodal.get(position).getQuentity()));

            holder.tvPrice.setText(Html.fromHtml(arrayListadonsemodal.get(position).getPrice()));


        }
        holder.Decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  if (quantity > 1) {
                    quantity--;

                    holder.quentityTv.setText(String.valueOf(quantity));

                    // itemClickListenerr.DecressQuentity(String.valueOf(quantity), position, modelArrayList);

                }*/


            }
        });
        holder.Increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* quantity = Integer.parseInt(holder.quentityTv.getText().toString());
                quantity++;
                holder.quentityTv.setText(String.valueOf(quantity));

                // itemClickListenerr.IncreaseQuentity(String.valueOf(quantity), position, modelArrayList);

*/
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
        return arrayListadonsemodal.size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        RadioButton AddonseRB;
        TextView addonseTv, tvPrice, quentityTv;
        ImageView Decrease, Increase;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            Decrease = itemView.findViewById(R.id.Decrease);
            Increase = itemView.findViewById(R.id.Increase);
            AddonseRB = itemView.findViewById(R.id.AddonseRB);
            addonseTv = itemView.findViewById(R.id.addonseTv);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            quentityTv = itemView.findViewById(R.id.quentityTv);
        }
    }

    public interface AddonseItemCartclick {
/*

        void IncreaseQuentity(String Quentity, int position, FoodCartViewRepo addToCartDetailsRepo);

        void DecressQuentity(String Quentity, int position, FoodCartViewRepo addToCartDetailsRepo);

        void EnableCheckedClick(AddToCartDetailsRepo repo, int position, Boolean bb);
*/

        //   void HomeAdapterClickk(FinacialCategoryRepo repo,int pos);


    }
}
