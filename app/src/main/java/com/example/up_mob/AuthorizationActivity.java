package com.example.up_mob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AuthorizationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        TextView tv = findViewById(R.id.reg);
        tv.setOnClickListener(this);

        Button btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(this);

        Button btnProfile = findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSignIn:
            case R.id.btnProfile:
                startActivity(new Intent(AuthorizationActivity.this, MainMenuActivity.class));
                break;
            case R.id.reg:
                startActivity(new Intent(AuthorizationActivity.this, RegActivity.class));
                break;
        }
    }
}