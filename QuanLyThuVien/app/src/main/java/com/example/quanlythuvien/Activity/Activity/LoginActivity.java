package com.example.quanlythuvien.Activity.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

public class LoginActivity extends AppCompatActivity {
    private Button btndangnhap,btndnbd;
    private EditText etTaiKhoan,etPassword;
    private String taikhoan, password;
    public static String taiKhoanDN ="";
    public static String taiKhoanDN1 ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AnhXa();
        btndnbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),BanDocLogin.class);
                startActivity(intent);
            }
        });
    }

    public void login(View view){
        taikhoan = etTaiKhoan.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        if(!taikhoan.equals("")&&!password.equals("")){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdandangnhap, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if(response.contains("success")){
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        taiKhoanDN = etTaiKhoan.getText().toString().trim();
                        intent.putExtra("taiKhoan",taiKhoanDN);
                        startActivity(intent);
                        finish();
                        Log.e("QB", "onResponse: " + response);
                    }else if(response.contains("failure")) {
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdandangnhapbd, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.contains("success")){
                                    Intent intent = new Intent(LoginActivity.this, MainBanDoc.class);
                                    taiKhoanDN1 = etTaiKhoan.getText().toString().trim();
                                    intent.putExtra("taiKhoan",taiKhoanDN1);
                                    startActivity(intent);
                                    finish();
                                    Log.e("QB", "onResponse: " + response);
                                }else if(response.contains("failure")) {

                                    Toast.makeText(LoginActivity.this, "Nh???p sai t??i kho???n ho???c m???t kh???u", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(LoginActivity.this, "onResponse: " + response, Toast.LENGTH_SHORT).show();
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
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "onResponse: " + response, Toast.LENGTH_SHORT).show();
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
            Toast.makeText(LoginActivity.this, "Field can not be empty!", Toast.LENGTH_SHORT).show();
        }
    }

    private void AnhXa() {
        btndangnhap = findViewById(R.id.btndangnhap);
        etTaiKhoan = findViewById(R.id.edtTaiKhoan);
        etPassword = findViewById(R.id.edtMatKhau);
        btndnbd = findViewById(R.id.btndangky);
    }
}