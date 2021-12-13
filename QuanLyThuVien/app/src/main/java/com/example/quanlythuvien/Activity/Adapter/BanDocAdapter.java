package com.example.quanlythuvien.Activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlythuvien.Activity.Model.BanDoc;
import com.example.quanlythuvien.Activity.Model.KeSach;
import com.example.quanlythuvien.R;

import java.util.ArrayList;

public class BanDocAdapter extends BaseAdapter {
    ArrayList<BanDoc> arrayListBanDoc;
    Context context;

    public BanDocAdapter(ArrayList<BanDoc> arrayListBanDoc, Context context) {
        this.arrayListBanDoc = arrayListBanDoc;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListBanDoc.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListBanDoc.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        TextView tvTenSV,tvMSV;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder= null;
        if(convertView ==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_bandoc,null);
            viewHolder.tvTenSV = convertView.findViewById(R.id.tvTenSV);
            viewHolder.tvMSV = convertView.findViewById(R.id.tvMSV);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        BanDoc bandoc = (BanDoc) getItem(position);
        viewHolder.tvTenSV.setText(bandoc.getHoTen());
        viewHolder.tvMSV.setText(bandoc.getMaSV());
        return convertView;
    }
}
