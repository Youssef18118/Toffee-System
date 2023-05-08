/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sw_ass3;
import java.util.ArrayList; 

/**
 *
 * @author Boda_Tarek
 */
public class Payment {
    String address;
    Payment method;
    float finalPrice;
    float totalPrice;
    int vouPrice;
    int loyPoints;
    Voucher vouchCode;
    LoyalityPoint LoyaltyPoints;
    Cart cart;

    
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

    public void setTotalPrice(Item Items) {
       //here will add for loop to calc all items price
    } 

    public int getVouPrice() {
        return vouPrice;
    }

    public void setVouPrice(String code) {
        if(code == vouchCode.getCode()){
            this.vouPrice = vouchCode.price;
        }
    }

    public int getLoyPoints() {
        return loyPoints;
    }

    public void setLoyPoints(int loyPoints) {
        if(loyPoints <= LoyaltyPoints.points){
            this.loyPoints = loyPoints;
        }   
    }
    
    public void updatePoints(int points){
        LoyaltyPoints.points += points;
    }
    
    public float getFinalPrice() {
        return finalPrice;
    }
    
    public void setFinalPrice() {
        this.finalPrice = totalPrice - ( vouPrice + (loyPoints * LoyaltyPoints.priceOfPoints ) );
    }
}
