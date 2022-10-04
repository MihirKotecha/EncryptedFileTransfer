import java.util.Scanner;
import java.lang.*;
import java.io.File;

public class project {
    public void Encrypter(String key) {
        
    }    

    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String key;
        System.out.println("Enter the key: ");
        key = scn.nextLine();

        int a = 0;
        int b = 0;

        for (int i = 0; i < key.length(); i++) {
            a = a + (int) key.charAt(i);
            b = b + 1;
        }
        int priKey = (int) Math.ceil(a / b);
        String message;
        System.out.println("Enter the message: ");
        message = scn.nextLine();
        String ciper = "";
        for (int i = 0; i < message.length(); i++) {
            ciper += (char) ((int) message.charAt(i) + (priKey) % 26);
        }
        System.out.println("Enter the ciper: "+ciper);
    }
}