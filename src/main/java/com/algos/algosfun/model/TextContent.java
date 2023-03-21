package com.algos.algosfun.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class TextContent extends Content{
    @Column(name="text",columnDefinition = "LONGTEXT")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TextContent(){
        this.setType(Constants.TEXT);
    }
    public TextContent(String text) {
        this.setType(Constants.TEXT);
        this.text = text;
    }
}
