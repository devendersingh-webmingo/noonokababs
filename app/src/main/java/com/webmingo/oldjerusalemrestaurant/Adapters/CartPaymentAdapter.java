package com.webmingo.oldjerusalemrestaurant.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.CardPayentRepo;
import com.webmingo.oldjerusalemrestaurant.R;

public class CartPaymentAdapter extends RecyclerView.Adapter<CartPaymentAdapter.myViewHolder> {

    CardPayentRepo modelArrayList;
    Context context;
    private CartPaymentClick itemClickListenerr;
    String firstFourChars,lastfourchar;

    public CartPaymentAdapter(CardPayentRepo modelArrayList, Context context, CartPaymentClick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_cardpayment_layout, parent, false);


        return new CartPaymentAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {



        if (modelArrayList.getData().getCards().getData().get(position).getCardNumber().length() > 4)
        {
            firstFourChars = modelArrayList.getData().getCards().getData().get(position).getCardNumber().substring(0, 4);
            lastfourchar = modelArrayList.getData().getCards().getData().get(position).getCardNumber().substring(modelArrayList.getData().getCards().getData().get(position).getCardNumber().length() -4);
            holder.address.setText(firstFourChars+"********"+lastfourchar);

        }

      /*  holder.tvSend.setText(modelArrayList.getData().getCategories().get(position).getName());
        Picasso.get().load(modelArrayList.getData().getCategories().get(position).getImage()).into(holder.ivimageone);

        holder.clickRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.CartPaymentClickk(modelArrayList,position);
            }
        });*/
        holder.EditTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.EditCartPaymentClickk(modelArrayList, position);
            }
        });
        holder.removeTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.RemoveCartPaymentClickk(modelArrayList, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getCards().getData().size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {


        TextView address, EditTV, removeTV;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            address = itemView.findViewById(R.id.address);
            EditTV = itemView.findViewById(R.id.EditTV);
            removeTV = itemView.findViewById(R.id.removeTV);

        }
    }

    public interface CartPaymentClick {
        void EditCartPaymentClickk(CardPayentRepo repo, int pos);

        void RemoveCartPaymentClickk(CardPayentRepo repo, int pos);

    }
}
