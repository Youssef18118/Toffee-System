package Shopping;


public class Item {
    private double price;
    private String ID;
    private String Description;
    private String Name;
    private String Brand;
    private int DiscountPercent;
    private String Category;
    private int quantity;
    private Cart Cartobj;


    public Item(String itemName, String id, int quantity, double price, int discountPercentage, String brand, String category, String description){
        this.Name = itemName;
        this.ID = id;
        this.quantity = quantity;
        this.price = price;
        this.DiscountPercent = discountPercentage;
        this.Brand = brand;
        this.Category = category;
        this.Description = description;
    }

    public String getCategory() {
        return Category;
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


//     public void addItemToCard(Item Itemx){
//         Cartobj.addItem(Itemx);
//     }

    public void viewItem(){
        System.out.println("ID: "+this.getID() + "\nName: " +this.getName() +"\nQuantity: "+this.getQuantity() +"\nPrice: "+ this.getPrice() +"\nDiscount percentage: "+this.getDiscountPercent()+"%\nBrand: " +this.getBrand() + "\nDescription : " +this.getDescription());

    }

}
