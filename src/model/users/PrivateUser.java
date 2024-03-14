package model.users;

import java.util.ArrayList;
import model.Post;
import model.PostType;

public class PrivateUser extends User {

    //1. variable
    private ArrayList<Post> privatePost = new ArrayList<Post>();
    private ArrayList<Post> publicPost = new ArrayList<Post>();
    private ArrayList<User> followers = new ArrayList<User>();
    //2. get and set
    public ArrayList<Post> getPrivatePosts(){
        return privatePost;
    }
    public ArrayList<Post> getPublicPost(){
        return publicPost;
    }
    public ArrayList<User> getFollowers(){
        return followers;
    }
    //3. constructors
    public PrivateUser(){
        super();
        setNameAndSurnameOrTitle("Jānis Bērziņs");
        SetUserName();
    }
    public PrivateUser(String name, String surname, String password){
        super(password);
        setNameAndSurnameOrTitle(name + " " + surname);
        SetUserName();
    }
    //4. toString
    public String toString(){
        return super.toString() + "[" + (privatePost.size() + publicPost.size()) + "posts]";
    }
    //5 other functions
    @Override
    public void publishPost(String title, String msg, PostType type) throws Exception {
        if(title == null || msg == null || type == null)
            throw new Exception("Problems with input params");
        Post newPost = new Post(title, msg);
        if(type.equals(PostType.privatePost))
            privatePost.add(newPost);
        else
            publicPost.add(newPost);
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'publishPost'");
    }

    @Override
    public void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle) {
        if(nameAndSurnameOrTitle != null && nameAndSurnameOrTitle.matches("[A-ZĒŪĪĻĶĢŠĀČŅ]{1}[a-zēūīļķģšāžčņ]+ [A-ZĒŪĪĻĶĢŠĀČŅ]{1}[a-zēūīļķģšāžčņ]+")){
            super.nameAndSurnameOrTitle = nameAndSurnameOrTitle;
        } else {
            super.nameAndSurnameOrTitle = "ERROR 404";
        }
    }

}
