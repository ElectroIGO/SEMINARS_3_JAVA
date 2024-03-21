package model;

import java.util.ArrayList;

import model.users.User;

public class Page {
    //1. variable
    private String title;
    private String description;
    private ArrayList<User> followers = new ArrayList<User>();
    private ArrayList<Post> publicPost = new ArrayList<Post>();
    private ArrayList<Post> privatePost = new ArrayList<Post>();
    //2. get and set
    public void setTitle(String title) {
        if(title != null && title.matches("[A-Za-z0-9]{5,20}"))
            this.title = title;
        else
            this.title = "-----";
    }
    public void setDescription(String description) {
        if(description != null && description.length() > 10 && description.length() < 256)
            this.description = description;
        else
            this.description = "-----";
    }
    public String getDescription() {
        return description;
    }
    public String getTitle() {
        return title;
    }
    public ArrayList<User> getFollowers() {
        return followers;
    }
    public ArrayList<Post> getPrivatePage() {
        return privatePage;
    }
    public ArrayList<Post> getPublicPage() {
        return publicPage;
    }
    //3. constructors
    public Page(){
        setTitle("Test page");
        setDescription("Test test test");
    }
    public Page(String title, String description){
        setTitle(title);
        setDescription(description);
    }
    //4. toString
    public String toString(){
        return title + " (" + description + "): [" + privatePost.size() + publicPost.size() + "]";
    }
    //5 other functions
}
