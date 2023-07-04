package com.DoubleLinked;

public class DataMahasiswa {
    public String dataBaru;
    public DataMahasiswa nextMahasiswa;
    public DataMahasiswa prevMahasiswa;

    public DataMahasiswa(String data) {
        this.dataBaru = data;
        this.nextMahasiswa = null;
        this.prevMahasiswa = null;
    }
}
