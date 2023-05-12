
package payment;
import java.util.List;
import Shopping.*;
import Users.*;

public class Payment {
    private String address;
    private Payment method;
    private float finalPrice;
    private float totalPrice;
    private int vouPrice;
    private int loyPoints;
    private Voucher vouchCode;
    private LoyalityPoint LoyaltyPoints;
    private Cart cart = new Cart();
    private loggedUser userX = new loggedUser();
    
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Payment getMethod() {
        return method;
    }

    public void setMethod(Payment method) {
        this.method = method;
    }
    
    public float getTotalPrice() {
        return totalPrice;
    }

   public void setTotalPrice(List<Item> itemList) {
        for (Item item : itemList) {
            totalPrice += item.getPrice();
        }
    } 
    public int getVouPrice() {
        return vouPrice;
    }

    public void setVouPrice(String code) {
        if(code == vouchCode.getCode()){
            this.vouPrice = vouchCode.getPrice();
        }
    }

    public int getLoyPoints() {
        return loyPoints;
    }

    public void setLoyPoints(int loyPoints) {
        if(loyPoints <= LoyaltyPoints.getPoints()){
            this.loyPoints = loyPoints;
        }   
    }
    
    public void updatePoints(int points){
        LoyaltyPoints.updatePoints(points);
    }
    
    public float getFinalPrice() {
        return finalPrice;
    }
    
    public void setFinalPrice() {
        this.finalPrice = totalPrice - ( vouPrice + (loyPoints * LoyaltyPoints.getPriceOfPoints() ) );
    }
    
    //public boolean checkUser(user userx){
    //    if(userx instanceof loggedUser){
    //        return true;
    //    }else
    //        return false;
    //}
    
    public boolean checkUser(loggedUser userx){
        if(userx.getUserName()!=""){
            return true;
        }else
           return false;
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
