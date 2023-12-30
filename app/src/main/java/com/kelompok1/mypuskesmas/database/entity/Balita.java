package com.kelompok1.mypuskesmas.database.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Balita implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "nama")
    private String nama;
    @ColumnInfo(name = "tanggalLahir")
    private String tanggalLahir;
    @ColumnInfo(name = "jenisKelamin")
    private String jenisKelamin;

    @ColumnInfo(name = "alamat")
    private String alamat;

    @ColumnInfo(name = "beratBadan")
    private double beratBadan;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getTanggalLahir() {
        return tanggalLahir;
    }
    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
    public String getJenisKelamin() {
        return jenisKelamin;
    }
    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public double getBeratBadan() {
        return beratBadan;
    }
    public void setBeratBadan(double beratBadan) {
        this.beratBadan = beratBadan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.nama);
        dest.writeString(this.tanggalLahir);
        dest.writeString(this.jenisKelamin);
        dest.writeString(this.alamat);
        dest.writeDouble(this.beratBadan);
    }

    @Ignore
    public Balita(){
    }

    public Balita(String nama, String tanggalLahir, String jenisKelamin, String alamat, double beratBadan) {
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.beratBadan = beratBadan;
    }

    private Balita(Parcel in) {
        this.id = in.readInt();
        this.nama = in.readString();
        this.tanggalLahir = in.readString();
        this.jenisKelamin = in.readString();
        this.alamat = in.readString();
        this.beratBadan = in.readDouble();
    }

    public static final Parcelable.Creator<Balita> CREATOR = new Parcelable.Creator<Balita>() {

        @Override
        public Balita createFromParcel(Parcel source) {
            return new Balita(source);
        }

        @Override
        public Balita[] newArray(int size) {
            return new Balita[size];
        }
    };
}
