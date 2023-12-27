package com.tasim.mypuskesmas.menu.formData;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.tasim.mypuskesmas.R;
import com.tasim.mypuskesmas.databinding.ActivityListTypeFormBinding;
import com.tasim.mypuskesmas.menu.riwayatLaporan.ListLaporanActivity;

public class ListTypeFormActivity extends AppCompatActivity {

    private ActivityListTypeFormBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListTypeFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setAction();
    }

    private void setAction() {
        binding.btnBack.setOnClickListener(view -> {
            finish();
        });
        binding.btnBalita.setOnClickListener(view->{
            Intent intent = new Intent(this, FormInputanActivity.class);
            // Menambahkan data string ke Intent
            String data1 = "balita";
            String data2 = "Nilai2";
            intent.putExtra("KEY_DATA_1", data1);
            intent.putExtra("KEY_DATA_2", data2);

            // Memulai activity baru dengan membawa Intent
            startActivity(intent);
        });
        binding.btnBumil.setOnClickListener(view->{
            Intent intent = new Intent(this, FormInputanActivity.class);
            // Menambahkan data string ke Intent
            String data1 = "bumil";
            String data2 = "Nilai2";
            intent.putExtra("KEY_DATA_1", data1);
            intent.putExtra("KEY_DATA_2", data2);

            // Memulai activity baru dengan membawa Intent
            startActivity(intent);
        });
        binding.btnLansia.setOnClickListener(view -> {
            Intent intent = new Intent(this, FormInputanActivity.class);
            // Menambahkan data string ke Intent
            String data1 = "lansia";
            String data2 = "Nilai2";
            intent.putExtra("KEY_DATA_1", data1);
            intent.putExtra("KEY_DATA_2", data2);

            // Memulai activity baru dengan membawa Intent
            startActivity(intent);
        });
    }
}