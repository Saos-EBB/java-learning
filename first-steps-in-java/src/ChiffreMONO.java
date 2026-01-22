import java.util.Random;
import java.util.Scanner;

public class ChiffreMONO {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Gib mir was zu Verschlüsseln");

        // key  ist immer 11 bei 0
        Random randy = new Random(0);
        // int key = randy.nextInt(25) + 1;
        int key = 1;

        String Input = normalize();
        System.out.println("Bereinigter Input : " + Input);

        String encrypted = encrypt(Input, key);
        System.out.println("Verschlüsselter Input : " + encrypted);

        String decrypted = decrypt(encrypted, key);
        System.out.println("Entschlüsselter Input : " + decrypted);
    }

    //1. Eingabe bereinigen
    static String normalize() {
        Scanner scan = new Scanner(System.in);

        String Input = scan.next().toUpperCase();

        //Umlaute mit replace ausstauschen <3
        Input = Input

                .replace("Ä", "AE")
                .replace("Ö", "OE")
                .replace("Ü", "UE")
                .replace("ß", "SS");

        String cleanInput = "";
        // Sonderzeichen entfernen </3
        char[] normalArr = Input.toCharArray();

        for (int i = 0; i < normalArr.length; i++) {
            if (normalArr[i] >= 'A' && normalArr[i] <= 'Z') {
                cleanInput += normalArr[i];  // Strings addieren , Hall = Hall + "o"   == Hallo . magie
            }
        }
        //Rückgabe bereinigter Input
        return cleanInput;
    }

    //2. Verschlüsseln
    static String encrypt(String xxx, int key) {

        String encrypted = "";

        char[] toEncrypt = xxx.toCharArray();

        for (int i = 0; i < toEncrypt.length; i++) {
            int temp = toEncrypt[i];
            temp = temp + key;

            if (temp > 'Z') {
                temp = temp - 26;
            }
            char add = (char) temp;
            encrypted += add;
        }
        return encrypted;
    }

    //3. Entschlüsseln
    static String decrypt(String encrypted, int key) {
        String decrypted = "";
        char[] toDecrypt = encrypted.toCharArray();

        for (int i = 0; i < toDecrypt.length; i++) {
            int temp = toDecrypt[i];
            temp = temp - key;

            if (temp < 'A') {
                temp = temp + 26;
            }
            char add = (char) temp;
            decrypted += add;
        }
        decrypted = decrypted
                .replace("AE", "Ä")
                .replace("OE", "Ö")
                .replace("UE", "Ü")
                .replace("SS", "ß");

        return decrypted;
    }

}//classEnte

                /*┌─┐┌─┐┌─┐┌─┐
                  └─┐├─┤│ │└─┐
                  └─┘┴ ┴│ │└─┘..43
                        └─┘*/

