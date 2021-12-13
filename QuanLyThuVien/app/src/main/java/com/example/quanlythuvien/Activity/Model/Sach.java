package com.example.quanlythuvien.Activity.Model;

import java.io.Serializable;

public class Sach implements Serializable {
    public int id;
    public int idKeSach;
    public String tenSach;
    public String tenTacGia;
    public String nhaXuatBan;
    public String ngayXuatBan;
    public String ngonNgu;
    public int giaSach;
    public String soSeries;
    public Integer soLuong;
    public String loiTua;
    public String hinhAnhSach;

    public Sach(int id, int idKeSach, String tenSach, String tenTacGia,String nhaXuatBan, String ngayXuatBan, String ngonNgu, int giaSach, String soSeries, Integer soLuong, String loiTua,String hinhAnhSach) {
        this.id = id;
        this.idKeSach = idKeSach;
        this.tenSach = tenSach;
        this.tenTacGia = tenTacGia;
        this.nhaXuatBan = nhaXuatBan;
        this.ngayXuatBan = ngayXuatBan;
        this.ngonNgu = ngonNgu;
        this.giaSach = giaSach;
        this.soSeries = soSeries;
        this.soLuong = soLuong;
        this.loiTua = loiTua;
        this.hinhAnhSach = hinhAnhSach;
    }

    public String getHinhAnhSach() {
        return hinhAnhSach;
    }

    public void setHinhAnhSach(String hinhAnhSach) {
        this.hinhAnhSach = hinhAnhSach;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdKeSach() {
        return idKeSach;
    }

    public void setIdKeSach(Integer idKeSach) {
        this.idKeSach = idKeSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public String getNgayXuatBan() {
        return ngayXuatBan;
    }

    public void setNgayXuatBan(String ngayXuatBan) {
        this.ngayXuatBan = ngayXuatBan;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public int getGiaSach() {
        return giaSach;
    }

    public void setGiaSach(int giaSach) {
        this.giaSach = giaSach;
    }

    public String getSoSeries() {
        return soSeries;
    }

    public void setSoSeries(String soSeries) {
        this.soSeries = soSeries;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getLoiTua() {
        return loiTua;
    }

    public void setLoiTua(String loiTua) {
        this.loiTua = loiTua;
    }
}
