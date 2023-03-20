package com.example.up_mob;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Including extends AppCompatActivity {

    public static String avatar;
    public static String nickName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        SharedPreferences prefs = this.getSharedPreferences(
                "Date", Context.MODE_PRIVATE);
        if (prefs != null) {
            if (!prefs.getString("NickName", "").equals(""))
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