package Register_Login;
import Users.*;

/**
 *
 * @author Aya_Ashraf
 */


public class Login {
    private loggedUser userX = new loggedUser();
    private Database db = new Database();
    
    public void login(String username , String pass){
       Checker check = new Checker();
       if(check.identical(username , pass)){
           System.out.println("Successfully login , hello " + username);
           userX.setUserName(username);
           userX.setPassword(pass);
           userX.setAddress(db.FindAddress(username));
           userX.setEmail(db.FindEmail(username));
           userX.setPhoneNO(db.FindPhone(username));
       }
       else{
           System.out.println("invalid username or password");
       }
    }


}
