package com.example.finalapptft.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.finalapptft.Object.Champ;
import com.example.finalapptft.OnItemClickListener;
import com.example.finalapptft.R;

import java.util.List;

public class AdapterRv3 extends RecyclerView.Adapter<AdapterRv3.ViewHolde> {
    private List<Champ> champs;
    private OnItemClickListener listener;
    private Context mContext;


    public AdapterRv3(Context context, List<Champ> champs, OnItemClickListener listener) {
        mContext = context;
        this.champs = champs;
        this.listener = listener;

    }

    public AdapterRv3(Context context, List<Champ> champs, int thamso) {
        mContext = context;
        this.champs = champs;

    }

    @NonNull
    @Override
    public ViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_img2, parent, false);

        return new ViewHolde(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolde holder, int position) {

        final Champ champ = champs.get(position);
        if (champ.getNameChamp().equals("") == false) {
            Glide.with(mContext).load(champ.getLinkChamp()).into(holder.img2);
            holder.relativeLayout2.setBackgroundColor(Color.parseColor(champ.color()));
            holder.img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickListenerRemove(champ);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return champs.size();
    }

    public class ViewHolde extends RecyclerView.ViewHolder {
        RelativeLayout relativeLayout2;
        ImageView img2;
        public ViewHolde(@NonNull View itemView) {
            super(itemView);
            img2 = itemView.findViewById(R.id.img_img2);
            relativeLayout2 = itemView.findViewById(R.id.layout_ab2);
        }
    }
}
