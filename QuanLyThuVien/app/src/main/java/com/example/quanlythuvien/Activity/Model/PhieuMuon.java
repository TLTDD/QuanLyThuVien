package com.example.quanlythuvien.Activity.Model;

public class PhieuMuon {
    public String hoTen;
    public String maSV;
    public String lop;
    public String tenSach;
    public String maSach;
    public String ngayMuon;
    public String ngayHetHan;
    public String trangThai;

    public PhieuMuon(String hoTen, String maSV, String lop, String tenSach, String maSach, String ngayMuon, String ngayHetHan, String trangThai) {
        this.hoTen = hoTen;
        this.maSV = maSV;
        this.lop = lop;
        this.tenSach = tenSach;
        this.maSach = maSach;
        this.ngayMuon = ngayMuon;
        this.ngayHetHan = ngayHetHan;
        this.trangThai = trangThai;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
