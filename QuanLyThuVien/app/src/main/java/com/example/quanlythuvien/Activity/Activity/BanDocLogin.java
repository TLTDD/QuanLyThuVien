package com.example.quanlythuvien.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;

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
import com.example.quanlythuvien.Activity.Util.Server;
import com.example.quanlythuvien.R;

import java.util.HashMap;
import java.util.Map;

public class BanDocLogin extends AppCompatActivity {
    private Button btndangnhap;
    private EditText etTaiKhoan,etPassword;
    private String taikhoan, password;
    public static String taiKhoanDN ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban_doc_login);
        AnhXa();
    }

    public void login(View view){
        taikhoan = etTaiKhoan.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        if(!taikhoan.equals("")&&!password.equals("")){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdandangnhapbd, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if(response.contains("success")){
                        Intent intent = new Intent(BanDocLogin.this, MainBanDoc.class);
                        taiKhoanDN = etTaiKhoan.getText().toString().trim();
                        intent.putExtra("taiKhoan",taiKhoanDN);
                        startActivity(intent);
                        finish();
                        Log.e("QB", "onResponse: " + response);
                    }else if(response.contains("failure")) {

                        Toast.makeText(BanDocLogin.this, "Nhập sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(BanDocLogin.this, "onResponse: " + response, Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(),error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("taiKhoan",taikhoan);
                    data.put("password",password);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        } else {
            Toast.makeText(BanDocLogin.this, "Field can not be empty!", Toast.LENGTH_SHORT).show();
        }
    }

    private void AnhXa() {
        btndangnhap = findViewById(R.id.btndangnhap);
        etTaiKhoan = findViewById(R.id.edtTaiKhoan);
        etPassword = findViewById(R.id.edtMatKhau);
    }
}