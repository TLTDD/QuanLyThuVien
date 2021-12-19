package com.example.quanlythuvien.Activity.Adapter;

import static android.app.Activity.RESULT_OK;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.example.quanlythuvien.Activity.Activity.Chitietphieumuon;
import com.example.quanlythuvien.Activity.Fragment.BanDocFragment;
import com.example.quanlythuvien.Activity.Model.BanDoc;
import com.example.quanlythuvien.Activity.Model.KeSach;
import com.example.quanlythuvien.Activity.Model.PhieuMuon;
import com.example.quanlythuvien.R;

import java.util.ArrayList;

public class BanDocAdapter extends BaseAdapter {
    private ArrayList<BanDoc> arrayListBanDoc;
     BanDocFragment context;

    public BanDocAdapter(ArrayList<BanDoc> arrayListBanDoc, BanDocFragment context) {
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
        public TextView tvTenSV,tvMSV;
        public ImageView btnXoaBD;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder= null;
        if(convertView ==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_bandoc,null);
            viewHolder.tvTenSV = convertView.findViewById(R.id.tvTenSV);
            viewHolder.tvMSV = convertView.findViewById(R.id.tvMSV);
            viewHolder.btnXoaBD = convertView.findViewById(R.id.btndeleteBanDoc);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        BanDoc bandoc = (BanDoc) getItem(position);
        viewHolder.tvTenSV.setText(bandoc.getHoTen());
        viewHolder.tvMSV.setText(bandoc.getMaSV());
        viewHolder.btnXoaBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XacNhanXoa(bandoc.getHoTen(), bandoc.getId());
            }
        });
        return convertView;
    }

    private void XacNhanXoa(String ten,final int id){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(context.getActivity());
        dialogXoa.setMessage("Bạn có muốn xóa bạn đọc "+ten+" không?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.DeleteBanDoc(id);
            }
        });
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogXoa.show();
    }
}
