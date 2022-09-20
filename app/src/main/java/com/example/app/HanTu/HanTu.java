package com.example.app.HanTu;

public class HanTu {
    private int _id;
    private String kanjj;
    private String amhanviet;
    private String nghia;
    private String amon;
    private String amkun;
    private String trinhdo;
    private int bai;
    public HanTu() {
    }

    public HanTu(int _id, String kanjj, String amhanviet, String nghia, String amon, String amkun, String trinhdo,int bai) {
        this._id = _id;
        this.kanjj = kanjj;
        this.amhanviet = amhanviet;
        this.nghia = nghia;
        this.amon = amon;
        this.amkun = amkun;
        this.trinhdo = trinhdo;
        this.bai = bai;
    }

    public int getBai() {
        return bai;
    }

    public void setBai(int bai) {
        this.bai = bai;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getKanjj() {
        return kanjj;
    }

    public void setKanjj(String kanjj) {
        this.kanjj = kanjj;
    }

    public String getAmhanviet() {
        return amhanviet;
    }

    public void setAmhanviet(String amhanviet) {
        this.amhanviet = amhanviet;
    }

    public String getNghia() {
        return nghia;
    }

    public void setNghia(String nghia) {
        this.nghia = nghia;
    }

    public String getAmon() {
        return amon;
    }

    public void setAmon(String amon) {
        this.amon = amon;
    }

    public String getAmkun() {
        return amkun;
    }

    public void setAmkun(String amkun) {
        this.amkun = amkun;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }
}
