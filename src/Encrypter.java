import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
/**
 *
 * @author Mihir Kotecha
 */
public class Encrypter {

    public static void encrypter(String key, String path) {
        int a = 0;
        int b = 0;

        for (int i = 0; i < key.length(); i++) {
            a = a + (int) key.charAt(i);
            b = b + 1;
        }
        int priKey = (int) Math.ceil(a / b);
        String Data = "";
        String encryptedData = "";

        try {
            try ( FileReader fr = new FileReader(path)) {
                for (int i = 0; i < key.length(); i++) {
                    Data += key.charAt(i);
                }

                Data += " ";
                int i;
                while ((i = fr.read()) != -1) {
                    Data += (char) i;
                }
            }

        } catch (IOException e) {
            System.out.println("File read error.");
        }

        for (int i = 0; i < Data.length(); i++) {
            encryptedData += (char) ((int) Data.charAt(i) + priKey % 26);
        }
        System.out.println(encryptedData);
        try {
            try ( FileWriter fw = new FileWriter("D:\\ISP Project\\Encrytedfile.txt")) {
                fw.write(encryptedData);
            }
        } catch (IOException e) {
            System.out.println("File write error.");
        }
    }
}
