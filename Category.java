package Shopping;
import TSystem.*;
import Users.loggedUser;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Category {
    private ArrayList <String> Catg = new ArrayList<>() ;
    private Database db = new Database() ;
    private int ID;
    private String Name;
    // CategoryName : ID of items
    Map<String, ArrayList<Item>> CategoryMap = new HashMap<>();
    Scanner in = new Scanner(System.in);
    private Cart cart = new Cart();
    private loggedUser userX = new loggedUser();

    
    
    
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }



    
    
    
    

    public String getCategoryName(){
        return Name;
    }
    public int getCategoryID(){
        return ID;
    }


    public void setCategoryMap(){
        db.add_to_Category(CategoryMap);
        for (Map.Entry<String, ArrayList<Item>> entry : CategoryMap.entrySet()) {
            String key = entry.getKey();
            Catg.add(key);
        }
        for(int i=0 ; i<Catg.size() ;i++){
            System.out.println(i+1 + "- "+ Catg.get(i));
        }

    }

    public void selectCategory(int index){
        Search search = new Search();
        if (CategoryMap.containsKey(Catg.get(index-1))) {
            ArrayList<Item> list = CategoryMap.get(Catg.get(index-1));
            search.DisplayResult(list);
        }
    }

    public void selectItem(int idxOfCatg ,String id){
        boolean found = false;
        ArrayList<Item> list = CategoryMap.get(Catg.get(idxOfCatg-1));
        for(Item item:list){
            if(id.equals(item.getID())){
                item.viewItem();
                found = true;
                System.out.println("Do you want to add this item to the cart? 1 -> Yes, 2 -> No");
                int response = in.nextInt();
                if (response == 1) {
            
                    cart.addToCart(userX, item);
                    cart.ViewCart(userX);
                } else {
                    break;
                }
            }
        }
        if(!found){
            System.out.println("invalid id , please try agian");
        }

    }





}
