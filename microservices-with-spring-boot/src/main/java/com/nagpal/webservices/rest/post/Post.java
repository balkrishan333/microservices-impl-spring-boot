package com.nagpal.webservices.rest.post;

import com.nagpal.webservices.rest.user.User;

import java.util.Date;

public class Post {

    private String title;
    private Date postedOn;
    private User user;

    public Post(String title, Date postedOn, User user) {
        this.title = title;
        this.postedOn = postedOn;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public Date getPostedOn() {
        return postedOn;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", postedOn=" + postedOn +
                ", user=" + user +
                '}';
    }
}
