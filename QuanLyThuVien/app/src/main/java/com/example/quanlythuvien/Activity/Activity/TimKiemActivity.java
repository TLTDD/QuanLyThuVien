package com.example.quanlythuvien.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TimKiemActivity extends AppCompatActivity {
    private LinearLayout lnHome,lnISBN,lnTaiKhoan;
    private Toolbar tbTimKiem;
    RecyclerView recyclerViewSach;
    ArrayList<Sach> arrayListSach;
    SachAdapter sachAdapter;
    EditText edtSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);
        AnhXa();
        OnClickMenu();
        ActionBar();
        GetDuLieuSach();
        Search();
    }

    private void Search() {
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    private void filter(String text){
        ArrayList<Sach> filteredList = new ArrayList<>();
        for(Sach item: arrayListSach){
            if(item.getTenSach().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        sachAdapter.filterList(filteredList);
    }

    private void GetDuLieuSach() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdansach, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response!=null){
                    int id=0;
                    int idKeSach = 0;
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
                            idKeSach = jsonObject.getInt("idKeSach");
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

    private void ActionBar() {
        setSupportActionBar(tbTimKiem);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbTimKiem.setNavigationIcon(R.drawable.ic_return);
        tbTimKiem.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void OnClickMenu() {
        lnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        lnISBN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MaISBNActivity.class);
                startActivity(intent);
            }
        });
        lnTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TaiKhoanActivity.class);
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {
        lnHome = findViewById(R.id.ln_home);
        lnISBN = findViewById(R.id.ln_isbn);
        lnTaiKhoan = findViewById(R.id.ln_tk);
        tbTimKiem = findViewById(R.id.tbTimKiem);
        recyclerViewSach = findViewById(R.id.recyclerTimKiem);
        arrayListSach = new ArrayList<>();
        sachAdapter = new SachAdapter(getApplicationContext(),arrayListSach);
        recyclerViewSach.setHasFixedSize(true);
        recyclerViewSach.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerViewSach.setAdapter(sachAdapter);
        edtSearch = findViewById(R.id.edtTimKiem);
    }
}