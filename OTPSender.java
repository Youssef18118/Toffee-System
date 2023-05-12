package TSystem;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class OTPSender {
    
    private static String OTP;

    public String getOTP() {
        return OTP;
    }
    
    
    
    public OTPSender(){
        // Generate a random 6-digit OTP
        Random rand = new Random();
        int randomNo = rand.nextInt(900000) + 100000; // range: 100000 - 999999
        OTPSender.OTP =  String.valueOf(randomNo);
    }

    public static void sendOTP(String email) {
        
        // Email properties
        String host = "smtp.gmail.com";
        String username = "toptoffeeshop@gmail.com"; // emailak
        String password = "aamptfnwixnknceg"; // passwordak
        int port = 587;

        // Sender's and recipient's email addresses
        String from = "toptoffeeshop@gmail.com"; // emailak
        String to = email;

        // Email message
        String subject = "One-Time Password (OTP)";
        String body = "Your OTP is: " + OTP;

        // Setup email session and properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Authenticate sender's email
        Session session;
        session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            // Create email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            // Send email message
            Transport.send(message);

            System.out.println("OTP sent to " + email);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}