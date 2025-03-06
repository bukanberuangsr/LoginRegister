package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    private TextInputEditText editTextUsername, editTextPassword;

    private final String correctUser = "akhtar";
    private final String correctPass = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        Button btn_login = findViewById(R.id.btn_login);

        // Kalo tombol diclick, proses login dimulai
        btn_login.setOnClickListener(v -> {
            String username, password;
            username = String.valueOf(editTextUsername.getText());
            password = String.valueOf(editTextPassword.getText());

            // Cek kalau editText username dan password kosong
            if (TextUtils.isEmpty(username)){
                Toast.makeText(Login.this, "Username Kosong", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(password)){
                Toast.makeText(Login.this, "Password Kosong", Toast.LENGTH_SHORT).show();
                return;
            }

            // Cek kalo jika sama dengan username dan password yang benar
            if (username.equals(correctUser) && password.equals(correctPass)){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(Login.this, "Username atau Password Salah",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}