package com.example.quanlythuvien.Activity.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.quanlythuvien.Activity.Model.Sach;
import com.example.quanlythuvien.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class ThongTinFragment extends Fragment {
    View view;
    private ImageView imgSach;
    private TextView tvTenSach,tvTacGia,tvNXB,tvSeries,tvNSX,tvNgonNgu,tvGiaSach,tvLoiTua;
    int id=0;
    int idKeSach = 0;
    String tenSach = "";
    String tenTacGia = "";
    String nhaXuatBan = "";
    String ngayXuatBan = "";
    String ngonNgu = "";
    int giaSach = 0;
    String soSeries = "";
    Integer soLuong = 0;
    String loiTua = "";
    String hinhAnhSach = "";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thongtinsach,container,false);
        AnhXa();
        GetDuLieu();
        return view;
    }

    private void GetDuLieu() {
        Sach sach = (Sach) getActivity().getIntent().getSerializableExtra("thongtinsach");
        id = sach.getId();
        idKeSach = sach.getIdKeSach();
        tenSach = sach.getTenSach();
        tenTacGia = sach.getTenTacGia();
        nhaXuatBan = sach.getNhaXuatBan();
        ngayXuatBan = sach.getNgayXuatBan();
        ngonNgu = sach.getNgonNgu();
        giaSach = sach.getGiaSach();
        soSeries = sach.getSoSeries();
        soLuong = sach.getSoLuong();
        loiTua = sach.getLoiTua();
        hinhAnhSach = sach.getHinhAnhSach();

        tvTenSach.setText(tenSach);
        tvTacGia.setText(tenTacGia);
        tvNXB.setText(nhaXuatBan);
        tvNSX.setText(ngayXuatBan);
        tvNgonNgu.setText(ngonNgu);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        tvGiaSach.setText(""+decimalFormat.format(giaSach) + " VNĐ");
        Log.e("gia",giaSach+"");
        tvSeries.setText(soSeries);
        tenTacGia = sach.tenTacGia;
        Picasso.get().load(hinhAnhSach)
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(imgSach);
        tvLoiTua.setText(loiTua);
    }

    private void AnhXa() {
        imgSach = view.findViewById(R.id.imgSachTT);
        tvTenSach = view.findViewById(R.id.tvTenSachTT);
        tvTacGia = view.findViewById(R.id.tvTacGiaTT);
        tvNXB = view.findViewById(R.id.tvNXBTT);
        tvSeries = view.findViewById(R.id.tvSeriesTT);
        tvNSX = view.findViewById(R.id.tvNSXTT);
        tvNgonNgu = view.findViewById(R.id.tvNgonNguTT);
        tvGiaSach = view.findViewById(R.id.tvGiaSachTT);
        tvLoiTua = view.findViewById(R.id.tvLoiTuaTT);
    }
}
