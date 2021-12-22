package com.example.quanlythuvien.Activity.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;

import com.example.quanlythuvien.Activity.Activity.ThemSach;
import com.example.quanlythuvien.Activity.Fragment.KeSachFragment;
import com.example.quanlythuvien.Activity.Model.KeSach;
import com.example.quanlythuvien.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class KeSachAdapter1 extends BaseAdapter {
    ArrayList<KeSach> arrayListKeSach;
    Context context;

    public KeSachAdapter1(ArrayList<KeSach> arrayListKeSach, Context context) {
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
        TextView tvTenKeSach;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder= null;
        if(convertView ==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_selected,null);
            viewHolder.tvTenKeSach = convertView.findViewById(R.id.tvSelected);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        KeSach kesach = (KeSach) getItem(position);


        viewHolder.tvTenKeSach.setText(kesach.getTenKeSach());
        ThemSach.b = kesach.getTenKeSach();
        return convertView;
    }


}
