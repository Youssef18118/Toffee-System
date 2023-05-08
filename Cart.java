package Shopping;

import java.util.ArrayList;
public class Cart {
    private ArrayList <Item> items ;
    private float totalPrice;
    private int CartID;

    public int getCartID(){
        return CartID;
    }
    
    public float gettotalPrice(){
        return totalPrice;
    }

    public void addItem(Item Itemx){
        items.add(Itemx);
    }

    
    //should be solved after adding Quantity to DB
    // public void selectQuantitiy (int Quant){
    //     for (Item item : items) {
    //         item.getQuantitiy();
    //     }
    // }
}
