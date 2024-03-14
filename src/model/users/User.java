package model.users;

public abstract class User extends GuestUser {
    //1. variable
    private String username;
    private String nameAndSurnameOrTitle;
    // PASSWORD SHOULD BE ENCODED BY SHA-256
    private String password;
    //2 get and set
    public String getUserName(){
        return username;
    }
    public void SetUserName(){
        this.username = super.getUserID() + "_" + nameAndSurnameOrTitle.substring(0, 5);
    }
    public String getNameAndSurnameOrTitle(){
        return nameAndSurnameOrTitle;
    }
    public abstract  String setNameAndSurnameOrTitle(String nameAndSurnameOrTitle);

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
