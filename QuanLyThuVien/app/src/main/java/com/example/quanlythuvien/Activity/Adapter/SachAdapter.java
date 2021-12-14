package com.example.quanlythuvien.Activity.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlythuvien.Activity.Activity.ChiTietSach;
import com.example.quanlythuvien.Activity.Model.Sach;
import com.example.quanlythuvien.Activity.Util.CheckConnection;
import com.example.quanlythuvien.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SachAdapter extends RecyclerView.Adapter<SachAdapter.ItemHolder> {
    Context context;
    ArrayList<Sach> arraySach;

    public SachAdapter(Context context, ArrayList<Sach> arraySach) {
        this.context = context;
        this.arraySach = arraySach;
    }

    public void filterList(ArrayList<Sach> filteredList) {
        arraySach = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sach,null);
        ItemHolder itemHolder = new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Sach sach = arraySach.get(position);
        holder.tvTenSach.setText(sach.getTenSach());
        holder.tvTacGia.setText(sach.getTenTacGia());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.tvGiaSach.setText("Giá: "+decimalFormat.format(sach.getGiaSach())+" Đ");
        Picasso.get().load(sach.getHinhAnhSach())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(holder.imgSach);
    }

    @Override
    public int getItemCount() {
        return arraySach.size();
    }


    public class ItemHolder extends RecyclerView.ViewHolder{
        public ImageView imgSach;
        public TextView tvTenSach,tvTacGia,tvGiaSach;

        public ItemHolder(View itemView) {
            super(itemView);
            imgSach = itemView.findViewById(R.id.imgSach);
            tvTenSach = itemView.findViewById(R.id.tvTenSach);
            tvTacGia = itemView.findViewById(R.id.tvTenTacGia);
            tvGiaSach = itemView.findViewById(R.id.tvGiaSach);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ChiTietSach.class);
                    intent.putExtra("thongtinsach",arraySach.get(getPosition()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    CheckConnection.ShowToast_Short(context,arraySach.get(getPosition()).getTenSach());
                    context.startActivity(intent);
                }
            });
        }
    }
}
