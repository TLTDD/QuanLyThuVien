package com.example.quanlythuvien.Activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlythuvien.Activity.Model.BanDoc;
import com.example.quanlythuvien.Activity.Model.PhieuMuon;
import com.example.quanlythuvien.R;

import java.util.ArrayList;

public class PhieuMuonAdapter extends BaseAdapter {
    ArrayList<PhieuMuon> arrayListPhieuMuon;
    Context context;

    public PhieuMuonAdapter(ArrayList<PhieuMuon> arrayListPhieuMuon, Context context) {
        this.arrayListPhieuMuon = arrayListPhieuMuon;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListPhieuMuon.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListPhieuMuon.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        TextView tvTenSachMuon,tvNguoiMuon,tvMSVMuon,tvNgayMuon,tvNgayTra,tvTinhTrang;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder= null;
        if(convertView ==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_phieumuon,null);
            viewHolder.tvTenSachMuon = convertView.findViewById(R.id.tvTenSachMuon);
            viewHolder.tvNguoiMuon = convertView.findViewById(R.id.tvNguoiMuon);
            viewHolder.tvMSVMuon = convertView.findViewById(R.id.tvMSVMuon);
            viewHolder.tvNgayMuon = convertView.findViewById(R.id.tvNgayMuon);
            viewHolder.tvNgayTra = convertView.findViewById(R.id.tvNgayTra);
            viewHolder.tvTinhTrang = convertView.findViewById(R.id.tvTinhTrang);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        PhieuMuon phieumuon = (PhieuMuon) getItem(position);
        viewHolder.tvTenSachMuon.setText(phieumuon.getTenSach());
        viewHolder.tvNguoiMuon.setText(phieumuon.getHoTen());
        viewHolder.tvMSVMuon.setText(phieumuon.getMaSV());
        viewHolder.tvNgayMuon.setText(phieumuon.getNgayMuon());
        viewHolder.tvNgayTra.setText(phieumuon.getNgayHetHan());
        viewHolder.tvTinhTrang.setText(phieumuon.getTrangThai());
        return convertView;
    }
}
