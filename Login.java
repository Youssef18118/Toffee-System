package Register_Login;
import Users.*;
import TSystem.*;

public class Login {
    private loggedUser userX = new loggedUser();
    private Database db = new Database();
    
    public boolean login(String username, String pass) {
        Checker check = new Checker();
        if (check.identical(username, pass)) {
            System.out.println("Successfully logged in. Hello, " + username);
            setUserX(check.getUserX());
            return true;
        } else {
            System.out.println("Invalid username or password");
            return false;
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
    
    public loggedUser getUserX() {
        return userX;
    }
}
