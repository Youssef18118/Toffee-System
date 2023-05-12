
package payment;
import Users.*;

public class deliveryCash {
    private String phoneNO;
private loggedUser userX = new loggedUser();

    public String getPhoneNO() {
        return phoneNO;
    }

    public void setPhoneNO(String phoneNO) {
        this.phoneNO = userX.getPhoneNO();
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
