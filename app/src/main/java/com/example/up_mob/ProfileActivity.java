package com.example.up_mob;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class ProfileActivity extends AppCompatActivity {

    public static MaskImageFProfile maskImageFProfile;
    private final List<MaskImageFProfile> list = new ArrayList<>();
    ImageView image;
    TextView textName;
    OutputStream outputStream;
    private AdapterImageFProfile pAdapter;
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Bitmap bitmap = null;
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Uri selectedImage = result.getData().getData();
                        try {
                            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        File dir = new File(getApplicationInfo().dataDir + "/MyFiles/");
                        dir.mkdirs();
                        File file = new File(dir, System.currentTimeMillis() + ".jpg");
                        try {
                            outputStream = new FileOutputStream(file);
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                            outputStream.flush();
                            outputStream.close();
                            Toast.makeText(ProfileActivity.this, "Изображение успешно сохранено", Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(ProfileActivity.this, "При сохранение изображения возникла ошибка!", Toast.LENGTH_LONG).show();
                        }
                        GetImageProfile();
                    }
                }
            });

    public static final String getFullTime(final long timeInMillis)
    {
        final SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timeInMillis);
        c.setTimeZone(TimeZone.getDefault());
        return format.format(c.getTime());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textName = findViewById(R.id.textNameProfile);
        textName.setText(Onboarding.nickName);

        image = findViewById(R.id.avatar);
        new AdapterElement.DownloadImageTask((ImageView) image)
                .execute(Onboarding.avatar);

        GridView gvImage = findViewById(R.id.lvImageProfile);
        pAdapter = new AdapterImageFProfile(ProfileActivity.this, list);
        gvImage.setAdapter(pAdapter);
        GetImageProfile();

        gvImage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MaskImageFProfile mask = list.get(i);
                if (mask.getImageProfile() == null)
                {
                    addImage();
                } else {
                    maskImageFProfile = list.get(i);
                    startActivity(new Intent(ProfileActivity.this, PhotoActivity.class));
                }
            }
        });
    }

    private void GetImageProfile()
    {
        File dir = new File(getApplicationInfo().dataDir + "/MyFiles/");
        dir.mkdirs();
        list.clear();
        pAdapter.notifyDataSetInvalidated();
        String path = getApplicationInfo().dataDir + "/MyFiles";
        File directory = new File(path);
        File[] files = directory.listFiles();
        int j = 0;
        for (int i = 0; i < files.length; i++) {
            Long last = files[i].lastModified();
            MaskImageFProfile tempProduct = new MaskImageFProfile(
                    j,
                    files[i].getAbsolutePath(),
                    files[i],
                    getFullTime(last)
            );
            list.add(tempProduct);
            pAdapter.notifyDataSetInvalidated();
        }
        MaskImageFProfile tempProduct = new MaskImageFProfile(j,null,null, "null");
        list.add(tempProduct);
        pAdapter.notifyDataSetInvalidated();
    }

    public void goMenu(View view) {
        startActivity(new Intent(this, MenuActivity.class));
    }

    public void goHome(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void goListen(View view) {
        startActivity(new Intent(this, ListenActivity.class));
    }

    public void goLogin(View view) {
        SharedPreferences prefs = getSharedPreferences(
                "Date", Context.MODE_PRIVATE);
        prefs.edit().putString("Avatar", "").apply();
        prefs.edit().putString("NickName", "").apply();

        startActivity(new Intent(this, LoginActivity.class));
    }

    public void addImage()
    {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        someActivityResultLauncher.launch(photoPickerIntent);
    }
}