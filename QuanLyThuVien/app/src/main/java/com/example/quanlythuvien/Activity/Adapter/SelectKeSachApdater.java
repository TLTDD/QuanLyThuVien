package com.example.quanlythuvien.Activity.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quanlythuvien.Activity.Activity.ThemSach;
import com.example.quanlythuvien.Activity.Model.KeSach;
import com.example.quanlythuvien.Activity.Util.CheckConnection;
import com.example.quanlythuvien.R;

import java.util.List;

public class SelectKeSachApdater extends ArrayAdapter<KeSach> {
    public SelectKeSachApdater(@NonNull Context context, int resource, @NonNull List<KeSach> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selected,parent,false);
        TextView tvSeleted = convertView.findViewById(R.id.tv_tenkesach);
        KeSach keSach = this.getItem(position);
        if(keSach!=null){
            tvSeleted.setText(keSach.getTenKeSach());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tenkesach,parent,false);
        TextView tvKeSach = convertView.findViewById(R.id.tv_tenkesach);

        KeSach keSach = this.getItem(position);
        if(keSach!=null){
            tvKeSach.setText(keSach.getTenKeSach());
        }
        return convertView;
    }
}
