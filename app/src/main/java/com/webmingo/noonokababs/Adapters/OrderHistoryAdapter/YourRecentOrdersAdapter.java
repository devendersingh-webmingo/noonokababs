package com.webmingo.noonokababs.Adapters.OrderHistoryAdapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.webmingo.noonokababs.ModelRepo.Orderhistory.AllHistoryRepo;
import com.webmingo.noonokababs.R;

public class YourRecentOrdersAdapter extends RecyclerView.Adapter<YourRecentOrdersAdapter.myViewHolder> {

    AllHistoryRepo modelArrayList;
    Context context;
    private YourRecentOrdersClick itemClickListenerr;


    public YourRecentOrdersAdapter(AllHistoryRepo modelArrayList, Context context, YourRecentOrdersClick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

    public YourRecentOrdersAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orderhistoryitem, parent, false);

        return new YourRecentOrdersAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {


        if (modelArrayList.getData().getOrders().get(position).getStatus().equalsIgnoreCase("Pending")) {
            holder.tvcancelOrder.setVisibility(View.VISIBLE);
            holder.tvcancelOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListenerr.OnClickCancelOrder(modelArrayList, position);


                }
            });


        }


        //holder.PaymentTV.setText(""+ modelArrayList.getData().getOrders().get(position).get());

        holder.OrderidTV.setText("Order:-" + modelArrayList.getData().getOrders().get(position).getOrderId());

        holder.DateTV.setText(modelArrayList.getData().getOrders().get(position).getOrderDatetime());

        holder.nameTV.setText(modelArrayList.getData().getOrders().get(position).getOrderFoodDetail().get(0).getName());
        if ((modelArrayList.getData().getOrders().get(position).getOrderFoodDetail().get(0).getRemark() != null)) {

            holder.RemarkTv.setText(Html.fromHtml(modelArrayList.getData().getOrders().get(position).getOrderFoodDetail().get(0).getRemark()));

        }

        holder.quentityTv.setText("$" + modelArrayList.getData().getOrders().get(position).getOrderFoodDetail().get(0).getAmount());

        holder.amounTV.setText("Quantity: " + modelArrayList.getData().getOrders().get(position).getOrderFoodDetail().get(0).getQuantity());

        holder.totalamounttv.setText("Grand Total: $" + modelArrayList.getData().getOrders().get(position).getOfferAmount());


        holder.PaymentMethodTV.setText("Payment Status:- " + modelArrayList.getData().getOrders().get(position).getPayment_status());
        holder.payment_mode.setText("Payment Mode:- " + modelArrayList.getData().getOrders().get(position).getPayment_method());


        if (modelArrayList.getData().getOrders().get(position).getRated().equalsIgnoreCase("No")) {
            holder.ratingLL.setVisibility(View.VISIBLE);


        } else {
            holder.ratingLL.setVisibility(View.GONE);
        }


        holder.statustv.setText(modelArrayList.getData().getOrders().get(position).getStatus());
        Glide.with(context)
                .load(modelArrayList.getData().getImageBaseUrl() + modelArrayList.getData().getOrders().get(position).getOrderFoodDetail().get(0).getImage())

                .into(holder.productIV);


        holder.ratingLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemClickListenerr.OnClickItemRating(modelArrayList, position);
            }
        });


        holder.moredetailsLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemClickListenerr.OnClickItemOrderdetails(modelArrayList, position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getOrders().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView OrderidTV, DateTV, nameTV, RemarkTv, amounTV, quentityTv, totalamounttv, statustv, tvcancelOrder, PaymentMethodTV, payment_mode;


        ImageView productIV;
        LinearLayout moredetailsLL, ratingLL;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            OrderidTV = itemView.findViewById(R.id.OrderidTV);
            PaymentMethodTV = itemView.findViewById(R.id.PaymentMethodTV);
            payment_mode = itemView.findViewById(R.id.payment_mode);
            tvcancelOrder = itemView.findViewById(R.id.tvcancelOrder);
            DateTV = itemView.findViewById(R.id.DateTV);
            nameTV = itemView.findViewById(R.id.nameTV);
            RemarkTv = itemView.findViewById(R.id.RemarkTv);
            amounTV = itemView.findViewById(R.id.amounTV);
            quentityTv = itemView.findViewById(R.id.quentityTv);
            totalamounttv = itemView.findViewById(R.id.totalamounttv);
            statustv = itemView.findViewById(R.id.statustv);
            productIV = itemView.findViewById(R.id.productIV);
            moredetailsLL = itemView.findViewById(R.id.moredetailsLL);

            ratingLL = itemView.findViewById(R.id.ratingLL);

        }
    }

    public interface YourRecentOrdersClick {


        void OnClickItemOrderdetails(AllHistoryRepo repo, int pos);

        void OnClickCancelOrder(AllHistoryRepo repo, int pos);


        void OnClickItemRating(AllHistoryRepo repo, int pos);


    }
}
