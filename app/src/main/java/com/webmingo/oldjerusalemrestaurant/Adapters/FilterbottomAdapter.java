package com.webmingo.oldjerusalemrestaurant.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webmingo.oldjerusalemrestaurant.Modal.Filtermodel;
import com.webmingo.oldjerusalemrestaurant.R;

import java.util.ArrayList;

public class FilterbottomAdapter extends RecyclerView.Adapter<FilterbottomAdapter.myViewHolder> {

    ArrayList<Filtermodel> arrayList;
    Context context;
    private CheckBoxListener itemClickListenerr;


    private static CheckBox lastChecked = null;
    private static int lastCheckedPos = 0;

    public FilterbottomAdapter(ArrayList<Filtermodel> arrayList, Context context,CheckBoxListener itemClickListenerr) {
        this.arrayList = arrayList;
        this.context = context;
        this.itemClickListenerr= itemClickListenerr;
    }
/*

    public FilterbottomAdapter(Context context) {

        this.context = context;
    }
*/

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.filteradapter, parent, false);

        return new FilterbottomAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.filter.setText(arrayList.get(position).getValue());

        //for default check in first item

      /*  if(position == 0 && arrayList.get(0).isSelected() && holder.checkBox.isChecked())
        {
            lastChecked = holder.checkBox;
            lastCheckedPos = 0;
        }*/

        holder.filter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                itemClickListenerr.CheckedClick(String.valueOf(arrayList.get(position).getKey()), position, isChecked);

                notifyDataSetChanged();

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();


    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        CheckBox filter;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            filter = itemView.findViewById(R.id.filter);

        }
    }

    public interface CheckBoxListener {

        void CheckedClick(String id, int position, Boolean bb);


    }
}
