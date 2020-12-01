package com.codeup.blog;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String body;


    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(long ID, String title, String body) {
        this.id = ID;
        this.title = title;
        this.body = body;
    }

    public Post() {
    }


    //    public Post getPostByID(long id){
//
//    }
    public long getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setID(long ID) {
        this.id = ID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
