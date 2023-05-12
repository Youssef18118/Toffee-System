package TSystem;

import Register_Login.Register;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.ArrayList;

import Shopping.Item;
import Users.loggedUser;


public class Database {

    private ArrayList<Item> All_items = new ArrayList<>();
    private loggedUser userX = new loggedUser();


    private boolean checkFileExists(File file) {
        return file.exists() && file.isFile();
    }

    private void write_in_file(Register reg) {
        File file = new File("UserData.txt");
        if (checkFileExists(file)) {
            try {
                FileWriter writer = new FileWriter(file, true);
                writer.write(reg.getUsername() + " " + reg.getEmail() + " " + reg.getPhone() + " " + reg.getAddress() + " " + reg.getPass() + " " + reg.getLoyalty() + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Error writing to file.");
            }
        } else {
            System.out.println("cannot open file");
        }
    }

    public boolean FindUser(String username) {
        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader("UserData.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(" ");
                if (fields.length >= 6 && fields[0].equals(username)) {
                    found = true;
                    int f5 =Integer.parseInt(fields[5]);  
                    setUserX(1,fields[0],fields[1],fields[2],fields[3],fields[4],f5);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error searching file: " + e.getMessage());
        }
        return found;
    }

    public void SaveData(Register reg) {
        write_in_file(reg);
    }

    public void load_items() {
        try (BufferedReader br = new BufferedReader(new FileReader("Items.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String itemName = parts[0];
                String id = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                double price = Double.parseDouble(parts[3]);
                int discountPercentage = Integer.parseInt(parts[4]);
                String brand = parts[5];
                String category = parts[6];
                String description = "";
                for (int i = 7; i < parts.length; i++) {
                    description = description + parts[i] + " ";
                }
                Item item = new Item(itemName, id, quantity, price, discountPercentage, brand, category, description);
                All_items.add(item);
            }
        } catch (IOException e) {
            System.out.println("Error searching file: " + e.getMessage());
        }
    }

    public ArrayList<Item> search(String query) {
        ArrayList<Item> result = new ArrayList<Item>();
        load_items();
        for (Item item : All_items) {
            if (item.getName().equalsIgnoreCase(query) || item.getBrand().equalsIgnoreCase(query)) {
                result.add(item);
            }
        }
        return result;
    }

    public void add_to_Category(Map<String, ArrayList<Item>> CategoryMap) {
        load_items();
        for (Item item : All_items) {
            if (CategoryMap.containsKey(item.getCategory())) {
                CategoryMap.get(item.getCategory()).add(item);
            } else {
                ArrayList<Item> integerList = new ArrayList<>();
                integerList.add(item);
                CategoryMap.put(item.getCategory(), integerList);
            }

        }
    }
    
    public void setUserX(int id,String userName,String email,String phone,String address,String pass,int loy) {
        this.userX.setID(id);
        this.userX.setUserName(userName);
        this.userX.setEmail(email);
        this.userX.setPhoneNO(phone);
        this.userX.setAddress(address);
        this.userX.setPassword(pass);
        this.userX.getLoyalityPoints().setPoints(loy);
        
    }

    public loggedUser getUserX() {
        return userX;
    }
}
