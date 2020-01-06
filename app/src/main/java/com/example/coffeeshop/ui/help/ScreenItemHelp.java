package com.example.coffeeshop.ui.help;

public class ScreenItemHelp {
    String Title, Description;
    int ScreenImg;

    public ScreenItemHelp(String title, String description, int screenImg){
        Title = title;
        Description = description;
        ScreenImg = screenImg;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setScreenImg(int screenImg) {
        ScreenImg = screenImg;
    }

    public String getDescription() {
        return Description;
    }

    public int getScreenImg() {
        return ScreenImg;
    }
}
