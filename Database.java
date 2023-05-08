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


}
