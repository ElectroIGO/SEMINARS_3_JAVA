package model.users;

import service.IPostService;

public abstract class User extends GuestUser implements IPostService {
    //1. variable
    private String username;
    protected String nameAndSurnameOrTitle;
    // PASSWORD SHOULD BE ENCODED BY SHA-256
    private String password;
    //2 get and set
    public String getUserName(){
        return username;
    }
    public void SetUserName(){
        this.username = super.getUserID() + "_" + nameAndSurnameOrTitle.substring(0, 5).trim();
    }
    public String getNameAndSurnameOrTitle(){
        return nameAndSurnameOrTitle;
    }
    public abstract void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle);

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    //3. constructors
    public User() {
        super(); //manto no mātes
        setPassword("12345678");
    }

    public User(String password) {
        super(); //manto no mātes
        setPassword(password);
    }

    //4. toString
    public String toString(){
        return "Registered User ->" + super.toString() + ": " + nameAndSurnameOrTitle + "(" + username + ")";
    }
    //5. other functions

}
