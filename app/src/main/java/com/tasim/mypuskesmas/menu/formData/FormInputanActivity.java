package com.tasim.mypuskesmas.menu.formData;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.tasim.mypuskesmas.databinding.ActivityFormInputanBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FormInputanActivity extends AppCompatActivity {
    
    private ActivityFormInputanBinding binding;
    private String data1;
    private String data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormInputanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
                    binding.beratBadan.setVisibility(View.GONE);
                    binding.judul.setText("Balita");
                    break;
                case "bumil":
                    binding.jenisKelamin.setVisibility(View.GONE);
                    binding.tinggiBadan.setVisibility(View.GONE);
                    binding.judul.setText("Ibu Hamil");
                    break;
                case "lansia":
                    binding.usiaKandungan.setVisibility(View.GONE);
                    binding.tinggiBadan.setVisibility(View.GONE);
                    binding.judul.setText("Lanjut Usia");
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
        binding.btnSimpan.setOnClickListener(view -> {
            boolean hasil = simpandata();
            if (hasil){
                finish();
            }else {
                Toast.makeText(getApplicationContext(), "Gagal menyimpan data", Toast.LENGTH_SHORT).show();
            }
        });
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
}