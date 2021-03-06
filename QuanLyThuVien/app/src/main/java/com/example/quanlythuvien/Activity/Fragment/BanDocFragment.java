package com.example.quanlythuvien.Activity.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.quanlythuvien.Activity.Activity.Thembandoc;
import com.example.quanlythuvien.Activity.Adapter.BanDocAdapter;
import com.example.quanlythuvien.Activity.Adapter.KeSachAdapter;
import com.example.quanlythuvien.Activity.Model.BanDoc;
import com.example.quanlythuvien.Activity.Model.KeSach;
import com.example.quanlythuvien.Activity.Util.CheckConnection;
import com.example.quanlythuvien.Activity.Util.Server;
import com.example.quanlythuvien.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BanDocFragment extends Fragment {
    private View view;
    private ListView lvBanDoc;
    private BanDocAdapter banDocAdapter;
    private ArrayList<BanDoc> arrayListBanDoc;
    FloatingActionButton btnThem;
    private int id=0;
    private String HoTen="";
    private String MSV="";
    private String Lop="";
    private String NgaySinh="";
    private String GioiTinh="";
    private String DiaChi="";
    private String SDT="";
    private String Email="";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bandoc,container,false);
        AnhXa();
        GetDuLieuBanDoc();
        EventButton();
        return view;
    }

    public void DeleteBanDoc(int id){
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdanxoabandoc, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    CheckConnection.ShowToast_Short(getActivity(),"X??a th??nh c??ng");
                    GetDuLieuBanDoc();
                }else {
                    CheckConnection.ShowToast_Short(getActivity(),"X??a kh??ng th??nh c??ng");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast_Short(getActivity(),"X??a kh??ng th??nh c??ng");
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("id",String.valueOf(id));
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void EventButton() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Thembandoc.class);
                startActivity(intent);
            }
        });
    }

    private void GetDuLieuBanDoc() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdanbandoc, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if (response != null){
                    arrayListBanDoc.clear();
                    for (int i = 0;i < response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            HoTen = jsonObject.getString("hoTen");
                            MSV = jsonObject.getString("maSV");
                            Lop = jsonObject.getString("lop");
                            NgaySinh = jsonObject.getString("ngaySinh");
                            GioiTinh = jsonObject.getString("gioiTinh");
                            DiaChi = jsonObject.getString("diaChi");
                            SDT = jsonObject.getString("soDienThoai");
                            Email = jsonObject.getString("email");
                            arrayListBanDoc.add(new BanDoc(id,HoTen,MSV,Lop,NgaySinh,GioiTinh,DiaChi,SDT,Email));
                            banDocAdapter.notifyDataSetChanged();
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
        lvBanDoc.setAdapter(banDocAdapter);
    }

    private void AnhXa() {
        lvBanDoc = view.findViewById(R.id.lvBanDoc);
        arrayListBanDoc = new ArrayList<>();
        banDocAdapter = new BanDocAdapter(arrayListBanDoc,BanDocFragment.this);
        btnThem = view.findViewById(R.id.btnThemBD);
    }
}
