package com.webmingo.oldjerusalemrestaurant.Modal;

public class HomeModal {


private     String name;
private Integer BackgroundImage;
private Integer Icon;

    public HomeModal(String name, Integer icon, Integer backgroundImage) {
        this.name = name;
        BackgroundImage = backgroundImage;
        Icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBackgroundImage() {
        return BackgroundImage;
    }

    public void setBackgroundImage(Integer backgroundImage) {
        BackgroundImage = backgroundImage;
    }

    public Integer getIcon() {
        return Icon;
    }

    public void setIcon(Integer icon) {
        Icon = icon;
    }
}
