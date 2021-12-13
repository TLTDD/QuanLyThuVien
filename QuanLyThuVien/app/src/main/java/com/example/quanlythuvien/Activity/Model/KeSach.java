package com.example.quanlythuvien.Activity.Model;

public class KeSach {
    public int id;
    public String tenKeSach;

    public KeSach(int id, String tenKeSach) {
        this.id = id;
        this.tenKeSach = tenKeSach;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKeSach() {
        return tenKeSach;
    }

    public void setTenKeSach(String tenKeSach) {
        this.tenKeSach = tenKeSach;
    }
}
