package org.east.laugh.app.domain;


import java.sql.Timestamp;

public class Blog {
    private Integer id;
    private String title;
    private int uid;
    private String content;
    private Timestamp created_at;
    private String tags;

    public Blog() {
    }

    public Blog(Integer id, String title, int uid, String content, Timestamp created_at, String tags) {
        this.id = id;
        this.title = title;
        this.uid = uid;
        this.content = content;
        this.created_at = created_at;
        this.tags = tags;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
