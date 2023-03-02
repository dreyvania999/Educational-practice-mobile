package com.example.up_mob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ImageView menu = findViewById(R.id.menu);
        menu.setOnClickListener(this);

        ImageView avatar = findViewById(R.id.avatar);
        avatar.setOnClickListener(this);

        ImageView profile = findViewById(R.id.profile);
        profile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menu:
                startActivity(new Intent(MainMenuActivity.this, MenuActivity.class));
                break;
            case R.id.avatar:
            case R.id.profile:
                startActivity(new Intent(MainMenuActivity.this, ProfileActivity.class));
                break;
        }
    }
}