package org.east.laugh.app.domain;

import java.sql.Timestamp;
import java.util.List;

public class User {
    Integer id;
    String email;
    String pwd;
    String name;
    String group;
    String info;

    Timestamp created_at;

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    private List<Blog> blogs;

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public User() {
    }

    public User(String email, String pwd, String name,String group) {
        this.email = email;
        this.pwd = pwd;
        this.name = name;
        this.group = group;
    }

    public User(Integer id, String email, String pwd, String name, String group, String info, Timestamp created_at, List<Blog> blogs) {
        this.id = id;
        this.email = email;
        this.pwd = pwd;
        this.name = name;
        this.group = group;
        this.info = info;
        this.created_at = created_at;
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", info='" + info + '\'' +
                ", created_at=" + created_at +
                ", blogs=" + blogs +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
