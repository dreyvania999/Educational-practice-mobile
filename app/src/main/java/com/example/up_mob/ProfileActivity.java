package com.example.up_mob;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
//https://stackoverflow.com/questions/8664440/how-to-copy-image-file-from-gallery-to-another-folder-programmatically-in-androi
    //https://www.google.com/search?q=how+copy+image+from+gallery+to+program+android+studio&rlz=1C1GCEA_enRU1047RU1047&biw=1920&bih=969&sxsrf=AJOqlzXVic10khtO0ldr8UyMSZZVxQsljg%3A1678096945983&ei=MboFZMfdO4iNrwTLqZPwDQ&oq=how+copy+image+from+galary+to+progra&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAxgAMgcIIRCgARAKMgcIIRCgARAKMgYIIRAVEAoyCgghEBYQHhAdEAoyCgghEBYQHhAdEAo6CggAEEcQ1gQQsAM6BQgAEIAEOgwIABANEIAEEEYQ_wE6BwgAEA0QgAQ6BwguEA0QgAQ6BggAEBYQHjoECCMQJzoKCAAQgAQQFBCHAjoICAAQgAQQsQM6BQguEIAEOg8IABCABBAUEIcCEEYQ_wE6EQgAEA0QgAQQFBCHAhBGEP8BOgwIABANEIAEEBQQhwI6CAgAEBYQHhAPOgcIABCABBANOggIABAIEB4QDToICAAQFhAeEAo6BwgAEIAEEBM6BQghEKABOggIIRAWEB4QHToLCCEQFhAeEPEEEB06CgghEBYQHhAPEB06BAghEBVKBAhBGABQ2ClYtpICYJ-tAmgYcAF4AIABbYgB-xySAQQ1MS4ymAEAoAEByAEIwAEB&sclient=gws-wiz-serp&safe=active&ssui=on
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