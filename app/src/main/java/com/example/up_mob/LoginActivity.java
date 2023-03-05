package com.example.up_mob;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText Email, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Password = findViewById(R.id.pass);
        Email = findViewById(R.id.email);

        TextView tv = findViewById(R.id.reg);
        tv.setOnClickListener(this);

        Button btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(this);

        Button btnProfile = findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(this);
    }

    public boolean PassAndEmail() {
        return !TextUtils.isEmpty(Email.getText()) && !TextUtils.isEmpty(Password.getText()) && android.util.Patterns.EMAIL_ADDRESS.matcher(Email.getText()).matches();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSignIn:
                if (PassAndEmail())

                    break;
            case R.id.btnProfile:
                MainActivity.CurrentUser = new User(1, "Вку", "ирил", "http://mskko2021.mad.hakta.pro//uploads//files//quote_2.png", "123");
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
            case R.id.reg:
                startActivity(new Intent(LoginActivity.this, RegActivity.class));
                break;
        }
    }




   /* private void postData( ) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mskko2021.mad.hakta.pro/api")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        User mask = new User( );

        retrofit2.Call<User> call = retrofitAPI.createPost(mask);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(LoginActivity.this, "Паста добавлена", Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Ошибка: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }*/
}