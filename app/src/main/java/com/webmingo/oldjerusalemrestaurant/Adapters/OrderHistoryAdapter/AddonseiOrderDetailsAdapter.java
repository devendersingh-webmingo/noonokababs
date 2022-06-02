package com.webmingo.oldjerusalemrestaurant.Adapters.OrderHistoryAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webmingo.oldjerusalemrestaurant.Modal.AddonseModal;
import com.webmingo.oldjerusalemrestaurant.R;

import java.util.ArrayList;

public class AddonseiOrderDetailsAdapter extends RecyclerView.Adapter<AddonseiOrderDetailsAdapter.myViewHolder> {
//modelArrayList.getData().getCartDetails().get().getAddons().size()

    Context context;

    ArrayList<AddonseModal> arrayListadonsemodal = new ArrayList<>();

    public AddonseiOrderDetailsAdapter(Context context, ArrayList<AddonseModal> arrayListadonsemodal) {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.productdetalsadpteraddonse, parent, false);

        return new AddonseiOrderDetailsAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.reuiredRB.setText(arrayListadonsemodal.get(position).getName());

        holder.amounTV.setText("Quantity :-" + arrayListadonsemodal.get(position).getQuentity());
        holder.quentityTv.setText("$" + arrayListadonsemodal.get(position).getPrice());




       
    }

    @Override
    public int getItemCount() {
        return arrayListadonsemodal.size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        RadioButton reuiredRB;
        TextView quentityTv, tvPrice, amounTV;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            reuiredRB = itemView.findViewById(R.id.reuiredRB);
            quentityTv = itemView.findViewById(R.id.quentityTv);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            amounTV = itemView.findViewById(R.id.amounTV);
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
