package com.example.quanlythuvien.Activity.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlythuvien.Activity.Model.Sach;
import com.example.quanlythuvien.R;

import java.util.ArrayList;

public class MuonFragment extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_muon,container,false);
        AnhXa();
        return view;
    }

    private void AnhXa() {

    }
}
