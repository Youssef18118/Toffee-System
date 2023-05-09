package Shopping;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Category {
    private ArrayList <Category> Catg ;
    private int ID;    
    private String Name;

    // CategoryName : ID of items
    Map<String, ArrayList<Integer>> CategoryMap = new HashMap<>();


    public String getCategoryName(){
        return Name;
    }
    public int getCategoryID(){
        return ID;
    }

    public void setCategoryName(String Name, int ItemID){
        for (Category category : Catg) {
            if(category.Name == Name){
                //if found in list of Category, put it in the map
                CategoryMap.get(Name).add(ItemID);    
            }else{
                //if not found in list of Category, add it and put it in the map
                Catg.add(category);
                CategoryMap.put(Name, new ArrayList<>(List.of(ItemID)));   
            }
        }

        
        this.Name = Name;
    }





}
