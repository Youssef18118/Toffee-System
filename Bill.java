/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sw_ass3;

/**
 *
 * @author Boda_Tarek
 */
public class Bill {
    
    int orderNO = 0;
    float price;
    String address;
    String date;
    String deliveryMan;
    String deliveryManNO;

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
    
    
}
