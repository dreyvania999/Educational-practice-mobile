package com.example.up_mob;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.EditEmail);
        etPassword = findViewById(R.id.Password);

        SharedPreferences prefs = this.getSharedPreferences(
                "Date", Context.MODE_PRIVATE); // Получение данных о пользователе
        if (prefs != null) {
            etEmail.setText(prefs.getString("Email", ""));
            etPassword.requestFocus();
        }
    }

    public void goMain(View v) {
        if (etEmail.getText().toString().equals("") || etPassword.getText().toString().equals("")) // Проверка заполненности полей
        {
            Toast.makeText(LoginActivity.this, "Все поля должны быть заполнены!", Toast.LENGTH_SHORT).show();
        } else {
            Pattern p = Pattern.compile("@", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(etEmail.getText().toString());
            boolean b = m.find();
            if (b) {
                callLogin();
            } else {
                Toast.makeText(LoginActivity.this, "Поле для Email обязательно должно содержать символ '@'", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void callLogin()
    {
        String email = String.valueOf(etEmail.getText());
        String password = String.valueOf(etPassword.getText());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mskko2021.mad.hakta.pro/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        SendUser sendUser = new SendUser(email, password);
        Call<User> call = retrofitAPI.createUser(sendUser);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Пользователь с такой почтой и паролем не найден", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (response.body() != null) {
                    if (response.body().getToken() != null) {
                        SharedPreferences prefs = getSharedPreferences( // Сохранение данных
                                "Date", Context.MODE_PRIVATE);
                        prefs.edit().putString("Email", "" + email).apply();
                        prefs.edit().putString("Avatar", "" + response.body().getAvatar()).apply();
                        prefs.edit().putString("NickName", "" + response.body().getNickName()).apply();

                        Onboarding.avatar = response.body().getAvatar();
                        Onboarding.nickName = response.body().getNickName();

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        Bundle b = new Bundle();
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "При авторизации возникла ошибка: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void goRegister(View v) {
        startActivity(new Intent(this, RegisterActivity.class));
    }
}