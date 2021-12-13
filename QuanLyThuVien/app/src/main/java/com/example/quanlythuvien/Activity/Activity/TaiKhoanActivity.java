package com.example.quanlythuvien.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.quanlythuvien.R;

public class TaiKhoanActivity extends AppCompatActivity {
    private LinearLayout lnHome,lnSearch,lnISBN;
    private Toolbar tbTaiKhoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_khoan);
        AnhXa();
        OnClickMenu();
        ActionBar();
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
    }
}