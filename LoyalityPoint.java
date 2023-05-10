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

public class LoyalityPoint {
    private int points;
    private int id;
    private int priceOfPoints;
    private String EXP;
    private float calculatePoints;
    private loggedUser userX;
    
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    public void updatePoints(int points){
        this.points += points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriceOfPoints() {
        return priceOfPoints;
    }

    public void setPriceOfPoints(int priceOfPoints) {
        this.priceOfPoints = priceOfPoints;
    }

    public String getEXP() {
        return EXP;
    }

    public void setEXP(String EXP) {
        this.EXP = EXP;
    }

    public float getCalculatePoints() {
        return calculatePoints;
    }

    public void setCalculatePoints() {
        calculatePoints = points * priceOfPoints;
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
