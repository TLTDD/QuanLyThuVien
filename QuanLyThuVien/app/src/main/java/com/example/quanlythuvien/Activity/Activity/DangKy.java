package com.example.quanlythuvien.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.quanlythuvien.R;

public class DangKy extends AppCompatActivity {
    private Button btnBack;
    private EditText etTaiKhoan, etName,etPassword,edtEmail,etAgainEmail;
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
        etTaiKhoan = findViewById(R.id.edtTaiKhoan);
        etName = findViewById(R.id.edtTenSv);
        edtEmail = findViewById(R.id.edtEmail);
    }
}