package Shopping;


public class Item {
    private int price;
    private int ID;
    private String Description;
    private String Name;
    private String Brand;
    private String DiscountPercent;
    private Category Categry;
    private Cart Cartobj;


    public int getPrice(){
        return price;
    }

    public int getProductID(){
        return ID;
    }
    
    //Database should provide items
    // public int getQuantitiy(){
    //     return ID;
    // }


    public void addItemToCard(Item Itemx){
        Cartobj.addItem(Itemx);    
    }    
    
    public void viewItem(Item Itemx){
       System.out.println("Name: " + Name + "ID: " + ID + " price: " + price + "Brand: " + Brand + "Category: " + Categry.getCategoryName() );
            
    }    


    public void AddToCategory(String name, int ID){
        Categry.setCategoryName(name, ID);
    }


    
}
