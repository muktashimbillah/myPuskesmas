package com.tasim.mypuskesmas.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.tasim.mypuskesmas.LoginActivity;
import com.tasim.mypuskesmas.R;
import com.tasim.mypuskesmas.databinding.ActivityMenuBinding;
import com.tasim.mypuskesmas.menu.formData.ListTypeFormActivity;
import com.tasim.mypuskesmas.menu.riwayatLaporan.ListTypeLaporanActivity;

public class MenuActivity extends AppCompatActivity {

    private ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setAction();
    }

    private void setAction() {
        binding.btnlaporan.setOnClickListener(view -> {
            startActivity(new Intent(this, ListTypeLaporanActivity.class));
        });
        binding.btnForm.setOnClickListener(view -> {
            startActivity(new Intent(this, ListTypeFormActivity.class));
        });
        binding.btnLogout.setOnClickListener(view -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}