package com.example.up_mob;

import java.io.File;

public class MaskImageFProfile {
    public int id;
    public String path;
    public File imageProfile;
    public String data;

    public MaskImageFProfile(int id, String path, File imageProfile, String data) {
        this.id = id;
        this.path = path;
        this.imageProfile = imageProfile;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public File getImageProfile() {
        return imageProfile;
    }


    public String getData() {
        return data;
    }

}
