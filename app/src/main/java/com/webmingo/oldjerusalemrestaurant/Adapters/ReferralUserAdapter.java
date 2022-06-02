package com.webmingo.oldjerusalemrestaurant.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webmingo.oldjerusalemrestaurant.ModelRepo.Responsee.ReferredUserListingRepo;
import com.webmingo.oldjerusalemrestaurant.R;


public class ReferralUserAdapter extends RecyclerView.Adapter<ReferralUserAdapter.myViewHolder> {

    ReferredUserListingRepo modelArrayList;
    Context context;
    //  private CheckBoxListener itemClickListenerr;

   /* public ReferralUserAdapter(ReferredUserListingRepo modelArrayList, Context context, CheckBoxListener itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }
*/
 /*  public ReferralUserAdapter(Context context) {
       this.context = context;
   }*/

    public ReferralUserAdapter(ReferredUserListingRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.referraluseradapter, parent, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.UserIdTV.setText("User Id: " + modelArrayList.getData().getUsers().get(position).getUsername());
        holder.nameTV.setText("Name: " + modelArrayList.getData().getUsers().get(position).getName());
        holder.emailTv.setText("Email:  " + modelArrayList.getData().getUsers().get(position).getEmail());
        holder.numberTV.setText("Mobile Number:  " + modelArrayList.getData().getUsers().get(position).getMobileNumber());


    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().getUsers().size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView UserIdTV, nameTV, numberTV, emailTv;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            UserIdTV = itemView.findViewById(R.id.UserIdTV);
            nameTV = itemView.findViewById(R.id.nameTV);
            numberTV = itemView.findViewById(R.id.numberTV);

            emailTv = itemView.findViewById(R.id.emailTv);
        }
    }

  /*  public interface CheckBoxListener {

        void CheckedClick(String id, int position, Boolean bb);


    }*/
}
