package com.example.finalapptft.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.finalapptft.Object.Activated;
import com.example.finalapptft.R;

import java.util.List;

public class AdapterDetailsOrigin_Class extends ArrayAdapter<Activated> {
    public AdapterDetailsOrigin_Class(@NonNull Context context, int resource, @NonNull List<Activated> objects) {
        super(context, resource, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Activated activated =getItem(position);
        AdapterDetailsOrigin_Class.ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activeamount_listview, parent, false);
            viewHolder = new AdapterDetailsOrigin_Class.ViewHolder();
            viewHolder.textView1 = (TextView) convertView.findViewById(R.id.amont_active);
            viewHolder.textView2 = (TextView) convertView.findViewById(R.id.content_active);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (AdapterDetailsOrigin_Class.ViewHolder) convertView.getTag();
        }
        viewHolder.textView1.setText(activated.getAmount()+"");
        viewHolder.textView2.setText(activated.getContent());
        return convertView;
    }

    public class ViewHolder {
        TextView textView1;
        TextView textView2;
    }
}
