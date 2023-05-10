/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payment;
import Users.*;

/**
 *
 * @author Boda_Tarek
 */
public class Bill {
    
    private int orderNO = 0;
    private float price;
    private String address;
    private String date;
    private String deliveryMan;
    private String deliveryManNO;
    private loggedUser userX = new loggedUser();
    

    public Bill(){
        orderNO++;
    }
    
    public int getOrdeNO() {
        return orderNO;
    }

    public void setOrderNO(int orderNO) {
        if(orderNO > 0){
            this.orderNO = orderNO;
        }else{
            System.out.println("No Order Can be less than 1...");
        }
      
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if(price > 0){
            this.price = price;
        }else{
            System.out.println("No Price Can be less than 0...");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(String deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public String getDeliveryManNO() {
        return deliveryManNO;
    }

    public void setDeliveryManNO(String deliveryManNO) {
        this.deliveryManNO = deliveryManNO;
    }

    public user getUserX() {
        return userX;
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
