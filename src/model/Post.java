package model;

import java.time.LocalDateTime;

public class Post {
    private String title;
    private String msg;
    private LocalDateTime dateTime = LocalDateTime.now();
    private int countOfLikes = 0;

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        if(title != null && title.length() > 5){
            this.title = title;
        } else {
            this.title = "Guest";
        }
    }

    public void setMSG(String msg){
        if(msg.length() > 5 && msg.length()< 1000){
            this.msg = msg;
        } else {
            this.msg = "ERROR";
        }
    }

    public String getMsg(){
        return msg;
    }

    public int getCountOfLikes(){
        return countOfLikes;
    }

    // TODO CAN CHANGE
    public void incrementCountOfLikes(){
        this.countOfLikes++;
    }

    public LocalDateTime getdDateTime(){
        return dateTime;
    }
    //3. constructors

    /**
     * Usuless
     */
    public Post(){
        setTitle("Test title");
        setMSG("Test description");
    }

    public Post(String title, String msg){
        setTitle(title);
        setMSG(msg);
    }
    //4. to string
    public String toString(){
        return title + "(" + dateTime + ")" + msg + "\n" + countOfLikes + "\n";
    }
}
