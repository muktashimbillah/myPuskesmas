package com.kelompok1.mypuskesmas.menu.riwayatLaporan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.kelompok1.mypuskesmas.databinding.ActivityListLaporanBinding;
import com.kelompok1.mypuskesmas.helper.ViewModelFactory;
import com.kelompok1.mypuskesmas.menu.riwayatLaporan.adapter.BalitaAdapter;
import com.kelompok1.mypuskesmas.menu.riwayatLaporan.adapter.BumilAdapter;
import com.kelompok1.mypuskesmas.menu.riwayatLaporan.adapter.LansiaAdapter;

public class ListLaporanActivity extends AppCompatActivity {

    private ActivityListLaporanBinding binding;
    private String data1;
    private String data2;
    private BalitaAdapter balitaAdapter;
    private BumilAdapter bumilAdapter;
    private LansiaAdapter lansiaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListLaporanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setAction();

        Intent intent = getIntent();
        if (intent != null) {
            data1 = intent.getStringExtra("KEY_DATA_1");
            if (data1 != null) {
                Log.d("data", data1);
            }
        }

        setUI(data1);


    }

    private void setUI(String data1) {
        ListLaporanViewModel listLaporanViewModel = obtainViewModel(ListLaporanActivity.this);

        if (data1 != null) {
            switch (data1) {
                case "Balita":
                    balitaAdapter = new BalitaAdapter();
                    listLaporanViewModel.getAllBalita().observe(this, balitas -> {
                        if (balitas != null) {
                            balitaAdapter.submitList(balitas);
                            binding.rvLaporan.setLayoutManager(new LinearLayoutManager(this));
                            binding.rvLaporan.setHasFixedSize(true);
                            binding.rvLaporan.setAdapter(balitaAdapter);
                        }
                    });
                    break;

                case "Ibu Hamil":
                    bumilAdapter = new BumilAdapter();
                    listLaporanViewModel.getAllBumil().observe(this, bumils -> {
                        if (bumils != null) {
                            bumilAdapter.submitList(bumils);
                            binding.rvLaporan.setLayoutManager(new LinearLayoutManager(this));
                            binding.rvLaporan.setHasFixedSize(true);
                            binding.rvLaporan.setAdapter(bumilAdapter);
                        }
                    });
                    break;

                case "Lansia":
                    lansiaAdapter = new LansiaAdapter();
                    listLaporanViewModel.getAllLansia().observe(this, lansias -> {
                        if (lansias != null) {
                            lansiaAdapter.submitList(lansias);
                            binding.rvLaporan.setLayoutManager(new LinearLayoutManager(this));
                            binding.rvLaporan.setHasFixedSize(true);
                            binding.rvLaporan.setAdapter(lansiaAdapter);
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
    }

    @NonNull
    private static ListLaporanViewModel obtainViewModel(AppCompatActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return new ViewModelProvider(activity, factory).get(ListLaporanViewModel.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}