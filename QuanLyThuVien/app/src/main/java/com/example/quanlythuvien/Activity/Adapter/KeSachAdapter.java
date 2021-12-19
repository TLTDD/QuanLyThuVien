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

import com.example.quanlythuvien.Activity.Fragment.KeSachFragment;
import com.example.quanlythuvien.Activity.Model.KeSach;
import com.example.quanlythuvien.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class KeSachAdapter extends BaseAdapter {
    ArrayList<KeSach> arrayListKeSach;
    KeSachFragment context;

    public KeSachAdapter(ArrayList<KeSach> arrayListKeSach, KeSachFragment context) {
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
        ImageView btnDelete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder= null;
        if(convertView ==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_kesach,null);
            viewHolder.tvTenKeSach = convertView.findViewById(R.id.tvTenKeSach);
            viewHolder.btnDelete = convertView.findViewById(R.id.btndeleteKeSach);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        KeSach kesach = (KeSach) getItem(position);
        viewHolder.tvTenKeSach.setText(kesach.getTenKeSach());
        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XacNhanXoa(kesach.getTenKeSach(),kesach.getId());
            }
        });
        return convertView;
    }

    private void XacNhanXoa(String ten,final int id){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(context.getActivity());
        dialogXoa.setMessage("Bạn có muốn xóa "+ten+" không?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.DeleteKeSach(id);
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
