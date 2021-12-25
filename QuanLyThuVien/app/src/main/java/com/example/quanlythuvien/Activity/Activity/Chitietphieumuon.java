package com.example.quanlythuvien.Activity.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
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

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Chitietphieumuon extends AppCompatActivity {
    EditText edtTenBanDoc,edtNgayMuon,edtNgayTra,edtMSSV;
    Button btnxacnhan,btntrove,btnChonSV;
    ImageButton ivNgayMuon,ivNgayTra;
    TextView txtNgayMuon, txtNgayTra,elNgayTra;
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
        btntrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
                        ||txtNgayMuon.getText().toString().trim().isEmpty()
                        ||txtNgayTra.getText().toString().trim().isEmpty()
                        ||edtMSSV.getText().toString().trim().isEmpty()
                        ){
                    Toast.makeText(getApplicationContext(), "Bạn phải điền đầy đủ thông tin !", Toast.LENGTH_SHORT).show();
                }
                else {
                    AddPhieuMuon();
                }
            }
        });
    }
    public void btnSetDateNm_click(View view) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String dateString = year + "-" + (month+1) + "-" + dayOfMonth;
                txtNgayMuon.setText(dateString);
            }
        },year,month, day);
        datePickerDialog.show();
    }
    public void btnSetDateNt_click(View view) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String dateString = year + "-" + (month+1) + "-" + dayOfMonth;
                txtNgayTra.setText(dateString);
            }
        },year,month, day);
        datePickerDialog.show();
    }
    private void AddPhieuMuon(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdanthemphieu, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.contains("success")){
                    Toast.makeText(getApplicationContext(), "Đã thêm thành công !", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Lỗi ngày trả sách!! !", Toast.LENGTH_SHORT).show();
                    elNgayTra.setTextColor(Color.parseColor("#FF0303"));
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
                param.put("ngayMuon",txtNgayMuon.getText().toString());
                param.put("ngayHetHan",txtNgayTra.getText().toString());
                param.put("trangThai","Đang mượn");
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void AnhXa() {
        edtTenBanDoc = findViewById(R.id.edtTenBanDoc);
        edtMSSV = findViewById(R.id.edtMSSV);
        ivNgayMuon = findViewById(R.id.ivNgayMuon);
        ivNgayTra = findViewById(R.id.ivNgayTra);
        txtNgayMuon = findViewById(R.id.txtNgayMuon);
        txtNgayTra = findViewById(R.id.txtNgayTra);
        btnxacnhan = findViewById(R.id.btnXacNhan);
        btntrove = findViewById(R.id.btnHuy);
        btnChonSV = findViewById(R.id.btnChonBanDoc);
        elNgayTra = findViewById(R.id.elNgayTra);
    }
}