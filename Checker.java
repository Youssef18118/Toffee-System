package TSystem;

import TSystem.Database;

public class Checker {
    private boolean available;
    private Database db = new Database();

    private void check_ascii(int ascii_before, int ascii_after) {
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

    private String Decryption(String password) {
        String decrypted = "";
        for (char ch : password.toCharArray()) {
            // 2 shifts backward to decrypt
            int ascii_after = (int)ch - 2;
            check_ascii((int)ch, ascii_after);
            ch = (char)ascii_after;
            decrypted += ch;
        }
        password = decrypted;
        return password;
    }

    public boolean identical(String username , String password){
        if(db.FindUser(username)){
            String savedPass = db.getUserX().getPassword();
            if(Decryption(savedPass).equals(password)){
                return true;
            }
        }
        return false;
    }


    public boolean checkUsername(String name){
        if(db.FindUser(name)){
            return false;
        }
        return true;
    }

    public boolean checkEmail(String email){
        String validEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(validEmail);
    }


    public boolean checkPass(String password) {
        if (password.length() < 8) {
            return false;
        }
        // Check if the password contains at least one uppercase letter
        boolean hasUpperCase = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                hasUpperCase = true;
                break;
            }
        }
        if (!hasUpperCase) {
            return false;
        }
        // Check if the password contains at least one lowercase letter
        boolean hasLowerCase = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                hasLowerCase = true;
                break;
            }
        }
        if (!hasLowerCase) {
            return false;
        }
        // Check if the password contains at least one digit
        boolean hasDigit = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                hasDigit = true;
                break;
            }
        }
        if (!hasDigit) {
            return false;
        }
        return true;
    }


    public boolean checkCpass(String pass , String Cpass){
        if(checkPass(pass)){
            if(pass.equals(Cpass)){
                return true;
            }
            return false;
        }
        return false;
    }


    public boolean checkPhone(String phone){
        String validPhone = "^01[0125][0-9]{8}$";
        return phone.matches(validPhone);
    }

    
    public boolean checkAvailabe(){
        // here we must check on available
        return false;
    }
    
    public boolean checkOTP(String responseOTP,String OTP){
        return (responseOTP == null ? OTP == null : responseOTP.equals(OTP));
    }
}
