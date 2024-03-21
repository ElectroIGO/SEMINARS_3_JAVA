import model.PostType;
import model.users.GuestUser;
import model.users.PrivateUser;

public class App {
    public static void main(String[] args) throws Exception {
        GuestUser test_test = new GuestUser();
        GuestUser test_test2 = new GuestUser();
        GuestUser test_test3 = new GuestUser();
        System.out.println(test_test + ", " + test_test2 + ", " + test_test3);
        PrivateUser Rodrigo_Laurinovics = new PrivateUser("Rodrigo", "Laurinovics", "GANGSTA");
        System.out.println(Rodrigo_Laurinovics);
        try{
            Rodrigo_Laurinovics.publishPost("Daugavas zaglis", "Aiznesa ar rokām", PostType.publicPost);
            Rodrigo_Laurinovics.publishPost("Mužiks ar ūsām", "Dinazaurs Rūdis izdur cauri ozolam", PostType.privatePost);
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println(Rodrigo_Laurinovics);
        System.out.println(Rodrigo_Laurinovics.getPublicPost());
        System.out.println(Rodrigo_Laurinovics.getPrivatePosts());
    }
}
