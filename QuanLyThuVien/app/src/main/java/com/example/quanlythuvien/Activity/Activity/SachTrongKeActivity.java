package com.example.quanlythuvien.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.quanlythuvien.Activity.Adapter.SachAdapter;
import com.example.quanlythuvien.Activity.Model.Sach;
import com.example.quanlythuvien.Activity.Util.CheckConnection;
import com.example.quanlythuvien.Activity.Util.Server;
import com.example.quanlythuvien.R;

import androidx.appcompat.widget.Toolbar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SachTrongKeActivity extends AppCompatActivity {
    private RecyclerView recyclerViewSach;
    ArrayList<Sach> arrayListSach;
    SachAdapter sachAdapter;
    Toolbar tbSach;
    String idKe="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach_trong_ke);
        AnhXa();
        ActionBar();
        GetIdKeSach();
        GetDuLieuSach(idKe);
    }

    private void ActionBar() {
        setSupportActionBar(tbSach);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbSach.setNavigationIcon(R.drawable.ic_return);
        tbSach.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void GetIdKeSach() {
        idKe = getIntent().getStringExtra("idKeSach");
        Log.d("idKeSach",idKe+"");
    }

    private void GetDuLieuSach(String Ke) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongdan = Server.Duongdansachtheoke+String.valueOf(Ke);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(duongdan, new Response.Listener<JSONArray>() {
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
                CheckConnection.ShowToast_Short(getApplicationContext(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void AnhXa() {
        recyclerViewSach = findViewById(R.id.recyclerViewSachKe);
        arrayListSach = new ArrayList<>();
        sachAdapter = new SachAdapter(getApplicationContext(),arrayListSach);
        recyclerViewSach.setHasFixedSize(true);
        recyclerViewSach.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerViewSach.setAdapter(sachAdapter);
        tbSach = findViewById(R.id.tbSachTrongKe);
    }
}