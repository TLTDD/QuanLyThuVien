package com.example.quanlythuvien.Activity.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.quanlythuvien.Activity.Activity.ThemSach;
import com.example.quanlythuvien.Activity.Adapter.SachAdapter;
import com.example.quanlythuvien.Activity.Model.Sach;
import com.example.quanlythuvien.Activity.Util.CheckConnection;
import com.example.quanlythuvien.Activity.Util.Server;
import com.example.quanlythuvien.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SachFragment extends Fragment {
    View view;
    RecyclerView recyclerViewSach;
    ArrayList<Sach> arrayListSach;
    SachAdapter sachAdapter;
    FloatingActionButton btnThemSach;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sach,container,false);
        AnhXa();
        GetDuLieuSach();
        EventButton();
        return view;
    }

    private void EventButton() {
        btnThemSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ThemSach.class);
                startActivity(intent);
            }
        });
    }

    private void GetDuLieuSach() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdansach, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response!=null){
                    int id=0;
                    String idKeSach = "";
                    String tenSach = "";
                    String tenTacGia = "";
                    String nhaXuatBan = "";
                    String ngayXuatBan = "";
                    String ngonNgu = "";
                    Integer giaSach = 0;
                    String soSeries = "";
                    Integer soLuong = 0;
                    String loiTua = "";
                    String hinhAnhSach = "";
                    for (int i=0; i<response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            idKeSach = jsonObject.getString("tenKeSach");
                            tenSach = jsonObject.getString("tenSach");
                            tenTacGia = jsonObject.getString("tenTacGia");
                            nhaXuatBan = jsonObject.getString("nhaXuatBan");
                            ngayXuatBan = jsonObject.getString("ngayXuatBan");
                            ngonNgu = jsonObject.getString("ngonNgu");
                            giaSach = jsonObject.getInt("giaSach");
                            soSeries = jsonObject.getString("soSeries");
                            soLuong = jsonObject.getInt("soLuong");
                            loiTua = jsonObject.getString("loiTua");
                            hinhAnhSach = jsonObject.getString("hinhAnhSach");
                            arrayListSach.add(new Sach(id,idKeSach,tenSach,tenTacGia,nhaXuatBan,ngayXuatBan,ngonNgu,giaSach,soSeries,soLuong,loiTua,hinhAnhSach));
                            sachAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast_Short(getActivity(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void AnhXa() {
        recyclerViewSach = view.findViewById(R.id.recyclerViewSach);
        arrayListSach = new ArrayList<>();
        sachAdapter = new SachAdapter(getActivity(),arrayListSach);
        recyclerViewSach.setHasFixedSize(true);
        recyclerViewSach.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerViewSach.setAdapter(sachAdapter);
        btnThemSach = view.findViewById(R.id.btnThemSach);
    }
}
