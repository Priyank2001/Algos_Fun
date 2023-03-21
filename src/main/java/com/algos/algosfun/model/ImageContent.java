package com.algos.algosfun.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class ImageContent extends Content{
    @Column(name="image_url")
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ImageContent() {
        this.setType(Constants.IMAGE);
    }

    public ImageContent(String imageUrl) {
        this.setType(Constants.IMAGE);
        this.imageUrl = imageUrl;
    }

}
