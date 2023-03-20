package com.example.up_mob;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class PhotoActivity extends AppCompatActivity {

    SubsamplingScaleImageView imageView;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        imageView = findViewById(R.id.image);
        if (ProfileActivity.maskImageFProfile.getImageProfile().exists()) {

            Bitmap myBitmap = BitmapFactory.decodeFile(ProfileActivity.maskImageFProfile.getImageProfile().getAbsolutePath());
            imageView.setImage(ImageSource.bitmap(myBitmap));
        }

        imageView.setOnTouchListener(new OnSwipeTouchListener(PhotoActivity.this) {
            public void onSwipeRight() {
                ProfileActivity.maskImageFProfile = null;
                startActivity(new Intent(PhotoActivity.this, ProfileActivity.class));
            }

            public void onSwipeLeft() {
                try {
                    ProfileActivity.maskImageFProfile.imageProfile.delete();
                    ProfileActivity.maskImageFProfile = null;
                    Toast.makeText(PhotoActivity.this, "Фотография успешно удалена", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(PhotoActivity.this, ProfileActivity.class));
                } catch (Exception e) {
                    Toast.makeText(PhotoActivity.this, "При удаление фотографии возникла ошибка!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        view = findViewById(R.id.view);
        view.setOnTouchListener(new OnSwipeTouchListener(PhotoActivity.this) {
            public void onSwipeRight() {
                ProfileActivity.maskImageFProfile = null;
                startActivity(new Intent(PhotoActivity.this, ProfileActivity.class));
            }

            public void onSwipeLeft() {
                try {
                    ProfileActivity.maskImageFProfile.imageProfile.delete();
                    ProfileActivity.maskImageFProfile = null;
                    Toast.makeText(PhotoActivity.this, "Фотография успешно удалена", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(PhotoActivity.this, ProfileActivity.class));
                } catch (Exception e) {
                    Toast.makeText(PhotoActivity.this, "При удаление фотографии возникла ошибка!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Close(View view) {
        ProfileActivity.maskImageFProfile = null;
        startActivity(new Intent(this, ProfileActivity.class));
    }

    public void Delete(View view) {
        try {
            ProfileActivity.maskImageFProfile.imageProfile.delete();
            ProfileActivity.maskImageFProfile = null;
            Toast.makeText(PhotoActivity.this, "Фотография успешно удалена", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(PhotoActivity.this, ProfileActivity.class));
        } catch (Exception e) {
            Toast.makeText(PhotoActivity.this, "При удаление фотографии возникла ошибка!", Toast.LENGTH_SHORT).show();
        }
    }
}
