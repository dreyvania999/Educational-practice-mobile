package com.example.up_mob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    User CurrentUser;
    final static String userVariableKey = "USER_VARIABLE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvGreeting = findViewById(R.id.tvGreeting);

        ImageView menu = findViewById(R.id.menu);
        menu.setOnClickListener(this);

        ImageView avatar = findViewById(R.id.avatar);
        avatar.setOnClickListener(this);

        ImageView profile = findViewById(R.id.profile);
        profile.setOnClickListener(this);
        tvGreeting.setText("С возвращением, " +CurrentUser.getNickName());
        new DownloadImageTask(avatar)
                .execute(CurrentUser.getAvatar());
    }


    public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Ошибка передачи изображения", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putSerializable(userVariableKey, CurrentUser);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        CurrentUser = (User)savedInstanceState.getSerializable(userVariableKey);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menu:
                startActivity(new Intent(MainActivity.this, MenuActivity.class));
                break;
            case R.id.avatar:
            case R.id.profile:
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                break;
        }
    }

}

