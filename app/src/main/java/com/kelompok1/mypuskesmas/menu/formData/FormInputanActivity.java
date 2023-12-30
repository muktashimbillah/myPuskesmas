package com.kelompok1.mypuskesmas.menu.formData;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.kelompok1.mypuskesmas.database.entity.Balita;
import com.kelompok1.mypuskesmas.database.entity.Bumil;
import com.kelompok1.mypuskesmas.database.entity.Lansia;
import com.kelompok1.mypuskesmas.databinding.ActivityFormInputanBinding;
import com.kelompok1.mypuskesmas.helper.ViewModelFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FormInputanActivity extends AppCompatActivity {
    
    private ActivityFormInputanBinding binding;
    private String data1;
    private String data2;

    private Balita balita;
    private Bumil bumil;
    private Lansia lansia;
    private FormInputanViewModel formInputanViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormInputanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        formInputanViewModel = obtainViewModel(FormInputanActivity.this);

        Intent intent = getIntent();
        if (intent != null) {
            data1 = intent.getStringExtra("KEY_DATA_1");
            data2 = intent.getStringExtra("KEY_DATA_2");
            Log.d("data", data1);
            Log.d("data", data2);
        }
        
        setUI(data1);
        setAction();

    }

    private void setUI(String data1) {
        if (data1 != null) {
            switch (data1) {
                case "balita":
                    binding.usiaKandungan.setVisibility(View.GONE);
                    binding.tinggiBadan.setVisibility(View.GONE);
                    binding.judul.setText("Balita");

                    balita = new Balita();
                    binding.btnSimpan.setOnClickListener( view -> {
                        String nama = binding.iptNamaLengkap.getText().toString().trim();
                        String tglLahir = binding.iptTanggalLahir.getText().toString().trim();
                        String jnKelamin = binding.iptJenisKelamin.getText().toString().trim();
                        String alamat = binding.iptAlamat.getText().toString().trim();
                        String beratBadanStr = binding.iptBeratBadan.getText().toString().trim();

                        if (nama.isEmpty() || tglLahir.isEmpty() || jnKelamin.isEmpty() || alamat.isEmpty() ||
                                beratBadanStr.isEmpty() ) {
                            Toast.makeText(this, "Data tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show();
                        } else {
                            double beratBadan = Double.parseDouble(beratBadanStr);
                            balita.setNama(nama);
                            balita.setTanggalLahir(tglLahir);
                            balita.setJenisKelamin(jnKelamin);
                            balita.setAlamat(alamat);
                            balita.setBeratBadan(beratBadan);

                            formInputanViewModel.insert(balita);
                            Toast.makeText(this, "Data Balita Berhasil di Upload", Toast.LENGTH_SHORT).show();

                            binding.iptNamaLengkap.setText("");
                            binding.iptTanggalLahir.setText("");
                            binding.iptJenisKelamin.setText("");
                            binding.iptAlamat.setText("");
                            binding.iptBeratBadan.setText("");
                        }

                    });

                    break;
                case "bumil":
                    binding.jenisKelamin.setVisibility(View.GONE);
                    binding.tinggiBadan.setVisibility(View.GONE);
                    binding.judul.setText("Ibu Hamil");

                    bumil = new Bumil();
                    binding.btnSimpan.setOnClickListener( view -> {
                        String nama = binding.iptNamaLengkap.getText().toString().trim();
                        String tglLahir = binding.iptTanggalLahir.getText().toString().trim();
                        String usiaKandunganStr = binding.iptUsiaKandungan.getText().toString().trim();
                        String alamat = binding.iptAlamat.getText().toString().trim();
                        String beratBadanStr = binding.iptBeratBadan.getText().toString().trim();

                        if (nama.isEmpty() || tglLahir.isEmpty() || usiaKandunganStr.isEmpty() || alamat.isEmpty() ||
                                beratBadanStr.isEmpty() ) {
                            Toast.makeText(this, "Data tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show();
                        } else {
                            double beratBadan = Double.parseDouble(beratBadanStr);
                            int usiaKandungan = Integer.parseInt(usiaKandunganStr);
                            bumil.setNama(nama);
                            bumil.setTanggalLahir(tglLahir);
                            bumil.setUsiaKandungan(usiaKandungan);
                            bumil.setAlamat(alamat);
                            bumil.setBeratBadan(beratBadan);

                            formInputanViewModel.insertBumil(bumil);
                            Toast.makeText(this, "Data Bumil Berhasil di Upload", Toast.LENGTH_SHORT).show();

                            binding.iptNamaLengkap.setText("");
                            binding.iptTanggalLahir.setText("");
                            binding.iptUsiaKandungan.setText("");
                            binding.iptAlamat.setText("");
                            binding.iptBeratBadan.setText("");
                        }

                    });
                    break;
                case "lansia":
                    binding.usiaKandungan.setVisibility(View.GONE);
                    binding.tinggiBadan.setVisibility(View.GONE);
                    binding.judul.setText("Lanjut Usia");

                    lansia = new Lansia();
                    binding.btnSimpan.setOnClickListener( view -> {
                        String nama = binding.iptNamaLengkap.getText().toString().trim();
                        String tglLahir = binding.iptTanggalLahir.getText().toString().trim();
                        String jnKelamin = binding.iptJenisKelamin.getText().toString().trim();
                        String alamat = binding.iptAlamat.getText().toString().trim();
                        String beratBadanStr = binding.iptBeratBadan.getText().toString().trim();

                        if (nama.isEmpty() || tglLahir.isEmpty() || jnKelamin.isEmpty() || alamat.isEmpty() ||
                                beratBadanStr.isEmpty() ) {
                            Toast.makeText(this, "Data tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show();
                        } else {
                            double beratBadan = Double.parseDouble(beratBadanStr);
                            lansia.setNama(nama);
                            lansia.setTanggalLahir(tglLahir);
                            lansia.setJenisKelamin(jnKelamin);
                            lansia.setAlamat(alamat);
                            lansia.setBeratBadan(beratBadan);

                            formInputanViewModel.insertLansia(lansia);
                            Toast.makeText(this, "Data Lansia Berhasil di Upload", Toast.LENGTH_SHORT).show();

                            binding.iptNamaLengkap.setText("");
                            binding.iptTanggalLahir.setText("");
                            binding.iptJenisKelamin.setText("");
                            binding.iptAlamat.setText("");
                            binding.iptBeratBadan.setText("");
                        }

                    });
                    break;
                default:
                    finish();
                    break;
            }
        }
    }


    private void setAction() {
        binding.btnBack.setOnClickListener(view -> {
            finish();
        });
//        binding.btnSimpan.setOnClickListener(view -> {
//            boolean hasil = simpandata();
//            if (hasil){
//                finish();
//            }else {
//                Toast.makeText(getApplicationContext(), "Gagal menyimpan data", Toast.LENGTH_SHORT).show();
//            }
//        });
        binding.iptTanggalLahir.setOnClickListener(view -> {
            showDatePickerDialog();
        });
    }
    private void showDatePickerDialog() {
        // Mendapatkan tanggal saat ini
        final Calendar calendar = Calendar.getInstance();

        // Membuat DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        // Format tanggal yang dipilih
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        String formattedDate = sdf.format(calendar.getTime());

                        // Menetapkan tanggal ke EditText
                        binding.iptTanggalLahir.setText(formattedDate);
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );

        // Menampilkan DatePickerDialog
        datePickerDialog.show();
    }

    private boolean simpandata() {
        // logic menyimoan data ke SQLIte

        return true;
    }

    @NonNull
    private static FormInputanViewModel obtainViewModel(AppCompatActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return new ViewModelProvider(activity, factory).get(FormInputanViewModel.class);
    }
}