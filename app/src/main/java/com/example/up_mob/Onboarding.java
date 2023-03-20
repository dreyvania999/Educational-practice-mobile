package com.example.up_mob;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Onboarding extends AppCompatActivity {

    public static String avatar; // Фотография пользователя, который уже вошёл в систему
    public static String nickName; // Имя пользователя, который уже вошёл в систему

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        SharedPreferences prefs = this.getSharedPreferences(
                "Date", Context.MODE_PRIVATE); // Получение данных о пользователе
        if (prefs != null) {
            if (!prefs.getString("NickName", "").equals("")) // Если пользователь уже входил, то получаем данные и пропускаем авторизацию
            {
                avatar = prefs.getString("Avatar", "");
                nickName = prefs.getString("NickName", "");
                startActivity(new Intent(this, MainActivity.class));
            }
        }
    }

    public void goRegistrarion(View v) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void goLogin(View v) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}