package Shopping;
import TSystem.*;
import Users.loggedUser;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Search {
    private ArrayList<Item> items;
    private Database db = new Database();
    private Cart cart = new Cart();
    private loggedUser userX = new loggedUser();
    Scanner in = new Scanner(System.in);

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void DisplayResult(ArrayList<Item> items) {
        Formatter formatter = new Formatter();
        String line;
        line = String.format("%53s", "").replace(" ", "-");
        System.out.println(line);
        formatter.format("|%-12s|%-12s|%12s|%12s|\n", "ID", "Name", "Brand", "Quantity");
        System.out.print(formatter.toString());
        System.out.print("|");
        line = String.format("%51s", "").replace(" ", "-");
        System.out.println(line + "|");

        for (Item item : items) {
            formatter = new Formatter();
            formatter.format("|%-12s|%-12s|%12s|%12d|\n", item.getID(), item.getName(), item.getBrand(),
                    item.getQuantity());
            System.out.print(formatter.toString());
        }
        line = String.format("%53s", "").replace(" ", "-");
        System.out.println(line);
    }

    public void Research(String query) {
        this.items = db.search(query);
        DisplayResult(items);
    }

    public void SelectItem(String id, loggedUser userX) {
        setUserX(userX);
        boolean found = false;
        for (Item item : items) {
            if (id.equals(item.getID())) {
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
        if (!found) {
            System.out.println("Invalid ID, please try again");
        }
    }

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

}
