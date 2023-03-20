package com.example.up_mob;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterImageFProfile extends BaseAdapter {
    private final Context mContext;
    List<MaskImageFProfile> maskList;

    public AdapterImageFProfile(Context mContext, List<MaskImageFProfile> maskList) {
        this.mContext = mContext;
        this.maskList = maskList;
    }

    @Override
    public int getCount() {
        return maskList.size();
    }

    @Override
    public Object getItem(int i) {
        return maskList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return maskList.get(i).getId();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MaskImageFProfile maskImageFProfile = maskList.get(position);
        View v = null;
        if (maskImageFProfile.getImageProfile() == null) // Если картинка не указана, то это последний элемент
        {
            v = View.inflate(mContext, R.layout.new_image, null); // Выводится форма с кнопкой
        } else {
            v = View.inflate(mContext, R.layout.image_in_profile, null); // Вывод стандартной формы

            ImageView Image = v.findViewById(R.id.image);
            TextView dateCreat = v.findViewById(R.id.dateCreat);

            if (maskImageFProfile.getImageProfile().exists()) {
                Bitmap myBitmap = BitmapFactory.decodeFile(maskImageFProfile.getImageProfile().getAbsolutePath());
                Image.setImageBitmap(myBitmap);
            }
            dateCreat.setText(maskImageFProfile.getData());
        }
        return v;
    }
}
