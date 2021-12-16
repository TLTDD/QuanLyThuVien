package com.example.quanlythuvien.Activity.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.quanlythuvien.Activity.Fragment.BanDocFragment;
import com.example.quanlythuvien.Activity.Model.BanDoc;
import com.example.quanlythuvien.Activity.Util.Server;
import com.example.quanlythuvien.R;

import java.util.HashMap;
import java.util.Map;

public class Chitietphieumuon extends AppCompatActivity {
    EditText edtTenBanDoc,edtNgayMuon,edtNgayTra,edtMSSV;
    Button btnxacnhan,btntrove,btnChonSV;
    int REQUEST_BANDOC;
    int maPM = 0;
    int maSach = 0;
    String tenSach = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietphieumuon);
        AnhXa();
        setbtnBanDoc();
        getMaSach();
        setActionButton();
    }

    private void getMaSach() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("dulieusach");
        if(bundle!=null){
            maSach = bundle.getInt("idSach");
            tenSach = bundle.getString("tenSach");
        }
    }

    private void setbtnBanDoc(){
        btnChonSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), BanDocActivity.class);
                startActivityForResult(intent,REQUEST_BANDOC);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(REQUEST_BANDOC == requestCode && resultCode == RESULT_OK & data != null){
            BanDoc bd = (BanDoc) data.getSerializableExtra("BanDoc");
            edtTenBanDoc.setText(bd.getHoTen());
            edtMSSV.setText(bd.getMaSV());
            maPM = bd.getId();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void setActionButton() {
        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtTenBanDoc.getText().toString().trim().isEmpty()
                        ||edtNgayMuon.getText().toString().trim().isEmpty()
                        ||edtNgayTra.getText().toString().trim().isEmpty()
                        ||edtMSSV.getText().toString().trim().isEmpty()
                        ){
                    Toast.makeText(getApplicationContext(), "Bạn phải điền đầy đủ thông tin !", Toast.LENGTH_SHORT).show();
                }
                else {
                    AddPhieuMuon();
                    finish();
                }
            }
        });
    }
    private void AddPhieuMuon(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdanthemphieu, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.contains("success")){
                    Toast.makeText(getApplicationContext(), "Đã thêm thành công !", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Xảy ra lỗi !", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Xảy ra lỗi !", Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("maPM",maPM+"");
                param.put("tenSach",tenSach+"");
                param.put("maSach",maSach+"");
                param.put("ngayMuon",edtNgayMuon.getText().toString().trim());
                param.put("ngayHetHan",edtNgayTra.getText().toString().trim());
                param.put("trangThai","Đang mượn");
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void AnhXa() {
        edtTenBanDoc = findViewById(R.id.edtTenBanDoc);
        edtMSSV = findViewById(R.id.edtMSSV);
        edtNgayMuon = findViewById(R.id.edtNgayMuon);
        edtNgayTra = findViewById(R.id.edtNgayTra);
        btnxacnhan = findViewById(R.id.btnXacNhan);
        btntrove = findViewById(R.id.btnHuy);
        btnChonSV = findViewById(R.id.btnChonBanDoc);
    }
}