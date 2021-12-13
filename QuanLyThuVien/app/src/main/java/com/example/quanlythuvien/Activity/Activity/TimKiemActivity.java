package com.example.quanlythuvien.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.quanlythuvien.R;

public class TimKiemActivity extends AppCompatActivity {
    private LinearLayout lnHome,lnISBN,lnTaiKhoan;
    private Toolbar tbTimKiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);
        AnhXa();
        OnClickMenu();
        ActionBar();
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
    }
}