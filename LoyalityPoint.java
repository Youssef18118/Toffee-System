/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sw_ass3;

/**
 *
 * @author Boda_Tarek
 */

public class LoyalityPoint {
    int points;
    int id;
    int priceOfPoints;
    String EXP;
    float calculatePoints;

    
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
    
}
