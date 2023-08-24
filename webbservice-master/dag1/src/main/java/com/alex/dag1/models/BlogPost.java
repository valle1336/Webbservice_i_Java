package com.alex.dag1.models;

public class BlogPost {

    private int userId;

    private int id;

    private String title;

    private String body;

    public int getUserID() {
        return userId;
    }

    public void setUserID(int userID) {
        this.userId = userID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
