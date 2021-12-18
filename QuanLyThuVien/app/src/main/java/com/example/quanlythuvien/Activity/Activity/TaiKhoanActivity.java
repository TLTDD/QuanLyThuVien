package com.example.quanlythuvien.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.quanlythuvien.Activity.Util.Server;
import com.example.quanlythuvien.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TaiKhoanActivity extends AppCompatActivity {
    private LinearLayout lnHome,lnSearch,lnISBN;
    private Toolbar tbTaiKhoan;
    private Button btnttk,btndmm,btndx;
    TextView txtTaiKhoan, txtTen;
    int idUser;
    String taikhoan = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_khoan);
        AnhXa();
        OnClickMenu();
        ActionBar();
        taikhoan = LoginActivity.taiKhoanDN.trim();
        readJson(Server.Duongdanthuthu+taikhoan);
        btnttk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ThongTinTaiKhoan.class);
                startActivity(intent);
            }
        });
        btndmm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DoiMatKhau.class);
                startActivity(intent);
            }
        });
        btndx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void ActionBar() {
        setSupportActionBar(tbTaiKhoan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbTaiKhoan.setNavigationIcon(R.drawable.ic_return);
        tbTaiKhoan.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void readJson(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            JSONObject jsonObject = response.getJSONObject(0);
                            idUser = jsonObject.getInt("id");
                            txtTen.setText(jsonObject.getString("name"));
                            txtTaiKhoan.setText(jsonObject.getString("taiKhoan"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();

                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }

    private void OnClickMenu() {
        lnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        lnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TimKiemActivity.class);
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
    }

    private void AnhXa() {
        lnHome = findViewById(R.id.ln_home);
        lnSearch = findViewById(R.id.ln_search);
        lnISBN = findViewById(R.id.ln_isbn);
        tbTaiKhoan = findViewById(R.id.tbTaiKhoan);
        txtTen = findViewById(R.id.tvTenThuThu);
        txtTaiKhoan = findViewById(R.id.tvTaiKhoan);
        btnttk = findViewById(R.id.btnthongtintk);
        btndmm = findViewById(R.id.btndoimatkhau);
        btndx = findViewById(R.id.btnDangXuat);
    }
}