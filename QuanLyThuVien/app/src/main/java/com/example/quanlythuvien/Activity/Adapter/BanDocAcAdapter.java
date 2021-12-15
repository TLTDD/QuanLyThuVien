package com.example.quanlythuvien.Activity.Adapter;

import static android.app.Activity.RESULT_OK;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.quanlythuvien.Activity.Activity.BanDocActivity;
import com.example.quanlythuvien.Activity.Activity.Chitietphieumuon;
import com.example.quanlythuvien.Activity.Model.BanDoc;
import com.example.quanlythuvien.R;

import java.util.ArrayList;

public class BanDocAcAdapter  extends BaseAdapter {
    private ArrayList<BanDoc> arrayListBanDoc;
    BanDocActivity context;

    public BanDocAcAdapter(ArrayList<BanDoc> arrayListBanDoc, BanDocActivity context) {
        this.arrayListBanDoc = arrayListBanDoc;
        this.context = context;
    }

    public class ViewHolder{
        public LinearLayout lnItemBandoc;
        public TextView tvTenSV,tvMSV;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder= null;
        if(convertView ==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_bandoc,null);
            viewHolder.tvTenSV = convertView.findViewById(R.id.tvTenSV);
            viewHolder.tvMSV = convertView.findViewById(R.id.tvMSV);
            viewHolder.lnItemBandoc = convertView.findViewById(R.id.ln_itemBanDoc);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        BanDoc bandoc = (BanDoc) getItem(position);
        viewHolder.tvTenSV.setText(bandoc.getHoTen());
        viewHolder.tvMSV.setText(bandoc.getMaSV());
        viewHolder.lnItemBandoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Chitietphieumuon.class);
                BanDoc bandoc = (BanDoc) getItem(position);
                intent.putExtra("BanDoc", bandoc);
                context.setResult(RESULT_OK,intent);
                context.finish();
            }
        });
        return convertView;
    }
}
