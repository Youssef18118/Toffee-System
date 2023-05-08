package Register_Login;

/**
 *
 * @author Aya_Ashraf
 */


public class Login {

    public void login(String username , String pass){
       Checker check = new Checker();
       if(check.identical(username , pass)){
           System.out.println("Successfully login , hello " + username);
       }
       else{
           System.out.println("invalid username or password");
       }
    }


}
