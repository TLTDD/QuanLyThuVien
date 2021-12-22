package com.example.quanlythuvien.Activity.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

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
import com.example.quanlythuvien.Activity.Activity.SachTrongKeActivity;
import com.example.quanlythuvien.Activity.Activity.ThemKeSach;
import com.example.quanlythuvien.Activity.Adapter.KeSachAdapter;
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

public class KeSachFragment extends Fragment {
    private View view;
    private ListView lvKeSach;
    private FloatingActionButton btnThem;
    private KeSachAdapter keSachAdapter;
    private ArrayList<KeSach> arrayListKeSach;
    private int id=0;
    private String tenKeSach="";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_kesach,container,false);
        AnhXa();
        GetDuLieuLoaiSP();
        eventBtn();
        setItemListView();
        return view;
    }

    public void DeleteKeSach(int id){
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdanxoake, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    CheckConnection.ShowToast_Short(getActivity(),"Xóa thành công");
                    GetDuLieuLoaiSP();
                }else {
                    CheckConnection.ShowToast_Short(getActivity(),"Xóa không thành công");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast_Short(getActivity(),"Xóa không thành công");
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

    private void eventBtn() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ThemKeSach.class);
                startActivity(intent);
            }
        });
    }

    private void setItemListView() {
        lvKeSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(getActivity(), SachTrongKeActivity.class);
                intent.putExtra("idKeSach",arrayListKeSach.get(position).getTenKeSach());
                startActivity(intent);
            }
        });
    }

    private void GetDuLieuLoaiSP() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdankesach, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if (response != null){
                    arrayListKeSach.clear();
                    for (int i = 0;i < response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tenKeSach = jsonObject.getString("tenKeSach");
                            arrayListKeSach.add(new KeSach(id,tenKeSach));
                            keSachAdapter.notifyDataSetChanged();
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
        lvKeSach.setAdapter(keSachAdapter);
    }

    private void AnhXa() {
        lvKeSach = view.findViewById(R.id.lvKeSach);
        arrayListKeSach = new ArrayList<>();
        keSachAdapter = new KeSachAdapter(arrayListKeSach,KeSachFragment.this);
        btnThem = view.findViewById(R.id.btnThemKe);
    }
}
