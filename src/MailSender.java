
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Mihir Kotecha
 */
public class MailSender {

    public static void Sender(String SenderAddress, String FilePath, String ReceiverAddress, String Password)
            throws AddressException {

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.TLS", "true");

        Session session;
        session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SenderAddress, Password);
            }

        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SenderAddress));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(ReceiverAddress));
            message.setSubject("ISP Project: Secure File Transfer");
            BodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setText("This a test mail.");

            BodyPart messageBodyPart2 = new MimeBodyPart();
            DataSource source = new FileDataSource(FilePath);
            messageBodyPart2.setDataHandler(new DataHandler(source));
            messageBodyPart2.setFileName(FilePath);

            Multipart multipartObject = new MimeMultipart();
            multipartObject.addBodyPart(messageBodyPart1);
            multipartObject.addBodyPart(messageBodyPart2);

            message.setContent(multipartObject);

            Transport.send(message);

        } catch (MessagingException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
