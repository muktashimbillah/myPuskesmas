package com.tasim.mypuskesmas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.tasim.mypuskesmas.databinding.ActivityLoginBinding;
import com.tasim.mypuskesmas.menu.MenuActivity;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setAction();
    }

    private void setAction() {
        binding.btnLogin.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, MenuActivity.class));
            finish();
        });
    }
}