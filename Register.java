package Register_Login;

/**
 *
 * @author Aya_Ashraf
 */


public class Register {
    private String username;
    private String phone;
    private String OTP;
    private String address;
    private String pass;
    private String email;
    private Database db = new Database();



    private void check_ascii(int ascii_before, int ascii_after)
    {
        if (Character.isUpperCase(ascii_after)){
            //if it exceeds Z it returns to A
            if (ascii_after > 90)
                ascii_after = 64 + (ascii_after - 90);

            //if it is lower than A, it continues from Z
            //at shifting in the left direction
            if (ascii_after < 65) {
                ascii_after = 91 - (65 - ascii_after);
            }
        }
        if (Character.isLowerCase(ascii_before))
        {
            //if it exceeds z it returns to a
            if (ascii_after > 122)
                ascii_after = 96 + (ascii_after - 122);

            //if it is lower than a, it continues from z
            //at shifting in the left direction
            if (ascii_after < 97)
                ascii_after = 123 - (97 - ascii_after);
        }
    }

    private String Encryption(String password) {
        String encrypted = "";
        for (char ch : password.toCharArray()) {
            // 2 shifts forward to encrypt
            int ascii_after = (int)ch + 2;
            check_ascii((int)ch, ascii_after);
            ch = (char)ascii_after;
            encrypted += ch;
        }
        password = encrypted;
        return password;
    }



    // getters
    public String getUsername() {
        return username;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
    public String getPass() {
        return pass;
    }
    public String getEmail() {
        return email;
    }


    //setters
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    public void register(String name , String phone , String email, String address  , String pass , String Cpass){
        Checker check = new Checker();
        int valid = 0;

        //check phone
        if(!check.checkPhone(phone)){
            System.out.println("invalid phone");
        }
        else{
            valid++;
        }

        //check email
        if(!check.checkEmail(email)){
            System.out.println("invalid email");
        }
        else{
            valid++;
        }


        //check password
        if(!check.checkPass(pass)){
            System.out.println("invalid password");
        }
        else{
            valid++;
        }

        //check Cpassword
        if(!check.checkCpass(pass , Cpass)){
            System.out.println("The password and confirm password do not match");
        }
        else{
            valid++;
        }
        if(valid == 4){
            setUsername(name);
            setPhone(phone);
            setAddress(address);
            setEmail(email);
            setPass(Encryption(pass));

            //save data in database

            db.SaveData(this);
            System.out.println("Successfully Registered , welcome " + name);
        }

    }

    public void SetOTP(){

    }
    public void EnterOTP(String response){

    }
    public void get_OTP(){

    }

}
