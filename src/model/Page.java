package model;

import java.util.ArrayList;

import model.users.User;

public class Page {
    //1. variable
    private String title;
    private String description;
    private ArrayList<User> followers = new ArrayList<User>();
    private ArrayList<Post> postsInPage = new ArrayList<Post>();
    //2. get and set
    public String getDescription() {
        return description;
    }
    public String getTitle() {
        return title;
    }
    //3. constructors
    //4. toString
    //5 other functions
}
