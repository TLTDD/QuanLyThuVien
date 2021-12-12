package com.example.quanlythuvien.Activity.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.quanlythuvien.Activity.Adapter.BanDocAdapter;
import com.example.quanlythuvien.Activity.Adapter.PhieuMuonAdapter;
import com.example.quanlythuvien.Activity.Model.BanDoc;
import com.example.quanlythuvien.Activity.Model.PhieuMuon;
import com.example.quanlythuvien.Activity.Model.Sach;
import com.example.quanlythuvien.Activity.Util.CheckConnection;
import com.example.quanlythuvien.Activity.Util.Server;
import com.example.quanlythuvien.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MuonFragment extends Fragment {
    private View view;
    private ListView lvPhieuMuon;
    private PhieuMuonAdapter phieumuonAdapter;
    private ArrayList<PhieuMuon> arrayListPhieuMuon;
    private String NguoiMuon="";
    private String MSVMuon="";
    private String Lop;
    private String TenSachMuon="";
    private String MaSach;
    private String NgayMuon="";
    private String NgayTra="";
    private String TinhTrang="";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_muon,container,false);
        AnhXa();
        GetDuLieuLoaiSP();
        return view;
    }

    private void GetDuLieuLoaiSP() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdanphieumuon, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if (response != null){

                    for (int i = 0;i < response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            NguoiMuon = jsonObject.getString("hoTen");
                            MSVMuon = jsonObject.getString("maSV");
                            Lop = jsonObject.getString("lop");
                            TenSachMuon = jsonObject.getString("tenSach");
                            MaSach = jsonObject.getString("maSach");
                            NgayMuon = jsonObject.getString("ngayMuon");
                            NgayTra = jsonObject.getString("ngayHetHan");
                            TinhTrang = jsonObject.getString("trangThai");
                            arrayListPhieuMuon.add(new PhieuMuon(NguoiMuon,MSVMuon,Lop,TenSachMuon,MaSach,NgayMuon,NgayTra,TinhTrang));
                            phieumuonAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast_Short(getActivity(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
        lvPhieuMuon.setAdapter(phieumuonAdapter);
    }

    private void AnhXa() {
        lvPhieuMuon = view.findViewById(R.id.lvPhieuMuon);
        arrayListPhieuMuon = new ArrayList<>();
        phieumuonAdapter = new PhieuMuonAdapter(arrayListPhieuMuon,getActivity());
    }
}
