package com.example.quanlythuvien.Activity.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.example.quanlythuvien.Activity.Adapter.ChiTietViewPagerAdapter;
import com.example.quanlythuvien.Activity.Adapter.MainViewPagerAdapter;
import com.example.quanlythuvien.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ChiTietSach extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;
    private ChiTietViewPagerAdapter chiTietViewPagerAdapter;
    private Toolbar tbChiTiet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_sach);
        AnhXa();
        TLayout();
        ActionBar();
    }

    private void ActionBar() {
        setSupportActionBar(tbChiTiet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbChiTiet.setNavigationIcon(R.drawable.ic_return);
        tbChiTiet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void TLayout() {
        new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Chi tiết");
                        break;
                }
            }
        }).attach();
    }

    private void AnhXa() {
        mTabLayout = findViewById(R.id.tabLayoutChiTiet);
        mViewPager2 = findViewById(R.id.viewPagerChiTiet);
        chiTietViewPagerAdapter = new ChiTietViewPagerAdapter(this);
        mViewPager2.setAdapter(chiTietViewPagerAdapter);
        tbChiTiet = findViewById(R.id.toolBarChiTiet);
    }
}