package model.users;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.PostType;

public class BusinessUser extends User {
    //1. variable
    private String VATNo; //Lv90000362426
    private ArrayList<Page> allUserPages = new ArrayList<Page>();
   //2. get and set
   @Override
   public void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle) {
    if(nameAndSurnameOrTitle  != null && nameAndSurnameOrTitle.matches("[A-ZĒŪĪĻĶĢŠĀČŅa-zēūīļķģšāžčņ0-9.,:'@&%+= ]{2,40}"))
        super.nameAndSurnameOrTitle = nameAndSurnameOrTitle;
    else
        super.nameAndSurnameOrTitle = "-----";
       throw new UnsupportedOperationException("Unimplemented method 'setNameAndSurnameOrTitle'");
   }
   public void setVATNo(String vATNo) {
        if(vATNo != null && vATNo.matches("[A-Z]{2}[0-9]{11}]"))
            VATNo = vATNo;
        else
            VATNo = "------------";
   }
   public String getVATNo() {
       return VATNo;
   }
    //3. constructors
    public BusinessUser(){
        super(); // tiek izskaukts mātes konstruktors.
        setNameAndSurnameOrTitle("SIA Rodrigo");
        SetUserName();
        setVATNo("LV90000362426");
    }
    public BusinessUser(String title, String password, String VATNo){
        super(password);
        setNameAndSurnameOrTitle(title);
        setVATNo(VATNo);
    }
    //4. toString
    public String toString(){
        return super.toString() + " " + VATNo;
    }
    //5 other functions

    public void addPage(String title, String description) throws Exception{
        for(Page tempP: allUserPages){
            if(tempP.getTitle().toLowerCase().equals(title.toLowerCase())){
                throw new Exception("Page already exists");
            }
        }
        Page newPage = new Page(title, description);
        allUserPages.add(newPage);
    }

    public void publishPostInPage(String postTitle, String msg, PostType type) throws Exception{
        for(Page tempP: allUserPages){
            if(tempP.getTitle().toLowerCase().equals(postTitle.toLowerCase())){
                Post newPost = publishPost(postTitle, msg, type);
                if(type.equals(PostType.privatePost))
                    tempP.getPrivatePage().add(newPost);
                else
                    tempP.getPublicPage().add(newPost);
                return;
            }
        }
        throw new Exception("Page not found!");
    }

    @Override
    public Post publishPost(String title, String msg, PostType type) throws Exception {
        Post newPost = new Post(title, msg);
        return newPost; 
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'publishPost'");
    }

    
   
}
