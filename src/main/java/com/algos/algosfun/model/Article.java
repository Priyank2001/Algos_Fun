package com.algos.algosfun.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name="articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="heading")
    private String heading;

    @Column(name="updated_on")
    private Date updatedOn;
    @ManyToMany
    @JoinTable(name = "article_contents",joinColumns = @JoinColumn(name = "article_id") , inverseJoinColumns = @JoinColumn(name = "content_id"))
    private ArrayList<Content> contentList;

    public Article() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Content> getContentList() {
        return contentList;
    }

    public void setContentList(ArrayList<Content> contentList) {
        this.contentList = contentList;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Article(String heading, Date updatedOn, ArrayList<Content> contentList) {
        this.heading = heading;
        this.updatedOn = updatedOn;
        this.contentList = contentList;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public void addContentList(Content content){
        this.contentList.add(content);
    }
    public void clearContentList(){
        this.contentList.clear();
    }
}
