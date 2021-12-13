package com.example.quanlythuvien.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.quanlythuvien.R;

public class MaISBNActivity extends AppCompatActivity {
    private LinearLayout lnHome,lnSearch,lnTaiKhoan;
    private Toolbar tbISBN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_isbnactivity);
        AnhXa();
        OnClickMenu();
        ActionBar();
    }

    private void ActionBar() {
        setSupportActionBar(tbISBN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbISBN.setNavigationIcon(R.drawable.ic_return);
        tbISBN.setNavigationOnClickListener(new View.OnClickListener() {
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
        lnSearch = findViewById(R.id.ln_search);
        lnTaiKhoan = findViewById(R.id.ln_tk);
        tbISBN = findViewById(R.id.tbISBN);
    }
}