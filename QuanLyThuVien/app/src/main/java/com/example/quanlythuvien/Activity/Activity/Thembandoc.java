package com.example.quanlythuvien.Activity.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
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
import com.example.quanlythuvien.Activity.Fragment.BanDocFragment;
import com.example.quanlythuvien.Activity.Util.Server;
import com.example.quanlythuvien.R;

import java.util.HashMap;
import java.util.Map;

public class Thembandoc extends AppCompatActivity {
    EditText edtHoTenBD,edtMaSVBD,edtLop,edtNgaySinh,edtGioiTinh,edtDiaChi,edtSoDienThoai,edtEmail;
    Button btnThemBanDoc;
    Toolbar tbThemBanDoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thembandoc);
        AnhXa();
        ActionBar();
        setActionButton();
    }

    private void setActionButton() {

        btnThemBanDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edtHoTenBD.getText().toString().trim().isEmpty()
                        ||edtMaSVBD.getText().toString().trim().isEmpty()
                        ||edtLop.getText().toString().trim().isEmpty()
                        ||edtNgaySinh.getText().toString().trim().isEmpty()
                        ||edtGioiTinh.getText().toString().trim().isEmpty()
                        ||edtDiaChi.getText().toString().trim().isEmpty()
                        ||edtSoDienThoai.getText().toString().trim().isEmpty()
                        ||edtEmail.getText().toString().trim().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Bạn phải điền đầy đủ thông tin !", Toast.LENGTH_SHORT).show();
                }
                else {
                    AddBanDoc();
                    finish();
                }
            }
        });
    }

    private void AddBanDoc(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdanthembandoc, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.contains("success")){
                    Toast.makeText(getApplicationContext(), "Đã thêm bạn đọc mới !", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
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
                param.put("hoTen",edtHoTenBD.getText().toString().trim());
                param.put("maSV",edtMaSVBD.getText().toString().trim());
                param.put("lop",edtLop.getText().toString().trim());
                param.put("ngaySinh",edtNgaySinh.getText().toString().trim());
                param.put("gioiTinh",edtGioiTinh.getText().toString().trim());
                param.put("diaChi",edtDiaChi.getText().toString().trim());
                param.put("soDienThoai",edtSoDienThoai.getText().toString().trim());
                param.put("email",edtEmail.getText().toString().trim());
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void ActionBar() {
        setSupportActionBar(tbThemBanDoc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbThemBanDoc.setNavigationIcon(R.drawable.ic_return);
        tbThemBanDoc.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void AnhXa() {
        btnThemBanDoc = findViewById(R.id.btnThemBanDoc);
        tbThemBanDoc = findViewById(R.id.tbThemBanDoc);
        edtHoTenBD = findViewById(R.id.edtHoTenBD);
        edtMaSVBD = findViewById(R.id.edtMaSVBD);
        edtLop = findViewById(R.id.edtLop);
        edtNgaySinh = findViewById(R.id.edtNgaySinh);
        edtGioiTinh = findViewById(R.id.edtGioiTinh);
        edtDiaChi = findViewById(R.id.edtDiaChi);
        edtSoDienThoai = findViewById(R.id.edtSoDienThoai);
        edtEmail = findViewById(R.id.edtEmail);
    }
}