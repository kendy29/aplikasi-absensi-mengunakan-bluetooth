package com.ptcintadamai.discovering;

public class data  {
    private String nama;
    private String tanggal;
    private String mata;
    private String semua;
    public data(String nama, String tanggal, String mata) {
        this.nama = nama;
        this.tanggal = tanggal;
        this.mata = mata;
    }
    public String getSemua() {
        return semua;
    }

    public void setSemua(String semua) {
        this.semua = semua;
    }



    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getMata() {
        return mata;
    }

    public void setMata(String mata) {
        this.mata = mata;
    }





    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }


}
