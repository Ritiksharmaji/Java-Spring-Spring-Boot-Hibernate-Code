package com.apringboot.api.springbootapi.entities;

public class normal {

    private int id;
    private String name;
    private String imageUrl;
    public int getId() {
        return id;
    }
    
    public normal(int id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }
    

    public normal() {
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    

}
