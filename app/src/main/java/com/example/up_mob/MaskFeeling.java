package com.example.up_mob;

public class MaskFeel {

    private int id;
    private String title;
    private String image;
    private int position;

    public MaskFeel(int id, String title, String image, int position) {
        this.id = id;
        this.title = title;
        this.position = position;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }


    public int getPosition() {
        return position;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
