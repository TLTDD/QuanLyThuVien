package com.example.quanlythuvien.Activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanlythuvien.Activity.Model.KeSach;
import com.example.quanlythuvien.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class KeSachAdapter extends BaseAdapter {
    ArrayList<KeSach> arrayListKeSach;
    Context context;

    public KeSachAdapter(ArrayList<KeSach> arrayListKeSach, Context context) {
        this.arrayListKeSach = arrayListKeSach;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListKeSach.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListKeSach.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        TextView tvTenKeSach,tvSoSach;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder= null;
        if(convertView ==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_kesach,null);
            viewHolder.tvTenKeSach = convertView.findViewById(R.id.tvTenKeSach);
            viewHolder.tvSoSach = convertView.findViewById(R.id.tvSoSach);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        KeSach kesach = (KeSach) getItem(position);
        viewHolder.tvTenKeSach.setText(kesach.getTenKeSach());
        return convertView;
    }
}
