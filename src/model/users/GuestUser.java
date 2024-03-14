package model.users;

public class GuestUser {
    private int userID;
    private static int counter = 0;

    public void setUserID(){
        this.userID = counter++;
    }
    public int getUserID(){
        return this.userID;
    }

    public GuestUser() {
        setUserID();
    }
    public String toString(){
        return "" + userID;
    }
}

    