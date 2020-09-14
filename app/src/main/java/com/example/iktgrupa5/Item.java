package com.example.iktgrupa5;

public class Item {
    private String imageUrl;
    private String creator;
    private int likes;
    public Item(String image, String creator, int likes){
        imageUrl=image;
        this.creator=creator;
        this.likes=likes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getLikes() {
        return likes;
    }


}
