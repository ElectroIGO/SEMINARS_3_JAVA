package model.users;

import java.security.MessageDigest;

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
    public void setPassword(String inputPassword) {
        if(inputPassword != null && inputPassword.matches("[A-ZĒŪĪĻĶĢŠĀČŅ]{1}[a-zēūīļķģšāžčņ]")){
            try{
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(inputPassword.getBytes());
                this.password = new String(md.digest());
            } catch (Exception e){
                this.password = "admin123";
            }
        } else {
            this.password = "admin123";
        }

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
