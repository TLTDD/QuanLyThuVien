package com.example.quanlythuvien.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.quanlythuvien.Activity.Adapter.BanDocAcAdapter;
import com.example.quanlythuvien.Activity.Adapter.BanDocAdapter;
import com.example.quanlythuvien.Activity.Model.BanDoc;
import com.example.quanlythuvien.Activity.Util.CheckConnection;
import com.example.quanlythuvien.Activity.Util.Server;
import com.example.quanlythuvien.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BanDocActivity extends AppCompatActivity {
    private ListView lvBanDoc;
    private BanDocAcAdapter banDocAdapter;
    private ArrayList<BanDoc> arrayListBanDoc;
    private int id=0;
    private String HoTen="";
    private String MSV="";
    private String Lop="";
    private String NgaySinh="";
    private String GioiTinh="";
    private String DiaChi="";
    private String SDT="";
    private String Email="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban_doc);
        AnhXa();
        GetDuLieuLoaiSP();
    }

    private void GetDuLieuLoaiSP() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdanbandoc, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if (response != null){

                    for (int i = 0;i < response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            HoTen = jsonObject.getString("hoTen");
                            MSV = jsonObject.getString("maSV");
                            Lop = jsonObject.getString("lop");
                            NgaySinh = jsonObject.getString("ngaySinh");
                            GioiTinh = jsonObject.getString("gioiTinh");
                            DiaChi = jsonObject.getString("diaChi");
                            SDT = jsonObject.getString("soDienThoai");
                            Email = jsonObject.getString("email");
                            arrayListBanDoc.add(new BanDoc(id,HoTen,MSV,Lop,NgaySinh,GioiTinh,DiaChi,SDT,Email));
                            banDocAdapter.notifyDataSetChanged();
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
        lvBanDoc.setAdapter(banDocAdapter);
    }

    private void AnhXa() {
        lvBanDoc = findViewById(R.id.lvBanDocAc);
        arrayListBanDoc = new ArrayList<>();
        banDocAdapter = new BanDocAcAdapter(arrayListBanDoc, BanDocActivity.this);
    }
}