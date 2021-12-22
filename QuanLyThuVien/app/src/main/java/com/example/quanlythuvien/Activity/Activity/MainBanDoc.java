package com.example.quanlythuvien.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.quanlythuvien.Activity.Adapter.SachAdapter;
import com.example.quanlythuvien.Activity.Adapter.SachBDAdapter;
import com.example.quanlythuvien.Activity.Model.Sach;
import com.example.quanlythuvien.Activity.Util.CheckConnection;
import com.example.quanlythuvien.Activity.Util.Server;
import com.example.quanlythuvien.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainBanDoc extends AppCompatActivity {
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewSachMN;
    ArrayList<Sach> arrayListSach;
    SachBDAdapter sachAdapter;
    private Toolbar toolbarMain;
    private DrawerLayout drawerLayout;
    private LinearLayout lnTimKiem,lnTaiKhoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ban_doc);
        AnhXa();
        GetDuLieuSach();
        ActionBar();
        ActionViewFlipper();
        OnClickMenu();
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

    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://chiasemoi.com/wp-content/uploads/2017/12/nhung-trich-dan-hay-trong-sach-nha-gia-kim.jpg");
        mangquangcao.add("https://hoctruongdoi.com/wp-content/uploads/2017/11/khi-ng%C6%B0%E1%BB%9Di-ta-b%C3%A1n-tu%E1%BB%95i-tr%E1%BA%BB-v%E1%BB%9Bi-gi%C3%A1-kh%C3%A1-r%E1%BA%BB-1-500x280.png");
        mangquangcao.add("http://file.hstatic.net/1000362347/article/damuocmow_ab793883a21f4aacb7b748a405dcdbb2_1024x1024.jpg");
        mangquangcao.add("https://nguontinhyeu.com/wp-content/uploads/2015/10/con-nguoi-tu-dau-den1.jpg");
        mangquangcao.add("https://tusachtinhhoa.vn/wp-content/uploads/2020/10/ben-rang-tuyet-son-1.png");
        for(int i =0; i<mangquangcao.size();i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    private void OnClickMenu() {
        lnTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TimKiemSachBD.class);
                startActivity(intent);
            }
        });
        lnTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TaiKhoanBD.class);
                startActivity(intent);
            }
        });
    }

    private void GetDuLieuSach() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdansachmoi, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response!=null){
                    int id=0;
                    String idKeSach = "";
                    String tenSach = "";
                    String tenTacGia = "";
                    String nhaXuatBan = "";
                    String ngayXuatBan = "";
                    String ngonNgu = "";
                    Integer giaSach = 0;
                    String soSeries = "";
                    Integer soLuong = 0;
                    String loiTua = "";
                    String hinhAnhSach = "";
                    for (int i=0; i<response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            idKeSach = jsonObject.getString("tenKeSach");
                            tenSach = jsonObject.getString("tenSach");
                            tenTacGia = jsonObject.getString("tenTacGia");
                            nhaXuatBan = jsonObject.getString("nhaXuatBan");
                            ngayXuatBan = jsonObject.getString("ngayXuatBan");
                            ngonNgu = jsonObject.getString("ngonNgu");
                            giaSach = jsonObject.getInt("giaSach");
                            soSeries = jsonObject.getString("soSeries");
                            soLuong = jsonObject.getInt("soLuong");
                            loiTua = jsonObject.getString("loiTua");
                            hinhAnhSach = jsonObject.getString("hinhAnhSach");
                            arrayListSach.add(new Sach(id,idKeSach,tenSach,tenTacGia,nhaXuatBan,ngayXuatBan,ngonNgu,giaSach,soSeries,soLuong,loiTua,hinhAnhSach));
                            sachAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast_Short(getApplicationContext(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void AnhXa() {
        recyclerViewSachMN = findViewById(R.id.recyclerViewSachMoi);
        arrayListSach = new ArrayList<>();
        sachAdapter = new SachBDAdapter(getApplicationContext(),arrayListSach);
        recyclerViewSachMN.setHasFixedSize(true);
        recyclerViewSachMN.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerViewSachMN.setAdapter(sachAdapter);
        toolbarMain = findViewById(R.id.tbMainBanDoc);
        drawerLayout = findViewById(R.id.drawerlayoutBD);
        viewFlipper = findViewById(R.id.viewflipperBD);
        lnTimKiem = findViewById(R.id.ln_search_bd);
        lnTaiKhoan = findViewById(R.id.ln_tk_bd);
    }
}