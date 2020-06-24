package com.example.finalapptft.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.finalapptft.Object.Champ;
import com.example.finalapptft.R;

import java.util.List;

public class AdapterFragmentItem extends ArrayAdapter<Champ> {


    public AdapterFragmentItem(@NonNull Context context, int resource, @NonNull List objects) {

        super(context, resource, objects);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Champ champ =getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_champ, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) convertView.findViewById(R.id.txv_name);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.img_item);
            viewHolder.relativeLayout = (RelativeLayout) convertView.findViewById(R.id.layoutFather);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(champ.getNameChamp());
        //viewHolder.imageView.setBackgroundColor(champ.getGold());
        viewHolder.imageView.setBackgroundColor(Color.parseColor("#0E202C"));
        Glide.with(getContext()).load(champ.getLinkChamp()).into(viewHolder.imageView);
        viewHolder.relativeLayout.setBackgroundColor(Color.parseColor(champ.color()));
        return convertView;
    }

    public class ViewHolder {
        TextView textView;
        ImageView imageView;
        RelativeLayout relativeLayout;
    }
}
