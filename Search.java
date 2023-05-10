package Shopping;


import java.util.ArrayList;
import java.util.Formatter;
import Register_Login.Database;

public class Search {
    private ArrayList <Item> items ;
    private Database db = new Database();



    public void DisplayResult(ArrayList <Item> items){
        Formatter formatter = new Formatter();
        String line ;
        line = String.format("%53s", "").replace(" ", "-");
        System.out.println(line);
        formatter.format("|%-12s|%-12s|%12s|%12s|\n", "ID" ,"Name", "Brand", "Quantity");
        System.out.print(formatter.toString());
        System.out.print("|");
        line = String.format("%51s", "").replace(" ", "-");
        System.out.println(line+ "|");

        for (Item item : items) {
            formatter = new Formatter();
            formatter.format("|%-12s|%-12s|%12s|%12d|\n", item.getID() , item.getName(), item.getBrand(), item.getQuantity());
            System.out.print(formatter.toString());
        }
        line = String.format("%53s", "").replace(" ", "-");
        System.out.println(line);
    }


    //should work on items provided from DB
    public void Research(String query) {
        this.items = db.search(query);
        DisplayResult(items);
    }

    public void SelectItem(String id){
        boolean found = false;
        for(Item item:items){
            if(id.equals(item.getID())){
                item.viewItem();
                found = true;
            }
        }
        if(!found){
            System.out.println("invalid id , please try agian");
        }
    }



}
