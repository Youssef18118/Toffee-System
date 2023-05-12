package Shopping;

import Users.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Formatter;

public class Cart {
    private float totalPrice;
    private int CartID;
    public Map<Item , Integer> CartMap = new HashMap<>();


    public int getCartID(){
        return CartID;
    }

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
                System.out.print(formatter.toString());
            }
            String line = String.format("%53s", "").replace(" ", "-");
            System.out.println(line);
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
}

