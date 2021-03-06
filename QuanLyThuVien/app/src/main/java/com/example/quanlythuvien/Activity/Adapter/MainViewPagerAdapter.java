package com.example.quanlythuvien.Activity.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.quanlythuvien.Activity.Fragment.BanDocFragment;
import com.example.quanlythuvien.Activity.Fragment.KeSachFragment;
import com.example.quanlythuvien.Activity.Fragment.MuonFragment;
import com.example.quanlythuvien.Activity.Fragment.SachFragment;

public class MainViewPagerAdapter extends FragmentStateAdapter {
    public MainViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new KeSachFragment();
            case 1:
                return new SachFragment();
            case 2:
                return new MuonFragment();
            case 3:
                return new BanDocFragment();
            default:
                return new KeSachFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
