package com.example.finalapptft.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalapptft.Object.Activated;
import com.example.finalapptft.R;

import java.util.List;

public class AdapterRv1 extends RecyclerView.Adapter<AdapterRv1.ViewHolde> {
    private List<Activated> activateds;
    public AdapterRv1(List<Activated> activateds){
        this.activateds = activateds;
    }
    @NonNull
    @Override
    public ViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activeamount_listview,parent,false);
        return new ViewHolde(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolde holder, int position) {
        Activated activated = activateds.get(position);
        holder.amont.setText(activated.getAmount()+"");
        holder.active.setText(activated.getContent());
    }

    @Override
    public int getItemCount() {
        return activateds.size();
    }

    public class ViewHolde extends RecyclerView.ViewHolder {
        TextView amont;
        TextView active;
        public ViewHolde(@NonNull View itemView) {
            super(itemView);
            amont = itemView.findViewById(R.id.amont_active);
            active = itemView.findViewById(R.id.content_active);
        }
    }
}
