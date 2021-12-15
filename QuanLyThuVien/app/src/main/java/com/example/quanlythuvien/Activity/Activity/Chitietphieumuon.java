package com.example.quanlythuvien.Activity.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.quanlythuvien.Activity.Fragment.BanDocFragment;
import com.example.quanlythuvien.Activity.Model.BanDoc;
import com.example.quanlythuvien.R;

public class Chitietphieumuon extends AppCompatActivity {
    EditText edtTenBanDoc,edtNgayMuon,edtNgayTra,edtMSSV;
    Button btnxacnhan,btntrove,btnChonSV;
    int REQUEST_BANDOC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietphieumuon);
        AnhXa();
        setbtnBanDoc();
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
        }
        super.onActivityResult(requestCode, resultCode, data);
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