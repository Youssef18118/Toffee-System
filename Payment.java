/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payment;
import java.util.ArrayList; 
import java.util.List;
import Shopping.Cart;
import Shopping.Item;




/**
 *
 * @author Boda_Tarek
 */
public class Payment {
    private String address;
    private Payment method;
    private float finalPrice;
    private float totalPrice;
    private int vouPrice;
    private int loyPoints;
    private Voucher vouchCode;
    private LoyalityPoint LoyaltyPoints;
    Cart cart = new Cart();
    
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
}
