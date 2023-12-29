package com.tasim.mypuskesmas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

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
            String username = String.valueOf(binding.iptUsername.getText());
            String password = String.valueOf(binding.iptPassword.getText());
            if (username.equals("admin") && password.equals("123456")) {
                startActivity(new Intent(LoginActivity.this, MenuActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Username/Password salah ", Toast.LENGTH_SHORT).show();
            }

        });
    }
}