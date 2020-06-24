package com.example.finalapptft.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalapptft.Object.CategoryChamp;
import com.example.finalapptft.OnItemClickListener;
import com.example.finalapptft.R;

import java.util.List;

public class AdapterFmtwo extends RecyclerView.Adapter<AdapterFmtwo.ViewHolde> {
    private List<CategoryChamp> categoryChamps;
    private Context mContext;
    private AdapterRv2 adapterRv2;
    private GridLayoutManager linearLayoutManager;
    private OnItemClickListener listener;

    public AdapterFmtwo(Context context, List<CategoryChamp> categoryChamps,OnItemClickListener listener) {
        mContext = context;
        this.categoryChamps = categoryChamps;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_rcv_item, parent, false);
        return new ViewHolde(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolde holder, int position) {
        CategoryChamp categoryChamp = categoryChamps.get(position);
        holder.textView.setText(categoryChamp.getSectionName());
        linearLayoutManager = new GridLayoutManager(mContext,5);
        adapterRv2 = new AdapterRv2(mContext, categoryChamp.getChamps(),listener, 2);
        holder.recyclerView.setAdapter(adapterRv2);
        holder.recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public int getItemCount() {
        return categoryChamps.size();
    }

    public class ViewHolde extends RecyclerView.ViewHolder {
        TextView textView;
        androidx.recyclerview.widget.RecyclerView recyclerView;

        public ViewHolde(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.name_section);
            ;
            recyclerView = itemView.findViewById(R.id.thuongngu);
        }


    }
}
