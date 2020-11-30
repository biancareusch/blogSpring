package com.codeup.blog;

public class Post {
    private String title;
    private String body;
    private long ID;

    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }
    public Post(long ID, String title, String body){
        this.ID = ID;
        this.title = title;
        this.body = body;
    }

//    public Post getPostByID(long id){
//
//    }
    public long getID() {
        return ID;
    }
    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
