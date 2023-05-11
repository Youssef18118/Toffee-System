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
           setUserX(db.getUserX());
       }
       else{
           System.out.println("invalid username or password");
       }
    }

    public void setUserX(loggedUser userX) {
        this.userX.setID(userX.getID());
        this.userX.setAddress(userX.getAddress());
        this.userX.setEmail(userX.getEmail());
        this.userX.setUserName(userX.getUserName());
        this.userX.setPassword(userX.getPassword());
        this.userX.setLoyalityPoints(userX.getLoyalityPoints());
        this.userX.setPhoneNO(userX.getPhoneNO());
    }
}
