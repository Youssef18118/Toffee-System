package Shopping;

<<<<<<< HEAD
import Users.loggedUser;
import Users.user;

=======
import Users.*;

import java.util.ArrayList;
>>>>>>> 34bbfbcb1dc5ea552c50666e2fbd9f441589ec7a
import java.util.HashMap;
import java.util.Map;
import java.util.Formatter;

public class Cart {
    private float totalPrice;
    private int CartID;
<<<<<<< HEAD
    public Map<Item, Integer> CartMap = new HashMap<>();
    private loggedUser userX = new loggedUser();
=======
    public Map<Item , Integer> CartMap = new HashMap<>();

>>>>>>> 34bbfbcb1dc5ea552c50666e2fbd9f441589ec7a

    public loggedUser getUserX() {
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

    public int getCartID() {
        return CartID;
    }

<<<<<<< HEAD
    public float gettotalPrice() {
        return totalPrice;
    }

    public void addToCart(loggedUser userx, Item Itemx) {
        setUserX(userx);
        CartMap.put(Itemx, 1);
    }

    public void ViewCart(user userx) {
        if (userx instanceof loggedUser) {
            for (Map.Entry<Item, Integer> entry : CartMap.entrySet()) {
                Formatter formatter = new Formatter();
                formatter.format("|%-12s|%-12s|%-12d|\n", entry.getKey().getID(), entry.getKey().getName(),
                        entry.getValue());
=======
    public float gettotalPrice(){
        return totalPrice;
    }
    
   
    public void addItem(user userx ,Item Itemx){
        if(userx instanceof loggedUser){
            CartMap.put(Itemx , 0);
        }
        else{
            System.out.println("Sorry , you must login first");
        }
    }

    public void ViewCart(user userx){
        if(userx instanceof loggedUser){
            for (Map.Entry<Item, Integer> entry : CartMap.entrySet()) {
                Formatter formatter = new Formatter();
                formatter.format("|%-12s|%-12s|%-12d|\n", entry.getKey().getID() , entry.getKey().getName() , entry.getValue());
>>>>>>> 34bbfbcb1dc5ea552c50666e2fbd9f441589ec7a
                System.out.print(formatter.toString());
            }
            String line = String.format("%53s", "").replace(" ", "-");
            System.out.println(line);
<<<<<<< HEAD
        } else {
            System.out.println("Sorry, you must login first");
        }
    }

    public void selectQuantity(String ID, int Quant) {
        boolean found = false;
        for (Map.Entry<Item, Integer> entry : CartMap.entrySet()) {
            if (ID.equals(entry.getKey().getID())) {
                if ((Quant > entry.getKey().getQuantity()) || (Quant > 50)) {
                    System.out.println("You exceeded the maximum number of items, please try again");
                } else {
                    entry.setValue(Quant);
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Invalid ID, please try again");
        }
    }
    
    public boolean checkUser(loggedUser userx){
        if(userx.getUserName()!=""){
            return true;
        }else
           return false;
    }
=======
        }
        else{
            System.out.println("Sorry , you must login first");
        }
    }




     public void selectQuantitiy (String ID ,int Quant){
         boolean found = false;
         for (Map.Entry<Item, Integer> entry : CartMap.entrySet()){
             if(ID.equals(entry.getKey().getID())){
                 if((Quant > entry.getKey().getQuantity()) || (Quant > 50)){
                     System.out.println("you exceeded the maximum number of items , please try again");
                 }
                 else{
                     entry.setValue(Quant);
                 }
             }
         }
         if(!found){
             System.out.println("invalid id , please try agian");
         }
     }
>>>>>>> 34bbfbcb1dc5ea552c50666e2fbd9f441589ec7a
}

