package com.example.quanlythuvien.Activity.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.quanlythuvien.Activity.Fragment.BanDocFragment;
import com.example.quanlythuvien.Activity.Fragment.GhiChuFragment;
import com.example.quanlythuvien.Activity.Fragment.KeSachFragment;
import com.example.quanlythuvien.Activity.Fragment.MuonFragment;
import com.example.quanlythuvien.Activity.Fragment.SachFragment;
import com.example.quanlythuvien.Activity.Fragment.ThongTinFragment;

public class ChiTietViewPagerAdapter extends FragmentStateAdapter {

    public ChiTietViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new ThongTinFragment();
            default:
                return new ThongTinFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
