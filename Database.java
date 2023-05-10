package Register_Login;


/**
 *
 * @author Aya_Ashraf
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import Shopping.Item;

public class Database {

    private boolean checkFileExists( File file) {
        return file.exists() && file.isFile();
    }


    private void write_in_file(Register reg){
        File file = new File("UserData.txt");
        if(checkFileExists(file)) {
            try {
                FileWriter writer = new FileWriter(file , true);
                writer.write(reg.getUsername() + " " + reg.getEmail() + " " + reg.getPhone() + " " + reg.getAddress()+" " + reg.getPass()+"\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Error writing to file.");
            }
        }
        else{
            System.out.println("cannot open file");
        }
    }


    public boolean FindUser(String username){
        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader("UserData.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(" ");
                if (fields.length >= 5 && fields[0].equals(username)) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error searching file: " + e.getMessage());
        }
        return found;
    }


    public String FindPass(String username){
        String password = "";
        try (BufferedReader br = new BufferedReader(new FileReader("UserData.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(" ");
                if (fields.length >= 5 && fields[0].equals(username)) {
                    password = fields[4];
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error searching file: " + e.getMessage());
        }
        return password;
    }
    public void SaveData(Register reg){
        write_in_file(reg);
    }


    public int getQuantity(String itemName){
        int quantity = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("Items.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(" ");
                if (fields.length >= 8 && fields[0].equals(itemName)) {
                    quantity = Integer.parseInt(fields[2]);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error searching file: " + e.getMessage());
        }
        return quantity;
    }


    public ArrayList<Item> search(String query){
        ArrayList<Item> result = new ArrayList<Item>();
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
                for(int i = 7 ; i<parts.length ; i++){
                   description = description+parts[i]+" ";
                }


                if (itemName.equalsIgnoreCase(query) || brand.equalsIgnoreCase(query)) {
                    Item item = new Item(itemName, id, quantity, price, discountPercentage, brand, category,description);
                    result.add(item);
                }
            }
        } catch (IOException e) {
            System.out.println("Error searching file: " + e.getMessage());
        }
        return result;
    }


}
