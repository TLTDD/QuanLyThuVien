package com.example.quanlythuvien.Activity.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.example.quanlythuvien.Activity.Adapter.MainViewPagerAdapter;
import com.example.quanlythuvien.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;
    private MainViewPagerAdapter mainViewPagerAdapter;
    private Toolbar toolbarMain;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        TLayout();
        ActionBar();
    }

    private void ActionBar() {
        setSupportActionBar(toolbarMain);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarMain.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbarMain.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void TLayout() {
        new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Kệ sách ");
                        break;
                    case 1:
                        tab.setText("Sách");
                        break;
                }
            }
        }).attach();
    }

    private void AnhXa() {
        mTabLayout = findViewById(R.id.tabLayoutMain);
        mViewPager2 = findViewById(R.id.viewPagerMain);
        mainViewPagerAdapter = new MainViewPagerAdapter(this);
        mViewPager2.setAdapter(mainViewPagerAdapter);
        toolbarMain = findViewById(R.id.toolBarMain);
        drawerLayout = findViewById(R.id.drawerLayoutMain);
    }
}