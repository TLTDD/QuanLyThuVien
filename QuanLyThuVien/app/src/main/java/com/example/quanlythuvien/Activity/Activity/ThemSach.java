package com.example.quanlythuvien.Activity.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.quanlythuvien.Activity.Util.Server;
import com.example.quanlythuvien.R;

import java.util.HashMap;
import java.util.Map;

public class ThemSach extends AppCompatActivity {
    EditText edtIdKeSach,edtTenSach,edtTacGia,edtNXB,edtNgayXB,edtNgonNgu,edtgiaSach,edtSoSeries,edtSoLuong,edtLoiTua,edtHinhAnhSach;
    Button btnThemSach;
    Toolbar tbThemSach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themsach);
        AnhXa();
        ActionBar();
        setActionButton();
    }

    private void setActionButton() {
        btnThemSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtIdKeSach.getText().toString().trim().isEmpty()
                ||edtTenSach.getText().toString().trim().isEmpty()
                ||edtTacGia.getText().toString().trim().isEmpty()
                ||edtNXB.getText().toString().trim().isEmpty()
                ||edtNgayXB.getText().toString().trim().isEmpty()
                ||edtNgonNgu.getText().toString().trim().isEmpty()
                ||edtgiaSach.getText().toString().trim().isEmpty()
                ||edtSoSeries.getText().toString().trim().isEmpty()
                ||edtSoLuong.getText().toString().trim().isEmpty()
                ||edtLoiTua.getText().toString().trim().isEmpty()
                ||edtHinhAnhSach.getText().toString().trim().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Bạn phải điền đầy đủ thông tin !", Toast.LENGTH_SHORT).show();
                }
                else {
                    AddSach();
                    finish();
                }

            }
        });
    }
    private void AddSach(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdanthemsach, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.contains("success")){
                    Toast.makeText(getApplicationContext(), "Đã thêm sách mới !", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Xảy ra lỗi chèn!", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Xảy ra lỗi !", Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("idKeSach",edtIdKeSach.getText().toString().trim());
                param.put("tenSach",edtTenSach.getText().toString().trim());
                param.put("tenTacGia",edtTacGia.getText().toString().trim());
                param.put("nhaXuatBan",edtNXB.getText().toString().trim());
                param.put("ngayXuatBan",edtNgayXB.getText().toString().trim());
                param.put("ngonNgu",edtNgonNgu.getText().toString().trim());
                param.put("giaSach",edtgiaSach.getText().toString().trim());
                param.put("soSeries",edtSoSeries.getText().toString().trim());
                param.put("soLuong",edtSoLuong.getText().toString().trim());
                param.put("loiTua",edtLoiTua.getText().toString().trim());
                param.put("hinhAnhSach",edtHinhAnhSach.getText().toString().trim());
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void ActionBar() {
        setSupportActionBar(tbThemSach);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbThemSach.setNavigationIcon(R.drawable.ic_return);
        tbThemSach.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void AnhXa() {
        btnThemSach = findViewById(R.id.btnMucThemSach);
        tbThemSach = findViewById(R.id.tbThemSach);
        edtIdKeSach = findViewById(R.id.edtIdKeSach);
        edtTenSach = findViewById(R.id.edtTenSach);
        edtTacGia = findViewById(R.id.edtTacGia);
        edtNXB = findViewById(R.id.edtNXB);
        edtNgayXB = findViewById(R.id.edtNgayXB);
        edtNgonNgu = findViewById(R.id.edtNgonNgu);
        edtgiaSach = findViewById(R.id.edtgiaSach);
        edtSoSeries = findViewById(R.id.edtSoSeries);
        edtSoLuong = findViewById(R.id.edtSoLuong);
        edtLoiTua = findViewById(R.id.edtLoiTua);
        edtHinhAnhSach = findViewById(R.id.edtHinhAnhSach);
    }
}