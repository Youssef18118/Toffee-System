/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import payment.*;

/**
 *
 * @author Boda_Tarek
 */
public class loggedUser extends user {
    private String email;
    private String phoneNO;
    private String address;
    private String userName;
    private String password;
    private LoyalityPoint LoyalityPoints;


    public String getEmail() {
        return email;
    }

    public void setEmail(String name) {
        this.email = email;
    }

    public String getPhoneNO() {
        return phoneNO;
    }

    public void setPhoneNO(String phoneNO) {
        this.phoneNO = phoneNO;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoyalityPoint getLoyalityPoints() {
        return LoyalityPoints;
    }

    public void setLoyalityPoints(LoyalityPoint LoyalityPoints) {
        this.LoyalityPoints = LoyalityPoints;
    }
    
    
    
    
}
