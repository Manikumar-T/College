import java.util.*;

import javax.crypto.*;
import javax.crypto.spec.*;

public class AES {
    //banner to print the information
    public static void printbanner() {
        System.out.println("'"
        + "*******************************************************\n" +
"     IT1681 - Cryptography and  Networks Security Laboratory\n" +
"\n" +
"	Roll Number : 20UIT020\n" +
"	Name        :T.MANIKUMAR\n" +
"	Ex. No.	    : 08\n" +
"	Ex. Name    : Apply AES algorithm for practical Application	\n" +
"*******************************************************\n");
    }
    public static  void  encryptDecrypt(String text) throws Exception {

        byte[]textbyte = text.getBytes();
        //Generating Key
        KeyGenerator Mygenerator = KeyGenerator.getInstance("AES");
        SecretKey AESKey = Mygenerator.generateKey();
        //initializing crypto algorithm
        Cipher myCipher = Cipher.getInstance("AES");
        //setting encryption mode
        myCipher.init(Cipher.ENCRYPT_MODE, AESKey);
        byte[] myEncryptedBytes=myCipher.doFinal(textbyte);
        System.out.println("Cipher Text: "+ new String(myEncryptedBytes));

        //setting decryption mode
        myCipher.init(Cipher.DECRYPT_MODE, AESKey);
        byte[] myDecryptedBytes=myCipher.doFinal(myEncryptedBytes);
        System.out.println("Decrypted Text: "+ new String(myDecryptedBytes));
    }

    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        printbanner();
        System.out.println("Enter the Aadhar Numner: ");
        String number = sc.next();
        if(number.length()==16)
            encryptDecrypt(number);
        else    
            System.out.println("Invalid Aadhar Numner");
    }   
}
