package com.tasim.mypuskesmas.menu.riwayatLaporan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tasim.mypuskesmas.R;
import com.tasim.mypuskesmas.databinding.ActivityListLaporanBinding;

public class ListLaporanActivity extends AppCompatActivity {

    private ActivityListLaporanBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListLaporanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setAction();
    }

    private void setAction() {
        binding.btnBack.setOnClickListener(view -> {
            finish();
        });
    }
}