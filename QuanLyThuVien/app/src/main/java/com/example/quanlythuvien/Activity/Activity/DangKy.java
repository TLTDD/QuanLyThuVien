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

public class DangKy extends AppCompatActivity {
    private Button btnBack, btnDangKy;
    private EditText etTaiKhoan, etName,etPassword,edtEmail,etAgainPass;
    private String name, taikhoan,password,reneterPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        AnhXa();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),BanDocLogin.class);
                startActivity(intent);
            }
        });
    }

    private void AnhXa()
    {
        btnBack = findViewById(R.id.btnBack);
        btnDangKy = findViewById(R.id.btndangky);
        etTaiKhoan = findViewById(R.id.edtTaiKhoan);
        etName = findViewById(R.id.edtTenSv);
        //edtEmail = findViewById(R.id.edtEmail);
        etPassword = findViewById(R.id.edtMatKhau);
        etAgainPass = findViewById(R.id.edtNhapLaiPass);
    }
    public void save(View view) {
        name =  etName.getText().toString().trim();
        taikhoan = etTaiKhoan.getText().toString().trim();
        password =  etPassword.getText().toString().trim();
        reneterPassword =  etAgainPass.getText().toString().trim();
        if(!password.equals(reneterPassword)){
            Toast.makeText(this, "Password Mismatch", Toast.LENGTH_SHORT).show();
        }
        else if (!name.equals("") && !taikhoan.equals("") && !password.equals("")){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Đuongdandangky, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e("QB", "onResponse: " + response);
                    if (response.contains("success")) {
                        etName.setText("");
                        etPassword.setText("");
                        etAgainPass.setText("");
                        //tvStatus.setText("Tạo tài khoản thành công!");
                        btnDangKy.setClickable(false);
                    } else if (response.contains("failure")) {
                        //tvStatus.setText("Email đã tồn tại");
                        //tvStatus.setTextColor(Color.parseColor("#950000"));
                        //etEmail.setTextColor(Color.parseColor("#950000"));
                        //etEmail.requestFocus();
                        //etEmail.requestFocus();
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
                    data.put("name",name);
                    data.put("taikhoan",taikhoan);
                    data.put("password",password);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }
}