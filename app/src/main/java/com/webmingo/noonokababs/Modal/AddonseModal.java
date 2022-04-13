package com.webmingo.noonokababs.Modal;

public class AddonseModal {


    String name, quentity, Description, Price, Image;

    public AddonseModal(String name, String quentity, String description, String price) {
        this.name = name;
        this.quentity = quentity;
        Description = description;
        Price = price;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuentity() {
        return quentity;
    }

    public void setQuentity(String quentity) {
        this.quentity = quentity;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
