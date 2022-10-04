
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mihir Kotecha
 */
public class decrypter {
     public static boolean Decrypter(String key,String Path) {
        try {
            FileReader fre = new FileReader(Path);
            Scanner sn = new Scanner(fre);
            String Word = sn.next();
            String FirstWord = "";

            int a = 0;
            int b = 0;

            for (int i = 0; i < key.length(); i++) {
                a = a + (int) key.charAt(i);
                b = b + 1;
            }
            int priKey = (int) Math.ceil(a / b);

            for (int i = 0; i < Word.length(); i++) {
                FirstWord += (char) ((int) Word.charAt(i) - priKey % 26);
            }

            if (FirstWord.substring(0, key.length()).equals(key)) {
                
                
                a = 0;
                b = 0;

                String Dataone = "";
                String DecryptedData = "";

                try {
                    try (FileReader fr = new FileReader("D:\\ISP Project\\Encrytedfile.txt")) {
                        int i;
                        
                        while ((i = fr.read()) != -1) {
                            Dataone += (char) i;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("File reader error.");
                }
                for (int i = 0; i < Dataone.length(); i++) {
                    DecryptedData += (char) ((int) Dataone.charAt(i) - priKey % 26);
                }
                
                String FinalData = DecryptedData.replaceAll(key,"");

                try {
                    try (FileWriter fw = new FileWriter("D:\\ISP Project\\DecryptedFile.txt")) {
                        fw.write(FinalData);
                    }
                } catch (IOException e) {
                    System.out.println("File Write error.");
                }
                return true;
            }

            else {
                System.out.println("Wrong Key.");
                return false;
            }
        } catch (FileNotFoundException e) {
        }
         return false;
        
         
    }
}
