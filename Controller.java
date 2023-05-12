/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TSystem;
import Register_Login.Login;
import Register_Login.Register;
import Shopping.Category;
import Shopping.Search;
import Users.loggedUser;
import java.util.*;



/**
 *
 * @author Boda_Tarek
 */
public class Controller {
    
    Register reg = new Register();
    OTPSender otp = new OTPSender();
    Checker check = new Checker();
    String username ,phone  ,address , pass , Cpass,email,OTP;
    Scanner in = new Scanner(System.in);
    Login log = new Login();
    private loggedUser userX = new loggedUser();

    
    
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
    
    

    
    public void register(){
        System.out.println("please Enter your Data");
        System.out.print("Username : ");
        username = in.next();

        System.out.print("Phone : ");
        phone = in.next();

        System.out.print("Email : ");
        email = in.next();
        otp.sendOTP(email);

        System.out.print("Ener the OTP whice send in your email : ");
        OTP = in.next();

        while(!check.checkOTP(otp.getOTP(),OTP)){
            System.out.println("The OTP is Wrong Write another Email or 'q' for Exit ---> " + otp.getOTP() + " ----->" + OTP );
            System.out.print("Email : ");
            email = in.next();
            System.out.print("Ener the OTP whice send in your email : ");
            OTP = in.next();
            if(email == "q" || OTP == "q"){
                System.exit(0);
            }
            else{
                otp.sendOTP(email);
            }
        }

        System.out.print("Address : ");
        address = in.next();

        System.out.println("Password must at least 8 character and contain uppercase , lowercase , digits");
        System.out.print("Password : ");
        pass = in.next();

        System.out.print("Confirm Password : ");
        Cpass = in.next();


        while(!check.checkOTP(otp.getOTP(),OTP)){
            System.out.println("The OTP is Wrong Write another Email or 'q' for Exit" );
            System.out.print("Email : ");
            email = in.next();
            
            if(email == "q"){
                System.exit(0);
            }
            
            else{
                otp.sendOTP(email);
                System.out.print("Ener the OTP whice send in your email : ");
                OTP = in.next();
            }
        }

        reg.register(username, phone, email, address, pass, Cpass);
    }
    
    public void login() {
        System.out.print("Username: ");
        username = in.next();
        System.out.print("Password: ");
        pass = in.next();
        boolean loginStatus = log.login(username, pass);
        if (loginStatus) {
            setUserX(log.getUserX());
        } else {
            setUserX(null);
        }
    }

    
    
    public boolean search(){
        String query;
        System.out.print("Enter item name or brand : ");
        Search search = new Search();
        query = in.next();
        search.Research(query);
        System.out.println("if you want to select specific item ,please enter its ID otherwise enter 0");
        String num = in.next();
        if (num == "0") {
            return false;
        } else {
            search.SelectItem(num, getUserX());
        }
        return true;
    }
    
    public boolean viewAllCatigories(){
        int num ;
        Search search = new Search();
        System.out.println("ALL Catygories....");
        Category catg = new Category();
        catg.setCategoryMap();
        System.out.println("if you want to select specific category , please enter the number that corresponding to it otherwise enter 0");
        num = in.nextInt();
        if(num == 0){
           return false;
        }
        else{
            catg.selectCategory(num);
            System.out.println("if you want to select specific item ,please enter its ID otherwise enter 0");
            String id = in.next();
            if(id == "0"){
                return false;
            }
            else{
                catg.selectItem(num , id);
            }
        }
        return true;
    }
}
