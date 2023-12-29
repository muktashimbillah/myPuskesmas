package com.tasim.mypuskesmas.database.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Bumil implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "nama")
    private String nama;
    @ColumnInfo(name = "tanggalLahir")
    private String tanggalLahir;
    @ColumnInfo(name = "usiaKandungan")
    private int usiaKandungan;

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
    public int getUsiaKandungan() {
        return usiaKandungan;
    }
    public void setUsiaKandungan(int usiaKandungan) {
        this.usiaKandungan = usiaKandungan;
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
        dest.writeInt(this.usiaKandungan);
        dest.writeString(this.alamat);
        dest.writeDouble(this.beratBadan);
    }

    @Ignore
    public Bumil(){
    }

    public Bumil(String nama, String tanggalLahir, int usiaKandungan, String alamat, double beratBadan) {
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.usiaKandungan = usiaKandungan;
        this.alamat = alamat;
        this.beratBadan = beratBadan;
    }

    private Bumil(Parcel in) {
        this.id = in.readInt();
        this.nama = in.readString();
        this.tanggalLahir = in.readString();
        this.usiaKandungan = in.readInt();
        this.alamat = in.readString();
        this.beratBadan = in.readDouble();
    }

    public static final Parcelable.Creator<Bumil> CREATOR = new Parcelable.Creator<Bumil>() {

        @Override
        public Bumil createFromParcel(Parcel source) {
            return new Bumil(source);
        }

        @Override
        public Bumil[] newArray(int size) {
            return new Bumil[size];
        }
    };
}
