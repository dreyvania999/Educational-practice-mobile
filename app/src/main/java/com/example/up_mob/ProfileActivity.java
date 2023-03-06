package com.example.up_mob;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView Nik = findViewById(R.id.NikName);
        Nik.setText(MainActivity.CurrentUser.getNickName());
        ImageView avatar = findViewById(R.id.Avatar);

        avatar.setImageBitmap(MainActivity.CurrentUser.getAvatarBitmap());
    }
}