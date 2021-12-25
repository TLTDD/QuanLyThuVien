package com.example.quanlythuvien.Activity.Adapter;

import static android.app.Activity.RESULT_OK;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.quanlythuvien.Activity.Activity.Chitietphieumuon;
import com.example.quanlythuvien.Activity.Fragment.MuonFragment;
import com.example.quanlythuvien.Activity.Model.BanDoc;
import com.example.quanlythuvien.Activity.Model.PhieuMuon;
import com.example.quanlythuvien.R;

import java.util.ArrayList;

public class PhieuMuonAdapter extends BaseAdapter {
    ArrayList<PhieuMuon> arrayListPhieuMuon;
    MuonFragment context;

    public PhieuMuonAdapter(ArrayList<PhieuMuon> arrayListPhieuMuon, MuonFragment context) {
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
        public TextView tvTenSachMuon,tvNguoiMuon,tvMSVMuon,tvNgayMuon,tvNgayTra,tvTinhTrang, btnTraSach;
        ImageView btnDelete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder= null;
        if(convertView ==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_phieumuon,null);
            viewHolder.tvTenSachMuon = convertView.findViewById(R.id.tvTenSachMuon);
            viewHolder.tvNguoiMuon = convertView.findViewById(R.id.tvNguoiMuon);
            viewHolder.tvMSVMuon = convertView.findViewById(R.id.tvMSVMuon);
            viewHolder.tvNgayMuon = convertView.findViewById(R.id.tvNgayMuon);
            viewHolder.tvNgayTra = convertView.findViewById(R.id.tvNgayTra);
            viewHolder.tvTinhTrang = convertView.findViewById(R.id.tvTinhTrang);
            //viewHolder.btnDelete = convertView.findViewById(R.id.btndeletePhieuMuon);
            viewHolder.btnTraSach = convertView.findViewById(R.id.btnTraSach);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final PhieuMuon phieumuon = (PhieuMuon) getItem(position);
        viewHolder.tvTenSachMuon.setText(phieumuon.getTenSach());
        viewHolder.tvNguoiMuon.setText(phieumuon.getHoTen());
        viewHolder.tvMSVMuon.setText(phieumuon.getMaSV());
        viewHolder.tvNgayMuon.setText(phieumuon.getNgayMuon());
        viewHolder.tvNgayTra.setText(phieumuon.getNgayHetHan());
        viewHolder.tvTinhTrang.setText(phieumuon.getTrangThai());
        if(phieumuon.getTrangThai().equals("Đã trả")){
            viewHolder.btnTraSach.setEnabled(false);
            viewHolder.btnTraSach.setBackgroundColor(Color.parseColor("#c1c1c1"));
        }
//        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                XacNhanXoa(phieumuon.getHoTen(),phieumuon.getMaSach());
//            }
//        });
        viewHolder.btnTraSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XacNhanTraSach(phieumuon.getHoTen(),phieumuon.getMaSach());
            }
        });
        return convertView;
    }

//    private void XacNhanXoa(String ten,final String maSach){
//        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(context.getActivity());
//        dialogXoa.setMessage("Bạn có muốn xóa "+ten+" không?");
//        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                context.DeletePhieuMuon(maSach);
//            }
//        });
//        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//        dialogXoa.show();
//    }

    private void XacNhanTraSach(String ten,final String maSach){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(context.getActivity());
        dialogXoa.setMessage("Bạn có muốn xác nhận "+ten+" trả sách không?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.UpdatePhieuMuon(maSach);
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
