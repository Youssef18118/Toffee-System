package Shopping;


public class Item {
    private double price;
    private String ID;
    private String Description;
    private String Name;
    private String Brand;
    private int DiscountPercent;       // string ----> int
    private Category Category;
    private int quantity;             // add this line
    private Cart Cartobj;


    public Item(String itemName, String id, int quantity, double price, int discountPercentage, String brand, String category, String description){
        this.Name = itemName;
        this.ID = id;
        this.quantity = quantity;
        this.price = price;
        this.DiscountPercent = discountPercentage;
        this.Brand = brand;
        // this.Category = category                difference types
        this.Description = description;
    }

    public double getPrice(){
        return price;
    }

    public String getID() {
        return ID;
    }

    public String getDescription() {
        return Description;
    }

    public String getName() {
        return Name;
    }

    public String getBrand() {
        return Brand;
    }

    public int getDiscountPercent() {
        return DiscountPercent;
    }

    public int getQuantity() {
        return quantity;
    }
    //Database should provide items
    // public int getQuantitiy(){
    //     return ID;
    // }


    public void addItemToCard(Item Itemx){
        Cartobj.addItem(Itemx);
    }

    public void viewItem(Item Itemx){
        System.out.println("Name: " + Name + "ID: " + ID + " price: " + price + "Brand: " + Brand + "Category: " );

    }

//
//    public void AddToCategory(String name, int ID){
//        Categry.setCategoryName(name, ID);
//    }



}
