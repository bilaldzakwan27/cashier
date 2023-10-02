package com.smk.model;

public class Barang extends Model{
    private String kodeBarang;
    private String namaBarang;

    private int hargaBarang;


    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(int hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    @Override
    public String toString() {
        return "Barang{" +
                "kodeBarang='" + kodeBarang + '\'' +
                ", namaBarang='" + namaBarang + '\'' +
                ", dateCreated=" + dateCreated +
                ", lastModified=" + lastModified +
                ", createdBy='" + createdBy + '\'' +
                ", updateBy=" + updatedBy + '\'' +
                '}';
    }
}